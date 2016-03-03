package mx.com.att.vo.amdocs;

public class ProductQuoteRequests {
	
	public LinkVO[] Link;
	public String productId;
	public ChangedServiceStatus[] changedServicesStatus;
	public ChangedServiceParameters[] changedParameters;
	public NewPricePackage[] newPricePackages;
	public NewService[] newServices;
	public RemovedPricePackage[] removedPricePackages;
	
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(final String productId) {
		this.productId = productId;
	}
	public ChangedServiceStatus[] getChangedServicesStatus() {
		return changedServicesStatus;
	}
	public void setChangedServicesStatus(final 
			ChangedServiceStatus[] changedServicesStatus) {
		this.changedServicesStatus = changedServicesStatus;
	}
	public ChangedServiceParameters[] getChangedParameters() {
		return changedParameters;
	}
	public void setChangedParameters(final ChangedServiceParameters[] changedParameters) {
		this.changedParameters = changedParameters;
	}
	public NewPricePackage[] getNewPricePackages() {
		return newPricePackages;
	}
	public void setNewPricePackages(final NewPricePackage[] newPricePackages) {
		this.newPricePackages = newPricePackages;
	}
	public NewService[] getNewServices() {
		return newServices;
	}
	public void setNewServices(final NewService[] newServices) {
		this.newServices = newServices;
	}
	public RemovedPricePackage[] getRemovedPricePackages() {
		return removedPricePackages;
	}
	public void setRemovedPricePackages(final RemovedPricePackage[] removedPricePackages) {
		this.removedPricePackages = removedPricePackages;
	}

	
	
	
	
	
	
	
}
