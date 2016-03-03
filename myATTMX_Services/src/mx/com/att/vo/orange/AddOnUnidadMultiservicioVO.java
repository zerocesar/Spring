package mx.com.att.vo.orange;

import java.io.Serializable;
import java.text.DecimalFormat;
/**@author Oliva Contreras Francisco Elias**/
public class AddOnUnidadMultiservicioVO implements Serializable {
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
	/**@param tipoUnidad**/
	private String tipoUnidad;
	/**@param Unidad**/
	private Double unidad;
	/**@param vigencia**/
	private Double vigencia;
	private String mensajeString;
	
	
	/**
	* Getter getDescripcion 
	* @return String 
	*/
	public String getDescripcion() {
		return descripcion;
	}
	/**
	* Getter getId 
	* @return String 
	*/
	public String getId() {
		return id;
	}
	/**
	* Getter getIdPaquete 
	* @return Double 
	*/
	public Double getIdPaquete() {
		return idPaquete;
	}
	/**
	* Getter getPeriodo 
	* @return Double 
	*/
	public Double getPeriodo() {
		return periodo;
	}
	/**
	* Getter getPrecioIVA11 
	* @return Double 
	*/
	public Double getPrecioIVA11() {
		return precioIVA11;
	}
	/**
	* Getter getPrecioIVA16 
	* @return Double 
	*/
	public Double getPrecioIVA16() {
		return precioIVA16;
	}
	/**
	* Getter getSnCode 
	* @return String 
	*/
	public String getSnCode() {
		return snCode;
	}
	/**
	* Getter getSpCode 
	* @return String 
	*/
	public String getSpCode() {
		return spCode;
	}
	/**
	* Getter getTipoUnidad 
	* @return String 
	*/
	public String getTipoUnidad() {
		return tipoUnidad;
	}
	/**
	* Getter getUnidad 
	* @return Double 
	*/
	public Double getUnidad() {
		return unidad;
	}
	/**
	* Getter getVigencia 
	* @return Double 
	*/
	public Double getVigencia() {
		return vigencia;
	}
	/**
	* Setter setDescripcion
	* @param String  
	*/
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	* Setter setId
	* @param String  
	*/
	public void setId(final String id) {
		this.id = id;
	}
	/**
	* Setter setIdPaquete
	* @param Double  
	*/
	public void setIdPaquete(final Double idPaquete) {
		this.idPaquete = idPaquete;
	}
	/**
	* Setter setPeriodo
	* @param Double  
	*/
	public void setPeriodo(final Double periodo) {
		this.periodo = periodo;
	}
	/**
	* Setter setPrecioIVA11
	* @param Double  
	*/
	public void setPrecioIVA11(final Double precioIVA11) {
		this.precioIVA11 = precioIVA11;
	}
	/**
	* Setter setPrecioIVA16
	* @param Double  
	*/
	public void setPrecioIVA16(final Double precioIVA16) {
		this.precioIVA16 = precioIVA16;
	}
	/**
	* Setter setSnCode
	* @param String  
	*/
	public void setSnCode(final String snCode) {
		this.snCode = snCode;
	}
	/**
	* Setter setSpCode
	* @param String  
	*/
	public void setSpCode(final String spCode) {
		this.spCode = spCode;
	}
	/**
	* Setter setTipoUnidad
	* @param String  
	*/
	public void setTipoUnidad(final String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}
	/**
	* Setter setUnidad
	* @param Double  
	*/
	public void setUnidad(final Double unidad) {
		this.unidad = unidad;
	}
	/**
	* Setter setVigencia
	* @param Double  
	*/
	public void setVigencia(final Double vigencia) {
		this.vigencia = vigencia;
	}
	
	public String getMensajeString() {
		return mensajeString;
	}
	
	public void setMensajeString(final String descripcion, final Double unidad, final String tipoUnidad) {
		final DecimalFormat decimalFormat = new DecimalFormat("###,##0");
		final int valorIlimitado = 5000;
		if (descripcion.equalsIgnoreCase("Llamadas")){
			this.mensajeString = "Doble tiempo aire para llamadas a México, EU y Canadá: $" + decimalFormat.format(unidad);
		} else if (unidad == null || unidad < 1){
			this.mensajeString = "Unidad: Sin unidades";
		} else if (unidad > valorIlimitado){
			this.mensajeString = "Unidad: ILIMITADO";
		} else{ 
			this.mensajeString = descripcion + " Unidad: " + decimalFormat.format(unidad) + " " + tipoUnidad;
		}
	}
}
