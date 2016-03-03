package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ReasonVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LinkVO Link[];	
	public String value;
	public String localizedValue;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		this.Link = link;
	}
	public String getValue() {
		return value;
	}
	public void setValue(final String value) {
		this.value = value;
	}
	public String getLocalizedValue() {
		return localizedValue;
	}
	public void setLocalizedValue(final String localizedValue) {
		this.localizedValue = localizedValue;
	}
	
	
	
	
	
}