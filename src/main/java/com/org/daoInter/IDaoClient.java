package com.org.daoInter;

import java.util.List;

import com.org.entities.Account;
import com.org.entities.Client;
import com.org.entities.Domain;
import com.org.entities.Role;

public interface IDaoClient {

	public Client addClient(Client client);
	public Client getClient(Long id);
	public void deleteClient(Long id);
	public Client updateClient(Client client);
	public List<Client> listAllClients();
	public Client getClientByUserName(String userName);
	public Role addRole(Client client, Role role);
	public List<Client> listClientByAccount(Account account);
	public List<Client> listUsersByDomain(Domain domain);
	
	
	//client account
	public Account addAccont(Account account);
	public Account getAccount(Long id);
	public Account updateAccount(Account account);
	
	
	
}
