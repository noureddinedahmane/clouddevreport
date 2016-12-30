package com.org.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.org.daoInter.IDaoRegime;
import com.org.entities.Client;
import com.org.entities.Patient;
import com.org.entities.Regime;

public class ImpDaoRegime implements IDaoRegime{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Regime addRegime(Regime regime, Patient patient, Client client) {
		if(patient.getClient().getIdClient().equals(client.getIdClient())){
			regime.setPatient(patient);
			em.persist(regime);
			return regime;
		}else{
			return null;
		}
	}

	@Override
	public Regime updateRegime(Regime regime, Patient patient, Client client) {
		if(patient.getClient().getIdClient().equals(client.getIdClient())&&regime.getPatient().getIdPatient().equals(patient.getIdPatient())){
			regime.setPatient(patient);
			em.merge(regime);
			return regime;
		}else{
			return null;
		}
		
	}

	@Override
	public Regime getRegime(Long idRegime, Client client) {
		Regime regime = em.find(Regime.class, idRegime);
		if(regime!=null){	
			if(regime.getPatient().getClient().getIdClient().equals(client.getIdClient())){
				return regime;	
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public boolean deleteRegime(Long idRegime, Client client) {
		Regime regime = this.getRegime(idRegime, client);
		if(regime!=null){
			em.remove(regime);
			return true;
		}else{
			return false;
		}

	}

	@Override
	public List<Regime> listRegime(Patient patient, Client client) {
		if(patient.getClient().getIdClient().equals(client.getIdClient())){
			Query req = em.createQuery("select r from Regime r where r.patient.idPatient=:p");
			req.setParameter("p", patient.getIdPatient());			
			return req.getResultList();
			
		}else{
			return null;
		}
	}

	@Override
	public List<Regime> listAllRegime(Client client) {
		Query req = em.createQuery("select r from Regime r where r.patient.client.idClient=:c");
		req.setParameter("c",client.getIdClient());			
		return req.getResultList();
	}

}
