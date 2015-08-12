package com.bs.service.firmacentralizada.auditoria.dao;

import java.util.List;

import com.bs.service.firmacentralizada.auditoria.dao.impl.OperationDataFilter;
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

public interface AuditoriaDAO {

	public List<Component> getAllComponents();
	
	public List<ComponentService> getAllComponentServices();
	
	public List<ExecutionPoint> getAllExecutionPoints();
	
	public List<Flow> getAllFlows();
	
	public List<Layer> getAllLayers();
	
	public List<OpenOperation> getAllOpenOperations();
	
	public List<OperationResultCode> getAllOperationResultCodes();
	
	public List<OperationStatus> getAllOperationStatus();
	
	public List<OperationData> getOperationData(OperationDataFilter filtro);
	
	public List<OperationActivity> getOperationActivity(int operationId, int iteration);
}
