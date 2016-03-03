package mx.com.att.vo.amdocs;

public class ResumeContainedProduct {
	private LinkVO[] link;
	private String productID;
	private CharacteristicValueChange[] changedCharacteristics;
	
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
	public final CharacteristicValueChange[] getChangedCharacteristics() {
		return changedCharacteristics;
	}
	public final void setChangedCharacteristics(final 
			CharacteristicValueChange[] changedCharacteristics) {
		this.changedCharacteristics = changedCharacteristics;
	}
}
