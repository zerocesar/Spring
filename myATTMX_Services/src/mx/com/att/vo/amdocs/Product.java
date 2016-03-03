package mx.com.att.vo.amdocs;

public class Product {
	
	private LinkVO[] link;	
	private String catalogItemDescription;
	private String catalogItemID;
	private String catalogItemImage;
	private String catalogItemImageType;
	//private MapStringObject catalogItemImages;
	private String catalogItemName;
	private Boolean ceaseActionAllowed;
	private Boolean changeActionAllowed;	
	private String offeringName;
	private String id;
	private String[] includedProductID;	
	private String lineOfBusiness;
	private String serviceId;
	private String spoDescription;
	private String spoName;
	private String status;
	private ConfigurationParameter[] parameters;	
	//private String spoDescription;
	//private String spoName;
	//private ServiceStatus status;	
	//private ConfigurationParameter[] parameters;
	private Plan plan;
	private RecurringPriceForOrder recurringPrice;
	private Device[] devices;
	private ProductPresentationGroup[] productPresentationGroups;
	private Service[] services;
	private PricePackage[] pricePackages;
	private TVPackage[] packages;
	private Channel[] channels;
		
	/*
	public String getSpoDescription() {
		return spoDescription;
	}
	public void setSpoDescription(String spoDescription) {
		this.spoDescription = spoDescription;
	}
	public String getSpoName() {
		return spoName;
	}
	public void setSpoName(String spoName) {
		this.spoName = spoName;
	}
	public ServiceStatus getStatus() {
		return status;
	}
	public void setStatus(ServiceStatus status) {
		this.status = status;
	}
	public ConfigurationParameter[] getParameters() {
		return parameters;
	}
	public void setParameters(ConfigurationParameter[] parameters) {
		this.parameters = parameters;
	}
	*/
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
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
	}*/
	public String getCatalogItemName() {
		return catalogItemName;
	}
	public void setCatalogItemName(String catalogItemName) {
		this.catalogItemName = catalogItemName;
	}
	public Boolean getCeaseActionAllowed() {
		return ceaseActionAllowed;
	}
	public void setCeaseActionAllowed(Boolean ceaseActionAllowed) {
		this.ceaseActionAllowed = ceaseActionAllowed;
	}
	public Boolean getChangeActionAllowed() {
		return changeActionAllowed;
	}
	public void setChangeActionAllowed(Boolean changeActionAllowed) {
		this.changeActionAllowed = changeActionAllowed;
	}
	public String getOfferingName() {
		return offeringName;
	}
	public void setOfferingName(String offeringName) {
		this.offeringName = offeringName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getIncludedProductID() {
		return includedProductID;
	}
	public void setIncludedProductID(String[] includedProductID) {
		this.includedProductID = includedProductID;
	}
	public String getLineOfBusiness() {
		return lineOfBusiness;
	}
	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getSpoDescription() {
		return spoDescription;
	}
	public void setSpoDescription(String spoDescription) {
		this.spoDescription = spoDescription;
	}
	public String getSpoName() {
		return spoName;
	}
	public void setSpoName(String spoName) {
		this.spoName = spoName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ConfigurationParameter[] getParameters() {
		return parameters;
	}
	public void setParameters(ConfigurationParameter[] parameters) {
		this.parameters = parameters;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public RecurringPriceForOrder getRecurringPrice() {
		return recurringPrice;
	}
	public void setRecurringPrice(RecurringPriceForOrder recurringPrice) {
		this.recurringPrice = recurringPrice;
	}
	public Device[] getDevices() {
		return devices;
	}
	public void setDevices(Device[] devices) {
		this.devices = devices;
	}
	public ProductPresentationGroup[] getProductPresentationGroups() {
		return productPresentationGroups;
	}
	public void setProductPresentationGroups(
			ProductPresentationGroup[] productPresentationGroups) {
		this.productPresentationGroups = productPresentationGroups;
	}
	public Service[] getServices() {
		return services;
	}
	public void setServices(Service[] services) {
		this.services = services;
	}
	public PricePackage[] getPricePackages() {
		return pricePackages;
	}
	public void setPricePackages(PricePackage[] pricePackages) {
		this.pricePackages = pricePackages;
	}
	public TVPackage[] getPackages() {
		return packages;
	}
	public void setPackages(TVPackage[] packages) {
		this.packages = packages;
	}
	public Channel[] getChannels() {
		return channels;
	}
	public void setChannels(Channel[] channels) {
		this.channels = channels;
	}
	
	
	
	
}
