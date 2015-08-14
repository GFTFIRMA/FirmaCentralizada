package com.bs.service.firmacentralizada.auditoria.dto;

import java.util.List;

public class OperationDetailsDTO extends OperationDTO {
	
	private String node;
	
	private String xmlRequest;
	
	private String xmlResponse;
	
	private List<ActivityDTO> operationActivity;

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getXmlRequest() {
		return xmlRequest;
	}

	public void setXmlRequest(String xmlRequest) {
		this.xmlRequest = xmlRequest;
	}

	public String getXmlResponse() {
		return xmlResponse;
	}

	public void setXmlResponse(String xmlResponse) {
		this.xmlResponse = xmlResponse;
	}

	public List<ActivityDTO> getOperationActivity() {
		return operationActivity;
	}

	public void setOperationActivity(List<ActivityDTO> operationActivity) {
		this.operationActivity = operationActivity;
	}
}
