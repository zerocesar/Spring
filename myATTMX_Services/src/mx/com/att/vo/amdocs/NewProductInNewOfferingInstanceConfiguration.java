package mx.com.att.vo.amdocs;

public class NewProductInNewOfferingInstanceConfiguration {
	
	private LinkVO[] link;
	private String installationAddressID;
	private String productID;
	private String productOfferingInstanceID;
	private String productOfferingProductSpecID;
	private String productOrderItemID;
	private String productOrderItemReferenceNumber;
	private String productOrderItemType;
	private String subscriptionGroupID;
	private TopLevelProductConfiguration productConfiguration;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public String getInstallationAddressID() {
		return installationAddressID;
	}
	public void setInstallationAddressID(final String installationAddressID) {
		this.installationAddressID = installationAddressID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(final String productID) {
		this.productID = productID;
	}
	public String getProductOfferingInstanceID() {
		return productOfferingInstanceID;
	}
	public void setProductOfferingInstanceID(final String productOfferingInstanceID) {
		this.productOfferingInstanceID = productOfferingInstanceID;
	}
	public String getProductOfferingProductSpecID() {
		return productOfferingProductSpecID;
	}
	public void setProductOfferingProductSpecID(final String productOfferingProductSpecID) {
		this.productOfferingProductSpecID = productOfferingProductSpecID;
	}
	public String getProductOrderItemID() {
		return productOrderItemID;
	}
	public void setProductOrderItemID(final String productOrderItemID) {
		this.productOrderItemID = productOrderItemID;
	}
	public String getProductOrderItemReferenceNumber() {
		return productOrderItemReferenceNumber;
	}
	public void setProductOrderItemReferenceNumber(final 
			String productOrderItemReferenceNumber) {
		this.productOrderItemReferenceNumber = productOrderItemReferenceNumber;
	}
	public String getProductOrderItemType() {
		return productOrderItemType;
	}
	public void setProductOrderItemType(final String productOrderItemType) {
		this.productOrderItemType = productOrderItemType;
	}
	public String getSubscriptionGroupID() {
		return subscriptionGroupID;
	}
	public void setSubscriptionGroupID(final String subscriptionGroupID) {
		this.subscriptionGroupID = subscriptionGroupID;
	}
	public TopLevelProductConfiguration getProductConfiguration() {
		return productConfiguration;
	}
	public void setProductConfiguration(final 
			TopLevelProductConfiguration productConfiguration) {
		this.productConfiguration = productConfiguration;
	}

	
	
}
