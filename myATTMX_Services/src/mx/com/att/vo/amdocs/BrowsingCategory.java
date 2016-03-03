package mx.com.att.vo.amdocs;

public class BrowsingCategory {
	private LinkVO[]	link;
	private FlexAttr[]	dynamicProperties;
	private String	code;
	private boolean	comparable;
	private String	id;
	private LineOfBusinessDetails	lob;
	private String	name;
//	private BrowsingCategoryType	type;
	private FilterFacet[]	filterFacets;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final FlexAttr[] getDynamicProperties() {
		return dynamicProperties;
	}
	public final void setDynamicProperties(final FlexAttr[] dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	public final String getCode() {
		return code;
	}
	public final void setCode(final String code) {
		this.code = code;
	}
	public boolean isComparable() {
		return comparable;
	}
	public void setComparable(final boolean comparable) {
		this.comparable = comparable;
	}
	public final String getId() {
		return id;
	}
	public final void setId(final String id) {
		this.id = id;
	}
	public final LineOfBusinessDetails getLob() {
		return lob;
	}
	public final void setLob(final LineOfBusinessDetails lob) {
		this.lob = lob;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public final FilterFacet[] getFilterFacets() {
		return filterFacets;
	}
	public final void setFilterFacets(final FilterFacet[] filterFacets) {
		this.filterFacets = filterFacets;
	}

}
