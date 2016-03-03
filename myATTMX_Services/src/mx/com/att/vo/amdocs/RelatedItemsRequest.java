package mx.com.att.vo.amdocs;

public class RelatedItemsRequest {
	private LinkVO[] link;
	private Boolean includeEligibleOfferingOnly;
	private Boolean includeExpiredOfferings;
	private String categoryId;
	private String customerId;
	private String offeringId;
	private String offeringToProductId;
	private FilterFacet[] filterFacets;
	private String paymentCategory;
	private String sortType;
	private Boolean sortAscending;
	private String browsingCategoryStructureId;
	private GeographicAddress GeographicAddress;
	private Boolean IncludeOnlySelectedProductVariant;
	private String HGPresentmentLevel;
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public Boolean getIncludeEligibleOfferingOnly() {
		return includeEligibleOfferingOnly;
	}
	public void setIncludeEligibleOfferingOnly(Boolean includeEligibleOfferingOnly) {
		this.includeEligibleOfferingOnly = includeEligibleOfferingOnly;
	}
	public Boolean getIncludeExpiredOfferings() {
		return includeExpiredOfferings;
	}
	public void setIncludeExpiredOfferings(Boolean includeExpiredOfferings) {
		this.includeExpiredOfferings = includeExpiredOfferings;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOfferingId() {
		return offeringId;
	}
	public void setOfferingId(String offeringId) {
		this.offeringId = offeringId;
	}
	public String getOfferingToProductId() {
		return offeringToProductId;
	}
	public void setOfferingToProductId(String offeringToProductId) {
		this.offeringToProductId = offeringToProductId;
	}
	public FilterFacet[] getFilterFacets() {
		return filterFacets;
	}
	public void setFilterFacets(FilterFacet[] filterFacets) {
		this.filterFacets = filterFacets;
	}
	public String getPaymentCategory() {
		return paymentCategory;
	}
	public void setPaymentCategory(String paymentCategory) {
		this.paymentCategory = paymentCategory;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public Boolean getSortAscending() {
		return sortAscending;
	}
	public void setSortAscending(Boolean sortAscending) {
		this.sortAscending = sortAscending;
	}
	public String getBrowsingCategoryStructureId() {
		return browsingCategoryStructureId;
	}
	public void setBrowsingCategoryStructureId(String browsingCategoryStructureId) {
		this.browsingCategoryStructureId = browsingCategoryStructureId;
	}
	public GeographicAddress getGeographicAddress() {
		return GeographicAddress;
	}
	public void setGeographicAddress(GeographicAddress geographicAddress) {
		GeographicAddress = geographicAddress;
	}
	public Boolean getIncludeOnlySelectedProductVariant() {
		return IncludeOnlySelectedProductVariant;
	}
	public void setIncludeOnlySelectedProductVariant(
			Boolean includeOnlySelectedProductVariant) {
		IncludeOnlySelectedProductVariant = includeOnlySelectedProductVariant;
	}
	public String getHGPresentmentLevel() {
		return HGPresentmentLevel;
	}
	public void setHGPresentmentLevel(String hGPresentmentLevel) {
		HGPresentmentLevel = hGPresentmentLevel;
	}
	
	
	
}
