package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="smartccda_validations")
public class SmartCcdaValidationEntity {

	@Id
	@Column(name="smartvalidation_pk")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic(optional = false)
	@Column(name = "smartvalidation_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="smartvalidation_httperror")
	private Boolean httpError;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((httpError == null) ? 0 : httpError.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
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
		SmartCcdaValidationEntity other = (SmartCcdaValidationEntity) obj;
		if (httpError == null) {
			if (other.httpError != null)
				return false;
		} else if (!httpError.equals(other.httpError))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
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

	public Boolean getHttpError() {
		return httpError;
	}

	public void setHttpError(Boolean httpError) {
		this.httpError = httpError;
	}
	
}
