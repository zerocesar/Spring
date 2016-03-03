package mx.com.att.vo.amdocs;

public class Orders {
	private LinkVO[] link;
	
	private Integer itemsPerPage;
	private Boolean moreRowsInd;
	private Integer startIndex;
	private Integer totalResults;
	private OrderHeader[] orders;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public Integer getItemsPerPage() {
		return itemsPerPage;
	}
	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	public Boolean getMoreRowsInd() {
		return moreRowsInd;
	}
	public void setMoreRowsInd(Boolean moreRowsInd) {
		this.moreRowsInd = moreRowsInd;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}
	public OrderHeader[] getOrders() {
		return orders;
	}
	public void setOrders(OrderHeader[] orders) {
		this.orders = orders;
	}

	
}
