package mx.com.att.vo.orange;

import java.io.Serializable;
import java.util.List;

public class DatosNumerosFrecuentesVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private long coId;
	private long customerId;
	private String dn;
	private String tmcode;
	private int contractType;
	private String idSistema;
	private List<FrecuentNumbersVO> numerosACambiar;
	private int maxFrecNums;
	private List<FrecuentNumbersVO> numerosRegistrar;
	private List<FrecuentNumbersVO> numerosExistentes; 
	private int serviceTypeId;
	private int idTecnology;
	private double amount;
	private int channelId;
	
	/**
	 * @return the coId
	 */
	public long getCoId() {
		return coId;
	}
	/**
	 * @return the numerosExistentes
	 */
	public List<FrecuentNumbersVO> getNumerosExistentes() {
		return numerosExistentes;
	}
	/**
	 * @param numerosExistentes the numerosExistentes to set
	 */
	public void setNumerosExistentes(final List<FrecuentNumbersVO> numerosExistentes) {
		this.numerosExistentes = numerosExistentes;
	}
	/**
	 * @return the serviceTypeId
	 */
	public int getServiceTypeId() {
		return serviceTypeId;
	}
	/**
	 * @param serviceTypeId the serviceTypeId to set
	 */
	public void setServiceTypeId(final int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	/**
	 * @return the idTecnology
	 */
	public int getIdTecnology() {
		return idTecnology;
	}
	/**
	 * @param idTecnology the idTecnology to set
	 */
	public void setIdTecnology(final int idTecnology) {
		this.idTecnology = idTecnology;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(final double amount) {
		this.amount = amount;
	}
	/**
	 * @return the channelId
	 */
	public int getChannelId() {
		return channelId;
	}
	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(final int channelId) {
		this.channelId = channelId;
	}
	/**
	 * @param coId the coId to set
	 */
	public void setCoId(final long coId) {
		this.coId = coId;
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
	/**
	 * @return the contractType
	 */
	public int getContractType() {
		return contractType;
	}
	/**
	 * @param contractType the contractType to set
	 */
	public void setContractType(final int contractType) {
		this.contractType = contractType;
	}
	/**
	 * @return the tmcode
	 */
	public String getTmcode() {
		return tmcode;
	}
	/**
	 * @param tmcode the tmcode to set
	 */
	public void setTmcode(final String tmcode) {
		this.tmcode = tmcode;
	}
	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(final long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the maxFrecNums
	 */
	public int getMaxFrecNums() {
		return maxFrecNums;
	}
	/**
	 * @param maxFrecNums the maxFrecNums to set
	 */
	public void setMaxFrecNums(final int maxFrecNums) {
		this.maxFrecNums = maxFrecNums;
	}
	/**
	 * @return the numerosACambiar
	 */
	public List<FrecuentNumbersVO> getNumerosACambiar() {
		return numerosACambiar;
	}
	/**
	 * @param numerosACambiar the numerosACambiar to set
	 */
	public void setNumerosACambiar(final List<FrecuentNumbersVO> numerosACambiar) {
		this.numerosACambiar = numerosACambiar;
	}
	/**
	 * @return the numerosRegistrar
	 */
	public List<FrecuentNumbersVO> getNumerosRegistrar() {
		return numerosRegistrar;
	}
	/**
	 * @param numerosRegistrar the numerosRegistrar to set
	 */
	public void setNumerosRegistrar(final List<FrecuentNumbersVO> numerosRegistrar) {
		this.numerosRegistrar = numerosRegistrar;
	}
	public String getIdSistema() {
		return idSistema;
	}
	public void setIdSistema(final String idSistema) {
		this.idSistema = idSistema;
	}
	
		
}
