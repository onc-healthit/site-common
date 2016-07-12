package org.sitenv.common.statistics.entity;

import javax.persistence.*;


@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="smtpreceive_log_counts", query="SELECT * FROM smtpreceive_log_counts()", resultClass=SmtpLogCountsEntity.class),
	@NamedNativeQuery(name="smtpsearch_counts", query="SELECT * FROM smtpsearch_counts()", resultClass=SmtpLogCountsEntity.class)
})

public class SmtpLogCountsEntity {
	@Id
	@Column(name="rnum")
	private Long rowNumber;
	
	@Column(name="total_searches")
	private Integer totalSearchesCount;
	
	@Column(name="distinct_domains")
	private Integer distinctDomainsCount;
	
	public Integer getTotalSearchesCount() {
		return totalSearchesCount;
	}

	public void setTotalSearchesCount(Integer totalSearchesCount) {
		this.totalSearchesCount = totalSearchesCount;
	}

	public Integer getDistinctDomainsCount() {
		return distinctDomainsCount;
	}

	public void setDistinctDomainsCount(Integer distinctDomainsCount) {
		this.distinctDomainsCount = distinctDomainsCount;
	}

	public Long getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(Long rowNumber) {
		this.rowNumber = rowNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((distinctDomainsCount == null) ? 0 : distinctDomainsCount
						.hashCode());
		result = prime * result
				+ ((rowNumber == null) ? 0 : rowNumber.hashCode());
		result = prime
				* result
				+ ((totalSearchesCount == null) ? 0 : totalSearchesCount
						.hashCode());
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
		SmtpLogCountsEntity other = (SmtpLogCountsEntity) obj;
		if (distinctDomainsCount == null) {
			if (other.distinctDomainsCount != null)
				return false;
		} else if (!distinctDomainsCount.equals(other.distinctDomainsCount))
			return false;
		if (rowNumber == null) {
			if (other.rowNumber != null)
				return false;
		} else if (!rowNumber.equals(other.rowNumber))
			return false;
		if (totalSearchesCount == null) {
			if (other.totalSearchesCount != null)
				return false;
		} else if (!totalSearchesCount.equals(other.totalSearchesCount))
			return false;
		return true;
	}
	
	

}
