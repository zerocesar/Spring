package mx.com.att.vo.amdocs;

import java.math.BigDecimal;

public class RecurringPriceForOrder {
	private LinkVO[] link;
	private String frequency;
	private BigDecimal proratedAmount;
	private BigDecimal proratedDiscountAmount;
	private BigDecimal proratedTaxAmount;
	private BigDecimal currency;
	private BigDecimal discountPercentage;
	private BigDecimal finalAmountWithTax;
	private BigDecimal finalTaxAmount;
	private BigDecimal originalAmount;
	private BigDecimal originalTaxAmount;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getFrequency() {
		return frequency;
	}
	public final void setFrequency(final String frequency) {
		this.frequency = frequency;
	}
	public BigDecimal getProratedAmount() {
		return proratedAmount;
	}
	public void setProratedAmount(final BigDecimal proratedAmount) {
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
	public final BigDecimal getCurrency() {
		return currency;
	}
	public final void setCurrency(final BigDecimal currency) {
		this.currency = currency;
	}
	public final BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}
	public final void setDiscountPercentage(final BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public final BigDecimal getFinalAmountWithTax() {
		return finalAmountWithTax;
	}
	public final void setFinalAmountWithTax(final BigDecimal finalAmountWithTax) {
		this.finalAmountWithTax = finalAmountWithTax;
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
	
}
