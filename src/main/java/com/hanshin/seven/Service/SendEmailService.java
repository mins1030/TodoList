package com.hanshin.seven.Service;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.hanshin.seven.Controller.MainController;
import com.hanshin.seven.Domain.MailDto;
import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Repository.MemberDao;
import com.hanshin.seven.Util.EncryptUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SendEmailService {
   
   @Autowired
   private static final Logger logger = LoggerFactory.getLogger(MainController.class);
   
   @Autowired
   MemberDao memberDao;
   
   @Autowired
   private JavaMailSender mailSender;
   private static final String FROM_ADDRESS = "lyjcooo01@gmail.com"; // 보내는 사람 이메일 주소
   
   public String changePassword(String name, String email) {
      String result;
      String str = getTempPassword(); // 임시 비밀번호 획득
      MailDto dto = new MailDto();
      
      dto.setAddress(email);
      dto.setTitle("OTM 시스템 임시 비밀번호 안내");
      dto.setMessage("[" + name + "] 님의 임시 비밀번호는 [" + str + "] 입니다.\n"
            + "임시 비밀번호로 로그인 후 내 정보에서 비밀번호를 수정하세요.");
      
      logger.debug("getTempPassword : " + str);
      
      mailSend(dto);
      result = updatePassword(str, email);

      return result;
   }
   
   private String updatePassword(String str, String email) {
       String result = "1";
       try {
         String encryptedPassword = EncryptUtils.encrypt(str);
         
         Member m = new Member();
         m.setEmail(email);
         Member memberInfo = memberDao.selectMember(m).get(0);
         memberInfo.setPwd(encryptedPassword);
         
         memberDao.updateMember(memberInfo);
         
      } catch (Exception e) {
         e.printStackTrace();
         logger.debug("exeception[updatePassword] ...");
         result = "-1";
      }
       
       return result;
   }
   
   // 10자리의 랜덤 난수를 생성하여 임시 비밀번호 구성
   private String getTempPassword() {
      char[] charSet = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
      };
      
      String str = "";
      
      int idx = 0;
      for(int i = 0; i < 10; i++) {
         idx = (int)(charSet.length * Math.random());
         str += charSet[idx];
      }
      
      return str;
   }
   
   private void mailSend(MailDto mailDto) {
//      Properties props = ((Object) mailSender).getJavaMailProperties();
//      props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
//      JavaMailSender mailSender = new JavaMailSenderImpl();
      SimpleMailMessage message = new SimpleMailMessage();
      logger.debug("mailDto[mailSend] : " + mailDto);
      try {
         message.setTo(mailDto.getAddress());
         message.setFrom(SendEmailService.FROM_ADDRESS);
         message.setSubject(mailDto.getTitle());
         message.setText(mailDto.getMessage());
         
         logger.debug("message[mailSend] : " + message);
         
         mailSender.send(message);
      }catch(Exception e){
         logger.info(e.toString());
      }
   }
}