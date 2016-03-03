package mx.com.att.vo.amdocs;

public class PricePackage {

	private LinkVO[] Link;
	private String catalogItemDescription;
	private String catalogItemID;
	private String catalogItemName;
	private String catalogItemUsageDescription;
	private Boolean defaultPP;
	private String id;
	private String status;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(LinkVO[] link) {
		Link = link;
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
	public String getCatalogItemName() {
		return catalogItemName;
	}
	public void setCatalogItemName(String catalogItemName) {
		this.catalogItemName = catalogItemName;
	}
	public String getCatalogItemUsageDescription() {
		return catalogItemUsageDescription;
	}
	public void setCatalogItemUsageDescription(String catalogItemUsageDescription) {
		this.catalogItemUsageDescription = catalogItemUsageDescription;
	}
	public Boolean getDefaultPP() {
		return defaultPP;
	}
	public void setDefaultPP(Boolean defaultPP) {
		this.defaultPP = defaultPP;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
