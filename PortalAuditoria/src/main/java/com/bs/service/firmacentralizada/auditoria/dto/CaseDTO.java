package com.bs.service.firmacentralizada.auditoria.dto;

import java.sql.Timestamp;

public class CaseDTO {

	private int requestcId;
	
	private String fcId;
	
	private Timestamp creationDate;
	
	private int statusId;
	
	private long operationId;
	
	private String operationType;
	
	private String applicationCode;
	
	private int multidoc;
	
	private String requester;
	
	private Timestamp closingDate;
	
	private Timestamp expirationDate;
	
	private String cancelationReason;
	
	private String sessionId;
	
	private String trackingId;
	
	private String entityCode;

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

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public long getOperationId() {
		return operationId;
	}

	public void setOperationId(long operationId) {
		this.operationId = operationId;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
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

	public Timestamp getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Timestamp closingDate) {
		this.closingDate = closingDate;
	}

	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCancelationReason() {
		return cancelationReason;
	}

	public void setCancelationReason(String cancelationReason) {
		this.cancelationReason = cancelationReason;
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

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}
}
