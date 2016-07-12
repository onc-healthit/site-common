package org.sitenv.common.statistics.dao.impl;

import org.sitenv.common.statistics.dao.QrdaValidationDAO;
import org.sitenv.common.statistics.dto.QrdaWeeklyCounts;
import org.sitenv.common.statistics.entity.QrdaValidationEntity;
import org.sitenv.common.statistics.entity.QrdaWeeklyCountsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository(value = "QrdaValidationDAO")
public class QrdaValidationDAOImpl extends BaseDAOImpl implements
		QrdaValidationDAO {

	public void createQrdaValidation(Integer category, Boolean hasSchemaErrors, Boolean hasSchematronErrors, Boolean hasSchematronWarnings, Boolean hasHttpError)
	{

		QrdaValidationEntity entity = new QrdaValidationEntity();

		entity.setSchemaErrors(hasSchemaErrors);
		entity.setSchematronWarnings(hasSchematronWarnings);
		entity.setSchematronErrors(hasSchematronErrors);
		entity.setHttpError(hasHttpError);
		entity.setCategory(category);

		entityManager.persist(entity);

	}

	public Long getSchemaErrorCount(Integer category, Boolean hasErrors,
			Integer numOfDays) {

		Long errorCount;

		if (category == null) {

			if (numOfDays == null) {

				errorCount = (Long) entityManager
						.createQuery(
								"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schemaErrors = :boolval AND t.httpError = false")
						.setParameter("boolval", hasErrors).getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schemaErrors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
				query.setParameter("boolval", hasErrors);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);

				errorCount = (Long) query.getSingleResult();

			}
		} else {
			if (numOfDays == null) {

				Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schemaErrors = :boolval and t.category = :category AND t.httpError = false");
				
				query.setParameter("boolval", hasErrors);
				query.setParameter("category", category);
				
				errorCount = (Long) query.getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schemaErrors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.category = :category AND t.httpError = false");
				query.setParameter("boolval", hasErrors);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);
				query.setParameter("category", category);

				errorCount = (Long) query.getSingleResult();

			}
		}

		return errorCount;
	}
	
	public Long getSchematronErrorCount(Integer category, Boolean hasErrors,
			Integer numOfDays) {

		Long errorCount;

		if (category == null) {

			if (numOfDays == null) {

				errorCount = (Long) entityManager
						.createQuery(
								"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schematronErrors = :boolval AND t.httpError = false")
						.setParameter("boolval", hasErrors).getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schematronErrors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
				query.setParameter("boolval", hasErrors);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);

				errorCount = (Long) query.getSingleResult();

			}
		} else {
			if (numOfDays == null) {

				Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schematronErrors = :boolval and t.category = :category AND t.httpError = false");
				
				query.setParameter("boolval", hasErrors);
				query.setParameter("category", category);
				
				errorCount = (Long) query.getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schematronErrors = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.category = :category AND t.httpError = false");
				query.setParameter("boolval", hasErrors);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);
				query.setParameter("category", category);

				errorCount = (Long) query.getSingleResult();

			}
		}

		return errorCount;
	}
	
	public Long getTotalErrorCount(Integer category, Integer numOfDays) {

		Long errorCount;

		if (category == null) {

			if (numOfDays == null) {

				errorCount = (Long) entityManager
						.createQuery(
								"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE (t.schematronErrors = true OR t.schemaErrors = true) AND t.httpError = false").getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE (t.schematronErrors = true OR t.schemaErrors = true ) AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);
				
				errorCount = (Long) query.getSingleResult();

			}
		} else {
			if (numOfDays == null) {

				Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE (t.schematronErrors = true OR t.schemaErrors = true) and t.category = :category AND t.httpError = false");
				
				query.setParameter("category", category);
				
				errorCount = (Long) query.getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE (t.schematronErrors = true OR t.schemaErrors = true) AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.category = :category AND t.httpError = false");
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);
				query.setParameter("category", category);

				errorCount = (Long) query.getSingleResult();

			}
		}

		return errorCount;
	}
	
	public Long getTotalNonErrorCount(Integer category, Integer numOfDays) {

		Long errorCount;

		if (category == null) {

			if (numOfDays == null) {

				errorCount = (Long) entityManager
						.createQuery(
								"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE (t.schematronErrors = false AND t.schemaErrors = false) AND t.httpError = false")
						.getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE (t.schematronErrors = false AND t.schemaErrors = false) AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);

				errorCount = (Long) query.getSingleResult();

			}
		} else {
			if (numOfDays == null) {

				Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE (t.schematronErrors = false AND t.schemaErrors = false) and t.category = :category AND t.httpError = false");
				
				query.setParameter("category", category);
				
				errorCount = (Long) query.getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE (t.schematronErrors = false AND t.schemaErrors = false) AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.category = :category AND t.httpError = false");
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);
				query.setParameter("category", category);

				errorCount = (Long) query.getSingleResult();

			}
		}

		return errorCount;
	}

	public Long getSchematronWarningCount(Integer category, Boolean hasWarnings,
			Integer numOfDays) {

		Long warningCount;

		if (category == null) {

			if (numOfDays == null) {

				warningCount = (Long) entityManager
						.createQuery(
								"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schematronWarnings = :boolval AND t.httpError = false")
						.setParameter("boolval", hasWarnings).getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schematronWarnings = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.httpError = false");
				query.setParameter("boolval", hasWarnings);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);

				warningCount = (Long) query.getSingleResult();

			}
		} else {
			if (numOfDays == null) {

				Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schematronWarnings = :boolval and t.category = :category AND t.httpError = false");
				
				query.setParameter("boolval", hasWarnings);
				query.setParameter("category", category);
				
				warningCount = (Long) query.getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.schematronWarnings = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.category = :category AND t.httpError = false");
				query.setParameter("boolval", hasWarnings);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);
				query.setParameter("category", category);

				warningCount = (Long) query.getSingleResult();

			}
		}

		return warningCount;
	}


	public Long getTotalCount(Integer category, Integer numOfDays) {

		Long totalCount;

		if (category == null) {

			if (numOfDays == null) {

				totalCount = (Long) entityManager
						.createQuery(
								"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.httpError = false").getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.httpError = false AND t.timestamp < :currentDate AND t.timestamp > :prevDate ");
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);

				totalCount = (Long) query.getSingleResult();

			}
		} else {
			if (numOfDays == null) {

				Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.httpError = false and t.category = :category");
				
				query.setParameter("category", category);
				
				totalCount = (Long) query.getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.httpError = false AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.category = :category");
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);
				query.setParameter("category", category);

				totalCount = (Long) query.getSingleResult();

			}
		}

		return totalCount;
	}

	public Long getHttpErrorCount(Integer category, Boolean hasHttpError,
			Integer numOfDays) {

		Long httpErrorCount;

		if (category == null) {

			if (numOfDays == null) {

				httpErrorCount = (Long) entityManager
						.createQuery(
								"SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.httpError = :boolval")
						.setParameter("boolval", hasHttpError).getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.httpError = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate");
				query.setParameter("boolval", hasHttpError);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);

				httpErrorCount = (Long) query.getSingleResult();

			}
		} else {
			if (numOfDays == null) {

				Query query = entityManager.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.httpError = :boolval and t.category = :category");
				
				query.setParameter("boolval", hasHttpError);
				query.setParameter("category", category);
				
				httpErrorCount = (Long) query.getSingleResult();

			} else {

				Date currentDbDate = this.getSystemDate();
				Date pastDate = this.getPreviousDate(currentDbDate, numOfDays);

				Query query = entityManager
						.createQuery("SELECT COUNT(t) FROM org.sitenv.common.statistics.entity.QrdaValidationEntity t WHERE t.httpError = :boolval AND t.timestamp < :currentDate AND t.timestamp > :prevDate AND t.category = :category");
				query.setParameter("boolval", hasHttpError);
				query.setParameter("currentDate", currentDbDate);
				query.setParameter("prevDate", pastDate);
				query.setParameter("category", category);

				httpErrorCount = (Long) query.getSingleResult();

			}
		}

		return httpErrorCount;
	}
	
	@SuppressWarnings("unchecked")
	public List<QrdaWeeklyCounts> getQrdaValidationsWeeklyCounts(Integer numOfWeeks) {
		
		List<QrdaWeeklyCounts> returnVal = null;
		
		Query query = entityManager.createNamedQuery("qrdaValidationWeeklyCounts", QrdaWeeklyCountsEntity.class);
		query.setParameter(1, numOfWeeks);
		
		List<QrdaWeeklyCountsEntity> results = query.getResultList();
		
		if (results != null) {
			for(QrdaWeeklyCountsEntity result : results) {
				if (returnVal == null)
				{
					returnVal = new ArrayList<QrdaWeeklyCounts>();
				}
				
				QrdaWeeklyCounts count = new QrdaWeeklyCounts();
				count.setEndDate(result.getEndDate());
				count.setInterval(result.getInterval());
				count.setStartDate(result.getStartDate());
				count.setYear(result.getYear());
				count.setCategory1Count(result.getCategory1Count());
				count.setCategory3Count(result.getCategory3Count());
				
				returnVal.add(count);
				
			}
		}
		
		return returnVal;
	}

}
