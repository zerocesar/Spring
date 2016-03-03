package mx.com.att.dao.orange;

import java.io.Serializable;

public class CsqSubcategoryVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int subcategoryId;
	private String subcategoryDesc;
	private String available;
	
	public int getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	public String getSubcategoryDesc() {
		return subcategoryDesc;
	}
	public void setSubcategoryDesc(String subcategoryDesc) {
		this.subcategoryDesc = subcategoryDesc;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
}