package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pdti_testcases")
public class PdtiTestCaseEntity {

	@Id
	@Column(name="testcase_pk")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Basic(optional = false)
	@Column(name = "testcase_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="testcase_name")
	private String name;

	@Column(name="testcase_pass")
	private Boolean pass;

	@Column(name="testcase_httperror")
	private Boolean httpError;
	
	@ManyToOne
	@JoinColumn(name="testcase_group")
	private PdtiTestGroupEntity pdtiTestGroupEntity;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((httpError == null) ? 0 : httpError.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime
				* result
				+ ((pdtiTestGroupEntity == null) ? 0 : pdtiTestGroupEntity
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
		PdtiTestCaseEntity other = (PdtiTestCaseEntity) obj;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (pdtiTestGroupEntity == null) {
			if (other.pdtiTestGroupEntity != null)
				return false;
		} else if (!pdtiTestGroupEntity.equals(other.pdtiTestGroupEntity))
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPass() {
		return pass;
	}

	public void setPass(Boolean pass) {
		this.pass = pass;
	}

	public Boolean getHttpError() {
		return httpError;
	}

	public void setHttpError(Boolean httpError) {
		this.httpError = httpError;
	}

	public PdtiTestGroupEntity getPdtiTestGroupEntity() {
		return pdtiTestGroupEntity;
	}

	public void setPdtiTestGroupEntity(PdtiTestGroupEntity pdtiTestGroupEntity) {
		this.pdtiTestGroupEntity = pdtiTestGroupEntity;
	}

	
	
}
