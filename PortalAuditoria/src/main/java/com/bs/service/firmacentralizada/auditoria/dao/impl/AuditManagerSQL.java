package com.bs.service.firmacentralizada.auditoria.dao.impl;

public class AuditManagerSQL {
	
	public final static String MAIN_QUERY = "SELECT * FROM OPERATIONS O" +
									 "LEFT JOIN OPERATION_ACTIVITY OA " +
									 "ON O.OPERATION_ID = OA.OPERATION_ID " +
									 "AND O.ITERATION = OA.ITERATION";

}
