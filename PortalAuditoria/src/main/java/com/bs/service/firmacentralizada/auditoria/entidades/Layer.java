package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LAYERS")
public class Layer  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="LAYER_ID")
	private Integer layerId;

	@Column (name="DESCRIPTION")
	private String description;

	@Column (name="DEPTH")
	private Integer depth;

	public Integer getLayerId() {
		return layerId;
	}

	public void setLayerId(Integer layerId) {
		this.layerId = layerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}
}
