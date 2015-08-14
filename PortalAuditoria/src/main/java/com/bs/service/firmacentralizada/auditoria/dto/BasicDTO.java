package com.bs.service.firmacentralizada.auditoria.dto;

public class BasicDTO {

	private long id;
	
	private String sId;
	
	private String description;

	@SuppressWarnings("unused")
	private BasicDTO(){
	}
	
	public BasicDTO(String sId, String description) {
		this(-1L, sId, description);
		try {
			this.id = Integer.valueOf(sId);
		} catch (NumberFormatException nfe) {}//Ignore it
	}
	
	public BasicDTO(long id, String description) {
		this(id, String.valueOf(id), description);
	}
	
	public BasicDTO(long id, String sId, String description) {
		this.id = id;
		this.sId = sId;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}
}
