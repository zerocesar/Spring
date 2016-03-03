package mx.com.att.vo.amdocs;

import java.util.Date;

public class NewOfferingConfigurationRequest {
	
	
	private LinkVO[] link;	
	private String activityForConfiguration;
	//private ConfigurationLevelFilter configurationLevel;
	private String installationAddressID;
	private Boolean itemsPerCategory;
	private String productOrderItemType;
	private Date serviceRequiredDate;
	//private SettingsViewFilter settingsView;
	private String[] stepIDs;
	private String subscriptionGroupID;
	private ReturnConfigurationData returnConfigurationData;
	private NewOfferingConfigurationRequest[] newProducts;
	private AttachmentTypes[] attachmentTypes;
	
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getActivityForConfiguration() {
		return activityForConfiguration;
	}
	public void setActivityForConfiguration(String activityForConfiguration) {
		this.activityForConfiguration = activityForConfiguration;
	}
	/*
	public ConfigurationLevelFilter getConfigurationLevel() {
		return configurationLevel;
	}
	public void setConfigurationLevel(ConfigurationLevelFilter configurationLevel) {
		this.configurationLevel = configurationLevel;
	}
	*/
	public String getInstallationAddressID() {
		return installationAddressID;
	}
	public void setInstallationAddressID(String installationAddressID) {
		this.installationAddressID = installationAddressID;
	}
	public Boolean getItemsPerCategory() {
		return itemsPerCategory;
	}
	public void setItemsPerCategory(Boolean itemsPerCategory) {
		this.itemsPerCategory = itemsPerCategory;
	}
	public String getProductOrderItemType() {
		return productOrderItemType;
	}
	public void setProductOrderItemType(String productOrderItemType) {
		this.productOrderItemType = productOrderItemType;
	}
	public Date getServiceRequiredDate() {
		return serviceRequiredDate;
	}
	public void setServiceRequiredDate(Date serviceRequiredDate) {
		this.serviceRequiredDate = serviceRequiredDate;
	}
	/*
	public SettingsViewFilter getSettingsView() {
		return settingsView;
	}
	public void setSettingsView(SettingsViewFilter settingsView) {
		this.settingsView = settingsView;
	}
	*/
	public String[] getStepIDs() {
		return stepIDs;
	}
	public void setStepIDs(String[] stepIDs) {
		this.stepIDs = stepIDs;
	}
	public String getSubscriptionGroupID() {
		return subscriptionGroupID;
	}
	public void setSubscriptionGroupID(String subscriptionGroupID) {
		this.subscriptionGroupID = subscriptionGroupID;
	}
	public ReturnConfigurationData getReturnConfigurationData() {
		return returnConfigurationData;
	}
	public void setReturnConfigurationData(
			ReturnConfigurationData returnConfigurationData) {
		this.returnConfigurationData = returnConfigurationData;
	}
	public NewOfferingConfigurationRequest[] getNewProducts() {
		return newProducts;
	}
	public void setNewProducts(NewOfferingConfigurationRequest[] newProducts) {
		this.newProducts = newProducts;
	}
	public AttachmentTypes[] getAttachmentTypes() {
		return attachmentTypes;
	}
	public void setAttachmentTypes(AttachmentTypes[] attachmentTypes) {
		this.attachmentTypes = attachmentTypes;
	}
	
	

}
