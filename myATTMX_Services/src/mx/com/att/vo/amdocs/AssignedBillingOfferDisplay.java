package mx.com.att.vo.amdocs;

public class AssignedBillingOfferDisplay {
	private LinkVO[] link;
//	private ProductConfigurationActionType action;
	private String billingOfferID;
	private boolean crossProductDiscount;
	private boolean penalty;
	private String crossProductDiscountRuleDescription;
	private String productSpecPricingID;
	private String selected;
//	private ProductActivationStatus status;
	private ProductSpecPricing productSpecPricing;
	private RuleExecutionMessage[] messages;
	private TotalOneTimeCalculatedPrice totalRecurringCalculatedPrice;
	private OneTimeCalculatedPrice[] oneTimeCalculatedPrices;
	private AllowedAction[] allowedActions;
	private PricheSchemaDisplay displayInformation;
	private RecurringCalculatedPrice[] recurringCalculatedPrices;
	private String name;
	private boolean saleable;
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
	public boolean isCrossProductDiscount() {
		return crossProductDiscount;
	}
	public void setCrossProductDiscount(final boolean crossProductDiscount) {
		this.crossProductDiscount = crossProductDiscount;
	}
	public boolean isPenalty() {
		return penalty;
	}
	public void setPenalty(final boolean penalty) {
		this.penalty = penalty;
	}
	public final String getCrossProductDiscountRuleDescription() {
		return crossProductDiscountRuleDescription;
	}
	public final void setCrossProductDiscountRuleDescription(final 
			String crossProductDiscountRuleDescription) {
		this.crossProductDiscountRuleDescription = crossProductDiscountRuleDescription;
	}
	public final String getProductSpecPricingID() {
		return productSpecPricingID;
	}
	public final void setProductSpecPricingID(final String productSpecPricingID) {
		this.productSpecPricingID = productSpecPricingID;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(final String selected) {
		this.selected = selected;
	}
	public final ProductSpecPricing getProductSpecPricing() {
		return productSpecPricing;
	}
	public final void setProductSpecPricing(final ProductSpecPricing productSpecPricing) {
		this.productSpecPricing = productSpecPricing;
	}
	public final RuleExecutionMessage[] getMessages() {
		return messages;
	}
	public final void setMessages(final RuleExecutionMessage[] messages) {
		this.messages = messages;
	}
	public final OneTimeCalculatedPrice[] getOneTimeCalculatedPrices() {
		return oneTimeCalculatedPrices;
	}
	public final void setOneTimeCalculatedPrices(final 
			OneTimeCalculatedPrice[] oneTimeCalculatedPrices) {
		this.oneTimeCalculatedPrices = oneTimeCalculatedPrices;
	}
	public final AllowedAction[] getAllowedActions() {
		return allowedActions;
	}
	public final void setAllowedActions(final AllowedAction[] allowedActions) {
		this.allowedActions = allowedActions;
	}
	public final RecurringCalculatedPrice[] getRecurringCalculatedPrices() {
		return recurringCalculatedPrices;
	}
	public final void setRecurringCalculatedPrices(final 
			RecurringCalculatedPrice[] recurringCalculatedPrices) {
		this.recurringCalculatedPrices = recurringCalculatedPrices;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public boolean isSaleable() {
		return saleable;
	}
	public void setSaleable(final boolean saleable) {
		this.saleable = saleable;
	}
	public final TotalOneTimeCalculatedPrice getTotalRecurringCalculatedPrice() {
		return totalRecurringCalculatedPrice;
	}
	public final void setTotalRecurringCalculatedPrice(
			TotalOneTimeCalculatedPrice totalRecurringCalculatedPrice) {
		this.totalRecurringCalculatedPrice = totalRecurringCalculatedPrice;
	}
	public final PricheSchemaDisplay getDisplayInformation() {
		return displayInformation;
	}
	public final void setDisplayInformation(PricheSchemaDisplay displayInformation) {
		this.displayInformation = displayInformation;
	}
}
