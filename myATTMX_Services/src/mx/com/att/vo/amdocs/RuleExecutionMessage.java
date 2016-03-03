package mx.com.att.vo.amdocs;

public class RuleExecutionMessage {
	private LinkVO[] link;
	private String configurationStepSpecID;
	private String configurationStepSpecName;
	private String messageId;
	private String objectId;
	private FlexAttr[] parameters;
	private String productSpecCharacteristicID;
//	private ConfigurationRuleLevel ruleLevel;
	private String severity;
	private String text;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getConfigurationStepSpecID() {
		return configurationStepSpecID;
	}
	public final void setConfigurationStepSpecID(final String configurationStepSpecID) {
		this.configurationStepSpecID = configurationStepSpecID;
	}
	public final String getConfigurationStepSpecName() {
		return configurationStepSpecName;
	}
	public final void setConfigurationStepSpecName(final String configurationStepSpecName) {
		this.configurationStepSpecName = configurationStepSpecName;
	}
	public final String getMessageId() {
		return messageId;
	}
	public final void setMessageId(final String messageId) {
		this.messageId = messageId;
	}
	public final String getObjectId() {
		return objectId;
	}
	public final void setObjectId(final String objectId) {
		this.objectId = objectId;
	}
	public final FlexAttr[] getParameters() {
		return parameters;
	}
	public final void setParameters(final FlexAttr[] parameters) {
		this.parameters = parameters;
	}
	public final String getProductSpecCharacteristicID() {
		return productSpecCharacteristicID;
	}
	public final void setProductSpecCharacteristicID(final 
			String productSpecCharacteristicID) {
		this.productSpecCharacteristicID = productSpecCharacteristicID;
	}
	public final String getSeverity() {
		return severity;
	}
	public final void setSeverity(final String severity) {
		this.severity = severity;
	}
	public final String getText() {
		return text;
	}
	public final void setText(final String text) {
		this.text = text;
	}
}
