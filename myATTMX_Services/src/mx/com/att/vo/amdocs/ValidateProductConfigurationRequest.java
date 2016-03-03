package mx.com.att.vo.amdocs;

public class ValidateProductConfigurationRequest {
	private LinkVO[] link;
	private String activityForConfiguration;
//	private ConfigurationLevelFilter configurationLevel;
	private String containedProductID;
	private String containedProductSpecID;
	private Boolean returnRemovedItems;
//	private SettingsViewFilter settingsView;
	private String serviceRequiredDate;
	private String[] stepsToValidate;
	private ProductConfigurationChanges[] productChanges;
	private AttachmentTypes[] attachmentCriteria;
	private ReturnConfigurationData[] returnConfigurationData;
	private Boolean addDefaultChildItemsImplicitly;
	private Boolean returnRemovedByReplaceItems;
	
	public final LinkVO[] getLinkVO() {
		return link;
	}
	public final void setLinkVO(final LinkVO[] link) {
		this.link = link;
	}
	public final String getActivityForConfiguration() {
		return activityForConfiguration;
	}
	public final void setActivityForConfiguration(final String activityForConfiguration) {
		this.activityForConfiguration = activityForConfiguration;
	}
	public final String getContainedProductID() {
		return containedProductID;
	}
	public final void setContainedProductID(final String containedProductID) {
		this.containedProductID = containedProductID;
	}
	public final String getContainedProductSpecID() {
		return containedProductSpecID;
	}
	public final void setContainedProductSpecID(final String containedProductSpecID) {
		this.containedProductSpecID = containedProductSpecID;
	}
	public final Boolean getReturnRemovedItems() {
		return returnRemovedItems;
	}
	public final void setReturnRemovedItems(final Boolean returnRemovedItems) {
		this.returnRemovedItems = returnRemovedItems;
	}
	public final String getServiceRequiredDate() {
		return serviceRequiredDate;
	}
	public final void setServiceRequiredDate(final String serviceRequiredDate) {
		this.serviceRequiredDate = serviceRequiredDate;
	}
	public final String[] getStepsToValidate() {
		return stepsToValidate;
	}
	public final void setStepsToValidate(final String[] stepsToValidate) {
		this.stepsToValidate = stepsToValidate;
	}
	public final ProductConfigurationChanges[] getProductChanges() {
		return productChanges;
	}
	public final void setProductChanges(final ProductConfigurationChanges[] productChanges) {
		this.productChanges = productChanges;
	}
	public final AttachmentTypes[] getAttachmentCriteria() {
		return attachmentCriteria;
	}
	public final void setAttachmentCriteria(final AttachmentTypes[] attachmentCriteria) {
		this.attachmentCriteria = attachmentCriteria;
	}
	public final ReturnConfigurationData[] getReturnConfigurationData() {
		return returnConfigurationData;
	}
	public final void setReturnConfigurationData(final 
			ReturnConfigurationData[] returnConfigurationData) {
		this.returnConfigurationData = returnConfigurationData;
	}
	public final Boolean getAddDefaultChildItemsImplicitly() {
		return addDefaultChildItemsImplicitly;
	}
	public final void setAddDefaultChildItemsImplicitly(final 
			Boolean addDefaultChildItemsImplicitly) {
		this.addDefaultChildItemsImplicitly = addDefaultChildItemsImplicitly;
	}
	public final Boolean getReturnRemovedByReplaceItems() {
		return returnRemovedByReplaceItems;
	}
	public final void setReturnRemovedByReplaceItems(final 
			Boolean returnRemovedByReplaceItems) {
		this.returnRemovedByReplaceItems = returnRemovedByReplaceItems;
	}
	
}
