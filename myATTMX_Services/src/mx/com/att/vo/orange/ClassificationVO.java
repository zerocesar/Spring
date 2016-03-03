package mx.com.att.vo.orange;

import java.io.Serializable;

public class ClassificationVO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4318626411593494767L;

	private int metaCatalogId;
    private String metaCatalogValue;
    private String metaCatalogType;
    private String metaCatalogDesc;
    
	public int getMetaCatalogId() {
		return metaCatalogId;
	}
	public void setMetaCatalogId(int metaCatalogId) {
		this.metaCatalogId = metaCatalogId;
	}
	public String getMetaCatalogValue() {
		return metaCatalogValue;
	}
	public void setMetaCatalogValue(String metaCatalogValue) {
		this.metaCatalogValue = metaCatalogValue;
	}
	public String getMetaCatalogType() {
		return metaCatalogType;
	}
	public void setMetaCatalogType(String metaCatalogType) {
		this.metaCatalogType = metaCatalogType;
	}
	public String getMetaCatalogDesc() {
		return metaCatalogDesc;
	}
	public void setMetaCatalogDesc(String metaCatalogDesc) {
		this.metaCatalogDesc = metaCatalogDesc;
	}	
}
