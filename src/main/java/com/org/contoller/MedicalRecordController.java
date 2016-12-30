package com.org.contoller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.entities.Client;
import com.org.entities.Patient;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierPatient;
import com.org.metierInter.IMetierRegime;

@Controller
@RequestMapping(value = "/admin/")
public class MedicalRecordController {

	@Autowired
	private IMetierRegime metierRegime;
	
	@Autowired
	private IMetierClient  metierClient;
	
	@Autowired
	private IMetierPatient  metierPatient;
	
	// list messages
	@RequestMapping(value = "listMedicalRecords", method = RequestMethod.GET)
	public String listMedicalRecords(Model model) {
	
				
		return "medicalRecords/medicalRecords";
	}
	
	// redirect to form to add medical record
	@RequestMapping(value = "medicalRecord", method = RequestMethod.GET)
	public String addMedicalRecord(Model model, Long patient, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		Patient patientTo = metierPatient.getPatient(patient, client);
        model.addAttribute("listRegimes", metierRegime.listRegime(patientTo, client));
        model.addAttribute("idPatient", patient);
				
		return "medicalRecords/medicalRecord";
	}
	
	
	
}
