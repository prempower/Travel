package com.travel.business.persistence;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Abstract Base Entity for JPA persistence.   
 * @author prem.kumar
 *
 */

@MappedSuperclass 
public abstract class BaseEntity {
	
	@Column(name = "UPDATE_TIME", insertable=true, updatable=true)
	private Timestamp updateTime;
	
	@Column(name ="UPDATED_BY", insertable=true, updatable=true)
	private String updatedBy;
  
	

	public Timestamp getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}



	public String getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	public String toString() { return ToStringBuilder.reflectionToString(this);};
}
