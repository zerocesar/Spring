package mx.com.att.vo.orange;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="datosCuenta")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatosCuentaVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(name="custcode")
	private String custcode;
	@XmlElement(name="customerId")
	private String customerId;
	@XmlElement(name="fechaFactura")
	private String fechaFactura;
	@XmlElement(name="nombreTabla")
	private String nombreTabla;
	/**
	 * @return the custcode
	 */
	public String getCustcode() {
		return custcode;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @return the fechaFactura
	 */
	public String getFechaFactura() {
		return fechaFactura;
	}
	/**
	 * @return the nombreTabla
	 */
	public String getNombreTabla() {
		return nombreTabla;
	}
	/**
	 * @param custcode the custcode to set
	 */
	public void setCustcode(final String custcode) {
		this.custcode = custcode;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(final String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @param fechaFactura the fechaFactura to set
	 */
	public void setFechaFactura(final String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	/**
	 * @param nombreTabla the nombreTabla to set
	 */
	public void setNombreTabla(final String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	
}
