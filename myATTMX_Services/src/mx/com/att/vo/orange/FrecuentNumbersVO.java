package mx.com.att.vo.orange;

import java.io.Serializable;

public class FrecuentNumbersVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String systemId;
	private String dn;
	private String code;
	private String messageCode;
	private String authorizationNumber;
	private FrecuentNumbersVO[] frecuentNumbers;
	private boolean canChange = true;
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
	public String getAuthorizationNumber() {
		return authorizationNumber;
	}
	public void setAuthorizationNumber(final String authorizationNumber) {
		this.authorizationNumber = authorizationNumber;
	}
	public FrecuentNumbersVO[] getFrecuentNumbers() {
		if( frecuentNumbers instanceof FrecuentNumbersVO[] ){
			return (FrecuentNumbersVO[]) frecuentNumbers.clone();
		} else{
			return new FrecuentNumbersVO[0];
		}
	}
	public void setFrecuentNumbers(final FrecuentNumbersVO[] frecuentNumbers) {
		if( frecuentNumbers instanceof FrecuentNumbersVO[] ){
			this.frecuentNumbers = (FrecuentNumbersVO[]) frecuentNumbers.clone();
		} else{
			this.frecuentNumbers = new FrecuentNumbersVO[0];
		}
	}
	public boolean isCanChange() {
		return canChange;
	}
	public void setCanChange(final boolean canChange) {
		this.canChange = canChange;
	}
}
