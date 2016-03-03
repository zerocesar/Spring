package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.www.ecommerce.ws.adicion.ClientesAdicionPortBindingStub;
import mx.com.nextel.www.ecommerce.ws.adicion.ClientesAdicionServiceLocator;

import org.apache.log4j.Logger;

public final class ClientesAdicionSoapServices {

	private static final Logger LOGGER = Logger.getLogger( ClientesAdicionSoapServices.class );
	private static volatile ClientesAdicionPortBindingStub service;
	
	private ClientesAdicionSoapServices(){
		
	}
	
	public static ClientesAdicionPortBindingStub getClientesAdicionService(){

		if(ClientesAdicionSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_ECOMMERCE + "EcommerceServices/ClientesAdicionService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final ClientesAdicionServiceLocator locator = new ClientesAdicionServiceLocator();
				locator.setClientesAdicionPortEndpointAddress(url);
				ClientesAdicionSoapServices.service = (ClientesAdicionPortBindingStub) locator.getClientesAdicionPort();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return ClientesAdicionSoapServices.service;
	}
}