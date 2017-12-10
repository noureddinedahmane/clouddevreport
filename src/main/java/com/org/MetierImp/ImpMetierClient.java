package com.org.MetierImp;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoClient;
import com.org.entities.Account;
import com.org.entities.Client;
import com.org.entities.Domain;
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

	@Override
	public Account addAccont(Account account) {
		// TODO Auto-generated method stub
		return dao.addAccont(account);
	}

	@Override
	public Account getAccount(Long id) {
		// TODO Auto-generated method stub
		return dao.getAccount(id);
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return  dao.updateAccount(account);
	}

	@Override
	public List<Client> listClientByAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.listClientByAccount(account);
	}

	@Override
	public List<Client> listUsersByDomain(Domain domain) {
		// TODO Auto-generated method stub
		return dao.listUsersByDomain(domain);
	}

}
