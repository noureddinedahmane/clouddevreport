package com.org.metierInter;

import java.util.Date;
import java.util.List;

import com.org.entities.Client;
import com.org.entities.Patient;

public interface IMetierPatient {
	public Patient addPatient(Patient patient, Client client);
	public Patient getPatient(Long idPatient, Client client);
	public boolean deletePatient(Long idPatient, Client client);
	public Patient updatePatient(Patient patient, Client client);
	public List<Patient> listPatient(int min, int max, Client client);
	public List<Patient> searchPatient(int min, int max, String patientName, Date birthDay, Client client);
}
