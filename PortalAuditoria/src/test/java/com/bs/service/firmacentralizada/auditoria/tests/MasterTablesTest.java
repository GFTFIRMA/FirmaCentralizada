package com.bs.service.firmacentralizada.auditoria.tests;

public class MasterTablesTest {
	
//	@Test
//	public void testSelectAllLayers() {
//		
//		AnnotationConfigApplicationContext context =
//			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
//		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
//		
//		List<Layer> layers = auditoriaDao.getAllLayers();
//
//		System.out.println(" -- Número de entradas: " + layers.size());
//		for (int index = 0; index < layers.size(); index++) {
//			System.out.println();
//			System.out.println("  --- " + (index + 1));
//			System.out.println("  ---- ID: " + layers.get(index).getLayerId());
//			System.out.println("  ---- DESCRIPTION: " + layers.get(index).getDescription());
//			System.out.println("  ---- DEPTH: " + layers.get(index).getDepth());
//		}
//		
//		assertFalse(layers.isEmpty());
//		context.close();
//	}
//	
//	@Test
//	public void testSelectAllFlows() {
//		
//		AnnotationConfigApplicationContext context =
//			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
//		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
//		
//		List<Flow> flows = auditoriaDao.getAllFlows();
//
//		System.out.println(" -- Número de entradas: " + flows.size());
//		for (int index = 0; index < flows.size(); index++) {
//			System.out.println();
//			System.out.println("  --- " + (index + 1));
//			System.out.println("  ---- FLOW: " + flows.get(index).getFlow());
//			System.out.println("  ---- DESCRIPTION: " + flows.get(index).getDescription());
//		}
//		
//		assertFalse(flows.isEmpty());
//		context.close();
//	}
//	
//	@Test
//	public void testSelectAllStatus() {
//		
//		AnnotationConfigApplicationContext context =
//			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
//		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
//		
//		List<OperationStatus> status = auditoriaDao.getAllOperationStatus();
//
//		System.out.println(" -- Número de entradas: " + status.size());
//		for (int index = 0; index < status.size(); index++) {
//			System.out.println();
//			System.out.println("  --- " + (index + 1));
//			System.out.println("  ---- ID: " + status.get(index).getStatusId());
//			System.out.println("  ---- DESCRIPTION: " + status.get(index).getDescription());
//		}
//		
//		assertFalse(status.isEmpty());
//		context.close();
//	}
//	
//	@Test
//	public void testSelectAllComponents() {
//		
//		AnnotationConfigApplicationContext context =
//			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
//		
//		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
//		
//		List<Component> components = auditoriaDao.getAllComponents();System.out.println(" -- Número de entradas: " + components.size());
//		for (int index = 0; index < components.size(); index++) {
//			System.out.println();
//			System.out.println("  --- " + (index + 1));
//			System.out.println("  ---- COMPONENT: " + components.get(index).getComponent());
//			System.out.println("  ---- DESCRIPTION: " + components.get(index).getDescription());
//		}
//		
//		assertFalse(components.isEmpty());
//		context.close();
//	}
//	
//	@Test
//	public void testSelectAllServices() {
//		
//		AnnotationConfigApplicationContext context =
//			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
//		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
//		
//		List<ComponentService> services = auditoriaDao.getAllComponentServices();
//
//		System.out.println(" -- Número de entradas: " + services.size());
//		for (int index = 0; index < services.size(); index++) {
//			System.out.println();
//			System.out.println("  --- " + (index + 1));
//			System.out.println("  ---- COMPONENT: " + services.get(index).getComponentServicesPK().getComponent().getComponent());
//			System.out.println("  ---- SERVICE: " + services.get(index).getComponentServicesPK().getService());
//			System.out.println("  ---- DESCRIPTION: " + services.get(index).getDescription());
//		}
//		
//		assertFalse(services.isEmpty());
//		context.close();
//	}
//	
//	@Test
//	public void testSelectAllExecutionPoints() {
//		
//		AnnotationConfigApplicationContext context =
//			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
//		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
//		
//		List<ExecutionPoint> executionPoint = auditoriaDao.getAllExecutionPoints();
//
//		System.out.println(" -- Número de entradas: " + executionPoint.size());
//		for (int index = 0; index < executionPoint.size(); index++) {
//			System.out.println();
//			System.out.println("  --- " + (index + 1));
//			System.out.println("  ---- EXECUTION POINT: " + executionPoint.get(index).getExecutionPoint());
//			System.out.println("  ---- DESCRIPTION: " + executionPoint.get(index).getDescription());
//		}
//		
//		assertFalse(executionPoint.isEmpty());
//		context.close();
//	}
//	
//	@Test
//	public void testSelectAllResultCodes() {
//		
//		AnnotationConfigApplicationContext context =
//			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
//		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
//		
//		List<OperationResultCode> resultCodes = auditoriaDao.getAllOperationResultCodes();
//
//		System.out.println(" -- Número de entradas: " + resultCodes.size());
//		for (int index = 0; index < resultCodes.size(); index++) {
//			System.out.println();
//			System.out.println("  --- " + (index + 1));
//			System.out.println("  ---- CODE: " + resultCodes.get(index).getCode());
//			System.out.println("  ---- DESCRIPTION: " + resultCodes.get(index).getDescription());
//			System.out.println("  ---- RETRAYABLE: " + resultCodes.get(index).getRetryable());
//		}
//		
//		assertFalse(resultCodes.isEmpty());
//		context.close();
//	}
}
