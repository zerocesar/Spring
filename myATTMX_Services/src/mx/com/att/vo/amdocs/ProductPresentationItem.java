package mx.com.att.vo.amdocs;

public class ProductPresentationItem {
	
	private LinkVO[]	link;
	private String name;
	//private ProductPresentationItemType type;
	private String value;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	public ProductPresentationItemType getType() {
		return type;
	}
	public void setType(ProductPresentationItemType type) {
		this.type = type;
	}*/
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	
	
}
