package org.sitenv.common.statistics.entity;

import javax.persistence.*;


@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="directreceive_log_counts", query="SELECT * FROM directreceive_log_counts()", resultClass=DirectLogCountsEntity.class),
	@NamedNativeQuery(name="directsend_log_counts", query="SELECT * FROM directsend_log_counts()", resultClass=DirectLogCountsEntity.class)
})

public class DirectLogCountsEntity {
	@Id
	@Column(name="rnum")
	private Long rowNumber;
	
	@Column(name="total_directmsg")
	private Integer totalDirectMessageCount;
	
	@Column(name="distinct_domains")
	private Integer distinctDomainsCount;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((distinctDomainsCount == null) ? 0 : distinctDomainsCount
						.hashCode());
		result = prime
				* result
				+ ((totalDirectMessageCount == null) ? 0
						: totalDirectMessageCount.hashCode());
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
		DirectLogCountsEntity other = (DirectLogCountsEntity) obj;
		if (distinctDomainsCount == null) {
			if (other.distinctDomainsCount != null)
				return false;
		} else if (!distinctDomainsCount.equals(other.distinctDomainsCount))
			return false;
		if (totalDirectMessageCount == null) {
			if (other.totalDirectMessageCount != null)
				return false;
		} else if (!totalDirectMessageCount
				.equals(other.totalDirectMessageCount))
			return false;
		return true;
	}

	public Integer getTotalDirectMessageCount() {
		return totalDirectMessageCount;
	}

	public void setTotalDirectMessageCount(Integer totalDirectMessageCount) {
		this.totalDirectMessageCount = totalDirectMessageCount;
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
	
	

}
