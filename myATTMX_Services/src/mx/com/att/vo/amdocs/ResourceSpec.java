package mx.com.att.vo.amdocs;

public class ResourceSpec {
	private LinkVO[]	link;
	private String	type;
	private Option	categoryDefaultValue;
	private Option[]	categoryValues;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getType() {
		return type;
	}
	public final void setType(final String type) {
		this.type = type;
	}
	public final Option getCategoryDefaultValue() {
		return categoryDefaultValue;
	}
	public final void setCategoryDefaultValue(final Option categoryDefaultValue) {
		this.categoryDefaultValue = categoryDefaultValue;
	}
	public final Option[] getCategoryValues() {
		return categoryValues;
	}
	public final void setCategoryValues(final Option[] categoryValues) {
		this.categoryValues = categoryValues;
	}

}
