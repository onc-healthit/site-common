package org.sitenv.common.statistics.dao.impl;

import org.sitenv.common.statistics.dao.CcdaValidationDAO;
import org.sitenv.common.statistics.dto.CcdaWeeklyCounts;
import org.sitenv.common.statistics.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository(value="CcdaValidationDAO")
public class CcdaValidationDAOImpl extends BaseDAOImpl implements CcdaValidationDAO {

	
	public void createCcdaValidation(String testType, Boolean hasErrors, Boolean hasWarnings,
			Boolean hasInfo, Boolean hasHttpError, String validator) {
		CcdaValidationEntity entity = new CcdaValidationEntity();
		
		entity.setErrors(hasErrors);
		entity.setWarnings(hasWarnings);
		entity.setInfo(hasInfo);
		entity.setHttpError(hasHttpError);
		entity.setValidationType(testType);
		entity.setValidator(validator);
		
		entityManager.persist(entity);
	}
	
	public void createSmartCcdaValidation(Boolean hasHttpError) {
		SmartCcdaValidationEntity entity = new SmartCcdaValidationEntity();
		
		entity.setHttpError(hasHttpError);
		
		entityManager.persist(entity);
	}

	public void createCcdaDownload() {
		CcdaDownloadEntity entity = new CcdaDownloadEntity();
		
		entityManager.persist(entity);
	}
	
	public void createCcdaReferenceDownload(String fileName) {
		CcdaReferenceDownloadEntity entity = new CcdaReferenceDownloadEntity();
		entity.setFileName(fileName);
		
		entityManager.persist(entity);
	}
	
	
	
	public Long getHttpErrorCount(Boolean hasHttpError, Integer numOfDays) {
		
		Long errorCount;
		
		if (numOfDays == null) {
			
			errorCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaValidationEntity t WHERE t.httpError = :boolval").setParameter("boolval", hasHttpError).getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaValidationEntity t WHERE t.httpError = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
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
			
			errorCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaValidationEntity t WHERE t.errors = :boolval AND t.httpError = false").setParameter("boolval", hasErrors).getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaValidationEntity t WHERE t.errors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
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
			
			warnCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaValidationEntity t WHERE t.warnings = :boolval AND t.httpError = false").setParameter("boolval", hasWarnings).getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaValidationEntity t WHERE t.warnings = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
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
			
			infoCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaValidationEntity t WHERE t.info = :boolval AND t.httpError = false").setParameter("boolval", hasInfo).getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaValidationEntity t WHERE t.info = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
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
			
			totalCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaValidationEntity t WHERE t.httpError = false").getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaValidationEntity t WHERE  t.httpError = false AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
			query.setParameter("currentDate", currentDbDate);
			query.setParameter("prevDate", pastDate);
			
			totalCount = (Long) query.getSingleResult();
			
		}
		
		return totalCount;
	}
	
	

	public Long getCcdaDownloadCount(Integer numOfDays) {
		
		Long downloadCount;
		
		if (numOfDays == null) {
			
			downloadCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaDownloadEntity t").getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.CcdaDownloadEntity t WHERE  t.timestamp < :currentDate AND t.timestamp > :prevDate");
			query.setParameter("currentDate", currentDbDate);
			query.setParameter("prevDate", pastDate);
			
			downloadCount = (Long) query.getSingleResult();
			
		}
		
		return downloadCount;
		
	}

	public Long getSmartCcdaCount(Boolean hasHttpError, Integer numOfDays) {
		
		Long totalCount;
		
		if (numOfDays == null) {
			
			totalCount = (Long) entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.SmartCcdaValidationEntity t WHERE t.httpError = :httperror").setParameter("httperror", hasHttpError).getSingleResult();
			
		} else {
			
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);
			
			Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.SmartCcdaValidationEntity t WHERE  t.httpError = :httperror AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
			query.setParameter("httperror", hasHttpError);
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

	
	public Long getCcdaLogCounts()
	{
		
		Query query = entityManager.createNativeQuery("SELECT CAST(SUM(ccdalog_count) AS INTEGER) total_ccda FROM ccda_log");
		
		Integer results = (Integer) query.getSingleResult();
		Long returnVal = null;
		
		if (results != null) {
				
				returnVal = results.longValue();
				
				
		}
		return returnVal;
		
		
	}

	
}
