package mx.com.att.vo.amdocs;

public class Plan {
	
	private LinkVO[] link;
	private Service[] services;
	private OneTimePriceForOrder oneTimeQuote;
	private ConfigurationParameter[] parameters;
	private RecurringPriceForOrder recurringPrice;
	private String catalogItemDescription;
	private String catalogItemID;
	//private MapStringObject catalogItemImage;
	private String catalogItemImages;
	private String catalogItemMarketingDescription;
	private String catalogItemName;
	private String id;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public Service[] getServices() {
		return services;
	}
	public void setServices(Service[] services) {
		this.services = services;
	}
	public OneTimePriceForOrder getOneTimeQuote() {
		return oneTimeQuote;
	}
	public void setOneTimeQuote(OneTimePriceForOrder oneTimeQuote) {
		this.oneTimeQuote = oneTimeQuote;
	}
	public ConfigurationParameter[] getParameters() {
		return parameters;
	}
	public void setParameters(ConfigurationParameter[] parameters) {
		this.parameters = parameters;
	}
	public RecurringPriceForOrder getRecurringPrice() {
		return recurringPrice;
	}
	public void setRecurringPrice(RecurringPriceForOrder recurringPrice) {
		this.recurringPrice = recurringPrice;
	}
	public String getCatalogItemDescription() {
		return catalogItemDescription;
	}
	public void setCatalogItemDescription(String catalogItemDescription) {
		this.catalogItemDescription = catalogItemDescription;
	}
	public String getCatalogItemID() {
		return catalogItemID;
	}
	public void setCatalogItemID(String catalogItemID) {
		this.catalogItemID = catalogItemID;
	}
	/*
	public MapStringObject getCatalogItemImage() {
		return catalogItemImage;
	}
	public void setCatalogItemImage(MapStringObject catalogItemImage) {
		this.catalogItemImage = catalogItemImage;
	}
	*/
	public String getCatalogItemImages() {
		return catalogItemImages;
	}
	public void setCatalogItemImages(String catalogItemImages) {
		this.catalogItemImages = catalogItemImages;
	}
	public String getCatalogItemMarketingDescription() {
		return catalogItemMarketingDescription;
	}
	public void setCatalogItemMarketingDescription(
			String catalogItemMarketingDescription) {
		this.catalogItemMarketingDescription = catalogItemMarketingDescription;
	}
	public String getCatalogItemName() {
		return catalogItemName;
	}
	public void setCatalogItemName(String catalogItemName) {
		this.catalogItemName = catalogItemName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

	
	
}
