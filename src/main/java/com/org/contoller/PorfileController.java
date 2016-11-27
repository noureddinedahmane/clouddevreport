package com.org.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/")
public class PorfileController {

	
	   //redirect to to form to edit profile
		@RequestMapping(value = "profile", method = RequestMethod.GET)
		public String profile(Model model) {
			
					
			return "profile/profile";
		}
		
		
}
