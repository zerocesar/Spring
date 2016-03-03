package mx.com.att.vo.orange;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MasterPINLog")
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterPINLogVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@XmlElement(name="account")
	private String custCode;
	
	@XmlElement(name="recoveryAttempts")
	private int recoveryAttempts;
	@XmlElement(name="lastRecoveryDate")
	private String lastRecoveryDate = "";
	@XmlElement(name="recoveryBlockedBy")
	private String recoveryBlockedBy = "";
	@XmlElement(name="isRecoveryBlocked")
	private String isRecoveryBlocked;
	@XmlElement(name="validationAttempts")	
	private int validationAttempts;
	@XmlElement(name="lastValidationDate")
	private String lastValidationDate = "";
	@XmlElement(name="validationBlockedBy")
	private String validationBlockedBy = "";
	@XmlElement(name="isValidationBlocked")
	private String isValidationBlocked;
	
	public MasterPINLogVO(){}
	
	public MasterPINLogVO(final String custCode){
		this.custCode = custCode;
	}
	
	public String getRecoveryBlocked() {
		return isRecoveryBlocked;
	}

	public void setRecoveryBlocked(final String isRecoveryBlocked) {
		this.isRecoveryBlocked = isRecoveryBlocked;
	}

	public String getValidationBlocked() {
		return isValidationBlocked;
	}

	public void setValidationBlocked(final String isValidationBlocked) {
		this.isValidationBlocked = isValidationBlocked;
	}

	public String getCustCode() {
		return custCode;
	}
	
	public void setCustCode(final String custCode) {
		this.custCode = custCode;
	}
	
	public int getRecoveryAttempts() {
		return recoveryAttempts;
	}
	
	public void setRecoveryAttempts(final  int recoveryAttempts) {
		this.recoveryAttempts = recoveryAttempts;
	}
	
	public String getLastRecoveryDate() {
		return lastRecoveryDate;
	}
	
	public void setLastRecoveryDate(final String lastRecoveryDate) {
		this.lastRecoveryDate = lastRecoveryDate;
	}
	
	public String getRecoveryBlockedBy() {
		return recoveryBlockedBy;
	}
	
	public void setRecoveryBlockedBy(final String recoveryBlockedBy) {
		this.recoveryBlockedBy = recoveryBlockedBy;
	}
	
	public int getValidationAttempts() {
		return validationAttempts;
	}
	
	public void setValidationAttempts(final  int validationAttempts) {
		this.validationAttempts = validationAttempts;
	}
	
	public String getLastValidationDate() {
		return lastValidationDate;
	}
	
	public void setLastValidationDate(final  String lastValidationDate) {
		this.lastValidationDate = lastValidationDate;
	}
	
	public String getValidationBlockedBy() {
		return validationBlockedBy;
	}
	
	public void setValidationBlockedBy(final  String validationBlockedBy) {
		this.validationBlockedBy = validationBlockedBy;
	}
	
}
