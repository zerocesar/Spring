package mx.com.att.vo.amdocs;

public class CatalogItemCharacteristicValue {
	private LinkVO[] Link;
	
	public FlexAttr[] AdditionalProperties;
	public String value;
	public String valueTo;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		this.Link = link;
	}
	public FlexAttr[] getAdditionalProperties() {
		return AdditionalProperties;
	}
	public void setAdditionalProperties(final FlexAttr[] additionalProperties) {
		AdditionalProperties = additionalProperties;
	}
	public String getValue() {
		return value;
	}
	public void setValue(final String value) {
		this.value = value;
	}
	public String getValueTo() {
		return valueTo;
	}
	public void setValueTo(final String valueTo) {
		this.valueTo = valueTo;
	}

	
	
	
}
