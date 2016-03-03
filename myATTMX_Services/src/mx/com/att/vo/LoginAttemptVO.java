package mx.com.att.vo;

import java.io.Serializable;
import java.util.List;

public class LoginAttemptVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long loginId; //loginId Id de login
	
	private String radioId; //ufmi numero de radio
	
	private String serialIdentifier; //serialIdentifier identificador serial del dispositivo
	
	private String equipmentDesc; //device descripcion del equipo
	
	private String myNextelVersion; //myNextelVersion version de miNextel
	
	private String osVersion; //osVersion version del S.O.
	
	private List<LoginAttemptTypeVO> loginAttemptType;

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(final long loginId) {
		this.loginId = loginId;
	}

	public String getRadioId() {
		return radioId;
	}

	public void setRadioId(final String radioId) {
		this.radioId = radioId;
	}

	public String getSerialIdentifier() {
		return serialIdentifier;
	}

	public void setSerialIdentifier(final String serialIdentifier) {
		this.serialIdentifier = serialIdentifier;
	}

	public String getEquipmentDesc() {
		return equipmentDesc;
	}

	public void setEquipmentDesc(final String equipmentDesc) {
		this.equipmentDesc = equipmentDesc;
	}

	public String getMyNextelVersion() {
		return myNextelVersion;
	}

	public void setMyNextelVersion(final String myNextelVersion) {
		this.myNextelVersion = myNextelVersion;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(final String osVersion) {
		this.osVersion = osVersion;
	}

	public List<LoginAttemptTypeVO> getLoginAttemptType() {
		return loginAttemptType;
	}

	public void setLoginAttemptType(final List<LoginAttemptTypeVO> loginAttemptType) {
		this.loginAttemptType = loginAttemptType;
	}
}