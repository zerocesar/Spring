package mx.com.att.vo.amdocs;

import java.math.BigDecimal;

public class RecurringCharge {
	private LinkVO[] link;
	private BigDecimal amount;
	private BigDecimal amountAfterDiscount;
	private BigDecimal currency;
	private BigDecimal discountAmount;
	private BigDecimal discountPercentage;
	private BigDecimal max;
	private BigDecimal min;
	private BigDecimal originalAmount;
	private Integer chargeFrequencyFactor;
	private BigDecimal chargeFrequencyUnit;
	private BigDecimal description;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final BigDecimal getAmount() {
		return amount;
	}
	public final void setAmount(final BigDecimal amount) {
		this.amount = amount;
	}
	public final BigDecimal getAmountAfterDiscount() {
		return amountAfterDiscount;
	}
	public final void setAmountAfterDiscount(final BigDecimal amountAfterDiscount) {
		this.amountAfterDiscount = amountAfterDiscount;
	}
	public BigDecimal getCurrency() {
		return currency;
	}
	public void setCurrency(final BigDecimal currency) {
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
	public final BigDecimal getMax() {
		return max;
	}
	public final void setMax(final BigDecimal max) {
		this.max = max;
	}
	public final BigDecimal getMin() {
		return min;
	}
	public final void setMin(final BigDecimal min) {
		this.min = min;
	}
	public final BigDecimal getOriginalAmount() {
		return originalAmount;
	}
	public final void setOriginalAmount(final BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}
	public final Integer getChargeFrequencyFactor() {
		return chargeFrequencyFactor;
	}
	public final void setChargeFrequencyFactor(final Integer chargeFrequencyFactor) {
		this.chargeFrequencyFactor = chargeFrequencyFactor;
	}
	public BigDecimal getChargeFrequencyUnit() {
		return chargeFrequencyUnit;
	}
	public void setChargeFrequencyUnit(final BigDecimal chargeFrequencyUnit) {
		this.chargeFrequencyUnit = chargeFrequencyUnit;
	}
	public BigDecimal getDescription() {
		return description;
	}
	public void setDescription(final BigDecimal description) {
		this.description = description;
	}
	
	
	
	
}
