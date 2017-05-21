package com.travel.business.common;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.travel.business.persistence.BaseEntity;


/**
 * Abstract BaseDAO class performs all underlying primary JPA database operations. 
 * @author prem.kumar
 *
 */
public abstract class BaseJPADAO {
	
    @PersistenceContext(unitName = "jpa")
    public EntityManager em;
    
    
    public void persist(BaseEntity obj)
    {
    	obj.setUpdateTime(new Timestamp(System.currentTimeMillis()));   
    	em.persist(obj);
    }
     
    public Object merge(BaseEntity obj)
    {    
    	obj.setUpdateTime(new Timestamp(System.currentTimeMillis()));  
    	return em.merge(obj);
    }
    
    public void remove(BaseEntity obj)
    {
    	em.remove(obj);
    }
}
