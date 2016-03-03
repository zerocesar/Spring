package mx.com.att.support;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.www.wppp.ws.clientes.ClientesWPPPSoapProxy;

import org.apache.log4j.Logger;

public final class ClientesWPPPSoapServices {
	
	private static final Logger LOGGER = Logger.getLogger(ClientesWPPPSoapServices.class);
	private static volatile ClientesWPPPSoapProxy service;
	
	private ClientesWPPPSoapServices(){
		
	}
	
	/**
	 * Este metodo instancia el proxy  de SrvWPPospago
	 * @author Edgar Gutierrez - MindBits Desarrollo (07/OCT/2015)
	 * @return ClientesWPPPSoapProxy que es proxy a la
	 *  conexion del servicio SrvWPPospago
	 */
	public static ClientesWPPPSoapProxy getClientesWPPPSoapServices() {
		if(ClientesWPPPSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_POSTPAID + "SrvWPPospago/ClientesWPPP?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			ClientesWPPPSoapServices.service = new ClientesWPPPSoapProxy();
			ClientesWPPPSoapServices.service.setEndpoint(url);
		}
		
		return ClientesWPPPSoapServices.service;
	}
}