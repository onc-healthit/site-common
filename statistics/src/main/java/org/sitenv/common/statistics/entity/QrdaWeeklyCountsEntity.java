package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="qrdaValidationWeeklyCounts", query = "SELECT * FROM qrda_validation_weekly_counts(?)", resultClass = QrdaWeeklyCountsEntity.class)
})
public class QrdaWeeklyCountsEntity {
	
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
	
	@Column(name="category1_count")
	private Long category1Count;

	@Column(name="category3_count")
	private Long category3Count;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category1Count == null) ? 0 : category1Count.hashCode());
		result = prime * result
				+ ((category3Count == null) ? 0 : category3Count.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((interval == null) ? 0 : interval.hashCode());
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
		QrdaWeeklyCountsEntity other = (QrdaWeeklyCountsEntity) obj;
		if (category1Count == null) {
			if (other.category1Count != null)
				return false;
		} else if (!category1Count.equals(other.category1Count))
			return false;
		if (category3Count == null) {
			if (other.category3Count != null)
				return false;
		} else if (!category3Count.equals(other.category3Count))
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

	public Long getCategory1Count() {
		return category1Count;
	}

	public void setCategory1Count(Long category1Count) {
		this.category1Count = category1Count;
	}

	public Long getCategory3Count() {
		return category3Count;
	}

	public void setCategory3Count(Long category3Count) {
		this.category3Count = category3Count;
	}

	
}
