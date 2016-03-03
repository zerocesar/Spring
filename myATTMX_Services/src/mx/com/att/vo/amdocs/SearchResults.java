package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class SearchResults implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LinkVO Link[];	
	private SearchCatalogItems items;
	private SearchResultsCategory categories;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(LinkVO[] link) {
		Link = link;
	}
	public SearchCatalogItems getItems() {
		return items;
	}
	public void setItems(SearchCatalogItems items) {
		this.items = items;
	}
	public SearchResultsCategory getCategories() {
		return categories;
	}
	public void setCategories(SearchResultsCategory categories) {
		this.categories = categories;
	}
	
	
	
}