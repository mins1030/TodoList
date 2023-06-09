package com.hanshin.seven.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Domain.Todo;
import com.hanshin.seven.Service.MemberService;
import com.hanshin.seven.Service.SendEmailService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	SendEmailService sendEmailService;

	@PostMapping("/signUp")
	public String signUp(Member member) {		
		memberService.insertMember(member);
			
		return "index";
	}
	
	
	@PostMapping("/login")
	@ResponseBody
	public Map<String, Object> login(HttpSession session, @RequestBody Member member) {
		logger.debug("[controller Login]requestMember : " + member);
		int serviceResult = memberService.login(session, member);
		Map<String, Object> result = new HashMap<String, Object>();

		// login 성긍 -> 1
		// login 실패 -> 0
		logger.debug("[controller Login]serviceResult : " + serviceResult);
		result.put("loginServiceResult", serviceResult);

		return result;

	}
	
	@GetMapping("/logout")
//	public Map<String, Object> logout(HttpSession session) {
//	public RedirectView logout(HttpSession session) {
	public String logout(HttpSession session) {
		int serviceResult = memberService.logout(session);
		Map<String, Object> result = new HashMap<String, Object>();

		// logout 성긍 -> 1
		// logout 실패 -> 0
		logger.debug("[controller Logout]serviceResult : " + serviceResult);
		result.put("logoutServiceResult", serviceResult);

//		return "index";
		return "redirect:/index";
//		return new RedirectView("index");

	}
	
	@PostMapping("/findId")
	@ResponseBody
	public Map<String, Object> findId(@RequestBody Member member) {
		logger.debug("find-id controller ...");
		logger.debug("Member[selectMember in controller] : " + member);
		String serviceResult = memberService.findId(member);
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("serviceResult", serviceResult);
		
		return result;
	}
	
	@PostMapping("/findPwd")
	@ResponseBody
	public Map<String, Object> findPwd(@RequestBody Member member) {
	    logger.debug("find-pwd controller ...");
	    logger.debug("Member[selectMember in controller] : " + member);
//	    String serviceResult = memberService.findPwd(member);
	    String serviceResult = sendEmailService.changePassword(member.getName(), member.getEmail());
	    Map<String, Object> result = new HashMap<String, Object>();
	      
	    result.put("serviceResult", serviceResult);
	      
	    return result;
	}
	@PostMapping("/profile")
	@ResponseBody
	public Map<String, Object> profile(HttpSession session) {		
		 List<Member> serviceResult = memberService.profile(session);
		 
		 Map<String, Object> result = new HashMap<String, Object>();
		 
		 result.put("profileServiceResult", serviceResult);
		return result;
	}
	/*
	 * @PostMapping("/profile")
	 * 
	 * @ResponseBody public Map<String, Object> profile(@RequestBody Member member)
	 * { logger.debug("profile controller ...");
	 * logger.debug("Member[selectMember in controller] : " + member); String
	 * serviceResult = memberService.profile(member); Map<String, Object> result =
	 * new HashMap<String, Object>();
	 * 
	 * result.put("serviceResult", serviceResult);
	 * 
	 * return result; }
	 */
	   
	@PostMapping("/changeInfo")
	public String changeInfo(Member member) {      
		memberService.changeInfo(member);
	         
		return "profile";
	}
}
