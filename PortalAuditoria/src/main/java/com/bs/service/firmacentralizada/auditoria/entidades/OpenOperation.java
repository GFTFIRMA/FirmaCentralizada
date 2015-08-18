package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPEN_OPERATIONS")
public class OpenOperation  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@OneToOne (targetEntity = Operation.class)
    @JoinColumns({
        @JoinColumn(name="OPERATION_ID", referencedColumnName="OPERATION_ID"),
        @JoinColumn(name="ITERATION", referencedColumnName="ITERATION")
    })
	private Operation operation;

	@Column(name="START_TIME")
	private Timestamp startTime;

	@Column(name="NODE")
	private String node;
	
	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
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
}
