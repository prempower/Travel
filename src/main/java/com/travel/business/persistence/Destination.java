package com.travel.business.persistence;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "destination")
public class Destination extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "LOCATION_ID", nullable = false)
    private Integer locationId;
	
	@Column(name = "CLIENT_ID", nullable = false)
    private Integer clientId;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID", nullable = false, insertable= false, updatable=false)
	private Client client;
	
	@Column(name = "LOCATION_NAME")
	private String locationName;
	
	@Column(name = "LOCATION_COUNTRY")
	private String locationCountry;
	
	
	@Column(name = "TRAVEL_TIME")
	private Timestamp travelTime;

	
	
	
	public Integer getLocationId() {
		return locationId;
	}



	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}


	

	public Integer getClientId() {
		return clientId;
	}



	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client= client;
	}



	public String getLocationName() {
		return locationName;
	}



	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}



	public String getLocationCountry() {
		return locationCountry;
	}



	public void setLocationCountry(String locationCountry) {
		this.locationCountry = locationCountry;
	}



	public Timestamp getTravelTime() {
		return travelTime;
	}



	public void setTravelTime(Timestamp travelTime) {
		this.travelTime = travelTime;
	}



	public String toString() { return ToStringBuilder.reflectionToString(this);}
}
