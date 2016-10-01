package com.org.loginmodule;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.org.entities.Client;
import com.org.metierInter.IMetierClient;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IMetierClient metier;
	
	/**
	 * redirect to login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Model model) {
		
		metier.addClient(new Client());
		return "login";
	}
	
	
	
	/**
	 * redirection to inscription page
	 */
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscription(Model model) {
		
		return "inscription";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		
		return "home";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		
		return "home";
	}
	
	
}
