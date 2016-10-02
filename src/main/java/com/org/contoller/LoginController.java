package com.org.contoller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.metierInter.IMetierClient;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IMetierClient metier;
	
	/**
	 * redirect to login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "login";
	}
	
	
	/**
	 * 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		
		return "redirect:/login";
	}
		
}
