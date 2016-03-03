package mx.com.att.vo.amdocs;

public class AccessoryQuote {

	private LinkVO[] Link;
	//public ServiceAction action;
	public String brand;
	public String catalogItemDescription;
	public String catalogItemID;
	public String catalogItemImage;
	public String catalogItemName;
	public String model;
	public int quantity;
	public RecurringPriceForOrder recurringPrice;
	public OneTimePriceForOrder oneTimePrice;
	
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	/*
	public ServiceAction getAction() {
		return action;
	}
	public void setAction(final ServiceAction action) {
		this.action = action;
	}
	*/
	public String getBrand() {
		return brand;
	}
	public void setBrand(final String brand) {
		this.brand = brand;
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
	public String getModel() {
		return model;
	}
	public void setModel(final String model) {
		this.model = model;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(final int quantity) {
		this.quantity = quantity;
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
