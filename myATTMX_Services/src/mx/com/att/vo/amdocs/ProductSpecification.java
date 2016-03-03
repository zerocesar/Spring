package mx.com.att.vo.amdocs;

public class ProductSpecification {
	private LinkVO[]	link;
	private String	code;
	private String	description;
	private String	lob;
	private String	name;
	private String	id;
	private String	lobImage;
	private FlexAttr[]	dynamicProperties;
	private String	lobName;
	private Integer	maximumQuantity;
	private String	type;
	private Integer	minimumQuantity;
	private String	offeringToProductId;
	private String	level;
	private Boolean	sharedProduct;
	private RecurringCharge	recurringPrice;
	private OnetimeCharge	oneTimePrice;
	private Attachment[]	attachments;
	private ProductSpecCharacteristic[]	characteristics;
	private PricheSchema	plan;
	private CatalogItemCharacteristicGroup	detailsGroups;
	private String	SKU;
	private ProductSpecificationBusinessType	businessType;
	private String	productOfferingID;
	private String	productOfferingProductSpecID;
	
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
	public final String getLob() {
		return lob;
	}
	public final void setLob(final String lob) {
		this.lob = lob;
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
	public final String getLobImage() {
		return lobImage;
	}
	public final void setLobImage(final String lobImage) {
		this.lobImage = lobImage;
	}
	public final FlexAttr[] getDynamicProperties() {
		return dynamicProperties;
	}
	public final void setDynamicProperties(final FlexAttr[] dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	public final String getLobName() {
		return lobName;
	}
	public final void setLobName(final String lobName) {
		this.lobName = lobName;
	}
	public final Integer getMaximumQuantity() {
		return maximumQuantity;
	}
	public final void setMaximumQuantity(final Integer maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}
	public final String getType() {
		return type;
	}
	public final void setType(final String type) {
		this.type = type;
	}
	public final Integer getMinimumQuantity() {
		return minimumQuantity;
	}
	public final void setMinimumQuantity(final Integer minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}
	public final String getOfferingToProductId() {
		return offeringToProductId;
	}
	public final void setOfferingToProductId(final String offeringToProductId) {
		this.offeringToProductId = offeringToProductId;
	}
	public final String getLevel() {
		return level;
	}
	public final void setLevel(final String level) {
		this.level = level;
	}
	public final Boolean getSharedProduct() {
		return sharedProduct;
	}
	public final void setSharedProduct(final Boolean sharedProduct) {
		this.sharedProduct = sharedProduct;
	}
	public final RecurringCharge getRecurringPrice() {
		return recurringPrice;
	}
	public final void setRecurringPrice(final RecurringCharge recurringPrice) {
		this.recurringPrice = recurringPrice;
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
	public final void setAttachments(final Attachment[] attachments) {
		this.attachments = attachments;
	}
	public final ProductSpecCharacteristic[] getCharacteristics() {
		return characteristics;
	}
	public final void setCharacteristics(final ProductSpecCharacteristic[] characteristics) {
		this.characteristics = characteristics;
	}
	public final PricheSchema getPlan() {
		return plan;
	}
	public final void setPlan(final PricheSchema plan) {
		this.plan = plan;
	}
	public final CatalogItemCharacteristicGroup getDetailsGroups() {
		return detailsGroups;
	}
	public final void setDetailsGroups(final CatalogItemCharacteristicGroup detailsGroups) {
		this.detailsGroups = detailsGroups;
	}
	public final String getSKU() {
		return SKU;
	}
	public final void setSKU(final String sKU) {
		SKU = sKU;
	}
	public final ProductSpecificationBusinessType getBusinessType() {
		return businessType;
	}
	public final void setBusinessType(final ProductSpecificationBusinessType businessType) {
		this.businessType = businessType;
	}
	public final String getProductOfferingID() {
		return productOfferingID;
	}
	public final void setProductOfferingID(final String productOfferingID) {
		this.productOfferingID = productOfferingID;
	}
	public final String getProductOfferingProductSpecID() {
		return productOfferingProductSpecID;
	}
	public final void setProductOfferingProductSpecID(final 
			String productOfferingProductSpecID) {
		this.productOfferingProductSpecID = productOfferingProductSpecID;
	}

}
