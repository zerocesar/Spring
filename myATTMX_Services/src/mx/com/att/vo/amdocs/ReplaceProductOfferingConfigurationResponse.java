package mx.com.att.vo.amdocs;

public class ReplaceProductOfferingConfigurationResponse {
	
	
	public String newProductOfferingID;
	public ReplaceProductOfferingProductConfigurationResponse[] products;
	
	public String getNewProductOfferingID() {
		return newProductOfferingID;
	}
	public void setNewProductOfferingID(final String newProductOfferingID) {
		this.newProductOfferingID = newProductOfferingID;
	}
	public ReplaceProductOfferingProductConfigurationResponse[] getProducts() {
		return products;
	}
	public void setProducts(final 
			ReplaceProductOfferingProductConfigurationResponse[] products) {
		this.products = products;
	}

	
}
