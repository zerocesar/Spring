package mx.com.att.vo.amdocs;

public class SimpleProductReferenceDisplay {
	private LinkVO[]	link;
//	private Boolean	default;
	private String	productSpecRelationshipID;
	private String	simpleProductSpecID;
	private AssignedBillingOfferDisplay[]	displayableBillingOffers;
	private ProductSpecification	originalProductSpecification;
	private ProductSpecDisplay	displayInformation;
	private TotalOneTimeCalculatedPrice	totalOneTimeCalculatedPrice;
	private BrowsingCategory	browsingCategory;
	private AllowedAction	allowedActions;
	private ProductSpecContainment	productSpecContainment;
	private TotalDepositCalculationResult	totalDeposit;
	private ProductSpecDisplay	originalCatalogDisplayInformation;
	private ActivityChargeDisplay[]	displayableActivityCharges;
	private CharacteristicValueDisplay[]	displayableCharacteristics;
	private TotalRecurringCalculatedPrice	totalRecurringCalculatedPrice;
//	private ProductConfigurationActionType	action;
//	private ProductBusinessType	businessType;
	private String	productID;
	private String	productSpecContainmentID;
	private boolean	selected;
	private String	serviceID;
//	private ProductActivationStatus	status;
	private String	temporaryID;
	private String	name;
	private String	parentProductID;
	private String	parentProductSpecContainmentID;
	private String	parentTemporaryID;
	private String	parentID;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getProductSpecRelationshipID() {
		return productSpecRelationshipID;
	}
	public final void setProductSpecRelationshipID(final String productSpecRelationshipID) {
		this.productSpecRelationshipID = productSpecRelationshipID;
	}
	public final String getSimpleProductSpecID() {
		return simpleProductSpecID;
	}
	public final void setSimpleProductSpecID(final String simpleProductSpecID) {
		this.simpleProductSpecID = simpleProductSpecID;
	}
	public final AssignedBillingOfferDisplay[] getDisplayableBillingOffers() {
		return displayableBillingOffers;
	}
	public final void setDisplayableBillingOffers(final 
			AssignedBillingOfferDisplay[] displayableBillingOffers) {
		this.displayableBillingOffers = displayableBillingOffers;
	}
	public final ProductSpecification getOriginalProductSpecification() {
		return originalProductSpecification;
	}
	public final void setOriginalProductSpecification(final 
			ProductSpecification originalProductSpecification) {
		this.originalProductSpecification = originalProductSpecification;
	}
	public final ProductSpecDisplay getDisplayInformation() {
		return displayInformation;
	}
	public final void setDisplayInformation(final ProductSpecDisplay displayInformation) {
		this.displayInformation = displayInformation;
	}
	public final TotalOneTimeCalculatedPrice getTotalOneTimeCalculatedPrice() {
		return totalOneTimeCalculatedPrice;
	}
	public final void setTotalOneTimeCalculatedPrice(final 
			TotalOneTimeCalculatedPrice totalOneTimeCalculatedPrice) {
		this.totalOneTimeCalculatedPrice = totalOneTimeCalculatedPrice;
	}
	public final BrowsingCategory getBrowsingCategory() {
		return browsingCategory;
	}
	public final void setBrowsingCategory(final BrowsingCategory browsingCategory) {
		this.browsingCategory = browsingCategory;
	}
	public AllowedAction getAllowedActions() {
		return allowedActions;
	}
	public void setAllowedActions(final AllowedAction allowedActions) {
		this.allowedActions = allowedActions;
	}
	public final ProductSpecContainment getProductSpecContainment() {
		return productSpecContainment;
	}
	public final void setProductSpecContainment(final 
			ProductSpecContainment productSpecContainment) {
		this.productSpecContainment = productSpecContainment;
	}
	public final TotalDepositCalculationResult getTotalDeposit() {
		return totalDeposit;
	}
	public final void setTotalDeposit(final TotalDepositCalculationResult totalDeposit) {
		this.totalDeposit = totalDeposit;
	}
	public final ProductSpecDisplay getOriginalCatalogDisplayInformation() {
		return originalCatalogDisplayInformation;
	}
	public final void setOriginalCatalogDisplayInformation(final 
			ProductSpecDisplay originalCatalogDisplayInformation) {
		this.originalCatalogDisplayInformation = originalCatalogDisplayInformation;
	}
	public ActivityChargeDisplay[] getDisplayableActivityCharges() {
		return displayableActivityCharges;
	}
	public void setDisplayableActivityCharges(final 
			ActivityChargeDisplay[] displayableActivityCharges) {
		this.displayableActivityCharges = displayableActivityCharges;
	}
	public final CharacteristicValueDisplay[] getDisplayableCharacteristics() {
		return displayableCharacteristics;
	}
	public final void setDisplayableCharacteristics(final 
			CharacteristicValueDisplay[] displayableCharacteristics) {
		this.displayableCharacteristics = displayableCharacteristics;
	}
	public final TotalRecurringCalculatedPrice getTotalRecurringCalculatedPrice() {
		return totalRecurringCalculatedPrice;
	}
	public final void setTotalRecurringCalculatedPrice(final 
			TotalRecurringCalculatedPrice totalRecurringCalculatedPrice) {
		this.totalRecurringCalculatedPrice = totalRecurringCalculatedPrice;
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
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(final boolean selected) {
		this.selected = selected;
	}
	public final String getServiceID() {
		return serviceID;
	}
	public final void setServiceID(final String serviceID) {
		this.serviceID = serviceID;
	}
	public final String getTemporaryID() {
		return temporaryID;
	}
	public final void setTemporaryID(final String temporaryID) {
		this.temporaryID = temporaryID;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
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
	public final String getParentID() {
		return parentID;
	}
	public final void setParentID(final String parentID) {
		this.parentID = parentID;
	}

}
