package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPERATIONS")
public class Operation implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OperationPK operationPK;

	@Column(name="START_TIME", nullable = false)
	private Timestamp startTime;
	
	@Column(name="END_TIME")
	private Timestamp endTime;

	@ManyToOne
	@JoinColumn(name="STATUS_ID", nullable = false)
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

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public OperationStatus getStatus() {
		return status;
	}

	public void setStatus(OperationStatus status) {
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
		private Long operationId;

		@Column(name="ITERATION")
		private Integer iteration;
		
		public OperationPK() {}
		
		public OperationPK(long operationId, int iteration) {
			this.setOperationId(operationId);
			this.setIteration(iteration);
		}

		public Long getOperationId() {
			return operationId;
		}

		public void setOperationId(Long operationId) {
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
	        result = (int) (29 * result + getIteration());
	        return result;
	    }
	}
}
