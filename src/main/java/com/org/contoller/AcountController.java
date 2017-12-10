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

import com.org.entities.Account;
import com.org.entities.Client;
import com.org.entities.Domain;
import com.org.metierInter.IMetierClient;
import com.org.util.Message;

@Controller
@RequestMapping(value = "/admin/")
public class AcountController {

	@Autowired
	private IMetierClient metier;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String account(Model model,Principal principal,RedirectAttributes redirecAtrributes) {
		Message message=null;
		
		Client client = metier.getClientByUserName(principal.getName());
		model.addAttribute("account", client.getAccount());
		
		return "account/account";
	}
	
	@RequestMapping(value = "updateAccount", method = RequestMethod.POST)
	public ModelAndView updateAccount(Model model, Account account, Principal principal,RedirectAttributes redirecAtrributes) {
		Message message=null;
		Client client = metier.getClientByUserName(principal.getName());
		
		if(account != null) {
			//update the account
			metier.updateAccount(account);
			
			message = new Message("The Account has been successfuly updated", "success");
			
		}else {
			message = new Message("The Account could not be updated", "danger");
		}
		
        redirecAtrributes.addFlashAttribute("message", message);
		
		return new ModelAndView("redirect:account");
	}
	
	
}
