package org.sitenv.common.statistics.dao.impl;

import org.sitenv.common.statistics.dao.DirectTransmissionDAO;
import org.sitenv.common.statistics.dto.DirectLogCounts;
import org.sitenv.common.statistics.dto.DirectWeeklyCounts;
import org.sitenv.common.statistics.entity.DirectLogCountsEntity;
import org.sitenv.common.statistics.entity.DirectReceiveEntity;
import org.sitenv.common.statistics.entity.DirectTrustUploadEntity;
import org.sitenv.common.statistics.entity.DirectWeeklyCountsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository(value="DirectTransmissionDAO")
public class DirectTransmissionDAOImpl extends BaseDAOImpl implements DirectTransmissionDAO {

	public void createDirectReceive(String domain, Boolean precanned, Boolean uploaded,
			Boolean hasErrors) {
		DirectReceiveEntity entity = new DirectReceiveEntity();

		entity.setPrecanned(precanned);
		entity.setUploaded(uploaded);
		entity.setErrors(hasErrors);
		entity.setDomain(domain);

		entityManager.persist(entity);
	}

	public void createDirectTrustUpload(Boolean hasErrors) {
		
		DirectTrustUploadEntity entity = new DirectTrustUploadEntity();

		entity.setErrors(hasErrors);

		entityManager.persist(entity);
		
	}

	public Long getDirectReceivePrecannedCount(Boolean precanned,
			Boolean hasErrors, Integer numOfDays) {
		
		Long errorCount;

		if (precanned == null) {

			if (numOfDays == null) {

				errorCount = (Long) entityManager
						.createQuery(
								"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval")
						.setParameter("boolval", hasErrors).getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
				query.setParameter("boolval", hasErrors);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);

				errorCount = (Long) query.getSingleResult();

			}
		} else {
			if (numOfDays == null) {

				Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval and t.precanned = :precanned");
				
				query.setParameter("boolval", hasErrors);
				query.setParameter("precanned", precanned);
				
				errorCount = (Long) query.getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.precanned = :precanned");
				query.setParameter("boolval", hasErrors);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);
				query.setParameter("precanned", precanned);

				errorCount = (Long) query.getSingleResult();

			}
		}

		return errorCount;
	}

	public Long getDirectReceiveUploadCount(Boolean upload, Boolean hasErrors,
			Integer numOfDays) {
		Long errorCount;

		if (upload == null) {

			if (numOfDays == null) {

				errorCount = (Long) entityManager
						.createQuery(
								"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval")
						.setParameter("boolval", hasErrors).getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
				query.setParameter("boolval", hasErrors);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);

				errorCount = (Long) query.getSingleResult();

			}
		} else {
			if (numOfDays == null) {

				Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval and t.uploaded = :upload");
				
				query.setParameter("boolval", hasErrors);
				query.setParameter("upload", upload);
				
				errorCount = (Long) query.getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.uploaded = :upload");
				query.setParameter("boolval", hasErrors);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);
				query.setParameter("upload", upload);

				errorCount = (Long) query.getSingleResult();

			}
		}

		return errorCount;
	}

	public Long getDirectReceiveCount(Boolean hasErrors, Integer numberOfDays) {
		Long errorCount;

		if (numberOfDays == null) {

				errorCount = (Long) entityManager
						.createQuery(
								"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval")
						.setParameter("boolval", hasErrors).getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numberOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
				query.setParameter("boolval", hasErrors);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);

				errorCount = (Long) query.getSingleResult();

			}
		

		return errorCount;
	}

	public Long getDirectTrustUploadCount(Boolean hasErrors,
			Integer numberOfDays) {
		Long errorCount;

		if (numberOfDays == null) {

			errorCount = (Long) entityManager
					.createQuery(
							"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval")
					.setParameter("boolval", hasErrors).getSingleResult();

		} else {

			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numberOfDays);

			Query query = entityManager
					.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.DirectReceiveEntity t WHERE t.errors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
			query.setParameter("boolval", hasErrors);
			query.setParameter("currentDate", currentDbDate);
			query.setParameter("prevDate", pastDate);

			errorCount = (Long) query.getSingleResult();

		}
	

	return errorCount;
	}
	
	@SuppressWarnings("unchecked")
	public List<DirectWeeklyCounts> getDirectWeeklyCounts(Integer numOfWeeks, Boolean send) {
		
		List<DirectWeeklyCounts> returnVal = null;
		
		Query query;
		
		if (send)
			query = entityManager.createNamedQuery("directSendWeeklyCounts", DirectWeeklyCountsEntity.class);
		else
			query = entityManager.createNamedQuery("directReceiveWeeklyCounts", DirectWeeklyCountsEntity.class);
		query.setParameter(1, numOfWeeks);
		
		List<DirectWeeklyCountsEntity> results = query.getResultList();
		
		if (results != null) {
			for(DirectWeeklyCountsEntity result : results) {
				if (returnVal == null)
				{
					returnVal = new ArrayList<DirectWeeklyCounts>();
				}
				
				DirectWeeklyCounts count = new DirectWeeklyCounts();
				count.setEndDate(result.getEndDate());
				count.setInterval(result.getInterval());
				count.setStartDate(result.getStartDate());
				count.setTotalCount(result.getTotalCount());
				count.setTotalUniqueDomainCount(result.getTotalUniqueDomainCount());
				count.setYear(result.getYear());
				
				returnVal.add(count);
				
			}
		}
		
		return returnVal;
		
	}

	public DirectLogCounts getDirectSendLogCount() {

		
		Query query = entityManager.createNamedQuery("directsend_log_counts", DirectLogCountsEntity.class);
		
		DirectLogCountsEntity results = (DirectLogCountsEntity) query.getSingleResult();
		DirectLogCounts returnVal = null;
		
		if (results != null) {
				
				returnVal = new DirectLogCounts();
				returnVal.setDistinctDomainsCount(results.getDistinctDomainsCount());
				returnVal.setTotalDirectMessageCount(results.getTotalDirectMessageCount());
				
		}
		
		return returnVal;
	}

	public DirectLogCounts getDirectReceiveLogCount() {
		
		Query query = entityManager.createNamedQuery("directreceive_log_counts", DirectLogCountsEntity.class);
		
		DirectLogCountsEntity results = (DirectLogCountsEntity) query.getSingleResult();
		DirectLogCounts returnVal = null;
		
		if (results != null) {
				
				returnVal = new DirectLogCounts();
				returnVal.setDistinctDomainsCount(results.getDistinctDomainsCount());
				returnVal.setTotalDirectMessageCount(results.getTotalDirectMessageCount());
				
		}
		
		return returnVal;
	}

}
