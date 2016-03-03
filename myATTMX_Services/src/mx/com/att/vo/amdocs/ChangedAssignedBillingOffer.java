package mx.com.att.vo.amdocs;

public class ChangedAssignedBillingOffer {
	private LinkVO[] link;
	private String billingOfferID;
	private String parentTemporaryID;
	private String productSpecPricingID;
	private String parentProductSpecContainmentID;
	private String parentProductID;
	private OverrideInfo oneTimeChargesOverrideInformation;
	private OverrideInfo recurringChargesOverrideInformation;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getBillingOfferID() {
		return billingOfferID;
	}
	public final void setBillingOfferID(final String billingOfferID) {
		this.billingOfferID = billingOfferID;
	}
	public final String getParentTemporaryID() {
		return parentTemporaryID;
	}
	public final void setParentTemporaryID(final String parentTemporaryID) {
		this.parentTemporaryID = parentTemporaryID;
	}
	public final String getProductSpecPricingID() {
		return productSpecPricingID;
	}
	public final void setProductSpecPricingID(final String productSpecPricingID) {
		this.productSpecPricingID = productSpecPricingID;
	}
	public final String getParentProductSpecContainmentID() {
		return parentProductSpecContainmentID;
	}
	public final void setParentProductSpecContainmentID(final 
			String parentProductSpecContainmentID) {
		this.parentProductSpecContainmentID = parentProductSpecContainmentID;
	}
	public final String getParentProductID() {
		return parentProductID;
	}
	public final void setParentProductID(final String parentProductID) {
		this.parentProductID = parentProductID;
	}
	public final OverrideInfo getOneTimeChargesOverrideInformation() {
		return oneTimeChargesOverrideInformation;
	}
	public final void setOneTimeChargesOverrideInformation(final 
			OverrideInfo oneTimeChargesOverrideInformation) {
		this.oneTimeChargesOverrideInformation = oneTimeChargesOverrideInformation;
	}
	public final OverrideInfo getRecurringChargesOverrideInformation() {
		return recurringChargesOverrideInformation;
	}
	public final void setRecurringChargesOverrideInformation(final 
			OverrideInfo recurringChargesOverrideInformation) {
		this.recurringChargesOverrideInformation = recurringChargesOverrideInformation;
	}
}
