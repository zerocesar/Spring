package mx.com.att.vo.orange;

public class RechargeVO {
	
	private String id;
	private  String systemId;
	private  String dn;
	private Double amount;
	private Integer paymentId ;
	private String authorizationNumber;
	private String code;
	private String messageCode;
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(final String systemId) {
		this.systemId = systemId;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(final String dn) {
		this.dn = dn;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(final Double amount) {
		this.amount = amount;
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(final Integer paymentId) {
		this.paymentId = paymentId;
	}
	public String getAuthorizationNumber() {
		return authorizationNumber;
	}
	public void setAuthorizationNumber(final String authorizationNumber) {
		this.authorizationNumber = authorizationNumber;
	}
	public String getCode() {
		return code;
	}
	public void setCode(final String code) {
		this.code = code;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(final String messageCode) {
		this.messageCode = messageCode;
	}
}