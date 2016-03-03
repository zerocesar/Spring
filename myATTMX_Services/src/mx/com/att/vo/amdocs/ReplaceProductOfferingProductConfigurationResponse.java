package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ReplaceProductOfferingProductConfigurationResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	public String productID;
	public String productOrderItemID;
	public String productOrderItemReferenceNumber;
	public TopLevelProductConfiguration productConfiguration;
	
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
	public TopLevelProductConfiguration getProductConfiguration() {
		return productConfiguration;
	}
	public void setProductConfiguration(final 
			TopLevelProductConfiguration productConfiguration) {
		this.productConfiguration = productConfiguration;
	}
	
	

	
}