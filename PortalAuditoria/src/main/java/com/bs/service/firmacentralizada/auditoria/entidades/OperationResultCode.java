package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OPERATION_RESULT_CODES")
public class OperationResultCode  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODE")
	private Integer code;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="RETRYABLE")
	private Integer retryable;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRetryable() {
		return retryable;
	}

	public void setRetryable(Integer retryable) {
		this.retryable = retryable;
	}
}
