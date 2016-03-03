package mx.com.att.vo.orange;

import java.io.Serializable;

public class ServiceOrderVO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private String orderId;
    private String serviceId;
	private String userDN;
	private double amount;
	private String serviceRef;
	private String contractType;
	private String additionalInfo;
	private String mwCodeResponse;
	private String mwMsgResponse;
	private String mwResponseInfo;
	private int status;
	private int commercialConfigId;
	private String mdn;
	private String custCode; 
	private String customerId; 
	private int batchAttempts; 
	private int cciSequence; 
	private String txnReference;
	private String userName;
	private String handsetModel;
	private int areamdn;
	private int region;
	private String apn;
	private String coId;
	private int channel;
	private int paymentId;
	private int serviceType;
	private String snCode;
	private String spCode;
	private String fechaProcesado;
	private String symbol;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(final String symbol) {
		this.symbol = symbol;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getUserDN() {
		return userDN;
	}
	public void setUserDN(String userDN) {
		this.userDN = userDN;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getServiceRef() {
		return serviceRef;
	}
	public void setServiceRef(String serviceRef) {
		this.serviceRef = serviceRef;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getMwCodeResponse() {
		return mwCodeResponse;
	}
	public void setMwCodeResponse(String mwCodeResponse) {
		this.mwCodeResponse = mwCodeResponse;
	}
	public String getMwMsgResponse() {
		return mwMsgResponse;
	}
	public void setMwMsgResponse(String mwMsgResponse) {
		this.mwMsgResponse = mwMsgResponse;
	}
	public String getMwResponseInfo() {
		return mwResponseInfo;
	}
	public void setMwResponseInfo(String mwResponseInfo) {
		this.mwResponseInfo = mwResponseInfo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCommercialConfigId() {
		return commercialConfigId;
	}
	public void setCommercialConfigId(int commercialConfigId) {
		this.commercialConfigId = commercialConfigId;
	}
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getBatchAttempts() {
		return batchAttempts;
	}
	public void setBatchAttempts(int batchAttempts) {
		this.batchAttempts = batchAttempts;
	}
	public int getCciSequence() {
		return cciSequence;
	}
	public void setCciSequence(int cciSequence) {
		this.cciSequence = cciSequence;
	}
	public String getTxnReference() {
		return txnReference;
	}
	public void setTxnReference(String txnReference) {
		this.txnReference = txnReference;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHandsetModel() {
		return handsetModel;
	}
	public void setHandsetModel(String handsetModel) {
		this.handsetModel = handsetModel;
	}
	public int getAreamdn() {
		return areamdn;
	}
	public void setAreamdn(int areamdn) {
		this.areamdn = areamdn;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public String getApn() {
		return apn;
	}
	public void setApn(String apn) {
		this.apn = apn;
	}
	public String getCoId() {
		return coId;
	}
	public void setCoId(String coId) {
		this.coId = coId;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getServiceType() {
		return serviceType;
	}
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}
	public String getSnCode() {
		return snCode;
	}
	public void setSnCode(String snCode) {
		this.snCode = snCode;
	}
	public String getSpCode() {
		return spCode;
	}
	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	public String getFechaProcesado() {
		return fechaProcesado;
	}
	public void setFechaProcesado(String fechaProcesado) {
		this.fechaProcesado = fechaProcesado;
	}



}
