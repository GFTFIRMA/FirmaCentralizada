package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPONENT")
public class Component implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="COMPONENT")
	private String component;
	
	@Column (name="DESCRIPTION")
	private String description;

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
