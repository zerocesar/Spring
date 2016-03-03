package mx.com.att.vo.amdocs;

public class AttachmentTypes {
	private LinkVO[] link;
	private String purpose;
	private String type;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getPurpose() {
		return purpose;
	}
	public final void setPurpose(final String purpose) {
		this.purpose = purpose;
	}
	public final String getType() {
		return type;
	}
	public final void setType(final String type) {
		this.type = type;
	}
}
