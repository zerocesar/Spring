package mx.com.att.vo.orange;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MasterPin")
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterPinVO implements Serializable   {

	
	private static final long serialVersionUID = 1L;
	@XmlElement(name="customerId")
	private Long customerId;
	@XmlElement(name="master")
	private String master;
	@XmlElement(name="codigoError")
	private String codigoError;
	@XmlElement(name="mensaje")
	private String mensaje;
	@XmlElement(name="dn")
	private String dn;
	@XmlElement(name="userPassword")
	private String userPassword;
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
	 * @return the master
	 */
	public String getMaster() {
		return master;
	}
	/**
	 * @param master the master to set
	 */
	public void setMaster(final String master) {
		this.master = master;
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
	/**
	 * @return the dn
	 */
	public String getDn() {
		return dn;
	}
	/**
	 * @param dn the dn to set
	 */
	public void setDn(final String dn) {
		this.dn = dn;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
	
			
}
