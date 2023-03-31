package com.hanshin.seven.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MemberService memberService;

	@PostMapping("/signUp")
	public String signUp(Member member) {
		logger.debug("signUp[controller]");
		logger.debug("signUp[Member] : " + member);
		
		memberService.insertMember(member);
		
		
		
		
		return "index";
	}
}
