package com.org.contoller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	 * 
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model, HttpServletRequest request) {
		
	 //return the user by username and store the idUser in user_session
	 User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 if(user!=null){
		 
		 Client client = metier.getClientByUserName(user.getUsername());
		 if(client!=null){
			 request.getSession().setAttribute("idClient", client.getIdClient());
		 }
	 }
	 
	 
	 return "home";
	}
		
}
