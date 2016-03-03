package mx.com.att.vo.amdocs;

import java.io.Serializable;
public class ChangedSimpleProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private LinkVO[] link;
	private CharacteristicValueChange[] changedCharacteristics;
	private String simpleProductSpecID;
	private String parentProductSpecContainmentID;
	private String parentTemporaryID;
	private String productSpecContainmentID;
	private String productID;
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
	public final String getSimpleProductSpecID() {
		return simpleProductSpecID;
	}
	public final void setSimpleProductSpecID(final String simpleProductSpecID) {
		this.simpleProductSpecID = simpleProductSpecID;
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
	public final String getProductID() {
		return productID;
	}
	public final void setProductID(final String productID) {
		this.productID = productID;
	}
	public final String getTemporaryID() {
		return temporaryID;
	}
	public final void setTemporaryID(final String temporaryID) {
		this.temporaryID = temporaryID;
	}
}
