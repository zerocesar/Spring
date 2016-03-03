package mx.com.att.vo.amdocs;

public class RetrieveNewOfferingConfigurationResponse {
	
	private LinkVO[] link;
	private String productOfferingID;
	private String subscriptionGroupID;
	private NewProdInNewOfferConfig[] newProductsInNewOffering;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getProductOfferingID() {
		return productOfferingID;
	}
	public void setProductOfferingID(String productOfferingID) {
		this.productOfferingID = productOfferingID;
	}
	public String getSubscriptionGroupID() {
		return subscriptionGroupID;
	}
	public void setSubscriptionGroupID(String subscriptionGroupID) {
		this.subscriptionGroupID = subscriptionGroupID;
	}
	public NewProdInNewOfferConfig[] getNewProductsInNewOffering() {
		return newProductsInNewOffering;
	}
	public void setNewProductsInNewOffering(
			NewProdInNewOfferConfig[] newProductsInNewOffering) {
		this.newProductsInNewOffering = newProductsInNewOffering;
	}

	
}
