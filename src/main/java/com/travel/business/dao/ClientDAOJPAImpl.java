package com.travel.business.dao;


import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.travel.business.common.BaseJPADAO;
import com.travel.business.persistence.Client;

@Repository("clientDAOJPAImpl")
public class ClientDAOJPAImpl extends BaseJPADAO implements ClientDAO {

	@Override
	public void createClient(Client client) {
		super.persist(client);

	}

	@Override
	public Client getClient(Integer clientId) {
	
		return em.find(Client.class, clientId);
	}
	
	public Client updateClient(Client client)
	{
		
		return (Client)em.merge(client);
	}

	@Override
	public List<Client> getClients() {
		 
				
		List<Client> clientList = Collections.emptyList();
		StringBuffer buff = new StringBuffer("FROM Client ");

		Query query = em.createQuery(buff.toString());

		clientList = query.getResultList();

		return clientList;
	}

	@Override
	public void deleteClient(Client client) {
		
		StringBuffer buff = new StringBuffer("Delete FROM Client cl where ");
		buff.append("cl.firstName = :fname ");
		buff.append("and cl.lastName = :lname ");
		Query query = em.createQuery(buff.toString());
		query.setParameter("fname", client.getFirstName());
		query.setParameter("lname", client.getLastName());
		query.executeUpdate();
		
	}
	
	

}
