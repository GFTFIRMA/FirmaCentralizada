package com.bs.service.firmacentralizada.auditoria.dto;

import java.util.List;

public class CaseDetailsDTO extends CaseDTO {

	private CaseDTO caseFC;
	
	private List<CaseDocumentDTO> documents;
	
	private List<CasePersonDTO> persons;

	public CaseDTO getCaseFC() {
		return caseFC;
	}

	public void setCaseFC(CaseDTO caseFC) {
		this.caseFC = caseFC;
	}

	public List<CaseDocumentDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(List<CaseDocumentDTO> documents) {
		this.documents = documents;
	}

	public List<CasePersonDTO> getPersons() {
		return persons;
	}

	public void setPersons(List<CasePersonDTO> persons) {
		this.persons = persons;
	}
}
