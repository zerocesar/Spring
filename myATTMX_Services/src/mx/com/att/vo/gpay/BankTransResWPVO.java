package mx.com.att.vo.gpay;

import java.io.Serializable;

public class BankTransResWPVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String acqResponseCode;

    private String authorizeId;

    private String batchNo;

    private String cardType;

    private long idCodeMessage;

    private String message;

    private String messageCode;

    private long orderId;

    private long receiptNo;

    private String resDate;

    private long txnNo;

    private String txnResponseCode;

	public String getAcqResponseCode() {
		return acqResponseCode;
	}

	public void setAcqResponseCode(final String acqResponseCode) {
		this.acqResponseCode = acqResponseCode;
	}

	public String getAuthorizeId() {
		return authorizeId;
	}

	public void setAuthorizeId(final String authorizeId) {
		this.authorizeId = authorizeId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(final String batchNo) {
		this.batchNo = batchNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(final String cardType) {
		this.cardType = cardType;
	}

	public long getIdCodeMessage() {
		return idCodeMessage;
	}

	public void setIdCodeMessage(final long idCodeMessage) {
		this.idCodeMessage = idCodeMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(final String messageCode) {
		this.messageCode = messageCode;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(final long orderId) {
		this.orderId = orderId;
	}

	public long getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(final long receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getResDate() {
		return resDate;
	}

	public void setResDate(final String resDate) {
		this.resDate = resDate;
	}

	public long getTxnNo() {
		return txnNo;
	}

	public void setTxnNo(final long txnNo) {
		this.txnNo = txnNo;
	}

	public String getTxnResponseCode() {
		return txnResponseCode;
	}

	public void setTxnResponseCode(final String txnResponseCode) {
		this.txnResponseCode = txnResponseCode;
	}
}