package mx.com.att.business;


import java.util.ArrayList;
import java.util.List;
import mx.com.att.utils.ATTConstants;
import mx.com.att.utils.LogInObjectsContents;
import mx.com.att.utils.MasterObjectsContents;
import mx.com.att.utils.SetObjectsAmdocs;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.GetBasicCustomerInfo;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.amdocs.GetNumberOfHandsets;
import mx.com.att.vo.amdocs.GetPasscode;
import mx.com.att.vo.amdocs.PreguntaVo;
import mx.com.att.vo.amdocs.RequestAmdocVO;
import mx.com.att.vo.amdocs.RequestCrmVO;
import mx.com.att.vo.amdocs.UpdatePasscode;
import mx.com.att.vo.amdocs.VerifyInvoiceZipCode;
import mx.com.att.vo.amdocs.VerifyPersonalZipCode;
import mx.com.att.vo.amdocs.VerifyRFC;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class MasterPINAmdocsBusiness {

	private static final Logger LOGGER = Logger.getLogger(MasterPINAmdocsBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	private static final LogInObjectsContents PRINTLOGOBJECT = new LogInObjectsContents();
	
	public String getMasterPinQuestionsAMDOCS(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);
		List<PreguntaVo> response= new ArrayList<PreguntaVo>();
		MasterObjectsContents respuesta= new MasterObjectsContents();

		try{

			VALIDATOR.validateEmptyString(requestVO.getStatus(),"status");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");
			List<PreguntaVo> listaNumeros= new ArrayList<PreguntaVo>();    
		    List<Integer> listaFinal= new ArrayList<Integer>();
			response = respuesta.totaldePreguntas(3, listaNumeros, listaFinal);
			
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
	
	public String validateMasterPinQuestionsAMDOCS(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		ResponseVO responseVO = new ResponseVO();
		RequestCrmVO requestVO = new Gson().fromJson(jsonRequest,RequestCrmVO.class);
		String tipo=""; 
		ResponseVO respuestaMetodos=new ResponseVO();
		
		try{

			VALIDATOR.validateEmptyString(requestVO.getFmtLo(),"fmtLo");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			tipo=requestVO.getFmtLo();
			
			if(tipo.equals("0")){
				respuestaMetodos=getNumberOfHandsets(jsonRequest);				
			}
			if(tipo.equals("1")){
				respuestaMetodos=verifyRFC(jsonRequest);
			}
			if(tipo.equals("2")){
				respuestaMetodos=verifyPersonalZipCode(jsonRequest);
			}
			if(tipo.equals("3")){
				respuestaMetodos=verifyInvoiceZipCode(jsonRequest);
			}
			if(tipo.equals("4")){
				respuestaMetodos=getBasicCustomerInfo(jsonRequest);
			}
			if(tipo.equals("5")){
				respuestaMetodos=getBasicCustomerInfo(jsonRequest);
			}
			
			responseVO=respuestaMetodos;
			
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
	
	public String changeMasterPINMobileAMDOCS(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		ResponseVO responseVO = new ResponseVO();
		RequestCrmVO requestVO = new Gson().fromJson(jsonRequest,RequestCrmVO.class);
		UpdatePasscode response= new UpdatePasscode();
				
		try{

			VALIDATOR.validateEmptyString(requestVO.getPasscode(),"passcode");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");
			
			response=SetObjectsAmdocs.changeMasterPINMobileAMDOCS();
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
	
	/********************************************************/
	public ResponseVO getNumberOfHandsets(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestCrmVO requestVO = new Gson().fromJson(jsonRequest, RequestCrmVO.class);
		GetNumberOfHandsets response= new GetNumberOfHandsets(); 

		try{

			VALIDATOR.validateEmptyString(requestVO.getNumberOfHandsets(),"id");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");
			
			response=SetObjectsAmdocs.getNumberOfHandsetsInfo();
			
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

		return responseVO;
	}
	
	public ResponseVO verifyRFC(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestCrmVO requestVO = new Gson().fromJson(jsonRequest, RequestCrmVO.class);
		VerifyRFC response= new VerifyRFC(); 

		try{

			VALIDATOR.validateEmptyString(requestVO.getRFC(),"id");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			response=SetObjectsAmdocs.verifyRFC();
			
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

		return responseVO;
	}
	
	public ResponseVO verifyPersonalZipCode(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestCrmVO requestVO = new Gson().fromJson(jsonRequest, RequestCrmVO.class);
		VerifyPersonalZipCode response= new VerifyPersonalZipCode(); 

		try{

			VALIDATOR.validateEmptyString(requestVO.getPersonalZipCode(),"id");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			response=SetObjectsAmdocs.verifyPersonalZipCode();
			
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

		return responseVO;
	}
	
	
	public ResponseVO verifyInvoiceZipCode(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestCrmVO requestVO = new Gson().fromJson(jsonRequest, RequestCrmVO.class);
		VerifyInvoiceZipCode response= new VerifyInvoiceZipCode(); 

		try{

			VALIDATOR.validateEmptyString(requestVO.getInvoiceZipCodev(),"invoiceZipCodev");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");
			
			response=SetObjectsAmdocs.verifyInvoiceZipCode();
			
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

		return responseVO;
	}
	
	public ResponseVO getBasicCustomerInfo(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestCrmVO requestVO = new Gson().fromJson(jsonRequest, RequestCrmVO.class);
		GetBasicCustomerInfo response= new GetBasicCustomerInfo(); 

		try{

			VALIDATOR.validateEmptyString(requestVO.getMobileNo(),"id");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			response=SetObjectsAmdocs.getBasicCustomerInfo();
			
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

		return responseVO;
	}
	
	
	
	public String validateMasterPinWithLockMobileAMDOCS(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);
		GetPasscode response= new GetPasscode(); 

		try{

			VALIDATOR.validateEmptyString(requestVO.getStatus(),"status");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");
			
			response.setPassword("att*123");

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
	
	public String validateMasterPinWithoutLockMobileAMDOCS(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);
		GetPasscode response= new GetPasscode(); 

		try{

			VALIDATOR.validateEmptyString(requestVO.getStatus(),"status");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");
			
			response.setPassword("att*123");

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
	
	public String recoverMasterPINMobileAMDOCS(final String cadenaJson){

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);
		GetPasscode response= new GetPasscode(); 

		try{

			VALIDATOR.validateEmptyString(requestVO.getStatus(),"status");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");
			
			response.setPassword("att*132");

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