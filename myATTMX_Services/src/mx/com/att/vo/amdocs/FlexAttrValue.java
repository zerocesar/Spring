package mx.com.att.vo.amdocs;

import java.math.BigDecimal;
import java.util.Date;

public class FlexAttrValue {
	private BigDecimal decimalValue;
	private Integer integerValue;
	private Boolean booleanValue;
	private String stringValue;	
	private Date dateValue;
//	private FlexAttrValueType valueType;
	public final BigDecimal getDecimalValue() {
		return decimalValue;
	}
	public final void setDecimalValue(final BigDecimal decimalValue) {
		this.decimalValue = decimalValue;
	}
	public final Integer getIntegerValue() {
		return integerValue;
	}
	public final void setIntegerValue(final Integer integerValue) {
		this.integerValue = integerValue;
	}
	public final Boolean getBooleanValue() {
		return booleanValue;
	}
	public final void setBooleanValue(final Boolean booleanValue) {
		this.booleanValue = booleanValue;
	}
	public final String getStringValue() {
		return stringValue;
	}
	public final void setStringValue(final String stringValue) {
		this.stringValue = stringValue;
	}
	public final Date getDateValue() {
		return dateValue;
	}
	public final void setDateValue(final Date dateValue) {
		this.dateValue = dateValue;
	}
}
