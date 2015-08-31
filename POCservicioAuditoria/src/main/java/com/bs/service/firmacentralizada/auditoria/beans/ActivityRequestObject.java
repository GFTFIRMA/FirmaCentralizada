package com.bs.service.firmacentralizada.auditoria.beans;

import com.bs.service.firmacentralizada.auditoria.dto.filtros.ActivityFilterDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.PaginationDTO;

public class ActivityRequestObject {

	private ActivityFilterDTO activityFilter;
	
	private PaginationDTO pagination;
	
	private String ordinationType;

	private String ordinationField;

	public PaginationDTO getPagination() {
		return pagination;
	}

	public void setPagination(PaginationDTO pagination) {
		this.pagination = pagination;
	}

	public String getOrdinationType() {
		return ordinationType;
	}

	public void setOrdinationType(String ordinationType) {
		this.ordinationType = ordinationType;
	}

	public String getOrdinationField() {
		return ordinationField;
	}

	public void setOrdinationField(String ordinationField) {
		this.ordinationField = ordinationField;
	}

	public ActivityFilterDTO getActivityFilter() {
		return activityFilter;
	}

	public void setActivityFilter(ActivityFilterDTO activityFilter) {
		this.activityFilter = activityFilter;
	}
}
