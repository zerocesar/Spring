package mx.com.att.vo.amdocs;

public class CatalogItemCharacteristic {
	private LinkVO[] link;
	private FlexAttr[] additionalProperties;
	private String name;
//	private CharacteristicValueRestrictionType[] valueRestiction;
//	private CharacteristicValueBasicType[] valueType;
	private CatalogItemCharacteristicValue[] values;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final FlexAttr[] getAdditionalProperties() {
		return additionalProperties;
	}
	public final void setAdditionalProperties(final FlexAttr[] additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public final CatalogItemCharacteristicValue[] getValues() {
		return values;
	}
	public void setValues(final CatalogItemCharacteristicValue[] values) {
		this.values = values;
	}
	
}
