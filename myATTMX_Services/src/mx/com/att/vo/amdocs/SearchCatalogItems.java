package mx.com.att.vo.amdocs;

import java.io.Serializable;
public class SearchCatalogItems implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LinkVO Link[];	
	private Integer itemsPerPage;
	private Integer itemsPerCategory;
	private Integer startIndex;
	private Integer totalResults;
	private SearchResults[] results;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public Integer getItemsPerPage() {
		return itemsPerPage;
	}
	public void setItemsPerPage(final Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	public Integer getItemsPerCategory() {
		return itemsPerCategory;
	}
	public void setItemsPerCategory(final Integer itemsPerCategory) {
		this.itemsPerCategory = itemsPerCategory;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(final Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(final Integer totalResults) {
		this.totalResults = totalResults;
	}
	public SearchResults[] getResults() {
		return results;
	}
	public void setResults(final SearchResults[] results) {
		this.results = results;
	}

	
}