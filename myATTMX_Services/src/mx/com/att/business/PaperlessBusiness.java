package mx.com.att.business;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import mx.com.att.support.PaperlessServiceSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;
import mx.com.nextel.paperless.PaperlessServicePortTypeProxy;
import mx.com.nextel.paperless.core.PaperlessExceptionDetail;
import mx.com.nextel.paperless.dto.PaperlessCustomerDto;

import com.google.gson.Gson;

public class PaperlessBusiness {

	private static final Logger LOGGER = Logger.getLogger(PaperlessBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	
	public String addPaperless(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo addPaperless de la clase PaperlessBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final PaymentRespVO paymentRespVO = new Gson().fromJson(jsonDecrypted, PaymentRespVO.class);
		
		try {
			VALIDATOR.validateEmptyLong(paymentRespVO.getCustomerId(), "CustomerId");
			VALIDATOR.validateEmptyString(paymentRespVO.getEmail(), "Email");
			VALIDATOR.validateEmptyString(paymentRespVO.getUser(), "User");
			
			final PaperlessServicePortTypeProxy paperlessProxy = PaperlessServiceSoapServices.getPaperlessServices();
			final int responsePaperless = paperlessProxy.addPaperless(paymentRespVO.getCustomerId(), paymentRespVO.getEmail(), paymentRespVO.getUser());
			
			if (responsePaperless > 0){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PAPERLESS);
				responseVO.setMessageCode(ATTConstants.DESC_CODIGO_ERROR_PAPERLESS);
				LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_PAPERLESS);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (PaperlessExceptionDetail paperlessExceptionDetail) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_PAPERLESS);
			responseVO.setMessageCode(paperlessExceptionDetail.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getPaperlessInfo(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo addPaperless de la clase PaperlessBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final PaymentRespVO paymentRespVO = new Gson().fromJson(jsonDecrypted, PaymentRespVO.class);
		
		try {
			VALIDATOR.validateEmptyLong(paymentRespVO.getCustomerId(), "CustomerId");
			
			final PaperlessServicePortTypeProxy paperlessProxy = PaperlessServiceSoapServices.getPaperlessServices();
			final PaperlessCustomerDto responsePaperless = paperlessProxy.getPaperlessInfo(paymentRespVO.getCustomerId());
			
			if (responsePaperless == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responsePaperless);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_PAPERLESS);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (PaperlessExceptionDetail paperlessExceptionDetail) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_PAPERLESS);
			responseVO.setMessageCode(paperlessExceptionDetail.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getIsPaperless(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getIsPaperless de la clase PaperlessBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final PaymentRespVO paymentRespVO = new Gson().fromJson(jsonDecrypted, PaymentRespVO.class);
		
		try {
			VALIDATOR.validateEmptyLong(paymentRespVO.getCustomerId(), "CustomerId");
			
			final PaperlessServicePortTypeProxy paperlessProxy = PaperlessServiceSoapServices.getPaperlessServices();
			final boolean responsePaperless = paperlessProxy.isPaperless(paymentRespVO.getCustomerId());
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(responsePaperless);
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_PAPERLESS);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (PaperlessExceptionDetail paperlessExceptionDetail) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_PAPERLESS);
			responseVO.setMessageCode(paperlessExceptionDetail.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String removePaperless(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getIsPaperless de la clase PaperlessBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final PaymentRespVO paymentRespVO = new Gson().fromJson(jsonDecrypted, PaymentRespVO.class);
		
		try {
			VALIDATOR.validateEmptyLong(paymentRespVO.getCustomerId(), "CustomerId");
			VALIDATOR.validateEmptyString(paymentRespVO.getUser(), "User");
			
			final PaperlessServicePortTypeProxy paperlessProxy = PaperlessServiceSoapServices.getPaperlessServices();
			final int responsePaperless = paperlessProxy.removePaperless(paymentRespVO.getCustomerId(), paymentRespVO.getUser());
			
			if (responsePaperless > 0){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PAPERLESS);
				responseVO.setMessageCode(ATTConstants.DESC_CODIGO_ERROR_PAPERLESS);
				LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_PAPERLESS);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (PaperlessExceptionDetail paperlessExceptionDetail) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_PAPERLESS);
			responseVO.setMessageCode(paperlessExceptionDetail.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

}