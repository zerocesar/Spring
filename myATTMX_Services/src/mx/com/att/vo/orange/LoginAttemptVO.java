package mx.com.att.vo.orange;

import java.io.Serializable;
import java.util.List;

public class LoginAttemptVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long loginId;
	private String ufmi;
	private String serialIdentifier;
	private String device;
	private String miNextelVersion;
	private String osVersion;
	private List<LoginAttemptTypeVO> loginAttemptType;
	
	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(final long loginId) {
		this.loginId = loginId;
	}

	public String getUfmi() {
		return ufmi;
	}

	public void setUfmi(final String ufmi) {
		this.ufmi = ufmi;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(final String device) {
		this.device = device;
	}

	public String getMiNextelVersion() {
		return miNextelVersion;
	}

	public void setMiNextelVersion(final String miNextelVersion) {
		this.miNextelVersion = miNextelVersion;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(final String osVersion) {
		this.osVersion = osVersion;
	}
	
	public String getSerialIdentifier() {
		return serialIdentifier;
	}

	public void setSerialIdentifier(final String serialIdentifier) {
		this.serialIdentifier = serialIdentifier;
	}
	
	public List<LoginAttemptTypeVO> getLoginAttemptType() {
		return loginAttemptType;
	}

	public void setLoginAttemptType(final List<LoginAttemptTypeVO> loginAttemptType) {
		this.loginAttemptType = loginAttemptType;
	}
}