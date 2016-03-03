package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ProductsAvailableActions implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LinkVO[] Link;
	private ProductAvailableActions[] catalogItemDescription;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public ProductAvailableActions[] getCatalogItemDescription() {
		return catalogItemDescription;
	}
	public void setCatalogItemDescription(final 
			ProductAvailableActions[] catalogItemDescription) {
		this.catalogItemDescription = catalogItemDescription;
	}
	
	
 
}