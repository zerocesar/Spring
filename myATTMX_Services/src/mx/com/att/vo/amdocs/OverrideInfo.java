package mx.com.att.vo.amdocs;

import java.math.BigDecimal;

public class OverrideInfo {
	public BigDecimal overrideAmount;
	private String allowedOverrideType;
	private String overrideReasonFreeText;
//	private OverrideAmountType overrideAmountType;
//	private OverrideReason overrideReason;
	
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
}
