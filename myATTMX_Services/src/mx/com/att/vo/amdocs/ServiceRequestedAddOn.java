package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ServiceRequestedAddOn implements Serializable{

	private static final long serialVersionUID = 1L;
	public LinkVO[] Link;
	//public RequestedAddOn requestedAddOn;
	public String pricePackageID;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(LinkVO[] link) {
		Link = link;
	}
	/*
	public RequestedAddOn getRequestedAddOn() {
		return requestedAddOn;
	}
	public void setRequestedAddOn(RequestedAddOn requestedAddOn) {
		this.requestedAddOn = requestedAddOn;
	}*/
	public String getPricePackageID() {
		return pricePackageID;
	}
	public void setPricePackageID(String pricePackageID) {
		this.pricePackageID = pricePackageID;
	}
	
	
	
	
}