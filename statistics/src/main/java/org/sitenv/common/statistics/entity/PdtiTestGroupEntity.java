package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pdti_testcasegroup")
public class PdtiTestGroupEntity {

	@Id
	@Column(name="group_pk")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Basic(optional = false)
	@Column(name = "group_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="group_endpointurl")
	private String endpointUrl;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "testcase_group")
    private List<PdtiTestCaseEntity> testCases;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endpointUrl == null) ? 0 : endpointUrl.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((testCases == null) ? 0 : testCases.hashCode());
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
		PdtiTestGroupEntity other = (PdtiTestGroupEntity) obj;
		if (endpointUrl == null) {
			if (other.endpointUrl != null)
				return false;
		} else if (!endpointUrl.equals(other.endpointUrl))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (testCases == null) {
			if (other.testCases != null)
				return false;
		} else if (!testCases.equals(other.testCases))
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

	public String getEndpointUrl() {
		return endpointUrl;
	}

	public void setEndpointUrl(String endpointUrl) {
		
		this.endpointUrl = (endpointUrl != null && endpointUrl.length() > 1000) ? endpointUrl.substring(0,1000) : endpointUrl;
	}

	public List<PdtiTestCaseEntity> getTestCases() {
		return testCases;
	}

	public void setTestCases(List<PdtiTestCaseEntity> testCases) {
		this.testCases = testCases;
	}


}
