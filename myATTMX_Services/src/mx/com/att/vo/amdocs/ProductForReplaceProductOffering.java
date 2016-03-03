package mx.com.att.vo.amdocs;

public class ProductForReplaceProductOffering {
	
	public String productID;
	public String productOrderItemID;
	public String productOrderItemReferenceNumber;
	public String newBasicPriceScehmaID;
	public String newProductOfferingProductSpecID;
	public ProductConfigurationChanges productForReplacement;
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(final String productID) {
		this.productID = productID;
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
	public String getNewBasicPriceScehmaID() {
		return newBasicPriceScehmaID;
	}
	public void setNewBasicPriceScehmaID(final String newBasicPriceScehmaID) {
		this.newBasicPriceScehmaID = newBasicPriceScehmaID;
	}
	public String getNewProductOfferingProductSpecID() {
		return newProductOfferingProductSpecID;
	}
	public void setNewProductOfferingProductSpecID(final
			String newProductOfferingProductSpecID) {
		this.newProductOfferingProductSpecID = newProductOfferingProductSpecID;
	}
	public ProductConfigurationChanges getProductForReplacement() {
		return productForReplacement;
	}
	public void setProductForReplacement(final
			ProductConfigurationChanges productForReplacement) {
		this.productForReplacement = productForReplacement;
	}
	
	
	
	
}
