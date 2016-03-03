package mx.com.att.vo.amdocs;

public class ConfigurationStepDisplay {
	private LinkVO[] link;
//	private CompatibilityStatus compatibilityStatus;
	private String description;
	private Boolean enabled;
	private String ID;
	private String message;
	private String name;
	private String type;
	private ConfigurationStepDisplay[] prerequisiteSteps;
	private String rootProductOfferingProductSpecID;
	private RuleExecutionMessage[] messages;
	private TotalOneTimeCalculatedPrice totalOneTimeCalculatedPrice;
	private ConfigurationStepDisplay[] steps;
	private ProductDisplay[] displayableItems;
	private ExternalWidget externalWidget;
	private SimpleProductReferenceDisplay[] displayableSimpleProductReferences;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getDescription() {
		return description;
	}
	public final void setDescription(final String description) {
		this.description = description;
	}
	public final Boolean getEnabled() {
		return enabled;
	}
	public final void setEnabled(final Boolean enabled) {
		this.enabled = enabled;
	}
	public final String getID() {
		return ID;
	}
	public final void setID(final String iD) {
		ID = iD;
	}
	public final String getMessage() {
		return message;
	}
	public final void setMessage(final String message) {
		this.message = message;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public final String getType() {
		return type;
	}
	public final void setType(final String type) {
		this.type = type;
	}
	public final ConfigurationStepDisplay[] getPrerequisiteSteps() {
		return prerequisiteSteps;
	}
	public final void setPrerequisiteSteps(final 
			ConfigurationStepDisplay[] prerequisiteSteps) {
		this.prerequisiteSteps = prerequisiteSteps;
	}
	public final String getRootProductOfferingProductSpecID() {
		return rootProductOfferingProductSpecID;
	}
	public final void setRootProductOfferingProductSpecID(final 
			String rootProductOfferingProductSpecID) {
		this.rootProductOfferingProductSpecID = rootProductOfferingProductSpecID;
	}
	public final RuleExecutionMessage[] getMessages() {
		return messages;
	}
	public final void setMessages(final RuleExecutionMessage[] messages) {
		this.messages = messages;
	}
	public final TotalOneTimeCalculatedPrice getTotalOneTimeCalculatedPrice() {
		return totalOneTimeCalculatedPrice;
	}
	public final void setTotalOneTimeCalculatedPrice(final 
			TotalOneTimeCalculatedPrice totalOneTimeCalculatedPrice) {
		this.totalOneTimeCalculatedPrice = totalOneTimeCalculatedPrice;
	}
	public final ConfigurationStepDisplay[] getSteps() {
		return steps;
	}
	public final void setSteps(final ConfigurationStepDisplay[] steps) {
		this.steps = steps;
	}
	public final ProductDisplay[] getDisplayableItems() {
		return displayableItems;
	}
	public final void setDisplayableItems(final ProductDisplay[] displayableItems) {
		this.displayableItems = displayableItems;
	}
	public final ExternalWidget getExternalWidget() {
		return externalWidget;
	}
	public final void setExternalWidget(final ExternalWidget externalWidget) {
		this.externalWidget = externalWidget;
	}
	public final SimpleProductReferenceDisplay[] getDisplayableSimpleProductReferences() {
		return displayableSimpleProductReferences;
	}
	public final void setDisplayableSimpleProductReferences(final 
			SimpleProductReferenceDisplay[] displayableSimpleProductReferences) {
		this.displayableSimpleProductReferences = displayableSimpleProductReferences;
	}
	
}
