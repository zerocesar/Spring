package mx.com.att.vo.orange;

import java.io.Serializable;

public class AddOnUnidadVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**@param id**/
	private String id;
	/**@param idPaquete**/
	private double idPaquete;
	/**@param precioIVA11**/
	private double precioIVA11;
	/**@param precioIVA16**/
	private double precioIVA16;
	/**@param snCode**/
	private String snCode;
	/**@param spCode**/
	private String spCode;
	/**@param tipoUnidad**/
	private String tipoUnidad;
	/**@param unidad**/
	private double unidad;
	/**@param vigencia**/
	private double vigencia;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the idPaquete
	 */
	public double getIdPaquete() {
		return idPaquete;
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
	 * @return the tipoUnidad
	 */
	public String getTipoUnidad() {
		return tipoUnidad;
	}
	/**
	 * @return the unidad
	 */
	public double getUnidad() {
		return unidad;
	}
	/**
	 * @return the vigencia
	 */
	public double getVigencia() {
		return vigencia;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}
	/**
	 * @param idPaquete the idPaquete to set
	 */
	public void setIdPaquete(final double idPaquete) {
		this.idPaquete = idPaquete;
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
	/**
	 * @param tipoUnidad the tipoUnidad to set
	 */
	public void setTipoUnidad(final String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}
	/**
	 * @param unidad the unidad to set
	 */
	public void setUnidad(final double unidad) {
		this.unidad = unidad;
	}
	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(final double vigencia) {
		this.vigencia = vigencia;
	}
}
