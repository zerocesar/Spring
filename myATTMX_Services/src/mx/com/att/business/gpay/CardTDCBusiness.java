package mx.com.att.business.gpay;

import java.rmi.RemoteException;

import mx.com.att.populate.PopulateTarjeta;
import mx.com.att.support.TarjetaTDCSoapService;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.validator.ValidatorGPAY;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.TarjetaTDCVO;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaTDCRequest;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaTDCResponse;
import mx.com.nextel.pggpay.ops.service.impl.DesactivaTDCRequest;
import mx.com.nextel.pggpay.ops.service.impl.DesactivaTDCResponse;
import mx.com.nextel.pggpay.ops.service.impl.PredetTDCRequest;
import mx.com.nextel.pggpay.ops.service.impl.PredetTDCResponse;
import mx.com.nextel.pggpay.ops.service.impl.RegistraTDCRequest;
import mx.com.nextel.pggpay.ops.service.impl.RegistraTDCResponse;
import mx.com.nextel.pggpay.ops.service.impl.TarjetaServiceSoapBindingStub;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class CardTDCBusiness {

	private static final Logger LOGGER = Logger.getLogger(CardTDCBusiness.class);
	private final ValidatorGPAY VALIDATOR = new ValidatorGPAY();
	private final ValidatorATT VALIDATORATT = new ValidatorATT();
	
	public String addCustomerTDC(final String cadenaJson){
		LOGGER.info("Ejecutando addCustomerTDC de la clase CardTDCBusiness");
		final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final TarjetaServiceSoapBindingStub tarjetaProxy = TarjetaTDCSoapService.consultaProxy();
		final PopulateTarjeta populateTarjeta = new PopulateTarjeta();
		final TarjetaTDCVO requestVO = new Gson().fromJson(jsonDecrypted, TarjetaTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
		
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
    	
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.TARJETATDCVO);
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getCredencial(), ATTConstants.CREDENCIAL);
			VALIDATOR.validateAttrString(requestVO.getTipo(), "tipo");
			VALIDATOR.validateAttrString(requestVO.getTarjetaHabiente(), "tarjetaHabiente");
			VALIDATOR.validateAttrString(requestVO.getNumero(), "numero");
			VALIDATOR.validateAttrString(requestVO.getVigencia(), "vigencia");
			VALIDATOR.validateAttrString(requestVO.getCodigo(), "codigo");
			
			final RegistraTDCRequest registraReq = populateTarjeta.addCustReq(requestVO);
			
			final RegistraTDCResponse registraRes = tarjetaProxy.addCustomerTDC(registraReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(registraRes, responseVO, requestVO.getPrincipal(), "TarjetaService.addCustomerTDC"));
			responseVO.setCode(ATTConstants.COD_EXITO);
			responseVO.setObjectResponse(populateTarjeta.addCustRes(registraRes));
			LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
			
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.TarjetaService.addCustomerTDC - ", e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
    		
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String defaultCustomerTDC(final String cadenaJson){
		LOGGER.info("Ejecutando defaultCustomerTDC de la clase CardTDCBusiness");
		final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final TarjetaServiceSoapBindingStub tarjetaProxy = TarjetaTDCSoapService.consultaProxy();
		final PopulateTarjeta populateTarjeta = new PopulateTarjeta();
		final TarjetaTDCVO requestVO = new Gson().fromJson(jsonDecrypted, TarjetaTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
		
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
    	
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.TARJETATDCVO);
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getCredencial(), ATTConstants.CREDENCIAL);
			VALIDATOR.validateAttrString(requestVO.getIdTarjeta(), "idTarjeta");
			
			final PredetTDCRequest predetReq = populateTarjeta.defaultCustReq(requestVO);
			
			final PredetTDCResponse predetRes = tarjetaProxy.defaultCustomerTDC(predetReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(predetRes, responseVO, requestVO.getPrincipal(), "TarjetaService.defaultCustomerTDC"));
			responseVO.setCode(ATTConstants.COD_EXITO);
			responseVO.setObjectResponse(populateTarjeta.defaultCustRes(predetRes));
			LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
			
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.TarjetaService.defaultCustomerTDC - ", e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
    	
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getCustomerTDC(final String cadenaJson){
		LOGGER.info("Ejecutando getCustomerTDC de la clase CardTDCBusiness");
		final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final TarjetaServiceSoapBindingStub tarjetaProxy = TarjetaTDCSoapService.consultaProxy();
		final PopulateTarjeta populateTarjeta = new PopulateTarjeta();
		final TarjetaTDCVO requestVO = new Gson().fromJson(jsonDecrypted, TarjetaTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
		
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
    	
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.TARJETATDCVO);
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			
			final ConsultaTDCRequest consultaReq = populateTarjeta.getCustReq(requestVO);
			
			final ConsultaTDCResponse consultaRes = tarjetaProxy.getCustomerTDC(consultaReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(consultaRes, responseVO, requestVO.getPrincipal(), "TarjetaService.getCustomerTDC"));
			responseVO.setCode(ATTConstants.COD_EXITO);
			responseVO.setObjectResponse(populateTarjeta.getCustRes(consultaRes));
			LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
			
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.TarjetaService.getCustomerTDC - ", e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
		
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String deleteCustomerTDC(final String cadenaJson){
		LOGGER.info("Ejecutando deleteCustomerTDC de la clase CardTDCBusiness");
		final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final TarjetaServiceSoapBindingStub tarjetaProxy = TarjetaTDCSoapService.consultaProxy();
		final PopulateTarjeta populateTarjeta = new PopulateTarjeta();
		final TarjetaTDCVO requestVO = new Gson().fromJson(jsonDecrypted, TarjetaTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
		
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
    	
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.TARJETATDCVO);
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getCredencial(), ATTConstants.CREDENCIAL);
			VALIDATOR.validateAttrString(requestVO.getIdTarjeta(), "idTarjeta");
			VALIDATOR.validateAttrString(requestVO.getCausa(), "causa");
			
			final DesactivaTDCRequest desactivaReq = populateTarjeta.deleteCustReq(requestVO);
			
			final DesactivaTDCResponse desactivaRes = tarjetaProxy.deleteCustomerTDC(desactivaReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(desactivaRes, responseVO, requestVO.getPrincipal(), "TarjetaService.deleteCustomerTDCRequest"));
			responseVO.setCode(ATTConstants.COD_EXITO);
			responseVO.setObjectResponse(populateTarjeta.deleteCustRes(desactivaRes));
			LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
			
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.TarjetaService.deleteCustomerTDC - ", e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
    	
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}
}