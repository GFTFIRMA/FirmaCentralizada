package com.bs.firmacentralizada.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.firmacentralizada.dto.BasicFilterDTO;


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
	
	
	static {
		DUMMY_FLOWS.add(new BasicFilterDTO(1, "Registrar Caso de Firma"));
		DUMMY_FLOWS.add(new BasicFilterDTO(2, "Completar Caso de Firma"));
		DUMMY_FLOWS.add(new BasicFilterDTO(3, "Cancelar Caso de Firma"));
		DUMMY_FLOWS.add(new BasicFilterDTO(4, "Feedback Caso de Firma"));
	}
	
	static {
		DUMMY_STATUS.add(new BasicFilterDTO(1, "Completado con exito"));
		DUMMY_STATUS.add(new BasicFilterDTO(2, "Error funcional"));
		DUMMY_STATUS.add(new BasicFilterDTO(3, "Error técnico"));
		DUMMY_STATUS.add(new BasicFilterDTO(4, "En curso"));
	}
	
	static {
		DUMMY_RESULTS.add(new BasicFilterDTO(0, "0"));
		DUMMY_RESULTS.add(new BasicFilterDTO(2, "500"));
		DUMMY_RESULTS.add(new BasicFilterDTO(3, "501"));
		DUMMY_RESULTS.add(new BasicFilterDTO(3, "502"));
		DUMMY_RESULTS.add(new BasicFilterDTO(3, "503"));
		DUMMY_RESULTS.add(new BasicFilterDTO(3, "504"));
	}
	
	static {
		DUMMY_INPUTCHANNELS.add(new BasicFilterDTO(1, "BSOnline"));
		DUMMY_INPUTCHANNELS.add(new BasicFilterDTO(2, "OSP"));
		DUMMY_INPUTCHANNELS.add(new BasicFilterDTO(3, "PROTEOMOBILE"));
		DUMMY_INPUTCHANNELS.add(new BasicFilterDTO(4, "SIBIS"));
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
	
}

