package com.bs.service.firmacentralizada.auditoria.tests;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bs.service.firmacentralizada.auditoria.AuditoriaConfig;
import com.bs.service.firmacentralizada.auditoria.dao.AuditoriaDAO;
import com.bs.service.firmacentralizada.auditoria.entidades.ComponentService;

public class ComponentServiceTest {
	
	@Test
	public void testSelectAll() {
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AuditoriaConfig.class);
		AuditoriaDAO auditoriaDao = context.getBean(AuditoriaDAO.class);
		List<ComponentService> components = auditoriaDao.getAllComponentServices();
		printFormat(components);
		assertFalse(components.isEmpty());
		context.close();
	}
	
	private void printFormat(List<ComponentService> components) {
		System.out.println(" -- Número de entradas: " + components.size());
		
		for (int index = 0; index < components.size(); index++) {
			System.out.println();
			System.out.println("  --- " + (index + 1));
			System.out.println("  ---- COMPONENT: " + components.get(index).getComponentServicesPK().getComponent().getComponent());
			System.out.println("  ---- SERVICE: " + components.get(index).getComponentServicesPK().getService());
			System.out.println("  ---- DESCRIPTION: " + components.get(index).getDescription());
		}
	}
}
