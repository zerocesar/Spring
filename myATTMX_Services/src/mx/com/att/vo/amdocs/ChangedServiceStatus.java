package mx.com.att.vo.amdocs;

public class ChangedServiceStatus {
	
	public LinkVO[] Link;
	//private ServiceAction newStatus;
	public String  serviceID;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	/*
	public ServiceAction getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(final ServiceAction newStatus) {
		this.newStatus = newStatus;
	}*/
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(final String serviceID) {
		this.serviceID = serviceID;
	}	
}
