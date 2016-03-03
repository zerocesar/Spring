package mx.com.att.vo.amdocs;

public class ProductHeader {
	
	private LinkVO[] link;	
	private Boolean confirmationMessagesApproved;
	private String equipmentName;
	private String id;
	private String[] includedProductID;
	private String lob;
	private String offeringDescription;
	private String offeringId;
	private String offeringInstanceId;
	private String offeringName;
	//private PaymentCategory paymentCategory;
	private String personId;
	private String personName;
	private String productName;
	private String serviceId;
	private Boolean shared;
	private String sharedPlanDescription;
	private String SharedProductID;
	private String spoDescription;
	private String spoName;
	//private ServiceStatus status;
	private Integer subscriptionId;
	private String sharedPlanName;
	private InstallationAddress address;
	private DeviceHeader[] devices;
	private PlanHeader plan;
	
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public Boolean getConfirmationMessagesApproved() {
		return confirmationMessagesApproved;
	}
	public void setConfirmationMessagesApproved(Boolean confirmationMessagesApproved) {
		this.confirmationMessagesApproved = confirmationMessagesApproved;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getIncludedProductID() {
		return includedProductID;
	}
	public void setIncludedProductID(String[] includedProductID) {
		this.includedProductID = includedProductID;
	}
	public String getLob() {
		return lob;
	}
	public void setLob(String lob) {
		this.lob = lob;
	}
	public String getOfferingDescription() {
		return offeringDescription;
	}
	public void setOfferingDescription(String offeringDescription) {
		this.offeringDescription = offeringDescription;
	}
	public String getOfferingId() {
		return offeringId;
	}
	public void setOfferingId(String offeringId) {
		this.offeringId = offeringId;
	}
	public String getOfferingInstanceId() {
		return offeringInstanceId;
	}
	public void setOfferingInstanceId(String offeringInstanceId) {
		this.offeringInstanceId = offeringInstanceId;
	}
	public String getOfferingName() {
		return offeringName;
	}
	public void setOfferingName(String offeringName) {
		this.offeringName = offeringName;
	}
	/*
	public PaymentCategory getPaymentCategory() {
		return paymentCategory;
	}
	public void setPaymentCategory(PaymentCategory paymentCategory) {
		this.paymentCategory = paymentCategory;
	}*/
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public Boolean getShared() {
		return shared;
	}
	public void setShared(Boolean shared) {
		this.shared = shared;
	}
	public String getSharedPlanDescription() {
		return sharedPlanDescription;
	}
	public void setSharedPlanDescription(String sharedPlanDescription) {
		this.sharedPlanDescription = sharedPlanDescription;
	}
	public String getSharedProductID() {
		return SharedProductID;
	}
	public void setSharedProductID(String sharedProductID) {
		SharedProductID = sharedProductID;
	}
	public String getSpoDescription() {
		return spoDescription;
	}
	public void setSpoDescription(String spoDescription) {
		this.spoDescription = spoDescription;
	}
	public String getSpoName() {
		return spoName;
	}
	public void setSpoName(String spoName) {
		this.spoName = spoName;
	}
	/*
	public ServiceStatus getStatus() {
		return status;
	}
	public void setStatus(ServiceStatus status) {
		this.status = status;
	}*/
	public Integer getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getSharedPlanName() {
		return sharedPlanName;
	}
	public void setSharedPlanName(String sharedPlanName) {
		this.sharedPlanName = sharedPlanName;
	}
	public InstallationAddress getAddress() {
		return address;
	}
	public void setAddress(InstallationAddress address) {
		this.address = address;
	}
	public DeviceHeader[] getDevices() {
		return devices;
	}
	public void setDevices(DeviceHeader[] devices) {
		this.devices = devices;
	}
	public PlanHeader getPlan() {
		return plan;
	}
	public void setPlan(PlanHeader plan) {
		this.plan = plan;
	}

	
	
	
	
}
