package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class NewService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LinkVO[] link;
	public String catalogItemID;
	public String parentID;
	public NewPricePackage[] newPricePackages;
	public ChangedConfigurationParameter[] parameters;
	public RemovedPricePackage[] removedPricePackages;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public String getCatalogItemID() {
		return catalogItemID;
	}
	public void setCatalogItemID(final String catalogItemID) {
		this.catalogItemID = catalogItemID;
	}
	public String getParentID() {
		return parentID;
	}
	public void setParentID(final String parentID) {
		this.parentID = parentID;
	}
	public NewPricePackage[] getNewPricePackages() {
		return newPricePackages;
	}
	public void setNewPricePackages(final NewPricePackage[] newPricePackages) {
		this.newPricePackages = newPricePackages;
	}
	public ChangedConfigurationParameter[] getParameters() {
		return parameters;
	}
	public void setParameters(final ChangedConfigurationParameter[] parameters) {
		this.parameters = parameters;
	}
	public RemovedPricePackage[] getRemovedPricePackages() {
		return removedPricePackages;
	}
	public void setRemovedPricePackages(final RemovedPricePackage[] removedPricePackages) {
		this.removedPricePackages = removedPricePackages;
	}
	
	


}