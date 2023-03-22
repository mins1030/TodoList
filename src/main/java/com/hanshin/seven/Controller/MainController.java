package com.hanshin.seven.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/loginPage")
	public String toLoginPage() {
		return "loginPage";
	}
	
	@PostMapping("login")
	public String login() {
		
		return "index";
	}
}
