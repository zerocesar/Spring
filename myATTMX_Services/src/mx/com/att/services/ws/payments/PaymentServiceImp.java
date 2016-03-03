package mx.com.att.services.ws.payments;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.PaymentBusiness;
import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;

@WebService(portName="PaymentServicePort",
serviceName="PaymentService",
targetNamespace="http://www.att.com.mx/att/services/ws/payments/paymentService",
endpointInterface="mx.com.att.services.ws.payments.PaymentService")
public class PaymentServiceImp implements PaymentService {
	
	private static final Logger LOGGER = Logger.getLogger(PaymentServiceImp.class);
	
	@Override
	public String getPaymentReferenceMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPaymentReferenceMobile de la clase PaymentServiceImp");
		
		final PaymentBusiness paymentBusiness = new PaymentBusiness();
		
		return paymentBusiness.getPaymentReference(cadenaJson);
	}

	@Override
	public ResponseVO getPaymentReference(PaymentRespVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getPaymentReference de la clase PaymentServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getPaymentReferenceMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}