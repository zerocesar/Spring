package mx.com.att.vo.amdocs;

public class RelatedItemDetailRequest {
	
	private LinkVO[] link;
	private String relatedItemProductSpecID;
	private String relatedItemProductOfferingID;
	private String relatedItemProductOfferingProductSpecID;
	private String relatedItemRelationID;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public String getRelatedItemProductSpecID() {
		return relatedItemProductSpecID;
	}
	public void setRelatedItemProductSpecID(final String relatedItemProductSpecID) {
		this.relatedItemProductSpecID = relatedItemProductSpecID;
	}
	public String getRelatedItemProductOfferingID() {
		return relatedItemProductOfferingID;
	}
	public void setRelatedItemProductOfferingID(final String relatedItemProductOfferingID) {
		this.relatedItemProductOfferingID = relatedItemProductOfferingID;
	}
	public String getRelatedItemProductOfferingProductSpecID() {
		return relatedItemProductOfferingProductSpecID;
	}
	public void setRelatedItemProductOfferingProductSpecID(final 
			String relatedItemProductOfferingProductSpecID) {
		this.relatedItemProductOfferingProductSpecID = relatedItemProductOfferingProductSpecID;
	}
	public String getRelatedItemRelationID() {
		return relatedItemRelationID;
	}
	public void setRelatedItemRelationID(final String relatedItemRelationID) {
		this.relatedItemRelationID = relatedItemRelationID;
	}

	
}
