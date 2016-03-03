package mx.com.att.business;

import mx.com.att.utils.ATTConstants;
import mx.com.att.utils.LogInObjectsContents;
import mx.com.att.utils.SetObjectsAmdocs;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.amdocs.GetAllowance;
import mx.com.att.vo.amdocs.GetBalance;
import mx.com.att.vo.amdocs.GetNumberOfHandsets;
import mx.com.att.vo.amdocs.RequestAmdocVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class PocketsAccountBusiness {

	private static final Logger LOGGER = Logger.getLogger(PocketsAccountBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	private static final LogInObjectsContents PRINTLOGOBJECT = new LogInObjectsContents();
	
	public String getPocketsLimitMobileAMDOCS(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);

		try{
			VALIDATOR.validateEmptyString(requestVO.getCustomerID(),"customerId");			

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			GetAllowance response = SetObjectsAmdocs.getAllowenceInfo();

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
	
	public String getAccountBalanceMobileAMDOCS(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);

		try{
			VALIDATOR.validateEmptyString(requestVO.getAccountid(),"accountid");			

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			GetBalance response = SetObjectsAmdocs.getBalanceInfo();

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
	
	public String getAccountContractsBrothersDNMobileAMDOCS(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);

		try{
			VALIDATOR.validateEmptyString(requestVO.getId(),"id");			

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			GetNumberOfHandsets response = SetObjectsAmdocs.getNumberOfHandsetsInfo();

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
