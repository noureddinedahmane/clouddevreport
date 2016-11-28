package com.org.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.MetierImp.ImpMetierClient;
import com.org.entities.Client;
import com.org.entities.ClientPage;

@Controller
@RequestMapping(value = "/pages/")
public class PageController {
   
	@Autowired
	private ImpMetierClient metierClient;
	
	 // redirect to about page
	@RequestMapping(value = "about", method = RequestMethod.GET)
	public String aboutPage(Model model) {
		
		Client client = metierClient.getClientByUserName("dnoureddine11@gmail.com");
		String about = null;
		ClientPage clientPage = client.getClientPage();
		
		if(clientPage!=null){
			about = clientPage.getAbout();
		}
		
		model.addAttribute("about", about);
		
		return "page/about";
	}
	
	// redirect to services page
	@RequestMapping(value = "services", method = RequestMethod.GET)
	public String servicesPage(Model model) {
		
				
		return "page/services";
	}
	
	// redirect to contact page
	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String contactPage(Model model) {
		
				
		return "page/contact";
	}
		
		
		
}
