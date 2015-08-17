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
													 	  "WHERE c.componentServicePK.component.component = :componentId", ComponentService.class)
											 .setParameter("componentId", componentId)
											 .getResultList();
		
		for (ComponentService service : services) {
			result.add(new BasicDTO(service.getComponentServicePK().getService(), service.getDescription()));
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OperationDTO> getOperationList(OperationFilterDTO filter, SortDTO ordination, PaginationDTO pagination) {
		
		List<OperationDTO> result = new ArrayList<OperationDTO>();
		
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
			
			// Para los filtros con fechas se usará el método Query.setParameter
			if (filter.getStartTime() != null) {
				query += selectKeyword() + " o.operation.startTime >= :startTime";
			}
			
			if (filter.getEndTime() != null) {
				query += selectKeyword() + " o.operation.endTime <= :endTime";
			}
		}
		
		// Ordenación
		if (ordination != null) {
			query += " ORDER BY o." + ordination.getField();
		}
		
		Query typedQuery = emf.createEntityManager().createQuery(query, OperationData.class);
		
		if (filter.getStartTime() != null) {
			typedQuery.setParameter("startTime", filter.getStartTime(), TemporalType.TIMESTAMP);
		}
		
		if (filter.getEndTime() != null) {
			typedQuery.setParameter("endTime", filter.getEndTime(), TemporalType.TIMESTAMP);
		}
		
		// Paginación
		if (pagination != null) {
			int startPosition = retrieveLowRowRange(pagination.getNumPage(), pagination.getNumRegisters());
			int maxResults = retrieveHighRowRange(pagination.getNumPage(), pagination.getNumRegisters());
			typedQuery.setFirstResult(startPosition).setMaxResults(maxResults);
		}
		
		List<OperationData> operations = typedQuery.getResultList();
		
		for (OperationData operation : operations) {
			result.add(buildOperationDtoFromOperationData(operation));
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityDTO> getActivityList(ActivityFilterDTO filter, SortDTO ordination, PaginationDTO pagination) {
		List<ActivityDTO> result = new ArrayList<ActivityDTO>();

		String query = "SELECT a FROM OperationActivity a";
		if (filter != null) {
			
			if (filter.getActivityId() != null) {
				query += selectKeyword() + " a.activityId = " + filter.getActivityId();
			}
			
			if (filter.getOperationId() != null) {
				query += selectKeyword() + " a.operation.operationPK.operationId = " + filter.getOperationId();
			}
			
			if (filter.getFlow() != null) {
				query += selectKeyword() + " a.flow.flow = '" + filter.getFlow() + "'";
			}
			
			if (filter.getResultCode() != null) {
				query += selectKeyword() + " a.operation.resultCode.code = " + filter.getResultCode();
			}
			
			if (filter.getExecutionPoint() != null) {
				query += selectKeyword() + "a.executionPoint = '" + filter.getExecutionPoint() + "'";
			}
			
			if (filter.getTrackingId() != null) {
				query += selectKeyword() + "a.trackingId = '" + filter.getTrackingId() + "'";
			}
			
			if (filter.getLayer() != null) {
				query += selectKeyword() + "a.layer.layerId = " + filter.getLayer();
			}
			
			if (filter.getComponent() != null) {
				query += selectKeyword() + "a.componentService.componentServicePK.component.component = '" + filter.getComponent() + "'";
			}
			
			if (filter.getService() != null) {
				query += selectKeyword() + "a.componentService.componentServicePK.service = '" + filter.getService() +"'";
			}
			
			if (filter.getStatusId() != null) {
				query += selectKeyword() + " a.status.statusId = " + filter.getStatusId();
			}
			
			// Para los filtros con fechas se usará el método setParameter
			if (filter.getStartTime() != null) {
				query += selectKeyword() + " a.startTime >= :startTime";
			}
			
			if (filter.getEndTime() != null) {
				query += selectKeyword() + " a.endTime <= :endTime";
			}
		}
		
		// Ordenación
		if (ordination != null) {
			query += " ORDER BY a." + ordination.getField();
		}

		Query typedQuery = emf.createEntityManager().createQuery(query, OperationActivity.class);
		
		if (filter.getStartTime() != null) {
			typedQuery.setParameter("startTime", filter.getStartTime(), TemporalType.TIMESTAMP);
		}
		
		if (filter.getEndTime() != null) {
			typedQuery.setParameter("endTime", filter.getEndTime(), TemporalType.TIMESTAMP);
		}
		
		// Paginación
		if (pagination != null) {
			int startPosition = retrieveLowRowRange(pagination.getNumPage(), pagination.getNumRegisters());
			int maxResults = retrieveHighRowRange(pagination.getNumPage(), pagination.getNumRegisters());
			typedQuery.setFirstResult(startPosition).setMaxResults(maxResults);
		}
		
		List<OperationActivity> activities = typedQuery.getResultList();
		
		for (OperationActivity opActivity : activities) {
			result.add(buildActivityDtoFromOperationActivity(opActivity));
		}

		return result;
	}

	@Override
	public List<ActivityDTO> getOperationActivityList(long operationId, SortDTO ordination, PaginationDTO pagination) {
		
		List<ActivityDTO> result = new ArrayList<ActivityDTO>();
		List<OperationActivity> opActivities = emf.createEntityManager()
												.createQuery("SELECT o FROM OperationActivity o " +
															 "WHERE o.operation.operationPK.operationId = :operationId", OperationActivity.class)
												.setParameter("operationId", operationId)
												.getResultList();
		
		// TODO incluir paginación y ordenación
		
		for (OperationActivity opActivity : opActivities) {
			result.add(buildActivityDtoFromOperationActivity(opActivity));
		}
		
		return result;
	}

	@Override
	public OperationDTO getLastIterationByOperationId(long operationId) {
		OperationDTO result = new OperationDTO();
		// TODO
		return result;
	}
	
	@Override
	public OperationDTO getOperationById(long operationId, int iteration) {
		OperationDTO result = new OperationDTO();
		List<OperationData> operation = emf.createEntityManager()
				.createQuery("SELECT o FROM Operation o " +
							 "WHERE o.operation.operationPK.operationId = :operationId", OperationData.class)
				.setParameter("operationId", operationId)
				.getResultList();
		
		// TODO -> qué devuelve este método si hay varias entradas para el mismo id con diferentes iteraciones?
		
		return result;
	}

	@Override
	public ActivityDTO getActivityById(long activityId) {
		ActivityDTO result = new ActivityDTO();
		List<OperationActivity> activityList = emf.createEntityManager()
				.createQuery("SELECT a FROM OperationActivity a " +
							 "WHERE a.activityId = :activityId", OperationActivity.class)
				.setParameter("activityId", activityId)
				.getResultList();
		
		if (activityList != null && activityList.size() == 1) {
			result = buildActivityDtoFromOperationActivity(activityList.get(0));
		} else {
			// TODO Devolver mensaje de error?
		}
		return result;
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
	
	private OperationDTO buildOperationDtoFromOperationData(OperationData operationData) {
	
		OperationDTO operation = new OperationDTO();
		
		operation.setOperationId(operationData.getOperation().getOperationPK().getOperationId());
		operation.setIteration(operationData.getOperation().getOperationPK().getIteration());
		operation.setFlow(operationData.getFlow().getFlow());
		operation.setStartTime(operationData.getOperation().getStartTime());
		operation.setEndTime(operationData.getOperation().getEndTime());
		operation.setStatusId(operationData.getOperation().getStatus().getStatusId());
		operation.setResultCode(operationData.getOperation().getResultCode().getDescription());
		operation.setFcId(operationData.getFcId());
		operation.setRequestcId(-1); // TODO
		operation.setInputChannel(operationData.getInputChannel());
		operation.setSessionId(operationData.getSessionId());
		
		return operation;
	}
	
	private ActivityDTO buildActivityDtoFromOperationActivity(OperationActivity opActivity) {
		
		ActivityDTO activity = new ActivityDTO();
		
		activity.setActivityId(opActivity.getActivityId());
		activity.setOperationId(opActivity.getOperation().getOperationPK().getOperationId());
		activity.setIteration(opActivity.getOperation().getOperationPK().getIteration());
		activity.setLayer(opActivity.getLayer().getDescription());
		activity.setExecutionPoint(opActivity.getExecutionPoint().getExecutionPoint());
		activity.setSourceComponent(null); //TODO
		activity.setDestinationComponent(null); //TODO
		activity.setService(opActivity.getComponentService().getComponentServicePK().getService());
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
		
		return activity;
	}
	
	private int retrieveLowRowRange(int pageNumber, int pageSize) {
		int iMaxRow = pageNumber * pageSize;
		int iMinRow = iMaxRow - pageSize + 1;
		return iMinRow;
	}

	private int retrieveHighRowRange(int pageNumber, int pageSize) {
		int numberOfRows = pageNumber * pageSize;
		return numberOfRows;
	}
}
