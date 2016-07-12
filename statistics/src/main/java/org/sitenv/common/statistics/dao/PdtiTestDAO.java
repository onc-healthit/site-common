package org.sitenv.common.statistics.dao;

import org.sitenv.common.statistics.dto.PdtiTestCase;
import org.sitenv.common.statistics.dto.PdtiWeeklyCounts;

import java.util.List;

public interface PdtiTestDAO {

	public void createPdtiTest(String endpointUrl, List<PdtiTestCase> testCases);
	
	
	public Long getPdtiTestCaseCount(String testcaseName, Boolean pass, Integer numOfDays);
	
	public Long getHttpErrorCount(Boolean hasHttpError, Integer numOfDays);
	
	public List<PdtiWeeklyCounts> getTestCasesWeeklyCounts(Integer numOfWeeks);
}
