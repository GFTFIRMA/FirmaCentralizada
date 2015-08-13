package com.bs.service.firmacentralizada.auditoria.tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bs.service.firmacentralizada.auditoria.AuditoriaConfig;
import com.bs.service.firmacentralizada.auditoria.dao.AuditoriaDAO;
import com.bs.service.firmacentralizada.auditoria.dao.OperationDataFilter;
import com.bs.service.firmacentralizada.auditoria.entidades.Operation;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationActivity;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationData;

public class OperationTest {
	
	@Test
	public void testSelectOperationActivity() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		List<OperationActivity> result = auditoriaDao.getOperationActivity(4, 1);
		
		System.out.println(" -- Número de entradas: " + result.size());
		for (int i = 0; i < result.size(); i++) 
			printOperationActivity(result.get(i));
		
		assertFalse(result.isEmpty());
		context.close();
	}
	
	@Test
	public void testSelectAllOperationData() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		List<OperationData> result = auditoriaDao.getOperationData(null);
		
		System.out.println(" -- Número de entradas: " + result.size());
		for (int i = 0; i < result.size(); i++) 
			printOperationData(result.get(i));
		
		assertFalse(result.isEmpty());
		context.close();
	}
	
	@Test
	public void testSelectFilteredOperationData() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		OperationDataFilter odf = new OperationDataFilter();
		Calendar d = Calendar.getInstance();
		odf.setOperationId(4);
		odf.setFlow("20");
		odf.setSessionId("sessionabcdef");
		odf.setFcId("fcidabcdef");
		odf.setStatusId(12);
		d.set(2015, 06, 12, 14, 34, 00);
		odf.setStartTime(new Date(d.getTimeInMillis()));
		d.set(2015, 06, 12, 15, 59, 59);
		odf.setEndTime(new Date(d.getTimeInMillis()));
		odf.setInputChannel("inputChannel1");
		
		List<OperationData> result = auditoriaDao.getOperationData(odf);
		
		System.out.println(" -- Número de entradas: " + result.size());
		for (int i = 0; i < result.size(); i++) 
			printOperationData(result.get(i));
		
		assertFalse(result.isEmpty());
		context.close();
	}
	
	@Test
	public void testSelectNumIterations() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		Integer i = auditoriaDao.getTotalIterations(4);
		
		System.out.println(" -- Número de iteraciones: " + i);
		
		assertTrue(i == 3);
		context.close();
	}
	
	//** UTILIDADES **//
	
	private void printOperation(Operation o) {
		System.out.println("  ---- OPERATION ID: " + o.getOperationPK().getOperationId());
		System.out.println("  ---- ITERATION: " + o.getOperationPK().getIteration());
		System.out.println("  ---- OPERATION START TIME: " + o.getStartTime());
		System.out.println("  ---- OPERATION END TIME: " + o.getEndTime());
		System.out.println("  ---- RESULT CODE: " + o.getResultCode().getCode());
		System.out.println("  ---- OPERATION NODE: " + o.getNode());
		System.out.println("  ---- OPERATION STATUS ID: " + o.getStatus().getStatusId());
	}
	
	private void printOperationData(OperationData o) {
		printOperation(o.getOperation());
		System.out.println("  ---- FLOW: " + o.getFlow().getFlow());
		System.out.println("  ---- INPUT_CHANNEL: " + o.getInputChannel());
		System.out.println("  ---- FC_ID: " + o.getFcId());
		System.out.println("  ---- SESSION_ID: " + o.getSessionId());
		System.out.println("  ---- REQUEST: " + o.getXmlRequest());
		System.out.println("  ---- RESPONSE: " + o.getXmlResponse());
	}
	
	private void printOperationActivity(OperationActivity o) {
		System.out.println("  ---- ACTIVITY ID: " + o.getActivityId());
		printOperation(o.getOperation());
		System.out.println("  ---- LAYER ID: " + o.getLayer().getLayerId());
		System.out.println("  ---- COMPONENT: " + o.getComponentService().getComponentServicesPK().getComponent().getComponent());
		System.out.println("  ---- SERVICE: " + o.getComponentService().getComponentServicesPK().getService());
		System.out.println("  ---- EXECUTION POINT: " + o.getExecutionPoint().getExecutionPoint());
		System.out.println("  ---- ACTIVITY START TIME: " + o.getStartTime());
		System.out.println("  ---- ACTIVITY END TIME: " + o.getEndTime());
		System.out.println("  ---- TRACKING ID: " + o.getTrackingId());
		System.out.println("  ---- ACTIVITY NODE: " + o.getNode());
		System.out.println("  ---- STATUS ID: " + o.getStatus().getStatusId());
		System.out.println("  ---- RETURN CODE: " + o.getReturnCode());
		System.out.println("  ---- RETURN DESCRIPTION: " + o.getReturnDescription());
		System.out.println("  ---- REQUEST: " + o.getXmlSvcRequest());
		System.out.println("  ---- RESPONSE: " + o.getXmlSvcResponse());
	}
}
