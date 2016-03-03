package mx.com.att.vo.amdocs;

public class CharacteristicValue {
	private LinkVO[]	link;
	private String	value;
	private String	valueForDisplay;
	private String	valueTo;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getValue() {
		return value;
	}
	public final void setValue(final String value) {
		this.value = value;
	}
	public final String getValueForDisplay() {
		return valueForDisplay;
	}
	public final void setValueForDisplay(final String valueForDisplay) {
		this.valueForDisplay = valueForDisplay;
	}
	public final String getValueTo() {
		return valueTo;
	}
	public final void setValueTo(final String valueTo) {
		this.valueTo = valueTo;
	}

}
