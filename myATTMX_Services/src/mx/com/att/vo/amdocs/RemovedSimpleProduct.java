package mx.com.att.vo.amdocs;

public class RemovedSimpleProduct {
	private LinkVO[] link;
	private String parentTemporaryID;
	private String productID;
	private String productSpecContainmentID;
	private String simpleProductSpecID;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getParentTemporaryID() {
		return parentTemporaryID;
	}
	public final void setParentTemporaryID(final String parentTemporaryID) {
		this.parentTemporaryID = parentTemporaryID;
	}
	public final String getProductID() {
		return productID;
	}
	public final void setProductID(final String productID) {
		this.productID = productID;
	}
	public final String getProductSpecContainmentID() {
		return productSpecContainmentID;
	}
	public final void setProductSpecContainmentID(final String productSpecContainmentID) {
		this.productSpecContainmentID = productSpecContainmentID;
	}
	public final String getSimpleProductSpecID() {
		return simpleProductSpecID;
	}
	public final void setSimpleProductSpecID(final String simpleProductSpecID) {
		this.simpleProductSpecID = simpleProductSpecID;
	}	
}
