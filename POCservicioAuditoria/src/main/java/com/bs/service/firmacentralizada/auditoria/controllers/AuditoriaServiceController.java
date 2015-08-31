package com.bs.service.firmacentralizada.auditoria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bs.service.firmacentralizada.auditoria.beans.ActivityRequestObject;
import com.bs.service.firmacentralizada.auditoria.beans.OperationRequestObject;
import com.bs.service.firmacentralizada.auditoria.dao.AuditoriaDAO;
import com.bs.service.firmacentralizada.auditoria.dto.ActivityDTO;
import com.bs.service.firmacentralizada.auditoria.dto.BasicDTO;
import com.bs.service.firmacentralizada.auditoria.dto.OperationDTO;
import com.bs.service.firmacentralizada.auditoria.dto.SearchResultDTO;
import com.bs.service.firmacentralizada.auditoria.dto.filtros.SortDTO;

@RestController
public class AuditoriaServiceController {
	
	@Autowired
	private AuditoriaDAO auditoriaDao;

	@RequestMapping(value = "/flows", method = RequestMethod.GET)
    @ResponseBody
	public List<BasicDTO> getFlows() {
		return auditoriaDao.getAllFlows();
	}
	
	@RequestMapping(value = "/status", method = RequestMethod.GET)
    @ResponseBody
	public List<BasicDTO> getOperationStatus() {
		return auditoriaDao.getAllOperationStatus();
	}
	
	@RequestMapping(value = "/resultcodes", method = RequestMethod.GET)
    @ResponseBody
	public List<BasicDTO> getOperationResultCodes() {
		return auditoriaDao.getAllOperationResultCodes();
	}
	
	@RequestMapping(value = "/inputchannels", method = RequestMethod.GET)
    @ResponseBody
	public List<BasicDTO> getInputChannels() {
		return auditoriaDao.getAllInputChannels();
	}
	
	@RequestMapping(value = "/components", method = RequestMethod.GET)
    @ResponseBody
	public List<BasicDTO> getComponents() {
		return auditoriaDao.getAllComponents();
	}
	
	@RequestMapping(value = "/layers", method = RequestMethod.GET)
    @ResponseBody
	public List<BasicDTO> getLayers() {
		return auditoriaDao.getAllLayers();
	}
	
	@RequestMapping(value = "/executionpoints", method = RequestMethod.GET)
    @ResponseBody
	public List<BasicDTO> getExecutionPoints() {
		return auditoriaDao.getAllExecutionPoints();
	}
	
	@RequestMapping(value = "/services", method = RequestMethod.POST)
    @ResponseBody
	public List<BasicDTO> getServicesByComponentId(@RequestBody Integer componentId) {
		return auditoriaDao.getServicesByComponentId(componentId);
	}
	
	@RequestMapping(value = "/activitydata", method = RequestMethod.POST)
    @ResponseBody
	public ActivityDTO getActivityData(@RequestBody Integer activityId) {
		return auditoriaDao.getActivityById(activityId);
	}
	
	@RequestMapping(value = "/activities", method = RequestMethod.POST)
    @ResponseBody
	public SearchResultDTO<ActivityDTO> getActivityData(@RequestBody ActivityRequestObject request) {
		
		SortDTO ordenacion = new SortDTO();
		if (request.getOrdinationField() != null)
			ordenacion.setField(SortDTO.OrderField.valueOf(request.getOrdinationField()));
		if (request.getOrdinationType() != null)
			ordenacion.setType(SortDTO.OrderType.valueOf(request.getOrdinationType()));
		
		return auditoriaDao.getActivityList(request.getActivityFilter(), ordenacion, request.getPagination());
	}
	
	@RequestMapping(value = "/operationdata", method = RequestMethod.POST)
    @ResponseBody
	public SearchResultDTO<ActivityDTO> getOperationData(@RequestBody OperationRequestObject request) {
		
		SortDTO ordenacion = new SortDTO();
		if (request.getOrdinationField() != null)
			ordenacion.setField(SortDTO.OrderField.valueOf(request.getOrdinationField()));
		if (request.getOrdinationType() != null)
			ordenacion.setType(SortDTO.OrderType.valueOf(request.getOrdinationType()));
		
		return auditoriaDao.getOperationActivityList(request.getOperation().getOperationId(), ordenacion, request.getPagination());
	}
	
	@RequestMapping(value = "/operations", method = RequestMethod.POST)
    @ResponseBody
	public SearchResultDTO<OperationDTO> getOperations(@RequestBody OperationRequestObject request) {
		
		SortDTO ordenacion = new SortDTO();
		if (request.getOrdinationField() != null)
			ordenacion.setField(SortDTO.OrderField.valueOf(request.getOrdinationField()));
		if (request.getOrdinationType() != null)
			ordenacion.setType(SortDTO.OrderType.valueOf(request.getOrdinationType()));
		
		return auditoriaDao.getOperationList(request.getOperation(),ordenacion, request.getPagination());
	}
}
