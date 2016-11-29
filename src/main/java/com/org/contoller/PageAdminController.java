package com.org.contoller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.entities.Client;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierClientPage;


@Controller
@RequestMapping(value = "/admin/")
public class PageAdminController {
  
	@Autowired
	private IMetierClientPage metierClientPage;
	
	@Autowired
	private IMetierClient metierClient;
	
	
	// redirect to editAbout page
	@RequestMapping(value = "editAbout", method = RequestMethod.GET)
	public String editAboutPage(Model model, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		if(client!=null){
			model.addAttribute("about", client.getClientPage().getAbout());
		}
		
		return "pageadmin/editAbout";
	}
	
	
	// update about page
	@RequestMapping(value = "updateEditAbout", method = RequestMethod.POST)
	public String updateEditAboutPage(Model model, Principal principal, String about) {
		
		Client client = metierClient.getClientByUserName(principal.getName());
		if(client!=null){
			metierClientPage.updateAboutClientPage(about, client);
		}
		
		return "redirect:editAbout";
	}
	
	
		
}
