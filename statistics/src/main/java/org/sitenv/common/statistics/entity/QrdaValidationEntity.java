package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="qrda_validations")
public class QrdaValidationEntity {

		
	@Id
	@Column(name="validation_pk")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Basic(optional = false)
	@Column(name = "validation_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="validation_schemaerrors")
	private Boolean schemaErrors;
	
	@Column(name="validation_schematronerrors")
	private Boolean schematronErrors;

	@Column(name="validation_schematronwarnings")
	private Boolean schematronWarnings;

	@Column(name="validation_category")
	private Integer category;

	@Column(name="validation_httperror")
	private Boolean httpError;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((httpError == null) ? 0 : httpError.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((schemaErrors == null) ? 0 : schemaErrors.hashCode());
		result = prime
				* result
				+ ((schematronErrors == null) ? 0 : schematronErrors.hashCode());
		result = prime
				* result
				+ ((schematronWarnings == null) ? 0 : schematronWarnings
						.hashCode());
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
		QrdaValidationEntity other = (QrdaValidationEntity) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
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
		if (schemaErrors == null) {
			if (other.schemaErrors != null)
				return false;
		} else if (!schemaErrors.equals(other.schemaErrors))
			return false;
		if (schematronErrors == null) {
			if (other.schematronErrors != null)
				return false;
		} else if (!schematronErrors.equals(other.schematronErrors))
			return false;
		if (schematronWarnings == null) {
			if (other.schematronWarnings != null)
				return false;
		} else if (!schematronWarnings.equals(other.schematronWarnings))
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

	public Boolean getSchemaErrors() {
		return schemaErrors;
	}

	public void setSchemaErrors(Boolean schemaErrors) {
		this.schemaErrors = schemaErrors;
	}

	public Boolean getSchematronErrors() {
		return schematronErrors;
	}

	public void setSchematronErrors(Boolean schematronErrors) {
		this.schematronErrors = schematronErrors;
	}

	public Boolean getSchematronWarnings() {
		return schematronWarnings;
	}

	public void setSchematronWarnings(Boolean schematronWarnings) {
		this.schematronWarnings = schematronWarnings;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Boolean getHttpError() {
		return httpError;
	}

	public void setHttpError(Boolean httpError) {
		this.httpError = httpError;
	}

	

	
	
	
}
