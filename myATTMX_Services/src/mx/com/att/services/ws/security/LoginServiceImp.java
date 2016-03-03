package mx.com.att.services.ws.security;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.LoginBusiness;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.LoginRecordVO;
import mx.com.att.vo.ResponseVO;

@WebService(portName="LoginServicePort", 
serviceName="LoginService", 
targetNamespace="http://www.att.com.mx/att/services/ws/security/loginService", 
endpointInterface="mx.com.att.services.ws.security.LoginService")
public class LoginServiceImp implements LoginService {

	private static final Logger LOGGER = Logger.getLogger(LoginServiceImp.class);

	@Override
	public String changeUserLdapMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo changeUserLdapMobile de la clase LoginServiceImp");
		
		final LoginBusiness loginBusiness = new LoginBusiness();
		
		return loginBusiness.changeUser(cadenaJson);
	}

	@Override
	public ResponseVO changeUserLdap(LoginRecordVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo changeUserLdap de la clase LoginServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = changeUserLdapMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String validateLoginMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateLoginMobil de la clase LoginServiceImp");
		
		final LoginBusiness loginBusiness = new LoginBusiness();
		
		return loginBusiness.validateLogin(cadenaJson);
	}

	@Override
	public ResponseVO validateLogin(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo validateLogin de la clase LoginServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = validateLoginMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String addUserLdapMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo addUserLdapMobil de la clase LoginServiceImp");
		
		final LoginBusiness loginBusiness = new LoginBusiness();
		
		return loginBusiness.addUser(cadenaJson);
	}

	@Override
	public ResponseVO addUserLdap(LoginRecordVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo addUserLdap de la clase LoginServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = addUserLdapMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String generatePasswordLdapMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo generatePasswordLdapMobil de la clase LoginServiceImp");
		
		final LoginBusiness loginBusiness = new LoginBusiness();
		
		return loginBusiness.generatePasswordLdap(cadenaJson);
	}

	@Override
	public ResponseVO generatePasswordLdap(LoginRecordVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo generatePasswordLdap de la clase LoginServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = generatePasswordLdapMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String searchInfoUserLdapMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo serachInfoUserLdapMobil de la clase LoginServiceImp");
		
		final LoginBusiness loginBusiness = new LoginBusiness();
		
		return loginBusiness.serachInfoUserLdap(cadenaJson);
	}

	@Override
	public ResponseVO searchInfoUserLdap(LoginRecordVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo serachInfoUserLdap de la clase LoginServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = searchInfoUserLdapMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getCarrierMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getCarrierMobile de la clase LoginServiceImp");
		
		final LoginBusiness loginBusiness = new LoginBusiness();
		
		return loginBusiness.getCarrier(cadenaJson);
	}

	@Override
	public ResponseVO getCarrier(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getCarrier de la clase LoginServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getCarrierMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getCustomerFromDNMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getCustomerFromDNMobile de la clase LoginServiceImp");
		
		final LoginBusiness loginBusiness = new LoginBusiness();
		
		return loginBusiness.getCustomerFromDN(cadenaJson);
	}

	@Override
	public ResponseVO getCustomerFromDN(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getCustomerFromDN de la clase LoginServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getCustomerFromDNMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String validateLoginSplitMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateLoginSplitMobile de la clase LoginServiceImp");
		
		final LoginBusiness loginBusiness = new LoginBusiness();
		
		return loginBusiness.validateLoginSplit(cadenaJson);
	}
}