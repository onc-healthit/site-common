package org.sitenv.common.statistics.dao.impl;

import org.sitenv.common.statistics.dao.SmtpTransmissionDAO;
import org.sitenv.common.statistics.dto.SmtpSearchLogCounts;
import org.sitenv.common.statistics.dto.SmtpWeeklyCounts;
import org.sitenv.common.statistics.entity.SmtpLogCountsEntity;
import org.sitenv.common.statistics.entity.SmtpReceiveEntity;
import org.sitenv.common.statistics.entity.SmtpSearchEntity;
import org.sitenv.common.statistics.entity.SmtpWeeklyCountsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository(value="smtpTransmissionDAO")
public class SmtpTransmissionDAOImpl extends BaseDAOImpl implements SmtpTransmissionDAO {

	public void createSMTPReceive(String domain, String from, String to, Boolean precanned, Boolean uploaded,
			Boolean hasErrors) {
		SmtpReceiveEntity entity = new SmtpReceiveEntity();
		entity.setErrors(hasErrors);
		entity.setFrom(from);
		entity.setPrecanned(precanned);
		entity.setTo(to);
		entity.setUploaded(uploaded);
		entity.setDomain(domain);
		entityManager.persist(entity);
	}

	public void createSMTPSearch(String value, Boolean hasErrors) {
		SmtpSearchEntity entity = new SmtpSearchEntity();
		entity.setError(hasErrors);
		entity.setValue(value);
		entityManager.persist(entity);
	}

	public SmtpSearchLogCounts getSmtpSearchLogCount() {
		Query query = entityManager.createNamedQuery("smtpsearch_counts", SmtpLogCountsEntity.class);

		SmtpLogCountsEntity results = (SmtpLogCountsEntity) query.getSingleResult();
		SmtpSearchLogCounts returnVal = null;

		if (results != null) {
			returnVal = new SmtpSearchLogCounts();
			returnVal.setDistinctDomainsSearchedCount(results.getDistinctDomainsCount());
			returnVal.setTotalSmtpSearchCount(results.getTotalSearchesCount());
		}
		return returnVal;
	}

	public Long getSmtpReceiveCount(boolean hasErrors, Integer numberOfDays) {
		Long errorCount;

		if (numberOfDays == null) {
			errorCount = (Long) entityManager
					.createQuery(
							"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.SmtpReceiveEntity t WHERE t.errors = :boolval")
							.setParameter("boolval", hasErrors).getSingleResult();
		} else {
			Date currentDbDate = this.getSystemDate();
			Date pastDate = this.getPreviousDate(currentDbDate, numberOfDays);

			Query query = entityManager
					.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.SmtpReceiveEntity t WHERE t.errors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
			query.setParameter("boolval", hasErrors);
			query.setParameter("currentDate", currentDbDate);
			query.setParameter("prevDate", pastDate);

			errorCount = (Long) query.getSingleResult();
		}

		return errorCount;
	}

	public List<SmtpWeeklyCounts> getSmtpWeeklyCounts(Integer numOfWeeks, boolean send) {
		List<SmtpWeeklyCounts> returnVal = null;
		Query query;
		if (send)
			query = entityManager.createNamedQuery("smtpSendWeeklyCounts", SmtpWeeklyCountsEntity.class);
		else
			query = entityManager.createNamedQuery("smtpReceiveWeeklyCounts", SmtpWeeklyCountsEntity.class);
		query.setParameter(1, numOfWeeks);

		List<SmtpWeeklyCountsEntity> results = query.getResultList();

		if (results != null) {
			for(SmtpWeeklyCountsEntity result : results) {
				if (returnVal == null){
					returnVal = new ArrayList<SmtpWeeklyCounts>();
				}
				SmtpWeeklyCounts count = new SmtpWeeklyCounts();
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

}
