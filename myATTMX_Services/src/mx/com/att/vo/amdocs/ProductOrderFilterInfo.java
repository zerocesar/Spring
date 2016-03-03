package mx.com.att.vo.amdocs;

import java.util.Date;


public class ProductOrderFilterInfo {
	
	
	private LinkVO[]	link;
	private String createdBy;
	private Date minOrderCreationDate;
	private String orderID;
	private String originalSalesChannel;
	private String[] productServiceIDs;
	private String referenceNumber;
	//private OrderStatus[] statuses;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getMinOrderCreationDate() {
		return minOrderCreationDate;
	}
	public void setMinOrderCreationDate(final Date minOrderCreationDate) {
		this.minOrderCreationDate = minOrderCreationDate;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(final String orderID) {
		this.orderID = orderID;
	}
	public String getOriginalSalesChannel() {
		return originalSalesChannel;
	}
	public void setOriginalSalesChannel(final String originalSalesChannel) {
		this.originalSalesChannel = originalSalesChannel;
	}
	public String[] getProductServiceIDs() {
		return productServiceIDs;
	}
	public void setProductServiceIDs(final String[] productServiceIDs) {
		this.productServiceIDs = productServiceIDs;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(final String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	/*
	public OrderStatus[] getStatuses() {
		return statuses;
	}
	public void setStatuses(final OrderStatus[] statuses) {
		this.statuses = statuses;
	}
	*/
	

}
