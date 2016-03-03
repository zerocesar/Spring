package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;

import org.apache.log4j.Logger;

import com.nextel.pgw.ws.PaymentGatewayWSServiceLocator;
import com.nextel.pgw.ws.PaymentGatewayWSSoapBindingStub;

public final class PaymentGatewaySoapService {

	private static final Logger LOGGER = Logger.getLogger( ClienteTDCSoapService.class );
	private static volatile PaymentGatewayWSSoapBindingStub servicio;
	
	private PaymentGatewaySoapService(){
		
	}
	
	public static PaymentGatewayWSSoapBindingStub consultaProxy(){
		if(PaymentGatewaySoapService.servicio == null) {
			final String url = ATTConstants.URL_WS_PAYMENT_GATEWAY + "PaymentGatewayWS/services/PaymentGatewayWS?wsdl";
			LOGGER.info("ENDPOINT -- " + url);

			try {
				final PaymentGatewayWSServiceLocator locator = new PaymentGatewayWSServiceLocator();
				locator.setPaymentGatewayWSEndpointAddress(url);
				PaymentGatewaySoapService.servicio = (PaymentGatewayWSSoapBindingStub)locator.getPaymentGatewayWS();
			} catch (ServiceException e) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", e);
			}
			
		}
		
		return PaymentGatewaySoapService.servicio;
	}
}