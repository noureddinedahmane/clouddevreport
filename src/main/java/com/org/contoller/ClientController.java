package com.org.contoller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.entities.Client;
import com.org.entities.Role;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierClientPage;

@Controller
public class ClientController {

	@Autowired
	private IMetierClient metier;
	
	@Autowired
	private IMetierClientPage metierClientPage;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	/**
	 * redirection to inscription page
	 */
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscription(Model model) {
		model.addAttribute("client", new Client());
		return "inscription";
	}
	
	/**
	 * redirection to inscription faild page
	 */
	@RequestMapping(value = "/inscriptionFailed", method = RequestMethod.GET)
	public String inscriptionFailed(Model model) {
		return "inscription";
	}
	
	
	/**
	 * accout activation
	 */
	@RequestMapping(value = "/accountActivation", method = RequestMethod.GET)
	public String accountActivation(Model model) {
		return "accountActivation";
	}
	
	/**
	 * save Client
	 */
	@RequestMapping(value = "/saveClient", method = RequestMethod.POST)
	public ModelAndView saveClient(@Valid Client client,BindingResult bindingResult,RedirectAttributes redir) {
		if(bindingResult.hasErrors()){
			redir.addFlashAttribute("client",client);
			return new ModelAndView("redirect:/inscriptionFailed");
		}else{
			
			if(client!=null){
				
				//make sure that the Username is Unique
				if(metier.getClientByUserName(client.getUsername())==null){
					client.setEnabled(true);
					metier.addClient(client);
					
					//create client Page
					metierClientPage.createClientPage(client);
					
					//add client Roles
					Role role = new Role("ROLE_ADMIN");
					metier.addRole(client, role);
					
					return new ModelAndView("redirect:/accountActivation");
				}else{
					redir.addFlashAttribute("username_exist","Sorry the Username ist already registried");
					redir.addFlashAttribute("client",client);
					return new ModelAndView("redirect:/inscriptionFailed");
				}
				
			}else{
				return new ModelAndView("redirect:/inscriptionFailed");
			}
		}
	}
	
	/**
	 * save Client
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		return"index";
	}
	
	
}
