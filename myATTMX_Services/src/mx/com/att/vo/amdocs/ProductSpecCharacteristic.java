package mx.com.att.vo.amdocs;

public class ProductSpecCharacteristic {
	private LinkVO[]	link;
	private String	code;
	private String	description;
//	private CharacteristicDisplayFormat	displayFormat;
	private FlexAttr[]	dynamicProperties;
	private boolean	enabled;
	private String	id;
//	private Integer	dynamicProperties;
	private boolean	mandatory;
	private String	mask;
	private String	name;
	private Integer	numberOfLines;
	private boolean	showHelpText;
//	private CharacteristicValueBasicType	valueBasicType;
//	private CharacteristicValueRestrictionType	valueRestriction;
	private boolean	visible;
	private CharacteristicValue	charactdefaultValue;
	private CharacteristicValue[]	values;
	private ProductSpecCharacteristic[]	characteristics;
	private CharacteristicActionDisplay	actionDisplay;
	
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
	public final String getDescription() {
		return description;
	}
	public final void setDescription(final String description) {
		this.description = description;
	}
	public final FlexAttr[] getDynamicProperties() {
		return dynamicProperties;
	}
	public final void setDynamicProperties(final FlexAttr[] dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}
	public final String getId() {
		return id;
	}
	public final void setId(final String id) {
		this.id = id;
	}
	public boolean isMandatory() {
		return mandatory;
	}
	public void setMandatory(final boolean mandatory) {
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
	public boolean isShowHelpText() {
		return showHelpText;
	}
	public void setShowHelpText(final boolean showHelpText) {
		this.showHelpText = showHelpText;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(final boolean visible) {
		this.visible = visible;
	}
	public CharacteristicValue getCharactdefaultValue() {
		return charactdefaultValue;
	}
	public void setCharactdefaultValue(final CharacteristicValue charactdefaultValue) {
		this.charactdefaultValue = charactdefaultValue;
	}
	public final CharacteristicValue[] getValues() {
		return values;
	}
	public final void setValues(final CharacteristicValue[] values) {
		this.values = values;
	}
	public ProductSpecCharacteristic[] getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(final ProductSpecCharacteristic[] characteristics) {
		this.characteristics = characteristics;
	}
	public final CharacteristicActionDisplay getActionDisplay() {
		return actionDisplay;
	}
	public final void setActionDisplay(final CharacteristicActionDisplay actionDisplay) {
		this.actionDisplay = actionDisplay;
	}

}
