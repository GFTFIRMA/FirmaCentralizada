package com.bs.service.firmacentralizada.auditoria.dto.filtros;

import java.util.Date;

public class FilterDTO {

	private Integer statusId;
	
	private Date startTime;
	
	private Date endTime;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
