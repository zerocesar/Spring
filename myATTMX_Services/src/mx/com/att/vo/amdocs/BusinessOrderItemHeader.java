package mx.com.att.vo.amdocs;

public class BusinessOrderItemHeader {
	
	private LinkVO[] link;
	private String businessOfferTemplateID;
	private String businessOfferTemplateName;
	private String frameworkAgreementName;
	private String groupName;
	//private OrderLevelInAgreement levelInAgreement;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getBusinessOfferTemplateID() {
		return businessOfferTemplateID;
	}
	public void setBusinessOfferTemplateID(String businessOfferTemplateID) {
		this.businessOfferTemplateID = businessOfferTemplateID;
	}
	public String getBusinessOfferTemplateName() {
		return businessOfferTemplateName;
	}
	public void setBusinessOfferTemplateName(String businessOfferTemplateName) {
		this.businessOfferTemplateName = businessOfferTemplateName;
	}
	public String getFrameworkAgreementName() {
		return frameworkAgreementName;
	}
	public void setFrameworkAgreementName(String frameworkAgreementName) {
		this.frameworkAgreementName = frameworkAgreementName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/*
	public OrderLevelInAgreement getLevelInAgreement() {
		return levelInAgreement;
	}
	public void setLevelInAgreement(OrderLevelInAgreement levelInAgreement) {
		this.levelInAgreement = levelInAgreement;
	}
	*/
	
	
}
