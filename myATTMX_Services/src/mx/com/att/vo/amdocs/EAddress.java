package mx.com.att.vo.amdocs;

public class EAddress {
	private LinkVO[] Link;	
	
	public String id;
	//public EAddressType type;
	public String value;
	public String objId;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	/*
	public EAddressType getType() {
		return type;
	}
	public void setType(final EAddressType type) {
		this.type = type;
	}
	*/
	public String getValue() {
		return value;
	}
	public void setValue(final String value) {
		this.value = value;
	}
	public String getObjId() {
		return objId;
	}
	public void setObjId(final String objId) {
		this.objId = objId;
	}

	
	
}
