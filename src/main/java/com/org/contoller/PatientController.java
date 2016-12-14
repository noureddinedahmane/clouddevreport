package com.org.contoller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.org.entities.Client;
import com.org.entities.Patient;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierPatient;
import com.org.util.Message;

@Controller
@RequestMapping(value = "/admin/")
public class PatientController {

	@Autowired
	private IMetierClient metierClient;
	
	@Autowired
	private IMetierPatient metierPatient;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	//redirect to to form to edit patient
	@RequestMapping(value = "editPatient", method = RequestMethod.POST)
	public ModelAndView editPatient(String action, Model model, Patient patient, Principal principal,  RedirectAttributes redirecAtrributes) {
		
		Message message = null;
		
		Client client = metierClient.getClientByUserName(principal.getName());
		patient.setClient(client);
		patient.setRegistrayDate(new Date());
		
		if(patient.getIdPatient()==null){
			
			//add new aptient
			if(metierPatient.addPatient(patient, client)!=null){
				
				//add the medical record
				
				 message = new Message("The Patient has been successfuly saved","success");
			}
			else{
				message = new Message("The Patient could not be saved","danger");
			}
		}else{
			
			//update patient 
			
			if(metierPatient.updatePatient(patient, client)!=null){
				 message = new Message("The Patient has been successfuly saved","success");
			}
			else{
				message = new Message("The Patient could not be saved","danger");
			}
		}
	    
		//add message attribut
		redirecAtrributes.addFlashAttribute("message", message);
		
		if(action!=null){
			
			if(action.equals("save")){
				
				
				//redirect to patient list
				return new ModelAndView("redirect:listPatients");
			}
			else{
				
				//redirect to edit patient medical records
				return new ModelAndView("redirect:medicalRecord");
			}
		}
		else{
			
			return new ModelAndView("redirect:addPatient");
		}

	}
	
	//redirect  patient to update 
	@RequestMapping(value = "updatePatient", method = RequestMethod.GET)
	public String updatePatient(Model model,Long patient,Principal principal ) {
		Client client = metierClient.getClientByUserName(principal.getName());
	    Patient patientToUpdate = metierPatient.getPatient(patient, client);
	    model.addAttribute("patient",patientToUpdate);
	    
		return "patients/patient";
	}
	
	//delete Patient 
	@RequestMapping(value = "deletePatient", method = RequestMethod.GET)
	public ModelAndView deletePatient(Model model,Long patient,Principal principal, RedirectAttributes redirecAtrributes ) {
		Message message=null;
		
		Client client = metierClient.getClientByUserName(principal.getName());
	    metierPatient.deletePatient(patient, client);
	    
	    message = new Message("This Item has been successfuly removed","success");
	    redirecAtrributes.addFlashAttribute("message", message);
	    
		return new ModelAndView("redirect:listPatients");
	}
	
	
		
	
	//add new patient
	@RequestMapping(value = "addPatient", method = RequestMethod.GET)
	public String addPatient(Model model) {
		model.addAttribute("patient", new Patient());
		return "patients/patient";
	}
		
		
	//List Patients
	@RequestMapping(value = "listPatients", method = RequestMethod.GET)
	public String listPatients(Model model, Principal principal) {
		
		Client client = metierClient.getClientByUserName(principal.getName());
		model.addAttribute("listPatients", client.getPatients());
		
		return "patients/patients";
	}
	
	//Load List Patients
	@RequestMapping(value = "loadListPatients", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String loadListPatients(Model model, Principal principal) {
		Gson gson = new Gson();
		ModelAndView modelAndView = new ModelAndView();
		
		Client client = metierClient.getClientByUserName(principal.getName());
		List<Patient> listPatients = client.getPatients();
		List<String> str = new ArrayList<String>();
		List<List<String>> str1 = new ArrayList<List<String>>();
		
		str.add("test");
		str.add("test");
		
		str1.add(str);
		
		//convert list Patients
		String json = gson.toJson(str1);
		modelAndView.addObject(json);
		
		model.addAttribute("json", json);

		return json;
	}
	
	
	
}
