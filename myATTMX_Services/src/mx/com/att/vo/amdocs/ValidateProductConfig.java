package mx.com.att.vo.amdocs;

import sun.awt.image.ImageWatched.Link;

public class ValidateProductConfig {
	public Link[] link;
	public String activityForConfiguration;
//	public ConfigurationLevelFilter configurationLevelFilter;
	public String containedProductID;
	public String containedProductSpecID;
	public Boolean returnRemovedItems;
//	public SettingsViewFilter settingsView;
	public String serviceRequiredDate;
	public String[] stepsToValidate;
	public ProductConfigurationChanges[] productChanges;
	public Boolean addDefaultChildItemsImplicitly;
	public Boolean returnRemovedByReplaceItems;
	
	public Link[] getLink() {
		return link;
	}
	public void setLink(final Link[] link) {
		this.link = link;
	}
	public String getActivityForConfiguration() {
		return activityForConfiguration;
	}
	public void setActivityForConfiguration(final String activityForConfiguration) {
		this.activityForConfiguration = activityForConfiguration;
	}
	public String getContainedProductID() {
		return containedProductID;
	}
	public void setContainedProductID(final String containedProductID) {
		this.containedProductID = containedProductID;
	}
	public String getContainedProductSpecID() {
		return containedProductSpecID;
	}
	public void setContainedProductSpecID(final String containedProductSpecID) {
		this.containedProductSpecID = containedProductSpecID;
	}
	public Boolean getReturnRemovedItems() {
		return returnRemovedItems;
	}
	public void setReturnRemovedItems(final Boolean returnRemovedItems) {
		this.returnRemovedItems = returnRemovedItems;
	}
	public String getServiceRequiredDate() {
		return serviceRequiredDate;
	}
	public void setServiceRequiredDate(final String serviceRequiredDate) {
		this.serviceRequiredDate = serviceRequiredDate;
	}
	public String[] getStepsToValidate() {
		return stepsToValidate;
	}
	public void setStepsToValidate(final String[] stepsToValidate) {
		this.stepsToValidate = stepsToValidate;
	}
	public ProductConfigurationChanges[] getProductChanges() {
		return productChanges;
	}
	public void setProductChanges(final ProductConfigurationChanges[] productChanges) {
		this.productChanges = productChanges;
	}
	public Boolean getAddDefaultChildItemsImplicitly() {
		return addDefaultChildItemsImplicitly;
	}
	public void setAddDefaultChildItemsImplicitly(final 
			Boolean addDefaultChildItemsImplicitly) {
		this.addDefaultChildItemsImplicitly = addDefaultChildItemsImplicitly;
	}
	public Boolean getReturnRemovedByReplaceItems() {
		return returnRemovedByReplaceItems;
	}
	public void setReturnRemovedByReplaceItems(final Boolean returnRemovedByReplaceItems) {
		this.returnRemovedByReplaceItems = returnRemovedByReplaceItems;
	}
	
	
	
	
}
