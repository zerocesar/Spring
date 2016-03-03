package mx.com.att.vo.orange;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="AddOn")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddOnVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name="addOnParamVO")
	private AddOnParamVO[] addOnParamVO;
	@XmlElement(name="addOnPeriodoVO")
	private AddOnPeriodoVO[] addOnPeriodoVO;
	@XmlElement(name="addOnUnidadVO")
	private AddOnUnidadVO[] addOnUnidadVO;
	@XmlElement(name="addOnPeriodoMultiservicioVO")
	private AddOnPeriodoMultiservicioVO[] addOnPeriodoMultiservicioVO;
	@XmlElement(name="addOnUnidadMultiservicioVO")
	private AddOnUnidadMultiservicioVO[] addOnUnidadMultiservicioVO;
	@XmlElement(name="descripcion")
	private String descripcion;
	@XmlElement(name="id")
	private String id;
	@XmlElement(name="idMercado")
	private String idMercado;
	@XmlElement(name="idPaquete")
	private String idPaquete;
	@XmlElement(name="idPlataforma")
	private String idPlataforma;
	@XmlElement(name="isMultiservicio")
	private Boolean isMultiservicio;
	@XmlElement(name="precioPaquete")
	private Double precioPaquete;
	@XmlElement(name="precioPaqueteString")
	private String precioPaqueteString;
	@XmlElement(name="snCode")
	private String snCode;
	@XmlElement(name="spCode")
	private String spCode;
	@XmlElement(name="tipo")
	private String tipo;
	@XmlElement(name="tmCode")
	private String tmCode;
	@XmlElement(name="vigenciaPaquete")
	private Double vigenciaPaquete;
	@XmlElement(name="vigenciaPaqueteString")
	private String vigenciaPaqueteString;
	
	
	/*###############*/
	public AddOnParamVO[] getAddOnParamVO() {
		if( addOnParamVO != null ){
			return (AddOnParamVO[]) addOnParamVO.clone();
		} else{
			return new AddOnParamVO[0];
		}
	}
	public AddOnParamVO getAddOnParamVO(final int iParam) {
		return addOnParamVO[iParam];
	}
	public void setAddOnParamVO(final AddOnParamVO[] addOnParamVO) {
		if( addOnParamVO instanceof AddOnParamVO[]){
			this.addOnParamVO = (AddOnParamVO[])addOnParamVO.clone();
		} else{
			this.addOnParamVO = new AddOnParamVO[0];
		}
	}
	public void setAddOnParamVO(final int iNumber,final AddOnParamVO addOnParamVO) {
		this.addOnParamVO[iNumber] = addOnParamVO;
	}
	 /*###############*/
	public AddOnPeriodoVO[] getAddOnPeriodoVO() {
		if( addOnPeriodoVO instanceof AddOnPeriodoVO[] ){
			return (AddOnPeriodoVO[]) addOnPeriodoVO.clone();
		} else{
			return new AddOnPeriodoVO[0];
		}
	}
	public AddOnPeriodoVO getAddOnPeriodoVO(final int iParam){
		return addOnPeriodoVO[iParam];
	}
	public void setAddOnPeriodoVO(final AddOnPeriodoVO[] addOnPeriodoVO) {
		if( addOnPeriodoVO instanceof AddOnPeriodoVO[]){
			this.addOnPeriodoVO = (AddOnPeriodoVO [])addOnPeriodoVO.clone();
		} else{
			this.addOnPeriodoVO = new AddOnPeriodoVO[0];
		}
	}
	public void setAddOnVO(final int iNumber, final AddOnPeriodoVO addOnPeriodoVO) {
		this.addOnPeriodoVO[iNumber] = addOnPeriodoVO;
	}
	/*#############*/
	public AddOnUnidadVO[] getAddOnUnidadVO() {
		if( addOnUnidadVO instanceof AddOnUnidadVO[]){
			return (AddOnUnidadVO[]) addOnUnidadVO.clone();
		} else{
			return new AddOnUnidadVO[0];
		}
	}
	public AddOnUnidadVO getAddOnUnidadVO(final int iParam){
		return addOnUnidadVO[iParam]; 
	}
	public void setAddOnUnidadVO(final AddOnUnidadVO[] addOnUnidadVO) {
		if( addOnUnidadVO instanceof AddOnUnidadVO[] ){
			this.addOnUnidadVO = (AddOnUnidadVO[]) addOnUnidadVO.clone();
		} else{
			this.addOnUnidadVO = new AddOnUnidadVO[0];
		}
	}
	public void setAddOnUnidadVO(final int iParam, final AddOnUnidadVO addOnUnidadVO) {
		this.addOnUnidadVO[iParam] = addOnUnidadVO;
	}
	/*##############*/
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getIdMercado() {
		return idMercado;
	}
	public void setIdMercado(final String idMercado) {
		this.idMercado = idMercado;
	}
	public String getIdPlataforma() {
		return idPlataforma;
	}
	public void setIdPlataforma(final String idPlataforma) {
		this.idPlataforma = idPlataforma;
	}
	public String getSnCode() {
		return snCode;
	}
	public void setSnCode(final String snCode) {
		this.snCode = snCode;
	}
	public String getSpCode() {
		return spCode;
	}
	public void setSpCode(final String spCode) {
		this.spCode = spCode;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}
	public AddOnPeriodoMultiservicioVO[] getAddOnPeriodoMultiservicioVO() {
		if( addOnPeriodoMultiservicioVO instanceof AddOnPeriodoMultiservicioVO[]){
			return (AddOnPeriodoMultiservicioVO[]) addOnPeriodoMultiservicioVO.clone();
		} else{
			return new AddOnPeriodoMultiservicioVO[0];
		}
	}
	public void setAddOnPeriodoMultiservicioVO(final 
			AddOnPeriodoMultiservicioVO[] addOnPeriodoMultiservicioVO) {
		if(addOnPeriodoMultiservicioVO instanceof AddOnPeriodoMultiservicioVO[]){
			this.addOnPeriodoMultiservicioVO = (AddOnPeriodoMultiservicioVO[])addOnPeriodoMultiservicioVO.clone();
		}else{
			this.addOnPeriodoMultiservicioVO = new AddOnPeriodoMultiservicioVO[0];
		}
	}
	public AddOnUnidadMultiservicioVO[] getAddOnUnidadMultiservicioVO() {
		if(addOnUnidadMultiservicioVO instanceof AddOnUnidadMultiservicioVO[]){
			return (AddOnUnidadMultiservicioVO[]) addOnUnidadMultiservicioVO.clone();
		}else{
			return new AddOnUnidadMultiservicioVO[0];
		}
	}
	public void setAddOnUnidadMultiservicioVO(final
			AddOnUnidadMultiservicioVO[] addOnUnidadMultiservicioVO) {
		if( addOnUnidadMultiservicioVO instanceof AddOnUnidadMultiservicioVO[]){
			this.addOnUnidadMultiservicioVO = (AddOnUnidadMultiservicioVO[]) addOnUnidadMultiservicioVO.clone();
		} else{
			this.addOnUnidadMultiservicioVO = new AddOnUnidadMultiservicioVO[0];
		}
	}
	public String getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(final String idPaquete) {
		this.idPaquete = idPaquete;
	}
	public Boolean getIsMultiservicio() {
		return isMultiservicio;
	}
	public void setIsMultiservicio(final Boolean isMultiservicio) {
		this.isMultiservicio = isMultiservicio;
	}
	public Double getPrecioPaquete() {
		return precioPaquete;
	}
	public void setPrecioPaquete(final Double precioPaquete) {
		this.precioPaquete = precioPaquete;
	}
	public String getTmCode() {
		return tmCode;
	}
	public void setTmCode(final String tmCode) {
		this.tmCode = tmCode;
	}
	public Double getVigenciaPaquete() {
		return vigenciaPaquete;
	}
	public void setVigenciaPaquete(final Double vigenciaPaquete) {
		this.vigenciaPaquete = vigenciaPaquete;
	}
	
	public void setPrecioPaqueteString(final Double precioPaquete) {
		final DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
		this.precioPaqueteString = "Precio: $" + decimalFormat.format(precioPaquete);
	}
	
	public String getPrecioPaqueteString() {
		return precioPaqueteString;
	}
	
	public void setVigenciaPaqueteString(final Double vigenciaPaquete) {
		final DecimalFormat decimalFormat = new DecimalFormat("###,##0");
		final int valorSinPeriodo = 1;
		if (vigenciaPaquete == null){
			this.vigenciaPaqueteString = "Sin Vigencia";
		} else if (vigenciaPaquete < valorSinPeriodo){
			this.vigenciaPaqueteString = "Vigencia: Sin períodos";
		} else{
			this.vigenciaPaqueteString = "Período: " + decimalFormat.format(vigenciaPaquete) + " día(s)";
		}
	}
	
	public String getVigenciaPaqueteString() {
		return vigenciaPaqueteString;
	}
}
