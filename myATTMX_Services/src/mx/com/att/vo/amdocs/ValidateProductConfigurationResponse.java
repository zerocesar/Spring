package mx.com.att.vo.amdocs;

public class ValidateProductConfigurationResponse {
	private LinkVO[] link;
	private String productID;
	private String productOrderID;
	private String productOrderItemID;
	private String productOrderItemReferenceNumber;
	private String productOrderReferenceNumber;
	private TopLevelProductConfiguration productConfiguration;
	private ProductDiscountsDisplay otherProductsCrossProductsDiscounts;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getProductID() {
		return productID;
	}
	public final void setProductID(final String productID) {
		this.productID = productID;
	}
	public final String getProductOrderID() {
		return productOrderID;
	}
	public final void setProductOrderID(final String productOrderID) {
		this.productOrderID = productOrderID;
	}
	public final String getProductOrderItemID() {
		return productOrderItemID;
	}
	public final void setProductOrderItemID(final String productOrderItemID) {
		this.productOrderItemID = productOrderItemID;
	}
	public final String getProductOrderItemReferenceNumber() {
		return productOrderItemReferenceNumber;
	}
	public final void setProductOrderItemReferenceNumber(final 
			String productOrderItemReferenceNumber) {
		this.productOrderItemReferenceNumber = productOrderItemReferenceNumber;
	}
	public final String getProductOrderReferenceNumber() {
		return productOrderReferenceNumber;
	}
	public final void setProductOrderReferenceNumber(final 
			String productOrderReferenceNumber) {
		this.productOrderReferenceNumber = productOrderReferenceNumber;
	}
	public final TopLevelProductConfiguration getProductConfiguration() {
		return productConfiguration;
	}
	public final void setProductConfiguration(final 
			TopLevelProductConfiguration productConfiguration) {
		this.productConfiguration = productConfiguration;
	}
	public final ProductDiscountsDisplay getOtherProductsCrossProductsDiscounts() {
		return otherProductsCrossProductsDiscounts;
	}
	public final void setOtherProductsCrossProductsDiscounts(final 
			ProductDiscountsDisplay otherProductsCrossProductsDiscounts) {
		this.otherProductsCrossProductsDiscounts = otherProductsCrossProductsDiscounts;
	}
}
