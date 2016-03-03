package mx.com.att.vo.amdocs;

public class FilterFacet {
	private LinkVO[]	link;
	private FlexAttr[]	additionalProperties;
	private String	code;
	private String	id;
	private String[]	lob;
	private String	name;
	private FilterFacetValue[]	valueRestriction;
//	private CharacteristicValueBasicType	valueType;
	private FilterFacetValue[]	values;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public FlexAttr[] getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(final FlexAttr[] additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	public final String getCode() {
		return code;
	}
	public final void setCode(final String code) {
		this.code = code;
	}
	public final String getId() {
		return id;
	}
	public final void setId(final String id) {
		this.id = id;
	}
	public String[] getLob() {
		return lob;
	}
	public void setLob(final String[] lob) {
		this.lob = lob;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public final FilterFacetValue[] getValueRestriction() {
		return valueRestriction;
	}
	public final void setValueRestriction(final FilterFacetValue[] valueRestriction) {
		this.valueRestriction = valueRestriction;
	}
	public final FilterFacetValue[] getValues() {
		return values;
	}
	public final void setValues(final FilterFacetValue[] values) {
		this.values = values;
	}

}
