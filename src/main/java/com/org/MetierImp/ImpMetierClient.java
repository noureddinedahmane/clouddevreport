package com.org.MetierImp;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoClient;
import com.org.entities.Client;
import com.org.entities.Role;
import com.org.metierInter.IMetierClient;

@Transactional
public class ImpMetierClient implements IMetierClient {

	private IDaoClient dao;
	
	public void setDao(IDaoClient dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client client) {
		return dao.addClient(client);
	}

	@Override
	public Client getClient(Long id) {
		return dao.getClient(id);
	}

	@Override
	public void deleteClient(Long id) {
		dao.deleteClient(id);
	}

	@Override
	public Client updateClient(Client client) {
		return dao.updateClient(client);
	}

	@Override
	public List<Client> listAllClients() {
		return dao.listAllClients();
	}

	@Override
	public Client getClientByUserName(String userName) {
		// TODO Auto-generated method stub
		return dao.getClientByUserName(userName);
	}

	@Override
	public Role addRole(Client client, Role role) {
		return dao.addRole(client, role);
	}

}
