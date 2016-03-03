package mx.com.att.vo.amdocs;

public class Service {
	
	public LinkVO[] Link;
	private RecurringPriceForOrder recurringPrice;
	private ConfigurationParameter[] parameters;
	private OneTimePriceForOrder oneTimeQuote;
	private Service[] containedServices; 
	private PricePackage[] pricePackages;
	//private ServiceBusinessType businessType;
	private String catalogItemDescription;
	private String catalogItemID;
	private String catalogItemImage;
	private String catalogItemImageType;
	//private MapStringObject catalogItemImages;
	private String catalogItemMarketingDescription;
	private String catalogItemMarketingDescriptionType;
	private String catalogItemName;
	private Integer friendsAndFamilyParamsNum;
	private String id;
	//private Date initialActivationDate;
	private String serviceType;
	private String status;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(LinkVO[] link) {
		Link = link;
	}
	public RecurringPriceForOrder getRecurringPrice() {
		return recurringPrice;
	}
	public void setRecurringPrice(RecurringPriceForOrder recurringPrice) {
		this.recurringPrice = recurringPrice;
	}
	public ConfigurationParameter[] getParameters() {
		return parameters;
	}
	public void setParameters(ConfigurationParameter[] parameters) {
		this.parameters = parameters;
	}
	public OneTimePriceForOrder getOneTimeQuote() {
		return oneTimeQuote;
	}
	public void setOneTimeQuote(OneTimePriceForOrder oneTimeQuote) {
		this.oneTimeQuote = oneTimeQuote;
	}
	public Service[] getContainedServices() {
		return containedServices;
	}
	public void setContainedServices(Service[] containedServices) {
		this.containedServices = containedServices;
	}
	public PricePackage[] getPricePackages() {
		return pricePackages;
	}
	public void setPricePackages(PricePackage[] pricePackages) {
		this.pricePackages = pricePackages;
	}
	/*
	public ServiceBusinessType getBusinessType() {
		return businessType;
	}
	public void setBusinessType(ServiceBusinessType businessType) {
		this.businessType = businessType;
	}
	*/
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
	public String getCatalogItemImage() {
		return catalogItemImage;
	}
	public void setCatalogItemImage(String catalogItemImage) {
		this.catalogItemImage = catalogItemImage;
	}
	public String getCatalogItemImageType() {
		return catalogItemImageType;
	}
	public void setCatalogItemImageType(String catalogItemImageType) {
		this.catalogItemImageType = catalogItemImageType;
	}
	/*
	public MapStringObject getCatalogItemImages() {
		return catalogItemImages;
	}
	public void setCatalogItemImages(MapStringObject catalogItemImages) {
		this.catalogItemImages = catalogItemImages;
	}
	*/
	public String getCatalogItemMarketingDescription() {
		return catalogItemMarketingDescription;
	}
	public void setCatalogItemMarketingDescription(
			String catalogItemMarketingDescription) {
		this.catalogItemMarketingDescription = catalogItemMarketingDescription;
	}
	public String getCatalogItemMarketingDescriptionType() {
		return catalogItemMarketingDescriptionType;
	}
	public void setCatalogItemMarketingDescriptionType(
			String catalogItemMarketingDescriptionType) {
		this.catalogItemMarketingDescriptionType = catalogItemMarketingDescriptionType;
	}
	public String getCatalogItemName() {
		return catalogItemName;
	}
	public void setCatalogItemName(String catalogItemName) {
		this.catalogItemName = catalogItemName;
	}
	public Integer getFriendsAndFamilyParamsNum() {
		return friendsAndFamilyParamsNum;
	}
	public void setFriendsAndFamilyParamsNum(Integer friendsAndFamilyParamsNum) {
		this.friendsAndFamilyParamsNum = friendsAndFamilyParamsNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/*
	public Date getInitialActivationDate() {
		return initialActivationDate;
	}
	public void setInitialActivationDate(Date initialActivationDate) {
		this.initialActivationDate = initialActivationDate;
	}
	*/
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
