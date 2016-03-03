package mx.com.att.vo.orange;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="AddOnPeriodoVO")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddOnPeriodoVO implements Serializable {

	/**@param serialVersionUID**/
	private static final long serialVersionUID = 1L;
	/**@param id**/
	@XmlElement(name="id")
	private String id;
	/**@param idMercado**/
	@XmlElement(name="idMercado")
	private double idMercado;
	/**@param periodo**/
	@XmlElement(name="periodo")
	private double periodo;
	/**@param precioIVA11**/
	@XmlElement(name="precioIVA11")
	private double precioIVA11;
	/**@param precioIVA16**/
	@XmlElement(name="precioIVA16")
	private double precioIVA16;
	/**@param snCode**/
	@XmlElement(name="snCode")
	private String snCode;
	/**@param spCode**/
	@XmlElement(name="spCode")
	private String spCode;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the idMercado
	 */
	public double getIdMercado() {
		return idMercado;
	}
	/**
	 * @return the periodo
	 */
	public double getPeriodo() {
		return periodo;
	}
	/**
	 * @return the precioIVA11
	 */
	public double getPrecioIVA11() {
		return precioIVA11;
	}
	/**
	 * @return the precioIVA16
	 */
	public double getPrecioIVA16() {
		return precioIVA16;
	}
	/**
	 * @return the snCode
	 */
	public String getSnCode() {
		return snCode;
	}
	/**
	 * @return the spCode
	 */
	public String getSpCode() {
		return spCode;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}
	/**
	 * @param idMercado the idMercado to set
	 */
	public void setIdMercado(final double idMercado) {
		this.idMercado = idMercado;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(final double periodo) {
		this.periodo = periodo;
	}
	/**
	 * @param precioIVA11 the precioIVA11 to set
	 */
	public void setPrecioIVA11(final double precioIVA11) {
		this.precioIVA11 = precioIVA11;
	}
	/**
	 * @param precioIVA16 the precioIVA16 to set
	 */
	public void setPrecioIVA16(final double precioIVA16) {
		this.precioIVA16 = precioIVA16;
	}
	/**
	 * @param snCode the snCode to set
	 */
	public void setSnCode(final String snCode) {
		this.snCode = snCode;
	}
	/**
	 * @param spCode the spCode to set
	 */
	public void setSpCode(final String spCode) {
		this.spCode = spCode;
	}
}
