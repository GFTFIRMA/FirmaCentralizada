package com.bs.service.firmacentralizada.auditoria.dto.filtros;

public class OperationFilterDTO extends FilterDTO { 

	private Long operationId;
	
	private String flow;
	
	private String resultCode;
	
	private String inputChannel;
	
	private String fcId;
	
	private String requestcId;
	
	private String sessionId;
	
	private boolean sendActivity;
	
	public Long getOperationId() {
		return operationId;
	}
	
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
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

	public boolean isSendActivity() {
		return sendActivity;
	}

	public void setSendActivity(boolean sendActivity) {
		this.sendActivity = sendActivity;
	}
}
