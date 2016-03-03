package mx.com.att.vo;

import java.io.Serializable;

import mx.com.att.vo.orange.BalanceInquiryVO;
import mx.com.att.vo.red.DatosCliente;
import mx.com.att.vo.red.FacturaVirtualDetalleVO;
import mx.com.att.vo.orange.PaymentBillVO;
import mx.com.att.vo.orange.ServiceWPVO;
import mx.com.att.vo.red.LoginVO;

public class CustomerVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name; //csFname Nombre del cliente
	
	private String lastName; //csLname Apellidos del cliente
	
	private String user; //mdn:uid:dn Numero telefonico
	
	private Integer areaId; //areaId Id del Area
	
	private String region; //region Region
	
	private String area; //area Area
	
	private String myATTVersion; //miNextelVersion Versión actual de la aplicación
	
	private Integer carrierId; //carrierId Identificador Rojo(1) o Naranja(2)
	
	private String systemId; //idSistema Identificador de sistema MVL(APK) o IOS
	
	private String login;   //login:password personal del cliente
	
	private String unidadNegocio; //unidad para identificar el cliente 
	
	private String numFacturas;   //son la cantidad de facturas que quieren visualizarse
	
    private String IdUsuario;     //idUsuario quien actualiza
	
	private String idServicios;   //Servicio para identificador de PIN
	
	private String idPin;         //id para generar PIN
	
	private String token;
	
	private DatosCliente datosCliente;
	
	private ContractVO contractVO;
	
	private PaymentRespVO paymentRespVO;
	
	private LoginRecordVO loginRecordVO;
	
	private BalanceInquiryVO balanceInquiryVO;
	
	private ServiceWPVO[] serviceWPVO;
	
	private PaymentBillVO paymentBillVO;
	
	private LoginVO loginVO;
	
	private String passwordAnt;
	
	private String tipoEvento;
	
	private String urlFactura;
	
	private FacturaVirtualDetalleVO facturaVirtualDetalle;
	
	private Integer associateContracts; //Numero de contratos asociados a la cuenta
	
	public Integer getAssociateContracts() {
		return associateContracts;
	}

	public void setAssociateContracts(final Integer associateContracts) {
		this.associateContracts = associateContracts;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(final String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getPasswordAnt() {
		return passwordAnt;
	}

	public void setPasswordAnt(final String passwordAnt) {
		this.passwordAnt = passwordAnt;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(final LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public PaymentBillVO getPaymentBillVO() {
		return paymentBillVO;
	}

	public void setPaymentBillVO(final PaymentBillVO paymentBillVO) {
		this.paymentBillVO = paymentBillVO;
	}

	public ServiceWPVO[] getServiceWPVO() {
		return serviceWPVO;
	}

	public void setServiceWPVO(final ServiceWPVO[] serviceWPVO) {
		this.serviceWPVO = serviceWPVO;
	}

	public BalanceInquiryVO getBalanceInquiryVO() {
		return balanceInquiryVO;
	}

	public void setBalanceInquiryVO(final BalanceInquiryVO balanceInquiryVO) {
		this.balanceInquiryVO = balanceInquiryVO;
	}

	public LoginRecordVO getLoginRecordVO() {
		return loginRecordVO;
	}

	public void setLoginRecordVO(final LoginRecordVO loginRecordVO) {
		this.loginRecordVO = loginRecordVO;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(final String user) {
		this.user = user;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(final Integer areaId) {
		this.areaId = areaId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(final String region) {
		this.region = region;
	}

	public String getArea() {
		return area;
	}

	public void setArea(final String area) {
		this.area = area;
	}

	public String getMyATTVersion() {
		return myATTVersion;
	}

	public void setMyATTVersion(final String myATTVersion) {
		this.myATTVersion = myATTVersion;
	}
	
	public Integer getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(final Integer carrierId) {
		this.carrierId = carrierId;
	}
	
	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(final String systemId) {
		this.systemId = systemId;
	}
	
	public ContractVO getContractVO() {
		return contractVO;
	}

	public void setContractVO(final ContractVO contractVO) {
		this.contractVO = contractVO;
	}

	public PaymentRespVO getPaymentRespVO() {
		return paymentRespVO;
	}

	public void setPaymentRespVO(final PaymentRespVO paymentRespVO) {
		this.paymentRespVO = paymentRespVO;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getUnidadNegocio() {
		return unidadNegocio;
	}

	public void setUnidadNegocio(final String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}

	public String getNumFacturas() {
		return numFacturas;
	}

	public void setNumFacturas(final String numFacturas) {
		this.numFacturas = numFacturas;
	}

	
	public String getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(final String idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getIdServicios() {
		return idServicios;
	}

	public void setIdServicios(final String idServicios) {
		this.idServicios = idServicios;
	}

	public String getIdPin() {
		return idPin;
	}

	public void setIdPin(final String idPin) {
		this.idPin = idPin;
	}

	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(final DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}

	public String getToken() {
		return token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	public FacturaVirtualDetalleVO getFacturaVirtualDetalle() {
		return facturaVirtualDetalle;
	}

	public void setFacturaVirtualDetalle(final FacturaVirtualDetalleVO facturaVirtualDetalle) {
		this.facturaVirtualDetalle = facturaVirtualDetalle;
	}

	public String getUrlFactura() {
		return urlFactura;
	}

	public void setUrlFactura(final String urlFactura) {
		this.urlFactura = urlFactura;
	}
}