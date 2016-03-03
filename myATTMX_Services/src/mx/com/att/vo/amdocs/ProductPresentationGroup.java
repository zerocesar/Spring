package mx.com.att.vo.amdocs;

public class ProductPresentationGroup {
	
	private LinkVO[] link;
	private String name;
	private ProductPresentationItem[] productPresentationItems;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductPresentationItem[] getProductPresentationItems() {
		return productPresentationItems;
	}
	public void setProductPresentationItems(
			ProductPresentationItem[] productPresentationItems) {
		this.productPresentationItems = productPresentationItems;
	}

	
	
}
