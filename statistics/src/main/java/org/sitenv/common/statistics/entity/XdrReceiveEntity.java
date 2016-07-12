package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="xdr_receive")
public class XdrReceiveEntity {

	
	@Id
	@Column(name="xdrreceive_pk")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Basic(optional = false)
	@Column(name = "xdrreceive_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="xdrreceive_errors")
	private Boolean errors;

	@Column(name="xdrreceive_precanned")
	private Boolean precanned;

	@Column(name="xdrreceive_uploaded")
	private Boolean uploaded;
	
	@Column(name="xdrreceive_wsdl")
	private String wsdl;
	
	@Column(name="xdrreceive_from")
	private String from;
	
	@Column(name="xdrreceive_to")
	private String to;
	
	@Column(name="xdrreceive_messagetype")
	private String messageType;

	public XdrReceiveEntity(Long id, Date timestamp, Boolean errors,
			Boolean precanned, Boolean uploaded, String wsdl, String from,
			String to, String messageType) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.errors = errors;
		this.precanned = precanned;
		this.uploaded = uploaded;
		this.wsdl = wsdl;
		this.from = from;
		this.to = to;
		this.messageType = messageType;
	}

	public XdrReceiveEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((messageType == null) ? 0 : messageType.hashCode());
		result = prime * result
				+ ((precanned == null) ? 0 : precanned.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result
				+ ((uploaded == null) ? 0 : uploaded.hashCode());
		result = prime * result + ((wsdl == null) ? 0 : wsdl.hashCode());
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
		XdrReceiveEntity other = (XdrReceiveEntity) obj;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (messageType == null) {
			if (other.messageType != null)
				return false;
		} else if (!messageType.equals(other.messageType))
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
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (uploaded == null) {
			if (other.uploaded != null)
				return false;
		} else if (!uploaded.equals(other.uploaded))
			return false;
		if (wsdl == null) {
			if (other.wsdl != null)
				return false;
		} else if (!wsdl.equals(other.wsdl))
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

	public String getWsdl() {
		return wsdl;
	}

	public void setWsdl(String wsdl) {
		this.wsdl = wsdl;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
	

}
