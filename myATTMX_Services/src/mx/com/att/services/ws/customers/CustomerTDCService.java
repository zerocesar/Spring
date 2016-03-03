package mx.com.att.services.ws.customers;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.ClienteTDCVO;

@WebService(name = "CustomerTDCService", 
targetNamespace = "http://www.att.com.mx/att/services/ws/customers/customerTDCService")
public interface CustomerTDCService {

	String RETURN = "return";
	String CLIENTEVO = "ClienteTDCVO";
	String JSON = "clienteTDCJson";

	@WebMethod(operationName="addCustomer")
	@WebResult(name = RETURN)
	ResponseVO addCustomer(@WebParam(name = CLIENTEVO) ClienteTDCVO requestVO);
	
	@WebMethod(operationName="addCustomerMobile")
	@WebResult(name = RETURN)
	String addCustomerMobile(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="changeCredentials")
	@WebResult(name = RETURN)
	ResponseVO changeCredentials(@WebParam(name = CLIENTEVO) ClienteTDCVO requestVO);
	
	@WebMethod(operationName="changeCredentialsMobile")
	@WebResult(name = RETURN)
	String changeCredentialsMobile(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="deleteCustomer")
	@WebResult(name = RETURN)
	ResponseVO deleteCustomer(@WebParam(name = CLIENTEVO) ClienteTDCVO requestVO);
	
	@WebMethod(operationName="deleteCustomerMobile")
	@WebResult(name = RETURN)
	String deleteCustomerMobile(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="editCustomer")
	@WebResult(name = RETURN)
	ResponseVO editCustomer(@WebParam(name = CLIENTEVO) ClienteTDCVO requestVO);
	
	@WebMethod(operationName="editCustomerMobile")
	@WebResult(name = RETURN)
	String editCustomerMobile(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getCustomerInfo")
	@WebResult(name = RETURN)
	ResponseVO getCustomerInfo(@WebParam(name = CLIENTEVO) ClienteTDCVO requestVO);
	
	@WebMethod(operationName="getCustomerInfoMobile")
	@WebResult(name = RETURN)
	String getCustomerInfoMobile(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getCustomerSignupStatus")
	@WebResult(name = RETURN)
	ResponseVO getCustomerSignupStatus(@WebParam(name = CLIENTEVO) ClienteTDCVO requestVO);
	
	@WebMethod(operationName="getCustomerSignupStatusMobile")
	@WebResult(name = RETURN)
	String getCustomerSignupStatusMobile(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getCustomerToken")
	@WebResult(name = RETURN)
	ResponseVO getCustomerToken(@WebParam(name = CLIENTEVO) ClienteTDCVO requestVO);
	
	@WebMethod(operationName="getCustomerTokenMobile")
	@WebResult(name = RETURN)
	String getCustomerTokenMobile(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="setCustomerCredentials")
	@WebResult(name = RETURN)
	ResponseVO setCustomerCredentials(@WebParam(name = CLIENTEVO) ClienteTDCVO requestVO);
	
	@WebMethod(operationName="setCustomerCredentialsMobile")
	@WebResult(name = RETURN)
	String setCustomerCredentialsMobile(@WebParam(name = JSON) String cadenaJson);
}