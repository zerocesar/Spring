package mx.com.att.services.ws.customers;

import javax.jws.WebService;

import mx.com.att.business.gpay.CustomerTDCBusiness;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.ClienteTDCVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

@WebService(portName="CustomerTDCServicePort", 
serviceName="CustomerTDCService", 
targetNamespace="http://www.att.com.mx/att/services/ws/customers/customerTDCService", 
endpointInterface="mx.com.att.services.ws.customers.CustomerTDCService")
public class CustomerTDCServiceImpl implements CustomerTDCService{

	private static final Logger LOGGER = Logger.getLogger(CustomerTDCServiceImpl.class);
	
	@Override
	public String addCustomerMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo addCustomerMobile de la clase CustomerTDCServiceImpl");
		
		final CustomerTDCBusiness customerTDCBusiness = new CustomerTDCBusiness();
		
		return customerTDCBusiness.addCustomer(cadenaJson);
	}
	
	public ResponseVO addCustomer(final ClienteTDCVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo addCustomer de la clase CustomerTDCServiceImpl");
		
		final String request = new Gson().toJson(requestVO);
		final String response = addCustomerMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String changeCredentialsMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo changeCredentialsMobile de la clase CustomerTDCServiceImpl");
		
		final CustomerTDCBusiness customerTDCBusiness = new CustomerTDCBusiness();
		
		return customerTDCBusiness.changeCredentials(cadenaJson);
	}
	
	public ResponseVO changeCredentials(final ClienteTDCVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo addCustomer de la clase changeCredentials");
		
		final String request = new Gson().toJson(requestVO);
		final String response = changeCredentialsMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String deleteCustomerMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo deleteCustomerMobile de la clase CustomerTDCServiceImpl");
		
		final CustomerTDCBusiness customerTDCBusiness = new CustomerTDCBusiness();
		
		return customerTDCBusiness.deleteCustomer(cadenaJson);
	}
	
	public ResponseVO deleteCustomer(final ClienteTDCVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo deleteCustomer de la clase changeCredentials");
		
		final String request = new Gson().toJson(requestVO);
		final String response = deleteCustomerMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String editCustomerMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo editCustomerMobile de la clase CustomerTDCServiceImpl");
		
		final CustomerTDCBusiness customerTDCBusiness = new CustomerTDCBusiness();
		
		return customerTDCBusiness.editCustomer(cadenaJson);
	}
	
	public ResponseVO editCustomer(final ClienteTDCVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo editCustomer de la clase changeCredentials");
		
		final String request = new Gson().toJson(requestVO);
		final String response = editCustomerMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getCustomerInfoMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getCustomerInfoMobile de la clase CustomerTDCServiceImpl");
		
		final CustomerTDCBusiness customerTDCBusiness = new CustomerTDCBusiness();
		
		return customerTDCBusiness.getCustomerInfo(cadenaJson);
	}
	
	public ResponseVO getCustomerInfo(final ClienteTDCVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo getCustomerInfo de la clase changeCredentials");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getCustomerInfoMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getCustomerSignupStatusMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getCustomerSignupStatusMobile de la clase CustomerTDCServiceImpl");
		
		final CustomerTDCBusiness customerTDCBusiness = new CustomerTDCBusiness();
		
		return customerTDCBusiness.getCustomerSignupStatus(cadenaJson);
	}
	
	public ResponseVO getCustomerSignupStatus(final ClienteTDCVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo getCustomerSignupStatus de la clase changeCredentials");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getCustomerSignupStatusMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getCustomerTokenMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getCustomerTokenMobile de la clase CustomerTDCServiceImpl");
		
		final CustomerTDCBusiness customerTDCBusiness = new CustomerTDCBusiness();
		
		return customerTDCBusiness.getCustomerToken(cadenaJson);
	}
	
	public ResponseVO getCustomerToken(final ClienteTDCVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo getCustomerToken de la clase changeCredentials");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getCustomerTokenMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String setCustomerCredentialsMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo setCustomerCredentialsMobile de la clase CustomerTDCServiceImpl");
		
		final CustomerTDCBusiness customerTDCBusiness = new CustomerTDCBusiness();
		
		return customerTDCBusiness.setCustomerCredentials(cadenaJson);
	}
	
	public ResponseVO setCustomerCredentials(final ClienteTDCVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo setCustomerCredentials de la clase changeCredentials");
		
		final String request = new Gson().toJson(requestVO);
		final String response = setCustomerCredentialsMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}