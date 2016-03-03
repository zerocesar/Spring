package mx.com.att.business;

import org.apache.log4j.Logger;

import mx.com.att.utils.ATTConstants;
import mx.com.att.utils.LogInObjectsContents;
import mx.com.att.utils.SetObjectsAmdocs;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.GetBasicCustomerInfo;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.amdocs.RequestAmdocVO;

import com.google.gson.Gson;

public class LoginServiceAmdocs {
	private static final Logger LOGGER = Logger.getLogger(LoginServiceAmdocs.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	private static final LogInObjectsContents PRINTLOGOBJECT = new LogInObjectsContents();

	public String getCustomerFromDnMobileAMDOCS(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getCustomerFromDnMobileAMDOCS de la clase LoginServiceAmdocs");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);

		try{
			VALIDATOR.validateEmptyString(requestVO.getFmtLo(),"fmtLo");			

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			GetBasicCustomerInfo response = SetObjectsAmdocs.getBasicCustomerInfo();

			PRINTLOGOBJECT.logObject(response, "RESPONSE"); 

			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(response);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));

		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}	
		catch (Exception exception) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(exception.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}	

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}


	public String validateLoginMobileAMDOCS(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo validateLoginMobileAMDOCS de la clase LoginServiceAmdocs");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);
		Boolean response; 

		try{

			VALIDATOR.validateEmptyString(requestVO.getStatus(),"status");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			response = true;

			PRINTLOGOBJECT.logObject(response, "RESPONSE"); 

			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(response);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));

		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}	
		catch (Exception exception) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(exception.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}	

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
}
