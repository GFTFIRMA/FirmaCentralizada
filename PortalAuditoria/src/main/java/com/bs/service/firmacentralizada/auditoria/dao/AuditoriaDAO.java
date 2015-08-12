package com.bs.service.firmacentralizada.auditoria.dao;

import java.util.List;

import com.bs.service.firmacentralizada.auditoria.entidades.Component;
import com.bs.service.firmacentralizada.auditoria.entidades.ComponentService;
import com.bs.service.firmacentralizada.auditoria.entidades.ExecutionPoint;
import com.bs.service.firmacentralizada.auditoria.entidades.Flow;
import com.bs.service.firmacentralizada.auditoria.entidades.Layer;
import com.bs.service.firmacentralizada.auditoria.entidades.OpenOperation;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationActivity;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationData;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationResultCode;
import com.bs.service.firmacentralizada.auditoria.entidades.OperationStatus;

/**
 * AuditoriaDAO.java
 * 
 * Capa de acceso a datos
 *
 */
public interface AuditoriaDAO {

	/**
	 * Recupera todos los componentes de la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo Component mapeando las entradas de la BBDD
	 * 
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.Component
	 */
	public List<Component> getAllComponents();
	
	/**
	 * Recupera todos los servicios ofrecidos por los componentes de la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo ComponentService mapeando las entradas de la BBDD
	 * 
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.ComponentService
	 */
	public List<ComponentService> getAllComponentServices();
	
	/**
	 * Recupera los diferentes puntos de ejecución en los que se audita la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo ExecutionPoint mapeando las entradas de la BBDD
	 * 
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.ExecutionPoint
	 */
	public List<ExecutionPoint> getAllExecutionPoints();
	
	/**
	 * Recupera todos los flujos de integración almacenados en la BBDD
	 * 
	 * @return
	 * 		Una lista con objetos de tipo Flow mapeando las entradas de la BBDD
	 * 
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.Flow
	 */
	public List<Flow> getAllFlows();
	
	/**
	 * Recupera todas las capas lógicas que componen la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo Layer mapeando las entradas de la BBDD
	 * 
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.Layer
	 */
	public List<Layer> getAllLayers();
	
	/**
	 * Recupera todas las operaciones que se están ejecutando en un momento dado
	 * 
	 * @return
	 * 		Una lista con objetos de tipo OpenOperation mapeando las entradas de la BBDD
	 * 
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.OpenOperation
	 */
	public List<OpenOperation> getAllOpenOperations();
	
	/**
	 * Recupera los distintos códigos de resultado que se contemplan en la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo OperationResultCode mapeando las entradas de la BBDD
	 * 
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.OperationResultCode
	 */
	public List<OperationResultCode> getAllOperationResultCodes();
	
	/**
	 * Recupera los distintos estados en los que puede estar la ejecución de una operación de la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo OperationStatus mapeando las entradas de la BBDD
	 * 
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.OperationStatus
	 */
	public List<OperationStatus> getAllOperationStatus();
	
	/**
	 * Recupera los datos relativos a aquellas operaciones ejecutadas dentro de la plataforma que cumplan los requisitos indicados en el filtro
	 * 
	 * @param filtro
	 * 		Objeto de tipo OperationDataFilter. Indica los diferentes criterios que serán aplicados a la hora de recuperar los datos
	 * 		
	 * @return
	 * 		Una lista de OperationData mapeando las entradas de la BBDD
	 * 
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.OperationData
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.OperationDataFilter
	 */
	public List<OperationData> getOperationData(OperationDataFilter filtro);
	
	/**
	 * Recupera los datos relativos a una ejecución concreta de una operación, identificada por id e iteración
	 * 
	 * @param operationId
	 * 		El identificador de la operación dentro de la BBDD
	 * @param iteration
	 * 		La iteración que se quiere recuperar
	 * 
	 * @return
	 * 		Una lista de OperationActivity mapeando las entradas de la BBDD
	 * 
	 * @see com.bs.service.firmacentralizada.auditoria.entidades.OperationActivity
	 */
	public List<OperationActivity> getOperationActivity(int operationId, int iteration);
	
	/**
	 * Devuelve el número total de iteraciones ejecutadas para una operación
	 * 
	 * @param operationId
	 * 		El identificador de la operación dentro de la BBDD
	 * @return
	 * 		El número total de iteraciones registradas para la operación indicada
	 */
	public Integer getTotalIterations(int operationId);
}
