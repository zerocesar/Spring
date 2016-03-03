package mx.com.att.vo.orange;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="estadoCuenta")
@XmlAccessorType(XmlAccessType.FIELD)
public class EstadoCuentaVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(name="saldoAnterior")
	private String saldoAnterior;
	@XmlElement(name="ajustes")
	private String ajustes;
	@XmlElement(name="tusPagos")
	private String tusPagos;
	@XmlElement(name="saldo")
	private String saldo;
	@XmlElement(name="customerId")
	private String customerId;
	@XmlElement(name="custcode")
	private String custcode;
	@XmlElement(name="billingAccountId")
	private String billingAccountId;
	@XmlElement(name="idCiclo")
	private String idCiclo;
	@XmlElement(name="timmCustomerId")
	private String timmCustomerId;
	@XmlElement(name="cargosCiclo")
	private String cargosCiclo;
	@XmlElement(name="subFijoTabla")
	private String subFijoTabla;
	@XmlElement(name="idContrato")
	private String idContrato;
	@XmlElement(name="tmcode")
	private String tmcode;
	@XmlElement(name="obtener")
	private String obtener;
	

	/**
	 * @return the subFijoTabla
	 */
	public String getSubFijoTabla() {
		return subFijoTabla;
	}
	/**
	 * @param subFijoTabla the subFijoTabla to set
	 */
	public void setSubFijoTabla(final String subFijoTabla) {
		this.subFijoTabla = subFijoTabla;
	}
	/**
	 * @return the saldoAnterior
	 */
	public String getSaldoAnterior() {
		return saldoAnterior;
	}
	/**
	 * @return the ajustes
	 */
	public String getAjustes() {
		return ajustes;
	}
	/**
	 * @return the tusPagos
	 */
	public String getTusPagos() {
		return tusPagos;
	}
	/**
	 * @return the saldo
	 */
	public String getSaldo() {
		return saldo;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @return the custcode
	 */
	public String getCustcode() {
		return custcode;
	}
	/**
	 * @return the billingAccountId
	 */
	public String getBillingAccountId() {
		return billingAccountId;
	}
	/**
	 * @return the idCiclo
	 */
	public String getIdCiclo() {
		return idCiclo;
	}
	/**
	 * @return the timmCustomerId
	 */
	public String getTimmCustomerId() {
		return timmCustomerId;
	}
	/**
	 * @return the cargosCiclo
	 */
	public String getCargosCiclo() {
		return cargosCiclo;
	}
	
	/**
	 * @return the idContrato
	 */
	public String getIdContrato() {
		return idContrato;
	}
	/**
	 * @return the tmcode
	 */
	public String getTmcode() {
		return tmcode;
	}
	/**
	 * @return the obtener
	 */
	public String getObtener() {
		return obtener;
	}
	/**
	 * @param saldoAnterior the saldoAnterior to set
	 */
	public void setSaldoAnterior(final String saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	/**
	 * @param ajustes the ajustes to set
	 */
	public void setAjustes(final String ajustes) {
		this.ajustes = ajustes;
	}
	/**
	 * @param tusPagos the tusPagos to set
	 */
	public void setTusPagos(final String tusPagos) {
		this.tusPagos = tusPagos;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(final String saldo) {
		this.saldo = saldo;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(final String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @param custcode the custcode to set
	 */
	public void setCustcode(final String custcode) {
		this.custcode = custcode;
	}
	/**
	 * @param billingAccountId the billingAccountId to set
	 */
	public void setBillingAccountId(final String billingAccountId) {
		this.billingAccountId = billingAccountId;
	}
	/**
	 * @param idCiclo the idCiclo to set
	 */
	public void setIdCiclo(final String idCiclo) {
		this.idCiclo = idCiclo;
	}
	/**
	 * @param timmCustomerId the timmCustomerId to set
	 */
	public void setTimmCustomerId(final String timmCustomerId) {
		this.timmCustomerId = timmCustomerId;
	}
	/**
	 * @param cargosCiclo the cargosCiclo to set
	 */
	public void setCargosCiclo(String cargosCiclo) {
		this.cargosCiclo = cargosCiclo;
	}
	/**
	 * @param idContrato the idContrato to set
	 */
	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}
	/**
	 * @param tmcode the tmcode to set
	 */
	public void setTmcode(String tmcode) {
		this.tmcode = tmcode;
	}
	/**
	 * @param obtener the obtener to set
	 */
	public void setObtener(String obtener) {
		this.obtener = obtener;
	}
	
}
