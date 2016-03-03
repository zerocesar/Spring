package mx.com.att.vo.amdocs;

public class CatalogItmeCharacteristicValue {
	private LinkVO[] link;
	private String value;
	private String valueTo;
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
	public final String getValueTo() {
		return valueTo;
	}
	public final void setValueTo(final String valueTo) {
		this.valueTo = valueTo;
	}
}
