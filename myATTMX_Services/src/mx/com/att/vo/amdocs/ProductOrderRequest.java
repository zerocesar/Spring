package mx.com.att.vo.amdocs;

public class ProductOrderRequest {
	
	
	private LinkVO[] link;
	private Integer numRowsToRetrieve;
	//private ProductOrderSortBy ordersSortBy;
	private Boolean sortAscending;
	private ProductOrderFilterInfo filterCriteria;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public Integer getNumRowsToRetrieve() {
		return numRowsToRetrieve;
	}
	public void setNumRowsToRetrieve(Integer numRowsToRetrieve) {
		this.numRowsToRetrieve = numRowsToRetrieve;
	}
	/*
	public ProductOrderSortBy getOrdersSortBy() {
		return ordersSortBy;
	}
	public void setOrdersSortBy(ProductOrderSortBy ordersSortBy) {
		this.ordersSortBy = ordersSortBy;
	}
	*/
	public Boolean getSortAscending() {
		return sortAscending;
	}
	public void setSortAscending(Boolean sortAscending) {
		this.sortAscending = sortAscending;
	}
	public ProductOrderFilterInfo getFilterCriteria() {
		return filterCriteria;
	}
	public void setFilterCriteria(ProductOrderFilterInfo filterCriteria) {
		this.filterCriteria = filterCriteria;
	}
	
	
	
}
