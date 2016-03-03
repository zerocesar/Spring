package mx.com.att.vo.amdocs;

public class AllowedAction {
	private LinkVO[] link;
	private Boolean allowed;
//	private ProductConfigurationActionType type;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final Boolean getAllowed() {
		return allowed;
	}
	public final void setAllowed(final Boolean allowed) {
		this.allowed = allowed;
	}
}
