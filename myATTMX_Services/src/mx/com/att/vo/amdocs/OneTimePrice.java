package mx.com.att.vo.amdocs;

import java.math.BigDecimal;

public class OneTimePrice {
	
	
	private LinkVO[] link;
	private BigDecimal finalAmountWithTax;
	private BigDecimal finalAmount;
	private String currency;
	private BigDecimal finalTaxAmount;
	private BigDecimal originalTaxAmount;
	private BigDecimal maxAmount;
	private BigDecimal minAmount;
	private BigDecimal originalAmount;
	private String description;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public BigDecimal getFinalAmountWithTax() {
		return finalAmountWithTax;
	}
	public void setFinalAmountWithTax(BigDecimal finalAmountWithTax) {
		this.finalAmountWithTax = finalAmountWithTax;
	}
	public BigDecimal getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getFinalTaxAmount() {
		return finalTaxAmount;
	}
	public void setFinalTaxAmount(BigDecimal finalTaxAmount) {
		this.finalTaxAmount = finalTaxAmount;
	}
	public BigDecimal getOriginalTaxAmount() {
		return originalTaxAmount;
	}
	public void setOriginalTaxAmount(BigDecimal originalTaxAmount) {
		this.originalTaxAmount = originalTaxAmount;
	}
	public BigDecimal getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}
	public BigDecimal getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}
	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}
	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
