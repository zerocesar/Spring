package mx.com.att.vo;

import java.io.Serializable;
import java.util.Calendar;

public class ContractVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long contractId; //coId Número de contrato del cliente
	
	private Integer technologyId; //subMId:technologyTypeId Id de tecnología
	
	private Long tmcode; //tmCode Id del plan contratado
	
	private String tmcodeDesc; //desTmcode:ratePlan Descripción del plan contratado
	
	private String contractTypeId; //csCustType:contractTypeId Tipo de Contrato
	
	private String sellChannelId; //prgCode Id de canal de venta
	
	private Long channelId; //channelId Canal de venta (IOS o MVK<APK>)
	
	private String suspensionId; //chReason Codigo de suspensión de la linea en caso de estarlo
	
	private String statusId; //chStatus Status de la linea
	
	private String ivaDesc; //desIva Descripción del IVA
	
	private Calendar nextBillCycle; //nextBillCycle Fecha del proximo corte
	
	private Calendar bchRunDate; //bchRunDate Fecha en que correra el proceso de generacion de facturacion
	
	private Integer maxFrecuentNumbers; //Numero maximo de numeros frecuentes
	
	private Boolean isTMCODEShare; //Bandera que identifica si el numero tiene padres o hijos (sea Oferta Comparte)
	
	private DeviceVO deviceVO; //deviceVO objeto equipo

	public Boolean getIsTMCODEShare() {
		return isTMCODEShare;
	}

	public void setIsTMCODEShare(final Boolean isTMCODEShare) {
		this.isTMCODEShare = isTMCODEShare;
	}
	
	public Integer getMaxFrecuentNumbers() {
		return maxFrecuentNumbers;
	}

	public void setMaxFrecuentNumbers(final Integer maxFrecuentNumbers) {
		this.maxFrecuentNumbers = maxFrecuentNumbers;
	}
	
	public Long getContractId() {
		return contractId;
	}

	public void setContractId(final Long contractId) {
		this.contractId = contractId;
	}

	public Integer getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	public Long getTmcode() {
		return tmcode;
	}

	public void setTmcode(final Long tmcode) {
		this.tmcode = tmcode;
	}

	public String getTmcodeDesc() {
		return tmcodeDesc;
	}

	public void setTmcodeDesc(final String tmcodeDesc) {
		this.tmcodeDesc = tmcodeDesc;
	}

	public String getContractTypeId() {
		return contractTypeId;
	}

	public void setContractTypeId(final String contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	public String getSellChannelId() {
		return sellChannelId;
	}

	public void setSellChannelId(final String sellChannelId) {
		this.sellChannelId = sellChannelId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(final Long channelId) {
		this.channelId = channelId;
	}

	public String getSuspensionId() {
		return suspensionId;
	}

	public void setSuspensionId(final String suspensionId) {
		this.suspensionId = suspensionId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(final String statusId) {
		this.statusId = statusId;
	}

	public String getIvaDesc() {
		return ivaDesc;
	}

	public void setIvaDesc(final String ivaDesc) {
		this.ivaDesc = ivaDesc;
	}

	public Calendar getNextBillCycle() {
		return nextBillCycle;
	}

	public void setNextBillCycle(final Calendar nextBillCycle) {
		this.nextBillCycle = nextBillCycle;
	}

	public Calendar getBchRunDate() {
		return bchRunDate;
	}

	public void setBchRunDate(Calendar bchRunDate) {
		this.bchRunDate = bchRunDate;
	}

	public DeviceVO getDeviceVO() {
		return deviceVO;
	}

	public void setDeviceVO(final DeviceVO deviceVO) {
		this.deviceVO = deviceVO;
	}
}