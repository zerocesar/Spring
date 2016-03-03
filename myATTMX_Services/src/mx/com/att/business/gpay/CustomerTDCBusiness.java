package mx.com.att.business.gpay;

import java.rmi.RemoteException;

import mx.com.att.populate.PopulateClientesPart1;
import mx.com.att.populate.PopulateClientesPart2;
import mx.com.att.support.ClienteTDCSoapService;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.validator.ValidatorGPAY;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.ClienteTDCVO;
import mx.com.nextel.pggpay.ops.service.impl.CambioContraClienteRequest;
import mx.com.nextel.pggpay.ops.service.impl.CambioContraClienteResponse;
import mx.com.nextel.pggpay.ops.service.impl.ClienteServiceSoapBindingStub;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaInfClienteRequest;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaInfClienteResponse;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaTokenRequest;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaTokenResponse;
import mx.com.nextel.pggpay.ops.service.impl.DesactivaClienteRequest;
import mx.com.nextel.pggpay.ops.service.impl.DesactivaClienteResponse;
import mx.com.nextel.pggpay.ops.service.impl.EstadoRegistroRequest;
import mx.com.nextel.pggpay.ops.service.impl.EstadoRegistroResponse;
import mx.com.nextel.pggpay.ops.service.impl.ModificaClienteRequest;
import mx.com.nextel.pggpay.ops.service.impl.ModificaClienteResponse;
import mx.com.nextel.pggpay.ops.service.impl.RegistroClienteRequest;
import mx.com.nextel.pggpay.ops.service.impl.RegistroClienteResponse;
import mx.com.nextel.pggpay.ops.service.impl.RegistroContrasenaRequest;
import mx.com.nextel.pggpay.ops.service.impl.RegistroContrasenaResponse;


import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class CustomerTDCBusiness {
	
	private static final Logger LOGGER = Logger.getLogger(CustomerTDCBusiness.class);
	private final ValidatorGPAY VALIDATOR = new ValidatorGPAY();
	private final ValidatorATT VALIDATORATT = new ValidatorATT();
	
	public String addCustomer(final String cadenaJson) {
		LOGGER.info("Ejecutando addCustomer de la clase ClienteBusiness");
		final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ClienteServiceSoapBindingStub clienteProxy = ClienteTDCSoapService.consultaProxy();
		final PopulateClientesPart1 populateClientes = new PopulateClientesPart1();
		final ClienteTDCVO requestVO = new Gson().fromJson(jsonDecrypted, ClienteTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
    	
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
		
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.CLIENTETDCVO);
			VALIDATOR.validateAttrString(requestVO.getApMaterno(), "apMaterno");
			VALIDATOR.validateAttrString(requestVO.getApPaterno(), "apPaterno");
			VALIDATOR.validateAttrString(requestVO.getCorreo(), "correo");
			VALIDATOR.validateAttrString(requestVO.getNombres(), "nombres");
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getTelefono(), "telefono");
			VALIDATOR.validateAttrString(requestVO.getCuenta(), "cuenta");
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			
			final RegistroClienteRequest registoReq = populateClientes.addReq(requestVO);
			
			final RegistroClienteResponse registroRes = clienteProxy.addCustomer(registoReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(registroRes, responseVO, requestVO.getPrincipal(), "ClienteService.addCustomer"));	
			responseVO.setCode(ATTConstants.COD_EXITO);
			responseVO.setObjectResponse(populateClientes.addResp(registroRes));
			LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
	    		
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.ClienteService.addCustomer - " , e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}

		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}  
	
	public String changeCredentials(final String cadenaJson)  {
		LOGGER.info("Ejecutando changeCredentials de la clase ClienteBusiness");
		final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ClienteServiceSoapBindingStub clienteProxy = ClienteTDCSoapService.consultaProxy();
		final PopulateClientesPart1 populateClientes = new PopulateClientesPart1();
		final ClienteTDCVO requestVO = new Gson().fromJson(jsonDecrypted, ClienteTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
    	
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
		
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.CLIENTETDCVO);
			VALIDATOR.validateAttrString(requestVO.getCredencial(), ATTConstants.CREDENCIAL);
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getNcredencial(), "nCredencial");
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			
			final CambioContraClienteRequest changeReq = populateClientes.changeReq(requestVO);
			
			final CambioContraClienteResponse changeRes = clienteProxy.changeCredentials(changeReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(changeRes, responseVO, requestVO.getPrincipal(), "ClienteService.changeCredentials"));
			responseVO.setCode(ATTConstants.COD_EXITO);
    		responseVO.setObjectResponse(populateClientes.changeResp(changeRes));
    		LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
    		
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.ClienteService.changeCredentials - " , e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}

		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
    }
	
	public String deleteCustomer(final String cadenaJson)  {
		LOGGER.info("Ejecutando deleteCustomer de la clase ClienteBusiness");
		final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ClienteServiceSoapBindingStub clienteProxy = ClienteTDCSoapService.consultaProxy();
		final PopulateClientesPart1 populateClientes = new PopulateClientesPart1();
		final ClienteTDCVO requestVO = new Gson().fromJson(jsonDecrypted, ClienteTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
    	
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
		
		
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.CLIENTETDCVO);
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getCausa(), "causa");
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			
			final DesactivaClienteRequest desactivaReq = populateClientes.deleteReq(requestVO);
			
			final DesactivaClienteResponse desactivaRes = clienteProxy.deleteCustomer(desactivaReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(desactivaRes, responseVO, requestVO.getPrincipal(), "ClienteService.deleteCustomer"));
			responseVO.setCode(ATTConstants.COD_EXITO);
    		responseVO.setObjectResponse(populateClientes.deleteResp(desactivaRes));
    		LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
    		
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.ClienteService.deleteCustomer - " , e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}

		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}  
	
	public String editCustomer(final String cadenaJson)  {
		LOGGER.info("Ejecutando editCustomer de la clase ClienteBusiness");
		final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ClienteServiceSoapBindingStub clienteProxy = ClienteTDCSoapService.consultaProxy();
		final PopulateClientesPart1 populateClientes = new PopulateClientesPart1();
		final ClienteTDCVO requestVO = new Gson().fromJson(jsonDecrypted, ClienteTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
    	
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
		
		
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.CLIENTETDCVO);
			VALIDATOR.validateAttrString(requestVO.getApMaterno(), "apMaterno");
			VALIDATOR.validateAttrString(requestVO.getApPaterno(), "apPaterno");
			VALIDATOR.validateAttrString(requestVO.getCorreo(), "correo");
			VALIDATOR.validateAttrString(requestVO.getCredencial(), ATTConstants.CREDENCIAL);
			VALIDATOR.validateAttrString(requestVO.getNombres(), "nombres");
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getTelefono(), "telefono");
			VALIDATOR.validateAttrString(requestVO.getCuenta(), "cuenta");
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			
			final ModificaClienteRequest editReq = populateClientes.editReq(requestVO);
			
			final ModificaClienteResponse editaRes = clienteProxy.editCustomer(editReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(editaRes, responseVO, requestVO.getPrincipal(), "ClienteService.editCustomer"));
			responseVO.setCode(ATTConstants.COD_EXITO);
    		responseVO.setObjectResponse(populateClientes.editResp(editaRes));
    		LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
    		
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.ClienteService.editCustomer - " , e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
    	
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}  
	
    public String getCustomerInfo(final String cadenaJson)  {
    	LOGGER.info("Ejecutando getCustomerInfo de la clase ClienteBusiness");
    	final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ClienteServiceSoapBindingStub clienteProxy = ClienteTDCSoapService.consultaProxy();
		final PopulateClientesPart2 populateClientes = new PopulateClientesPart2();
		final ClienteTDCVO requestVO = new Gson().fromJson(jsonDecrypted, ClienteTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
    	
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
		
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.CLIENTETDCVO);
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			
			final ConsultaInfClienteRequest infoReq = populateClientes.infoReq(requestVO);
			
			final ConsultaInfClienteResponse infoRes = clienteProxy.getCustomerInfo(infoReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(infoRes, responseVO, requestVO.getPrincipal(), "ClienteService.getCustomerInfo"));
			responseVO.setCode(ATTConstants.COD_EXITO);
    		responseVO.setObjectResponse(populateClientes.infoResp(infoRes));
    		LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
    		
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.ClienteService.getCustomerInfo - " , e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
    	
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}  

    public String getCustomerSignupStatus(final String cadenaJson)  {
    	LOGGER.info("Ejecutando getCustomerSignupStatus de la clase ClienteBusiness");
    	final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ClienteServiceSoapBindingStub clienteProxy = ClienteTDCSoapService.consultaProxy();
		final PopulateClientesPart2 populateClientes = new PopulateClientesPart2();
		final ClienteTDCVO requestVO = new Gson().fromJson(jsonDecrypted, ClienteTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
    	
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
		
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.CLIENTETDCVO);
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			
			final EstadoRegistroRequest signupReq = populateClientes.signupReq(requestVO);
			
			final EstadoRegistroResponse singnupRes = clienteProxy.getCustomerSignupStatus(signupReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(singnupRes, responseVO, requestVO.getPrincipal(), "ClienteService.getCustomerSignupStatus"));
			responseVO.setCode(ATTConstants.COD_EXITO);
    		responseVO.setObjectResponse(populateClientes.signupResp(singnupRes));
    		LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
    		
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.ClienteService.getCustomerSignupStatus - " , e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
    	
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}
    
    public String getCustomerToken(final String cadenaJson)  {
    	LOGGER.info("Ejecutando getCustomerToken de la clase ClienteBusiness");
    	final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ClienteServiceSoapBindingStub clienteProxy = ClienteTDCSoapService.consultaProxy();
		final PopulateClientesPart2 populateClientes = new PopulateClientesPart2();
		final ClienteTDCVO requestVO = new Gson().fromJson(jsonDecrypted, ClienteTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
    	
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
		
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.CLIENTETDCVO);
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			
			final ConsultaTokenRequest tokenReq = populateClientes.getTokenReq(requestVO);
			
			final ConsultaTokenResponse tokenRes = clienteProxy.getCustomerToken(tokenReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(tokenRes, responseVO, requestVO.getPrincipal(), "ClienteService.getCustomerToken"));
			responseVO.setCode(ATTConstants.COD_EXITO);
    		responseVO.setObjectResponse(populateClientes.getTokenResp(tokenRes));
    		LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
    		
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.ClienteService.getCustomerToken - " , e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
		
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}
    
    public String setCustomerCredentials(final String cadenaJson)  {
    	LOGGER.info("Ejecutando setCustomerCredentials de la clase ClienteBusiness");
    	final String jsonDecrypted = VALIDATORATT.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ClienteServiceSoapBindingStub clienteProxy = ClienteTDCSoapService.consultaProxy();
		final PopulateClientesPart2 populateClientes = new PopulateClientesPart2();
		final ClienteTDCVO requestVO = new Gson().fromJson(jsonDecrypted, ClienteTDCVO.class);
		
    	final ResponseVO responseVO = new ResponseVO();
    	
    	responseVO.setCode(ATTConstants.COD_ERROR);
		responseVO.setMessageCode(ATTConstants.DES_ERR_DAT_ENT);
		responseVO.setObjectResponse(null);
		
		try {
			VALIDATOR.validateVO(requestVO, ATTConstants.CLIENTETDCVO);
			VALIDATOR.validateAttrString(requestVO.getCredencial(), ATTConstants.CREDENCIAL);
			VALIDATOR.validateAttrString(requestVO.getPrincipal(), ATTConstants.PRINCIPAL);
			VALIDATOR.validateAttrString(requestVO.getPrincipalApp(), ATTConstants.PRINCIPALAPP);
			requestVO.setCredencialApp(VALIDATOR.validateCredencialApp(requestVO.getPrincipalApp()));
			
			final RegistroContrasenaRequest registroReq = populateClientes.setCredentialsReq(requestVO);
			
			final RegistroContrasenaResponse registroRes = clienteProxy.setCustomerCredentials(registroReq);
			
			responseVO.setMessageCode(VALIDATOR.validateServiceResponse(registroRes, responseVO, requestVO.getPrincipal(), "ClienteService.setCustomerCredentials"));
			responseVO.setCode(ATTConstants.COD_EXITO);
    		responseVO.setObjectResponse(populateClientes.setCredentialsResp(registroRes));
    		LOGGER.info(ATTConstants.DES_EXITO_LOG + requestVO.getPrincipal());
    		
		} catch (ValidateException e1) {
			LOGGER.error(e1.getMessage());
			responseVO.setObjectResponse(e1.getMessage());
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error al consultar los servicios OnlinePaymentService.ClienteService.setCustomerCredentials - " , e);
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
		}
		
		return VALIDATORATT.validateResponseString(new Gson().toJson(responseVO));
	}  
}