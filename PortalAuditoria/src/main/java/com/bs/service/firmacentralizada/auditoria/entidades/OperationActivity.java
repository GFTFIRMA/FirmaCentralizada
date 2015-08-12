package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="OPERATION_ACTIVITY")
public class OperationActivity  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ACTIVITY_ID")
	private Integer activityId;

	@ManyToOne (targetEntity = Operation.class)
    @JoinColumns({
        @JoinColumn(name="OPERATION_ID", referencedColumnName="OPERATION_ID"),
        @JoinColumn(name="ITERATION", referencedColumnName="ITERATION")
    })
	private Operation operation;

	@ManyToOne
	@JoinColumn(name="LAYER_ID")
	private Layer layer;

	@ManyToOne (targetEntity = ComponentService.class)
    @JoinColumns({
        @JoinColumn(name="COMPONENT", referencedColumnName="COMPONENT"),
        @JoinColumn(name="SERVICE", referencedColumnName="SERVICE")
    })
	private ComponentService componentService;

	@ManyToOne
	@JoinColumn(name="EXECUTION_POINT")
	private ExecutionPoint executionPoint;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_TIME")
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TIME")
	private Date endTime;

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

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
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

	public ComponentService getComponentService() {
		return componentService;
	}

	public void setComponentService(ComponentService componentService) {
		this.componentService = componentService;
	}
}
