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
import com.org.entities.Patient;
import com.org.entities.Regime;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierPatient;
import com.org.metierInter.IMetierRegime;
import com.org.util.Message;

@Controller
@RequestMapping(value = "/admin/")
public class RegimeController {
	
	@Autowired
	private IMetierRegime metierRegime;
	
	@Autowired
	private IMetierClient  metierClient;
	
	@Autowired
	private IMetierPatient  metierPatient;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	/**
	 * list Regime of a patient
	 */
	@RequestMapping(value = "listRegimes", method = RequestMethod.GET)
	public String listRegime(Model model,Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
        model.addAttribute("listRegimes",metierRegime.listAllRegime(client));
		return "regime/regimes";
	}
	
	/**
	 * list Regime of a patient
	 */
	@RequestMapping(value = "saveRegime", method = RequestMethod.POST)
	public ModelAndView saveRegime(Model model,Principal principal,Regime regime, Long idPatient,RedirectAttributes redirecAtrributes) {
		Message message=null;
		Client client = metierClient.getClientByUserName(principal.getName());
		Patient patient = metierPatient.getPatient(idPatient, client);
        
		if(regime.getIdRegime()==null){
        	//new Regime
        	regime.setPatient(patient);
        	regime.setLastUpdate(new Date());
        	metierRegime.addRegime(regime, patient, client);
        	message = new Message("The Task has been successfuly saved","success");
        }else{
        	//update Regime
        	regime.setPatient(patient);
        	regime.setLastUpdate(new Date());
        	metierRegime.updateRegime(regime, patient, client);
        	message = new Message("The Task has been successfuly modified","success");
        }
		
		redirecAtrributes.addFlashAttribute("message", message);
		
		return new ModelAndView("redirect:medicalRecord?patient="+idPatient);
	}
	
	/**
	 * redirect to create new Regime
	 */
	@RequestMapping(value = "newRegime", method = RequestMethod.GET)
	public String newRegimeRegime(Model model,Principal principal,Long idPatient) {
        model.addAttribute("regime",new Regime());
        model.addAttribute("idPatient", idPatient);
        
		return "regime/regime";
	}
	
	/**
	 * redirect to update Regime
	 */
	@RequestMapping(value = "editRegime", method = RequestMethod.GET)
	public String updateRegime(Model model,Principal principal,Long idRegime) {
		Client client = metierClient.getClientByUserName(principal.getName());
		Regime regime = metierRegime.getRegime(idRegime, client);
		
        model.addAttribute("regime",regime);
        model.addAttribute("idPatient", regime.getPatient().getIdPatient());
        
		return "regime/regime";
	}
	
	/**
	 * delete Regime--> redirect vers medical folder page
	 */
	@RequestMapping(value = "deleteRegime", method = RequestMethod.GET)
	public ModelAndView deleteRegime(Model model,Principal principal,Long idRegime,RedirectAttributes redirecAtrributes) {
		Message message=null;
		Client client = metierClient.getClientByUserName(principal.getName());
		Regime regime = metierRegime.getRegime(idRegime, client);
		
		if(metierRegime.deleteRegime(idRegime, client)){
		   message = new Message("Regime has been successfuly removed","success");
		}else{
			message = new Message("Error, Regime could not be removed","danger");
		}
        
		redirecAtrributes.addFlashAttribute("message", message);
		
		return new ModelAndView("redirect:medicalRecord?patient="+regime.getPatient().getIdPatient());
	}
	
	
	
}
