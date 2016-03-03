package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class PriceSchemasForReplacementRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LinkVO[] Link;
	private String categoryId;
	private Boolean sortAscending;
	private FilterFacet[]  filterFacets;
	//private CatalogItemSortType sortType;
	private Boolean returnOnlySPO;
	private RelatedItemDetailRequest RelatedItemDetailRequest;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(final String categoryId) {
		this.categoryId = categoryId;
	}
	public Boolean getSortAscending() {
		return sortAscending;
	}
	public void setSortAscending(final Boolean sortAscending) {
		this.sortAscending = sortAscending;
	}
	public FilterFacet[] getFilterFacets() {
		return filterFacets;
	}
	public void setFilterFacets(final FilterFacet[] filterFacets) {
		this.filterFacets = filterFacets;
	}
	/*
	public CatalogItemSortType getSortType() {
		return sortType;
	}
	public void setSortType(final CatalogItemSortType sortType) {
		this.sortType = sortType;
	}
	*/
	public Boolean getReturnOnlySPO() {
		return returnOnlySPO;
	}
	public void setReturnOnlySPO(final Boolean returnOnlySPO) {
		this.returnOnlySPO = returnOnlySPO;
	}
	public RelatedItemDetailRequest getRelatedItemDetailRequest() {
		return RelatedItemDetailRequest;
	}
	public void setRelatedItemDetailRequest(final 
			RelatedItemDetailRequest relatedItemDetailRequest) {
		RelatedItemDetailRequest = relatedItemDetailRequest;
	}

	
	
}