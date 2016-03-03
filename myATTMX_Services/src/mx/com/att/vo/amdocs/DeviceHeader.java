package mx.com.att.vo.amdocs;

public class DeviceHeader {
	
	
	private LinkVO[] Link;
	//private DeviceAcquisitionType acquisitionType;
	private String catalogItemName;
	private String id;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(LinkVO[] link) {
		Link = link;
	}
	/*
	public DeviceAcquisitionType getAcquisitionType() {
		return acquisitionType;
	}
	public void setAcquisitionType(DeviceAcquisitionType acquisitionType) {
		this.acquisitionType = acquisitionType;
	}
	*/
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
