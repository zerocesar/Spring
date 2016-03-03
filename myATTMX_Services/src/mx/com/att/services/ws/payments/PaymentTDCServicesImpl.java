package mx.com.att.services.ws.payments;

import javax.jws.WebService;

import mx.com.att.business.gpay.PaymentTDCBusiness;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.PagoTDCVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

@WebService(portName="PaymentTDCServicePort", 
serviceName="PaymentTDCService", 
targetNamespace="http://www.att.com.mx/att/services/ws/payments/paymentTDCService", 
endpointInterface="mx.com.att.services.ws.payments.PaymentTDCService")
public class PaymentTDCServicesImpl implements PaymentTDCService {

	private static final Logger LOGGER = Logger.getLogger(PaymentTDCServicesImpl.class);
	
	@Override
	public String addTransactionMovil(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo addTransactionMovil de la clase PaymentTDCServicesImpl");
		
		final PaymentTDCBusiness paymentTDCBusiness = new PaymentTDCBusiness();
		
		return paymentTDCBusiness.addTransaction(cadenaJson);
	}
	
	@Override
	public ResponseVO addTransaction(final PagoTDCVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo addTransactionMovil de la clase PaymentTDCServicesImpl");
		
		final String request = new Gson().toJson(requestVO);
		final String response = addTransactionMovil(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getTransactionInfoMovil(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getTransactionInfoMovil de la clase PaymentTDCServicesImpl");
		
		final PaymentTDCBusiness paymentTDCBusiness = new PaymentTDCBusiness();
		
		return paymentTDCBusiness.getTransactionInfo(cadenaJson);
	}
	
	@Override
	public ResponseVO getTransactionInfo(final PagoTDCVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getTransactionInfo de la clase PaymentTDCServicesImpl");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getTransactionInfoMovil(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}