package com.hanshin.seven.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanshin.seven.Controller.MainController;
import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Repository.MemberDao;
import com.hanshin.seven.Util.EncryptUtils;

import jakarta.servlet.http.HttpSession;

@Service
public class MemberService {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MemberDao memberDao;
	
	
	public int insertMember(Member member){
		try {
			member.setPwd(EncryptUtils.encrypt(member.getPwd()) );
		}catch(Exception e) {
			logger.debug("exception in insertMember() ...");
		}
		
		return memberDao.insertMember(member);
	}
	public int updateMember(Member member){
		try {
			member.setPwd(EncryptUtils.encrypt(member.getPwd()) );
		}catch(Exception e) {
			logger.debug("exception in updateMember() ...");
		}
		
		return memberDao.updateMember(member);
	}
	
	public List<Member> selectMember (Member member) {
		return memberDao.selectMember(member);
	}
	
	// 1 성공
	// 0 실패
	public int login(HttpSession session, Member member) {
		try {
			member.setPwd(EncryptUtils.encrypt(member.getPwd()) );
			logger.debug("[MemberService login] : " + member);
		}catch(Exception e) {
			logger.debug("exception in login() ...");
		}
		List<Member> selectedMemberList = memberDao.selectMember(member);
		
		if(selectedMemberList.size() == 1) {
			session.setAttribute("otm_email", selectedMemberList.get(0).getEmail());
			return 1;
		}else {
			return 0;
		}
	}
	
	public int logout(HttpSession session) {
		session.removeAttribute("otm_email");
		System.out.println("After removal: " + session.getAttribute("otm_email"));
		return 1;
	}
	// 1 성공
	// 0 실패
	public String findId(Member member) {
		
		List<Member> selectedMemberList = memberDao.selectMember(member);
		
		if(selectedMemberList.size() == 1) {
			return selectedMemberList.get(0).getEmail();
		}else {
			return "0";
		}
	}
	
	public String findPwd(Member member) {
		
		List<Member> selectedMemberList = memberDao.selectMember(member);
		
		if(selectedMemberList.size() == 1) {
			return selectedMemberList.get(0).getPwd();
		}else {
			return "0";
		}
	}
	public List<Member> profile(HttpSession session) {
		  String email = (String)session.getAttribute("otm_email");
		  Member member = new Member();
		  
		  member.setEmail(email);
		  
	      List<Member> selectedMemberList = memberDao.selectMember(member);
	     
	      return selectedMemberList;
	   }
	   
	   public int changeInfo(Member member){
	      try {
	         member.setPwd(EncryptUtils.encrypt(member.getPwd()) );
	      }catch(Exception e) {
	         logger.debug("exception in insertMember() ...");
	      }
	      
	      return memberDao.updateMember(member);
	   }
}
