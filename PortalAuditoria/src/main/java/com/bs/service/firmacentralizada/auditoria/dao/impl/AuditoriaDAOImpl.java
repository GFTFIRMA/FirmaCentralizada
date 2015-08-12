package com.bs.service.firmacentralizada.auditoria.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.bs.service.firmacentralizada.auditoria.dao.AuditoriaDAO;
import com.bs.service.firmacentralizada.auditoria.entidades.Component;
import com.bs.service.firmacentralizada.auditoria.entidades.ComponentService;
import com.bs.service.firmacentralizada.auditoria.entidades.ExecutionPoint;
import com.bs.service.firmacentralizada.auditoria.entidades.Flow;
import com.bs.service.firmacentralizada.auditoria.entidades.Layer;
import com.bs.service.firmacentralizada.auditoria.entidades.OpenOperation;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationActivity;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationData;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationResultCode;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationStatus;

public class AuditoriaDAOImpl implements AuditoriaDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;
		
	@Override
	public List<Component> getAllComponents() {
		return emf.createEntityManager().createQuery("SELECT c FROM Component c", Component.class).getResultList();
	}

	@Override
	public List<ComponentService> getAllComponentServices() {
		return emf.createEntityManager().createQuery("SELECT c FROM ComponentService c", ComponentService.class).getResultList();
	}

	@Override
	public List<ExecutionPoint> getAllExecutionPoints() {
		return emf.createEntityManager().createQuery("SELECT e FROM ExecutionPoint e", ExecutionPoint.class).getResultList();
	}

	@Override
	public List<Flow> getAllFlows() {
		return emf.createEntityManager().createQuery("SELECT f FROM Flow f", Flow.class).getResultList();
	}

	@Override
	public List<Layer> getAllLayers() {
		return emf.createEntityManager().createQuery("SELECT l FROM Layer l", Layer.class).getResultList();
	}

	@Override
	public List<OpenOperation> getAllOpenOperations() {
		return emf.createEntityManager().createQuery("SELECT o FROM OpenOperation o", OpenOperation.class).getResultList();
	}

	@Override
	public List<OperationResultCode> getAllOperationResultCodes() {
		return emf.createEntityManager().createQuery("SELECT o FROM OperationResultCode o", OperationResultCode.class).getResultList();
	}

	@Override
	public List<OperationStatus> getAllOperationStatus() {
		return emf.createEntityManager().createQuery("SELECT o FROM OperationStatus o", OperationStatus.class).getResultList();
	}
	
	@Override
	public List<OperationData> getOperationData(OperationDataFilter filtro) {
		
		String query = "SELECT o FROM OperationData o";
		if (filtro != null) {
			
			if (filtro.getOperationId() != null) {
				query += selectKeyword() + " o.operation.operationPK.operationId = " + filtro.getOperationId();
			}
			
			if (filtro.getStatusId() != null) {
				query += selectKeyword() + " o.operation.status.statusId = " + filtro.getStatusId();
			}
			
			if (filtro.getStartTime() != null) {
				query += selectKeyword() + " o.operation.startTime = " + filtro.getStartTime();
			}
			
			if (filtro.getEndTime() != null) {
				query += selectKeyword() + " o.operation.endTime = " + filtro.getEndTime();
			}
			
			if (filtro.getFlow() != null) {
				query += selectKeyword() + " o.flow.flow = " + filtro.getFlow();
			}
			
			if (filtro.getInputChannel() != null) {
				query += selectKeyword() + " o.inputChannel = " + filtro.getInputChannel();
			}
			
			if (filtro.getFcId() != null) {
				query += selectKeyword() + " o.fcId = " + filtro.getFcId();
			}
			
			if (filtro.getSessionId() != null) {
				query += selectKeyword() + " o.sessionId = " + filtro.getSessionId();
			}
		}
		return emf.createEntityManager().createQuery(query, OperationData.class).getResultList();
	}

	@Override
	public List<OperationActivity> getOperationActivity(int operationId, int iteration) {
		return emf.createEntityManager()
				.createQuery("SELECT o FROM OperationActivity o WHERE o.operation.operationPK.operationId = :operationId AND o.operation.operationPK.iteration = :iteration", OperationActivity.class)
				.setParameter("operationId", operationId)
				.setParameter("iteration", iteration)
				.getResultList();
	}
	
	private boolean firstFilterAdded = false;
	private String selectKeyword () {
		if (firstFilterAdded)
			return " AND";
		else {
			firstFilterAdded = true;
			return " WERE";
		}
	}
}
