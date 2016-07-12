package org.sitenv.common.statistics.manager;

import org.sitenv.common.statistics.dto.*;

import java.util.List;

public interface StatisticsManager {

	public static final Integer QRDA_CATEGORY_I = new Integer(1);
	public static final Integer QRDA_CATEGORY_III = new Integer(3);

	//TODO: Add Validator Type
	public void addCcdaValidation(String testType, Boolean hasErrors, Boolean hasWarnings, Boolean hasInfo, Boolean hasHttpError, String validator);
	public void addSmartCcdaValidation(Boolean hasHttpError);
	public void addCcdaDownload();
	public void addReferenceCcdaDownload(String fileName);

	public void addCcdaServiceCall(String testType, Boolean hasErrors, Boolean hasWarnings, Boolean hasInfo, Boolean hasHttpError, String validator);


	public Long getSuccessfulCcdaValidationCount(Integer numOfDays);
	public Long getFailedCcdaValidationCount(Integer numOfDays);
	public Long getHttpErrorCcdaValidationCount(Integer numOfDays);
	public Long getWarningCcdaValidationCount(Integer numOfDays);
	public Long getInfoCcdaValidationCount(Integer numOfDays);
	public Long getTotalCcdaValidationCount(Integer numOfDays);

	public Long getSmartCcdaCount(Integer numOfDays);
	public Long getSmartCcdaWithHttpErrorCount(Integer numOfDays);
	public Long getCcdaDownloadCount(Integer numOfDays);

	public List<CcdaWeeklyCounts> getCcdaWeeklyCounts(Integer numOfWeeks);
	public List<QrdaWeeklyCounts> getQrdaWeeklyCounts(Integer numOfWeeks);
	public List<PdtiWeeklyCounts> getPdtiWeeklyCounts(Integer numOfWeeks);
	public List<DirectWeeklyCounts> getDirectWeeklyCounts(Integer numOfWeeks, Boolean send);


	public void addQrdaValidation(Integer category, Boolean hasSchemaErrors, Boolean hasSchematronErrors, Boolean hasSchematronWarnings, Boolean hasHttpError);
	public Long getSuccessfulQrdaValidationCount(Integer category, Integer numOfDays);
	public Long getFailedQrdaValidationCount(Integer category, Integer numOfDays);
	public Long getWarningQrdaValidationCount(Integer category, Integer numOfDays);
	public Long getTotalQrdaValidationCount(Integer category, Integer numOfDays);
	public Long getHttpErrorQrdaValidationCount(Integer category, Integer numOfDays);



	public void addDirectReceive(String domain, Boolean uploaded, Boolean precanned, Boolean hasErrors);
	public void addDirectTrustUpload(Boolean hasErrors);
	public Long getSuccessfulDirectReceiveCount(Integer numOfDays);
	public Long getFailedDirectReceiveCount(Integer numOfDays);
	public Long getSuccessfulPrecannedDirectReceiveCount(Integer numOfDays);
	public Long getSuccessfulUploadedDirectReceiveCount(Integer numOfDays);
	public Long getSuccessfulTrustAnchorUploadCount(Integer numOfDays);
	public Long getFailedTrustAnchorUploadCount(Integer numOfDays);


	public void addPdtiTest(String endpointUrl, List<PdtiTestCase> testCases);
	public Long getSuccessfulPdtiTestCount(Integer numOfDays);
	public Long getFailedPdtiTestCount(Integer numOfDays);
	public Long getTotalPdtiTestCount(Integer numOfDays);
	public Long getHttpErrorPdtiTestCount(Integer numOfDays);


	public void addDcdtHostingVerification(String testcase, String directAddress, String response , String dcdtVersion);

	public List<AggregateWeeklyCounts> getAggregateWeeklyCounts(Integer numOfWeeks);

	public Long getJiraIssuesCreatedCount(Integer numOfDays);
	public Long getJiraIssuesResolvedCount(Integer numOfDays);

	public GoogleAnalyticsData getGoogleAnalyticsData(String p12CertPath);

	public DirectLogCounts getDirectSendLogCount();

	public DirectLogCounts getDirectReceiveLogCount();

	public Long getCcdaLogCounts();

	public void addXdrReceive(String wsdl, String from,	String to, String messageType, Boolean precanned, Boolean uploaded, Boolean hasErrors);

	public void addXdrSendSearch(String value, Boolean hasErrors);

	public void addSMTPReceive(String domain, String from, String to, Boolean precanned, Boolean uploaded, Boolean hasErrors);
	public void addSMTPSendSearch(String value, Boolean hasErrors);
	public SmtpSearchLogCounts getSmtpSendLogCount();
	public Long getSuccessfulSmtpReceiveCount(Integer numberOfDays);
	public List<SmtpWeeklyCounts> getSmtpWeeklyCounts(Integer smallWeeklyStatisticsLimit, boolean b);

}
