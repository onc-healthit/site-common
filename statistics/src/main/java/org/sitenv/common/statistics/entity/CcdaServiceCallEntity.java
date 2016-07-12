package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ccda_service_calls")
public class CcdaServiceCallEntity {

@Id
@Column(name="validation_pk")
@GeneratedValue( strategy = GenerationType.IDENTITY )
private Long id;

@Basic(optional = false)
@Column(name = "validation_time", insertable = false, updatable = false)
@Temporal(TemporalType.TIMESTAMP)
private Date timestamp;

@Column(name="validation_errors")
private Boolean errors;

@Column(name="validation_warnings")
private Boolean warnings;

@Column(name="validation_info")
private Boolean info;

@Column(name="validation_httperror")
private Boolean httpError;

@Column(name="validation_type")
private String validationType;

@Column(name="validator")
private String validator;



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((errors == null) ? 0 : errors.hashCode());
	result = prime * result + ((httpError == null) ? 0 : httpError.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((info == null) ? 0 : info.hashCode());
	result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
	result = prime * result
			+ ((validationType == null) ? 0 : validationType.hashCode());
	result = prime * result + ((warnings == null) ? 0 : warnings.hashCode());
	result = prime * result + ((validator == null) ? 0 : validator.hashCode());
	
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
	CcdaServiceCallEntity other = (CcdaServiceCallEntity) obj;
	if (errors == null) {
		if (other.errors != null)
			return false;
	} else if (!errors.equals(other.errors))
		return false;
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
	if (info == null) {
		if (other.info != null)
			return false;
	} else if (!info.equals(other.info))
		return false;
	if (timestamp == null) {
		if (other.timestamp != null)
			return false;
	} else if (!timestamp.equals(other.timestamp))
		return false;
	if (validationType == null) {
		if (other.validationType != null)
			return false;
	} else if (!validationType.equals(other.validationType))
		return false;
	if (warnings == null) {
		if (other.warnings != null)
			return false;
	} else if (!warnings.equals(other.warnings))
		return false;
	return true;
}

public Boolean getHttpError() {
	return httpError;
}

public void setHttpError(Boolean httpError) {
	this.httpError = httpError;
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

public Boolean getWarnings() {
	return warnings;
}

public void setWarnings(Boolean warnings) {
	this.warnings = warnings;
}

public Boolean getInfo() {
	return info;
}

public void setInfo(Boolean info) {
	this.info = info;
}

public String getValidationType() {
	return validationType;
}

public void setValidationType(String validationType) {
	this.validationType = validationType;
}

public String getValidator() {
	return validator;
}

public void setValidator(String validator) {
	this.validator = validator;
}


}
