package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="xdr_send_search")
public class XdrSendSearchEntity {

	
	@Id
	@Column(name="search_pk")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Basic(optional = false)
	@Column(name = "search_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="search_error")
	private Boolean error;

	@Column(name="search_value")
	private String value;

	public XdrSendSearchEntity(Long id, Date timestamp, Boolean error,
			String value) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.error = error;
		this.value = value;
	}
	
	

	public XdrSendSearchEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		XdrSendSearchEntity other = (XdrSendSearchEntity) obj;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
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
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
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

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
