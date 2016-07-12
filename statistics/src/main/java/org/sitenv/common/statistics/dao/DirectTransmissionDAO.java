package org.sitenv.common.statistics.dao;

import org.sitenv.common.statistics.dto.DirectLogCounts;
import org.sitenv.common.statistics.dto.DirectWeeklyCounts;

import java.util.List;

public interface DirectTransmissionDAO {

	public void createDirectReceive(String domain, Boolean precanned, Boolean uploaded, Boolean hasErrors);
	
	public void createDirectTrustUpload(Boolean hasErrors);
	
	
	public Long getDirectReceivePrecannedCount(Boolean precanned, Boolean hasErrors, Integer numOfDays);
	
	public Long getDirectReceiveUploadCount(Boolean upload, Boolean hasErrors, Integer numOfDays);
	
	public Long getDirectReceiveCount(Boolean hasErrors, Integer numberOfDays);
	

	public Long getDirectTrustUploadCount(Boolean hasErrors, Integer numberOfDays);
	
	public DirectLogCounts getDirectSendLogCount();
	
	public DirectLogCounts getDirectReceiveLogCount();
	
	public List<DirectWeeklyCounts> getDirectWeeklyCounts(Integer numOfWeeks, Boolean send);
}
