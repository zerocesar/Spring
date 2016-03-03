package mx.com.att.vo.amdocs;

public class PricheSchemaDisplay {
	
	private LinkVO[] Link;
	public boolean enabled;
	public boolean visible;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(final boolean visible) {
		this.visible = visible;
	}
}
