package mx.com.att.vo.amdocs;

import java.math.BigDecimal;

public class RecurringCalculatedPrice {
	private LinkVO[]	link;
	private String	currency;
	private String	description;
	private BigDecimal	discountAmount;
	private BigDecimal	discountPercentage;
	private BigDecimal	finalAmount;
	private BigDecimal	finalTaxAmount;
	private String	name;
	private BigDecimal	originalAmount;
	private BigDecimal	originalTaxAmount;	
	private BigDecimal	overrideAmount;
	private String	allowedOverrideType;
//	private OverrideReason	overrideReason;
	private String	overrideReasonFreeText;
	private BigDecimal	proratedAmount;
	private BigDecimal	proratedDiscountAmount;
	private BigDecimal	proratedTaxAmount;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getCurrency() {
		return currency;
	}
	public final void setCurrency(final String currency) {
		this.currency = currency;
	}
	public final String getDescription() {
		return description;
	}
	public final void setDescription(final String description) {
		this.description = description;
	}
	public final BigDecimal getDiscountAmount() {
		return discountAmount;
	}
	public final void setDiscountAmount(final BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public final BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}
	public final void setDiscountPercentage(final BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public final BigDecimal getFinalAmount() {
		return finalAmount;
	}
	public final void setFinalAmount(final BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}
	public final BigDecimal getFinalTaxAmount() {
		return finalTaxAmount;
	}
	public final void setFinalTaxAmount(final BigDecimal finalTaxAmount) {
		this.finalTaxAmount = finalTaxAmount;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public final BigDecimal getOriginalAmount() {
		return originalAmount;
	}
	public final void setOriginalAmount(final BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}
	public final BigDecimal getOriginalTaxAmount() {
		return originalTaxAmount;
	}
	public final void setOriginalTaxAmount(final BigDecimal originalTaxAmount) {
		this.originalTaxAmount = originalTaxAmount;
	}
	public final BigDecimal getOverrideAmount() {
		return overrideAmount;
	}
	public final void setOverrideAmount(final BigDecimal overrideAmount) {
		this.overrideAmount = overrideAmount;
	}
	public final String getAllowedOverrideType() {
		return allowedOverrideType;
	}
	public final void setAllowedOverrideType(final String allowedOverrideType) {
		this.allowedOverrideType = allowedOverrideType;
	}
	public final String getOverrideReasonFreeText() {
		return overrideReasonFreeText;
	}
	public final void setOverrideReasonFreeText(final String overrideReasonFreeText) {
		this.overrideReasonFreeText = overrideReasonFreeText;
	}
	public final BigDecimal getProratedAmount() {
		return proratedAmount;
	}
	public final void setProratedAmount(final BigDecimal proratedAmount) {
		this.proratedAmount = proratedAmount;
	}
	public final BigDecimal getProratedDiscountAmount() {
		return proratedDiscountAmount;
	}
	public final void setProratedDiscountAmount(final BigDecimal proratedDiscountAmount) {
		this.proratedDiscountAmount = proratedDiscountAmount;
	}
	public final BigDecimal getProratedTaxAmount() {
		return proratedTaxAmount;
	}
	public final void setProratedTaxAmount(final BigDecimal proratedTaxAmount) {
		this.proratedTaxAmount = proratedTaxAmount;
	}

}
