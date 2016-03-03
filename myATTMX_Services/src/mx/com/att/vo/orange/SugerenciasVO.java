package mx.com.att.vo.orange;

import java.io.Serializable;

public class SugerenciasVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long loginId;
	private Long navigationId;
	private String category;
	private String message;
	private String mood;
	private Long subcategoryId;
	
	public Long getLoginId() {
		return loginId;
	}
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	public Long getNavigationId() {
		return navigationId;
	}
	public void setNavigationId(Long navigationId) {
		this.navigationId = navigationId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	public Long getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(Long subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
}