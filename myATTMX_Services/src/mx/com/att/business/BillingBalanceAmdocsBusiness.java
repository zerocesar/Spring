package mx.com.att.business;

import mx.com.att.utils.ATTConstants;
import mx.com.att.utils.LogInObjectsContents;
import mx.com.att.utils.SetObjectsAmdocs;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.amdocs.GetLastInvoiceInfo;
import mx.com.att.vo.amdocs.ProductsAvailableActions;
import mx.com.att.vo.amdocs.RequestAmdocVO;
import mx.com.att.vo.amdocs.UpdateProdConfigRes;
import mx.com.att.vo.amdocs.ValidateNewOfferingConfigurationResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class BillingBalanceAmdocsBusiness {
	private static final Logger LOGGER = Logger.getLogger(BillingBalanceAmdocsBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	private static final LogInObjectsContents PRINTLOGOBJECT = new LogInObjectsContents();
	
	public String getAvailableActions(final String cadenaJson){

		LOGGER.info("Comienza la ejecucion del metodo getAvailableActions de la clase BillingBalanceAmdocsBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);

		try{
			VALIDATOR.validateEmptyString(requestVO.getProductIds(),"productIds");
			VALIDATOR.validateEmptyString(requestVO.getId(),"id");	

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			final ProductsAvailableActions response = SetObjectsAmdocs.getAvailableActions();

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
		
	public String getAvailableProducts(final String cadenaJson){

		LOGGER.info("Comienza la ejecucion del metodo getAvailableProducts de la clase BillingBalanceAmdocsBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);

		try{
			VALIDATOR.validateEmptyString(requestVO.getProductIds(),"productId");
			VALIDATOR.validateEmptyString(requestVO.getId(),"id");
//			VALIDATOR.validateEmptyString(requestVO.getRp(),"rp");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			final ValidateNewOfferingConfigurationResponse response = SetObjectsAmdocs.getAvailableProducts();

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
	
	public String setConfiguration(final String cadenaJson){

		LOGGER.info("Comienza la ejecucion del metodo setConfiguration de la clase BillingBalanceAmdocsBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);

		try{
			VALIDATOR.validateEmptyString(requestVO.getProductIds(),"productIds");
			VALIDATOR.validateEmptyString(requestVO.getId(),"id");	

			PRINTLOGOBJECT.logObject(requestVO.getUpdateProductConfig(), "REQUEST");

			final UpdateProdConfigRes response = SetObjectsAmdocs.setConfiguration();

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
		
	public String getLastInvoice(final String cadenaJson){

		LOGGER.info("Comienza la ejecucion del metodo getLastInvoice de la clase BillingBalanceAmdocsBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);

		try{
			VALIDATOR.validateEmptyString(requestVO.getBaid(),"baid");
			VALIDATOR.validateEmptyString(requestVO.getFromDate(),"fromDate");	
			VALIDATOR.validateEmptyString(requestVO.getToDate(),"toDate");	

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			final GetLastInvoiceInfo response = SetObjectsAmdocs.getLastInvoice();

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
	
	public String getLastTotalBill(final String cadenaJson){

		LOGGER.info("Comienza la ejecucion del metodo getLastTotalBill de la clase BillingBalanceAmdocsBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);

		final ResponseVO responseVO = new ResponseVO();
		RequestAmdocVO requestVO = new Gson().fromJson(jsonRequest, RequestAmdocVO.class);

		try{
			VALIDATOR.validateEmptyString(requestVO.getBaid(),"baid");
			VALIDATOR.validateEmptyString(requestVO.getFromDate(),"fromDate");
			VALIDATOR.validateEmptyString(requestVO.getToDate(),"toDate");

			PRINTLOGOBJECT.logObject(requestVO, "REQUEST");

			final double lastTotalBill = 1985.58;			

			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(lastTotalBill);
			
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
