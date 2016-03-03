package mx.com.att.services.ws.security;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.MasterPINBusiness;
import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;
import mx.com.nextel.www.ecommerce.ws.cliente.DeviceVO;
import ws.ecommerce.nextel.com.mx.masterpin.ListaVO;
import ws.ecommerce.nextel.com.mx.masterpin.MasterPinVO;
import ws.ecommerce.nextel.com.mx.masterpin.MasterVO;
import ws.ecommerce.nextel.com.mx.masterpin.QuestionVO;

@WebService(portName="MasterPINServicePort", 
serviceName="MasterPINService", 
targetNamespace="http://www.att.com.mx/att/services/ws/security/masterPINService", 
endpointInterface="mx.com.att.services.ws.security.MasterPINService")
public class MasterPINServiceImp implements MasterPINService {

	private static final Logger LOGGER = Logger.getLogger(MasterPINServiceImp.class);
	
	@Override
	public String getQuestionsMobile(String question) {
		LOGGER.info("Comienza la ejecucion del metodo getQuestionsMobil de la clase MasterPINServiceImp");
		
		final MasterPINBusiness masterPINBusiness = new MasterPINBusiness();
		
		return masterPINBusiness.getQuestions(question);
	}

	@Override
	public ResponseVO getQuestions(QuestionVO question) {
		LOGGER.info("Comienza la ejecucion del metodo getQuestions de la clase MasterPINServiceImp");
		
		final String request = new Gson().toJson(question);
		final String response = getQuestionsMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getAnswersMobile(String respuestas) {
		LOGGER.info("Comienza la ejecucion del metodo getAnswersMobil de la clase MasterPINServiceImp");
		
		final MasterPINBusiness masterPINBusiness = new MasterPINBusiness();
		
		return masterPINBusiness.getAnswers(respuestas);
	}

	@Override
	public ResponseVO getAnswers(ListaVO respuestas) {
		LOGGER.info("Comienza la ejecucion del metodo getAnswers de la clase MasterPINServiceImp");
		
		final String request = new Gson().toJson(respuestas);
		final String response = getAnswersMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String recoverMasterPINMobile(String masterPIN) {
		LOGGER.info("Comienza la ejecucion del metodo recoverMasterPINMobil de la clase MasterPINServiceImp");
		
		final MasterPINBusiness masterPINBusiness = new MasterPINBusiness();
		
		return masterPINBusiness.recoverMasterPIN(masterPIN);
	}

	@Override
	public ResponseVO recoverMasterPIN(MasterPinVO masterPIN) {
		LOGGER.info("Comienza la ejecucion del metodo recoverMasterPIN de la clase MasterPINServiceImp");
		
		final String request = new Gson().toJson(masterPIN);
		final String response = recoverMasterPINMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getBlockedRecoveryMobile(String custCode) {
		LOGGER.info("Comienza la ejecucion del metodo getBlockedRecoveryMobil de la clase MasterPINServiceImp");
		
		final MasterPINBusiness masterPINBusiness = new MasterPINBusiness();
		
		return masterPINBusiness.getBlockedRecovery(custCode);
	}

	@Override
	public ResponseVO getBlockedRecovery(PaymentRespVO custCode) {
		LOGGER.info("Comienza la ejecucion del metodo getBlockedRecovery de la clase MasterPINServiceImp");
		
		final String request = new Gson().toJson(custCode);
		final String response = getBlockedRecoveryMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String changeMasterPINMobile(String master) {
		LOGGER.info("Comienza la ejecucion del metodo changeMasterPINMobil de la clase MasterPINServiceImp");
		
		final MasterPINBusiness masterPINBusiness = new MasterPINBusiness();
		
		return masterPINBusiness.changeMasterPIN(master);
	}

	@Override
	public ResponseVO changeMasterPIN(MasterVO master) {
		LOGGER.info("Comienza la ejecucion del metodo changeMasterPIN de la clase MasterPINServiceImp");
		
		final String request = new Gson().toJson(master);
		final String response = changeMasterPINMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String validateMasterPinWithLockMobile(String masterPin) {
		LOGGER.info("Comienza la ejecucion del metodo validateMasterPinWithLockMobil de la clase MasterPINServiceImp");
		
		final MasterPINBusiness masterPINBusiness = new MasterPINBusiness();
		
		return masterPINBusiness.validateMasterPinWithLock(masterPin);
	}

	@Override
	public ResponseVO validateMasterPinWithLock(MasterPinVO masterPin) {
		LOGGER.info("Comienza la ejecucion del metodo validateMasterPinWithLock de la clase MasterPINServiceImp");
		
		final String request = new Gson().toJson(masterPin);
		final String response = validateMasterPinWithLockMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String validateMasterPinWithoutLockMobile(String device) {
		LOGGER.info("Comienza la ejecucion del metodo validateMasterPinWithoutLockMobil de la clase MasterPINServiceImp");
		
		final MasterPINBusiness masterPINBusiness = new MasterPINBusiness();
		
		return masterPINBusiness.validateMasterPinWithoutLock(device);
	}

	@Override
	public ResponseVO validateMasterPinWithoutLock(DeviceVO device) {
		LOGGER.info("Comienza la ejecucion del metodo validateMasterPinWithoutLock de la clase MasterPINServiceImp");
		
		final String request = new Gson().toJson(device);
		final String response = validateMasterPinWithoutLockMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getBlockedValidationMobile(String custCode) {
		LOGGER.info("Comienza la ejecucion del metodo getBlockedValidationMobil de la clase MasterPINServiceImp");
		
		final MasterPINBusiness masterPINBusiness = new MasterPINBusiness();
		
		return masterPINBusiness.getBlockedValidation(custCode);
	}

	@Override
	public ResponseVO getBlockedValidation(PaymentRespVO custCode) {
		LOGGER.info("Comienza la ejecucion del metodo getBlockedValidation de la clase MasterPINServiceImp");
		
		final String request = new Gson().toJson(custCode);
		final String response = getBlockedValidationMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}