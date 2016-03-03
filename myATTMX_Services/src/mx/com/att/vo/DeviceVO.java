package mx.com.att.vo;

import java.io.Serializable;

public class DeviceVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String telephoneNum; //mdn N�mero telef�nico
	
	private String equipmentDesc; //equipo:divece Descripci�n del equipo registrado en su contrato
	
	private String radioId; //codigo N�mero de radio
	
	public String getTelephoneNum() {
		return telephoneNum;
	}

	public void setTelephoneNum(final String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}

	public String getEquipmentDesc() {
		return equipmentDesc;
	}

	public void setEquipmentDesc(final String equipmentDesc) {
		this.equipmentDesc = equipmentDesc;
	}

	public String getRadioId() {
		return radioId;
	}

	public void setRadioId(final String radioId) {
		this.radioId = radioId;
	}
}