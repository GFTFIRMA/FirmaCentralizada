package com.bs.service.firmacentralizada.auditoria.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bs.service.firmacentralizada.auditoria.AuditoriaConfig;
import com.bs.service.firmacentralizada.auditoria.beans.OperationData;
import com.bs.service.firmacentralizada.auditoria.dao.AuditoriaDAO;
import com.bs.service.firmacentralizada.auditoria.dao.OperationDataFilter;
import com.bs.service.firmacentralizada.auditoria.entidades.Flow;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationStatus;

@RestController
@RequestMapping(value = "/auditoria")
public class AuditoriaController {
	
	private ApplicationContext context =  new AnnotationConfigApplicationContext(AuditoriaConfig.class);
	private AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);

	@RequestMapping(method = RequestMethod.GET)
	public List<Flow> getFlows() {
		return auditoriaDao.getAllFlows();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<OperationStatus> getOperationStatus() {
		return auditoriaDao.getAllOperationStatus();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<OperationData> getOperationData(@RequestBody @Valid OperationDataFilter filter) {
		
		List<OperationData> operationsList = new ArrayList<OperationData>();
		List<com.bs.service.firmacentralizada.auditoria.entidades.OperationData> result = auditoriaDao.getOperationData(null);
		
		for (int i = 0; i < result.size(); i++) {
			OperationData operation = new OperationData();
			operation.setOperationId(result.get(i).getOperation().getOperationPK().getOperationId());
			operation.setIteration(result.get(i).getOperation().getOperationPK().getIteration());
			operation.setFlow(result.get(i).getFlow().getFlow());
			operation.setFcId(result.get(i).getFcId());
			operation.setInputChannel(result.get(i).getInputChannel());
			operation.setStatusId(result.get(i).getOperation().getStatus().getStatusId());
			operation.setSessionId(result.get(i).getSessionId());
			operation.setResultCode(result.get(i).getOperation().getResultCode().getCode());
			
			operationsList.add(operation);
		}
		
		return operationsList;
	}
}
