package mx.com.att.vo.orange;

import java.io.Serializable;

public class ServiceWPVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long idCodeMessage;
	private boolean inFamily;
	private String messageCode;
	private String servDescription;
	private long serviceId;
	private long serviceTypeId;
	private String servName;
	private String servSncode;
	private String servSpcode;
	private String servTypeAccessCode;
	private String servTypeDescription;
	private String servTypeMerchantId;
	private String servTypeName;
	private String servTypeSecretHash;
	
	public long getIdCodeMessage() {
		return idCodeMessage;
	}
	public void setIdCodeMessage(long idCodeMessage) {
		this.idCodeMessage = idCodeMessage;
	}
	public boolean isInFamily() {
		return inFamily;
	}
	public void setInFamily(boolean inFamily) {
		this.inFamily = inFamily;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getServDescription() {
		return servDescription;
	}
	public void setServDescription(String servDescription) {
		this.servDescription = servDescription;
	}
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public long getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	public String getServName() {
		return servName;
	}
	public void setServName(String servName) {
		this.servName = servName;
	}
	public String getServSncode() {
		return servSncode;
	}
	public void setServSncode(String servSncode) {
		this.servSncode = servSncode;
	}
	public String getServSpcode() {
		return servSpcode;
	}
	public void setServSpcode(String servSpcode) {
		this.servSpcode = servSpcode;
	}
	public String getServTypeAccessCode() {
		return servTypeAccessCode;
	}
	public void setServTypeAccessCode(String servTypeAccessCode) {
		this.servTypeAccessCode = servTypeAccessCode;
	}
	public String getServTypeDescription() {
		return servTypeDescription;
	}
	public void setServTypeDescription(String servTypeDescription) {
		this.servTypeDescription = servTypeDescription;
	}
	public String getServTypeMerchantId() {
		return servTypeMerchantId;
	}
	public void setServTypeMerchantId(String servTypeMerchantId) {
		this.servTypeMerchantId = servTypeMerchantId;
	}
	public String getServTypeName() {
		return servTypeName;
	}
	public void setServTypeName(String servTypeName) {
		this.servTypeName = servTypeName;
	}
	public String getServTypeSecretHash() {
		return servTypeSecretHash;
	}
	public void setServTypeSecretHash(String servTypeSecretHash) {
		this.servTypeSecretHash = servTypeSecretHash;
	}
	
}
