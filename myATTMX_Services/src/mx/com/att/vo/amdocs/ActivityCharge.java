package mx.com.att.vo.amdocs;

public class ActivityCharge {
	private LinkVO[]	link;
	private String	code;
	private String	description;
	private FlexAttr[]	dynamicProperties;
	private String	id;
	private String	name;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getCode() {
		return code;
	}
	public final void setCode(final String code) {
		this.code = code;
	}
	public final String getDescription() {
		return description;
	}
	public final void setDescription(final String description) {
		this.description = description;
	}
	public final FlexAttr[] getDynamicProperties() {
		return dynamicProperties;
	}
	public final void setDynamicProperties(final FlexAttr[] dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	public final String getId() {
		return id;
	}
	public final void setId(final String id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}

}
