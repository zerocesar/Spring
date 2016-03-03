package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class NewPricePackage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LinkVO[] link;
	public String catalogItemID;
	public String parentID;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public String getCatalogItemID() {
		return catalogItemID;
	}
	public void setCatalogItemID(final String catalogItemID) {
		this.catalogItemID = catalogItemID;
	}
	public String getParentID() {
		return parentID;
	}
	public void setParentID(final String parentID) {
		this.parentID = parentID;
	}
	

}