package mx.com.att.vo.amdocs;

public class ChangedConfigurationParameter {
	public LinkVO[] Link;
	public String catalogId;
	public String  value;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(final String catalogId) {
		this.catalogId = catalogId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(final String value) {
		this.value = value;
	}
	
	
	
	
	
}
