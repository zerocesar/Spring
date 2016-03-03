package mx.com.att.vo.amdocs;

public class SearchResult {
	
	private LinkVO[] link;
	private String assignedID;
	private Attachment[] attachments;
	private Boolean bundle;
	//private ItemBusinessType businessType;
	private String catalogItemBanner;
	private String catalogItemDescription;
	private String catalogItemDisplayName;
	private String catalogItemID;
	private String catalogItemImage;
	private String catalogItemImageType;
	private String catalogItemName;	
	//private CompatibleWithDevice compatibleWithDevice;
	private String currency;	
	//private ItemStatus currentStatus;
	private String eligibilityReason;
	private String eligibilityStatus;	
	private Boolean expiredIndication;
	private Boolean hasCrossProductDiscount;
	private Boolean isReplaceOffer;	
	private String[] lob;
	private Integer minNumOfSubscribers;
	private Integer numOfSubscribers;
	private Integer parentAssignedID;
	private Integer parentCatalogItemID;
	private Integer parentCatalogItemName;
	private Integer parentCurrentStatus;
	private Integer planType;
	private Integer relationID;
	//private SharedPlan sharedPlan;	
	private Boolean topRecommended;
	private Boolean type;
	private RecurringPrice recurringPrice;
	private ContainingOffering[] containingOfferings;
	private BundleSearchResult[] bundleSearchResults;
	private OneTimePrice oneTimePrice;
	private Integer catalogVariantGroupResponse;
	private Boolean sellableWithoutPlan;
	private String sku;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getAssignedID() {
		return assignedID;
	}
	public void setAssignedID(String assignedID) {
		this.assignedID = assignedID;
	}
	public Attachment[] getAttachments() {
		return attachments;
	}
	public void setAttachments(Attachment[] attachments) {
		this.attachments = attachments;
	}
	public Boolean getBundle() {
		return bundle;
	}
	public void setBundle(Boolean bundle) {
		this.bundle = bundle;
	}
	/*
	public ItemBusinessType getBusinessType() {
		return businessType;
	}
	public void setBusinessType(ItemBusinessType businessType) {
		this.businessType = businessType;
	}*/
	public String getCatalogItemBanner() {
		return catalogItemBanner;
	}
	public void setCatalogItemBanner(String catalogItemBanner) {
		this.catalogItemBanner = catalogItemBanner;
	}
	public String getCatalogItemDescription() {
		return catalogItemDescription;
	}
	public void setCatalogItemDescription(String catalogItemDescription) {
		this.catalogItemDescription = catalogItemDescription;
	}
	public String getCatalogItemDisplayName() {
		return catalogItemDisplayName;
	}
	public void setCatalogItemDisplayName(String catalogItemDisplayName) {
		this.catalogItemDisplayName = catalogItemDisplayName;
	}
	public String getCatalogItemID() {
		return catalogItemID;
	}
	public void setCatalogItemID(String catalogItemID) {
		this.catalogItemID = catalogItemID;
	}
	public String getCatalogItemImage() {
		return catalogItemImage;
	}
	public void setCatalogItemImage(String catalogItemImage) {
		this.catalogItemImage = catalogItemImage;
	}
	public String getCatalogItemImageType() {
		return catalogItemImageType;
	}
	public void setCatalogItemImageType(String catalogItemImageType) {
		this.catalogItemImageType = catalogItemImageType;
	}
	public String getCatalogItemName() {
		return catalogItemName;
	}
	public void setCatalogItemName(String catalogItemName) {
		this.catalogItemName = catalogItemName;
	}
	/*
	public CompatibleWithDevice getCompatibleWithDevice() {
		return compatibleWithDevice;
	}
	public void setCompatibleWithDevice(CompatibleWithDevice compatibleWithDevice) {
		this.compatibleWithDevice = compatibleWithDevice;
	}
	*/
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/*
	public ItemStatus getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(ItemStatus currentStatus) {
		this.currentStatus = currentStatus;
	}
	*/
	public String getEligibilityReason() {
		return eligibilityReason;
	}
	public void setEligibilityReason(String eligibilityReason) {
		this.eligibilityReason = eligibilityReason;
	}
	public String getEligibilityStatus() {
		return eligibilityStatus;
	}
	public void setEligibilityStatus(String eligibilityStatus) {
		this.eligibilityStatus = eligibilityStatus;
	}
	public Boolean getExpiredIndication() {
		return expiredIndication;
	}
	public void setExpiredIndication(Boolean expiredIndication) {
		this.expiredIndication = expiredIndication;
	}
	public Boolean getHasCrossProductDiscount() {
		return hasCrossProductDiscount;
	}
	public void setHasCrossProductDiscount(Boolean hasCrossProductDiscount) {
		this.hasCrossProductDiscount = hasCrossProductDiscount;
	}
	public Boolean getIsReplaceOffer() {
		return isReplaceOffer;
	}
	public void setIsReplaceOffer(Boolean isReplaceOffer) {
		this.isReplaceOffer = isReplaceOffer;
	}
	public String[] getLob() {
		return lob;
	}
	public void setLob(String[] lob) {
		this.lob = lob;
	}
	public Integer getMinNumOfSubscribers() {
		return minNumOfSubscribers;
	}
	public void setMinNumOfSubscribers(Integer minNumOfSubscribers) {
		this.minNumOfSubscribers = minNumOfSubscribers;
	}
	public Integer getNumOfSubscribers() {
		return numOfSubscribers;
	}
	public void setNumOfSubscribers(Integer numOfSubscribers) {
		this.numOfSubscribers = numOfSubscribers;
	}
	public Integer getParentAssignedID() {
		return parentAssignedID;
	}
	public void setParentAssignedID(Integer parentAssignedID) {
		this.parentAssignedID = parentAssignedID;
	}
	public Integer getParentCatalogItemID() {
		return parentCatalogItemID;
	}
	public void setParentCatalogItemID(Integer parentCatalogItemID) {
		this.parentCatalogItemID = parentCatalogItemID;
	}
	public Integer getParentCatalogItemName() {
		return parentCatalogItemName;
	}
	public void setParentCatalogItemName(Integer parentCatalogItemName) {
		this.parentCatalogItemName = parentCatalogItemName;
	}
	public Integer getParentCurrentStatus() {
		return parentCurrentStatus;
	}
	public void setParentCurrentStatus(Integer parentCurrentStatus) {
		this.parentCurrentStatus = parentCurrentStatus;
	}
	public Integer getPlanType() {
		return planType;
	}
	public void setPlanType(Integer planType) {
		this.planType = planType;
	}
	public Integer getRelationID() {
		return relationID;
	}
	public void setRelationID(Integer relationID) {
		this.relationID = relationID;
	}
	/*
	public SharedPlan getSharedPlan() {
		return sharedPlan;
	}
	public void setSharedPlan(SharedPlan sharedPlan) {
		this.sharedPlan = sharedPlan;
	}
	*/
	public Boolean getTopRecommended() {
		return topRecommended;
	}
	public void setTopRecommended(Boolean topRecommended) {
		this.topRecommended = topRecommended;
	}
	public Boolean getType() {
		return type;
	}
	public void setType(Boolean type) {
		this.type = type;
	}
	public RecurringPrice getRecurringPrice() {
		return recurringPrice;
	}
	public void setRecurringPrice(RecurringPrice recurringPrice) {
		this.recurringPrice = recurringPrice;
	}
	public ContainingOffering[] getContainingOfferings() {
		return containingOfferings;
	}
	public void setContainingOfferings(ContainingOffering[] containingOfferings) {
		this.containingOfferings = containingOfferings;
	}
	public BundleSearchResult[] getBundleSearchResults() {
		return bundleSearchResults;
	}
	public void setBundleSearchResults(BundleSearchResult[] bundleSearchResults) {
		this.bundleSearchResults = bundleSearchResults;
	}
	public OneTimePrice getOneTimePrice() {
		return oneTimePrice;
	}
	public void setOneTimePrice(OneTimePrice oneTimePrice) {
		this.oneTimePrice = oneTimePrice;
	}
	public Integer getCatalogVariantGroupResponse() {
		return catalogVariantGroupResponse;
	}
	public void setCatalogVariantGroupResponse(Integer catalogVariantGroupResponse) {
		this.catalogVariantGroupResponse = catalogVariantGroupResponse;
	}
	public Boolean getSellableWithoutPlan() {
		return sellableWithoutPlan;
	}
	public void setSellableWithoutPlan(Boolean sellableWithoutPlan) {
		this.sellableWithoutPlan = sellableWithoutPlan;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}

	
}
