package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="OPERATIONS")
public class Operation implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OperationPK operationPK;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_TIME")
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TIME")
	private Date endTime;

	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private OperationStatus status;

	@ManyToOne
	@JoinColumn(name="RESULT_CODE")
	private OperationResultCode resultCode;

	@Column(name="NODE")
	private String node;

	public OperationPK getOperationPK() {
		return operationPK;
	}

	public void setOperationPK(OperationPK operationsPK) {
		this.operationPK = operationsPK;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public OperationStatus getStatusId() {
		return status;
	}

	public void setStatusId(OperationStatus status) {
		this.status = status;
	}

	public OperationResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(OperationResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
	@Embeddable
	public static class OperationPK implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name="OPERATION_ID")
		private Integer operationId;

		@Column(name="ITERATION")
		private Integer iteration;
		
		public OperationPK() {}
		
		public OperationPK(int operationId, int iteration) {
			this.setOperationId(operationId);
			this.setIteration(iteration);
		}

		public Integer getOperationId() {
			return operationId;
		}

		public void setOperationId(Integer operationId) {
			this.operationId = operationId;
		}

		public Integer getIteration() {
			return iteration;
		}

		public void setIteration(Integer iteration) {
			this.iteration = iteration;
		}
		
		@Override
		public boolean equals(Object o) {
			
	        if (this == o) 
	        	return true;
	        
	        if (o == null || !(o instanceof OperationPK) ) 
	        	return false;

	        final OperationPK oopk = (OperationPK) o;

	        if (!oopk.getOperationId().equals(getOperationId()) || !oopk.getIteration().equals(getIteration()))
	       		return false;

	        return true;
	    }
		
		@Override
	    public int hashCode() {
	        int result;
	        result = getOperationId().hashCode();
	        result = 29 * result + getIteration();
	        return result;
	    }
	}
}
