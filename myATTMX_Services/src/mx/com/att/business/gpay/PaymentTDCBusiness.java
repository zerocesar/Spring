package mx.com.att.business.gpay;

import java.rmi.RemoteException;

import mx.com.att.populate.PopulatePagos;
import mx.com.att.support.PagosTDCSoapService;
import mx.com.att.support.PaymentGatewaySoapService;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.validator.ValidatorGPAY;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.BankTransResWPVO;
import mx.com.att.vo.gpay.PagoTDCVO;
import mx.com.att.vo.orange.ServiceOrderWPVO;
import mx.com.nextel.pggpay.ops.service.impl.ConsTransaccionesRequest;
import mx.com.nextel.pggpay.ops.service.impl.ConsTransaccionesResponse;
import mx.com.nextel.pggpay.ops.service.impl.PagoLineaRequest;
import mx.com.nextel.pggpay.ops.service.impl.PagoLineaResponse;
import mx.com.nextel.pggpay.ops.service.impl.PagosServiceSoapBindingStub;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nextel.pgw.ws.PaymentGatewayWSSoapBindingStub;

public class PaymentTDCBusiness {

	private static final Logger LOGGER = Logger.getLogger(PaymentTDCBusiness.class);
	private final ValidatorGPAY VALIDATOR = new ValidatorGPAY();
	private final ValidatorATT VALIDATORATT = new ValidatorATT();
	
	public String addTransaction(final String cadenaJson){
		LOGGER.info("Ejecutando addTransaction de la clase PagosBusiness");
		final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final PagosServiceSoapBindingStub pagosProxy = PagosTDCSoapService.consultaProxy();
		final PaymentGatewayWSSoapBindingStub webService = PaymentGatewaySoapService.consultaProxy();
		final PopulatePagos populatePagos = new PopulatePagos();
		final BankTransResWPVO bankTransResWPVO = new BankTransResWPVO();
		final ServiceOrderWPVO serviceOrderWPVO = new ServiceOrderWPVO();
		final PagoTDCVO requestVO = new Gson().fromJson(jsonDecrypted, PagoTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
		
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
    	
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.PAGOTDCVO);
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getCredencial(), ATTConstants.CREDENCIAL);
			VALIDATOR.validateAttrString(requestVO.getIdTarjeta(), "idTarjeta");
			VALIDATOR.validateAttrString(requestVO.getCodigo(), "codigo");
			VALIDATOR.validateAttrString(requestVO.getReferencia(), "referencia");
			VALIDATOR.validateAttrFloat(requestVO.getMonto(), "monto");
			VALIDATOR.validateAttrInteger(requestVO.getIdServicio(), "idServicio");
			VALIDATOR.validateAttrString(requestVO.getDescripcion(), "descripcion");
			
			final PagoLineaRequest pagoLineaReq = populatePagos.addTransReq(requestVO);
			
			LOGGER.info("Se manda la peticion a los OnlinePaymentService.addTransaction.");
			final PagoLineaResponse pagoLineaRes = pagosProxy.addTransaction(pagoLineaReq);
			LOGGER.info("Finaliza la peticion a los OnlinePaymentService.addTransaction.");
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(pagoLineaRes, responseVO, requestVO.getPrincipal(), requestVO.getReferencia(), "PagosService.addTransaction", bankTransResWPVO, serviceOrderWPVO));
			responseVO.setCode(ATTConstants.COD_EXITO);
			responseVO.setObjectResponse(populatePagos.addTransRes(pagoLineaRes));
			LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
			
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.PagosService.addTransaction - ", e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
    	
		try {
			LOGGER.info("Se procede a registrar el orderId: " + bankTransResWPVO.getOrderId() + " con la referencia bancaria: " + bankTransResWPVO.getAuthorizeId() + " en la tabla WP_GPAY_RESP");
			final com.nextel.pgw.ws.vo.BankTransResWPVO bankResponse = webService.bankTransResponseGpayRegister(populatePagos.getBankTransReq(bankTransResWPVO));
			if (bankResponse == null){
				LOGGER.error("Ocurrio un error en los PaymentGatewayServices en el metodo bankTransResponseGpayRegister respondio null");
			} else{
				LOGGER.info("El servicio respondio con el codigo: " + bankResponse.getIdCodeMessage() + " y el mensaje: " + bankResponse.getMessageCode() + " para el COID: " + bankTransResWPVO.getOrderId() + " --- (Codigo 0.- Exito, Codigo 1.-Error) ---");
			}
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios PaymentGateway.bankTransResponseGpayRegister - ", e);
		}
		
		try {
			LOGGER.info("Se procede a cambiar el estatus de la orden: " + serviceOrderWPVO.getOrderId() + " con estatus: " + serviceOrderWPVO.getOrderStatusId() + " en webportal");
			final com.nextel.pgw.ws.vo.ServiceOrderWPVO servOrderRes = webService.updateServiceOrderStatus(populatePagos.getServiceOrderReq(serviceOrderWPVO));
			if (servOrderRes == null){
				LOGGER.error("Ocurrio un error en los PaymentGatewayServices en el metodo updateServiceOrderStatus, respuesta NULA");
			} else{
				LOGGER.info("El servicio respondio con el codigo: " + servOrderRes.getIdCodeMessage() + " y el mensaje: " + servOrderRes.getMessageCode() + " --- (Codigo 0.- Exito, Codigo 1.-Error) ---");
			}
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios PaymentGateway.updateServiceOrderStatus - ", e);
			
			try {
				LOGGER.info("Se procede con el SEGUNDO REINTENTO para cambiar el estatus de la orden: " + serviceOrderWPVO.getOrderId() + " con estatus: " + serviceOrderWPVO.getOrderStatusId() + " en webportal");
				final com.nextel.pgw.ws.vo.ServiceOrderWPVO servOrderRes = webService.updateServiceOrderStatus(populatePagos.getServiceOrderReq(serviceOrderWPVO));
				if (servOrderRes == null){
					LOGGER.error("Ocurrio un error en el SEGUNDO REINTENTO en los PaymentGatewayServices en el metodo updateServiceOrderStatus, respuesta NULA");
				} else{
					LOGGER.info("En el SEGUNDO REINTENTO el servicio respondio con el codigo: " + servOrderRes.getIdCodeMessage() + " y el mensaje: " + servOrderRes.getMessageCode() + " --- (Codigo 0.- Exito, Codigo 1.-Error) ---");
				}
			} catch (RemoteException e1) {
				LOGGER.error("Ocurrio error en el SEGUNDO REINTENTO al consultar los servicios PaymentGateway.updateServiceOrderStatus - ", e);
			}
		}
		
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getTransactionInfo(final String cadenaJson){
		LOGGER.info("Ejecutando getTransactionInfo de la clase PagosBusiness");
		final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final PagosServiceSoapBindingStub pagosProxy = PagosTDCSoapService.consultaProxy();
		final PopulatePagos populatePagos = new PopulatePagos();
		final PagoTDCVO requestVO = new Gson().fromJson(jsonDecrypted, PagoTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
		
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
    	
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.PAGOTDCVO);
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getCredencial(), ATTConstants.CREDENCIAL);
			VALIDATOR.validateAttrString(requestVO.getReferencia(), "referencia");
			
			final ConsTransaccionesRequest transReq = populatePagos.getTransReq(requestVO);
			
			final ConsTransaccionesResponse transRes = pagosProxy.getTransactionInfo(transReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(transRes, responseVO, requestVO.getPrincipal(), "PagosService.getTransactionInfo"));
			responseVO.setCode(ATTConstants.COD_EXITO);
			responseVO.setObjectResponse(populatePagos.getTransRes(transRes));
			LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
			
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.PagosService.getTransactionInfo - ", e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
    	
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}
}