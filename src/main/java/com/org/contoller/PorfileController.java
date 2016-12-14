package com.org.contoller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.entities.Client;
import com.org.util.Message;
import com.org.entities.Profile;
import com.org.metierInter.IMetierClient;

@Controller
@RequestMapping(value = "/admin/")
public class PorfileController {

	@Autowired
	private IMetierClient metierClient;
	
   //redirect to to form to edit profile
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile(Model model, Principal principal) {
		
		Client client = metierClient.getClientByUserName(principal.getName());
		Profile profile = client.getProfile();
		
		model.addAttribute("profile",profile);
				
		return "profile/profile";
	}
	
	//redirect to to form to edit profile
	@RequestMapping(value = "updateProfile", method = RequestMethod.POST)
	public String updateProfile(Model model, Profile profile, Principal principal) {
		Message message = null;
		
		Client client = metierClient.getClientByUserName(principal.getName());
        if(profile!=null){
        	metierClient.updateProfile(profile, client);
        	message = new Message("The Profile has been successfuly updated","success");
        	model.addAttribute("message",message);
        }
				
		return "profile/profile";
	}
		
		
}
