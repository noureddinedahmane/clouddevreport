package com.org.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/")
public class MedicalRecordController {

	// list messages
	@RequestMapping(value = "listMedicalRecords", method = RequestMethod.GET)
	public String listMedicalRecords(Model model) {
		
				
		return "medicalRecords/medicalRecords";
	}
	
	// redirect to form to add medical record
	@RequestMapping(value = "medicalRecord", method = RequestMethod.GET)
	public String addMedicalRecord(Model model) {
		
				
		return "medicalRecords/medicalRecord";
	}
	
}
