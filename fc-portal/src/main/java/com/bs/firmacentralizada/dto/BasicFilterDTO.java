package com.bs.firmacentralizada.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class BasicFilterDTO {

	@NotEmpty
	private Integer id;
	
	@NotEmpty
	private String description;

	private BasicFilterDTO() {
		
	}
	
	public BasicFilterDTO(Integer _id, String _description) {
		this.id = _id;
		this.description = _description;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	

}
