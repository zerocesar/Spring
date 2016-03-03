package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ChangeProductSatusInputVO implements Serializable{

	private static final long serialVersionUID = 1L;
	public String reasonCode;
	public String changeStatusRequestedDate;
	public String externalUserID;
	public String externalUserOrg;
	
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(final String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getChangeStatusRequestedDate() {
		return changeStatusRequestedDate;
	}
	public void setChangeStatusRequestedDate(final String changeStatusRequestedDate) {
		this.changeStatusRequestedDate = changeStatusRequestedDate;
	}
	public String getExternalUserID() {
		return externalUserID;
	}
	public void setExternalUserID(final String externalUserID) {
		this.externalUserID = externalUserID;
	}
	public String getExternalUserOrg() {
		return externalUserOrg;
	}
	public void setExternalUserOrg(final String externalUserOrg) {
		this.externalUserOrg = externalUserOrg;
	}
	
	
	
	
	
}