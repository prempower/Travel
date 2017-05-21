package com.travel.business.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.travel.business.persistence.Client;
import com.travel.business.persistence.Destination;

public interface ClientService {

	
	@Transactional(readOnly = true, value = "transactionManager")
	public Client getClient(Integer clientId);	 	


	@Transactional(propagation = Propagation.REQUIRES_NEW, value = "transactionManager")
	public void createClient(Client client) ;
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, value = "transactionManager" )
	public Client updateClient(Client client);
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, value = "transactionManager" )
	public void  deleteClient(Client client);
	
	@Transactional(readOnly = true, value = "transactionManager")
	public List<Client> getClientList();
	
	
	@Transactional(readOnly = true, value = "transactionManager")
	public Destination getDestination(Integer destination);	 	


	@Transactional(propagation = Propagation.REQUIRES_NEW, value = "transactionManager")
	public void createDestination(Destination destination) ;
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, value = "transactionManager" )
	public Destination updateDestination(Destination destination);
	
	@Transactional(readOnly = true, value = "transactionManager")
	public List<Destination> getUserDestinations(Integer id);
	
	
	
	
}
