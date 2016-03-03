package mx.com.att.services.ws.payments;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.PagoTDCVO;

@WebService(name = "PaymentTDCService", 
targetNamespace = "http://www.att.com.mx/att/services/ws/payments/paymentTDCService")
public interface PaymentTDCService {

	String RETURN = "return";
	String PAGOVO = "PagoTDCVO";
	String JSON = "pagoTDCJson";
	
	@WebMethod(operationName="addTransaction")
	@WebResult(name = RETURN)
	ResponseVO addTransaction(@WebParam(name = PAGOVO) PagoTDCVO requestVO);
	
	@WebMethod(operationName="addTransactionMovil")
	@WebResult(name = RETURN)
	String addTransactionMovil(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getTransactionInfo")
	@WebResult(name = RETURN)
	ResponseVO getTransactionInfo(@WebParam(name = PAGOVO) PagoTDCVO requestVO);
	
	@WebMethod(operationName="getTransactionInfoMovil")
	@WebResult(name = RETURN)
	String getTransactionInfoMovil(@WebParam(name = JSON) String cadenaJson);
}