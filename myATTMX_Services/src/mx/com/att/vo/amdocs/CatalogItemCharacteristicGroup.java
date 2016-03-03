package mx.com.att.vo.amdocs;

public class CatalogItemCharacteristicGroup {
	private LinkVO[] link;
	private CatalogItemCharacteristic[] characteristics;
	private String name;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final CatalogItemCharacteristic[] getCharacteristics() {
		return characteristics;
	}
	public final void setCharacteristics(final CatalogItemCharacteristic[] characteristics) {
		this.characteristics = characteristics;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
}
