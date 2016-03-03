package mx.com.att.vo.orange;

import java.io.Serializable;
import java.util.Calendar;

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = {
//    "id",
//    "activityId",
//    "activity",
//    "statusId",
//    "status",
//    "transactionDate",
//    "authorizationNumber",
//    "idRef",
//    "dn",
//    "error",
//    "retailId",
//    "retail",
//    "systemId",
//    "system",
//    "paymentId",
//    "payment",
//    "areaId",
//    "area",
//    "code",
//    "idCadena",
//    "cadena",
//    "amount",
//    "walletId",
//    "wallet",
//    "spCode",
//    "snCode",
//    "service",
//    "period",
//    "unit",
//    "typeunit",
//    "expirationDate"
//})
//@XmlRootElement(name = "DetailPurchaseServicesVO")
public class DetailPurchaseServicesVO implements Serializable{

    private final static long serialVersionUID = 1L;
//    @XmlElement(required = true, nillable = true)
    protected String id;
//    @XmlElement(required = true, nillable = true)
    protected String activityId;
//    @XmlElement(required = true, nillable = true)
    protected String activity;
//    @XmlElement(required = true, nillable = true)
    protected String statusId;
//    @XmlElement(required = true, nillable = true)
    protected String status;
//    @XmlElement(required = true, nillable = true)
//    @XmlSchemaType(name = "date")
    protected Calendar transactionDate;
//    @XmlElement(required = true, nillable = true)
    protected String authorizationNumber;
//    @XmlElement(required = true, nillable = true)
    protected String idRef;
//    @XmlElement(required = true, nillable = true)
    protected String dn;
//    @XmlElement(required = true, nillable = true)
    protected String error;
//    @XmlElement(required = true, nillable = true)
    protected String retailId;
//    @XmlElement(required = true, nillable = true)
    protected String retail;
//    @XmlElement(required = true, nillable = true)
    protected String systemId;
//    @XmlElement(required = true, nillable = true)
    protected String system;
//    @XmlElement(required = true, nillable = true)
    protected String paymentId;
//    @XmlElement(required = true, nillable = true)
    protected String payment;
//    @XmlElement(required = true, nillable = true)
    protected String areaId;
//    @XmlElement(required = true, nillable = true)
    protected String area;
//    @XmlElement(required = true, nillable = true)
    protected String code;
//    @XmlElement(required = true, nillable = true)
    protected String idCadena;
//    @XmlElement(required = true, nillable = true)
    protected String cadena;
//    @XmlElement(required = true, nillable = true)
    protected String amount;
//    @XmlElement(required = true, nillable = true)
    protected String walletId;
//    @XmlElement(required = true, nillable = true)
    protected String wallet;
//    @XmlElement(required = true, nillable = true)
    protected String spCode;
//    @XmlElement(required = true, nillable = true)
    protected String snCode;
//    @XmlElement(required = true, nillable = true)
    protected String service;
//    @XmlElement(required = true, nillable = true)
    protected String period;
//    @XmlElement(required = true, nillable = true)
    protected String unit;
//    @XmlElement(required = true, nillable = true)
    protected String typeunit;    
//    @XmlElement(required = true, nillable = true)
//    @XmlSchemaType(name = "date")
    protected Calendar expirationDate;
    
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(final String activityId) {
		this.activityId = activityId;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(final String activity) {
		this.activity = activity;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(final String statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(final String status) {
		this.status = status;
	}
	public Calendar getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(final Calendar calendar) {
		this.transactionDate = calendar;
	}
	public String getAuthorizationNumber() {
		return authorizationNumber;
	}
	public void setAuthorizationNumber(final String authorizationNumber) {
		this.authorizationNumber = authorizationNumber;
	}
	public String getIdRef() {
		return idRef;
	}
	public void setIdRef(final String idRef) {
		this.idRef = idRef;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(final String dn) {
		this.dn = dn;
	}
	public String getError() {
		return error;
	}
	public void setError(final String error) {
		this.error = error;
	}
	public String getRetailId() {
		return retailId;
	}
	public void setRetailId(final String retailId) {
		this.retailId = retailId;
	}
	public String getRetail() {
		return retail;
	}
	public void setRetail(final String retail) {
		this.retail = retail;
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(final String systemId) {
		this.systemId = systemId;
	}
	public String getsystem() {
		return system;
	}
	public void setSystem(final String system) {
		this.system = system;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(final String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(final String payment) {
		this.payment = payment;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(final String areaId) {
		this.areaId = areaId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(final String area) {
		this.area = area;
	}
	public String getCode() {
		return code;
	}
	public void setCode(final String code) {
		this.code = code;
	}
	public String getIdCadena() {
		return idCadena;
	}
	public void setIdCadena(final String idCadena) {
		this.idCadena = idCadena;
	}
	public String getCadena() {
		return cadena;
	}
	public void setCadena(final String cadena) {
		this.cadena = cadena;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(final String amount) {
		this.amount = amount;
	}
	public String getWalletId() {
		return walletId;
	}
	public void setWalletId(final String walletId) {
		this.walletId = walletId;
	}
	public String getWallet() {
		return wallet;
	}
	public void setWallet(final String wallet) {
		this.wallet = wallet;
	}
	public String getSpCode() {
		return spCode;
	}
	public void setSpCode(final String spCode) {
		this.spCode = spCode;
	}
	public String getSnCode() {
		return snCode;
	}
	public void setSnCode(final String snCode) {
		this.snCode = snCode;
	}
	public String getService() {
		return service;
	}
	public void setService(final String service) {
		this.service = service;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(final String period) {
		this.period = period;
	}		
	public String getUnit() {
		return unit;
	}
	public void setUnit(final String unit) {
		this.unit = unit;
	}
	public String getTypeunit() {
		return typeunit;
	}
	public void setTypeunit(final String typeunit) {
		this.typeunit = typeunit;
	}
	public Calendar getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(final Calendar calendar) {
		this.expirationDate = calendar;
	}
    
}
