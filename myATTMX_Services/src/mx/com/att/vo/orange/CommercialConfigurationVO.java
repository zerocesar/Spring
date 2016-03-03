package mx.com.att.vo.orange;

import java.io.Serializable;

public class CommercialConfigurationVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long commercialConfigId;
	private long channelId;
	private long serviceId;
	private long serviceTypeId;
	private long contractTypeId;
	private long paymentId;
	private long technologyTypeId;
	private String newPaymentType;
	private String status;
	private String regDate;
	private String regUser;
	private String modDate;
	private String modUser;
	private String servName;
	private String servDescription;
	private String paymName;
	private String paymDescription;
	private String servTypeName;
	private String servTypeDescription;
	private String servTypeSecretHash;
	private String servTypeAccessCode;
	private String servTypeMerchantId;
	private String contName;
	private String contDescription;
	private String chanName;
	private String chanDescription;
	private String prefix;
	private long idCodeMessage=0L;
	private String messageCode;
	private String dn;
	
	public String getDn() {
		return dn;
	}
	public void setDn(final String dn) {
		this.dn = dn;
	}
	public long getCommercialConfigId() {
		return commercialConfigId;
	}
	public void setCommercialConfigId(final long commercialConfigId) {
		this.commercialConfigId = commercialConfigId;
	}
	public long getChannelId() {
		return channelId;
	}
	public void setChannelId(final long channelId) {
		this.channelId = channelId;
	}
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(final long serviceId) {
		this.serviceId = serviceId;
	}
	public long getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(final long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	public long getContractTypeId() {
		return contractTypeId;
	}
	public void setContractTypeId(final long contractTypeId) {
		this.contractTypeId = contractTypeId;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(final long paymentId) {
		this.paymentId = paymentId;
	}
	public long getTechnologyTypeId() {
		return technologyTypeId;
	}
	public void setTechnologyTypeId(final long technologyTypeId) {
		this.technologyTypeId = technologyTypeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(final String status) {
		this.status = status;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(final String regDate) {
		this.regDate = regDate;
	}
	public String getRegUser() {
		return regUser;
	}
	public void setRegUser(final String regUser) {
		this.regUser = regUser;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(final String modDate) {
		this.modDate = modDate;
	}
	public String getModUser() {
		return modUser;
	}
	public void setModUser(final String modUser) {
		this.modUser = modUser;
	}
	public String getServName() {
		return servName;
	}
	public void setServName(final String servName) {
		this.servName = servName;
	}
	public String getServDescription() {
		return servDescription;
	}
	public void setServDescription(final String servDescription) {
		this.servDescription = servDescription;
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
	public String getServTypeName() {
		return servTypeName;
	}
	public void setServTypeName(final String servTypeName) {
		this.servTypeName = servTypeName;
	}
	public String getServTypeDescription() {
		return servTypeDescription;
	}
	public void setServTypeDescription(final String servTypeDescription) {
		this.servTypeDescription = servTypeDescription;
	}
	public String getServTypeSecretHash() {
		return servTypeSecretHash;
	}
	public void setServTypeSecretHash(final String servTypeSecretHash) {
		this.servTypeSecretHash = servTypeSecretHash;
	}
	public String getServTypeAccessCode() {
		return servTypeAccessCode;
	}
	public void setServTypeAccessCode(final String servTypeAccessCode) {
		this.servTypeAccessCode = servTypeAccessCode;
	}
	public String getServTypeMerchantId() {
		return servTypeMerchantId;
	}
	public void setServTypeMerchantId(final String servTypeMerchantId) {
		this.servTypeMerchantId = servTypeMerchantId;
	}
	public String getContName() {
		return contName;
	}
	public void setContName(final String contName) {
		this.contName = contName;
	}
	public String getContDescription() {
		return contDescription;
	}
	public void setContDescription(final String contDescription) {
		this.contDescription = contDescription;
	}
	public String getChanName() {
		return chanName;
	}
	public void setChanName(final String chanName) {
		this.chanName = chanName;
	}
	public String getChanDescription() {
		return chanDescription;
	}
	public void setChanDescription(final String chanDescription) {
		this.chanDescription = chanDescription;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(final String prefix) {
		this.prefix = prefix;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNewPaymentType() {
		return newPaymentType;
	}
	public void setNewPaymentType(final String newPaymentType) {
		this.newPaymentType = newPaymentType;
	}
	
	
	
}
