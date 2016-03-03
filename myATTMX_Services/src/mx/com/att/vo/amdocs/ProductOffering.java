package mx.com.att.vo.amdocs;

public class ProductOffering {
	private LinkVO[]	link;
	private boolean	bundle;
	private String	code;
	private String	description;
	private String	name;
	private String	id;
	private FlexAttr[]	dynamicProperties;
	private ProductSpecification[]	products;
	private RecurringCharge	totalRecurringCharge;
	private CustomerDiscounts[]	crossProductDiscounts;
	private CatalogItemCharacteristicGroup[]	detailsGroups;
	private OnetimeCharge	oneTimePrice;
	private Attachment[]	attachments;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public boolean isBundle() {
		return bundle;
	}
	public void setBundle(final boolean bundle) {
		this.bundle = bundle;
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
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public final String getId() {
		return id;
	}
	public final void setId(final String id) {
		this.id = id;
	}
	public final FlexAttr[] getDynamicProperties() {
		return dynamicProperties;
	}
	public final void setDynamicProperties(final FlexAttr[] dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	public final ProductSpecification[] getProducts() {
		return products;
	}
	public final void setProducts(final ProductSpecification[] products) {
		this.products = products;
	}
	public final RecurringCharge getTotalRecurringCharge() {
		return totalRecurringCharge;
	}
	public final void setTotalRecurringCharge(final RecurringCharge totalRecurringCharge) {
		this.totalRecurringCharge = totalRecurringCharge;
	}
	public final CustomerDiscounts[] getCrossProductDiscounts() {
		return crossProductDiscounts;
	}
	public final void setCrossProductDiscounts(final 
			CustomerDiscounts[] crossProductDiscounts) {
		this.crossProductDiscounts = crossProductDiscounts;
	}
	public final CatalogItemCharacteristicGroup[] getDetailsGroups() {
		return detailsGroups;
	}
	public final void setDetailsGroups(final 
			CatalogItemCharacteristicGroup[] detailsGroups) {
		this.detailsGroups = detailsGroups;
	}
	public final OnetimeCharge getOneTimePrice() {
		return oneTimePrice;
	}
	public final void setOneTimePrice(final OnetimeCharge oneTimePrice) {
		this.oneTimePrice = oneTimePrice;
	}
	public final Attachment[] getAttachments() {
		return attachments;
	}
	public final void setAttachments(Attachment[] attachments) {
		this.attachments = attachments;
	}

}
