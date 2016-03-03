package mx.com.att.vo.amdocs;

public class ProductConfigurationChanges {
	private LinkVO[] link;
	private RemovedAssignedBillingOffer[] removedAssignedBillingOffers;
	private ChangedAssignedBillingOffer[] changedAssignedBillingOffers;
	private AddedAssignedBillingOffer[] newAssignedBillingOffers;
	private ResumeContainedProduct[] resumedContainedProducts;
	private ChangedContainedProduct[] changedContainedProducts;
	private RemovedContainedProduct[] removedContainedProducts;
	private AddedContainedProduct[] newContainedProducts;
	private ChangedSimpleProduct[] changedSimpleProducts; 
	private SuspendContainedProduct[] suspendedContainedProducts;
	private RemovedSimpleProduct[] removedSimpleProducts;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final RemovedAssignedBillingOffer[] getRemovedAssignedBillingOffers() {
		return removedAssignedBillingOffers;
	}
	public final void setRemovedAssignedBillingOffers(final 
			RemovedAssignedBillingOffer[] removedAssignedBillingOffers) {
		this.removedAssignedBillingOffers = removedAssignedBillingOffers;
	}
	public final ChangedAssignedBillingOffer[] getChangedAssignedBillingOffers() {
		return changedAssignedBillingOffers;
	}
	public final void setChangedAssignedBillingOffers(final 
			ChangedAssignedBillingOffer[] changedAssignedBillingOffers) {
		this.changedAssignedBillingOffers = changedAssignedBillingOffers;
	}
	public final AddedAssignedBillingOffer[] getNewAssignedBillingOffers() {
		return newAssignedBillingOffers;
	}
	public final void setNewAssignedBillingOffers(final 
			AddedAssignedBillingOffer[] newAssignedBillingOffers) {
		this.newAssignedBillingOffers = newAssignedBillingOffers;
	}
	public final ResumeContainedProduct[] getResumedContainedProducts() {
		return resumedContainedProducts;
	}
	public final void setResumedContainedProducts(final 
			ResumeContainedProduct[] resumedContainedProducts) {
		this.resumedContainedProducts = resumedContainedProducts;
	}
	public final ChangedContainedProduct[] getChangedContainedProducts() {
		return changedContainedProducts;
	}
	public final void setChangedContainedProducts(final 
			ChangedContainedProduct[] changedContainedProducts) {
		this.changedContainedProducts = changedContainedProducts;
	}
	public final RemovedContainedProduct[] getRemovedContainedProducts() {
		return removedContainedProducts;
	}
	public final void setRemovedContainedProducts(final 
			RemovedContainedProduct[] removedContainedProducts) {
		this.removedContainedProducts = removedContainedProducts;
	}
	public final AddedContainedProduct[] getNewContainedProducts() {
		return newContainedProducts;
	}
	public final void setNewContainedProducts(final 
			AddedContainedProduct[] newContainedProducts) {
		this.newContainedProducts = newContainedProducts;
	}
	public final ChangedSimpleProduct[] getChangedSimpleProducts() {
		return changedSimpleProducts;
	}
	public final void setChangedSimpleProducts(final 
			ChangedSimpleProduct[] changedSimpleProducts) {
		this.changedSimpleProducts = changedSimpleProducts;
	}
	public final SuspendContainedProduct[] getSuspendedContainedProducts() {
		return suspendedContainedProducts;
	}
	public final void setSuspendedContainedProducts(final 
			SuspendContainedProduct[] suspendedContainedProducts) {
		this.suspendedContainedProducts = suspendedContainedProducts;
	}
	public final RemovedSimpleProduct[] getRemovedSimpleProducts() {
		return removedSimpleProducts;
	}
	public final void setRemovedSimpleProducts(final 
			RemovedSimpleProduct[] removedSimpleProducts) {
		this.removedSimpleProducts = removedSimpleProducts;
	}
}
