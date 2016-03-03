package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class RemoveContainedProduct implements Serializable{

	private static final long serialVersionUID = 1L;
	public LinkVO[] Link;		
	public String productSpecContainmentID;
	public String parentTemporaryID;
	public String productID;
	
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(LinkVO[] link) {
		Link = link;
	}
	public String getProductSpecContainmentID() {
		return productSpecContainmentID;
	}
	public void setProductSpecContainmentID(final String productSpecContainmentID) {
		this.productSpecContainmentID = productSpecContainmentID;
	}
	public String getParentTemporaryID() {
		return parentTemporaryID;
	}
	public void setParentTemporaryID(final String parentTemporaryID) {
		this.parentTemporaryID = parentTemporaryID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(final String productID) {
		this.productID = productID;
	}
	
	
	

}