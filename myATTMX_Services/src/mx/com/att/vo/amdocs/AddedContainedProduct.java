package mx.com.att.vo.amdocs;

public class AddedContainedProduct {
	private LinkVO[] link;
	private CharacteristicValueChange[] changedCharacteristics;
	private String parentProductID;
	private String parentProductSpecContainmentID;
	private String parentTemporaryID;
	private String productSpecContainmentID;
	private String productSpecID;
	private String temporaryID;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public CharacteristicValueChange[] getChangedCharacteristics() {
		return changedCharacteristics;
	}
	public void setChangedCharacteristics(final 
			CharacteristicValueChange[] changedCharacteristics) {
		this.changedCharacteristics = changedCharacteristics;
	}
	public final String getParentProductID() {
		return parentProductID;
	}
	public final void setParentProductID(final String parentProductID) {
		this.parentProductID = parentProductID;
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
	public final String getProductSpecContainmentID() {
		return productSpecContainmentID;
	}
	public final void setProductSpecContainmentID(final String productSpecContainmentID) {
		this.productSpecContainmentID = productSpecContainmentID;
	}
	public final String getProductSpecID() {
		return productSpecID;
	}
	public final void setProductSpecID(final String productSpecID) {
		this.productSpecID = productSpecID;
	}
	public final String getTemporaryID() {
		return temporaryID;
	}
	public final void setTemporaryID(final String temporaryID) {
		this.temporaryID = temporaryID;
	}
}
