package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="direct_receive")
public class DirectReceiveEntity {

	
	@Id
	@Column(name="directreceive_pk")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Basic(optional = false)
	@Column(name = "directreceive_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="directreceive_errors")
	private Boolean errors;

	@Column(name="directreceive_precanned")
	private Boolean precanned;

	@Column(name="directreceive_uploaded")
	private Boolean uploaded;
	
	@Column(name="directreceive_domain")
	private String domain;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((precanned == null) ? 0 : precanned.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result
				+ ((uploaded == null) ? 0 : uploaded.hashCode());
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
		DirectReceiveEntity other = (DirectReceiveEntity) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (precanned == null) {
			if (other.precanned != null)
				return false;
		} else if (!precanned.equals(other.precanned))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (uploaded == null) {
			if (other.uploaded != null)
				return false;
		} else if (!uploaded.equals(other.uploaded))
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

	public Boolean getErrors() {
		return errors;
	}

	public void setErrors(Boolean errors) {
		this.errors = errors;
	}

	public Boolean getPrecanned() {
		return precanned;
	}

	public void setPrecanned(Boolean precanned) {
		this.precanned = precanned;
	}

	public Boolean getUploaded() {
		return uploaded;
	}

	public void setUploaded(Boolean uploaded) {
		this.uploaded = uploaded;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		if (domain != null)
		{	
			this.domain = (domain.length() > 1000) ? domain.toUpperCase().substring(0, 1000) : domain.toUpperCase();
		}
		else
		{
			this.domain = null;
		}
				
	}

	
}
