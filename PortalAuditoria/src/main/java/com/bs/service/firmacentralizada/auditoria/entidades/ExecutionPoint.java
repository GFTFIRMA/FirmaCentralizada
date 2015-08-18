package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EXECUTION_POINTS")
public class ExecutionPoint  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="EXECUTION_POINT_ID")
	private long executionPointId;
	
	@Column (name="DESCRIPTION")
	private String description;

	public long getExecutionPointId() {
		return executionPointId;
	}

	public void setExecutionPointId(long executionPointId) {
		this.executionPointId = executionPointId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}