package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMPONENT_SERVICES")
public class ComponentService  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="SERVICE_ID")
	private long serviceId;
	
	@Column(name="DESCRIPTION")
	private String description;

	@ManyToOne
	@JoinColumn(name="COMPONENT_ID", referencedColumnName = "COMPONENT_ID")
	private Component component;

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
}
