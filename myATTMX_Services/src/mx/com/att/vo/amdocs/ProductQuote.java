package mx.com.att.vo.amdocs;

public class ProductQuote {
	
	public LinkVO[] Link;
	
	public String currency;
	public String productCatalogID;
	public String productDescription;
	public String productID;
	public String productName;
	public String validationStatus;
	public OneTimePriceForOrder oneTimePrice;
	public RecurringPriceForOrder recurringPrice;
	public ServiceQuote[] services;
	public ValidationMessage[] validationMessages;
	public DeviceQuote devices;
	public PlanQuote[] plan;
	public AccessoryQuote[] accessories;
	
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(final String currency) {
		this.currency = currency;
	}
	public String getProductCatalogID() {
		return productCatalogID;
	}
	public void setProductCatalogID(final String productCatalogID) {
		this.productCatalogID = productCatalogID;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(final String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(final String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(final String productName) {
		this.productName = productName;
	}
	public String getValidationStatus() {
		return validationStatus;
	}
	public void setValidationStatus(final String validationStatus) {
		this.validationStatus = validationStatus;
	}
	public OneTimePriceForOrder getOneTimePrice() {
		return oneTimePrice;
	}
	public void setOneTimePrice(final OneTimePriceForOrder oneTimePrice) {
		this.oneTimePrice = oneTimePrice;
	}
	public RecurringPriceForOrder getRecurringPrice() {
		return recurringPrice;
	}
	public void setRecurringPrice(final RecurringPriceForOrder recurringPrice) {
		this.recurringPrice = recurringPrice;
	}
	public ServiceQuote[] getServices() {
		return services;
	}
	public void setServices(final ServiceQuote[] services) {
		this.services = services;
	}
	public ValidationMessage[] getValidationMessages() {
		return validationMessages;
	}
	public void setValidationMessages(final ValidationMessage[] validationMessages) {
		this.validationMessages = validationMessages;
	}
	public DeviceQuote getDevices() {
		return devices;
	}
	public void setDevices(final DeviceQuote devices) {
		this.devices = devices;
	}
	public PlanQuote[] getPlan() {
		return plan;
	}
	public void setPlan(final PlanQuote[] plan) {
		this.plan = plan;
	}
	public AccessoryQuote[] getAccessories() {
		return accessories;
	}
	public void setAccessories(final AccessoryQuote[] accessories) {
		this.accessories = accessories;
	}

	
	
}
