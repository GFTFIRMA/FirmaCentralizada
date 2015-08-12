package com.bs.service.firmacentralizada.auditoria.dao;

import java.util.Date;

public class OperationDataFilter {

	private Integer operationId;
	
	private Integer statusId;
	
	private Date startTime;
	
	private Date endTime;
	
	private String flow;
	
	private String inputChannel;
	
	private String fcId;
	
	private String sessionId;
	
	public Integer getOperationId() {
		return operationId;
	}
	
	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}
	
	public Integer getStatusId() {
		return statusId;
	}
	
	public void setStatusId(int statusId) {
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
	
	public String getFlow() {
		return flow;
	}
	
	public void setFlow(String flow) {
		this.flow = flow;
	}
	
	public String getInputChannel() {
		return inputChannel;
	}
	
	public void setInputChannel(String inputChannel) {
		this.inputChannel = inputChannel;
	}
	
	public String getFcId() {
		return fcId;
	}
	
	public void setFcId(String fcId) {
		this.fcId = fcId;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
