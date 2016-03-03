package mx.com.att.vo.amdocs;

import java.util.Date;


public class CreateNewOfferingConfigurationRequest {
	
	
	private LinkVO[]	link;
	private String activityForConfiguration;
	//private ConfigurationLevelFilter configurationLevel;
	private Boolean confirmationMessagesApproved;
	private String installationAddressID;
	private String orderReferenceNumber;
	private String productOrderID;
	//private ReturnedConfiguration returnConfiguration;
	private Boolean runCompatibilityRules;
	private Date serviceRequiredDate;
	//private SettingsViewFilter settingsView;
	private String externalUserID;
	private String externalUserOrg;
	private String subscriptionGroupID;
	private ProductDetails[] newProducts;
	private ReturnConfigurationData returnConfigurationData;
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
	}*/
	public Boolean getConfirmationMessagesApproved() {
		return confirmationMessagesApproved;
	}
	public void setConfirmationMessagesApproved(Boolean confirmationMessagesApproved) {
		this.confirmationMessagesApproved = confirmationMessagesApproved;
	}
	public String getInstallationAddressID() {
		return installationAddressID;
	}
	public void setInstallationAddressID(String installationAddressID) {
		this.installationAddressID = installationAddressID;
	}
	public String getOrderReferenceNumber() {
		return orderReferenceNumber;
	}
	public void setOrderReferenceNumber(String orderReferenceNumber) {
		this.orderReferenceNumber = orderReferenceNumber;
	}
	public String getProductOrderID() {
		return productOrderID;
	}
	public void setProductOrderID(String productOrderID) {
		this.productOrderID = productOrderID;
	}
	/*
	public ReturnedConfiguration getReturnConfiguration() {
		return returnConfiguration;
	}
	public void setReturnConfiguration(ReturnedConfiguration returnConfiguration) {
		this.returnConfiguration = returnConfiguration;
	}
	*/
	public Boolean getRunCompatibilityRules() {
		return runCompatibilityRules;
	}
	public void setRunCompatibilityRules(Boolean runCompatibilityRules) {
		this.runCompatibilityRules = runCompatibilityRules;
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
	public String getExternalUserID() {
		return externalUserID;
	}
	public void setExternalUserID(String externalUserID) {
		this.externalUserID = externalUserID;
	}
	public String getExternalUserOrg() {
		return externalUserOrg;
	}
	public void setExternalUserOrg(String externalUserOrg) {
		this.externalUserOrg = externalUserOrg;
	}
	public String getSubscriptionGroupID() {
		return subscriptionGroupID;
	}
	public void setSubscriptionGroupID(String subscriptionGroupID) {
		this.subscriptionGroupID = subscriptionGroupID;
	}
	public ProductDetails[] getNewProducts() {
		return newProducts;
	}
	public void setNewProducts(ProductDetails[] newProducts) {
		this.newProducts = newProducts;
	}
	public ReturnConfigurationData getReturnConfigurationData() {
		return returnConfigurationData;
	}
	public void setReturnConfigurationData(
			ReturnConfigurationData returnConfigurationData) {
		this.returnConfigurationData = returnConfigurationData;
	}

	

}
