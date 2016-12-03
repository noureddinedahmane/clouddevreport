package com.org.contoller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.MetierImp.ImpMetierClient;
import com.org.MetierImp.ImpMetierClientPage;
import com.org.entities.Client;
import com.org.entities.ClientPage;
import com.org.entities.ClientService;

@Controller
@RequestMapping(value = "/pages/")
public class PageController {
   
	@Autowired
	private ImpMetierClient metierClient;
	
	@Autowired
	private ImpMetierClientPage metierClientPage;
	
	 // redirect to about page
	@RequestMapping(value = "about", method = RequestMethod.GET)
	public String aboutPage(Model model, Principal principal) {
		
		Client client = metierClient.getClientByUserName(principal.getName());
		String about = null;
		List<ClientService> listClientService=null;
		ClientPage clientPage = client.getClientPage();
		
		if(clientPage!=null){
			about = clientPage.getAbout();
			listClientService = clientPage.getClientServices();
		}
		
		model.addAttribute("about", about);
		model.addAttribute("listClientServices", listClientService);
		
		return "page/about";
	}
	
	// redirect to services page
	@RequestMapping(value = "services", method = RequestMethod.GET)
	public String servicesPage(Model model,Long service, Principal principal) {
		
		Client client = metierClient.getClientByUserName(principal.getName());
		List<ClientService> listClientService=null;
		ClientPage clientPage = client.getClientPage();
		
		if(clientPage!=null){
			listClientService = clientPage.getClientServices();
		}
		
		
		model.addAttribute("listClientServices", listClientService);
		model.addAttribute("clientService", metierClientPage.getClientService(service, client));
				
		return "page/services";
	}
	
	// redirect to contact page
	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String contactPage(Model model, Principal principal) {
		
		Client client = metierClient.getClientByUserName(principal.getName());
		List<ClientService> listClientService=null;
		ClientPage clientPage = client.getClientPage();
		
		if(clientPage!=null){
			listClientService = clientPage.getClientServices();
		}
		
		model.addAttribute("listClientServices", listClientService);
		model.addAttribute("client", client.getIdClient());
				
		return "page/contact";
	}
		
		
		
}
