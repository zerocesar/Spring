package mx.com.att.vo.amdocs;

public class ProductDisplay {
	private LinkVO[] link;
//	private ProductBusinessType businessType;
	private AssignedBillingOfferDisplay[] displayableBillingOffers;
	private ActivityChargeDisplay[] displayableActivityCharges;
	private TotalOneTimeCalculatedPrice[] totalOneTimeCalculatedPrice;
	private CharacteristicValueDisplay displayableCharacteristics;
	private ProductSpecDisplay displayInformation;
	private ProductSpecContainment productSpecContainment;
	private ProductDisplay[] displayableItems;
	private ProductSpecDisplay originalCatalogDisplayInformation;
	private TotalRecurringCalculatedPrice totalRecurringCalculatedPrice;
	private AllowedAction[] allowedActions;
	private SimpleProductReferenceDisplay[] displayableSimpleProductReferences;
//	private ProductConfigurationActionType action;
	private String productID;
	private String productSpecContainmentID;
	private boolean selected;
	private String serviceID;
//	private ProductActivationStatus status;
	private String temporaryID;
	private TotalDepositCalculationResult totalDeposit;
	private String name;
	private boolean main;
	private boolean saleable;
	private String parentProductSpecContainmentID;
	private String parentProductID;
	private String parentTemporaryID;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final AssignedBillingOfferDisplay[] getDisplayableBillingOffers() {
		return displayableBillingOffers;
	}
	public final void setDisplayableBillingOffers(final 
			AssignedBillingOfferDisplay[] displayableBillingOffers) {
		this.displayableBillingOffers = displayableBillingOffers;
	}
	public final ActivityChargeDisplay[] getDisplayableActivityCharges() {
		return displayableActivityCharges;
	}
	public final void setDisplayableActivityCharges(final 
			ActivityChargeDisplay[] displayableActivityCharges) {
		this.displayableActivityCharges = displayableActivityCharges;
	}
	public TotalOneTimeCalculatedPrice[] getTotalOneTimeCalculatedPrice() {
		return totalOneTimeCalculatedPrice;
	}
	public void setTotalOneTimeCalculatedPrice(final 
			TotalOneTimeCalculatedPrice[] totalOneTimeCalculatedPrice) {
		this.totalOneTimeCalculatedPrice = totalOneTimeCalculatedPrice;
	}
	public CharacteristicValueDisplay getDisplayableCharacteristics() {
		return displayableCharacteristics;
	}
	public void setDisplayableCharacteristics(final 
			CharacteristicValueDisplay displayableCharacteristics) {
		this.displayableCharacteristics = displayableCharacteristics;
	}
	public final ProductSpecDisplay getDisplayInformation() {
		return displayInformation;
	}
	public final void setDisplayInformation(final ProductSpecDisplay displayInformation) {
		this.displayInformation = displayInformation;
	}
	public final ProductSpecContainment getProductSpecContainment() {
		return productSpecContainment;
	}
	public final void setProductSpecContainment(final 
			ProductSpecContainment productSpecContainment) {
		this.productSpecContainment = productSpecContainment;
	}
	public final ProductDisplay[] getDisplayableItems() {
		return displayableItems;
	}
	public final void setDisplayableItems(final ProductDisplay[] displayableItems) {
		this.displayableItems = displayableItems;
	}
	public final ProductSpecDisplay getOriginalCatalogDisplayInformation() {
		return originalCatalogDisplayInformation;
	}
	public final void setOriginalCatalogDisplayInformation(final 
			ProductSpecDisplay originalCatalogDisplayInformation) {
		this.originalCatalogDisplayInformation = originalCatalogDisplayInformation;
	}
	public final TotalRecurringCalculatedPrice getTotalRecurringCalculatedPrice() {
		return totalRecurringCalculatedPrice;
	}
	public final void setTotalRecurringCalculatedPrice(final 
			TotalRecurringCalculatedPrice totalRecurringCalculatedPrice) {
		this.totalRecurringCalculatedPrice = totalRecurringCalculatedPrice;
	}
	public AllowedAction[] getAllowedActions() {
		return allowedActions;
	}
	public void setAllowedActions(final AllowedAction[] allowedActions) {
		this.allowedActions = allowedActions;
	}
	public SimpleProductReferenceDisplay[] getDisplayableSimpleProductReferences() {
		return displayableSimpleProductReferences;
	}
	public void setDisplayableSimpleProductReferences(final 
			SimpleProductReferenceDisplay[] displayableSimpleProductReferences) {
		this.displayableSimpleProductReferences = displayableSimpleProductReferences;
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
	public final TotalDepositCalculationResult getTotalDeposit() {
		return totalDeposit;
	}
	public final void setTotalDeposit(final TotalDepositCalculationResult totalDeposit) {
		this.totalDeposit = totalDeposit;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public boolean isMain() {
		return main;
	}
	public void setMain(final boolean main) {
		this.main = main;
	}
	public boolean isSaleable() {
		return saleable;
	}
	public void setSaleable(final boolean saleable) {
		this.saleable = saleable;
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
	public final String getParentTemporaryID() {
		return parentTemporaryID;
	}
	public final void setParentTemporaryID(final String parentTemporaryID) {
		this.parentTemporaryID = parentTemporaryID;
	}
}
