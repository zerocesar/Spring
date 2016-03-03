package mx.com.att.vo.orange;

import java.io.Serializable;

public class ServiceOrderWPVO implements Serializable{
private final static long serialVersionUID = 1L;
	
	private long orderId;
	private long contractTypeId;
	private long channelId;
	private long userMdn;
	private double amount;
	private boolean getCciSecuence;
	private String serviceRef;
	private long commercialConfigId;
	private String custCode="";
	private long customerId;
	private long coId;
	private String additionalInfo;
	private long cciSecuence;
	private String txnReference;
	private int lastOrderStatusId;
	private String userFullName;
	private int batchAttemps;
	private String area="";
	private String region="";
	private String apn="";
	private String deviceDesc="";
	private long servOrdId;
	private int orderStatusId;
	private String statusDate;
	private String orderStatusName;
	private String orderStatusDescription;
	private String ratePlan;
	private String userEmail;
	private String prgCode;
	private int cciConfigId;
	private long idCodeMessage;
	private String messageCode;
	
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getContractTypeId() {
		return contractTypeId;
	}
	public void setContractTypeId(long contractTypeId) {
		this.contractTypeId = contractTypeId;
	}
	public long getChannelId() {
		return channelId;
	}
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}
	public long getUserMdn() {
		return userMdn;
	}
	public void setUserMdn(long userMdn) {
		this.userMdn = userMdn;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isGetCciSecuence() {
		return getCciSecuence;
	}
	public void setGetCciSecuence(boolean getCciSecuence) {
		this.getCciSecuence = getCciSecuence;
	}
	public String getServiceRef() {
		return serviceRef;
	}
	public void setServiceRef(String serviceRef) {
		this.serviceRef = serviceRef;
	}
	public long getCommercialConfigId() {
		return commercialConfigId;
	}
	public void setCommercialConfigId(long commercialConfigId) {
		this.commercialConfigId = commercialConfigId;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getCoId() {
		return coId;
	}
	public void setCoId(long coId) {
		this.coId = coId;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public long getCciSecuence() {
		return cciSecuence;
	}
	public void setCciSecuence(long cciSecuence) {
		this.cciSecuence = cciSecuence;
	}
	public String getTxnReference() {
		return txnReference;
	}
	public void setTxnReference(String txnReference) {
		this.txnReference = txnReference;
	}
	public int getLastOrderStatusId() {
		return lastOrderStatusId;
	}
	public void setLastOrderStatusId(int lastOrderStatusId) {
		this.lastOrderStatusId = lastOrderStatusId;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public int getBatchAttemps() {
		return batchAttemps;
	}
	public void setBatchAttemps(int batchAttemps) {
		this.batchAttemps = batchAttemps;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getApn() {
		return apn;
	}
	public void setApn(String apn) {
		this.apn = apn;
	}
	public String getDeviceDesc() {
		return deviceDesc;
	}
	public void setDeviceDesc(String deviceDesc) {
		this.deviceDesc = deviceDesc;
	}
	public long getServOrdId() {
		return servOrdId;
	}
	public void setServOrdId(long servOrdId) {
		this.servOrdId = servOrdId;
	}
	public int getOrderStatusId() {
		return orderStatusId;
	}
	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	public String getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}
	public String getOrderStatusName() {
		return orderStatusName;
	}
	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}
	public String getOrderStatusDescription() {
		return orderStatusDescription;
	}
	public void setOrderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
	}
	public String getRatePlan() {
		return ratePlan;
	}
	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getCciConfigId() {
		return cciConfigId;
	}
	public void setCciConfigId(int cciConfigId) {
		this.cciConfigId = cciConfigId;
	}
	public long getIdCodeMessage() {
		return idCodeMessage;
	}
	public void setIdCodeMessage(long idCodeMessage) {
		this.idCodeMessage = idCodeMessage;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String toString(){
		return "commercialConfigId: "+commercialConfigId+" \n " +
				"orderId: "+orderId+" \n" +
				"contractTypeId: "+contractTypeId+"\n" +
				"channelId: "+channelId+"\n" +
				"userMdn: "+userMdn+" \n" +
				"amount: "+amount+" \n" +
				"cciSecuence: "+cciSecuence+" \n" +
				"serviceRef: "+serviceRef+" \n" +
				"custCode: "+custCode+"\n" +
				"customerId: "+customerId +"\n" +
				"coId: "+coId +"\n" +
				"additionalInfo: "+additionalInfo+" \n" +
				"cciSecuence: "+cciSecuence+"\n" +
				"txnReference: "+txnReference+"\n" +
				"lastOrderStatusId: "+lastOrderStatusId+"\n" + 
				"userFullName: "+userFullName+"\n" + 
				"batchAttemps: "+batchAttemps+"\n" +
				"area: "+area+"\n" +
				"region: "+region+"\n" +
				"apn: "+apn+"\n" +
				"deviceDesc: "+deviceDesc+"\n" +
				"servOrdId: "+servOrdId+"\n" +
				"orderStatusId: "+orderStatusId+"\n" +
				"statusDate: "+statusDate+"\n" +
				"orderStatusName: "+orderStatusName+"\n" +
				"orderStatusDescription: "+orderStatusDescription+"\n" +
				"ratePlan: "+ratePlan+"\n" +
				"userEmail"+userEmail+"\n" +
				"idCodeMessage: "+idCodeMessage+"\n" +
				"messageCode: "+messageCode+"\n";
	}
	public String getPrgCode() {
		return prgCode;
	}
	public void setPrgCode(String prgCode) {
		this.prgCode = prgCode;
	}
	
}
