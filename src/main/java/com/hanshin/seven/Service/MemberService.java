package com.hanshin.seven.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanshin.seven.Controller.MainController;
import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Repository.MemberDao;
import com.hanshin.seven.Util.EncryptUtils;

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
	
	public List<Member> selectMember (Member member) {
		return memberDao.selectMember(member);
	}
	
	// 1 성공
	// 0 실패
	public int login(Member member) {
		try {
			member.setPwd(EncryptUtils.encrypt(member.getPwd()) );
		}catch(Exception e) {
			logger.debug("exception in login() ...");
		}
		List<Member> selectedMemberList = memberDao.selectMember(member);
		
		if(selectedMemberList.size() == 1) {
			return 1;
		}else {
			return 0;
		}
	}
	
}
