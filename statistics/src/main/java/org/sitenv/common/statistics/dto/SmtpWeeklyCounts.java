package org.sitenv.common.statistics.dto;

import java.util.Date;

public class SmtpWeeklyCounts {
	
	private Date startDate;
	
	private Date endDate;
	
	private Integer interval;
	
	private Integer year;
	
	private Long totalCount;
	
	private Long totalUniqueDomainCount;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((interval == null) ? 0 : interval.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((totalCount == null) ? 0 : totalCount.hashCode());
		result = prime
				* result
				+ ((totalUniqueDomainCount == null) ? 0
						: totalUniqueDomainCount.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		SmtpWeeklyCounts other = (SmtpWeeklyCounts) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (interval == null) {
			if (other.interval != null)
				return false;
		} else if (!interval.equals(other.interval))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (totalCount == null) {
			if (other.totalCount != null)
				return false;
		} else if (!totalCount.equals(other.totalCount))
			return false;
		if (totalUniqueDomainCount == null) {
			if (other.totalUniqueDomainCount != null)
				return false;
		} else if (!totalUniqueDomainCount.equals(other.totalUniqueDomainCount))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTotalUniqueDomainCount() {
		return totalUniqueDomainCount;
	}

	public void setTotalUniqueDomainCount(Long totalUniqueDomainCount) {
		this.totalUniqueDomainCount = totalUniqueDomainCount;
	}

	
}
