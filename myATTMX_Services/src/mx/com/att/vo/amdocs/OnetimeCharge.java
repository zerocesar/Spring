package mx.com.att.vo.amdocs;

import java.math.BigDecimal;

public class OnetimeCharge {
	private LinkVO[] link;
	private BigDecimal amount;
	private BigDecimal amountAfterDiscount;
	private BigDecimal currency;
	private BigDecimal discountAmount;
	private BigDecimal discountPercentage;
	private BigDecimal max;
	private BigDecimal min;
	private BigDecimal originalAmount;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(LinkVO[] link) {
		this.link = link;
	}
	public final BigDecimal getAmount() {
		return amount;
	}
	public final void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public final BigDecimal getAmountAfterDiscount() {
		return amountAfterDiscount;
	}
	public final void setAmountAfterDiscount(BigDecimal amountAfterDiscount) {
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
	public final void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public final BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}
	public final void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public final BigDecimal getMax() {
		return max;
	}
	public final void setMax(BigDecimal max) {
		this.max = max;
	}
	public final BigDecimal getMin() {
		return min;
	}
	public final void setMin(BigDecimal min) {
		this.min = min;
	}
	public final BigDecimal getOriginalAmount() {
		return originalAmount;
	}
	public final void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}
}
