package mx.com.att.services.ws.customers;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.TarjetaTDCVO;

@WebService(name = "CardTDCService", 
targetNamespace = "http://www.att.com.mx/att/services/ws/customers/cardTDCService")
public interface CardTDCService {

	String RETURN = "return";
	String TARJETAVO = "TarjetaTDCVO";
	String JSON = "tarjetaTDCJson";
	
	@WebMethod(operationName="registerTDC")
	@WebResult(name = RETURN)
	ResponseVO registerTDC(@WebParam(name = TARJETAVO) TarjetaTDCVO requestVO);
	
	@WebMethod(operationName="registerTDCMobile")
	@WebResult(name = RETURN)
	String registerTDCMobile(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="defaultTDC")
	@WebResult(name = RETURN)
	ResponseVO defaultTDC(@WebParam(name = TARJETAVO) TarjetaTDCVO requestVO);
	
	@WebMethod(operationName="defaultTDCMobile")
	@WebResult(name = RETURN)
	String defaultTDCMobile(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getCustomerTDC")
	@WebResult(name = RETURN)
	ResponseVO getCustomerTDC(@WebParam(name = TARJETAVO) TarjetaTDCVO requestVO);
	
	@WebMethod(operationName="getCustomerTDCMobile")
	@WebResult(name = RETURN)
	String getCustomerTDCMobile(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="deactivateTDC")
	@WebResult(name = RETURN)
	ResponseVO deactivateTDC(@WebParam(name = TARJETAVO) TarjetaTDCVO requestVO);
	
	@WebMethod(operationName="deactivateTDCMobile")
	@WebResult(name = RETURN)
	String deactivateTDCMobile(@WebParam(name = JSON) String cadenaJson);
}