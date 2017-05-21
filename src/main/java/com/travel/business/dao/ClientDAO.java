package com.travel.business.dao;

import java.util.List;

import com.travel.business.persistence.Client;


public interface ClientDAO {
	

	public void createClient(Client client);
	

	public Client getClient(Integer clientId);
	
	public Client updateClient(Client client);

    public List<Client> getClients();
    
    public void deleteClient(Client client);

}
