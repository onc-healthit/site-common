package org.sitenv.common.statistics.dao;

import org.sitenv.common.statistics.dto.SmtpSearchLogCounts;
import org.sitenv.common.statistics.dto.SmtpWeeklyCounts;

import java.util.List;

public interface SmtpTransmissionDAO {

	public void createSMTPReceive(String domain, String from, String to, Boolean precanned, Boolean uploaded, Boolean hasErrors);
	
	public void createSMTPSearch(String value, Boolean hasErrors);
	
	public SmtpSearchLogCounts getSmtpSearchLogCount();

	public Long getSmtpReceiveCount(boolean b, Integer numberOfDays);

	public List<SmtpWeeklyCounts> getSmtpWeeklyCounts(Integer numOfWeeks, boolean send);
	
}
