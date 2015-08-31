package com.bs.firmacentralizada.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.firmacentralizada.dto.BasicFilterDTO;
import com.bs.firmacentralizada.dto.OperationDTO;
import com.bs.firmacentralizada.dto.OperationFilterDTO;


/**
 * Controller for flow actions.
 */
@Controller
public class FlowsController {
	
    //private static final Logger LOGGER = Logger.getLogger(UserController.class);

    /*@Autowired
    FlowService flowService;*/

	private static final List<BasicFilterDTO> DUMMY_FLOWS = new ArrayList<BasicFilterDTO>();
	private static final List<BasicFilterDTO> DUMMY_STATUS = new ArrayList<BasicFilterDTO>();
	private static final List<BasicFilterDTO> DUMMY_RESULTS = new ArrayList<BasicFilterDTO>();
	private static final List<BasicFilterDTO> DUMMY_INPUTCHANNELS = new ArrayList<BasicFilterDTO>();
	private static final List<BasicFilterDTO> DUMMY_EXECPOINTS = new ArrayList<BasicFilterDTO>();
	private static final List<BasicFilterDTO> DUMMY_LAYERS = new ArrayList<BasicFilterDTO>();
	private static final List<BasicFilterDTO> DUMMY_COMPONENTS = new ArrayList<BasicFilterDTO>();
	
	
	static {
		DUMMY_FLOWS.add(new BasicFilterDTO(0, "Registrar Caso de Firma"));
		DUMMY_FLOWS.add(new BasicFilterDTO(1, "Completar Caso de Firma"));
		DUMMY_FLOWS.add(new BasicFilterDTO(2, "Cancelar Caso de Firma"));
		DUMMY_FLOWS.add(new BasicFilterDTO(3, "Feedback Caso de Firma"));
	}
	
	static {
		DUMMY_STATUS.add(new BasicFilterDTO(0, "Completado con exito"));
		DUMMY_STATUS.add(new BasicFilterDTO(1, "Error funcional"));
		DUMMY_STATUS.add(new BasicFilterDTO(2, "Error técnico"));
		DUMMY_STATUS.add(new BasicFilterDTO(3, "En curso"));
	}
	
	static {
		DUMMY_RESULTS.add(new BasicFilterDTO(0, "0"));
		DUMMY_RESULTS.add(new BasicFilterDTO(1, "500"));
		DUMMY_RESULTS.add(new BasicFilterDTO(2, "501"));
		DUMMY_RESULTS.add(new BasicFilterDTO(3, "502"));
		DUMMY_RESULTS.add(new BasicFilterDTO(4, "503"));
		DUMMY_RESULTS.add(new BasicFilterDTO(5, "504"));
	}
	
	static {
		DUMMY_INPUTCHANNELS.add(new BasicFilterDTO(0, "BSOnline"));
		DUMMY_INPUTCHANNELS.add(new BasicFilterDTO(1, "OSP"));
		DUMMY_INPUTCHANNELS.add(new BasicFilterDTO(2, "PROTEOMOBILE"));
		DUMMY_INPUTCHANNELS.add(new BasicFilterDTO(3, "SIBIS"));
	}
	
	static {
		DUMMY_EXECPOINTS.add(new BasicFilterDTO(0, "Service Init"));
		DUMMY_EXECPOINTS.add(new BasicFilterDTO(1, "Service End"));
		DUMMY_EXECPOINTS.add(new BasicFilterDTO(2, "Service Call"));
		DUMMY_EXECPOINTS.add(new BasicFilterDTO(3, "Response treatment"));
	}
	
	static {
		DUMMY_LAYERS.add(new BasicFilterDTO(0, "Service"));
		DUMMY_LAYERS.add(new BasicFilterDTO(1, "Business"));
		DUMMY_LAYERS.add(new BasicFilterDTO(2, "Persistencia"));
	}
	
	static {
		DUMMY_COMPONENTS.add(new BasicFilterDTO(0, "Controller"));
		DUMMY_COMPONENTS.add(new BasicFilterDTO(1, "Gestor Procesos"));
		DUMMY_COMPONENTS.add(new BasicFilterDTO(2, "DMS"));
	}
	
	
    @RequestMapping(value = "/flow", method = RequestMethod.GET)
    @ResponseBody
    public List<BasicFilterDTO> getFlows() {
    	return DUMMY_FLOWS;
    }
    
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @ResponseBody
    public List<BasicFilterDTO> getStatus() {
    	return DUMMY_STATUS;
    }
    
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseBody
    public List<BasicFilterDTO> getResults() {
    	return DUMMY_RESULTS;
    }
    
    @RequestMapping(value = "/inputChannel", method = RequestMethod.GET)
    @ResponseBody
    public List<BasicFilterDTO> getInputChannels() {
    	return DUMMY_INPUTCHANNELS;
    }
    
    @RequestMapping(value = "/executionPoint", method = RequestMethod.GET)
    @ResponseBody
    public List<BasicFilterDTO> getIExecutionPoints() {
    	return DUMMY_EXECPOINTS;
    }
    
    @RequestMapping(value = "/layer", method = RequestMethod.GET)
    @ResponseBody
    public List<BasicFilterDTO> getLayers() {
    	return DUMMY_LAYERS;
    }
    
    @RequestMapping(value = "/component", method = RequestMethod.GET)
    @ResponseBody
    public List<BasicFilterDTO> getComponents() {
    	return DUMMY_COMPONENTS;
    }
    
    @RequestMapping(value = "/operations", method = RequestMethod.POST)
    @ResponseBody
    public OperationDTO getOperationData(@RequestBody OperationFilterDTO operationFilter) {

    	OperationDTO operation = new OperationDTO();

    	if (operationFilter == null)
    		return operation;
    	
    	operation.setOperationId(operationFilter.getOperationId());
    	if (operationFilter.getFlowId() != null)
    		operation.setFlow(DUMMY_FLOWS.get(operationFilter.getFlowId()).getDescription());
    	if (operationFilter.getInputChannelId() != null)
    		operation.setInputChannel(DUMMY_INPUTCHANNELS.get(operationFilter.getInputChannelId()).getDescription());
    	if (operationFilter.getResultCodeId() != null)
    		operation.setResultCode(DUMMY_RESULTS.get(operationFilter.getResultCodeId()).getDescription());
    	if (operationFilter.getStatusId() != null)
    		operation.setStatus(DUMMY_STATUS.get(operationFilter.getStatusId()).getDescription());
    	operation.setFcId(operationFilter.getFcId());
    	operation.setRequestcId(operationFilter.getRequestcId());
    	operation.setSessionId(operationFilter.getSessionId());
    	operation.setStartTime(operationFilter.getStartTime());
    	operation.setEndTime(operationFilter.getEndTime());
    	
    	return operation;
    }
	
}

