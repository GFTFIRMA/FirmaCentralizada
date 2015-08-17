package com.bs.service.firmacentralizada.auditoria.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMPONENT_SERVICES")
public class ComponentService  implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComponentServicePK componentServicePK;
	
	@Column(name="DESCRIPTION")
	private String description;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public ComponentServicePK getComponentServicePK() {
		return componentServicePK;
	}

	public void setComponentServicePK(ComponentServicePK componentServicePK) {
		this.componentServicePK = componentServicePK;
	}

	/**
	 * Composite Primary Key
	 */
	@Embeddable
	public static class ComponentServicePK implements Serializable {

		private static final long serialVersionUID = 1L;

		@ManyToOne
		@JoinColumn(name="COMPONENT", referencedColumnName = "COMPONENT")
		private Component component;
		
		@Column(name="SERVICE")
		private String service;
		
		public ComponentServicePK() {}
		
		public ComponentServicePK(Component component, String service) {
			this.component = component;
			this.service = service;
		}

		public Component getComponent() {
			return component;
		}

		public void setComponent(Component component) {
			this.component = component;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}
		
		@Override
		public boolean equals(Object o) {
			
	        if (this == o) 
	        	return true;
	        
	        if (o == null || !(o instanceof ComponentServicePK) ) 
	        	return false;

	        final ComponentServicePK cspk = (ComponentServicePK) o;

	        if (!cspk.getComponent().equals(getComponent()) || !cspk.getService().equals( getService()))
	       		return false;

	        return true;
	    }
		
		@Override
	    public int hashCode() {
	        int result;
	        result = getComponent().hashCode();
	        result = 29 * result + getService().hashCode();
	        return result;
	    }
	}
}
