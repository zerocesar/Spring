package mx.com.att.dao.orange;

import java.io.Serializable;

public class PaymentTypeWPVO implements Serializable{
private final static long serialVersionUID = 1L;
	
	private long commercialConfigId = 0L;
	private long paymentId = 0L;
	private String paymName = "";
	private String paymDescription = "";
	private long idCodeMessage = 0L;
	private String messageCode;

	public long getCommercialConfigId() {
		return commercialConfigId;
	}
	public void setCommercialConfigId(final long commercialConfigId) {
		this.commercialConfigId = commercialConfigId;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(final long paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymName() {
		return paymName;
	}
	public void setPaymName(final String paymName) {
		this.paymName = paymName;
	}
	public String getPaymDescription() {
		return paymDescription;
	}
	public void setPaymDescription(final String paymDescription) {
		this.paymDescription = paymDescription;
	}
	public long getIdCodeMessage() {
		return idCodeMessage;
	}
	public void setIdCodeMessage(final long idCodeMessage) {
		this.idCodeMessage = idCodeMessage;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(final String messageCode) {
		this.messageCode = messageCode;
	}
}