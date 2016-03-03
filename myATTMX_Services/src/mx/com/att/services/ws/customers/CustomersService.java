package mx.com.att.services.ws.customers;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.OrdenesWPVO;
import mx.com.att.vo.orange.ServiceOrderWPVO;

@WebService(name = "CustomersService", 
targetNamespace = "http://www.att.com.mx/att/services/ws/customers/customersService")
public interface CustomersService {

	String RETURN = "return";
	String CUSTOMERVO = "customerVO";
	String PAYMENTRESPVO = "paymentRespVO";
	String ORDENESWPVO = "ordenesWpVO";
	String SERVICEORDERWPVO = "serviceOrderWpVO";
	String JSON = "customerJson";
	
	@WebMethod(operationName="getBlockedDnMobile")
	@WebResult(name = RETURN)
	String getBlockedDnMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getBlockedDn")
	@WebResult(name = RETURN)
	ResponseVO getBlockedDn(@WebParam(name = PAYMENTRESPVO) PaymentRespVO requestVO);
	
	@WebMethod(operationName="getAccountContractsBrothersDnMobile")
	@WebResult(name = RETURN)
	String getAccountContractsBrothersDnMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getAccountContractsBrothersDn")
	@WebResult(name = RETURN)
	ResponseVO getAccountContractsBrothersDn(@WebParam(name = CUSTOMERVO) CustomerVO requestVO);
	
	@WebMethod(operationName="getServiceBalanceMobile")
	@WebResult(name = RETURN)
	String getServiceBalanceMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getServiceBalance")
	@WebResult(name = RETURN)
	ResponseVO getServiceBalance(@WebParam(name = CUSTOMERVO) CustomerVO requestVO);
	
	@WebMethod(operationName="getTicketInfoMobile")
	@WebResult(name = RETURN)
	String getTicketInfoMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getTicketInfo")
	@WebResult(name = RETURN)
	ResponseVO getTicketInfo(@WebParam(name = ORDENESWPVO) OrdenesWPVO requestVO);
	
	@WebMethod(operationName="getPocketsMobile")
	@WebResult(name = RETURN)
	String getPocketsMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getPockets")
	@WebResult(name = RETURN)
	ResponseVO getPockets(@WebParam(name = CUSTOMERVO) CustomerVO requestVO);
	
	@WebMethod(operationName="getPocketsLimitMobile")
	@WebResult(name = RETURN)
	String getPocketsLimitMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getPocketsLimit")
	@WebResult(name = RETURN)
	ResponseVO getPocketsLimit(@WebParam(name = CUSTOMERVO) CustomerVO requestVO);
	
	@WebMethod(operationName="getAccountBalanceMobile")
	@WebResult(name = RETURN)
	String getAccountBalanceMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getAccountBalance")
	@WebResult(name = RETURN)
	ResponseVO getAccountBalance(@WebParam(name = CUSTOMERVO) CustomerVO requestVO);
	
	@WebMethod(operationName="getServiceOrderMobile")
	@WebResult(name = RETURN)
	String getServiceOrderMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getServiceOrder")
	@WebResult(name = RETURN)
	ResponseVO getServiceOrder(@WebParam(name = ORDENESWPVO) OrdenesWPVO requestVO);
	
	@WebMethod(operationName="setServiceOrderRegisterMobile")
	@WebResult(name = RETURN)
	String setServiceOrderRegisterMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="setServiceOrderRegister")
	@WebResult(name = RETURN)
	ResponseVO setServiceOrderRegister(@WebParam(name = SERVICEORDERWPVO) ServiceOrderWPVO requestVO);
	
	@WebMethod(operationName="updateServiceOrderStatusMobile")
	@WebResult(name = RETURN)
	String updateServiceOrderStatusMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="updateServiceOrderStatus")
	@WebResult(name = RETURN)
	ResponseVO updateServiceOrderStatus(@WebParam(name = SERVICEORDERWPVO) ServiceOrderWPVO requestVO);
}