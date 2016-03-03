package mx.com.att.vo.amdocs;

public class ProductDetails {
	
	private LinkVO[]	link;
	private String basicPriceSchemaID;
	private String productOfferingProductSpecID;
	private String temporaryID;
	private ProductConfigurationChanges productChanges;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public String getBasicPriceSchemaID() {
		return basicPriceSchemaID;
	}
	public void setBasicPriceSchemaID(final String basicPriceSchemaID) {
		this.basicPriceSchemaID = basicPriceSchemaID;
	}
	public String getProductOfferingProductSpecID() {
		return productOfferingProductSpecID;
	}
	public void setProductOfferingProductSpecID(final String productOfferingProductSpecID) {
		this.productOfferingProductSpecID = productOfferingProductSpecID;
	}
	public String getTemporaryID() {
		return temporaryID;
	}
	public void setTemporaryID(final String temporaryID) {
		this.temporaryID = temporaryID;
	}
	public ProductConfigurationChanges getProductChanges() {
		return productChanges;
	}
	public void setProductChanges(final ProductConfigurationChanges productChanges) {
		this.productChanges = productChanges;
	}

		

}
