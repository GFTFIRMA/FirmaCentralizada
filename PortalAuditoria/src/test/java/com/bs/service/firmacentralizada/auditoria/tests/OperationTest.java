package com.bs.service.firmacentralizada.auditoria.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bs.service.firmacentralizada.auditoria.AuditoriaConfig;
import com.bs.service.firmacentralizada.auditoria.dao.AuditoriaDAO;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationData;

public class OperationTest {
	
	private void changeBoolean(Boolean b) {
		b ^= b;
	}
	
	@Test
	public void testSelectOperationActivity() {
		
		Boolean b = false;
		System.out.println(b);
		changeBoolean(b);
		System.out.println(b);
		changeBoolean(b);
		System.out.println(b);
		changeBoolean(b);
		System.out.println(b);
		
		
//		
//		AnnotationConfigApplicationContext context =
//			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
//		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
//		List<OperationActivity> result = auditoriaDao.getOperationActivity(4, 1);
//		
//		System.out.println(" -- Número de entradas: " + result.size());
//		
//		for (int index = 0; index < result.size(); index++) {
//			System.out.println();
//			System.out.println("  --- " + (index + 1));
//			System.out.println("  ---- ACTIVITY_ID: " + result.get(index).getActivityId());
//			System.out.println("  ---- OPERATION_ID: " + result.get(index).getOperation().getOperationPK().getOperationId());
//			System.out.println("  ---- ITERATION: " + result.get(index).getOperation().getOperationPK().getIteration());
//			System.out.println("  ---- STEP: " + result.get(index).getStepId());
//			System.out.println("  ---- LAYER: " + result.get(index).getLayer().getLayerId());
//			System.out.println("  ---- COMPONENT: " + result.get(index).getComponentService().getComponentServicesPK().getComponent().getComponent());
//			System.out.println("  ---- SERVICE: " + result.get(index).getComponentService().getComponentServicesPK().getService());
//			System.out.println("  ---- EXECUTION_POINT: " + result.get(index).getExecutionPoint().getExecutionPoint());
//			System.out.println("  ---- START: " + result.get(index).getStartTime());
//			System.out.println("  ---- END: " + result.get(index).getEndTime());
//			System.out.println("  ---- TRACKING: " + result.get(index).getTrackingId());
//			System.out.println("  ---- REQUEST: " + result.get(index).getXmlSvcRequest());
//			System.out.println("  ---- RESPONSE: " + result.get(index).getXmlSvcResponse());
//			System.out.println("  ---- CONTEXT: " + result.get(index).getXmlSvcContext());
//			System.out.println("  ---- STATUS: " + result.get(index).getStatus().getStatusId());
//			System.out.println("  ---- RETURN CODE: " + result.get(index).getReturnCode());
//			System.out.println("  ---- RETURN DESCRIPTION: " + result.get(index).getReturnDescription());
//			System.out.println("  ---- NODE: " + result.get(index).getNode());
//		}
		
		assertTrue(b);
	}
	
	//@Test
	public void testSelectAllOperationData() {
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		List<OperationData> components = auditoriaDao.getOperationData(null);
		printFormat(components);
		assertFalse(components.isEmpty());
		context.close();
	}
	
	private void printFormat(List<OperationData> components) {
		System.out.println(" -- Número de entradas: " + components.size());
		
		for (int index = 0; index < components.size(); index++) {
			System.out.println();
			System.out.println("  --- " + (index + 1));
			System.out.println("  ---- OPERATION_ID: " + components.get(index).getOperation().getOperationPK().getOperationId());
			System.out.println("  ---- ITERATION: " + components.get(index).getOperation().getOperationPK().getIteration());
			System.out.println("  ---- NODO: " + components.get(index).getOperation().getNode());
			System.out.println("  ---- RESULT_CODE: " + components.get(index).getOperation().getResultCode().getCode());
			System.out.println("  ---- FLOW: " + components.get(index).getFlow());
			System.out.println("  ---- REQUEST_ID: " + components.get(index).getRequestId());
			System.out.println("  ---- FC_ID: " + components.get(index).getFcId());
			System.out.println("  ---- SESSION_ID: " + components.get(index).getSessionId());
		}
	}

}
