package mx.com.att.vo.amdocs;

public class PriceSchemaDisplay {
	private LinkVO[] link;
	private Boolean enabled;
	private Boolean visible;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(LinkVO[] link) {
		this.link = link;
	}
	public final Boolean getEnabled() {
		return enabled;
	}
	public final void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public final Boolean getVisible() {
		return visible;
	}
	public final void setVisible(Boolean visible) {
		this.visible = visible;
	}
}
