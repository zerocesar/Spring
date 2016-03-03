package mx.com.att.vo;

import java.io.Serializable;

public class PaymentRespVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long customerId; //customerId Id del cliente
	
	private String customerCode; //custCode Número de cuenta del cliente
	
	private String masterPIN; //smcId masterPIN
	
	private String nombreCompleto;
	
	private String email;
	
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(final String user) {
		this.user = user;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(final String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(final Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(final String customerCode) {
		this.customerCode = customerCode;
	}

	public String getMasterPIN() {
		return masterPIN;
	}

	public void setMasterPIN(final String masterPIN) {
		this.masterPIN = masterPIN;
	}
}