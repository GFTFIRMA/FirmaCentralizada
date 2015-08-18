package com.bs.service.firmacentralizada.auditoria.dto.filtros;

public class OperationFilterDTO extends FilterDTO { 

	private Long operationId;
	
	private Long flowId;
	
	private String resultCode;
	
	private String inputChannel;
	
	private String fcId;
	
	private String requestcId;
	
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

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getRequestcId() {
		return requestcId;
	}

	public void setRequestcId(String requestcId) {
		this.requestcId = requestcId;
	}

	public Long getFlowId() {
		return flowId;
	}

	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}
}
