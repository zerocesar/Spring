package mx.com.att.vo;

import java.io.Serializable;

public class DeviceVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String telephoneNum; //mdn Número telefónico
	
	private String equipmentDesc; //equipo:divece Descripción del equipo registrado en su contrato
	
	private String radioId; //codigo Número de radio
	
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