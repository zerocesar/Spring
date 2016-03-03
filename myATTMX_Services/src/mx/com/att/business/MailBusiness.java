package mx.com.att.business;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import mx.com.att.support.MailSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.ResponseVO;
import mx.com.nextel.ecommerce.ws.exception.EcommerceWSException;
import mx.com.nextel.www.mail.ws.mail.MailServicePortBindingStub;

import com.google.gson.Gson;

public class MailBusiness {

	private static final Logger LOGGER = Logger.getLogger(MailBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	
	public String sendEmail(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo sendEmail de la clase MailBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			final MailServicePortBindingStub mailProxy = MailSoapServices.getMailService();
			final String responseMail = mailProxy.sendEmailMovil(jsonDecrypted);
			final ResponseVO responseMailVO = new Gson().fromJson(responseMail, ResponseVO.class);
			
			if (responseMailVO == null || responseMailVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_MAIL);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseMailVO.getCode(), ATTConstants.CODIGO_EXITO_MAIL)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(responseMailVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseMailVO.getCode());
				responseVO.setMessageCode(responseMailVO.getMessageCode());
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
}