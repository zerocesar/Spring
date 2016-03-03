package mx.com.att.vo.amdocs;

public class TopLevelProductConfiguration {
	private LinkVO[] link;
//	private CompatibilityStatus compatibilityStatus;
	private String temporaryID;
	private String effectiveCatalogVersion;
	private String lineOfBusiness;
	private String productID;
//	private QuoteStatus  quoteStatus;
	private String serviceID;
	private String rootProductOfferingID;
	private String rootProductOfferingProductSpecID;
	private RuleExecutionMessage[] messages;
	private TotalOneTimeCalculatedPrice totalOneTimeCalculatedPrice;
	private ConfigurationStepDisplay[] steps;
	private ProductSpecification productSpecification;
	private SimpleProductReferenceDisplay[] displayableSimpleProductReferences;
	private ProductDisplay[] displayableItems;
	private ActivityChargeDisplay displayableActivityCharge;
	private TotalRecurringCalculatedPrice totalRecurringCalculatedPrice;
	private ProductOffering productOffering;
	private Boolean mandatoryConfigRequired;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getTemporaryID() {
		return temporaryID;
	}
	public final void setTemporaryID(final String temporaryID) {
		this.temporaryID = temporaryID;
	}
	public final String getEffectiveCatalogVersion() {
		return effectiveCatalogVersion;
	}
	public final void setEffectiveCatalogVersion(final String effectiveCatalogVersion) {
		this.effectiveCatalogVersion = effectiveCatalogVersion;
	}
	public final String getLineOfBusiness() {
		return lineOfBusiness;
	}
	public final void setLineOfBusiness(final String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(final String productID) {
		this.productID = productID;
	}
	/*
	public QuoteStatus getQuoteStatus() {
		return quoteStatus;
	}
	public void setQuoteStatus(final QuoteStatus quoteStatus) {
		this.quoteStatus = quoteStatus;
	}
	*/
	public String getServiceID() {
		return serviceID;
	}
	public final void setServiceID(final String serviceID) {
		this.serviceID = serviceID;
	}
	public final String getRootProductOfferingID() {
		return rootProductOfferingID;
	}
	public final void setRootProductOfferingID(final String rootProductOfferingID) {
		this.rootProductOfferingID = rootProductOfferingID;
	}
	public final String getRootProductOfferingProductSpecID() {
		return rootProductOfferingProductSpecID;
	}
	public final void setRootProductOfferingProductSpecID(final 
			String rootProductOfferingProductSpecID) {
		this.rootProductOfferingProductSpecID = rootProductOfferingProductSpecID;
	}
	public final RuleExecutionMessage[] getMessages() {
		return messages;
	}
	public final void setMessages(final RuleExecutionMessage[] messages) {
		this.messages = messages;
	}
	public final TotalOneTimeCalculatedPrice getTotalOneTimeCalculatedPrice() {
		return totalOneTimeCalculatedPrice;
	}
	public final void setTotalOneTimeCalculatedPrice(final 
			TotalOneTimeCalculatedPrice totalOneTimeCalculatedPrice) {
		this.totalOneTimeCalculatedPrice = totalOneTimeCalculatedPrice;
	}
	public final ConfigurationStepDisplay[] getSteps() {
		return steps;
	}
	public final void setSteps(final ConfigurationStepDisplay[] steps) {
		this.steps = steps;
	}
	public final ProductSpecification getProductSpecification() {
		return productSpecification;
	}
	public final void setProductSpecification(final 
			ProductSpecification productSpecification) {
		this.productSpecification = productSpecification;
	}
	public final SimpleProductReferenceDisplay[] getDisplayableSimpleProductReferences() {
		return displayableSimpleProductReferences;
	}
	public final void setDisplayableSimpleProductReferences(final 
			SimpleProductReferenceDisplay[] displayableSimpleProductReferences) {
		this.displayableSimpleProductReferences = displayableSimpleProductReferences;
	}
	public final ProductDisplay[] getDisplayableItems() {
		return displayableItems;
	}
	public final void setDisplayableItems(final ProductDisplay[] displayableItems) {
		this.displayableItems = displayableItems;
	}
	public final ActivityChargeDisplay getDisplayableActivityCharge() {
		return displayableActivityCharge;
	}
	public final void setDisplayableActivityCharge(final 
			ActivityChargeDisplay displayableActivityCharge) {
		this.displayableActivityCharge = displayableActivityCharge;
	}
	public final TotalRecurringCalculatedPrice getTotalRecurringCalculatedPrice() {
		return totalRecurringCalculatedPrice;
	}
	public final void setTotalRecurringCalculatedPrice(final 
			TotalRecurringCalculatedPrice totalRecurringCalculatedPrice) {
		this.totalRecurringCalculatedPrice = totalRecurringCalculatedPrice;
	}
	public final ProductOffering getProductOffering() {
		return productOffering;
	}
	public final void setProductOffering(final ProductOffering productOffering) {
		this.productOffering = productOffering;
	}
	public final Boolean getMandatoryConfigRequired() {
		return mandatoryConfigRequired;
	}
	public final void setMandatoryConfigRequired(final Boolean mandatoryConfigRequired) {
		this.mandatoryConfigRequired = mandatoryConfigRequired;
	}
}
