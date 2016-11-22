package com.org.MetierImp;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoPatient;
import com.org.entities.Client;
import com.org.entities.Patient;
import com.org.metierInter.IMetierPatient;

@Transactional
public class ImpMetierPatient implements IMetierPatient{
	
	private IDaoPatient daoPatient;

	public IDaoPatient getDaoPatient() {
		return daoPatient;
	}

	public void setDaoPatient(IDaoPatient daoPatient) {
		this.daoPatient = daoPatient;
	}

	@Override
	public Patient addPatient(Patient patient, Client client) {
		return daoPatient.addPatient(patient, client);
	}

	@Override
	public Patient getPatient(Long idPatient, Client client) {
		return daoPatient.getPatient(idPatient, client);
	}

	@Override
	public boolean deletePatient(Long idPatient, Client client) {
		return daoPatient.deletePatient(idPatient, client);
	}

	@Override
	public Patient updatePatient(Patient patient, Client client) {
		return daoPatient.updatePatient(patient, client);
	}

	@Override
	public List<Patient> listPatient(int min, int max, Client client) {
		return daoPatient.listPatient(min, max, client);
	}

	@Override
	public List<Patient> searchPatient(int min, int max, String patientName,
			Date birthDay) {
		return daoPatient.searchPatient(min, max, patientName, birthDay);
	}
	
	
	

}
