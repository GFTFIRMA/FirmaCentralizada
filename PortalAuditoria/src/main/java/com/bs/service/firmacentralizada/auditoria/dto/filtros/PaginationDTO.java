package com.bs.service.firmacentralizada.auditoria.dto.filtros;

public class PaginationDTO {

	public static final int DEFAULT_PAGE_SIZE = 25;
	public static final int DEFAULT_PAGE_NUMBER = 1;
	
	private int numPage;
	
	private int numRegisters;

	public PaginationDTO() {
		this.numPage = DEFAULT_PAGE_NUMBER;
		this.numRegisters = DEFAULT_PAGE_SIZE;
	}
	
	public int getNumPage() {
		return numPage;
	}

	public void setNumPage(int numPage) {
		if (numPage < 1) return;
		this.numPage = numPage;
	}

	public int getNumRegisters() {
		return numRegisters;
	}

	public void setNumRegisters(int numRegisters) {
		if (numRegisters < 1) return;
		this.numRegisters = numRegisters;
	}
}
