package org.sitenv.common.statistics.dao.impl;

import org.sitenv.common.statistics.dao.DcdtHostingVerificationDAO;
import org.sitenv.common.statistics.entity.DcdtHostingVerificationEntity;
import org.springframework.stereotype.Repository;

@Repository(value = "DcdtHostingVerificationDAO")
public class DcdtHostingVerificationDAOImpl extends BaseDAOImpl implements DcdtHostingVerificationDAO 
{
	public void createDcdtHostingVerification(String testcase, String directAddress, String response , String dcdtVersion) 
	{
		DcdtHostingVerificationEntity entity = new DcdtHostingVerificationEntity();
		entity.setVerificationTestcase(testcase);
		entity.setVerificationDirectAddress(directAddress);
		entity.setVerificationResponse(response);
		entity.setDcdtVersion(dcdtVersion);
		entityManager.persist(entity);
	}
}
