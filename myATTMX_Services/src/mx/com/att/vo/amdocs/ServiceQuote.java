package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ServiceQuote implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LinkVO Link[];		
	public String action;
	public String catalogItemDescription;
	public String catalogItemID;
	public String catalogItemImage;
	public String catalogItemName;
	public String serviceID;
	public String serviceType;	
	public ValidationMessage[] validationMessages;
	public PricePackageQuote[] pricePackages;
	public OneTimePriceForOrder[] activityOneTimePrices;
	public RecurringPriceForOrder recurringPrice;
	public ServiceQuote[] containedServices;
	public ConfigurationParameterForOrder[] parameters;
	public OneTimePriceForOrder oneTimePrice;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getAction() {
		return action;
	}
	public void setAction(final String action) {
		this.action = action;
	}
	public String getCatalogItemDescription() {
		return catalogItemDescription;
	}
	public void setCatalogItemDescription(final String catalogItemDescription) {
		this.catalogItemDescription = catalogItemDescription;
	}
	public String getCatalogItemID() {
		return catalogItemID;
	}
	public void setCatalogItemID(final String catalogItemID) {
		this.catalogItemID = catalogItemID;
	}
	public String getCatalogItemImage() {
		return catalogItemImage;
	}
	public void setCatalogItemImage(final String catalogItemImage) {
		this.catalogItemImage = catalogItemImage;
	}
	public String getCatalogItemName() {
		return catalogItemName;
	}
	public void setCatalogItemName(final String catalogItemName) {
		this.catalogItemName = catalogItemName;
	}
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(final String serviceType) {
		this.serviceType = serviceType;
	}
	public ValidationMessage[] getValidationMessages() {
		return validationMessages;
	}
	public void setValidationMessages(final ValidationMessage[] validationMessages) {
		this.validationMessages = validationMessages;
	}
	public PricePackageQuote[] getPricePackages() {
		return pricePackages;
	}
	public void setPricePackages(final PricePackageQuote[] pricePackages) {
		this.pricePackages = pricePackages;
	}
	public OneTimePriceForOrder[] getActivityOneTimePrices() {
		return activityOneTimePrices;
	}
	public void setActivityOneTimePrices(final 
			OneTimePriceForOrder[] activityOneTimePrices) {
		this.activityOneTimePrices = activityOneTimePrices;
	}
	public RecurringPriceForOrder getRecurringPrice() {
		return recurringPrice;
	}
	public void setRecurringPrice(final RecurringPriceForOrder recurringPrice) {
		this.recurringPrice = recurringPrice;
	}
	public ServiceQuote[] getContainedServices() {
		return containedServices;
	}
	public void setContainedServices(final ServiceQuote[] containedServices) {
		this.containedServices = containedServices;
	}
	public ConfigurationParameterForOrder[] getParameters() {
		return parameters;
	}
	public void setParameters(final ConfigurationParameterForOrder[] parameters) {
		this.parameters = parameters;
	}
	public OneTimePriceForOrder getOneTimePrice() {
		return oneTimePrice;
	}
	public void setOneTimePrice(final OneTimePriceForOrder oneTimePrice) {
		this.oneTimePrice = oneTimePrice;
	}
	
	
	
	
}