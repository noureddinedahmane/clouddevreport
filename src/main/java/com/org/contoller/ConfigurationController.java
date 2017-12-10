package com.org.contoller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.entities.Client;
import com.org.entities.Configuration;
import com.org.entities.DeviationType;
import com.org.entities.Domain;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierDeviationReport;
import com.org.util.Message;

@Controller
@RequestMapping(value = "/admin/")
public class ConfigurationController {
	
	@Autowired
	private IMetierDeviationReport metier;
	
	@Autowired
	private IMetierClient metierClient;
	
	@RequestMapping(value = "domainConfig", method = RequestMethod.GET)
	public String domainConfig(Model model,Long idDomain,Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		
		Domain domain = metier.getDomain(idDomain, client);
		Configuration domainConfig = domain.getConfiguration();
		
		model.addAttribute("domainConfig", domainConfig);
		model.addAttribute("domain", domain);
		model.addAttribute("deviationType", new DeviationType());
		model.addAttribute("listDeviationTypes", metier.listDeviationTypeByDomain(domain));
		
		return"configuration/configuration";
	}
	
	@RequestMapping(value = "editDeviationType", method = RequestMethod.GET)
	public String editDeviationType(Model model,Principal principal, HttpServletRequest request) {
		Client client = metierClient.getClientByUserName(principal.getName());
		
		Long idDomain = new Long(request.getParameter("idDomain"));
		Long idDeviationType = new Long(request.getParameter("idDeviationType"));
		
		Domain domain = metier.getDomain(idDomain, client);
		Configuration domainConfig = domain.getConfiguration();
		
		model.addAttribute("domainConfig", domainConfig);
		model.addAttribute("domain", domain);
		model.addAttribute("deviationType", metier.getDeviationType(idDeviationType));
		model.addAttribute("listDeviationTypes", metier.listDeviationTypeByDomain(domain));
		
		return"configuration/configuration";
	}
	
	
	@RequestMapping(value = "saveDomainConfig", method = RequestMethod.POST)
	public ModelAndView saveDomainConfig(Model model,Configuration domainConfig,Principal principal,HttpServletRequest request, RedirectAttributes redirecAtrributes) {
		
		Message message = null;
		Client client = metierClient.getClientByUserName(principal.getName());
		Domain domain = metier.getDomain(new Long(request.getParameter("idDomain")), client);
		
		if(domain != null) {
			metier.updateConfiguration(domainConfig, domain, client);
			
			message = new Message("The Configuration has been saved","success");
		}else {
			message = new Message("Error: Domain dos not exist","danger");
		}
		
		//add message attribut
		redirecAtrributes.addFlashAttribute("message", message);
				
		return new ModelAndView("redirect:domainConfig?idDomain=" + request.getParameter("idDomain"));
	}
	
	@RequestMapping(value = "saveDeviationType", method = RequestMethod.POST)
	public ModelAndView saveDeviationType(Model model,DeviationType deviationType,Principal principal,HttpServletRequest request, RedirectAttributes redirecAtrributes) {
		
		Message message = null;
		Client client = metierClient.getClientByUserName(principal.getName());
		Domain domain = metier.getDomain(new Long(request.getParameter("idDomain")), client);
		
		if(domain != null) {
			
			deviationType.setDomain(domain);
			
			if(deviationType.getIdDeviationType() == null) {				
				metier.addDeviationType(deviationType);
			}else {
				metier.updateDeviationType(deviationType);
			}
		
			
			message = new Message("The Item has been saved","success");
		}else {
			message = new Message("Error: Item dos not exist","danger");
		}
		
		//add message attribut
		redirecAtrributes.addFlashAttribute("message", message);
				
		return new ModelAndView("redirect:domainConfig?idDomain=" + request.getParameter("idDomain"));
	}
	

}
