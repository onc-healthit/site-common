package org.sitenv.common.statistics.dto;

public class GoogleAnalyticsData {

	private Long totalPageViews = 0L;
	private Long totalSessions = 0L;
	
	private Long pageViews30 = 0L;
	private Long pageViews60 = 0L;
	private Long pageViews90 = 0L;
	
	private Long sessions30 = 0L;
	private Long sessions60 = 0L;
	private Long sessions90 = 0L;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pageViews30 == null) ? 0 : pageViews30.hashCode());
		result = prime * result
				+ ((pageViews60 == null) ? 0 : pageViews60.hashCode());
		result = prime * result
				+ ((pageViews90 == null) ? 0 : pageViews90.hashCode());
		result = prime * result
				+ ((sessions30 == null) ? 0 : sessions30.hashCode());
		result = prime * result
				+ ((sessions60 == null) ? 0 : sessions60.hashCode());
		result = prime * result
				+ ((sessions90 == null) ? 0 : sessions90.hashCode());
		result = prime * result
				+ ((totalPageViews == null) ? 0 : totalPageViews.hashCode());
		result = prime * result
				+ ((totalSessions == null) ? 0 : totalSessions.hashCode());
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
		GoogleAnalyticsData other = (GoogleAnalyticsData) obj;
		if (pageViews30 == null) {
			if (other.pageViews30 != null)
				return false;
		} else if (!pageViews30.equals(other.pageViews30))
			return false;
		if (pageViews60 == null) {
			if (other.pageViews60 != null)
				return false;
		} else if (!pageViews60.equals(other.pageViews60))
			return false;
		if (pageViews90 == null) {
			if (other.pageViews90 != null)
				return false;
		} else if (!pageViews90.equals(other.pageViews90))
			return false;
		if (sessions30 == null) {
			if (other.sessions30 != null)
				return false;
		} else if (!sessions30.equals(other.sessions30))
			return false;
		if (sessions60 == null) {
			if (other.sessions60 != null)
				return false;
		} else if (!sessions60.equals(other.sessions60))
			return false;
		if (sessions90 == null) {
			if (other.sessions90 != null)
				return false;
		} else if (!sessions90.equals(other.sessions90))
			return false;
		if (totalPageViews == null) {
			if (other.totalPageViews != null)
				return false;
		} else if (!totalPageViews.equals(other.totalPageViews))
			return false;
		if (totalSessions == null) {
			if (other.totalSessions != null)
				return false;
		} else if (!totalSessions.equals(other.totalSessions))
			return false;
		return true;
	}
	public Long getTotalPageViews() {
		return totalPageViews;
	}
	public void setTotalPageViews(Long totalPageViews) {
		this.totalPageViews = totalPageViews;
	}
	public Long getTotalSessions() {
		return totalSessions;
	}
	public void setTotalSessions(Long totalSessions) {
		this.totalSessions = totalSessions;
	}
	public Long getPageViews30() {
		return pageViews30;
	}
	public void setPageViews30(Long pageViews30) {
		this.pageViews30 = pageViews30;
	}
	public Long getPageViews60() {
		return pageViews60;
	}
	public void setPageViews60(Long pageViews60) {
		this.pageViews60 = pageViews60;
	}
	public Long getPageViews90() {
		return pageViews90;
	}
	public void setPageViews90(Long pageViews90) {
		this.pageViews90 = pageViews90;
	}
	public Long getSessions30() {
		return sessions30;
	}
	public void setSessions30(Long sessions30) {
		this.sessions30 = sessions30;
	}
	public Long getSessions60() {
		return sessions60;
	}
	public void setSessions60(Long sessions60) {
		this.sessions60 = sessions60;
	}
	public Long getSessions90() {
		return sessions90;
	}
	public void setSessions90(Long sessions90) {
		this.sessions90 = sessions90;
	}
	
	
}
