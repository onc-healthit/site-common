package org.sitenv.common.statistics.dao;

public interface XdrTransmissionDAO {

	public void createXdrReceive(String wsdl, String from,	String to, String messageType, Boolean precanned, Boolean uploaded, Boolean hasErrors);
	
	public void createXdrSendSearch(String value, Boolean hasErrors);
	
}
