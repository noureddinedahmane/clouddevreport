package com.org.daoInter;

import java.util.List;

import com.org.entities.Client;
import com.org.entities.Patient;
import com.org.entities.Regime;

public interface IDaoRegime {

	public Regime addRegime(Regime regime, Patient patient, Client client);
	public Regime updateRegime(Regime regime, Patient patient, Client client);
	public Regime getRegime(Long idRegime, Client client);
	public boolean deleteRegime(Long idRegime, Client client);
	public List<Regime> listRegime(Patient patient, Client client);
	public List<Regime> listAllRegime(Client client);
	
}
