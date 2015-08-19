package com.bs.service.firmacentralizada.auditoria.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bs.service.firmacentralizada.auditoria.AuditoriaConfig;
import com.bs.service.firmacentralizada.auditoria.dao.AuditoriaDAO;
import com.bs.service.firmacentralizada.auditoria.dto.BasicDTO;

public class MasterTablesTest {
	
	//@Test
	public void testSelectAllFlows() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		List<BasicDTO> flows = auditoriaDao.getAllFlows();

		printBasicDTOList(flows);
		
		assertFalse(flows.isEmpty());
		context.close();
	}
	
	//@Test
	public void testSelectAllStatus() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		List<BasicDTO> status = auditoriaDao.getAllOperationStatus();

		printBasicDTOList(status);
		
		assertFalse(status.isEmpty());
		context.close();
	}
	
	//@Test
	public void testSelectAllResultCodes() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		List<BasicDTO> codes = auditoriaDao.getAllOperationResultCodes();

		printBasicDTOList(codes);
		
		assertFalse(codes.isEmpty());
		context.close();
	}
	
	//@Test
	public void testSelectAllExecutionPoints() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		List<BasicDTO> executionPoints = auditoriaDao.getAllExecutionPoints();

		printBasicDTOList(executionPoints);
		
		assertFalse(executionPoints.isEmpty());
		context.close();
	}
	
	//@Test
	public void testSelectAllLayers() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		List<BasicDTO> layers = auditoriaDao.getAllLayers();

		printBasicDTOList(layers);
		
		assertFalse(layers.isEmpty());
		context.close();
	}
	
	//@Test
	public void testSelectAllComponents() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		List<BasicDTO> components = auditoriaDao.getAllComponents();

		printBasicDTOList(components);
		
		assertFalse(components.isEmpty());
		context.close();
	}
	
	//@Test
	public void testSelectAllInputChannels() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		List<BasicDTO> channels = auditoriaDao.getAllInputChannels();

		printBasicDTOList(channels);
		
		assertFalse(channels.isEmpty());
		context.close();
	}

	//@Test
	public void testSelectServicesByComponent() {
		
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		
		List<BasicDTO> services = auditoriaDao.getServicesByComponentId(1);
		
		printBasicDTOList(services);
		
		assertFalse(services.isEmpty());
		context.close();
	}


	
	private void printBasicDTOList(List<BasicDTO> bList) {
		System.out.println();
		System.out.println(" -- TOTAL ENTRIES: " + bList.size());
		for (BasicDTO b : bList) {
			printBasicDTO(b);
		}
	}
	
	private void printBasicDTO(BasicDTO b) {
		System.out.println();
		System.out.println("  ---- ID: " + b.getId());
		System.out.println("  ---- DESCRIPTION: " + b.getDescription());
	}
}
