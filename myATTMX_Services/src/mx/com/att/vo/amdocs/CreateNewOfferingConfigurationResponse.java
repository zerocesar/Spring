package mx.com.att.vo.amdocs;

public class CreateNewOfferingConfigurationResponse {
	
	
	private LinkVO[]	link;
	private String productOrderID;
	private String productOrderReferenceNumber;
	private NewProductInNewOfferingInstanceConfiguration[] newProductsInNewOfferings;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getProductOrderID() {
		return productOrderID;
	}
	public void setProductOrderID(String productOrderID) {
		this.productOrderID = productOrderID;
	}
	public String getProductOrderReferenceNumber() {
		return productOrderReferenceNumber;
	}
	public void setProductOrderReferenceNumber(String productOrderReferenceNumber) {
		this.productOrderReferenceNumber = productOrderReferenceNumber;
	}
	public NewProductInNewOfferingInstanceConfiguration[] getNewProductsInNewOfferings() {
		return newProductsInNewOfferings;
	}
	public void setNewProductsInNewOfferings(
			NewProductInNewOfferingInstanceConfiguration[] newProductsInNewOfferings) {
		this.newProductsInNewOfferings = newProductsInNewOfferings;
	}

	

}
