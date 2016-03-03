package mx.com.att.vo.amdocs;

public class Device {
	
	
	private LinkVO[] Link;
	private Service[] acquisitionType;
	private String brand;
	private String catalogItemDescription;
	private String catalogItemID;
	private String catalogItemImageType;
	//private MapStringObject catalogItemImages;
	private String catalogItemMarketingDescription;
	private String catalogItemName;
	//private DeviceStatus deviceStatus;
	private String id;
	private String model;
	private ConfigurationParameter[] parameters;
	private Device[] loanedDevice;
	private Service[] services;
	
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(LinkVO[] link) {
		Link = link;
	}
	public Service[] getAcquisitionType() {
		return acquisitionType;
	}
	public void setAcquisitionType(Service[] acquisitionType) {
		this.acquisitionType = acquisitionType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
	public String getCatalogItemName() {
		return catalogItemName;
	}
	public void setCatalogItemName(String catalogItemName) {
		this.catalogItemName = catalogItemName;
	}
	/*
	public DeviceStatus getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(DeviceStatus deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public ConfigurationParameter[] getParameters() {
		return parameters;
	}
	public void setParameters(ConfigurationParameter[] parameters) {
		this.parameters = parameters;
	}
	public Device[] getLoanedDevice() {
		return loanedDevice;
	}
	public void setLoanedDevice(Device[] loanedDevice) {
		this.loanedDevice = loanedDevice;
	}
	public Service[] getServices() {
		return services;
	}
	public void setServices(Service[] services) {
		this.services = services;
	}

		
	
}
