package mx.com.att.services.ws.tools;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.orange.LoginAttemptVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.LoginVO;
import mx.com.att.vo.orange.NavigationVO;
import mx.com.att.vo.orange.SugerenciasVO;

@WebService(name = "NavigationLogService",
targetNamespace = "http://www.att.com.mx/att/services/ws/tools/navigationLogService")
public interface NavigationLogService {
	
	String RETURN = "return";
	String LOGINATTEMPTVO = "loginAttemptVO";
	String NAVIGATIONVO = "navigationVO";
	String LOGINVO = "loginVO";
	String SUGERENCIASVO = "sugerenciasVO";
	String JSON = "loginAttemptJson";

	@WebMethod(operationName="registerCSQMobile")
	@WebResult(name = RETURN)
	String registerCSQMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="registerCSQ")
	@WebResult(name = RETURN)
	ResponseVO registerCSQ(@WebParam(name = SUGERENCIASVO) SugerenciasVO requestVO);
	
	@WebMethod(operationName="getCsqCatSubcategoryMobile")
	@WebResult(name = RETURN)
	String getCsqCatSubcategoryMobile();

	@WebMethod(operationName="getCsqCatSubcategory")
	@WebResult(name = RETURN)
	ResponseVO getCsqCatSubcategory();
	
	@WebMethod(operationName="setLoginMobile")
	@WebResult(name = RETURN)
	String setLoginMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="setLogin")
	@WebResult(name = RETURN)
	ResponseVO setLogin(@WebParam(name = LOGINVO) LoginVO requestVO);
	
	@WebMethod(operationName="setLoginAttemptMobile")
	@WebResult(name = RETURN)
	String setLoginAttemptMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="setLoginAttempt")
	@WebResult(name = RETURN)
	ResponseVO setLoginAttempt(@WebParam(name = LOGINATTEMPTVO) LoginAttemptVO requestVO);
	
	@WebMethod(operationName="setLogNavigationMobile")
	@WebResult(name = RETURN)
	String setLogNavigationMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="setLogNavigation")
	@WebResult(name = RETURN)
	ResponseVO setLogNavigation(@WebParam(name = NAVIGATIONVO) NavigationVO requestVO);
	
	@WebMethod(operationName="setLogoutMobile")
	@WebResult(name = RETURN)
	String setLogoutMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="setLogout")
	@WebResult(name = RETURN)
	ResponseVO setLogout(@WebParam(name = LOGINVO) LoginVO requestVO);
}