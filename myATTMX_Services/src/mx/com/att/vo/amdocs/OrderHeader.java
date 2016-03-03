package mx.com.att.vo.amdocs;

import java.math.BigDecimal;

public class OrderHeader {
	
	private LinkVO[]	link;
	private String description;
	private String externalID;
	private OrderItemHeader[]  orderItems;
	private RecurringPriceForOrder recurringPrice;
	private OneTimePriceForOrder oneTimePrice;
	private BigDecimal creationDate;
	private String currency;
	private String currentSalesChannel;
	private String id;
	private String originatingSalesChannel;
	private String referenceNumber;
	private BigDecimal serviceRequiredDate;
	//private OrderStatus status;
	private String reasonCode;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExternalID() {
		return externalID;
	}
	public void setExternalID(String externalID) {
		this.externalID = externalID;
	}
	public OrderItemHeader[] getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(OrderItemHeader[] orderItems) {
		this.orderItems = orderItems;
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
	public BigDecimal getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(BigDecimal creationDate) {
		this.creationDate = creationDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCurrentSalesChannel() {
		return currentSalesChannel;
	}
	public void setCurrentSalesChannel(String currentSalesChannel) {
		this.currentSalesChannel = currentSalesChannel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriginatingSalesChannel() {
		return originatingSalesChannel;
	}
	public void setOriginatingSalesChannel(String originatingSalesChannel) {
		this.originatingSalesChannel = originatingSalesChannel;
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
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	*/
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	
	

}
