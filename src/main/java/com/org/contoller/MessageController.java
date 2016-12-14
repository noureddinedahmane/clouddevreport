package com.org.contoller;

import java.security.Principal;

import javax.script.Bindings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.entities.Client;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierMessage;
import com.org.util.Message;

@Controller
@RequestMapping(value = "/admin/")
public class MessageController {
	
	@Autowired
	private IMetierClient metierClient;
	
	@Autowired
	private IMetierMessage metierMessage;
	
	// list messages
	@RequestMapping(value = "listMessages", method = RequestMethod.GET)
	public String listMessages(Model model, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		model.addAttribute("listMessages", metierMessage.listMessages(0, 200, client));		
		return "messages/messages";
	}
	
	// delete messages
	@RequestMapping(value = "deleteMessage", method = RequestMethod.GET)
	public ModelAndView deleteMessages(Model model, Principal principal,Long idMessage, RedirectAttributes redirectAtrributes) {
		Client client = metierClient.getClientByUserName(principal.getName());
		metierMessage.deleteMessage(idMessage, client);
        Message message = new Message("The message has been successfuly deleted","success");
        redirectAtrributes.addFlashAttribute("message", message);
        
		return new ModelAndView("redirect:listMessages");
	}
	
	// show message
	@RequestMapping(value = "showMessage", method = RequestMethod.GET)
	public String showMessage(Model model, Principal principal,Long message) {
		Client client = metierClient.getClientByUserName(principal.getName());
		com.org.entities.Message messageToShow = metierMessage.getMessage(message, client);
        model.addAttribute("mail", messageToShow);
        return "messages/message";
	}
		
}
