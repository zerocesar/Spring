package mx.com.att.vo.amdocs;

public class ConfigurationParameterForOrder {
	
	private LinkVO[] Link;
	
	public String catalogId;
	public String name;
	public String value;
	public String valueName;
	
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
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(final String value) {
		this.value = value;
	}
	public String getValueName() {
		return valueName;
	}
	public void setValueName(final String valueName) {
		this.valueName = valueName;
	}	
	

}
