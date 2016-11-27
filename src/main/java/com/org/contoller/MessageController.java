package com.org.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/")
public class MessageController {

	
	// list messages
	@RequestMapping(value = "listMessages", method = RequestMethod.GET)
	public String listMessages(Model model) {
		
				
		return "messages/messages";
	}
		
}
