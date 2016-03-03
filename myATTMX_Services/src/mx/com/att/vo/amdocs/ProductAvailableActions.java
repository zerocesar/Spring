package mx.com.att.vo.amdocs;

public class ProductAvailableActions {
	
	private LinkVO[] link;
	private String productId;
	private ProductAvailableAction[] catalogItemDescription;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(final String productId) {
		this.productId = productId;
	}
	public ProductAvailableAction[] getCatalogItemDescription() {
		return catalogItemDescription;
	}
	public void setCatalogItemDescription(final 
			ProductAvailableAction[] catalogItemDescription) {
		this.catalogItemDescription = catalogItemDescription;
	}
	
	
}
