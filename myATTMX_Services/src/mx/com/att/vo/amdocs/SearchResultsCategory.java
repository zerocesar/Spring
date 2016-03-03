package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class SearchResultsCategory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LinkVO[] Link;
	private String categoryId;
	private String categoryName;
	private String currentPlanRelationID;
	private Integer itemsPerCategory;
	private Integer itemsPerPage;
	private Integer startIndex;
	private Integer totalResultsInCategory;
	private SearchResult[]  results;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(LinkVO[] link) {
		Link = link;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCurrentPlanRelationID() {
		return currentPlanRelationID;
	}
	public void setCurrentPlanRelationID(String currentPlanRelationID) {
		this.currentPlanRelationID = currentPlanRelationID;
	}
	public Integer getItemsPerCategory() {
		return itemsPerCategory;
	}
	public void setItemsPerCategory(Integer itemsPerCategory) {
		this.itemsPerCategory = itemsPerCategory;
	}
	public Integer getItemsPerPage() {
		return itemsPerPage;
	}
	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getTotalResultsInCategory() {
		return totalResultsInCategory;
	}
	public void setTotalResultsInCategory(Integer totalResultsInCategory) {
		this.totalResultsInCategory = totalResultsInCategory;
	}
	public SearchResult[] getResults() {
		return results;
	}
	public void setResults(SearchResult[] results) {
		this.results = results;
	}
	
	

}