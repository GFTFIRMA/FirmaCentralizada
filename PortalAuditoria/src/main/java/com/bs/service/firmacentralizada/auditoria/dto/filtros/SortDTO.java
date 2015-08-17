package com.bs.service.firmacentralizada.auditoria.dto.filtros;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que proporciona constantes y métodos para definir la ordenación a usar en una consulta a BBDD
 */
public class SortDTO {
	
	/**
	 * Tipo de ordenación para {@link #getOrder()} y {@link #setOrder(String)} indicando una ordenación ascendente
	 */
	public static final String ASC = "ASC";
	
	/**
	 * Tipo de ordenación para {@link #getOrder()} y {@link #setOrder(String)} indicando una ordenación descendente
	 */
	public static final String DESC = "DESC";
	
	public static final String ID_OPERACION = "operationId";
	public static final String ID_ACTIVIDAD = "activityId";
	public static final String FLUJO = "flow";
	public static final String CANAL_ENTRADA = "inputChannel";
	public static final String REQUESTC_ID ="requestcId";
	public static final String INICIO_OPERACION = "operationStartTime";
	public static final String FIN_OPERACION = "operationEndTime";
	public static final String INICIO_ACTIVIDAD = "activityStartTime";
	public static final String FIN_ACTIVIDAD = "activityEndTime";
	public static final String ESTADO_OPERACION ="operationStatus";
	public static final String ESTADO_ACTIVIDAD ="activityStatus";
	public static final String ORIGEN ="origen";
	public static final String DESTINO = "destino";
	
	private String order;
	private String field;
	
	private static Map<String,String> sortMap = new HashMap<String, String>();
	
	static {
		sortMap.put(ID_OPERACION, "operation.operationPK.operationId");
		sortMap.put(ID_ACTIVIDAD, "activityId");
		sortMap.put(FLUJO, "flow.flow");
		sortMap.put(CANAL_ENTRADA, "inputChannel");
		sortMap.put(REQUESTC_ID, ""); // TODO
		sortMap.put(INICIO_OPERACION, "operation.startTime");
		sortMap.put(FIN_OPERACION, "operation.endTime");
		sortMap.put(INICIO_ACTIVIDAD, "startTime");
		sortMap.put(FIN_ACTIVIDAD, "startTime");
		sortMap.put(ESTADO_OPERACION, "operation.status.statusId");
		sortMap.put(ESTADO_ACTIVIDAD, "status.statusId");
	}
	
	/**
	 * Devuelve el tipo de ordenación del filtro
	 * 
	 * @return
	 * 		El valor del tipo de ordenación activo, {@value #ASC} o {@value #DESC}
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * Fija el tipo de ordenación del filto. Se recomienda utilizar uno de los dos valores definidos, {@link #ASC} o {@link #DESC}
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * Devuelve el campo por el cual se realiza la ordenación
	 */
	public String getField() {
		return sortMap.containsKey(field) ? sortMap.get(field) : ID_OPERACION;
	}

	/**
	 * Fija el campo por el cual se realizará la ordenación.
	 */
	public void setField(String field) {
		this.field = field;
	}
}
