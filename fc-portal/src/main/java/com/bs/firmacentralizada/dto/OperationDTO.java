package com.bs.firmacentralizada.dto;

import java.sql.Timestamp;

public class OperationDTO {

	private Long operationId;
	
	private Integer iteration;
	
	private String flow;
	
	private Timestamp startTime;
	
	private Timestamp endTime;
	
	private String status;
	
	private String resultCode;
	
	private String fcId;
	
	private Long requestcId;
	
	private String inputChannel;
	
	private String sessionId; 

	public Long getOperationId() {
		return operationId;
	}

	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}

	public Integer getIteration() {
		return iteration; 
	}

	public void setIteration(Integer iteration) {
		this.iteration = iteration;
	}

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getFcId() {
		return fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	public Long getRequestcId() {
		return requestcId;
	}

	public void setRequestcId(Long l) {
		this.requestcId = l;
	}

	public String getInputChannel() {
		return inputChannel;
	}

	public void setInputChannel(String inputChannel) {
		this.inputChannel = inputChannel;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
