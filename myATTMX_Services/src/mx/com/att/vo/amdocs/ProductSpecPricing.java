package mx.com.att.vo.amdocs;

public class ProductSpecPricing {
	private LinkVO[] link;
	private FlexAttr[] dynamicProperties;
	private String id;
//	private InclusionType includeByDefault;
	private PricheSchema childPricingSchema;
	
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
	public final String getId() {
		return id;
	}
	public final void setId(final String id) {
		this.id = id;
	}
	public final PricheSchema getChildPricingSchema() {
		return childPricingSchema;
	}
	public void setChildPricingSchema(final PricheSchema childPricingSchema) {
		this.childPricingSchema = childPricingSchema;
	}
}
