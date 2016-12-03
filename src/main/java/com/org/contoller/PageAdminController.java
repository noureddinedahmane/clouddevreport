package com.org.contoller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.entities.Client;
import com.org.entities.ClientService;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierClientPage;
import com.org.util.Message;


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
	
	
	// redirect to add a service
	@RequestMapping(value = "addService", method = RequestMethod.GET)
	public String addService(Model model) {
        
		ClientService clientService = new ClientService();
		model.addAttribute("clientService", clientService);
		
		return "pageadmin/addService";
	}
	
	
	
	// insert a new client service
	@RequestMapping(value = "saveService", method = RequestMethod.POST)
	public ModelAndView saveService(Model model, ClientService clientService, Principal principal) {
		
		Message message =null;
		
		Client client = metierClient.getClientByUserName(principal.getName());
		if(client!=null){
			
		    if(clientService.getIdClientService()!=null){
		    	//update the client Service
		    	metierClientPage.updateClientService(clientService, client);
				message = new Message("The service was successfuly updated","success");
				
		    }else{
		    	//add the client service
		    	//add datecreation and dateupdate
				 //.....
				
				//
				metierClientPage.addClientService(clientService, client);
				message = new Message("The service was successfuly saved","success");
		    }
		}
		
		return new ModelAndView("pageadmin/addService","message",message);
	}
	
	
	// List de services
	@RequestMapping(value = "clientServices", method = RequestMethod.GET)
	public String clientServices(Model model, Principal principal) {
        
		Client client = metierClient.getClientByUserName(principal.getName());
		if(client!=null){
			
			model.addAttribute("clientServices", client.getClientPage().getClientServices());
		}
		
		return "pageadmin/clientServices";
	}
	
	// redirect to update service
	@RequestMapping(value = "editClientService", method = RequestMethod.GET)
	public String editClientSerice(Model model,int service, Principal principal) {
		Message message =null;
		
		Client client = metierClient.getClientByUserName(principal.getName());
		if(client!=null){
			ClientService clientService = metierClientPage.getClientService(new Long(service), client);
			if(clientService!=null){
				model.addAttribute("clientService", clientService);
			}
			else{
				message = new Message("Service was not found","danger");
				model.addAttribute("clientService", new ClientService());
				model.addAttribute("message", message);
			}
		}
		
		return "pageadmin/addService";
	}
	
	//delete Client Service 
	@RequestMapping(value = "deleteService", method = RequestMethod.GET)
	public ModelAndView deleteClientSerice(Model model,Long service, Principal principal, RedirectAttributes redirecAtrributes) {
		Message message =null;
		
		Client client = metierClient.getClientByUserName(principal.getName());
		if(client!=null){
			ClientService clientService = metierClientPage.getClientService(service, client);
			if(clientService!=null){
				
				//remove service
				if(metierClientPage.deleteClientService(service, client)){
					message = new Message("Service has been successfuly removed","success");
				}else{
					message = new Message("Service could not be removed","danger");
				}
			}
			else{
				message = new Message("Service was not found","danger");
			}
		}
	    
		redirecAtrributes.addFlashAttribute("message", message);
		
		return new ModelAndView("redirect:clientServices");
	}
	
		
}
