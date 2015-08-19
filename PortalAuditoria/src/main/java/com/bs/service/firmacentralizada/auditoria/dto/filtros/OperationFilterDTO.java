package com.bs.service.firmacentralizada.auditoria.dto.filtros;

public class OperationFilterDTO extends FilterDTO { 

	private Long operationId;
	
	private Integer flowId;
	
	private Integer resultCodeId;
	
	private String inputChannel;
	
	private String fcId;
	
	private Long requestcId;
	
	private String sessionId;
	
	public Long getOperationId() {
		return operationId;
	}
	
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
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
