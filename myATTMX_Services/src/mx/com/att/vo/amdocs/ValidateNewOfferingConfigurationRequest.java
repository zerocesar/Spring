package mx.com.att.vo.amdocs;


public class ValidateNewOfferingConfigurationRequest {
	private LinkVO[] link;
	private String	activityForConfiguration;
//	private ConfigurationLevelFilter	configurationLevel;
	private String	installationAddressID;
	private String	serviceRequiredDate;
//	private SettingsViewFilter	settingsView;
	private String	stepsToRetrieve;
	private String	stepsToValidate;
	private String	subscriptionGroupID;
	private ReturnConfigurationData	returnConfigurationData;
	private ProductDetails	newProducts;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public String getActivityForConfiguration() {
		return activityForConfiguration;
	}
	public void setActivityForConfiguration(final String activityForConfiguration) {
		this.activityForConfiguration = activityForConfiguration;
	}
	public String getInstallationAddressID() {
		return installationAddressID;
	}
	public void setInstallationAddressID(final String installationAddressID) {
		this.installationAddressID = installationAddressID;
	}
	public String getServiceRequiredDate() {
		return serviceRequiredDate;
	}
	public void setServiceRequiredDate(final String serviceRequiredDate) {
		this.serviceRequiredDate = serviceRequiredDate;
	}
	public String getStepsToRetrieve() {
		return stepsToRetrieve;
	}
	public void setStepsToRetrieve(final String stepsToRetrieve) {
		this.stepsToRetrieve = stepsToRetrieve;
	}
	public String getStepsToValidate() {
		return stepsToValidate;
	}
	public void setStepsToValidate(final String stepsToValidate) {
		this.stepsToValidate = stepsToValidate;
	}
	public String getSubscriptionGroupID() {
		return subscriptionGroupID;
	}
	public void setSubscriptionGroupID(final String subscriptionGroupID) {
		this.subscriptionGroupID = subscriptionGroupID;
	}
	public ReturnConfigurationData getReturnConfigurationData() {
		return returnConfigurationData;
	}
	public void setReturnConfigurationData(final 
			ReturnConfigurationData returnConfigurationData) {
		this.returnConfigurationData = returnConfigurationData;
	}
	public ProductDetails getNewProducts() {
		return newProducts;
	}
	public void setNewProducts(final ProductDetails newProducts) {
		this.newProducts = newProducts;
	}
	
}
