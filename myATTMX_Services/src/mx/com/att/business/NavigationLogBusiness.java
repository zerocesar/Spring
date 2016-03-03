package mx.com.att.business;

import java.rmi.RemoteException;

import mx.com.att.dao.orange.CsqSubcategoryVO;
import mx.com.att.support.NavigationLogSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.orange.LoginAttemptVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.LoginVO;
import mx.com.att.vo.orange.NavigationVO;
import mx.com.att.vo.orange.SugerenciasVO;
import mx.com.nextel.www.ecommerce.ws.navigationLog.EcommerceServiceBindingStub;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class NavigationLogBusiness {
	private static final Logger LOGGER = Logger.getLogger(NavigationLogBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT(); 
	
	public String csqRegister(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo csqRegister de la clase NavigationLogBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final SugerenciasVO sugerenciasVO = new Gson().fromJson(jsonDecrypted, SugerenciasVO.class);
		
		try {
			//Se registra la informacion de los intentos fallidos de login del usuario en bitacora de logs
			LOGGER.info("Se registra la informacion para el Login: " + sugerenciasVO.getLoginId());
			final EcommerceServiceBindingStub ecommerceNavigationLogProxy = NavigationLogSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceNavigationLogProxy.csqRegisterMovil(jsonDecrypted);
			final ResponseVO responseNavigationVO = new Gson().fromJson(responseString, ResponseVO.class);
			if (responseNavigationVO == null || responseNavigationVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NAVIGATION_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseNavigationVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseNavigationVO.getCode(), ATTConstants.CODIGO_ERROR_CSQ_REGISTER)){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_CSQ_REGISTER);
				responseVO.setMessageCode(ATTConstants.DESC_CODIGO_CSQ_REGISTER);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseNavigationVO.getCode());
				responseVO.setMessageCode(responseNavigationVO.getMessageCode());
				responseVO.setObjectResponse(responseNavigationVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getCsqCatSubcategory(){
		LOGGER.info("Comienza la ejecucion del metodo getCsqCatSubcategory de la clase NavigationLogBusiness");
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			//Se obtiene la informacion de la lista de opciones para Evaluanos
			LOGGER.info("Se obtiene la lista de opciones para Evaluanos");
			final EcommerceServiceBindingStub ecommerceNavigationLogProxy = NavigationLogSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceNavigationLogProxy.getCsqCatSubcategoryMovil();
			final ResponseVO responseNavigationVO = new Gson().fromJson(responseString, ResponseVO.class);

			if (responseNavigationVO == null || responseNavigationVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NAVIGATION_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseNavigationVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(new Gson().fromJson(new Gson().toJson(responseNavigationVO.getObjectResponse()), CsqSubcategoryVO[].class));
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(responseNavigationVO.getCode());
				responseVO.setMessageCode(responseNavigationVO.getMessageCode());
				responseVO.setObjectResponse(responseNavigationVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String login(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo login de la clase NavigationLogBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			//Se registra la informacion de los intentos fallidos de login del usuario en bitacora de logs
			final EcommerceServiceBindingStub ecommerceNavigationLogProxy = NavigationLogSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceNavigationLogProxy.loginMovil(jsonDecrypted);
			final ResponseVO responseNavigationVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseNavigationVO == null || responseNavigationVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NAVIGATION_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseNavigationVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(new Gson().fromJson(new Gson().toJson(responseNavigationVO.getObjectResponse()), Long.class));
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(responseNavigationVO.getCode());
				responseVO.setMessageCode(responseNavigationVO.getMessageCode());
				responseVO.setObjectResponse(responseNavigationVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String loginAttempt(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo loginAttempt de la clase NavigationLogBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final LoginAttemptVO loginAttemptVO = new Gson().fromJson(jsonDecrypted, LoginAttemptVO.class);
		
		try {
			VALIDATOR.validateEmptyString(""+loginAttemptVO.getLoginId(), "Identificador del Login");
			
			//Se registra la informacion de los intentos fallidos de login del usuario en bitacora de logs
			LOGGER.info("Se registra la informacion para el Login: " + loginAttemptVO.getLoginId());
			final EcommerceServiceBindingStub ecommerceNavigationLogProxy = NavigationLogSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceNavigationLogProxy.loginAttemptMovil(jsonDecrypted);
			final ResponseVO responseNavigationVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseNavigationVO == null || responseNavigationVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NAVIGATION_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseNavigationVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(responseNavigationVO.getCode());
				responseVO.setMessageCode(responseNavigationVO.getMessageCode());
				responseVO.setObjectResponse(responseNavigationVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String logNavigation(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo logNavigation de la clase NavigationLogBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final NavigationVO navigationVO = new Gson().fromJson(jsonDecrypted, NavigationVO.class);
		
		try {
			VALIDATOR.validateEmptyString(""+navigationVO.getLoginId(), "Identificador del Login");
			
			//Se registra la informacion del login del usuario en bitacora de logs
			LOGGER.info("Se registra la informacion para el Login: " + navigationVO.getLoginId());
			final EcommerceServiceBindingStub ecommerceNavigationLogProxy = NavigationLogSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceNavigationLogProxy.logNavigationMovil(jsonDecrypted);
			final ResponseVO responseNavigationVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseNavigationVO == null || responseNavigationVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NAVIGATION_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseNavigationVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(responseNavigationVO.getCode());
				responseVO.setMessageCode(responseNavigationVO.getMessageCode());
				responseVO.setObjectResponse(responseNavigationVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String logout(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo logout de la clase NavigationLogBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final LoginVO loginVO = new Gson().fromJson(jsonDecrypted, LoginVO.class);
		
		try {
			VALIDATOR.validateEmptyString(""+loginVO.getLoginId(), "Identificador del Login");
			
			//Se registra la informacion del logout del usuario en bitacora de logs
			LOGGER.info("Se registra la informacion para el Login: " + loginVO.getLoginId());
			final EcommerceServiceBindingStub ecommerceNavigationLogProxy = NavigationLogSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceNavigationLogProxy.logoutMovil(jsonDecrypted);
			final ResponseVO responseNavigationVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseNavigationVO == null || responseNavigationVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NAVIGATION_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseNavigationVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(responseNavigationVO.getCode());
				responseVO.setMessageCode(responseNavigationVO.getMessageCode());
				responseVO.setObjectResponse(responseNavigationVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
}