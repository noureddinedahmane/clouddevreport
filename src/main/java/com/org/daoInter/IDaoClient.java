package com.org.daoInter;

import java.util.List;

import com.org.entities.Client;

public interface IDaoClient {

	public Client addClient(Client client);
	public Client getClient(Long id);
	public void deleteClient(Long id);
	public Client updateClient(Client client);
	public List<Client> listAllClients();
	public Client getClientByUserName(String userName);
	
}
