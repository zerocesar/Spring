package mx.com.att.vo.amdocs;

public class ProductSpecContainment {
	private LinkVO[]	Link;
	private Integer	defaultQuantity;
	private FlexAttr[]	dynamicProperties;
	private Integer	maximumQuantity;
	private Integer	minimumQuantity;
	private ProductSpecification	containedProduct;
	
	public final LinkVO[] getLink() {
		return Link;
	}
	public final void setLink(final LinkVO[] link) {
		Link = link;
	}
	public final Integer getDefaultQuantity() {
		return defaultQuantity;
	}
	public final void setDefaultQuantity(final Integer defaultQuantity) {
		this.defaultQuantity = defaultQuantity;
	}
	public final FlexAttr[] getDynamicProperties() {
		return dynamicProperties;
	}
	public final void setDynamicProperties(final FlexAttr[] dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	public final Integer getMaximumQuantity() {
		return maximumQuantity;
	}
	public final void setMaximumQuantity(final Integer maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}
	public final Integer getMinimumQuantity() {
		return minimumQuantity;
	}
	public final void setMinimumQuantity(final Integer minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}
	public final ProductSpecification getContainedProduct() {
		return containedProduct;
	}
	public final void setContainedProduct(final ProductSpecification containedProduct) {
		this.containedProduct = containedProduct;
	}

}
