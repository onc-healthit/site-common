package org.sitenv.common.statistics.dao;

import org.sitenv.common.statistics.dto.CcdaWeeklyCounts;

import java.util.List;

public interface CcdaValidationDAO {
	
	public void createCcdaValidation(String testType, Boolean hasErrors, Boolean hasWarnings, Boolean hasInfo, Boolean hasHttpError, String validator);
	
	public void createSmartCcdaValidation(Boolean hasHttpError);
	
	public void createCcdaDownload();
	
	public void createCcdaReferenceDownload(String fileName);
	
	
	public Long getErrorCount(Boolean hasErrors, Integer numOfDays);
	
	public Long getWarningCount(Boolean hasWarnings, Integer numOfDays);
	
	public Long getInfoCount(Boolean hasInfo, Integer numOfDays);
	
	public Long getTotalCount(Integer numOfDays);
	
	public Long getHttpErrorCount(Boolean hasHttpError, Integer numOfDays);
	
	
	public Long getCcdaDownloadCount(Integer numOfDays);
	
	public Long getSmartCcdaCount(Boolean hasHttpError, Integer numOfDays);
	
	public List<CcdaWeeklyCounts> getCcdaWeeklyCounts(Integer numOfWeeks);

	public Long getCcdaLogCounts();
}
