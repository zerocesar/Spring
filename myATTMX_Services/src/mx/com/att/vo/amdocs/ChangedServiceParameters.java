package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ChangedServiceParameters implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	public LinkVO[] Link;
	public String serviceID;
	public ChangedConfigurationParameter[] parameters;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(final String serviceID) {
		this.serviceID = serviceID;
	}
	public ChangedConfigurationParameter[] getParameters() {
		return parameters;
	}
	public void setParameters(final ChangedConfigurationParameter[] parameters) {
		this.parameters = parameters;
	}

	
	
}