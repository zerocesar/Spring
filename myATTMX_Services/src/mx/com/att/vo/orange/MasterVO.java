package mx.com.att.vo.orange;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MasterVO")
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="customerId")
	private Long customerId;
	@XmlElement(name="masterPin")
	private String masterPin;
	@XmlElement(name="newMasterPin")
	private String newMasterPin;//masterAactualizar
	@XmlElement(name="codigoError")
	private String codigoError;
	@XmlElement(name="mensaje")
	private String mensaje;
	/**
	 * @return the masterPin
	 */
	public String getMasterPin() {
		return masterPin;
	}
	/**
	 * @param masterPin the masterPin to set
	 */
	public void setMasterPin(final String masterPin) {
		this.masterPin = masterPin;
	}
	/**
	 * @return the newMasterPin
	 */
	public String getNewMasterPin() {
		return newMasterPin;
	}
	/**
	 * @param newMasterPin the newMasterPin to set
	 */
	public void setNewMasterPin(final String newMasterPin) {
		this.newMasterPin = newMasterPin;
	}
	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(final Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the codigoError
	 */
	public String getCodigoError() {
		return codigoError;
	}
	/**
	 * @param codigoError the codigoError to set
	 */
	public void setCodigoError(final String codigoError) {
		this.codigoError = codigoError;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(final String mensaje) {
		this.mensaje = mensaje;
	}
}

