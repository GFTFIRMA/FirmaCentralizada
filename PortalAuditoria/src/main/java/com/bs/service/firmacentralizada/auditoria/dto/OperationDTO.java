package com.bs.service.firmacentralizada.auditoria.dto;

import java.sql.Timestamp;

public class OperationDTO {

	private long operationId;
	
	private int iteration;
	
	private String flow;
	
	private Timestamp startTime;
	
	private Timestamp endTime;
	
	private int statusId;
	
	private String resultCode;
	
	private String fcId;
	
	private long requestcId;
	
	private String inputChannel;
	
	private String sessionId; 

	public long getOperationId() {
		return operationId;
	}

	public void setOperationId(long operationId) {
		this.operationId = operationId;
	}

	public int getIteration() {
		return iteration; 
	}

	public void setIteration(int iteration) {
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
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

	public long getRequestcId() {
		return requestcId;
	}

	public void setRequestcId(long l) {
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
