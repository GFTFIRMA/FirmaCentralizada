package com.bs.service.firmacentralizada.auditoria.dto.filtros;

/**
 * Class ActivityFilterDTO.java
 * 
 * Clase que proporciona una serie de filtros para ser utilizados en la recuperación de actividades de la BBDD.
 * 
 * Todos aquellos campos con valor null no serán añadidos a la consulta.
 * 
 */
public class ActivityFilterDTO extends FilterDTO {

	private Long activityId;
	
	private Long operationId;
	
	private Integer flowId;
	
	private Integer resultCodeId;
	
	private Integer executionPointId;
	
	private String trackingId;
	
	private Integer layerId;
	
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

	public Integer getResultCodeId() {
		return resultCodeId;
	}

	public void setResultCodeId(Integer resultCodeId) {
		this.resultCodeId = resultCodeId;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public Integer getFlowId() {
		return flowId;
	}

	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}

	public Integer getExecutionPointId() {
		return executionPointId;
	}

	public void setExecutionPointId(Integer executionPointId) {
		this.executionPointId = executionPointId;
	}

	public Integer getLayerId() {
		return layerId;
	}

	public void setLayerId(Integer layerId) {
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
