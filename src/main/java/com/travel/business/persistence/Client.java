package com.travel.business.persistence;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;



@Entity
@Table(name = "client")
public class Client extends BaseEntity{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "CLIENT_ID", nullable = false)
    private Integer clientId;
	
	@Column(name = "FNAME")
	private String firstName;
	
	@Column(name = "LNAME")
	private String lastName;
	
	@Column(name = "HOME_STATE")
	private String homeState;
	
	@Column(name = "HOME_COUNTRY")
	private String homeCountry;
	
	

	public Integer getClientId() {
		return clientId;
	}


	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getHomeState() {
		return homeState;
	}


	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}


	public String getHomeCountry() {
		return homeCountry;
	}


	public void setHomeCountry(String homeCountry) {
		this.homeCountry = homeCountry;
	}


	
	
	public String toString() { return ToStringBuilder.reflectionToString(this);}

}
