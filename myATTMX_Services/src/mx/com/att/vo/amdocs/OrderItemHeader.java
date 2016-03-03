package mx.com.att.vo.amdocs;

import java.math.BigDecimal;

public class OrderItemHeader {
	
	private LinkVO[] link;	
	private AvailableAction[] allowedActions;
	private String createdBy;
	private Boolean isPartOfBundle;
	private String lineOfBusiness;
	private String productLevel;	
	private BusinessOrderItemHeader BusinessOrderItem;
	private RecurringPriceForOrder recurringPrice;
	private OneTimePriceForOrder oneTimePrice;	
	//private BusinessAction actionSubType;
	private BigDecimal actionType;
	private String creationDate;
	private String description;
	private String id;
	private String lob;
	private String originatingSalesChannel;
	private String productCatalogID;
	private String productID;
	private String productOfferingInstanceID;
	private String productOfferingName;
	private String productLineOfBusiness;
	private String productName;
	private String productServiceID;
	private String referenceNumber;
	private BigDecimal serviceRequiredDate;
	//private OrderItemStatus status;
	private Integer productQuantity;
	private ProductSpecificationBusinessType businessType;
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public AvailableAction[] getAllowedActions() {
		return allowedActions;
	}
	public void setAllowedActions(AvailableAction[] allowedActions) {
		this.allowedActions = allowedActions;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Boolean getIsPartOfBundle() {
		return isPartOfBundle;
	}
	public void setIsPartOfBundle(Boolean isPartOfBundle) {
		this.isPartOfBundle = isPartOfBundle;
	}
	public String getLineOfBusiness() {
		return lineOfBusiness;
	}
	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}
	public String getProductLevel() {
		return productLevel;
	}
	public void setProductLevel(String productLevel) {
		this.productLevel = productLevel;
	}
	public BusinessOrderItemHeader getBusinessOrderItem() {
		return BusinessOrderItem;
	}
	public void setBusinessOrderItem(BusinessOrderItemHeader businessOrderItem) {
		BusinessOrderItem = businessOrderItem;
	}
	public RecurringPriceForOrder getRecurringPrice() {
		return recurringPrice;
	}
	public void setRecurringPrice(RecurringPriceForOrder recurringPrice) {
		this.recurringPrice = recurringPrice;
	}
	public OneTimePriceForOrder getOneTimePrice() {
		return oneTimePrice;
	}
	public void setOneTimePrice(OneTimePriceForOrder oneTimePrice) {
		this.oneTimePrice = oneTimePrice;
	}
	/*
	public BusinessAction getActionSubType() {
		return actionSubType;
	}
	public void setActionSubType(BusinessAction actionSubType) {
		this.actionSubType = actionSubType;
	}
	*/
	public BigDecimal getActionType() {
		return actionType;
	}
	public void setActionType(BigDecimal actionType) {
		this.actionType = actionType;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLob() {
		return lob;
	}
	public void setLob(String lob) {
		this.lob = lob;
	}
	public String getOriginatingSalesChannel() {
		return originatingSalesChannel;
	}
	public void setOriginatingSalesChannel(String originatingSalesChannel) {
		this.originatingSalesChannel = originatingSalesChannel;
	}
	public String getProductCatalogID() {
		return productCatalogID;
	}
	public void setProductCatalogID(String productCatalogID) {
		this.productCatalogID = productCatalogID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductOfferingInstanceID() {
		return productOfferingInstanceID;
	}
	public void setProductOfferingInstanceID(String productOfferingInstanceID) {
		this.productOfferingInstanceID = productOfferingInstanceID;
	}
	public String getProductOfferingName() {
		return productOfferingName;
	}
	public void setProductOfferingName(String productOfferingName) {
		this.productOfferingName = productOfferingName;
	}
	public String getProductLineOfBusiness() {
		return productLineOfBusiness;
	}
	public void setProductLineOfBusiness(String productLineOfBusiness) {
		this.productLineOfBusiness = productLineOfBusiness;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductServiceID() {
		return productServiceID;
	}
	public void setProductServiceID(String productServiceID) {
		this.productServiceID = productServiceID;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public BigDecimal getServiceRequiredDate() {
		return serviceRequiredDate;
	}
	public void setServiceRequiredDate(BigDecimal serviceRequiredDate) {
		this.serviceRequiredDate = serviceRequiredDate;
	}
	/*
	public OrderItemStatus getStatus() {
		return status;
	}
	public void setStatus(OrderItemStatus status) {
		this.status = status;
	}
	*/
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public ProductSpecificationBusinessType getBusinessType() {
		return businessType;
	}
	public void setBusinessType(ProductSpecificationBusinessType businessType) {
		this.businessType = businessType;
	}
	
	
	
}
