package mx.com.att.vo.amdocs;

public class PriceSchema {
	private LinkVO[] link;
	private CatalogItemCharacteristic[] summary;
	private CatalogItemCharacteristicGroup detailsGroups;
	private FlexAttr[] dynamicProperties;
	private CatalogItemCharacteristic[] overview;
	private CustomerDiscounts[] crossProductDiscounts;
	private String planType;
	private CatalogItemCharacteristicGroup[] containingOfferDetailsGroup;
	private String marketingDescription;
	private OnetimeCharge totalOneTimeCharges;
	private Boolean changeToThisPlanAllowed;
	private RecurringCharge totalRecurringCharges;
	private String name;
	private String id;
//	private PriceSchemaType type;
	private String displayName;
	private String level;
	private String image;
	private String description;
	private String marketingDescriptionType;
	private String imageType;
	private String productOfferingType;
	private String lob;
	private String productSpecId;
	private String productSpecPricingID;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final CatalogItemCharacteristic[] getSummary() {
		return summary;
	}
	public final void setSummary(final CatalogItemCharacteristic[] summary) {
		this.summary = summary;
	}
	public final CatalogItemCharacteristicGroup getDetailsGroups() {
		return detailsGroups;
	}
	public final void setDetailsGroups(final CatalogItemCharacteristicGroup detailsGroups) {
		this.detailsGroups = detailsGroups;
	}
	public final FlexAttr[] getDynamicProperties() {
		return dynamicProperties;
	}
	public final void setDynamicProperties(final FlexAttr[] dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	public final CatalogItemCharacteristic[] getOverview() {
		return overview;
	}
	public final void setOverview(final CatalogItemCharacteristic[] overview) {
		this.overview = overview;
	}
	public final CustomerDiscounts[] getCrossProductDiscounts() {
		return crossProductDiscounts;
	}
	public final void setCrossProductDiscounts(final 
			CustomerDiscounts[] crossProductDiscounts) {
		this.crossProductDiscounts = crossProductDiscounts;
	}
	public final String getPlanType() {
		return planType;
	}
	public final void setPlanType(final String planType) {
		this.planType = planType;
	}
	public final CatalogItemCharacteristicGroup[] getContainingOfferDetailsGroup() {
		return containingOfferDetailsGroup;
	}
	public final void setContainingOfferDetailsGroup(final 
			CatalogItemCharacteristicGroup[] containingOfferDetailsGroup) {
		this.containingOfferDetailsGroup = containingOfferDetailsGroup;
	}
	public final String getMarketingDescription() {
		return marketingDescription;
	}
	public final void setMarketingDescription(final String marketingDescription) {
		this.marketingDescription = marketingDescription;
	}
	public final OnetimeCharge getTotalOneTimeCharges() {
		return totalOneTimeCharges;
	}
	public final void setTotalOneTimeCharges(final OnetimeCharge totalOneTimeCharges) {
		this.totalOneTimeCharges = totalOneTimeCharges;
	}
	public final Boolean getChangeToThisPlanAllowed() {
		return changeToThisPlanAllowed;
	}
	public final void setChangeToThisPlanAllowed(final Boolean changeToThisPlanAllowed) {
		this.changeToThisPlanAllowed = changeToThisPlanAllowed;
	}
	public final RecurringCharge getTotalRecurringCharges() {
		return totalRecurringCharges;
	}
	public final void setTotalRecurringCharges(final RecurringCharge totalRecurringCharges) {
		this.totalRecurringCharges = totalRecurringCharges;
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
	public final String getDisplayName() {
		return displayName;
	}
	public final void setDisplayName(final String displayName) {
		this.displayName = displayName;
	}
	public final String getLevel() {
		return level;
	}
	public final void setLevel(final String level) {
		this.level = level;
	}
	public final String getImage() {
		return image;
	}
	public final void setImage(final String image) {
		this.image = image;
	}
	public final String getDescription() {
		return description;
	}
	public final void setDescription(final String description) {
		this.description = description;
	}
	public final String getMarketingDescriptionType() {
		return marketingDescriptionType;
	}
	public final void setMarketingDescriptionType(final String marketingDescriptionType) {
		this.marketingDescriptionType = marketingDescriptionType;
	}
	public final String getImageType() {
		return imageType;
	}
	public final void setImageType(final String imageType) {
		this.imageType = imageType;
	}
	public final String getProductOfferingType() {
		return productOfferingType;
	}
	public final void setProductOfferingType(final String productOfferingType) {
		this.productOfferingType = productOfferingType;
	}
	public final String getLob() {
		return lob;
	}
	public final void setLob(final String lob) {
		this.lob = lob;
	}
	public final String getProductSpecId() {
		return productSpecId;
	}
	public final void setProductSpecId(final String productSpecId) {
		this.productSpecId = productSpecId;
	}
	public final String getProductSpecPricingID() {
		return productSpecPricingID;
	}
	public final void setProductSpecPricingID(final String productSpecPricingID) {
		this.productSpecPricingID = productSpecPricingID;
	}
}
