package mx.com.att.services.ws.amdoc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="AmdocService",
targetNamespace="http://www.att.com.mx/att/services/ws/amdocService")
public interface AmdocService {
	
	String RETURN = "return";
	String JSON = "responseJson";
	
	@WebMethod(operationName="getCustomerFromDnMobileAMDOCS")
	@WebResult(name = RETURN)
	String getCustomerFromDnMobileAMDOCS(@WebParam(name = JSON) String cadenaJson);		
	
	@WebMethod(operationName="validateLoginMobileAMDOCS")
	@WebResult(name = RETURN)
	String validateLoginMobileAMDOCS(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getUnbilledCallDetailsAMDOCS")
    @WebResult(name = RETURN)
    String getUnbilledCallDetailsAMDOCS(@WebParam(name = JSON) String cadenaJson);
    
    @WebMethod(operationName="getProductsAMDOCS")
    @WebResult(name = RETURN)
    String getProductsAMDOCS(@WebParam(name = JSON) String cadenaJson);
    
    @WebMethod(operationName="getProductsDetailsAMDOCS")
    @WebResult(name = RETURN)
    String getProductsDetailsAMDOCS(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getPocketsLimitMobileAMDOCS")
	@WebResult(name = RETURN)
	String getPocketsLimitMobileAMDOCS(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getAccountBalanceMobileAMDOCS")
	@WebResult(name = RETURN)
	String getAccountBalanceMobileAMDOCS(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getAccountContractsBrothersDNMobileAMDOCS")
	@WebResult(name = RETURN)
	String getAccountContractsBrothersDNMobileAMDOCS(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getAvailableActionsAMDOCS")
	@WebResult(name = RETURN)
	String getAvailableActionsAMDOCS(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getAvailableProductsAMDOCS")
	@WebResult(name = RETURN)
	String getAvailableProductsAMDOCS(@WebParam(name = JSON) String cadenaJson);	
	
	@WebMethod(operationName="setConfigurationAMDOCS")
	@WebResult(name = RETURN)
	String setConfigurationAMDOCS(@WebParam(name = JSON) String cadenaJson);	
	
	@WebMethod(operationName="getLastInvoiceAMDOCS")
	@WebResult(name = RETURN)
	String getLastInvoiceAMDOCS(@WebParam(name = JSON) String cadenaJson);	
	
	@WebMethod(operationName="getLastTotalBillAMDOCS")
	@WebResult(name = RETURN)
	String getLastTotalBillAMDOCS(@WebParam(name = JSON) String cadenaJson);	
}