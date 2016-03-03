package mx.com.att.services.ws.security;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.LoginRecordVO;
import mx.com.att.vo.ResponseVO;

@WebService(name = "LoginService", 
targetNamespace = "http://www.att.com.mx/att/services/ws/security/loginService")
public interface LoginService {

	String RETURN = "return";
	String CUSTOMERVO = "customerVO";
	String LOGINRECORDVO = "loginRecordVO";
	String JSON = "customerJson";
	
	@WebMethod(operationName="changeUserLdapMobile")
	@WebResult(name = RETURN)
	String changeUserLdapMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="changedUserLdap")
	@WebResult(name = RETURN)
	ResponseVO changeUserLdap(@WebParam(name = LOGINRECORDVO) LoginRecordVO requestVO);
	
	@WebMethod(operationName="validateLoginMobile")
	@WebResult(name = RETURN)
	String validateLoginMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="validateLogin")
	@WebResult(name = RETURN)
	ResponseVO validateLogin(@WebParam(name = CUSTOMERVO) CustomerVO requestVO);
	
	@WebMethod(operationName="addUserLdapMobile")
	@WebResult(name = RETURN)
	String addUserLdapMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="addUserLdap")
	@WebResult(name = RETURN)
	ResponseVO addUserLdap(@WebParam(name = LOGINRECORDVO) LoginRecordVO requestVO);
	
	@WebMethod(operationName="generatePasswordLdapMobile")
	@WebResult(name = RETURN)
	String generatePasswordLdapMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="generatePasswordLdap")
	@WebResult(name = RETURN)
	ResponseVO generatePasswordLdap(@WebParam(name = LOGINRECORDVO) LoginRecordVO requestVO);
	
	@WebMethod(operationName="searchInfoUserLdapMobile")
	@WebResult(name = RETURN)
	String searchInfoUserLdapMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="searchInfoUserLdap")
	@WebResult(name = RETURN)
	ResponseVO searchInfoUserLdap(@WebParam(name = LOGINRECORDVO) LoginRecordVO requestVO);
	
	@WebMethod(operationName="getCarrierMobile")
	@WebResult(name = RETURN)
	String getCarrierMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getCarrier")
	@WebResult(name = RETURN)
	ResponseVO getCarrier(@WebParam(name = LOGINRECORDVO) CustomerVO requestVO);
	
	@WebMethod(operationName="getCustomerFromDNMobile")
	@WebResult(name = RETURN)
	String getCustomerFromDNMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getCustomerFromDN")
	@WebResult(name = RETURN)
	ResponseVO getCustomerFromDN(@WebParam(name = LOGINRECORDVO) CustomerVO requestVO);
	
	@WebMethod(operationName="validateLoginSplitMobile")
	@WebResult(name = RETURN)
	String validateLoginSplitMobile(@WebParam(name = JSON) String cadenaJson);		
}