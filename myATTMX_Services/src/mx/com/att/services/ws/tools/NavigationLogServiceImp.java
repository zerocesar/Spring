package mx.com.att.services.ws.tools;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.NavigationLogBusiness;
import mx.com.att.vo.orange.LoginAttemptVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.LoginVO;
import mx.com.att.vo.orange.NavigationVO;
import mx.com.att.vo.orange.SugerenciasVO;

@WebService(portName="NavigationLogServicePort",
serviceName="NavigationLogService",
targetNamespace="http://www.att.com.mx/att/services/ws/tools/navigationLogService",
endpointInterface="mx.com.att.services.ws.tools.NavigationLogService")
public class NavigationLogServiceImp implements NavigationLogService {
	
	private static final Logger LOGGER = Logger.getLogger(NavigationLogServiceImp.class);
	
	@Override
	public String registerCSQMobile(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo registerCSQMobil de la clase NavigationLogServiceImp");
		
		final NavigationLogBusiness navigationLogBusiness = new NavigationLogBusiness();
		return navigationLogBusiness.csqRegister(cadenaJson);
	}
	
	@Override
	public ResponseVO registerCSQ(SugerenciasVO sugerenciasVO){
		LOGGER.info("Comienza la ejecucion del metodo registerCSQM de la clase NavigationLogServiceImp");
		final String request = new Gson().toJson(sugerenciasVO);
		final String response = registerCSQMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getCsqCatSubcategoryMobile(){
		LOGGER.info("Comienza la ejecucion del metodo getCsqCatSubcategoryMobil de la clase NavigationLogServiceImp");
		
		final NavigationLogBusiness navigationLogBusiness = new NavigationLogBusiness();
		return navigationLogBusiness.getCsqCatSubcategory();
	}
	
	@Override
	public ResponseVO getCsqCatSubcategory(){
		LOGGER.info("Comienza la ejecucion del metodo getCsqCatSubcategory de la clase NavigationLogServiceImp");
		final String response = getCsqCatSubcategoryMobile();
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String setLoginMobile(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo setLoginMobil de la clase NavigationLogServiceImp");
		
		final NavigationLogBusiness navigationLogBusiness = new NavigationLogBusiness();
		return navigationLogBusiness.login(cadenaJson);
	}
	
	@Override
	public ResponseVO setLogin(LoginVO loginVO){
		LOGGER.info("Comienza la ejecucion del metodo setLogin de la clase NavigationLogServiceImp");
		final String request = new Gson().toJson(loginVO);
		final String response = setLoginMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String setLoginAttemptMobile(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo setLoginAttemptMobil de la clase NavigationLogServiceImp");
		
		final NavigationLogBusiness navigationLogBusiness = new NavigationLogBusiness();
		return navigationLogBusiness.loginAttempt(cadenaJson);
	}
	
	@Override
	public ResponseVO setLoginAttempt(LoginAttemptVO loginAttemptVO){
		LOGGER.info("Comienza la ejecucion del metodo setLoginAttempt de la clase NavigationLogServiceImp");
		final String request = new Gson().toJson(loginAttemptVO);
		final String response = setLoginAttemptMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String setLogNavigationMobile(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo setLogNavigationMobil de la clase NavigationLogServiceImp");
		
		final NavigationLogBusiness navigationLogBusiness = new NavigationLogBusiness();
		return navigationLogBusiness.logNavigation(cadenaJson);
	}
	
	@Override
	public ResponseVO setLogNavigation(NavigationVO navigationVO){
		LOGGER.info("Comienza la ejecucion del metodo setLogNavigation de la clase NavigationLogServiceImp");
		final String request = new Gson().toJson(navigationVO);
		final String response = setLogNavigationMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String setLogoutMobile(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo setLogoutMobil de la clase NavigationLogServiceImp");
		
		final NavigationLogBusiness navigationLogBusiness = new NavigationLogBusiness();
		return navigationLogBusiness.logout(cadenaJson);
	}
	
	@Override
	public ResponseVO setLogout(LoginVO navigationVO){
		LOGGER.info("Comienza la ejecucion del metodo setLogout de la clase NavigationLogServiceImp");
		final String request = new Gson().toJson(navigationVO);
		final String response = setLogoutMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}