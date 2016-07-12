package org.sitenv.common.statistics.dao.impl;

import org.sitenv.common.statistics.dao.CcdaServiceDAO;
import org.sitenv.common.statistics.dto.CcdaWeeklyCounts;
import org.sitenv.common.statistics.entity.CcdaServiceCallEntity;
import org.sitenv.common.statistics.entity.CcdaWeeklyCountsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository(value="ccdaServiceDAO")
public class CcdaServiceDAOImpl extends BaseDAOImpl implements CcdaServiceDAO {

	
	public void createCcdaServiceCall(String testType, Boolean hasErrors, Boolean hasWarnings,
			Boolean hasInfo, Boolean hasHttpError, String validator) {
		CcdaServiceCallEntity entity = new CcdaServiceCallEntity();
		
		entity.setErrors(hasErrors);
		entity.setWarnings(hasWarnings);
		entity.setInfo(hasInfo);
		entity.setHttpError(hasHttpError);
		entity.setValidationType(testType);
		entity.setValidator(validator);
		entityManager.persist(entity);
	}
	
	
	
	public Long getHttpErrorCount(Boolean hasHttpError, Integer numOfDays) {
		
		Long errorCount;
		
		if (numOfDays == null) {
			
			errorCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaServiceCallEntity t WHERE t.httpError = :boolval").setParameter("boolval", hasHttpError).getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaServiceCallEntity t WHERE t.httpError = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
			query.setParameter("boolval", hasHttpError);
			query.setParameter("currentDate", currentDbDate);
			query.setParameter("prevDate", pastDate);
			
			errorCount = (Long) query.getSingleResult();
			
		}
		
		return errorCount;
		
	}

	public Long getErrorCount(Boolean hasErrors, Integer numOfDays) {
		
		Long errorCount;
		
		if (numOfDays == null) {
			
			errorCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaServiceCallEntity t WHERE t.errors = :boolval AND t.httpError = false").setParameter("boolval", hasErrors).getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaServiceCallEntity t WHERE t.errors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
			query.setParameter("boolval", hasErrors);
			query.setParameter("currentDate", currentDbDate);
			query.setParameter("prevDate", pastDate);
			
			errorCount = (Long) query.getSingleResult();
			
		}
		
		return errorCount;
		
	}

	public Long getWarningCount(Boolean hasWarnings, Integer numOfDays) {

		Long warnCount;
		
		if (numOfDays == null) {
			
			warnCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaServiceCallEntity t WHERE t.warnings = :boolval AND t.httpError = false").setParameter("boolval", hasWarnings).getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaServiceCallEntity t WHERE t.warnings = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
			query.setParameter("boolval", hasWarnings);
			query.setParameter("currentDate", currentDbDate);
			query.setParameter("prevDate", pastDate);
			
			warnCount = (Long) query.getSingleResult();
			
		}
		
		return warnCount;
	}

	public Long getInfoCount(Boolean hasInfo, Integer numOfDays) {

		Long infoCount;
		
		if (numOfDays == null) {
			
			infoCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaServiceCallEntity t WHERE t.info = :boolval AND t.httpError = false").setParameter("boolval", hasInfo).getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaServiceCallEntity t WHERE t.info = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
			query.setParameter("boolval", hasInfo);
			query.setParameter("currentDate", currentDbDate);
			query.setParameter("prevDate", pastDate);
			
			infoCount = (Long) query.getSingleResult();
			
		}
		
		return infoCount;
	}

	public Long getTotalCount(Integer numOfDays) {

		Long totalCount;
		
		if (numOfDays == null) {
			
			totalCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaServiceCallEntity t WHERE t.httpError = false").getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaServiceCallEntity t WHERE  t.httpError = false AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
			query.setParameter("currentDate", currentDbDate);
			query.setParameter("prevDate", pastDate);
			
			totalCount = (Long) query.getSingleResult();
			
		}
		
		return totalCount;
	}
	
	

	@SuppressWarnings("unchecked")
	public List<CcdaWeeklyCounts> getCcdaWeeklyCounts(Integer numOfWeeks) {
		
		List<CcdaWeeklyCounts> returnVal = null;
		
		Query query = entityManager.createNamedQuery("ccdaValidationWeeklyCounts", CcdaWeeklyCountsEntity.class);
		query.setParameter(1, numOfWeeks);
		
		List<CcdaWeeklyCountsEntity> results = query.getResultList();
		
		if (results != null) {
			for(CcdaWeeklyCountsEntity result : results) {
				if (returnVal == null)
				{
					returnVal = new ArrayList<CcdaWeeklyCounts>();
				}
				
				CcdaWeeklyCounts count = new CcdaWeeklyCounts();
				count.setEndDate(result.getEndDate());
				count.setTotalCount(result.getTotalCount());
				count.setInterval(result.getInterval());
				count.setStartDate(result.getStartDate());
				count.setYear(result.getYear());
				
				returnVal.add(count);
				
			}
		}
		
		return returnVal;
		
	}

	
}
