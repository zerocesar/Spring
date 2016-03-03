package mx.com.att.vo.amdocs;

public class Option {
	private LinkVO[]	link;
	private String	code;
	private String	value;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getCode() {
		return code;
	}
	public final void setCode(final String code) {
		this.code = code;
	}
	public final String getValue() {
		return value;
	}
	public final void setValue(final String value) {
		this.value = value;
	}

}
