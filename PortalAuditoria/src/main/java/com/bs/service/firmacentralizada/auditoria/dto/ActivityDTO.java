package com.bs.service.firmacentralizada.auditoria.dto;

import java.sql.Timestamp;

public class ActivityDTO {
	
	private long activityId;
	
	private long operationId;
	
	private int iteration;
	
	private String layer;
	
	private String executionPoint;
	
	private String sourceComponent;
	
	private String destinationComponent;
	
	private String service;
	
	private Timestamp startTime;
	
	private Timestamp endTime;
	
	private String trackingId;
	
	private String xmlSvcRequest;
	
	private String xmlSvcResponse;
	
	private int statusId;
	
	private int returnCode;
	
	private String returnDescription;
	
	private String node;

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

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

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public String getExecutionPoint() {
		return executionPoint;
	}

	public void setExecutionPoint(String executionPoint) {
		this.executionPoint = executionPoint;
	}

	public String getSourceComponent() {
		return sourceComponent;
	}

	public void setSourceComponent(String sourceComponent) {
		this.sourceComponent = sourceComponent;
	}

	public String getDestinationComponent() {
		return destinationComponent;
	}

	public void setDestinationComponent(String destinationComponent) {
		this.destinationComponent = destinationComponent;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
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

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getXmlSvcRequest() {
		return xmlSvcRequest;
	}

	public void setXmlSvcRequest(String xmlSvcRequest) {
		this.xmlSvcRequest = xmlSvcRequest;
	}

	public String getXmlSvcResponse() {
		return xmlSvcResponse;
	}

	public void setXmlSvcResponse(String xmlSvcResponse) {
		this.xmlSvcResponse = xmlSvcResponse;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnDescription() {
		return returnDescription;
	}

	public void setReturnDescription(String returnDescription) {
		this.returnDescription = returnDescription;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

}
