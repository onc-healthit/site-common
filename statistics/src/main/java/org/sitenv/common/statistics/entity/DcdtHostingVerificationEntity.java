package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="dcdt_hosting_verification")
public class DcdtHostingVerificationEntity 
{		
	@Id
	@Column(name="verification_pk")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Basic(optional = false)
	@Column(name = "verification_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="verification_testcase")
	private String verificationTestcase;
	
	@Column(name="verification_direct_address")
	private String verificationDirectAddress;

	@Column(name="verification_response")
	private String verificationResponse;
	
	@Column(name="dcdt_version")
	private String dcdtVersion = "2014";

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((verificationTestcase == null) ? 0 : verificationTestcase.hashCode());
		result = prime * result + ((verificationDirectAddress == null) ? 0 : verificationDirectAddress.hashCode());
		result = prime * result + ((verificationResponse == null) ? 0 : verificationResponse.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((dcdtVersion == null) ? 0 : dcdtVersion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DcdtHostingVerificationEntity other = (DcdtHostingVerificationEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (verificationTestcase == null) {
			if (other.verificationTestcase != null)
				return false;
		} else if (!verificationTestcase.equals(other.verificationTestcase))
			return false;
		if (verificationDirectAddress == null) {
			if (other.verificationDirectAddress != null)
				return false;
		} else if (!verificationDirectAddress.equals(other.verificationDirectAddress))
			return false;
		if (verificationResponse == null) {
			if (other.verificationResponse != null)
				return false;
		} else if (!verificationResponse.equals(other.verificationResponse))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (dcdtVersion == null) {
			if (other.dcdtVersion != null)
				return false;
		} else if (!dcdtVersion.equals(other.dcdtVersion))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getVerificationTestcase() {
		return verificationTestcase;
	}

	public void setVerificationTestcase(String verificationTestcase) {
		this.verificationTestcase = verificationTestcase;
	}

	public String getVerificationDirectAddress() {
		return verificationDirectAddress;
	}

	public void setVerificationDirectAddress(String verificationDirectAddress) {
		this.verificationDirectAddress = verificationDirectAddress;
	}

	public String getVerificationResponse() {
		return verificationResponse;
	}

	public void setVerificationResponse(String verificationResponse) {
		this.verificationResponse = verificationResponse;
	}

	public String getDcdtVersion() {
		return dcdtVersion;
	}

	public void setDcdtVersion(String dcdtVersion) {
		this.dcdtVersion = dcdtVersion;
	}
	
	
}
