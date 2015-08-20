package com.bs.service.firmacentralizada.auditoria.tests;

import static org.junit.Assert.assertFalse;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bs.service.firmacentralizada.auditoria.AuditoriaConfig;
import com.bs.service.firmacentralizada.auditoria.dao.AuditoriaDAO;
import com.bs.service.firmacentralizada.auditoria.dto.ActivityDTO;
import com.bs.service.firmacentralizada.auditoria.dto.OperationDTO;
import com.bs.service.firmacentralizada.auditoria.dto.SearchResultDTO;
import com.bs.service.firmacentralizada.auditoria.dto.SearchStatsDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.ActivityFilterDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.OperationFilterDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.PaginationDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.SortDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.SortDTO.OrderField;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.SortDTO.OrderType;

public class OperationTest {
	
	//@Test
	public void testSelectOperation() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		// CAMBIAR LOS VALORES DE LOS PARÁMETROS PARA PROBAR DIFERENTES CASOS
		int operationId = 4;
		int iteration = 3;
		OperationDTO result = auditoriaDao.getOperationById(operationId, iteration);

		printOperation(result);
		
		assertFalse(result == null);
		
		context.close();
	}
	
	//@Test
	public void testSelectLastIterationByOperationId() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);

		// CAMBIAR LOS VALORES DE LOS PARÁMETROS PARA PROBAR DIFERENTES CASOS
		int operationId = 4;
		OperationDTO result = auditoriaDao.getLastIterationByOperationId(operationId);

		printOperation(result);
		
		assertFalse(result == null);
		
		context.close();
	}
	
	//@Test
	public void testSelectActivityById() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);

		// CAMBIAR LOS VALORES DE LOS PARÁMETROS PARA PROBAR DIFERENTES CASOS
		int activityId = 1114;
		ActivityDTO result = auditoriaDao.getActivityById(activityId);

		printActivity(result);
		
		assertFalse(result == null);
		
		context.close();
	}
	
	//@Test
	public void testSelectActivitiesByOperationNoSortNoPag() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);

		// CAMBIAR LOS VALORES DE LOS PARÁMETROS PARA PROBAR DIFERENTES CASOS
		int operationId = 2;
		SearchResultDTO<ActivityDTO> result = auditoriaDao.getOperationActivityList(operationId, null, null);

		printActivityList(result.getSearchData());
		printStats(result.getSearchStats());
		
		assertFalse(result == null);
		
		context.close();
	}
	
	//@Test
	public void testSelectActivitiesByOperationWithPagination() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		// CAMBIAR LOS VALORES DE LA BUSQUEDA PARA PROBAR DIFERENTES CASOS
		int operationId = 2;
		PaginationDTO pagination = new PaginationDTO();
		pagination.setNumRegisters(PaginationDTO.DEFAULT_PAGE_SIZE);
		pagination.setNumPage(PaginationDTO.DEFAULT_PAGE_NUMBER);
		
		SearchResultDTO<ActivityDTO> result = auditoriaDao.getOperationActivityList(operationId, null, pagination);

		printActivityList(result.getSearchData());
		printStats(result.getSearchStats());
		
		assertFalse(result == null);
		
		context.close();
	}
	
	//@Test
	public void testSelectActivitiesByOperationWithSort() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		// CAMBIAR LOS VALORES DE LA BUSQUEDA PARA PROBAR DIFERENTES CASOS
		int operationId = 4;
		SortDTO sort = new SortDTO();
		sort.setField(OrderField.FIN_ACTIVIDAD);
		sort.setType(OrderType.DESC);
		
		SearchResultDTO<ActivityDTO> result = auditoriaDao.getOperationActivityList(operationId, sort, null);

		printActivityList(result.getSearchData());
		printStats(result.getSearchStats());
		
		assertFalse(result == null);
		
		context.close();
	}
	
	//@Test
	public void testSelectActivitiesByOperationWithSortAndPagination() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		// CAMBIAR LOS VALORES DE LA BUSQUEDA PARA PROBAR DIFERENTES CASOS
		int operationId = 4;
		PaginationDTO pagination = new PaginationDTO();
		SortDTO sort = new SortDTO();
		pagination.setNumRegisters(3);
		pagination.setNumPage(1);
		sort.setField(OrderField.ID_ACTIVIDAD);
		sort.setType(OrderType.DESC);
		
		SearchResultDTO<ActivityDTO> result = auditoriaDao.getOperationActivityList(operationId, sort, pagination);

		printActivityList(result.getSearchData());
		printStats(result.getSearchStats());
		
		assertFalse(result == null);
		
		context.close();
	}

	//@Test
	public void testSelectFilteredActivities() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		// CAMBIAR LOS VALORES DEL FILTRO PARA PROBAR DIFERENTES CASOS
		ActivityFilterDTO filter = new ActivityFilterDTO();
		filter.setActivityId(null);
		filter.setOperationId(null);
		filter.setFlowId(null);
		filter.setResultCodeId(null);
		filter.setExecutionPointId(null);
		filter.setTrackingId(null);
		filter.setLayerId(null);
		filter.setComponentId(null);
		filter.setServiceId(null);
		filter.setStatusId(null);

		Calendar c = Calendar.getInstance();
		
		c.set(2015, 07, 11);
		Timestamp t = new Timestamp(c.getTimeInMillis());
		filter.setStartTime(null);
		
		c.set(2015, 07, 11, 00, 00, 00);
		t.setTime(c.getTimeInMillis());
		filter.setEndTime(t);
		
		SearchResultDTO<ActivityDTO> result = auditoriaDao.getActivityList(filter, null, null);

		printActivityList(result.getSearchData());
		printStats(result.getSearchStats());
		
		assertFalse(result == null);
		
		context.close();
	}

	//@Test
	public void testSelectFilteredActivitiesWithSortAndPagination() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		// CAMBIAR LOS VALORES DEL FILTRO PARA PROBAR DIFERENTES CASOS
		PaginationDTO pagination = new PaginationDTO();
		SortDTO sort = new SortDTO();
		ActivityFilterDTO filter = new ActivityFilterDTO();
		
		// Paginación
		pagination.setNumRegisters(PaginationDTO.DEFAULT_PAGE_SIZE);
		pagination.setNumPage(PaginationDTO.DEFAULT_PAGE_NUMBER);
		
		// Ordenación
		sort.setField(OrderField.ID_ACTIVIDAD);
		sort.setType(OrderType.ASC);
		
		// Filtros
		filter.setActivityId(1123L);
		filter.setOperationId(4L);
		filter.setFlowId(null);
		filter.setResultCodeId(401);
		filter.setExecutionPointId(null);
		filter.setTrackingId(null);
		filter.setLayerId(null);
		filter.setComponentId(null);
		filter.setServiceId(null);
		filter.setStatusId(null);

		Calendar c = Calendar.getInstance();
		
		c.set(2015, 7, 11, 10, 33, 00);
		Timestamp startT = new Timestamp(c.getTimeInMillis());
		filter.setStartTime(startT);
		
		c.set(2015, 7, 11, 10, 37, 00);
		Timestamp endT = new Timestamp(c.getTimeInMillis());
		filter.setEndTime(endT);
		
		SearchResultDTO<ActivityDTO> result = auditoriaDao.getActivityList(filter, sort, pagination);

		printActivityList(result.getSearchData());
		printStats(result.getSearchStats());
		
		
		assertFalse(result == null);
		
		context.close();
	}
	
	//@Test
	public void testSelectFilteredOperationsNoSortNoPag() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);

		// CAMBIAR LOS VALORES DE LOS PARÁMETROS PARA PROBAR DIFERENTES CASOS
		OperationFilterDTO filter = new OperationFilterDTO();
		
		filter.setOperationId(null);
		filter.setFlowId(null);
		filter.setResultCodeId(null);
		filter.setFcId(null);
		filter.setRequestcId(null);
		filter.setInputChannel(null);
		filter.setSessionId(null);
		filter.setStatusId(null);

		Calendar c = Calendar.getInstance();
		
		c.set(2015, 07, 11);
		Timestamp t = new Timestamp(c.getTimeInMillis());
		filter.setStartTime(null);
		
		c.set(2015, 07, 11, 00, 00, 00);
		t.setTime(c.getTimeInMillis());
		filter.setEndTime(null);
		
		SearchResultDTO<OperationDTO> result = auditoriaDao.getOperationList(filter, null, null);

		printOperationList(result.getSearchData());
		printStats(result.getSearchStats());
		
		assertFalse(result == null);
		
		context.close();
	}
	
	@Test
	public void testSelectFilteredOperationsWithSortAndPag() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);

		// CAMBIAR LOS VALORES DE LOS PARÁMETROS PARA PROBAR DIFERENTES CASOS
		PaginationDTO pagination = new PaginationDTO();
		SortDTO sort = new SortDTO();
		OperationFilterDTO filter = new OperationFilterDTO();
		
		// Paginación
		pagination.setNumRegisters(3);
		pagination.setNumPage(1);
		
		// Ordenación
		sort.setField(OrderField.INICIO_OPERACION);
		sort.setType(OrderType.DESC);
		
		// Filtros
		filter.setOperationId(null);
		filter.setFlowId(null);
		filter.setResultCodeId(200);
		filter.setFcId(null);
		filter.setRequestcId(null);
		filter.setInputChannel(null);
		filter.setSessionId("session_sess4");
		filter.setStatusId(100);

		Calendar c = Calendar.getInstance();
		
		c.set(2015, 06, 15, 7, 13, 00);
		Timestamp startT = new Timestamp(c.getTimeInMillis());
		filter.setStartTime(startT);
		
		c.set(2015, 06, 15, 8, 17, 59);
		Timestamp endT = new Timestamp(c.getTimeInMillis());
		filter.setEndTime(null);
		
		SearchResultDTO<OperationDTO> result = auditoriaDao.getOperationList(filter, sort, pagination);

		printOperationList(result.getSearchData());
		printStats(result.getSearchStats());
		
		assertFalse(result == null);
		
		context.close();
	}
	
	//** UTILIDADES **//
	
	private void printStats(SearchStatsDTO s) {
		System.out.println();
		System.out.println(" -- TOTAL RESULTS: " + s.getTotalResults());
		System.out.println(" -- CURRENT PAGE: " + s.getCurrentPage());
		System.out.println(" -- TOTAL PAGES: " + s.getTotalPages());
		System.out.println();
	}

	private void printOperationList(List<OperationDTO> oList) {
		System.out.println();
		System.out.println(" -- TOTAL ENTRIES: " + oList.size());
		for (OperationDTO o : oList) {
			printOperation(o);
		}
	}
	
	private void printOperation(OperationDTO o) {
		
		if (o == null) {
			System.out.println("  NO DATA");
			return;
		}

		System.out.println();
		System.out.println("  ---- OPERATION ID: " + o.getOperationId());
		System.out.println("  ---- ITERATION: " + o.getIteration());
		System.out.println("  ---- FC ID: " + o.getFcId());
		System.out.println("  ---- FLOW: " + o.getFlow());
		System.out.println("  ---- RESULT CODE: " + o.getResultCode());
		System.out.println("  ---- INPUT CHANNEL: " + o.getInputChannel());
		System.out.println("  ---- STATUS ID: " + o.getStatusId());
		System.out.println("  ---- REQUEST C: " + o.getRequestcId());
		System.out.println("  ---- SESSION ID: " + o.getSessionId());
		System.out.println("  ---- START TIME: " + o.getStartTime());
		System.out.println("  ---- END TIME: " + o.getEndTime());
	}

	private void printActivityList(List<ActivityDTO> aList) {
		System.out.println();
		System.out.println(" -- TOTAL ENTRIES: " + aList.size());
		for (ActivityDTO a : aList) {
			printActivity(a);
		}
	}
	
	private void printActivity(ActivityDTO a) {
		
		if (a == null) {
			System.out.println("  NO DATA");
			return;
		}

		System.out.println();
		System.out.println("  ---- ACTIVITY ID: " + a.getActivityId());
		System.out.println("  ---- OPERATION ID: " + a.getOperationId());
		System.out.println("  ---- ITERATION: " + a.getIteration());
		System.out.println("  ---- LAYER: " + a.getLayer());
		System.out.println("  ---- SOURCE COMPONENT: " + a.getSourceComponent());
		System.out.println("  ---- DEST COMPONENT: " + a.getDestinationComponent());
		System.out.println("  ---- DEST SERVICE: " + a.getService());
		System.out.println("  ---- EXECUTION POINT: " + a.getExecutionPoint());
		System.out.println("  ---- ACTIVITY START TIME: " + a.getStartTime());
		System.out.println("  ---- ACTIVITY END TIME: " + a.getEndTime());
		System.out.println("  ---- TRACKING ID: " + a.getTrackingId());
		System.out.println("  ---- NODE: " + a.getNode());
		System.out.println("  ---- STATUS ID: " + a.getStatusId());
		System.out.println("  ---- RETURN CODE: " + a.getReturnCode());
		System.out.println("  ---- RETURN DESCRIPTION: " + a.getReturnDescription());
		System.out.println("  ---- REQUEST: " + a.getXmlSvcRequest());
		System.out.println("  ---- RESPONSE: " + a.getXmlSvcResponse());
	}
}
