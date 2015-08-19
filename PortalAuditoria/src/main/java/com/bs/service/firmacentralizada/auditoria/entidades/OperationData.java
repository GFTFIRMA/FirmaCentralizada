package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPERATION_DATA")
public class OperationData  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@OneToOne (targetEntity = Operation.class)
    @JoinColumns({
        @JoinColumn(name="OPERATION_ID", referencedColumnName="OPERATION_ID"),
        @JoinColumn(name="ITERATION", referencedColumnName="ITERATION")
    })
	private Operation operation;
	
	@ManyToOne
	@JoinColumn(name = "FLOW_ID")
	private Flow flow;

	@Column(name="REQUESTC_ID")
	private long requestcId;
	
	@Column(name="INPUT_CHANNEL")
	private String inputChannel;

	@Column(name="FC_ID")
	private String fcId;

	@Column(name="SESSION_ID")
	private String sessionId;

	@Column(name="XML_REQUEST")
	private Clob xmlRequest;

	@Column(name="XML_RESPONSE")
	private Clob xmlResponse;

	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
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

	public Clob getXmlRequest() {
		return xmlRequest;
	}

	public void setXmlRequest(Clob xmlRequest) {
		this.xmlRequest = xmlRequest;
	}

	public Clob getXmlResponse() {
		return xmlResponse;
	}

	public void setXmlResponse(Clob xmlResponse) {
		this.xmlResponse = xmlResponse;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public long getRequestcId() {
		return requestcId;
	}

	public void setRequestcId(long requestcId) {
		this.requestcId = requestcId;
	}
}
