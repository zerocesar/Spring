package mx.com.att.business;

import java.rmi.RemoteException;

import mx.com.att.support.RechargeSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;
import mx.com.nextel.www.ecommerce.ws.paquetes.ContractVO;
import mx.com.nextel.www.ecommerce.ws.recharge.EcommerceServiceBindingStub;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class TopUpBusiness {

	private static final Logger LOGGER = Logger.getLogger(TopUpBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	
	public String getWebPortalAmounts(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getWebPortalAmounts de la clase TopUpBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final EcommerceServiceBindingStub rechargeProxy = RechargeSoapServices.getRechargeService();
			final String responseRecharge = rechargeProxy.getMontosWebPortalMovil(jsonDecrypted);
			
			final ResponseVO responseRechargeVO = new Gson().fromJson(responseRecharge, ResponseVO.class);
			
			if (responseRechargeVO == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseRechargeVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseRechargeVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_RECHARGE);
				responseVO.setMessageCode(responseRechargeVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getRechargeAmounts(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getWebPortalAmounts de la clase TopUpBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final CustomerVO CustomerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class); 
		
		try {
			VALIDATOR.validateEmptyString(CustomerVO.getSystemId(), "SystemId");
			
			final EcommerceServiceBindingStub rechargeProxy = RechargeSoapServices.getRechargeService();
			final String responseRecharge = rechargeProxy.getRechargeAmountsMovil(CustomerVO.getSystemId());
			
			final ResponseVO responseRechargeVO = new Gson().fromJson(responseRecharge, ResponseVO.class);
			
			if (responseRechargeVO == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseRechargeVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseRechargeVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_RECHARGE);
				responseVO.setMessageCode(responseRechargeVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_RECHARGE);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getServiceCredit(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getServiceCredit de la clase TopUpBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final EcommerceServiceBindingStub rechargeProxy = RechargeSoapServices.getRechargeService();
			final String responseRecharge = rechargeProxy.isServiceCreditMovil(jsonDecrypted);
			
			final ResponseVO responseRechargeVO = new Gson().fromJson(responseRecharge, ResponseVO.class);
			
			if (responseRechargeVO == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseRechargeVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseRechargeVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_RECHARGE);
				responseVO.setMessageCode(responseRechargeVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String validateDN(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateDN de la clase TopUpBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final EcommerceServiceBindingStub rechargeProxy = RechargeSoapServices.getRechargeService();
			final String responseRecharge = rechargeProxy.validateDNMovil(jsonDecrypted);
			
			final ResponseVO responseRechargeVO = new Gson().fromJson(responseRecharge, ResponseVO.class);
			
			if (responseRechargeVO == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseRechargeVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(responseRechargeVO.getMessageCode());
				responseVO.setObjectResponse(new Gson().fromJson(new Gson().toJson(responseRechargeVO.getObjectResponse()), ContractVO.class));
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_RECHARGE);
				responseVO.setMessageCode(responseRechargeVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String validateDNTransfer(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateDNTransfer de la clase TopUpBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final EcommerceServiceBindingStub rechargeProxy = RechargeSoapServices.getRechargeService();
			final String responseRecharge = rechargeProxy.validateDNTransferMovil(jsonDecrypted);
			
			final ResponseVO responseRechargeVO = new Gson().fromJson(responseRecharge, ResponseVO.class);
			
			if (responseRechargeVO == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseRechargeVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(responseRechargeVO.getMessageCode());
				responseVO.setObjectResponse(responseRechargeVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_RECHARGE);
				responseVO.setMessageCode(responseRechargeVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String validateBillByDN(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateBillByDN de la clase TopUpBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final EcommerceServiceBindingStub rechargeProxy = RechargeSoapServices.getRechargeService();
			final String responseRecharge = rechargeProxy.validateFacturaByDNMovil(jsonDecrypted);
			
			final ResponseVO responseRechargeVO = new Gson().fromJson(responseRecharge, ResponseVO.class);
			
			if (responseRechargeVO == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseRechargeVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(responseRechargeVO.getMessageCode());
				responseVO.setObjectResponse(responseRechargeVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_RECHARGE);
				responseVO.setMessageCode(responseRechargeVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
}