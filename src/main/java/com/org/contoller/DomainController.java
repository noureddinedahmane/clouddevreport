package com.org.contoller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.entities.Client;
import com.org.entities.Configuration;
import com.org.entities.Domain;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierDeviationReport;
import com.org.util.Message;

@Controller
@RequestMapping(value = "/admin/")
public class DomainController {

	@Autowired
	private IMetierDeviationReport metier;
	
	@Autowired
	private IMetierClient metierClient;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	//new domain
	@RequestMapping(value = "domain", method = RequestMethod.GET)
	public String newDomain(Model model,Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
	    model.addAttribute("domain",new Domain());
	    model.addAttribute("listDomains",metier.listDomainsByAccount(client.getAccount()));
		return "domain/domain";
	}
		
		
	//save or update Domain
	@RequestMapping(value = "saveDomain", method = RequestMethod.POST)
	public ModelAndView saveDomain(Model model,Domain domain,Principal principal,RedirectAttributes redirecAtrributes) {
		Message message=null;
		Client client = metierClient.getClientByUserName(principal.getName());
		if(domain.getIdDomain()==null){
			domain.setDateCreation(new Date());
			domain.setAccount(client.getAccount());
			//save new Task
			domain = metier.addDomain(domain, client);
			
			//create default configuration for the domain
			Configuration domainConfig =  new Configuration();
			domainConfig.setDomain(domain);
			
			//save configuration for the new Domain
			metier.addConfiguration(domainConfig, domain, client);
		
			message = new Message("The Domain has been successfuly saved","success");
		}
		else{
			//update the task
			metier.updateDomain(domain, client);
			message = new Message("The Domain has been successfuly saved","success");
		}
		
		redirecAtrributes.addFlashAttribute("message", message);
		
		return new ModelAndView("redirect:domain");
	}
	
	//edit domain
	@RequestMapping(value = "editDomain", method = RequestMethod.GET)
	public String editDomain(Model model,Long idDomain,Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		Domain domain = metier.getDomain(idDomain, client);
	    model.addAttribute("domain",domain);
	    model.addAttribute("listDomains",metier.listDomainsByAccount(client.getAccount()));
		return "domain/domain";
	}
			
	
	
	
		
}
