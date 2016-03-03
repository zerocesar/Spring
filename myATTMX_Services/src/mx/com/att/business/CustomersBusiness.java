package mx.com.att.business;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import mx.com.att.support.ClientesAdicionSoapServices;
import mx.com.att.support.ClientesOESoapServices;
import mx.com.att.support.ClientesWPPPSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.ConsultaSaldoVO;
import mx.com.att.vo.orange.OrdenesWPVO;
import mx.com.att.vo.orange.PaymentBillVO;
import mx.com.att.vo.orange.ServiceOrderVO;
import mx.com.att.vo.orange.ServiceOrderWPVO;
import mx.com.att.vo.orange.TicketInfoWPVO;
import mx.com.nextel.www.ecommerce.ws.adicion.ClientesAdicionPortBindingStub;
import mx.com.nextel.www.ecommerce.ws.cliente.ClientesOESoapBindingStub;
import mx.com.nextel.www.wppp.exceptions.WPPPntException;
import mx.com.nextel.www.wppp.ws.clientes.ClientesWPPPSoapProxy;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class CustomersBusiness {
	private static final Logger LOGGER = Logger.getLogger(CustomersBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT(); 
	
	
	public String getBlockedDn(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getBlockedDn de la clase CustomersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final PaymentRespVO paymentRespVO = new Gson().fromJson(jsonDecrypted, PaymentRespVO.class);
		try{
			VALIDATOR.validateEmptyLong(paymentRespVO.getCustomerId(), "Id del Responsable de Pago");
			
			//Obtiene la informacion del numero de dns bloqueados mediante el id del responsable de pago.
			final ClientesAdicionPortBindingStub clientesAdicionProxy = ClientesAdicionSoapServices.getClientesAdicionService();
			final String responseString = clientesAdicionProxy.consultaDnBloqueadosMovil(""+paymentRespVO.getCustomerId());
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(responseString);
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_GET_SALDO_CUENTA);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getAccountContractsBrothersDn(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getAccountContractsBrothersDn de la clase CustomersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final CustomerVO customerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class);
		try{
			VALIDATOR.validateDN12(customerVO.getUser());
			
			final mx.com.nextel.www.ecommerce.ws.adicion.DeviceVO deviceVO = new mx.com.nextel.www.ecommerce.ws.adicion.DeviceVO();
			deviceVO.setDn(customerVO.getUser());
			//Obtiene el numero de contratos hermanos dado un dn.
			final ClientesAdicionPortBindingStub clientesAdicionProxy = ClientesAdicionSoapServices.getClientesAdicionService();
			final String responseString = clientesAdicionProxy.getCuentaContratosHermanosDnMovil(new Gson().toJson(deviceVO));
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(responseString);
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_GET_SALDO_CUENTA);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String saldoFacturasCuenta(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo saldoFacturasCuenta de la clase CustomersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final CustomerVO customerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class);
		final mx.com.nextel.www.wppp.ws.vo.DeviceVO deviceVO = new mx.com.nextel.www.wppp.ws.vo.DeviceVO();
		final PaymentBillVO bills = new PaymentBillVO();
		
		try {
			VALIDATOR.validateDN12(customerVO.getUser());
			
			//Se busca la informacion del usuario en BSCS
			LOGGER.info("Se busca la informacion del saldo de la factura de la cuenta para el DN: " + customerVO.getUser());
			deviceVO.setDn(customerVO.getUser());
			final ClientesWPPPSoapProxy webService = ClientesWPPPSoapServices.getClientesWPPPSoapServices();
			final mx.com.nextel.www.wppp.ws.vo.CustomerVO cliente = webService.saldoFacturasCuenta(deviceVO);
			
			final DecimalFormat df = new DecimalFormat();
			if(cliente.getInvoiceVO() != null) {
				for(int x=0; x<cliente.getInvoiceVO().length; x++){
					//MANDAMOS A LLAMAR AL METODO QUE NOS PERMITE OBTENER MAS
					//INFORMACION ACERCA DE LA FACTURA
					bill(cliente.getInvoiceVO()[x], bills);
				}
			}
			//DAMOS EL FORMATO AL SALDO TOTAL
			if (bills.getSaldoAcumTotal() == 0)
	        	bills.setSaldoTotal("0.00");
	        else
	        	bills.setSaldoTotal(df.format(bills.getSaldoAcumTotal()));
	        	
	        if (bills.getSaldoVencerTotal() == 0)
	        	bills.setSaldoVencer("0.00");
	        else
	        	bills.setSaldoVencer(df.format(bills.getSaldoVencerTotal()));
	        
	        if (bills.getSaldoVencidoTotal() == 0)
	        	bills.setSaldoVencido("0.00");
	        else
	       		bills.setSaldoVencido(df.format(bills.getSaldoVencidoTotal()));			
			//INFORMACION REFERENTE A LOS SALDOS
	        LOGGER.info("saldoVencido= " + bills.getSaldoVencido() + " para el DN: " + deviceVO.getDn());
	        LOGGER.info("saldoVencer= " + bills.getSaldoVencer() + " para el DN: " + deviceVO.getDn());
	        LOGGER.info("saldoTotal= " + bills.getSaldoTotal() + " para el DN: " + deviceVO.getDn());
	        LOGGER.info("csCurBalance= " + cliente.getCsCurBalance() + " para el DN: " + deviceVO.getDn());
	        
	        //COMPARAMOS SI EL OBJETO NO ESTA VACIO
	        LOGGER.info("Saldos de getSaldosCuenta regresando el tamano de lista " + bills);
	        
	        
	        responseVO.setCode(ATTConstants.CODIGO_EXITO);
	        responseVO.setMessageCode(ATTConstants.DESC_EXITO);
	        responseVO.setObjectResponse(bills);
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_GET_SALDO_CUENTA);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	/**
	 * Este metodo obtiene la informacion de saldos de la factura de una cuenta.
	 * @author Edgar Gutierrez - MindBits Desarrollo (07/OCT/2015)
	 * @param InvoiceVO con los siguientes atributos no nulos y diferentes de cero:
	 * 		CUSTOMERID	[Identificador del cliente].
	 * @param PaymentBillVO
	 * @return PaymentBillVO con los siguientes atributos no nulos y 
	 * distintos de cero:
	 * 		ACCOUNT		[Numero de cuenta del cliente].
	 * 		NUMBERBILL		[Numero de facturacion].
	 * 		AMOUNT		[Monto de la facturacion].
	 * 		DATEBILL	[fecha de facturacion].
	 * 		DATEEXPIRATION	[Fecha de expiracion].
	 * 		BALANCE		[Balance de la factura].
	 */
	private void bill(mx.com.nextel.www.wppp.ws.vo.InvoiceVO factura, PaymentBillVO payment) {
		
		// CREAMOS EL OBJETO DONDE SE ALMACENA LA FECHA DE ENTREGA
		GregorianCalendar deliveryDate = null;
		// CREAMOS EL OBJETO QUE ALMACENA LA FECHA ACTUAL
		GregorianCalendar todayDate = null;
		// LE INDICAMOS EL FORMATO A LA FECHA
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		// CREAMOS UN OBJETO DE GREGORIAN CALENDAR PARA PODER MANEJAR FECHAS
		Calendar calendario = GregorianCalendar.getInstance();
		// OBTENEMOS LA FECHA ACTUAL
		Date fecha = calendario.getTime();
		deliveryDate = new GregorianCalendar();
		todayDate = new GregorianCalendar();
		// CREAMOS EL OBJETO DEL PaymentBillVO PARA PODER OBTENER LOS RESULTADOS
		
		// SETEAMOS LA CUENTA DEL USUARIO
		payment.setAccount( factura.getCustomerId().toString());
		payment.setNumberBill(factura.getInvoiceReference());
		payment.setAmount(factura.getInvoiceAmount().toString());
		// ASIGNAMOS LA FECHA DE FACTURACION
		Date dBill = factura.getInvoiceRefDate();
		// ASIGNAMOS LA FECHA DE EXPIRACION
		Date dExpiracion = factura.getInvoiceDueDate();
		LOGGER.info("Fecha de expiracion de la factura: "
				+ formatoDeFecha.format(dExpiracion));
		LOGGER.info("Hoy es: " + formatoDeFecha.format(fecha));
		// ASIGNAMOS LA FECHA DE ENTREGA CON LA FECHA DE EXPIRACION
		deliveryDate.setTime(dExpiracion);
		// ASIGNAMOS LA FECHA ACTUAL DE LA FACTURA
		todayDate.setTime(fecha);
		// OBTENEMOS EL TOTAL DE LA FACTURA A PARTIR DE LA FACTURA
		LOGGER.info("Total de la factura: " + factura.getInvoiceOpenAmt());
		// VERIFICAMOS SI LA FECHA DEL DIA DE HOY ESTA DESPUES DE LA FECHA DE
		// ENTREGA
		if (todayDate.after(deliveryDate)) {
			payment.setSaldoVencidoTotal(payment.getSaldoVencidoTotal() + factura.getInvoiceOpenAmt());
			payment.setFechaVencido(formatoDeFecha.format(dExpiracion));
			
		} else {
			payment.setSaldoVencerTotal(payment.getSaldoVencerTotal() + factura.getInvoiceOpenAmt());
			payment.setFechaVencer(formatoDeFecha.format(dExpiracion));
			
		}
		// OBTENEMOS EL SALDO ACTUAL DE FACTURACION
		payment.setSaldoAcumTotal(payment.getSaldoAcumTotal() + factura.getInvoiceOpenAmt());
		
		// SETEAMOS EL OBJETO CON LOS NUEVOS VALORES
		// payment.setDateBill(dBill.getDay()+"/"+dBill.getMonth()+"/"+dBill.getYear());
		payment.setDateBill(formatoDeFecha.format(dBill));

		payment.setDateExpiracion(formatoDeFecha.format(dExpiracion));
		payment.setBalance(factura.getInvoiceOpenAmt().toString());

	}
	
	public String getServiceBalance(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getServiceBalance de la clase CustomersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final CustomerVO customerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class);
		try{
			VALIDATOR.validateDN10(customerVO.getUser());
			VALIDATOR.validateEmptyString(customerVO.getSystemId(), "Id del Sistema");
			
			final mx.com.nextel.www.ecommerce.ws.adicion.ConsultaSaldoVO consultaSaldoVO = new mx.com.nextel.www.ecommerce.ws.adicion.ConsultaSaldoVO();
			consultaSaldoVO.setDn(customerVO.getUser());
			consultaSaldoVO.setIdSistema(customerVO.getSystemId());
			//Obtiene el saldo de los monederos mediante el metodo consultaSaldo de los servicios de MAR.
			final ClientesAdicionPortBindingStub clientesAdicionProxy = ClientesAdicionSoapServices.getClientesAdicionService();
			final String responseString = clientesAdicionProxy.getSaldoServiceMovil(new Gson().toJson(consultaSaldoVO));
			final ConsultaSaldoVO consultaSaldoResponse = new Gson().fromJson(responseString, ConsultaSaldoVO.class);
			
			if (consultaSaldoResponse == null || consultaSaldoResponse.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(consultaSaldoResponse.getCode(), ATTConstants.COD_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(consultaSaldoResponse);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_CUSTOMERS);
				responseVO.setMessageCode(consultaSaldoResponse.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_GET_SALDO_CUENTA);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getTicketInfo(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getTicketInfo de la clase CustomersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final OrdenesWPVO ordenesWPVO = new Gson().fromJson(jsonDecrypted, OrdenesWPVO.class);
		try{
			VALIDATOR.validateEmptyLong(Long.parseLong(ordenesWPVO.getOrderID()), "Id de la Orden");
			
			final mx.com.nextel.www.ecommerce.ws.adicion.TicketInfoWPVO ticketInfoWPVO = new mx.com.nextel.www.ecommerce.ws.adicion.TicketInfoWPVO();
			ticketInfoWPVO.setOrderId(Long.parseLong(ordenesWPVO.getOrderID()));
			//Obtiene la informacion del ticket para una orden especificada.
			final ClientesAdicionPortBindingStub clientesAdicionProxy = ClientesAdicionSoapServices.getClientesAdicionService();
			final String responseString = clientesAdicionProxy.getTicketInfoMovil(new Gson().toJson(ticketInfoWPVO));
			final TicketInfoWPVO ticketInfoWPResponse = new Gson().fromJson(responseString, TicketInfoWPVO.class);
			
			if(ticketInfoWPResponse == null || ticketInfoWPResponse.getIdCodeMessage() > ATTConstants.VAL_CERO){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION_ORDEN);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(ticketInfoWPResponse.getIdCodeMessage() == ATTConstants.VAL_CERO){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(ticketInfoWPResponse);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_CUSTOMERS);
				responseVO.setMessageCode(ticketInfoWPResponse.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_GET_SALDO_CUENTA);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getServiceOrder(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getServiceOrder de la clase CustomersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try{
			//Obtiene la informacion de la orden registrada en WebPortal.
			final ClientesOESoapBindingStub clientesAdicionProxy = ClientesOESoapServices.getClientesOEService();
			final String responseString = clientesAdicionProxy.getServiceOrderMovil(jsonDecrypted);
			
			final ResponseVO serviceOrderResponseVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (serviceOrderResponseVO == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION_ORDEN);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(serviceOrderResponseVO.getCode(), ATTConstants.COD_EXITO)){
				JsonElement objectResponseJson = new JsonParser().parse( responseString ).getAsJsonObject().get("objectResponse");
				JsonArray respuestaArray = objectResponseJson.getAsJsonArray();
				
				List<ServiceOrderVO> listaServiceOrderVO = new ArrayList<ServiceOrderVO>();
				for(JsonElement object: respuestaArray){
					ServiceOrderVO serviceOrderVO = new Gson().fromJson(object, ServiceOrderVO.class);
					listaServiceOrderVO.add(serviceOrderVO);
				}
				
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(listaServiceOrderVO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_CUSTOMERS);
				responseVO.setMessageCode(serviceOrderResponseVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_GET_SALDO_CUENTA);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String setServiceOrderRegister(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo setServiceOrderRegister de la clase CustomersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try{
			//Registra la orden en WebPortal.
			final ClientesAdicionPortBindingStub clientesAdicionProxy = ClientesAdicionSoapServices.getClientesAdicionService();
			final String responseString = clientesAdicionProxy.serviceOrderRegisterMovil(jsonDecrypted);
			final ServiceOrderWPVO serviceOrderWPVOResponse = new Gson().fromJson(responseString, ServiceOrderWPVO.class);
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(serviceOrderWPVOResponse);
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_GET_SALDO_CUENTA);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String updateServiceOrderStatus(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo updateServiceOrderStatus de la clase CustomersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try{
			VALIDATOR.validateEmptyString(cadenaJson, "Cadena Json");
			final ServiceOrderWPVO serviceOrderWPVO = new Gson().fromJson(cadenaJson, ServiceOrderWPVO.class);
			
			VALIDATOR.validateEmptyLong(serviceOrderWPVO.getOrderId(), "Id de la Orden");
			VALIDATOR.validateEmptyLong(serviceOrderWPVO.getOrderStatusId(), "Estado de la Orden");
			
			final mx.com.nextel.www.ecommerce.ws.adicion.ServiceOrderWPVO requestServiceOrderWPVO= new mx.com.nextel.www.ecommerce.ws.adicion.ServiceOrderWPVO();
			requestServiceOrderWPVO.setOrderId(serviceOrderWPVO.getOrderId());
			requestServiceOrderWPVO.setOrderStatusId(serviceOrderWPVO.getOrderStatusId());
			requestServiceOrderWPVO.setTxnReference(serviceOrderWPVO.getTxnReference());
			//Actualiza la informacion de la orden en WebPortal.
			final ClientesAdicionPortBindingStub clientesAdicionProxy = ClientesAdicionSoapServices.getClientesAdicionService();
			final String responseString = clientesAdicionProxy.updateServiceOrderStatusMovil(new Gson().toJson(requestServiceOrderWPVO));
			final ServiceOrderWPVO serviceOrderWPVOResponse = new Gson().fromJson(responseString, ServiceOrderWPVO.class);
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(serviceOrderWPVOResponse);
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_GET_SALDO_CUENTA);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
}