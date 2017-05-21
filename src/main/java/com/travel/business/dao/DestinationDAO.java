package com.travel.business.dao;

import java.util.List;

import com.travel.business.persistence.Destination;

public interface DestinationDAO {
	
	public void createDestination(Destination destination);
	

	public Destination getDestination(Integer destination);
	
	public Destination updateDestination(Destination destination);
	
	public List<Destination> getUserDestinations(Integer id );

}
