package com.bs.firmacentralizada.dto;

public class OperationFilterDTO extends FilterDTO { 

	private Long operationId;
	
	private Integer flowId;
	
	private Integer resultCodeId;
	
	private Integer inputChannelId;
	
	private String fcId;
	
	private Long requestcId;
	
	private String sessionId;
	
	public Long getOperationId() {
		return operationId;
	}
	
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}
	
	public Integer getInputChannelId() {
		return inputChannelId;
	}
	
	public void setInputChannelId(Integer inputChannelId) {
		this.inputChannelId = inputChannelId;
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

	public Integer getResultCodeId() {
		return resultCodeId;
	}

	public void setResultCodeId(Integer resultCodeId) {
		this.resultCodeId = resultCodeId;
	}

	public Long getRequestcId() {
		return requestcId;
	}

	public void setRequestcId(Long requestcId) {
		this.requestcId = requestcId;
	}

	public Integer getFlowId() {
		return flowId;
	}

	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}
}
