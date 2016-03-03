package mx.com.att.vo.amdocs;

public class ProductSpecDisplay {
	private LinkVO[]	link;
	private FlexAttr[]	dynamicProperties;
	private Boolean	enabled;
	private Boolean	mandatory;
	private Boolean	showStructure;
	private Boolean	visible;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final FlexAttr[] getDynamicProperties() {
		return dynamicProperties;
	}
	public final void setDynamicProperties(final FlexAttr[] dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	public final Boolean getEnabled() {
		return enabled;
	}
	public final void setEnabled(final Boolean enabled) {
		this.enabled = enabled;
	}
	public final Boolean getMandatory() {
		return mandatory;
	}
	public final void setMandatory(final Boolean mandatory) {
		this.mandatory = mandatory;
	}
	public final Boolean getShowStructure() {
		return showStructure;
	}
	public final void setShowStructure(final Boolean showStructure) {
		this.showStructure = showStructure;
	}
	public final Boolean getVisible() {
		return visible;
	}
	public final void setVisible(final Boolean visible) {
		this.visible = visible;
	}

}
