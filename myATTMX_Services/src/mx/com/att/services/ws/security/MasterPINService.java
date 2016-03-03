package mx.com.att.services.ws.security;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;
import mx.com.nextel.www.ecommerce.ws.cliente.DeviceVO;

import ws.ecommerce.nextel.com.mx.masterpin.ListaVO;
import ws.ecommerce.nextel.com.mx.masterpin.MasterPinVO;
import ws.ecommerce.nextel.com.mx.masterpin.MasterVO;
import ws.ecommerce.nextel.com.mx.masterpin.QuestionVO;

@WebService(name = "MasterPINService", 
targetNamespace = "http://www.att.com.mx/att/services/ws/security/masterPINService")
public interface MasterPINService {

	public final static String RETURN = "return";
	
	@WebMethod(operationName = "getQuestionsMobile")
	@WebResult(name = RETURN)// ListaVO
	String getQuestionsMobile(@WebParam(name = "questionVO") String question);
	
	@WebMethod(operationName = "getQuestions")
	@WebResult(name = RETURN) // ListaVO
	ResponseVO getQuestions(@WebParam(name = "questionVO") QuestionVO question);

	@WebMethod(operationName = "getAnswersMobile")
	@WebResult(name = RETURN)// ListaVO
	String getAnswersMobile(@WebParam(name = "preguntas") String preguntas);
	
	@WebMethod(operationName = "getAnswers")
	@WebResult(name = RETURN) // ListaVO
	ResponseVO getAnswers(@WebParam(name = "preguntas") ListaVO preguntas);

	@WebMethod(operationName = "recoverMasterPINMobile")
	@WebResult(name = RETURN)
	String recoverMasterPINMobile(@WebParam(name = "masterPINVO") String masterPIN);
	
	@WebMethod(operationName = "recoverMasterPIN")
	@WebResult(name = RETURN)
	ResponseVO recoverMasterPIN(@WebParam(name = "masterPINVO") MasterPinVO masterPIN);

	@WebMethod(operationName = "getBlockedRecoveryMobile")
	@WebResult(name = RETURN)// MasterPINLogVO
	String getBlockedRecoveryMobile (@WebParam(name = "custCode") String custCode);
	
	@WebMethod(operationName = "getBlockedRecovery")
	@WebResult(name = RETURN)// MasterPINLogVO
	ResponseVO getBlockedRecovery(@WebParam(name = "custCode") PaymentRespVO custCode);
	
	@WebMethod(operationName = "changeMasterPINMobile")
	@WebResult(name = RETURN)// MasterVO
	String changeMasterPINMobile (@WebParam(name = "master") String master);
	
	@WebMethod(operationName = "changeMasterPIN")
	@WebResult(name = RETURN) // MasterVO
	ResponseVO changeMasterPIN (@WebParam(name = "master") MasterVO master);
	
	@WebMethod(operationName = "validateMasterPinWithLockMobile")
	@WebResult(name = RETURN)//boolean
	String validateMasterPinWithLockMobile(@WebParam(name = "MasterPin")  String masterPin);
	
	@WebMethod(operationName = "validateMasterPinWithLock")
	@WebResult(name = RETURN)//boolean
	ResponseVO validateMasterPinWithLock(@WebParam(name = "MasterPin")  MasterPinVO masterPin);

	@WebMethod(operationName = "validateMasterPinWithoutLockMobile")
	@WebResult(name = RETURN)//boolean
	String validateMasterPinWithoutLockMobile(@WebParam(name="masterPIN") String device);
	
	@WebMethod(operationName = "validateMasterPinWithoutLock")
	@WebResult(name = RETURN)//boolean
	ResponseVO validateMasterPinWithoutLock(@WebParam(name="masterPIN") DeviceVO device);
	
	@WebMethod(operationName = "getBlockedValidationMobile")
	@WebResult(name = RETURN)// MasterPINLogVO
	String getBlockedValidationMobile(@WebParam(name = "custCode") String custCode);
	
	@WebMethod(operationName = "getBlockedValidation")
	@WebResult(name = RETURN)// MasterPINLogVO
	ResponseVO getBlockedValidation(@WebParam(name = "custCode") PaymentRespVO custCode);
}