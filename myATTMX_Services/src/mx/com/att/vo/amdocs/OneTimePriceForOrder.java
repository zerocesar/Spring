package mx.com.att.vo.amdocs;

import java.math.BigDecimal;

public class OneTimePriceForOrder {
	private LinkVO[] link;
	private String description;
	private String currency;
	private BigDecimal discountPercentage;
	private BigDecimal finalAmount;
	private BigDecimal finalTaxAmount;
	private BigDecimal originalAmount;
	private BigDecimal originalTaxAmount;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getDescription() {
		return description;
	}
	public final void setDescription(final String description) {
		this.description = description;
	}
	public final String getCurrency() {
		return currency;
	}
	public final void setCurrency(final String currency) {
		this.currency = currency;
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
