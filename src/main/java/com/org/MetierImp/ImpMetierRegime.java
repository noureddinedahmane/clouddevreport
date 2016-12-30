package com.org.MetierImp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoRegime;
import com.org.entities.Client;
import com.org.entities.Patient;
import com.org.entities.Regime;
import com.org.metierInter.IMetierRegime;

@Transactional
public class ImpMetierRegime implements IMetierRegime {

	private IDaoRegime daoRegime;
	
	
	public IDaoRegime getDaoRegime() {
		return daoRegime;
	}

	public void setDaoRegime(IDaoRegime daoRegime) {
		this.daoRegime = daoRegime;
	}

	@Override
	public Regime addRegime(Regime regime, Patient patient, Client client) {
		return daoRegime.addRegime(regime, patient, client);
	}

	@Override
	public Regime updateRegime(Regime regime, Patient patient, Client client) {
		return daoRegime.updateRegime(regime, patient, client);
	}

	@Override
	public Regime getRegime(Long idRegime, Client client) {
		return daoRegime.getRegime(idRegime, client);
	}

	@Override
	public boolean deleteRegime(Long idRegime, Client client) {
		return daoRegime.deleteRegime(idRegime, client);
	}

	@Override
	public List<Regime> listRegime(Patient patient, Client client) {
		return daoRegime.listRegime(patient, client);
	}

	@Override
	public List<Regime> listAllRegime(Client client) {
		return daoRegime.listAllRegime(client);
	}

}
