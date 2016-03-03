package mx.com.att.business;

import mx.com.att.dao.PaymentDAO;
import mx.com.att.dao.PaymentDAOImp;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.BankReferenceVO;
import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class PaymentBusiness {
	
	private static final Logger LOGGER = Logger.getLogger(PaymentBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT(); 
	
	public String getPaymentReference(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getPaymentReference de la clase PaymentBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final PaymentRespVO paymentRespVO = new Gson().fromJson(jsonDecrypted, PaymentRespVO.class);
		try{
			VALIDATOR.validateEmptyLong(paymentRespVO.getCustomerId(),"Customer Id del Responsable de Pago");
			
			final BankReferenceVO requestBankReferenceVO = new BankReferenceVO(); 
			requestBankReferenceVO.setTimCustomerId(paymentRespVO.getCustomerId());
			//Obtiene la informacion de las referencias para pagar en las distintas instituciones bancarias.
			final PaymentDAO paymentDAO = new PaymentDAOImp();
			final BankReferenceVO[] bankReferenceVO = paymentDAO.getBankReference(requestBankReferenceVO); 
			
			if (bankReferenceVO == null || bankReferenceVO.length <= 0){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PAYMENT);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(bankReferenceVO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}	
}