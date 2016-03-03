package mx.com.att.services.ws.payments;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;

@WebService(name="PaymentService",
targetNamespace="http://www.att.com.mx/att/services/ws/payments/paymentService")
public interface PaymentService {
	
	String RETURN = "return";
	String PAYMENTRESPVO = "paymentRespVO";
	String JSON = "paymentJson";
	
	@WebMethod(operationName="getPaymentReferenceMobile")
	@WebResult(name = RETURN)
	String getPaymentReferenceMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getPaymentReference")
	@WebResult(name = RETURN)
	ResponseVO getPaymentReference(@WebParam(name = PAYMENTRESPVO) PaymentRespVO requestVO);
}
