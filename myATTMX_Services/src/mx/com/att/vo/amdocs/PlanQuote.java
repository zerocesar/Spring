package mx.com.att.vo.amdocs;

public class PlanQuote {
	
	private LinkVO[] Link;
	public String action;
	public String catalogItemDescription;
	public String catalogItemID;
	public String catalogItemImage;
	public String catalogItemName;
	public String pricePackageID;
	public ValidationMessage[] validationMessages;
	public ServiceQuote[] services;
	public RecurringPriceForOrder recurringPrice;
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
	public String getPricePackageID() {
		return pricePackageID;
	}
	public void setPricePackageID(final String pricePackageID) {
		this.pricePackageID = pricePackageID;
	}
	public ValidationMessage[] getValidationMessages() {
		return validationMessages;
	}
	public void setValidationMessages(final ValidationMessage[] validationMessages) {
		this.validationMessages = validationMessages;
	}
	public ServiceQuote[] getServices() {
		return services;
	}
	public void setServices(final ServiceQuote[] services) {
		this.services = services;
	}
	public RecurringPriceForOrder getRecurringPrice() {
		return recurringPrice;
	}
	public void setRecurringPrice(final RecurringPriceForOrder recurringPrice) {
		this.recurringPrice = recurringPrice;
	}
	public OneTimePriceForOrder getOneTimePrice() {
		return oneTimePrice;
	}
	public void setOneTimePrice(final OneTimePriceForOrder oneTimePrice) {
		this.oneTimePrice = oneTimePrice;
	}

	
	
}
