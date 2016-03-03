package mx.com.att.vo.amdocs;

public class RemovedAssignedBillingOffer {			 

		private LinkVO[] link;
		private String billingOfferID;
		private String parentTemporaryID;
		private String productSpecPricingID;
		private String ParentProductSpecContainmentID;
		private String ParentProductID;
		
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
			return ParentProductSpecContainmentID;
		}
		public final void setParentProductSpecContainmentID(final 
				String parentProductSpecContainmentID) {
			ParentProductSpecContainmentID = parentProductSpecContainmentID;
		}
		public final String getParentProductID() {
			return ParentProductID;
		}
		public final void setParentProductID(final String parentProductID) {
			ParentProductID = parentProductID;
		}
}
