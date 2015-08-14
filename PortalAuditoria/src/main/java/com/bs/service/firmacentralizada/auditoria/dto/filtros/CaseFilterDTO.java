package com.bs.service.firmacentralizada.auditoria.dto.filtros;

public class CaseFilterDTO {

	private int requestcId;
	
	private String fcId;
	
	private long operationId;
	
	private String applicationCode;
	
	private String operationType;
	
	private String sessionId;
	
	private String trackingId;
	
	private int multidoc;
	
	private String requester;
	
	private boolean sendDocuments;
	
	private boolean sendPersons;

	public int getRequestcId() {
		return requestcId;
	}

	public void setRequestcId(int requestcId) {
		this.requestcId = requestcId;
	}

	public String getFcId() {
		return fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	public long getOperationId() {
		return operationId;
	}

	public void setOperationId(long operationId) {
		this.operationId = operationId;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public int getMultidoc() {
		return multidoc;
	}

	public void setMultidoc(int multidoc) {
		this.multidoc = multidoc;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public boolean isSendDocuments() {
		return sendDocuments;
	}

	public void setSendDocuments(boolean sendDocuments) {
		this.sendDocuments = sendDocuments;
	}

	public boolean isSendPersons() {
		return sendPersons;
	}

	public void setSendPersons(boolean sendPersons) {
		this.sendPersons = sendPersons;
	}
}
