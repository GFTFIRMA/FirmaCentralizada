package com.bs.service.firmacentralizada.auditoria.dto.filtros;

import java.sql.Timestamp;

public class FilterDTO {

	private Integer statusId;
	
	private Timestamp startTime;
	
	private Timestamp endTime;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
}
