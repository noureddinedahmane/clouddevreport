package com.org.daoImp;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.org.daoInter.IDaoPatient;
import com.org.entities.Client;
import com.org.entities.Patient;

public class ImpDaoPatient implements IDaoPatient {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Patient addPatient(Patient patient, Client client) {
		patient.setClient(client);
		em.persist(patient);
		
		return patient;
	}

	@Override
	public Patient getPatient(Long idPatient, Client client) {
		Patient patient = em.find(Patient.class, idPatient);
		if(patient!=null){
			if(patient.getClient().equals(client)){
				return patient;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public boolean deletePatient(Long idPatient, Client client) {
		 Patient patient = em.find(Patient.class, idPatient);
		 if(patient!=null){
			 if(patient.getClient().equals(client)){
				 em.remove(patient);
				 return true;
				 
			 }else{
				 return false;
			 }
		 }else{
			 return false;
		 }
	}

	@Override
	public Patient updatePatient(Patient patient, Client client) {
		
		if(patient!=null){
			patient.setClient(client);
			em.merge(patient);
		}
		
		return patient;
	}

	@Override
	public List<Patient> listPatient(int min, int max, Client client) {
		Query req = em.createQuery("select p from Patient p where p.client=:c");
		req.setParameter("c", client);
		req.setFirstResult(min);
		req.setMaxResults(max);
		
		return req.getResultList();
	}

	@Override
	public List<Patient> searchPatient(int min, int max, String patientName,
			Date birthDay, Client client) {
		
		Criteria  criteria = em.unwrap(Session.class).createCriteria(Patient.class);
		criteria.add(Restrictions.eq("client", client));
		
		if(patientName!=null){
			criteria.add(Restrictions.eq("firstName", patientName));
		}
		if(birthDay!=null){
			criteria.add(Restrictions.eq("birthDay", birthDay));
		}
		
		criteria.setFirstResult(min);
		criteria.setMaxResults(max);
		
		return criteria.list();
	}

}
