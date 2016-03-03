package mx.com.att.vo.amdocs;

public class ExternalWidgetParameters {
	private LinkVO[] link;
	private String	name;
	private String	value;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public final String getValue() {
		return value;
	}
	public final void setValue(final String value) {
		this.value = value;
	}

}
