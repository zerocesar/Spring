package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.pggpay.ops.service.impl.ClienteServiceLocator;
import mx.com.nextel.pggpay.ops.service.impl.ClienteServiceSoapBindingStub;

import org.apache.log4j.Logger;

public final class ClienteTDCSoapService {
	
	private static final Logger LOGGER = Logger.getLogger( ClienteTDCSoapService.class );
	private static volatile ClienteServiceSoapBindingStub servicio;
	
	private ClienteTDCSoapService(){
		
	}
	
	public static ClienteServiceSoapBindingStub consultaProxy(){
		if(ClienteTDCSoapService.servicio == null) {
			final String url = ATTConstants.URL_WS_GPAY + "OnlinePaymentService/ClienteService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final ClienteServiceLocator locator = new ClienteServiceLocator();
				locator.setClienteServiceImplPortEndpointAddress(url);
				ClienteTDCSoapService.servicio = (ClienteServiceSoapBindingStub)locator.getClienteServiceImplPort();
			} catch (ServiceException e) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", e);
			}
		}
		
		return ClienteTDCSoapService.servicio;
	}
}