package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class LinkVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5931188924903488084L;
	
	public String href;
	public String rel;
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	
	
}