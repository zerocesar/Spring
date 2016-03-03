package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class UpdateProdConfigRes implements Serializable{

	private static final long serialVersionUID = 1L;
	public LinkVO[] Link;
	public String productID;
	public String productOrderID;
	public String productOrderItemID;
	public String productOrderItemReferenceNumber;
	public String productOrderReferenceNumber;
	public TopLevelProductConfiguration productConfiguration; 
	public ProductDiscountsDisplay[] otherProductsCrossProductDiscounts;
	public ReplaceProductOfferingConfigurationResponse[] productsInReplaceProductOffering;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(final String productID) {
		this.productID = productID;
	}
	public String getProductOrderID() {
		return productOrderID;
	}
	public void setProductOrderID(final String productOrderID) {
		this.productOrderID = productOrderID;
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
	public String getProductOrderReferenceNumber() {
		return productOrderReferenceNumber;
	}
	public void setProductOrderReferenceNumber(final String productOrderReferenceNumber) {
		this.productOrderReferenceNumber = productOrderReferenceNumber;
	}
	public TopLevelProductConfiguration getProductConfiguration() {
		return productConfiguration;
	}
	public void setProductConfiguration(final 
			TopLevelProductConfiguration productConfiguration) {
		this.productConfiguration = productConfiguration;
	}
	public ProductDiscountsDisplay[] getOtherProductsCrossProductDiscounts() {
		return otherProductsCrossProductDiscounts;
	}
	public void setOtherProductsCrossProductDiscounts(final 
			ProductDiscountsDisplay[] otherProductsCrossProductDiscounts) {
		this.otherProductsCrossProductDiscounts = otherProductsCrossProductDiscounts;
	}
	public ReplaceProductOfferingConfigurationResponse[] getProductsInReplaceProductOffering() {
		return productsInReplaceProductOffering;
	}
	public void setProductsInReplaceProductOffering(final 
			ReplaceProductOfferingConfigurationResponse[] productsInReplaceProductOffering) {
		this.productsInReplaceProductOffering = productsInReplaceProductOffering;
	}

	
	
	
	
}