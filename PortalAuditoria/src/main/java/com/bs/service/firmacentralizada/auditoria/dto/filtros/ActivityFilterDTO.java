package com.bs.service.firmacentralizada.auditoria.dto.filtros;

public class ActivityFilterDTO extends FilterDTO {

	private Long activityId;
	
	private Long operationId;
	
	private String flow;
	
	private String resultCode;
	
	private String executionPoint;
	
	private String trackingId;
	
	private String layer;
	
	private String component;
	
	private String service;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

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

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getExecutionPoint() {
		return executionPoint;
	}

	public void setExecutionPoint(String executionPoint) {
		this.executionPoint = executionPoint;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
}
