package com.org.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/")
public class PatientController {

	//redirect to to form to edit patient
	@RequestMapping(value = "patient", method = RequestMethod.GET)
	public String addPatient(Model model) {
		
				
		return "patients/patient";
	}
	
	//List Patients
	@RequestMapping(value = "listPatients", method = RequestMethod.GET)
	public String listPatients(Model model) {
		
				
		return "patients/patients";
	}
	
	
	
}
