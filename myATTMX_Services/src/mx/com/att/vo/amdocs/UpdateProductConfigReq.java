package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class UpdateProductConfigReq implements Serializable{

	private static final long serialVersionUID = 1L;
	public LinkVO[] Link;
	public String activityForConfiguration;
	//public ConfigurationLevelFilter configurationLevel; 
	public boolean confirmationMessagesApproved;
	public boolean returnRemovedItems;
	public boolean runCompatibilityRules;
	public String serviceRequiredDate;
	//public SettingsViewFilter settingsView;
	public boolean submitProductOrder;
	public AttachmentTypes[] attachmentCriteria;
	public ReturnConfigurationData returnConfigurationData;	
	public ProductConfigurationChanges[] productChanges;	
	public boolean addDefaultChildItemsImplicitly;	
	public ConfigureReplaceProductOffering[] replaceProductOfferingConfiguration;
	public String basicPriceSchemaID;
	public String productOrderID;
	public String externalUserID;
	public String externalUserOrg;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getActivityForConfiguration() {
		return activityForConfiguration;
	}
	public void setActivityForConfiguration(final String activityForConfiguration) {
		this.activityForConfiguration = activityForConfiguration;
	}
	public boolean isConfirmationMessagesApproved() {
		return confirmationMessagesApproved;
	}
	public void setConfirmationMessagesApproved(final boolean confirmationMessagesApproved) {
		this.confirmationMessagesApproved = confirmationMessagesApproved;
	}
	public boolean isReturnRemovedItems() {
		return returnRemovedItems;
	}
	public void setReturnRemovedItems(final boolean returnRemovedItems) {
		this.returnRemovedItems = returnRemovedItems;
	}
	public boolean isRunCompatibilityRules() {
		return runCompatibilityRules;
	}
	public void setRunCompatibilityRules(final boolean runCompatibilityRules) {
		this.runCompatibilityRules = runCompatibilityRules;
	}
	public String getServiceRequiredDate() {
		return serviceRequiredDate;
	}
	public void setServiceRequiredDate(final String serviceRequiredDate) {
		this.serviceRequiredDate = serviceRequiredDate;
	}
	public boolean isSubmitProductOrder() {
		return submitProductOrder;
	}
	public void setSubmitProductOrder(final boolean submitProductOrder) {
		this.submitProductOrder = submitProductOrder;
	}
	public AttachmentTypes[] getAttachmentCriteria() {
		return attachmentCriteria;
	}
	public void setAttachmentCriteria(final AttachmentTypes[] attachmentCriteria) {
		this.attachmentCriteria = attachmentCriteria;
	}
	public ReturnConfigurationData getReturnConfigurationData() {
		return returnConfigurationData;
	}
	public void setReturnConfigurationData(final
			ReturnConfigurationData returnConfigurationData) {
		this.returnConfigurationData = returnConfigurationData;
	}
	public ProductConfigurationChanges[] getProductChanges() {
		return productChanges;
	}
	public void setProductChanges(final ProductConfigurationChanges[] productChanges) {
		this.productChanges = productChanges;
	}
	public boolean isAddDefaultChildItemsImplicitly() {
		return addDefaultChildItemsImplicitly;
	}
	public void setAddDefaultChildItemsImplicitly(final
			boolean addDefaultChildItemsImplicitly) {
		this.addDefaultChildItemsImplicitly = addDefaultChildItemsImplicitly;
	}
	public ConfigureReplaceProductOffering[] getReplaceProductOfferingConfiguration() {
		return replaceProductOfferingConfiguration;
	}
	public void setReplaceProductOfferingConfiguration(final
			ConfigureReplaceProductOffering[] replaceProductOfferingConfiguration) {
		this.replaceProductOfferingConfiguration = replaceProductOfferingConfiguration;
	}
	public String getBasicPriceSchemaID() {
		return basicPriceSchemaID;
	}
	public void setBasicPriceSchemaID(final String basicPriceSchemaID) {
		this.basicPriceSchemaID = basicPriceSchemaID;
	}
	public String getProductOrderID() {
		return productOrderID;
	}
	public void setProductOrderID(final String productOrderID) {
		this.productOrderID = productOrderID;
	}
	public String getExternalUserID() {
		return externalUserID;
	}
	public void setExternalUserID(final String externalUserID) {
		this.externalUserID = externalUserID;
	}
	public String getExternalUserOrg() {
		return externalUserOrg;
	}
	public void setExternalUserOrg(final String externalUserOrg) {
		this.externalUserOrg = externalUserOrg;
	}
		
}