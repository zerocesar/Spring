package mx.com.att.vo.amdocs;

public class ChangedContainedProduct {
	private LinkVO[] link;
	private String parentProductSpecContainmentID;
	private String parentTemporaryID;
	private String productID;
	private String productSpecContainmentID;
	private String temporaryID;
	private CharacteristicValueChange[] changedCharacteristics;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getParentProductSpecContainmentID() {
		return parentProductSpecContainmentID;
	}
	public final void setParentProductSpecContainmentID(final 
			String parentProductSpecContainmentID) {
		this.parentProductSpecContainmentID = parentProductSpecContainmentID;
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
	public final String getTemporaryID() {
		return temporaryID;
	}
	public final void setTemporaryID(final String temporaryID) {
		this.temporaryID = temporaryID;
	}
	public final CharacteristicValueChange[] getChangedCharacteristics() {
		return changedCharacteristics;
	}
	public final void setChangedCharacteristics(final 
			CharacteristicValueChange[] changedCharacteristics) {
		this.changedCharacteristics = changedCharacteristics;
	}
}
