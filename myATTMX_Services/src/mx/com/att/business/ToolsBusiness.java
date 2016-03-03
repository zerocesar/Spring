package mx.com.att.business;

import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.ParamCatalogoVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class ToolsBusiness {
	private static final Logger LOGGER = Logger.getLogger(ToolsBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT(); 
	
	public String getParametersWP(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getParametersWP de la clase ToolsBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final ParamCatalogoVO paramCatalogoVO = new Gson().fromJson(jsonDecrypted, ParamCatalogoVO.class);
		
		try {
			VALIDATOR.validateEmptyString(paramCatalogoVO.getParam_id(), "Param Id");
			
			paramCatalogoVO.setParam_value(ATTConstants.getPARAMETERS_WP().get(paramCatalogoVO.getParam_id()));
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(paramCatalogoVO.getParam_value());
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_PARAM_ENTRADA);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getParametersFVM(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getParametersFVM de la clase ToolsBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final ParamCatalogoVO paramCatalogoVO = new Gson().fromJson(jsonDecrypted, ParamCatalogoVO.class);
		
		try {
			VALIDATOR.validateEmptyString(paramCatalogoVO.getParam_id(), "Param Id");
			
			paramCatalogoVO.setParam_value(ATTConstants.getPARAMETERS_FVM().get(paramCatalogoVO.getParam_id()));
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(paramCatalogoVO.getParam_value());
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_PARAM_ENTRADA);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
}