package mx.com.att.business;

import java.rmi.RemoteException;

import mx.com.att.dao.LoginDAO;
import mx.com.att.dao.LoginDAOImpl;
import mx.com.att.support.ClientesOESoapServices;
import mx.com.att.support.MasterPINSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.utils.CryptoHelper;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.DeviceVO;
import mx.com.att.vo.orange.ListaVO;
import mx.com.att.vo.orange.MasterPINLogVO;
import mx.com.att.vo.orange.MasterPinVO;
import mx.com.att.vo.orange.MasterVO;
import mx.com.nextel.ecommerce.ws.exception.EcommerceWSException;
import mx.com.nextel.www.ecommerce.ws.cliente.ClientesOESoapBindingStub;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import ws.ecommerce.nextel.com.mx.masterpin.MasterPINServicePortBindingStub;

public class MasterPINBusiness {

	private static final Logger LOGGER = Logger.getLogger(MasterPINBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	
	public String getQuestions(String question) {
		LOGGER.info("Comienza la ejecucion del metodo getQuestions de la clase MasterPINBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(question);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			final MasterPINServicePortBindingStub masterPINProxy = MasterPINSoapServices.getMasterPINService();
			final String responseMasterPIN = masterPINProxy.consultaPreguntasMovil(jsonDecrypted);
			final ResponseVO responseMasterPINVO = new Gson().fromJson(responseMasterPIN, ResponseVO.class);
			
			if (responseMasterPINVO == null || responseMasterPINVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseMasterPINVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(new Gson().fromJson(new Gson().toJson(responseMasterPINVO.getObjectResponse()), ListaVO.class));
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseMasterPINVO.getCode());
				responseVO.setMessageCode(responseMasterPINVO.getMessageCode());
				responseVO.setObjectResponse(responseMasterPINVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getAnswers(String respuestas) {
		LOGGER.info("Comienza la ejecucion del metodo getAnswers de la clase MasterPINBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(respuestas);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			final ListaVO listaVO = new Gson().fromJson(jsonDecrypted, ListaVO.class);
			VALIDATOR.validateEmptyString(listaVO.getCustCode(), "CustCode");
			VALIDATOR.validateDN10(listaVO.getDn());
			/*Descomentar para Seguridad Begin*/
			//VALIDATOR.validateEmptyString(listaVO.getUserPassword(),"UserPassword");
			/*Descomentar para Seguridad End*/
			String currentPassword = listaVO.getUserPassword();
			final LoginDAO loginDAO = new LoginDAOImpl();
			/*Comentar para Seguridad Begin*/
			if (listaVO.getUserPassword() == null){
				final String encryptPassword = loginDAO.getDecriptedPassword(listaVO.getDn());
				currentPassword = CryptoHelper.decrypt((encryptPassword == null)?"":encryptPassword);
			}
			/*Comentar para Seguridad End*/
			final String userPassLdap = loginDAO.getDecriptedPassword(listaVO.getDn());
			if (userPassLdap == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
				responseVO.setMessageCode(ATTConstants.DESC_PASSWORD_INCORRECT);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else if (currentPassword.equals(CryptoHelper.decrypt(userPassLdap))){
				final MasterPINServicePortBindingStub masterPINProxy = MasterPINSoapServices.getMasterPINService();
				final String responseMasterPIN = masterPINProxy.consultaRespuestasMovil(jsonDecrypted);
				final ResponseVO responseMasterPINVO = new Gson().fromJson(responseMasterPIN, ResponseVO.class);
				
				if (responseMasterPINVO == null || responseMasterPINVO.getCode() == null){
					responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
					responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				} else if(VALIDATOR.validateGetCode(responseMasterPINVO.getCode(), ATTConstants.CODIGO_EXITO)){
					responseVO.setCode(ATTConstants.CODIGO_EXITO);
					responseVO.setMessageCode(ATTConstants.DESC_EXITO);
					responseVO.setObjectResponse(new Gson().fromJson(new Gson().toJson(responseMasterPINVO.getObjectResponse()), ListaVO.class));
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				} else{
					responseVO.setCode(responseMasterPINVO.getCode());
					responseVO.setMessageCode(responseMasterPINVO.getMessageCode());
					responseVO.setObjectResponse(responseMasterPINVO.getObjectResponse());
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				}
			}else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
				responseVO.setMessageCode(ATTConstants.DESC_PASSWORD_INCORRECT);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String recoverMasterPIN(String masterPIN) {
		LOGGER.info("Comienza la ejecucion del metodo recoverMasterPIN de la clase MasterPINBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(masterPIN);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			final MasterPinVO masterPinVO = new Gson().fromJson(jsonDecrypted,MasterPinVO.class);
			VALIDATOR.validateEmptyString(masterPinVO.getCustomerId().toString(), "Customer Id");
			/*Descomentar para Seguridad Begin*/
			//VALIDATOR.validateEmptyString(masterPinVO.getUserPassword(),"UserPassword");
			//VALIDATOR.validateDN10(masterPinVO.getDn());
			/*Descomentar para Seguridad End*/
			String currentPassword = masterPinVO.getUserPassword();
			final LoginDAO loginDAO = new LoginDAOImpl();
			/*Comentar para Seguridad Begin*/
			if (masterPinVO.getUserPassword() == null && masterPinVO.getDn() != null){
				final String encryptPassword = loginDAO.getDecriptedPassword(masterPinVO.getDn());
				currentPassword = CryptoHelper.decrypt((encryptPassword == null)?"":encryptPassword);
			}
			/*Comentar para Seguridad End*/
			final String userPassLdap = loginDAO.getDecriptedPassword((masterPinVO.getDn()==null)?"1":masterPinVO.getDn());
			if (userPassLdap == null && masterPinVO.getDn() != null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
				responseVO.setMessageCode(ATTConstants.DESC_PASSWORD_INCORRECT);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else if ((currentPassword!=null && userPassLdap!=null && currentPassword.equals(CryptoHelper.decrypt(userPassLdap))) || masterPinVO.getDn()==null){
				masterPinVO.setDn(null);
				final MasterPINServicePortBindingStub masterPINProxy = MasterPINSoapServices.getMasterPINService();
				final String responseMasterPIN = masterPINProxy.recuperaMasterPINMovil(new Gson().toJson(masterPinVO)).replace("\"", "");
				
				VALIDATOR.validateEmptyString(responseMasterPIN, "MasterPIN");
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseMasterPIN);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
				responseVO.setMessageCode(ATTConstants.DESC_PASSWORD_INCORRECT);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
			responseVO.setMessageCode(ATTConstants.DESC_CODIGO_ERROR_MPIN);
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getBlockedRecovery(String custCode) {
		LOGGER.info("Comienza la ejecucion del metodo getBlockedRecovery de la clase MasterPINBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(custCode);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final PaymentRespVO paymentRespVO = new Gson().fromJson(jsonDecrypted, PaymentRespVO.class);
		
		try {
			
			VALIDATOR.validateEmptyString(paymentRespVO.getCustomerCode(), "CustomerCode");
			final MasterPINServicePortBindingStub masterPINProxy = MasterPINSoapServices.getMasterPINService();
			final String responseMasterPIN = masterPINProxy.consultaBloqueoRecuperacionMovil(paymentRespVO.getCustomerCode());
			final ResponseVO responseMasterPINVO = new Gson().fromJson(responseMasterPIN, ResponseVO.class);
			
			if (responseMasterPINVO == null || responseMasterPINVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseMasterPINVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(new Gson().fromJson(new Gson().toJson(responseMasterPINVO.getObjectResponse()), MasterPINLogVO.class));
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseMasterPINVO.getCode());
				responseVO.setMessageCode(responseMasterPINVO.getMessageCode());
				responseVO.setObjectResponse(responseMasterPINVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String changeMasterPIN(String master) {
		LOGGER.info("Comienza la ejecucion del metodo changeMasterPIN de la clase MasterPINBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(master);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			final MasterPINServicePortBindingStub masterPINProxy = MasterPINSoapServices.getMasterPINService();
			final String responseMasterPIN = masterPINProxy.cambiarMasterPINMovil(jsonDecrypted);
			final ResponseVO responseMasterPINVO = new Gson().fromJson(responseMasterPIN, ResponseVO.class);
			
			if (responseMasterPINVO == null || responseMasterPINVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseMasterPINVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(new Gson().fromJson(new Gson().toJson(responseMasterPINVO.getObjectResponse()), MasterVO.class));
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseMasterPINVO.getCode());
				responseVO.setMessageCode(responseMasterPINVO.getMessageCode());
				responseVO.setObjectResponse(responseMasterPINVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String validateMasterPinWithLock(String masterPin) {
		LOGGER.info("Comienza la ejecucion del metodo validateMasterPinWithLock de la clase MasterPINBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(masterPin);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			final MasterPinVO masterPinVO = new Gson().fromJson(jsonDecrypted,MasterPinVO.class);
			VALIDATOR.validateEmptyLong(masterPinVO.getCustomerId(), "Customer Id");
			/*Descomentar para Seguridad Begin*/
			//VALIDATOR.validateEmptyString(masterPinVO.getUserPassword(),"UserPassword");
			VALIDATOR.validateDN10(masterPinVO.getDn());
			VALIDATOR.validateEmptyString(masterPinVO.getMaster(), "MasterPIN");
			/*Descomentar para Seguridad End*/
			String currentPassword = masterPinVO.getUserPassword();
			final LoginDAO loginDAO = new LoginDAOImpl();
			/*Comentar para Seguridad Begin*/
			if (masterPinVO.getUserPassword() == null){
				final String encryptPassword = loginDAO.getDecriptedPassword(masterPinVO.getDn());
				currentPassword = CryptoHelper.decrypt((encryptPassword == null)?"":encryptPassword);
			}
			/*Comentar para Seguridad End*/
			final String userPassLdap = loginDAO.getDecriptedPassword(masterPinVO.getDn());
			if (userPassLdap == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
				responseVO.setMessageCode(ATTConstants.DESC_PASSWORD_INCORRECT);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else if (currentPassword.equals(CryptoHelper.decrypt(userPassLdap))){
				final MasterPINServicePortBindingStub masterPINProxy = MasterPINSoapServices.getMasterPINService();
				final String responseMasterPIN = masterPINProxy.validaMasterPinConBloqueoMovil(jsonDecrypted);
				final ResponseVO responseMasterPINVO = new Gson().fromJson(responseMasterPIN, ResponseVO.class);
				
				if (responseMasterPINVO == null || responseMasterPINVO.getCode() == null){
					responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
					responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				} else if(VALIDATOR.validateGetCode(responseMasterPINVO.getCode(), ATTConstants.CODIGO_EXITO)){
					responseVO.setCode(ATTConstants.CODIGO_EXITO);
					responseVO.setMessageCode(ATTConstants.DESC_EXITO);
					responseVO.setObjectResponse(responseMasterPINVO.getObjectResponse().toString().replace("\"", ""));
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				} else{
					responseVO.setCode(responseMasterPINVO.getCode());
					responseVO.setMessageCode(responseMasterPINVO.getMessageCode());
					responseVO.setObjectResponse(responseMasterPINVO.getObjectResponse());
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				}
			}else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
				responseVO.setMessageCode(ATTConstants.DESC_PASSWORD_INCORRECT);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getBlockedValidation(String custCode) {
		LOGGER.info("Comienza la ejecucion del metodo getBlockedRecovery de la clase MasterPINBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(custCode);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final PaymentRespVO paymentRespVO = new Gson().fromJson(jsonDecrypted, PaymentRespVO.class);
		
		try {
			
			VALIDATOR.validateEmptyString(paymentRespVO.getCustomerCode(), "CustomerCode");
			final MasterPINServicePortBindingStub masterPINProxy = MasterPINSoapServices.getMasterPINService();
			final String responseMasterPIN = masterPINProxy.consultaBloqueoValidacionMovil(paymentRespVO.getCustomerCode());
			final ResponseVO responseMasterPINVO = new Gson().fromJson(responseMasterPIN, ResponseVO.class);
			
			if (responseMasterPINVO == null || responseMasterPINVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseMasterPINVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(new Gson().fromJson(new Gson().toJson(responseMasterPINVO.getObjectResponse()), MasterPINLogVO.class));
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseMasterPINVO.getCode());
				responseVO.setMessageCode(responseMasterPINVO.getMessageCode());
				responseVO.setObjectResponse(responseMasterPINVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String validateMasterPinWithoutLock(String device) {
		LOGGER.info("Comienza la ejecucion del metodo validateMasterPinWithLock de la clase MasterPINBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(device);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			final DeviceVO deviceVO = new Gson().fromJson(device, DeviceVO.class);
			VALIDATOR.validateEmptyLong(deviceVO.getSmcId(), "MasterPin");
			VALIDATOR.validateDN12(deviceVO.getDn());
			/*Descomentar para Seguridad Begin*/
			//VALIDATOR.validateEmptyString(deviceVO.getUserPassword(),"UserPassword");
			/*Descomentar para Seguridad End*/
			String currentPassword = deviceVO.getUserPassword();
			final LoginDAO loginDAO = new LoginDAOImpl();
			/*Comentar para Seguridad Begin*/
			if (deviceVO.getUserPassword() == null){
				final String encryptPassword = loginDAO.getDecriptedPassword(deviceVO.getDn().substring(2));
				currentPassword = CryptoHelper.decrypt((encryptPassword == null)?"":encryptPassword);
			}
			/*Comentar para Seguridad End*/
			final String userPassLdap = loginDAO.getDecriptedPassword(deviceVO.getDn().substring(2));
			if (userPassLdap == null && deviceVO.getDn() != null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
				responseVO.setMessageCode(ATTConstants.DESC_PASSWORD_INCORRECT);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else if ( currentPassword.equals(CryptoHelper.decrypt(userPassLdap)) ){
				final ClientesOESoapBindingStub clientesOEProxy = ClientesOESoapServices.getClientesOEService();
				final String responseMasterPIN = clientesOEProxy.validateMasterPINMovil(jsonDecrypted).replace("\"", "");
				
				VALIDATOR.validateEmptyString(responseMasterPIN, "Respuesta boolean");
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseMasterPIN);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
				responseVO.setMessageCode(ATTConstants.DESC_PASSWORD_INCORRECT);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
}