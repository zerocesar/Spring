package mx.com.att.vo;

import java.io.Serializable;

public class BankReferenceVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long timCustomerId; //csFname Nombre del cliente
	
	private String fechaIngreso; //csLname Apellidos del cliente
	
	private String banco; //userPassword Password del usuario
	
	private String contrato; //mdn:uid:dn Numero telefonico
	
	private String referencia; //region Region
	
	private Integer orden; //areaId Id del Area

	public Long getTimCustomerId() {
		return timCustomerId;
	}

	public void setTimCustomerId(Long timCustomerId) {
		this.timCustomerId = timCustomerId;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
}