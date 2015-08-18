package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OPERATION_STATUS")
public class OperationStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="STATUS_ID")
	private int statusId;

	@Column(name="DESCRIPTION")
	private String description;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
