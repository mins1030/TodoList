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

import com.hanshin.seven.Domain.Cal;
import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Domain.Todo;
import com.hanshin.seven.Service.CalService;
import com.hanshin.seven.Service.MemberService;
import com.hanshin.seven.Service.TodoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CalController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	CalService calService;

	@PostMapping("/calendarList")
	@ResponseBody
	public Map<String, Object> calendar(HttpSession session) {		
		 List<Cal> serviceResult = calService.selectCal(session);
		 
		 Map<String, Object> result = new HashMap<String, Object>();
		 
		 result.put("calListServiceResult", serviceResult);
		return result;
	}
	
	
}
