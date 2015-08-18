package com.bs.service.firmacentralizada.auditoria.dto.filtros;

public class ActivityFilterDTO extends FilterDTO {

	private Long activityId;
	
	private Long operationId;
	
	private Long flowId;
	
	private String resultCode;
	
	private Long executionPointId;
	
	private String trackingId;
	
	private Long layerId;
	
	private Long componentId;
	
	private Long serviceId;

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

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public Long getFlowId() {
		return flowId;
	}

	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}

	public Long getExecutionPointId() {
		return executionPointId;
	}

	public void setExecutionPointId(Long executionPointId) {
		this.executionPointId = executionPointId;
	}

	public Long getLayerId() {
		return layerId;
	}

	public void setLayerId(Long layerId) {
		this.layerId = layerId;
	}

	public Long getComponentId() {
		return componentId;
	}

	public void setComponentId(Long componentId) {
		this.componentId = componentId;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
}
