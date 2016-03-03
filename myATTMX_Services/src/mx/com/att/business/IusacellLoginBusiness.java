package mx.com.att.business;


import java.util.List;

import mx.com.att.business.call.CallServicesMiIusacell;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.red.ConfiguracionXUsuarioMovilVO;
import mx.com.att.vo.red.ConsultaOperadorExtendidoVO;
import mx.com.att.vo.red.DatosFocalizacionUsuario;
import mx.com.att.vo.red.OperacionVO;
import mx.com.att.vo.red.PermisosClienteVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;


public class IusacellLoginBusiness {

	private static final Logger LOGGER = Logger.getLogger(IusacellLoginBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	
	/*******************************/
	
	public String consultaOperadorExtendido(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();		
		LOGGER.info("Comienza la ejecucion del metodo consultaOperadorExtendido de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell iusacellService = new CallServicesMiIusacell();
		
		ConsultaOperadorExtendidoVO response;
		
		try {	

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			
			try {
				response=iusacellService.consultaOperadorExtendido("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/",operacionVO.getUser(), operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(response);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	
	public String focalizacion(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();		
		LOGGER.info("Comienza la ejecucion del metodo focalizacion de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell iusacellService = new CallServicesMiIusacell();
		
		DatosFocalizacionUsuario response;
		
		try {	

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			
			try {
				response=iusacellService.focalizacion("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/",operacionVO.getUser(), operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(response);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getConfiguracionXUsuarioMovil(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();		
		LOGGER.info("Comienza la ejecucion del metodo getConfiguracionXUsuarioMovil de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell iusacellService = new CallServicesMiIusacell();
		
		ConfiguracionXUsuarioMovilVO response;
		
		try {	

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			
			try {
				response=iusacellService.getConfiguracionXUsuarioMovil("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/",operacionVO.getUser(), operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(response);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getPermisosXcliente(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();		
		LOGGER.info("Comienza la ejecucion del metodo getPermisosXcliente de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell iusacellService = new CallServicesMiIusacell();
		
		List<PermisosClienteVO> response;
		
		try {	

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			
			try {
				response=iusacellService.getPermisosXcliente("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/",operacionVO.getUser(), operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(response);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	
}