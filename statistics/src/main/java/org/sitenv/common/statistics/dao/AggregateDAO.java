package org.sitenv.common.statistics.dao;

import org.sitenv.common.statistics.dto.AggregateWeeklyCounts;

import java.util.List;

public interface AggregateDAO {

	public List<AggregateWeeklyCounts> getAggregateWeeklyCounts(Integer numOfWeeks);
	
}
