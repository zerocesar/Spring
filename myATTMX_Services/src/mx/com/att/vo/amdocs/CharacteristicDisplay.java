package mx.com.att.vo.amdocs;

public class CharacteristicDisplay {
	private LinkVO[]	link;
//	private CharacteristicDisplayFormat	displayFormat;
	private FlexAttr[]	dynamicProperties;
	private Boolean	enabled;
	private Boolean	mandatory;
	private String	mask;
	private String	name;
	private Integer	numberOfLines;
	private Boolean	showHelpText;
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
	public final String getMask() {
		return mask;
	}
	public final void setMask(final String mask) {
		this.mask = mask;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public final Integer getNumberOfLines() {
		return numberOfLines;
	}
	public final void setNumberOfLines(final Integer numberOfLines) {
		this.numberOfLines = numberOfLines;
	}
	public final Boolean getShowHelpText() {
		return showHelpText;
	}
	public final void setShowHelpText(final Boolean showHelpText) {
		this.showHelpText = showHelpText;
	}
	public final Boolean getVisible() {
		return visible;
	}
	public final void setVisible(final Boolean visible) {
		this.visible = visible;
	}

}
