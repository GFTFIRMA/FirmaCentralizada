package com.bs.service.firmacentralizada.auditoria.dto.filtros;

import java.util.HashMap;
import java.util.Map;

/**
 * Class SortDTO
 * 
 * Clase que proporciona constantes y métodos para definir la ordenación a usar en una consulta a BBDD
 */
public class SortDTO {
	
	private SortDTO.OrderType type;
	private SortDTO.OrderField field;
	private static Map<SortDTO.OrderField,String> fieldMap = new HashMap<SortDTO.OrderField, String>();
	private static Map<SortDTO.OrderType,String> typeMap = new HashMap<SortDTO.OrderType, String>();
	
	static {
		fieldMap.put(OrderField.ID_OPERACION, "operation.operationPK.operationId");
		fieldMap.put(OrderField.ID_ACTIVIDAD, "activityId");
		fieldMap.put(OrderField.FLUJO, "flow.flowId");
		fieldMap.put(OrderField.CANAL_ENTRADA, "inputChannel");
		fieldMap.put(OrderField.REQUESTC_ID, "requestcId");
		fieldMap.put(OrderField.INICIO_OPERACION, "operation.startTime");
		fieldMap.put(OrderField.FIN_OPERACION, "operation.endTime");
		fieldMap.put(OrderField.INICIO_ACTIVIDAD, "startTime");
		fieldMap.put(OrderField.FIN_ACTIVIDAD, "startTime");
		fieldMap.put(OrderField.ESTADO_OPERACION, "operation.status.statusId");
		fieldMap.put(OrderField.ESTADO_ACTIVIDAD, "status.statusId"); 
		fieldMap.put(OrderField.ORIGEN, "origComponent.componentId");
		fieldMap.put(OrderField.DESTINO, "destService.serviceId");
		
		typeMap.put(OrderType.ASC, "ASC");
		typeMap.put(OrderType.DESC, "DESC");
	}
	

	/**
	 * Campos de ordenación para {@link SortDTO#getType()} y {@link SortDTO#setType(OrderType)}
	 */
	public enum OrderType {
		ASC, DESC
	}
	
	/**
	 * Campos de ordenación para {@link SortDTO#getField()} y {@link SortDTO#setField(OrderField)}
	 */
	public enum OrderField {
		ID_OPERACION,
		ID_ACTIVIDAD,
		FLUJO,
		CANAL_ENTRADA,
		REQUESTC_ID,
		INICIO_OPERACION,
		FIN_OPERACION,
		INICIO_ACTIVIDAD,
		FIN_ACTIVIDAD,
		ESTADO_OPERACION,
		ESTADO_ACTIVIDAD,
		ORIGEN,
		DESTINO
	}
	
	/**
	 * Devuelve el tipo de ordenación del filtro
	 */
	public SortDTO.OrderType getType() {
		return type;
	}

	/**
	 * Fija el tipo de ordenación del filto.
	 * @param type
	 * 		El tipo de ordenación, especificado por uno de los valores definidos en {@link SortDTO.OrderType}
	 */
	public void setType(SortDTO.OrderType type) {
		this.type = type;
	}
	
	/**
	 * Devuelve la representación String del tipo de ordenación del filtro
	 */
	public String getTypeAsString() {
		return typeMap.containsKey(type) ? typeMap.get(type) : typeMap.get(OrderType.ASC);
	}
	
	/**
	 * Devuelve el campo por el cual se realiza la ordenación
	 */
	public SortDTO.OrderField getField() {
		return field;
	}

	/**
	 * Fija el campo de ordenación del filto.
	 * @param field
	 * 		El campo de ordenación, especificado por uno de los valores definidos en {@link SortDTO.OrderField}
	 */
	public void setField(SortDTO.OrderField field) {
		this.field = field;
	}
	
	/**
	 * Devuelve la representación String del campo por el cual se realiza la ordenación
	 */
	public String getFieldAsString() {
		return fieldMap.containsKey(field) ? fieldMap.get(field) : fieldMap.get(OrderField.ID_OPERACION);
	}
}
