package org.sitenv.common.statistics.dao;

import org.sitenv.common.statistics.dto.QrdaWeeklyCounts;

import java.util.List;

public interface QrdaValidationDAO {

	
	
	public void createQrdaValidation(Integer category, Boolean hasSchemaErrors, Boolean hasSchematronErrors, Boolean hasSchematronWarnings, Boolean hasHttpError);
	
	public Long getSchemaErrorCount(Integer category, Boolean hasErrors, Integer numOfDays);
	
	public Long getSchematronErrorCount(Integer category, Boolean hasErrors, Integer numOfDays);
	
	public Long getTotalErrorCount(Integer category, Integer numberOfDays);
	
	public Long getTotalNonErrorCount(Integer category, Integer numberOfDays);
	
	public Long getSchematronWarningCount(Integer category, Boolean hasWarnings, Integer numOfDays);
	
	public Long getTotalCount(Integer category, Integer numOfDays);
	
	public Long getHttpErrorCount(Integer category, Boolean hasHttpError, Integer numOfDays);
	
	public List<QrdaWeeklyCounts> getQrdaValidationsWeeklyCounts(Integer numOfWeeks);
}
