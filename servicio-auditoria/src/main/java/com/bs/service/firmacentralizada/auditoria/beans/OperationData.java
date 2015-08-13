package com.bs.service.firmacentralizada.auditoria.beans;

import org.hibernate.validator.constraints.NotEmpty;

public class OperationData {
	
	@NotEmpty
	private int operationId;
	
	@NotEmpty
	private int iteration;
	
	@NotEmpty
	private String inputChannel;
	
	@NotEmpty
	private String flow;
	
	@NotEmpty
	private String fcId;
	
	@NotEmpty
	private String sessionId;
	
	@NotEmpty
	private String statusId;
	
	@NotEmpty
	private int resultCode;

	public int getOperationId() {
		return operationId;
	}

	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public String getInputChannel() {
		return inputChannel;
	}

	public void setInputChannel(String inputChannel) {
		this.inputChannel = inputChannel;
	}

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
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

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
}
