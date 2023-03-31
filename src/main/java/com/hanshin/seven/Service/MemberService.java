package com.hanshin.seven.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanshin.seven.Controller.MainController;
import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Repository.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MemberDao memberDao;
	
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}
	
	
}
