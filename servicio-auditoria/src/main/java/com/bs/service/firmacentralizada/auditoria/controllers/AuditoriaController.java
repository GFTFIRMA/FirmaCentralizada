package com.bs.service.firmacentralizada.auditoria.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bs.service.firmacentralizada.auditoria.beans.OperationData;

@RestController
@RequestMapping(value = "/auditoria")
public class AuditoriaController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<OperationData> getOperationData() {
		return null;
	}
}
