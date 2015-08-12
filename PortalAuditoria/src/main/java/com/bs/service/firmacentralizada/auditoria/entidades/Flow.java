package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FLOWS")
public class Flow  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="FLOW")
	private String flow;
	
	@Column (name="DESCRIPTION")
	private String description;

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
