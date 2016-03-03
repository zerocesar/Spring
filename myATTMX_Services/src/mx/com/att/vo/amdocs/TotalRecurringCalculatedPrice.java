package mx.com.att.vo.amdocs;

import java.math.BigDecimal;

public class TotalRecurringCalculatedPrice {
	private LinkVO[] link;
	private BigDecimal proratedAmount;
	private BigDecimal proratedDiscountAmount;
	private BigDecimal proratedTaxAmount;
//	private SimpleFrequency recurringChargeFrequency;
	private String currency;
	private BigDecimal discountAmount;
	private BigDecimal discountPercentage;
	private BigDecimal finalAmount;
	private BigDecimal finalAmountIncludingTax;
	private BigDecimal finalTaxAmount;
	private BigDecimal originalAmount;
	private BigDecimal originalTaxAmount;
	private BigDecimal overrideAmount;
	public BigDecimal bigPicture;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
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
	public final String getCurrency() {
		return currency;
	}
	public final void setCurrency(final String currency) {
		this.currency = currency;
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
	public final BigDecimal getFinalAmountIncludingTax() {
		return finalAmountIncludingTax;
	}
	public final void setFinalAmountIncludingTax(final BigDecimal finalAmountIncludingTax) {
		this.finalAmountIncludingTax = finalAmountIncludingTax;
	}
	public final BigDecimal getFinalTaxAmount() {
		return finalTaxAmount;
	}
	public final void setFinalTaxAmount(final BigDecimal finalTaxAmount) {
		this.finalTaxAmount = finalTaxAmount;
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
	public final BigDecimal getBigPicture() {
		return bigPicture;
	}
	public final void setBigPicture(BigDecimal bigPicture) {
		this.bigPicture = bigPicture;
	}
}
