package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="aggregateWeeklyCounts", query = "SELECT * FROM aggregate_weekly_counts(?)", resultClass = AggregateWeeklyCountsEntity.class)
})
public class AggregateWeeklyCountsEntity {

	@Id
	@Column(name="start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name="end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name="range_interval")
	private Integer interval; // month number or week number
	
	@Column(name="range_year")
	private Integer year;
	
	@Column(name="directsent_count")
	private Long directSentCount;
	
	@Column(name="ccda_count")
	private Long ccdaCount;
	
	@Column(name="qrda_count")
	private Long qrdaCount;
	
	@Column(name="pdtirequest_count")
	private Long pdtiCount;
	
	@Column(name="directreceive_count")
	private Long directReceiveCount;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ccdaCount == null) ? 0 : ccdaCount.hashCode());
		result = prime
				* result
				+ ((directReceiveCount == null) ? 0 : directReceiveCount
						.hashCode());
		result = prime * result
				+ ((directSentCount == null) ? 0 : directSentCount.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((interval == null) ? 0 : interval.hashCode());
		result = prime * result
				+ ((pdtiCount == null) ? 0 : pdtiCount.hashCode());
		result = prime * result
				+ ((qrdaCount == null) ? 0 : qrdaCount.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
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
		AggregateWeeklyCountsEntity other = (AggregateWeeklyCountsEntity) obj;
		if (ccdaCount == null) {
			if (other.ccdaCount != null)
				return false;
		} else if (!ccdaCount.equals(other.ccdaCount))
			return false;
		if (directReceiveCount == null) {
			if (other.directReceiveCount != null)
				return false;
		} else if (!directReceiveCount.equals(other.directReceiveCount))
			return false;
		if (directSentCount == null) {
			if (other.directSentCount != null)
				return false;
		} else if (!directSentCount.equals(other.directSentCount))
			return false;
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
		if (pdtiCount == null) {
			if (other.pdtiCount != null)
				return false;
		} else if (!pdtiCount.equals(other.pdtiCount))
			return false;
		if (qrdaCount == null) {
			if (other.qrdaCount != null)
				return false;
		} else if (!qrdaCount.equals(other.qrdaCount))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
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

	public Long getDirectSentCount() {
		return directSentCount;
	}

	public void setDirectSentCount(Long directSentCount) {
		this.directSentCount = directSentCount;
	}

	public Long getCcdaCount() {
		return ccdaCount;
	}

	public void setCcdaCount(Long ccdaCount) {
		this.ccdaCount = ccdaCount;
	}

	public Long getQrdaCount() {
		return qrdaCount;
	}

	public void setQrdaCount(Long qrdaCount) {
		this.qrdaCount = qrdaCount;
	}

	public Long getPdtiCount() {
		return pdtiCount;
	}

	public void setPdtiCount(Long pdtiCount) {
		this.pdtiCount = pdtiCount;
	}

	public Long getDirectReceiveCount() {
		return directReceiveCount;
	}

	public void setDirectReceiveCount(Long directReceiveCount) {
		this.directReceiveCount = directReceiveCount;
	}

	
	
	
}
