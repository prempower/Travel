package com.travel.business.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.travel.business.dao.ClientDAO;
import com.travel.business.dao.DestinationDAO;
import com.travel.business.persistence.Client;
import com.travel.business.persistence.Destination;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {

	
	@Inject
	@Qualifier("clientDAOJPAImpl")
	private ClientDAO clientDao;
	
	
	@Inject
	@Qualifier("destinationDAOJPAImpl")
	private DestinationDAO detsinationDao;
	
	@Override
	public Client getClient(Integer clientId) {
		Client client = clientDao.getClient(clientId);
		return client;
	}

	@Override
	public void createClient(Client client) {
		clientDao.createClient(client);
		System.out.println("create client complete");

	}

	@Override
	public Client updateClient(Client client) {

		return clientDao.updateClient(client);
	}

	@Override
	public Destination getDestination(Integer destination) {

		return detsinationDao.getDestination(destination);
	}

	@Override
	public void createDestination(Destination destination) {
		detsinationDao.createDestination(destination);
		
	}

	@Override
	public Destination updateDestination(Destination destination) {
		
		return detsinationDao.updateDestination(destination);
	}

	@Override
	public List<Destination> getUserDestinations(Integer id) {
		
		return detsinationDao.getUserDestinations(id);
	}

	@Override
	public List<Client> getClientList() {
		// TODO Auto-generated method stub
		return clientDao.getClients();
	}

	@Override
	public void  deleteClient(Client client) {
		// TODO Auto-generated method stub
		clientDao.deleteClient(client);
	}
	
	
   
}
