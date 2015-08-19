package com.bs.service.firmacentralizada.auditoria.dao;

import java.util.List;

import com.bs.service.firmacentralizada.auditoria.dto.ActivityDTO;
import com.bs.service.firmacentralizada.auditoria.dto.BasicDTO;
import com.bs.service.firmacentralizada.auditoria.dto.OperationDTO;
import com.bs.service.firmacentralizada.auditoria.dto.SearchResultDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.ActivityFilterDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.OperationFilterDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.PaginationDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.SortDTO;

/**
 * AuditoriaDAO.java
 * 
 * Capa de acceso a datos
 *
 */
public interface AuditoriaDAO {

	/**
	 * Recupera todos los flujos de integración almacenados en la BBDD
	 * 
	 * @return
	 * 		Una lista con objetos de tipo Flow mapeando las entradas de la BBDD
	 * 
	 */
	public List<BasicDTO> getAllFlows();
	
	/**
	 * Recupera los distintos estados en los que puede estar la ejecución de una operación de la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo OperationStatus mapeando las entradas de la BBDD
	 * 
	 */
	public List<BasicDTO> getAllOperationStatus();
	
	/**
	 * Recupera los distintos códigos de resultado que se contemplan en la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo OperationResultCode mapeando las entradas de la BBDD
	 * 
	 */
	public List<BasicDTO> getAllOperationResultCodes();
	
	/**
	 * Recupera todos los canales de entrada soportados por la plataforma
	 * 
	 * @return
	 * 		Una lista de canales de entrada, identificados por su Id y su descripción.
	 */
	public List<BasicDTO> getAllInputChannels();
	
	/**
	 * Recupera todos los componentes de la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo Component mapeando las entradas de la BBDD
	 * 
	 */
	public List<BasicDTO> getAllComponents();
	
	/**
	 * Recupera los diferentes puntos de ejecución en los que se audita la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo ExecutionPoint mapeando las entradas de la BBDD
	 * 
	 */
	public List<BasicDTO> getAllExecutionPoints();
	
	/**
	 * Recupera todas las capas lógicas que componen la plataforma
	 * 
	 * @return
	 * 		Una lista con objetos de tipo Layer mapeando las entradas de la BBDD
	 * 
	 */
	public List<BasicDTO> getAllLayers();
	
	/**
	 * Recupera la lista de servicios asociados al componente indicado
	 * 
	 * @param componentId
	 * 		El identificador del componente para el cual se quiere recuperar los servicios
	 * 
	 * @return
	 * 		Una lista de servicios, identificados por su Id y su descripción. Si no existen servicios, devolverá una lista vacía.
	 */
	public List<BasicDTO> getServicesByComponentId(long componentId);
	
	/**
	 * Recupera la lista de operaciones ejecutadas dentro de la plataforma que cumplan los requisitos indicados en el filtro,
	 * de acuerdo a los criterios de ordenación y paginación indicados.
	 * 
	 * @param filter
	 * 		Objeto que indica los diferentes criterios que serán aplicados a la hora de recuperar los datos
	 * @param ordination
	 * 		El tipo de ordenación en el que se devolverá el resultado
	 * @param pagination
	 * 		El tipo de paginación que se aplicará al resultado
	 * @return
	 * 		Una lista de OperationDTO con las operaciones recuperadas. Si no existen operaciones que se ajusten a los criterios
	 * 		de búsqueda, devolverá una lista vacía.
	 * 
	 */
	public SearchResultDTO<OperationDTO> getOperationList(OperationFilterDTO filter, SortDTO ordination, PaginationDTO pagination);
	
	/**
	 * Devuelve los datos relativos a la última iteración de la operación indicada, sin incluir información de la actividad asociada a la misma
	 * 
	 * @param operationId
	 * 		El identificador de la operación
	 * @return
	 * 		La operación con el identificador proporcionado, null si no existe tal operación
	 */
	public OperationDTO getLastIterationByOperationId(long operationId);
	
	/**
	 * Devuelve los datos relativos a la iteración concreta de la operación indicada, sin incluir información de la actividad asociada a la misma
	 * 
	 * @param operationId
	 * 		El identificador de la operación
	 * @param
	 * 		La iteración de la operación a recuperar
	 * @return
	 * 		La operación con el identificador proporcionado, null si no existe tal operación
	 */
	public OperationDTO getOperationById(long operationId, int iteration);
	
	/**
	 * Devuelve la lista de actividades englobadas en la operación indicada, de acuerdo con los criterios de paginacion y ordenación
	 * 
	 * @param operationId
	 * 		El identificador de la operación
	 * @param ordination
	 * 		El tipo de ordenación en el que se devolverá el resultado
	 * @param pagination
	 * 		El tipo de paginación que se aplicará al resultado
	 * 
	 * @return
	 * 		Una lista de ActivityDTO con los datos de las actividades recuperadas. Si no existen actividades que se ajusten a los criterios
	 * 		de búsqueda, devolverá una lista vacía.
	 * 
	 */
	public SearchResultDTO<ActivityDTO> getOperationActivityList(long operationId, SortDTO ordination, PaginationDTO pagination);
	
	/**
	 * Recupera los datos relativos a la actividad indicada
	 * 
	 * @param activityId
	 * 		El identificador de la actividad
	 * @return
	 * 		La actividad con el identificador proporcionado, null si no existe tal actividad
	 */
	public ActivityDTO getActivityById(long activityId);
	
	/**
	 * Recupera la lista de actividades dentro de la plataforma que cumplan los requisitos indicados en el filtro,
	 * de acuerdo a los criterios de ordenación y paginación indicados.
	 * 
	 * @param filter
	 * 		Objeto que indica los diferentes criterios que serán aplicados a la hora de recuperar los datos
	 * @param ordination
	 * 		El tipo de ordenación en el que se devolverá el resultado
	 * @param pagination
	 * 		El tipo de paginación que se aplicará al resultado
	 * @return
	 * 		Una lista de ActivityDTO con las actividades recuperadas. Si no existen actividades que se ajusten a los criterios
	 * 		de búsqueda, devolverá una lista vacía.
	 */
	public SearchResultDTO<ActivityDTO> getActivityList(ActivityFilterDTO filter, SortDTO ordination, PaginationDTO pagination);
}
