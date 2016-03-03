package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.www.ecommerce.ws.cliente.ClienteServiceLocator;
import mx.com.nextel.www.ecommerce.ws.cliente.ClientesOESoapBindingStub;

import org.apache.log4j.Logger;

public final class ClientesOESoapServices {

	private static final Logger LOGGER = Logger.getLogger( ClientesOESoapServices.class );
	private static volatile ClientesOESoapBindingStub service;
	
	private ClientesOESoapServices(){
		
	}
	
	public static ClientesOESoapBindingStub getClientesOEService(){

		if(ClientesOESoapServices.service == null) {
			final String url = ATTConstants.URL_WS_ECOMMERCE + "EcommerceServices/ClienteService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final ClienteServiceLocator locator = new ClienteServiceLocator();
				locator.setClientesOESoapEndpointAddress(url);
				ClientesOESoapServices.service = (ClientesOESoapBindingStub) locator.getClientesOESoap();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return ClientesOESoapServices.service;
	}
}