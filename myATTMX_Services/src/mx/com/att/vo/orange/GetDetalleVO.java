package mx.com.att.vo.orange;

import java.io.Serializable;

public class GetDetalleVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long ordenId;
	private String userMdn;
	private long amount;
	private String serviceRef;
	private long customerId;
	private String custCode;
	private long coId;
	private long commercialConfigId;
	private long lastOrderStatusId;
	private String statusName;
	private long serviceId;
	private long paymentId;
	private long serviceTypeId;
	private String serviceName;
	private String serviceDesc;
	private String paymentName;
	
	public long getOrdenId() {
		return ordenId;
	}
	public void setOrdenId(final long ordenId) {
		this.ordenId = ordenId;
	}
	public String getUserMdn() {
		return userMdn;
	}
	public void setUserMdn(final String userMdn) {
		this.userMdn = userMdn;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(final long amount) {
		this.amount = amount;
	}
	public String getServiceRef() {
		return serviceRef;
	}
	public void setServiceRef(final String serviceRef) {
		this.serviceRef = serviceRef;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(final long customerId) {
		this.customerId = customerId;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(final String custCode) {
		this.custCode = custCode;
	}
	public long getCoId() {
		return coId;
	}
	public void setCoId(final long coId) {
		this.coId = coId;
	}
	public long getCommercialConfigId() {
		return commercialConfigId;
	}
	public void setCommercialConfigId(final long commercialConfigId) {
		this.commercialConfigId = commercialConfigId;
	}
	public long getLastOrderStatusId() {
		return lastOrderStatusId;
	}
	public void setLastOrderStatusId(final long lastOrderStatusId) {
		this.lastOrderStatusId = lastOrderStatusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(final String statusName) {
		this.statusName = statusName;
	}
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(final long serviceId) {
		this.serviceId = serviceId;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(final long paymentId) {
		this.paymentId = paymentId;
	}
	public long getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(final long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(final String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDesc() {
		return serviceDesc;
	}
	public void setServiceDesc(final String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(final String paymentName) {
		this.paymentName = paymentName;
	}
}
