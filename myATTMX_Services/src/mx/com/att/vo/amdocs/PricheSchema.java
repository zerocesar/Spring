package mx.com.att.vo.amdocs;

public class PricheSchema {
	
	private LinkVO[] Link;
	public CatalogItemCharacteristic  Summary;
	public CatalogItemCharacteristicGroup DetailsGroups;
	public FlexAttr[] DynamicProperties;
	public CatalogItemCharacteristic[] Overview;
	public CustomerDiscounts[] CrossProductDiscounts;
	public String PlanType;
	public CatalogItemCharacteristicGroup[] ContainingOfferDetailsGroup;
	public String MarketingDescription;
	public OnetimeCharge TotalOneTimeCharges;
	public boolean ChangeToThisPlanAllowed;
	public RecurringCharge TotalRecurringCharges;	
	public String Name;
	public String ID;
	//public PriceSchemaType Type;
	public String DisplayName;
	public String Level;
	public String Image;
	public String Description;
	public String marketingDescriptionType;
	public String imageType;
	public String productOfferingType;
	public String lob;
	public String productSpecId;
	public String productSpecPricingID;
	
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public CatalogItemCharacteristic getSummary() {
		return Summary;
	}
	public void setSummary(final CatalogItemCharacteristic summary) {
		Summary = summary;
	}
	public CatalogItemCharacteristicGroup getDetailsGroups() {
		return DetailsGroups;
	}
	public void setDetailsGroups(final CatalogItemCharacteristicGroup detailsGroups) {
		DetailsGroups = detailsGroups;
	}
	public FlexAttr[] getDynamicProperties() {
		return DynamicProperties;
	}
	public void setDynamicProperties(final FlexAttr[] dynamicProperties) {
		DynamicProperties = dynamicProperties;
	}
	public CatalogItemCharacteristic[] getOverview() {
		return Overview;
	}
	public void setOverview(final CatalogItemCharacteristic[] overview) {
		Overview = overview;
	}
	public CustomerDiscounts[] getCrossProductDiscounts() {
		return CrossProductDiscounts;
	}
	public void setCrossProductDiscounts(final CustomerDiscounts[] crossProductDiscounts) {
		CrossProductDiscounts = crossProductDiscounts;
	}
	public String getPlanType() {
		return PlanType;
	}
	public void setPlanType(final String planType) {
		PlanType = planType;
	}
	public CatalogItemCharacteristicGroup[] getContainingOfferDetailsGroup() {
		return ContainingOfferDetailsGroup;
	}
	public void setContainingOfferDetailsGroup(final 
			CatalogItemCharacteristicGroup[] containingOfferDetailsGroup) {
		ContainingOfferDetailsGroup = containingOfferDetailsGroup;
	}
	public String getMarketingDescription() {
		return MarketingDescription;
	}
	public void setMarketingDescription(final String marketingDescription) {
		MarketingDescription = marketingDescription;
	}
	public OnetimeCharge getTotalOneTimeCharges() {
		return TotalOneTimeCharges;
	}
	public void setTotalOneTimeCharges(final OnetimeCharge totalOneTimeCharges) {
		TotalOneTimeCharges = totalOneTimeCharges;
	}
	public boolean isChangeToThisPlanAllowed() {
		return ChangeToThisPlanAllowed;
	}
	public void setChangeToThisPlanAllowed(final boolean changeToThisPlanAllowed) {
		ChangeToThisPlanAllowed = changeToThisPlanAllowed;
	}
	public RecurringCharge getTotalRecurringCharges() {
		return TotalRecurringCharges;
	}
	public void setTotalRecurringCharges(final RecurringCharge totalRecurringCharges) {
		TotalRecurringCharges = totalRecurringCharges;
	}
	public String getName() {
		return Name;
	}
	public void setName(final String name) {
		Name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(final String iD) {
		ID = iD;
	}
	/*
	public PriceSchemaType getType() {
		return Type;
	}
	public void setType(final PriceSchemaType type) {
		Type = type;
	}*/
	public String getDisplayName() {
		return DisplayName;
	}
	public void setDisplayName(final String displayName) {
		DisplayName = displayName;
	}
	public String getLevel() {
		return Level;
	}
	public void setLevel(final String level) {
		Level = level;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(final String image) {
		Image = image;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(final String description) {
		Description = description;
	}
	public String getMarketingDescriptionType() {
		return marketingDescriptionType;
	}
	public void setMarketingDescriptionType(final String marketingDescriptionType) {
		this.marketingDescriptionType = marketingDescriptionType;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(final String imageType) {
		this.imageType = imageType;
	}
	public String getProductOfferingType() {
		return productOfferingType;
	}
	public void setProductOfferingType(final String productOfferingType) {
		this.productOfferingType = productOfferingType;
	}
	public String getLob() {
		return lob;
	}
	public void setLob(final String lob) {
		this.lob = lob;
	}
	public String getProductSpecId() {
		return productSpecId;
	}
	public void setProductSpecId(final String productSpecId) {
		this.productSpecId = productSpecId;
	}
	public String getProductSpecPricingID() {
		return productSpecPricingID;
	}
	public void setProductSpecPricingID(final String productSpecPricingID) {
		this.productSpecPricingID = productSpecPricingID;
	}

}
