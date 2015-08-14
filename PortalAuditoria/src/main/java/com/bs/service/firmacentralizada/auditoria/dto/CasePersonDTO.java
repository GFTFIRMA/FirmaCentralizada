package com.bs.service.firmacentralizada.auditoria.dto;

public class CasePersonDTO {
	
	private int numPerson;
	
	private String signerType;
	
	private String name;
	
	private String surname_1;
	
	private String surname_2;
	
	private int statusId;
	
	private boolean signed;

	public int getNumPerson() {
		return numPerson;
	}

	public void setNumPerson(int numPerson) {
		this.numPerson = numPerson;
	}

	public String getSignerType() {
		return signerType;
	}

	public void setSignerType(String signerType) {
		this.signerType = signerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname_1() {
		return surname_1;
	}

	public void setSurname_1(String surname_1) {
		this.surname_1 = surname_1;
	}

	public String getSurname_2() {
		return surname_2;
	}

	public void setSurname_2(String surname_2) {
		this.surname_2 = surname_2;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public boolean isSigned() {
		return signed;
	}

	public void setSigned(boolean signed) {
		this.signed = signed;
	}

}
