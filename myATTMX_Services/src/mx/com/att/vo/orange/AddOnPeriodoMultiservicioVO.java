package mx.com.att.vo.orange;

import java.io.Serializable;

/**@author Oliva Contreras Francisco Elias**/
public class AddOnPeriodoMultiservicioVO implements Serializable {
	
	/**@param serialVersionUID**/
	private static final long serialVersionUID = 1L;
	/**@param descripcion**/
	private String descripcion;
	/**@param id**/
	private String id;
	/**@param idPaquete**/
	private Double idPaquete;
	/**@param periodo**/
	private Double periodo;
	/**@param precioIVA11**/
	private Double precioIVA11;
	/**@param precioIVA16**/
	private Double precioIVA16;
	/**@param snCode**/
	private String snCode;
	/**@param spCode**/
	private String spCode;
	/**@param tipoUnida**/
	private String tipoUnida;
	/**@param tipoUnidad**/
	private String tipoUnidad;
	/**@param unidad**/
	private Double unidad;
	/**@param vigencia**/
	private Double vigencia;
	private String descripcionString;
	
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the idPaquete
	 */
	public Double getIdPaquete() {
		return idPaquete;
	}
	/**
	 * @return the periodo
	 */
	public Double getPeriodo() {
		return periodo;
	}
	/**
	 * @return the precioIVA11
	 */
	public Double getPrecioIVA11() {
		return precioIVA11;
	}
	/**
	 * @return the precioIVA16
	 */
	public Double getPrecioIVA16() {
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
	 * @return the tipoUnida
	 */
	public String getTipoUnida() {
		return tipoUnida;
	}
	/**
	 * @return the unidad
	 */
	public Double getUnidad() {
		return unidad;
	}
	/**
	 * @return the vigencia
	 */
	public Double getVigencia() {
		return vigencia;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
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
	public void setIdPaquete(final Double idPaquete) {
		this.idPaquete = idPaquete;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(final Double periodo) {
		this.periodo = periodo;
	}
	/**
	 * @param precioIVA11 the precioIVA11 to set
	 */
	public void setPrecioIVA11(final Double precioIVA11) {
		this.precioIVA11 = precioIVA11;
	}
	/**
	 * @param precioIVA16 the precioIVA16 to set
	 */
	public void setPrecioIVA16(final Double precioIVA16) {
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
	 * @param tipoUnida the tipoUnida to set
	 */
	public void setTipoUnida(final String tipoUnida) {
		this.tipoUnida = tipoUnida;
	}
	/**
	 * @param unidad the unidad to set
	 */
	public void setUnidad(final Double unidad) {
		this.unidad = unidad;
	}
	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(final Double vigencia) {
		this.vigencia = vigencia;
	}
	public String getTipoUnidad() {
		return tipoUnidad;
	}
	public void setTipoUnidad(final String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}	

	public String getDescripcionString() {
		return descripcionString;
	}
	
	public void setDescripcionString(final String tipoUnidad) {
		this.descripcionString = getDescripcion() + ": " + tipoUnidad;
	}
}
