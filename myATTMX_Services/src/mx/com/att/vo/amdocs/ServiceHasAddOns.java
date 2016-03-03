package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ServiceHasAddOns implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LinkVO[] Link;
	private boolean hasAddOns;
	private String serviceID;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public boolean isHasAddOns() {
		return hasAddOns;
	}
	public void setHasAddOns(final boolean hasAddOns) {
		this.hasAddOns = hasAddOns;
	}
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(final String serviceID) {
		this.serviceID = serviceID;
	}
	
	

}