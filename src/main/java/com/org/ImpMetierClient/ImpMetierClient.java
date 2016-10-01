package com.org.ImpMetierClient;
import org.springframework.transaction.annotation.Transactional;
import com.org.daoInter.IDaoClient;
import com.org.entities.Client;
import com.org.metierInter.IMetierClient;

@Transactional
public class ImpMetierClient implements IMetierClient {

	private IDaoClient dao;
	
	public void setDao(IDaoClient dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client client) {
		// TODO Auto-generated method stub
		return dao.addClient(client);
	}

}
