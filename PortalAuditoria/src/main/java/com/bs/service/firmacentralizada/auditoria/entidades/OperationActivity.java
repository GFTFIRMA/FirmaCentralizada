package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPERATION_ACTIVITY")
public class OperationActivity  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ACTIVITY_ID")
	private long activityId;

	@ManyToOne (targetEntity = Operation.class)
    @JoinColumns({
        @JoinColumn(name="OPERATION_ID", referencedColumnName="OPERATION_ID"),
        @JoinColumn(name="ITERATION", referencedColumnName="ITERATION")
    })
	private Operation operation;

	@ManyToOne
	@JoinColumn(name="LAYER_ID", nullable = false)
	private Layer layer;
	
	@ManyToOne
	@JoinColumn(name="EXECUTION_POINT_ID")
	private ExecutionPoint executionPoint;

	@ManyToOne (targetEntity = Component.class)
	@JoinColumn(name="ORIG_COMPONENT_ID", referencedColumnName="COMPONENT_ID")
	private Component origComponent;
	
	@ManyToOne (targetEntity = ComponentService.class)
    @JoinColumn(name="DEST_SERVICE_ID", referencedColumnName="SERVICE_ID")
	private ComponentService destService;

	@Column(name="START_TIME", nullable = false)
	private Timestamp startTime;
	
	@Column(name="END_TIME")
	private Timestamp endTime;

	@Column(name="TRACKING_ID")
	private String trackingId;

	@Column(name="XML_SVC_REQUEST")
	private Clob xmlSvcRequest;

	@Column(name="XML_SVC_RESPONSE")
	private Clob xmlSvcResponse;
	
	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private OperationStatus status;

	@Column(name="RETURN_CODE")
	private Integer returnCode;

	@Column(name="RETURN_DESCRIPTION")
	private String returnDescription;
	
	@Column(name="NODE")
	private String node;

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public Layer getLayer() {
		return layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}

	public ExecutionPoint getExecutionPoint() {
		return executionPoint;
	}

	public void setExecutionPoint(ExecutionPoint executionPoint) {
		this.executionPoint = executionPoint;
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

	public Clob getXmlSvcRequest() {
		return xmlSvcRequest;
	}

	public void setXmlSvcRequest(Clob xmlSvcRequest) {
		this.xmlSvcRequest = xmlSvcRequest;
	}

	public Clob getXmlSvcResponse() {
		return xmlSvcResponse;
	}

	public void setXmlSvcResponse(Clob xmlSvcResponse) {
		this.xmlSvcResponse = xmlSvcResponse;
	}

	public OperationStatus getStatus() {
		return status;
	}

	public void setStatus(OperationStatus status) {
		this.status = status;
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
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

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public ComponentService getDestService() {
		return destService;
	}

	public void setDestService(ComponentService destService) {
		this.destService = destService;
	}

	public Component getOrigComponent() {
		return origComponent;
	}

	public void setOrigComponent(Component origComponent) {
		this.origComponent = origComponent;
	}
}
