package mx.com.att.business;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import mx.com.att.dao.FrecuentNumbersDAO;
import mx.com.att.dao.FrecuentNumbersDAOImp;
import mx.com.att.support.NumerosFrecuentesSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.DatosNumerosFrecuentesVO;
import mx.com.att.vo.orange.FrecuentNumbersVO;
import mx.com.nextel.www.ecommerce.ws.numerosFrecuentes.FormasPagoVO;
import mx.com.nextel.www.ecommerce.ws.numerosFrecuentes.NumerosFrecuentesPortBindingStub;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class FrecuentNumbersBusiness {
	
	private static final Logger LOGGER = Logger.getLogger(FrecuentNumbersBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT(); 
	
	public String getMaximumFrecuentsNumbersBsn(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getMaximumFrecuentsNumbersBsn de la clase FrecuentNumbersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		int maxFrecuentNum = 0;
		
		final DatosNumerosFrecuentesVO datosNumerosFrecuentesVO = new Gson().fromJson(jsonDecrypted, DatosNumerosFrecuentesVO.class);
		
		try {
			VALIDATOR.validateDN10(datosNumerosFrecuentesVO.getDn());
			VALIDATOR.validateEmptyString(datosNumerosFrecuentesVO.getTmcode(), "Identificador del Plan (TMCODE)");
			
			//Se busca la informacion del usuario en BSCS
			LOGGER.info("Se busca la informacion de numeros frecuentes para el DN: " + datosNumerosFrecuentesVO.getDn());
			final FrecuentNumbersDAO frecuentNumbersDAO = new FrecuentNumbersDAOImp();
			maxFrecuentNum = frecuentNumbersDAO.getMaximoNumerosFrecuentes(datosNumerosFrecuentesVO.getTmcode(), datosNumerosFrecuentesVO.getDn());
			

			if (maxFrecuentNum != ATTConstants.VAL_CERO){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(maxFrecuentNum);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NO_MAX_NUM_FREC);
				responseVO.setMessageCode(ATTConstants.DESC_CODIGO_ERROR_NO_MAX_NUM_FREC);
				responseVO.setObjectResponse(maxFrecuentNum);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getFrecuentNumbers(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getFrecuentNumbers de la clase FrecuentNumbersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final NumerosFrecuentesPortBindingStub numerosFrecProxy = NumerosFrecuentesSoapServices.getNumerosFrecuentesService();
			final String responseFrecuentNum = numerosFrecProxy.getFrecuentNumbersMovil(jsonDecrypted);
			final ResponseVO responseFrecuentNumVO = new Gson().fromJson(responseFrecuentNum, ResponseVO.class);
			
			if (responseFrecuentNumVO == null || responseFrecuentNumVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_FREC);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseFrecuentNumVO.getCode(), ATTConstants.CODIGO_EXITO)){
				JsonElement objectResponseJson = new JsonParser().parse( responseFrecuentNum ).getAsJsonObject().get("objectResponse");
				JsonArray respuestaArray = objectResponseJson.getAsJsonArray();
				
				List<FrecuentNumbersVO> listaFrecNumVO = new ArrayList<FrecuentNumbersVO>();
				for(JsonElement object: respuestaArray){
					FrecuentNumbersVO frecuentNumbersVO = new Gson().fromJson(object, FrecuentNumbersVO.class);
					listaFrecNumVO.add(frecuentNumbersVO);
				}
					
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(listaFrecNumVO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_FREC);
				responseVO.setMessageCode(responseFrecuentNumVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} 
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getMethodOfPayment(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getMethodOfPayment de la clase FrecuentNumbersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final NumerosFrecuentesPortBindingStub numerosFrecProxy = NumerosFrecuentesSoapServices.getNumerosFrecuentesService();
			final String responseFrecuentNum = numerosFrecProxy.getMethodOfPaymentMovil(jsonDecrypted);
			final ResponseVO responseFrecuentNumVO = new Gson().fromJson(responseFrecuentNum, ResponseVO.class);
			
			if (responseFrecuentNumVO == null || responseFrecuentNumVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_FREC);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseFrecuentNumVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(new Gson().fromJson(new Gson().toJson(responseFrecuentNumVO.getObjectResponse()), FormasPagoVO.class));
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_FREC);
				responseVO.setMessageCode(responseFrecuentNumVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} 
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getPriceChangeFN(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPriceChangeFN de la clase FrecuentNumbersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final NumerosFrecuentesPortBindingStub numerosFrecProxy = NumerosFrecuentesSoapServices.getNumerosFrecuentesService();
			final String responseFrecuentNum = numerosFrecProxy.getPriceChangeFNMovil(jsonDecrypted);
			final ResponseVO responseFrecuentNumVO = new Gson().fromJson(responseFrecuentNum, ResponseVO.class);
			
			if (responseFrecuentNumVO == null || responseFrecuentNumVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_FREC);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseFrecuentNumVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(new Gson().toJson(responseFrecuentNumVO.getObjectResponse()));
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_FREC);
				responseVO.setMessageCode(responseFrecuentNumVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} 
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String validateContract(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateContract de la clase FrecuentNumbersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final NumerosFrecuentesPortBindingStub numerosFrecProxy = NumerosFrecuentesSoapServices.getNumerosFrecuentesService();
			final String responseFrecuentNum = numerosFrecProxy.validateContractMovil(jsonDecrypted);
			final ResponseVO responseFrecuentNumVO = new Gson().fromJson(responseFrecuentNum, ResponseVO.class);
			
			if (responseFrecuentNumVO == null || responseFrecuentNumVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_FREC);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseFrecuentNumVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(new Gson().toJson(responseFrecuentNumVO.getObjectResponse()));
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_FREC);
				responseVO.setMessageCode(responseFrecuentNumVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} 
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String validateDn(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateContract de la clase FrecuentNumbersBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final NumerosFrecuentesPortBindingStub numerosFrecProxy = NumerosFrecuentesSoapServices.getNumerosFrecuentesService();
			final String responseFrecuentNum = numerosFrecProxy.validateDnMovil(jsonDecrypted);
			final ResponseVO responseFrecuentNumVO = new Gson().fromJson(responseFrecuentNum, ResponseVO.class);
			
			if (responseFrecuentNumVO == null || responseFrecuentNumVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_FREC);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseFrecuentNumVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(responseFrecuentNumVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_FREC);
				responseVO.setMessageCode(responseFrecuentNumVO.getMessageCode());
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