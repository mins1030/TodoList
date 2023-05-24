package com.hanshin.seven.Service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanshin.seven.Controller.MainController;
import com.hanshin.seven.Domain.Cal;
import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Domain.Todo;
import com.hanshin.seven.Repository.CalDao;
import com.hanshin.seven.Repository.MemberDao;
import com.hanshin.seven.Repository.TodoDao;

import jakarta.servlet.http.HttpSession;

@Service
public class CalService {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	CalDao calDao;
	
	@Autowired
	MemberDao memberDao;
	
	public List<Cal> selectCal (HttpSession session) {
		String seniorEmail = (String)(session.getAttribute("otm_email"));
		Member m = new Member();
		m.setEmail(seniorEmail);
		
		Member seniorMember = memberDao.selectMember(m).get(0);
		Cal cl = new Cal();
		try {
			cl.setMemId(seniorMember.getEmpNum());
		}catch(Exception e) {
			logger.debug("exception in selectCal() ...");
		}
		return calDao.selectCal(cl);
	}
	
	public int insertCal(HttpSession session, Cal cal){
		String seniorEmail = (String)(session.getAttribute("otm_email"));
		Member m = new Member();
		m.setEmail(seniorEmail);
		
		Member seniorMember = memberDao.selectMember(m).get(0);
		String id = UUID.randomUUID().toString(); 
		
		try {
			cal.setCalId("1");
			cal.setMemId(seniorMember.getEmpNum());
			cal.setId(id);
			cal.setDueDateClass("");
			cal.setCategory("time");
		}catch(Exception e) {
			logger.debug("exception in insertCal() ...");
		}
		
		return calDao.insertCal(cal);
	}
	public int updateCal(HttpSession session, Cal cal){
		
		
		return calDao.updateCal(cal);
	}
	
	public int deleteCal(HttpSession session, Cal cal){
		
		
		return calDao.deleteCal(cal);
	}
	
}
