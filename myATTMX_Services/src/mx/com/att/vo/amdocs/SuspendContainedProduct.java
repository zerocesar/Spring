package mx.com.att.vo.amdocs;

public class SuspendContainedProduct {
	private LinkVO[] link;
	private String productID;
	
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
}
