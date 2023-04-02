package com.hanshin.seven.Controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		memberService.insertMember(member);
			
		return "index";
	}
	
	
	@PostMapping("/login")
	@ResponseBody
	public Map<String, Object> login(Member member) {
		int serviceResult = memberService.login(member);
		Map<String, Object> result = new HashMap<String, Object>();

		// login 성긍 -> 1
		// login 실패 -> 0
		logger.debug("[controller Login]serviceResult : " + serviceResult);
		result.put("loginServiceResult", serviceResult);

		return result;

	}
}
