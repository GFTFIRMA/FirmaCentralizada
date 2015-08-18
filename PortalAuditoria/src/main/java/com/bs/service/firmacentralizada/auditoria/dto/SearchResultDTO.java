package com.bs.service.firmacentralizada.auditoria.dto;

import java.util.List;

public class SearchResultDTO<T> {
	
	private List<T> searchData;
	
	private SearchStatsDTO searchStats;

	public List<T> getSearchData() {
		return searchData;
	}

	public void setSearchData(List<T> queryResult) {
		this.searchData = queryResult;
	}

	public SearchStatsDTO getSearchStats() {
		return searchStats;
	}

	public void setSearchStats(SearchStatsDTO searchStats) {
		this.searchStats = searchStats;
	}	
}
