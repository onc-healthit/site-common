package org.sitenv.common.statistics.dto;


public class SmtpSearchLogCounts {

	private Integer totalSmtpSearchCount;
	
	private Integer distinctDomainsSearchedCount;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((distinctDomainsSearchedCount == null) ? 0 : distinctDomainsSearchedCount
						.hashCode());
		result = prime
				* result
				+ ((totalSmtpSearchCount == null) ? 0
						: totalSmtpSearchCount.hashCode());
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
		SmtpSearchLogCounts other = (SmtpSearchLogCounts) obj;
		if (distinctDomainsSearchedCount == null) {
			if (other.distinctDomainsSearchedCount != null)
				return false;
		} else if (!distinctDomainsSearchedCount.equals(other.distinctDomainsSearchedCount))
			return false;
		if (totalSmtpSearchCount == null) {
			if (other.totalSmtpSearchCount != null)
				return false;
		} else if (!totalSmtpSearchCount
				.equals(other.totalSmtpSearchCount))
			return false;
		return true;
	}

	public Integer getTotalSmtpSearchCount() {
		return totalSmtpSearchCount;
	}

	public void setTotalSmtpSearchCount(Integer totalSmtpMessageCount) {
		this.totalSmtpSearchCount = totalSmtpMessageCount;
	}

	public Integer getDistinctDomainsSearchedCount() {
		return distinctDomainsSearchedCount;
	}

	public void setDistinctDomainsSearchedCount(Integer distinctDomainsSearchedCount) {
		this.distinctDomainsSearchedCount = distinctDomainsSearchedCount;
	}
	
	
}
