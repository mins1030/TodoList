package com.hanshin.seven.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/")
	public String index() {
		logger.debug("index controller ...");
		return "index";
	}
	
	@RequestMapping("/test")
	public String test() {
		logger.debug("test controller ...");
		return "test";
	}
	
	@RequestMapping("/charts-chartjs")
	public String chartsChartjs() {
		logger.debug("charts-chartjs controller ...");
		return "charts-chartjs";
	}
	
	public String iconsFeather() {
		logger.debug("icons-feather controller ...");
		return "icons-feather";
	}
	
	public String mapsGoogle() {
		logger.debug("maps-google controller ...");
		return "maps-google";
	}
	
	public String pageBlank() {
		logger.debug("pages-blank controller ...");
		return "pages-blank";
	}

	@GetMapping("/pages-profile")
	public String pagesProfile() {
		logger.debug("pages-profile controller ...");
		return "pages-profile";
	}
	
	public String pagesSignIn() {
		logger.debug("pages-sign-in controller ...");
		return "pages-sign-in";
	}
	
	public String pagesSignUp() {
		logger.debug("pages-sign-up controller ...");
		return "pages-sign-up";
	}
	
	public String uiButtons() {
		logger.debug("ui-buttons controller ...");
		return "ui-buttons";
	}
	
	public String uiCards() {
		logger.debug("ui-cards controller ...");
		return "ui-cards";
	}
	
	public String uiForms() {
		logger.debug("ui-forms controller ...");
		return "ui-forms";
	}
	
	public String uiTypography() {
		logger.debug("ui-typography controller ...");
		return "ui-typography";
	}
	
	public String upgradeToPro() {
		logger.debug("upgrade-to-pro controller ...");
		return "upgrade-to-pro";
	}
//	
//	@RequestMapping("/loginPage")
//	public String toLoginPage() {
//		return "loginPage";
//	}
//	
//	@PostMapping("login")
//	public String login() {
//		
//		return "index";
//	}

//	  작동안함----------------------------------------------------
//    @RequestMapping("/{*\\Page$}")
//    public String pages(HttpServletRequest request) {
//        String path = request.getRequestURI();
//        String resultPath = path.substring(path.indexOf("/")+1, path.indexOf("pages"));
//        logger.debug("resultPath :" + resultPath);
//        return resultPath;
//    }
}
