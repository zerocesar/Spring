package mx.com.att.vo.orange;

import java.io.Serializable;

public class TicketInfoWPVO implements Serializable {
private final static long serialVersionUID = 1L;
	
	private long orderId;
	private String statusDate;
	private long serviceTypeId;
	private String serviceType;
	private String paymentOption;
	private String operationNumber;
	private String referenceNumber;
	private String orderInfo;
	private long folioCci;
	private double amountOrder;
	private String txnResponseCode;
	private String txnResponseCodeDesc;
	private String message;
	private String acqResponseCode;
	private long txnNo;
	private long receiptNo;
	private String authorizeId;
	private long batchNo;
	private String cardType;
	private String serviceRef;
	private long idCodeMessage;
	private String messageCode;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}
	public long getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public String getOperationNumber() {
		return operationNumber;
	}
	public void setOperationNumber(String operationNumber) {
		this.operationNumber = operationNumber;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}
	public long getFolioCci() {
		return folioCci;
	}
	public void setFolioCci(long folioCci) {
		this.folioCci = folioCci;
	}
	public double getAmountOrder() {
		return amountOrder;
	}
	public void setAmountOrder(double amountOrder) {
		this.amountOrder = amountOrder;
	}
	public String getTxnResponseCode() {
		return txnResponseCode;
	}
	public void setTxnResponseCode(String txnResponseCode) {
		this.txnResponseCode = txnResponseCode;
	}
	public String getTxnResponseCodeDesc() {
		return txnResponseCodeDesc;
	}
	public void setTxnResponseCodeDesc(String txnResponseCodeDesc) {
		this.txnResponseCodeDesc = txnResponseCodeDesc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAcqResponseCode() {
		return acqResponseCode;
	}
	public void setAcqResponseCode(String acqResponseCode) {
		this.acqResponseCode = acqResponseCode;
	}
	public long getTxnNo() {
		return txnNo;
	}
	public void setTxnNo(long txnNo) {
		this.txnNo = txnNo;
	}
	public long getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(long receiptNo) {
		this.receiptNo = receiptNo;
	}
	public String getAuthorizeId() {
		return authorizeId;
	}
	public void setAuthorizeId(String authorizeId) {
		this.authorizeId = authorizeId;
	}
	public long getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(long batchNo) {
		this.batchNo = batchNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getServiceRef() {
		return serviceRef;
	}
	public void setServiceRef(String serviceRef) {
		this.serviceRef = serviceRef;
	}
	public long getIdCodeMessage() {
		return idCodeMessage;
	}
	public void setIdCodeMessage(long idCodeMessage) {
		this.idCodeMessage = idCodeMessage;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String toString(){
		return "orderId: "+orderId+" \n" +
				"statusDate: "+statusDate+"\n" +
				"serviceTypeId: "+serviceTypeId+"\n" +
				"serviceType: "+serviceType+" \n" +
				"paymentOption: "+paymentOption+" \n" +
				"operationNumber: "+operationNumber+" \n" +
				"referenceNumber: "+referenceNumber+" \n" +
				"orderInfo: "+orderInfo+"\n" +
				"folioCci: "+folioCci +"\n" +
				"amountOrder: "+amountOrder +"\n" +
				"txnResponseCode: "+txnResponseCode+" \n" +
				"txnResponseCodeDesc: "+txnResponseCodeDesc+"\n" +
				"message: "+message+"\n" +
				"acqResponseCode: "+acqResponseCode+"\n" + 
				"txnNo: "+txnNo+"\n" + 
				"receiptNo: "+receiptNo+"\n" +
				"authorizeId: "+authorizeId+"\n" +
				"batchNo: "+batchNo+"\n" +
				"cardType: "+cardType+"\n" +
				"serviceRef"+serviceRef+"\n" +
				"idCodeMessage: "+idCodeMessage+"\n" +
				"messageCode: "+messageCode+"\n";
	}
}
