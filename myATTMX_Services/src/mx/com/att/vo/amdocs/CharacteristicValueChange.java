package mx.com.att.vo.amdocs;

public class CharacteristicValueChange {
	private LinkVO[] link;
	private String characteristicID;
	private String value;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getCharacteristicID() {
		return characteristicID;
	}
	public final void setCharacteristicID(final String characteristicID) {
		this.characteristicID = characteristicID;
	}
	public final String getValue() {
		return value;
	}
	public final void setValue(final String value) {
		this.value = value;
	}
}
