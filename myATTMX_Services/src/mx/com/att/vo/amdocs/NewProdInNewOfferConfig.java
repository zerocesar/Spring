package mx.com.att.vo.amdocs;

public class NewProdInNewOfferConfig {
	
	private LinkVO[] link;
	private String basicPriceSchemaID;
	private String installationAddressID;
	private String productOfferingProductSpecID;
	private String productOrderItemType;
	private TopLevelProductConfiguration productConfiguration;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getBasicPriceSchemaID() {
		return basicPriceSchemaID;
	}
	public void setBasicPriceSchemaID(String basicPriceSchemaID) {
		this.basicPriceSchemaID = basicPriceSchemaID;
	}
	public String getInstallationAddressID() {
		return installationAddressID;
	}
	public void setInstallationAddressID(String installationAddressID) {
		this.installationAddressID = installationAddressID;
	}
	public String getProductOfferingProductSpecID() {
		return productOfferingProductSpecID;
	}
	public void setProductOfferingProductSpecID(String productOfferingProductSpecID) {
		this.productOfferingProductSpecID = productOfferingProductSpecID;
	}
	public String getProductOrderItemType() {
		return productOrderItemType;
	}
	public void setProductOrderItemType(String productOrderItemType) {
		this.productOrderItemType = productOrderItemType;
	}
	public TopLevelProductConfiguration getProductConfiguration() {
		return productConfiguration;
	}
	public void setProductConfiguration(
			TopLevelProductConfiguration productConfiguration) {
		this.productConfiguration = productConfiguration;
	}

	
}
