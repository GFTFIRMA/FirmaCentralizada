package com.bs.service.firmacentralizada.auditoria.dao.impl;

import java.math.BigDecimal;
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
import com.bs.service.firmacentralizada.auditoria.dto.SearchResultDTO;
import com.bs.service.firmacentralizada.auditoria.dto.SearchStatsDTO;
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
			result.add(new BasicDTO(component.getComponentId(), component.getDescription()));
		}
		
		return result;
	}

	@Override
	public List<BasicDTO> getAllExecutionPoints() {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<ExecutionPoint> executionPoints = emf.createEntityManager().createQuery("SELECT e FROM ExecutionPoint e", ExecutionPoint.class).getResultList();
		
		for (ExecutionPoint executionPoint : executionPoints) {
			result.add(new BasicDTO(executionPoint.getExecutionPointId(), executionPoint.getDescription()));
		}
		
		return result;
	}

	@Override
	public List<BasicDTO> getAllFlows() {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<Flow> flows = emf.createEntityManager().createQuery("SELECT f FROM Flow f", Flow.class).getResultList();
		
		for (Flow flow : flows) {
			result.add(new BasicDTO(flow.getFlowId(), flow.getDescription()));
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

	@SuppressWarnings("unchecked")
	@Override
	public List<BasicDTO> getAllInputChannels() {

		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<Object[]> inputChannels= emf.createEntityManager().createNativeQuery("SELECT * FROM FC_GCONFIG_REGLAS WHERE TABLA_ID = 'GLOBAL_CANALESENTRADA'").getResultList();
		
		for (Object[] inputChannel : inputChannels) {
			
			if (((String)inputChannel[5]).equals("L_CONFIG"))
				continue;
			
			result.add(new BasicDTO(((BigDecimal)inputChannel[0]).longValue(), (String) inputChannel[4]));
		}
		
		return result;
	}

	@Override
	public List<BasicDTO> getServicesByComponentId(long componentId) {
		
		List<BasicDTO> result = new ArrayList<BasicDTO>();
		List<ComponentService> services = emf.createEntityManager()
											 .createQuery("SELECT c FROM ComponentService c " +
													 	  "WHERE c.component.componentId = :componentId", ComponentService.class)
											 .setParameter("componentId", componentId)
											 .getResultList();
		
		for (ComponentService service : services) {
			result.add(new BasicDTO(service.getServiceId(), service.getDescription()));
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public SearchResultDTO<OperationDTO> getOperationList(OperationFilterDTO filter, SortDTO ordination, PaginationDTO pagination) {
		
		List<OperationDTO> searchData = new ArrayList<OperationDTO>();
		SearchResultDTO<OperationDTO> searchResult = new SearchResultDTO<OperationDTO>();
		SearchStatsDTO stats = new SearchStatsDTO();
		
		String query = "SELECT o FROM OperationData o";
		if (filter != null) {
			
			if (filter.getOperationId() != null) {
				query += selectKeyword() + " o.operation.operationPK.operationId = " + filter.getOperationId();
			}
			
			if (filter.getFlowId() != null) {
				query += selectKeyword() + " o.flow.flowId = " + filter.getFlowId();
			}
			
			if (filter.getResultCodeId() != null) {
				query += selectKeyword() + " o.operation.resultCode.code = " + filter.getResultCodeId();
			}
			
			if (filter.getFcId() != null) {
				query += selectKeyword() + " o.fcId = '" + filter.getFcId() + "'";
			}
			
			if (filter.getRequestcId() != null) {
				query += selectKeyword() + " o.requestcId = '" + filter.getRequestcId() + "'";
			}
			
			if (filter.getInputChannel() != null) {
				query += selectKeyword() + " o.inputChannel = '" + filter.getInputChannel() + "'";
			}
			
			if (filter.getSessionId() != null) {
				query += selectKeyword() + " o.sessionId = '" + filter.getSessionId() + "'";
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
			query += " ORDER BY o." + ordination.getFieldAsString() + " " + ordination.getTypeAsString();
		}
		
		Query typedQuery = emf.createEntityManager().createQuery(query, OperationData.class);
		
		if (filter.getStartTime() != null) {
			typedQuery.setParameter("startTime", filter.getStartTime(), TemporalType.TIMESTAMP);
		}
		
		if (filter.getEndTime() != null) {
			typedQuery.setParameter("endTime", filter.getEndTime(), TemporalType.TIMESTAMP);
		}

		stats = setStats(typedQuery, pagination);
		
		// Paginación
		if (pagination != null) {
			typedQuery.setFirstResult(retrieveFirstPosition(pagination.getNumPage(), pagination.getNumRegisters()))
					  .setMaxResults(pagination.getNumRegisters());
		}
		
		List<OperationData> operations = typedQuery.getResultList();
		
		for (OperationData operation : operations) {
			searchData.add(buildOperationDtoFromOperationData(operation));
		}
		
		searchResult.setSearchData(searchData);
		searchResult.setSearchStats(stats);
		
		return searchResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SearchResultDTO<ActivityDTO> getActivityList(ActivityFilterDTO filter, SortDTO ordination, PaginationDTO pagination) {
		
		List<ActivityDTO> searchData = new ArrayList<ActivityDTO>();
		SearchResultDTO<ActivityDTO> searchResult = new SearchResultDTO<ActivityDTO>();
		SearchStatsDTO stats = new SearchStatsDTO();

		String query = "SELECT a FROM OperationActivity a";
		if (filter != null) {
			
			if (filter.getActivityId() != null) {
				query += selectKeyword() + " a.activityId = " + filter.getActivityId();
			}
			
			if (filter.getOperationId() != null) {
				query += selectKeyword() + " a.operation.operationPK.operationId = " + filter.getOperationId();
			}
			
			if (filter.getFlowId() != null) {
				query += selectKeyword() + " a.operation.operationPK.operationId = " + 
										   "(SELECT od.operation.operationPK.operationId FROM OperationData od WHERE od.flow.flowId = " + filter.getFlowId() +
										   " AND od.operation.operationPK.operationId = a.operation.operationPK.operationId" +
										   " AND od.operation.operationPK.iteration = a.operation.operationPK.iteration)";
			}
			
			if (filter.getResultCodeId() != null) {
				query += selectKeyword() + " a.operation.resultCode.code = " + filter.getResultCodeId();
			}
			
			if (filter.getExecutionPointId() != null) {
				query += selectKeyword() + " a.executionPoint.executionPointId = " + filter.getExecutionPointId();
			}
			
			if (filter.getTrackingId() != null) {
				query += selectKeyword() + " a.trackingId = '" + filter.getTrackingId() + "'";
			}
			
			if (filter.getLayerId() != null) {
				query += selectKeyword() + " a.layer.layerId = " + filter.getLayerId();
			}
			
			if (filter.getComponentId() != null) {
				query += selectKeyword() + " a.origComponent.componentId = " + filter.getComponentId();
			}
			
			if (filter.getServiceId() != null) {
				query += selectKeyword() + " a.destService.serviceId = " + filter.getServiceId();
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
			query += " ORDER BY a." + ordination.getFieldAsString() + " " + ordination.getTypeAsString();
		}

		Query typedQuery = emf.createEntityManager().createQuery(query, OperationActivity.class);
		
		if (filter.getStartTime() != null) {
			typedQuery.setParameter("startTime", filter.getStartTime(), TemporalType.TIMESTAMP);
		}
		
		if (filter.getEndTime() != null) {
			typedQuery.setParameter("endTime", filter.getEndTime(), TemporalType.TIMESTAMP);
		}
		
		stats = setStats(typedQuery, pagination);
		
		// Paginación
		if (pagination != null) {
			typedQuery.setFirstResult(retrieveFirstPosition(pagination.getNumPage(), pagination.getNumRegisters()))
					  .setMaxResults(pagination.getNumRegisters());
		}
		
		List<OperationActivity> activities = typedQuery.getResultList();
		
		for (OperationActivity opActivity : activities) {
			searchData.add(buildActivityDtoFromOperationActivity(opActivity));
		}

		searchResult.setSearchData(searchData);
		searchResult.setSearchStats(stats);
		
		return searchResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SearchResultDTO<ActivityDTO> getOperationActivityList(long operationId, SortDTO ordination, PaginationDTO pagination) {
		
		List<ActivityDTO> searchData = new ArrayList<ActivityDTO>();
		SearchResultDTO<ActivityDTO> searchResult = new SearchResultDTO<ActivityDTO>();
		SearchStatsDTO stats = new SearchStatsDTO();
		
		String query = "SELECT o FROM OperationActivity o " +
				 	   "WHERE o.operation.operationPK.operationId = " + operationId;
		
		// Ordenacion
		if (ordination != null) {
			query += " ORDER BY o." + ordination.getFieldAsString() + " " + ordination.getTypeAsString();
		}
		
		Query typedQuery = emf.createEntityManager().createQuery(query, OperationActivity.class);
		stats = setStats(typedQuery, pagination);
		
		// Paginación
		if (pagination != null) {
			typedQuery.setFirstResult(retrieveFirstPosition(pagination.getNumPage(), pagination.getNumRegisters()))
					  .setMaxResults(pagination.getNumRegisters());
		}
		
		List<OperationActivity> opActivities = typedQuery.getResultList();
		
		for (OperationActivity opActivity : opActivities) {
			searchData.add(buildActivityDtoFromOperationActivity(opActivity));
		}
		
		searchResult.setSearchStats(stats);
		searchResult.setSearchData(searchData);
		
		return searchResult;
	}

	@Override
	public OperationDTO getLastIterationByOperationId(long operationId) {
		
		List<OperationData> operation = emf.createEntityManager()
				.createQuery("SELECT o FROM OperationData o " +
							 "WHERE o.operation.operationPK.operationId = :operationId " +
							 "ORDER BY o.operation.operationPK.iteration DESC", OperationData.class)
				.setParameter("operationId", operationId)
				.getResultList();
		
		if (operation != null && !operation.isEmpty()) {
			return buildOperationDtoFromOperationData(operation.get(0));
		}
		
		return null;
	}
	
	@Override
	public OperationDTO getOperationById(long operationId, int iteration) {
		
		List<OperationData> operation = emf.createEntityManager()
				.createQuery("SELECT o FROM OperationData o " +
							 "WHERE o.operation.operationPK.operationId = :operationId " +
							 "AND o.operation.operationPK.iteration = :iteration", OperationData.class)
				.setParameter("operationId", operationId)
				.setParameter("iteration", iteration)
				.getResultList();
		
		if (operation != null && operation.size() == 1) {
			return buildOperationDtoFromOperationData(operation.get(0));
		}
		
		return null;
	}

	@Override
	public ActivityDTO getActivityById(long activityId) {
		
		List<OperationActivity> activityList = emf.createEntityManager()
				.createQuery("SELECT a FROM OperationActivity a " +
							 "WHERE a.activityId = :activityId", OperationActivity.class)
				.setParameter("activityId", activityId)
				.getResultList();
		
		if (activityList != null && activityList.size() == 1) {
			return buildActivityDtoFromOperationActivity(activityList.get(0));
		}
		
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
	
	private SearchStatsDTO setStats(Query query, PaginationDTO pagination) {
		
		SearchStatsDTO stats = new SearchStatsDTO();
		
		stats.setTotalResults(query.getResultList().size());
		stats.setCurrentPage(pagination == null ? 1 : pagination.getNumPage());
		stats.setTotalPages(pagination == null ? 1 : (int) Math.ceil((float) stats.getTotalResults() / (float) pagination.getNumRegisters()));
		
		return stats;
	}
	
	private int retrieveFirstPosition(int pageNumber, int pageSize) {
		int iMaxRow = pageNumber * pageSize;
		int iMinRow = iMaxRow - pageSize;
		return iMinRow;
	}
	
	private OperationDTO buildOperationDtoFromOperationData(OperationData operationData) {
	
		OperationDTO operation = new OperationDTO();
		
		operation.setOperationId(operationData.getOperation().getOperationPK().getOperationId());
		operation.setIteration(operationData.getOperation().getOperationPK().getIteration());
		operation.setFlow(operationData.getFlow().getDescription());
		operation.setStartTime(operationData.getOperation().getStartTime());
		operation.setEndTime(operationData.getOperation().getEndTime());
		operation.setStatusId(operationData.getOperation().getStatus().getStatusId());
		operation.setResultCode(operationData.getOperation().getResultCode().getDescription());
		operation.setFcId(operationData.getFcId());
		operation.setRequestcId(operationData.getRequestcId());
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
		activity.setExecutionPoint(opActivity.getExecutionPoint().getDescription());
		activity.setSourceComponent(opActivity.getOrigComponent().getDescription());
		activity.setDestinationComponent(opActivity.getDestService().getComponent().getDescription());
		activity.setService(opActivity.getDestService().getDescription());
		activity.setStartTime(opActivity.getStartTime());
		activity.setEndTime(opActivity.getEndTime());
		activity.setTrackingId(opActivity.getTrackingId());
		activity.setStatusId(opActivity.getStatus().getStatusId());
		activity.setReturnCode(opActivity.getReturnCode());
		activity.setReturnDescription(opActivity.getReturnDescription());
		activity.setNode(opActivity.getNode());
		
		if (opActivity.getXmlSvcRequest() != null) {
			try {
				activity.setXmlSvcRequest(opActivity.getXmlSvcRequest().getSubString(1, (int)opActivity.getXmlSvcRequest().length()));
			} catch (Exception e) {
				activity.setXmlSvcRequest("Ha ocurrido el siguente error recuperando la petición: " + e);
			}
		}
		
		if (opActivity.getXmlSvcResponse() != null) {
			try {
				activity.setXmlSvcResponse(opActivity.getXmlSvcResponse().getSubString(1, (int)opActivity.getXmlSvcResponse().length()));
			} catch (Exception e) {
				activity.setXmlSvcResponse("Ha ocurrido el siguente error recuperando la respuesta: " + e);
			}
		}
		
		return activity;
	}
}