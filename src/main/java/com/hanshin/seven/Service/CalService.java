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
	
	public int insertCal(HttpSession session, Cal cal){
		try {
		}catch(Exception e) {
			logger.debug("exception in insertCal() ...");
		}
		
		return calDao.insertCal(cal);
	}
	
	public int deleteCal(HttpSession session, Cal cal){
		/*
		 * try {
		 * 
		 * }catch(Exception e) { logger.debug("exception in deleteTodo() ..."); }
		 */
		
		return calDao.deleteCal(cal);
	}
	
}
