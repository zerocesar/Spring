package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class RemovedPricePackage implements Serializable{

	private static final long serialVersionUID = 1L;
	public LinkVO[] Link;
	public String pricePackageID;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getPricePackageID() {
		return pricePackageID;
	}
	public void setPricePackageID(final String pricePackageID) {
		this.pricePackageID = pricePackageID;
	}
	
}