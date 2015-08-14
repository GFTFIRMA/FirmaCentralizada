package com.bs.service.firmacentralizada.auditoria.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.bs.service.firmacentralizada.auditoria.dao.AuditoriaDAO;
import com.bs.service.firmacentralizada.auditoria.dto.ActivityDTO;
import com.bs.service.firmacentralizada.auditoria.dto.BasicDTO;
import com.bs.service.firmacentralizada.auditoria.dto.OperationDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.ActivityFilterDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.OperationFilterDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.PaginationDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.SortDTO;
import com.bs.service.firmacentralizada.auditoria.entidades.Component;
import com.bs.service.firmacentralizada.auditoria.entidades.ComponentService;
import com.bs.service.firmacentralizada.auditoria.entidades.ExecutionPoint;
import com.bs.service.firmacentralizada.auditoria.entidades.Flow;
import com.bs.service.firmacentralizada.auditoria.entidades.Layer;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationActivity;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationData;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationResultCode;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationStatus;

public class AuditoriaDAOImpl implements AuditoriaDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;
		
	@Override
	public List<BasicDTO> getAllComponents() {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<Component> components = emf.createEntityManager().createQuery("SELECT c FROM Component c", Component.class).getResultList();
		
		for (Component component : components) {
			result.add(new BasicDTO(component.getComponent(), component.getDescription()));
		}
		
		return result;
	}

	@Override
	public List<BasicDTO> getAllExecutionPoints() {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<ExecutionPoint> executionPoints = emf.createEntityManager().createQuery("SELECT e FROM ExecutionPoint e", ExecutionPoint.class).getResultList();
		
		for (ExecutionPoint executionPoint : executionPoints) {
			result.add(new BasicDTO(executionPoint.getExecutionPoint(), executionPoint.getDescription()));
		}
		
		return result;
	}

	@Override
	public List<BasicDTO> getAllFlows() {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<Flow> flows = emf.createEntityManager().createQuery("SELECT f FROM Flow f", Flow.class).getResultList();
		
		for (Flow flow : flows) {
			result.add(new BasicDTO(flow.getFlow(), flow.getDescription()));
		}
		
		return result;
	}

	@Override
	public List<BasicDTO> getAllLayers() {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<Layer> layers = emf.createEntityManager().createQuery("SELECT l FROM Layer l", Layer.class).getResultList();
		
		for (Layer layer : layers) {
			result.add(new BasicDTO(layer.getLayerId(), layer.getDescription()));
		}
		
		return result;
	}

	@Override
	public List<BasicDTO> getAllOperationResultCodes() {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<OperationResultCode> codes = emf.createEntityManager().createQuery("SELECT o FROM OperationResultCode o", OperationResultCode.class).getResultList();
		
		for (OperationResultCode code : codes) {
			result.add(new BasicDTO(code.getCode(), code.getDescription()));
		}
		
		return result;
	}

	@Override
	public List<BasicDTO> getAllOperationStatus() {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<OperationStatus> opStatus = emf.createEntityManager().createQuery("SELECT o FROM OperationStatus o", OperationStatus.class).getResultList();
		
		for (OperationStatus status : opStatus) {
			result.add(new BasicDTO(status.getStatusId(), status.getDescription()));
		}
		
		return result;
	}

	@Override
	public List<BasicDTO> getAllInputChannels() {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		// TODO Implementar cuando se puedan obtener canales de entrada
		return result;
	}

	@Override
	public List<BasicDTO> getServicesByComponentId(String componentId) {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<ComponentService> services = emf.createEntityManager()
											 .createQuery("SELECT c FROM ComponentService c " +
													 	  "WHERE c.componentServicesPK.component.component = :componentId", ComponentService.class)
											 .setParameter("componentId", componentId)
											 .getResultList();
		
		for (ComponentService service : services) {
			result.add(new BasicDTO(service.getComponentServicesPK().getService(), service.getDescription()));
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OperationDTO> getOperationList(OperationFilterDTO filter, SortDTO ordination,
			PaginationDTO pagination) {
		
		String query = "SELECT o FROM OperationData o";
		if (filter != null) {
			
			if (filter.getOperationId() != null) {
				query += selectKeyword() + " o.operation.operationPK.operationId = " + filter.getOperationId();
			}
			
			if (filter.getFlow() != null) {
				query += selectKeyword() + " o.flow.flow = '" + filter.getFlow() + "'";
			}
			
			// TODO resultCode string o int?
			if (filter.getResultCode() != null) {
				query += selectKeyword() + " o.operation.resultCode.code = " + filter.getResultCode();
			}
			
			if (filter.getFcId() != null) {
				query += selectKeyword() + " o.fcId = '" + filter.getFcId() + "'";
			}
			
			if (filter.getRequestcId() != null) {
				// TODO implementar cuando se pueda recuperar el requestcId
			}
			
			if (filter.getInputChannel() != null) {
				query += selectKeyword() + " o.inputChannel = '" + filter.getInputChannel() + "'";
			}
			
			if (filter.getSessionId() != null) {
				query += selectKeyword() + " o.sessionId = '" + filter.getSessionId() + "'";
				
			}
			
			if (filter.isSendActivity()) {
				// TODO ?
			}
			
			if (filter.getStatusId() != null) {
				query += selectKeyword() + " o.operation.status.statusId = " + filter.getStatusId();
			}
			
			// Para los filtros con fechas se usará el método setParameter
			if (filter.getStartTime() != null) {
				query += selectKeyword() + " o.operation.startTime >= :startTime";
			}
			
			if (filter.getEndTime() != null) {
				query += selectKeyword() + " o.operation.endTime <= :endTime";
			}
		}
		
		Query typedQuery = emf.createEntityManager().createQuery(query, OperationData.class);
		
		if (filter.getStartTime() != null) {
			typedQuery.setParameter("startTime", filter.getStartTime(), TemporalType.TIMESTAMP);
		}
		
		if (filter.getEndTime() != null) {
			typedQuery.setParameter("endTime", filter.getEndTime(), TemporalType.TIMESTAMP);
		}
		
		return typedQuery.getResultList();
	}

	@Override
	public List<ActivityDTO> getOperationActivityList(long operationId, SortDTO ordination, PaginationDTO pagination) {
		
		List<ActivityDTO> result = new ArrayList<ActivityDTO>();
		List<OperationActivity> opActivities = emf.createEntityManager()
												.createQuery("SELECT o FROM OperationActivity o " +
															 "WHERE o.operation.operationPK.operationId = :operationId", OperationActivity.class)
												.setParameter("operationId", operationId)
												.getResultList();
		
		for (OperationActivity opActivity : opActivities) {
			ActivityDTO activity = new ActivityDTO();
			activity.setActivityId(opActivity.getActivityId());
			activity.setOperationId(opActivity.getOperation().getOperationPK().getOperationId());
			activity.setIteration(opActivity.getOperation().getOperationPK().getIteration());
			activity.setLayer(opActivity.getLayer().getDescription());
			activity.setExecutionPoint(opActivity.getExecutionPoint().getExecutionPoint());
			activity.setSourceComponent(null); //TODO
			activity.setDestinationComponent(null); //TODO
			activity.setService(opActivity.getComponentService().getComponentServicesPK().getService());
			activity.setStartTime(opActivity.getStartTime());
			activity.setEndTime(opActivity.getEndTime());
			activity.setTrackingId(opActivity.getTrackingId());
			activity.setStatusId(opActivity.getStatus().getStatusId());
			activity.setReturnCode(opActivity.getReturnCode());
			activity.setReturnDescription(opActivity.getReturnDescription());
			activity.setNode(opActivity.getNode());
				
			try {
				activity.setXmlSvcRequest(opActivity.getXmlSvcRequest().getSubString(1, (int)opActivity.getXmlSvcRequest().length()));
			} catch (SQLException e) {
				// TODO Setear un mensaje de error?
			}
			
			try {
				activity.setXmlSvcResponse(opActivity.getXmlSvcResponse().getSubString(1, (int)opActivity.getXmlSvcResponse().length()));
			} catch (SQLException e) {
				// TODO Setear un mensaje de error?
			}
			
			result.add(activity);
		}
		
		return result;
	}

	@Override
	public OperationDTO getOperationById(long operationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityDTO getActivityById(long activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityDTO> getActivityList(ActivityFilterDTO filter, SortDTO ordination, PaginationDTO pagination) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//** API PRIVADA **//
	
	private boolean firstFilterAdded = false;
	private String selectKeyword () {
		if (firstFilterAdded)
			return " AND";
		else {
			firstFilterAdded = true;
			return " WHERE";
		}
	}
}
