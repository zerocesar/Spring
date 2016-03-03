package mx.com.att.vo.amdocs;

public class ContainingOffering {
	
	private LinkVO[] link;
	private String[] offeringToProductIds;
	private String[] offeringId;
	private String[] productSpecIds;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String[] getOfferingToProductIds() {
		return offeringToProductIds;
	}
	public void setOfferingToProductIds(String[] offeringToProductIds) {
		this.offeringToProductIds = offeringToProductIds;
	}
	public String[] getOfferingId() {
		return offeringId;
	}
	public void setOfferingId(String[] offeringId) {
		this.offeringId = offeringId;
	}
	public String[] getProductSpecIds() {
		return productSpecIds;
	}
	public void setProductSpecIds(String[] productSpecIds) {
		this.productSpecIds = productSpecIds;
	}
	
	

}
