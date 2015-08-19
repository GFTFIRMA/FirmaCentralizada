package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMPONENTS")
public class Component implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="COMPONENT_ID")
	private long componentId;
	
	@Column (name="DESCRIPTION")
	private String description;

	@Column (name="IS_EXTERNAL")
	private int isExternal;
	
	@ManyToOne
	@JoinColumn(name="LAYER_ID", nullable = false)
	private Layer layer;

	public long getComponentId() {
		return componentId;
	}

	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsExternal() {
		return isExternal;
	}

	public void setIsExternal(int isExternal) {
		this.isExternal = isExternal;
	}

	public Layer getLayer() {
		return layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}
}
