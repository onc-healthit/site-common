package org.sitenv.common.statistics.dao.impl;

import org.sitenv.common.statistics.dao.XdrTransmissionDAO;
import org.sitenv.common.statistics.entity.XdrReceiveEntity;
import org.sitenv.common.statistics.entity.XdrSendSearchEntity;
import org.springframework.stereotype.Repository;

@Repository(value="XdrTransmissionDAO")
public class XdrTransmissionDAOImpl extends BaseDAOImpl implements XdrTransmissionDAO {

	public void createXdrReceive(String wsdl, String from, String to,
			String messageType, Boolean precanned, Boolean uploaded,
			Boolean hasErrors) {
		
		XdrReceiveEntity entity = new XdrReceiveEntity();
		
		entity.setErrors(hasErrors);
		entity.setFrom(from);
		entity.setMessageType(messageType);
		entity.setPrecanned(precanned);
		entity.setTo(to);
		entity.setUploaded(uploaded);
		
		if (wsdl != null) {
			entity.setWsdl(wsdl.substring(0, Math.min(wsdl.length(), 1000)));
		}
		
		entityManager.persist(entity);
		
	}

	public void createXdrSendSearch(String value, Boolean hasErrors) {
		
		XdrSendSearchEntity entity = new XdrSendSearchEntity();
		
		entity.setError(hasErrors);
		entity.setValue(value);
		
		entityManager.persist(entity);
	}

}
