package org.sitenv.common.statistics.dao.impl;

import org.sitenv.common.statistics.entity.DateItemEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;

public class BaseDAOImpl {

	@PersistenceContext
	protected EntityManager entityManager;
	
	
	/**
	 * @return System date on DB server
	 */
	protected Date getSystemDate() {
	    Query query = entityManager.createNativeQuery(
	            "SELECT CURRENT_TIMESTAMP as currtime", DateItemEntity.class);
	    DateItemEntity dateItem = (DateItemEntity) query.getSingleResult();
	    return dateItem.getDate();
	}
	
	protected Date getPreviousDate(Date currentDate, Integer numOfDays)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.DAY_OF_YEAR, ((-1) * numOfDays));
		Date pastDate = cal.getTime();
		
		return pastDate;
	}
	

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
}
