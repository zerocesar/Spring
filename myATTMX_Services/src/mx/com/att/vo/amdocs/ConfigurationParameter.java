package mx.com.att.vo.amdocs;

public class ConfigurationParameter {
	
	private LinkVO[]	link;
	//private ConfigurationParameterBusinessType businessType;
	private String catalogId;
	private String name;
	private String valueDisplayName;
	private String catalogItemImages;
	private String valueName;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	/*
	public ConfigurationParameterBusinessType getBusinessType() {
		return businessType;
	}
	public void setBusinessType(ConfigurationParameterBusinessType businessType) {
		this.businessType = businessType;
	}*/
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValueDisplayName() {
		return valueDisplayName;
	}
	public void setValueDisplayName(String valueDisplayName) {
		this.valueDisplayName = valueDisplayName;
	}
	public String getCatalogItemImages() {
		return catalogItemImages;
	}
	public void setCatalogItemImages(String catalogItemImages) {
		this.catalogItemImages = catalogItemImages;
	}
	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}	

}
