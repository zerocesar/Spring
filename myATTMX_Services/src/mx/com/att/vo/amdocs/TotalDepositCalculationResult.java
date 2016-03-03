package mx.com.att.vo.amdocs;

import java.io.Serializable;
import java.math.BigDecimal;

public class TotalDepositCalculationResult implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public LinkVO[] Link;
	public String currency;
	public String description;
	public BigDecimal discountAmount;
	public BigDecimal discountPercentage;
	public BigDecimal finalAmount;
	public BigDecimal finalTaxAmount;
	public String name;
	public BigDecimal originalAmount;
	public BigDecimal originalTaxAmount;
	//public BigDecimal finalTaxAmount;
	public BigDecimal overrideAmount;
	public String allowedOverrideType;
	//public OverrideReason overrideReason;
	public String overrideReasonFreeText;
	public BigDecimal proratedAmount;
	public BigDecimal proratedDiscountAmount;
	public BigDecimal proratedTaxAmount;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		this.Link = link;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(final String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(final BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(final BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public BigDecimal getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(final BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}
	public BigDecimal getFinalTaxAmount() {
		return finalTaxAmount;
	}
	public void setFinalTaxAmount(final BigDecimal finalTaxAmount) {
		this.finalTaxAmount = finalTaxAmount;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}
	public void setOriginalAmount(final BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}
	public BigDecimal getOriginalTaxAmount() {
		return originalTaxAmount;
	}
	public void setOriginalTaxAmount(final BigDecimal originalTaxAmount) {
		this.originalTaxAmount = originalTaxAmount;
	}
	public BigDecimal getOverrideAmount() {
		return overrideAmount;
	}
	public void setOverrideAmount(final BigDecimal overrideAmount) {
		this.overrideAmount = overrideAmount;
	}
	public String getAllowedOverrideType() {
		return allowedOverrideType;
	}
	public void setAllowedOverrideType(final String allowedOverrideType) {
		this.allowedOverrideType = allowedOverrideType;
	}
	/*
	public OverrideReason getOverrideReason() {
		return overrideReason;
	}
	public void setOverrideReason(final OverrideReason overrideReason) {
		this.overrideReason = overrideReason;
	}
	*/
	public String getOverrideReasonFreeText() {
		return overrideReasonFreeText;
	}
	public void setOverrideReasonFreeText(final String overrideReasonFreeText) {
		this.overrideReasonFreeText = overrideReasonFreeText;
	}
	public BigDecimal getProratedAmount() {
		return proratedAmount;
	}
	public void setProratedAmount(final BigDecimal proratedAmount) {
		this.proratedAmount = proratedAmount;
	}
	public BigDecimal getProratedDiscountAmount() {
		return proratedDiscountAmount;
	}
	public void setProratedDiscountAmount(final BigDecimal proratedDiscountAmount) {
		this.proratedDiscountAmount = proratedDiscountAmount;
	}
	public BigDecimal getProratedTaxAmount() {
		return proratedTaxAmount;
	}
	public void setProratedTaxAmount(final BigDecimal proratedTaxAmount) {
		this.proratedTaxAmount = proratedTaxAmount;
	}

	
	
	
}
