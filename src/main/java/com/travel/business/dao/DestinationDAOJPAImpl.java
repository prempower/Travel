package com.travel.business.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.travel.business.common.BaseJPADAO;
import com.travel.business.persistence.Destination;

@Repository("destinationDAOJPAImpl")
public class DestinationDAOJPAImpl extends BaseJPADAO implements DestinationDAO {

	@Override
	public void createDestination(Destination destination) {
		super.persist(destination);

	}

	@Override
	public Destination getDestination(Integer destination) {
		// TODO Auto-generated method stub
		return em.find(Destination.class, destination);
	}

	@Override
	public Destination updateDestination(Destination destination) {
		// TODO Auto-generated method stub
		return (Destination)super.merge(destination);
	}

	@Override
	public List<Destination> getUserDestinations(Integer id) {
		
		List<Destination> destinationList = Collections.emptyList();
		StringBuffer buff = new StringBuffer("FROM Destination dest WHERE ");
		buff.append("dest.clientId = :clientID ");
		Query query = em.createQuery(buff.toString());
		query.setParameter("clientID", id);
		destinationList = query.getResultList();
		return destinationList;

	}
	
	

}
