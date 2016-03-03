package mx.com.att.support;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.www.wppp.ws.contratos.ContratosWPPPSoapProxy;

import org.apache.log4j.Logger;

public final class ContratosWPPPSoapServices {
	
	private static final Logger LOGGER = Logger.getLogger(ContratosWPPPSoapServices.class);
	private static volatile ContratosWPPPSoapProxy servicios;

	private ContratosWPPPSoapServices(){
		
	}

	/**
	 * Este metodo instancia el proxy  de SrvWPPospago
	 * @author Francisco Oliva - MindBits Desarrollo (17/OCT/2013)
	 * @return ContratosWPPPSoapProxy que es proxy a la 
	 * conexion del servicio SrvWPPospago
	 */
	
	public static ContratosWPPPSoapProxy getContratosWPPPSoapServices() {
		if(ContratosWPPPSoapServices.servicios == null) {
			String url = ATTConstants.URL_WS_POSTPAID + "SrvWPPospago/ContratosWPPP?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			ContratosWPPPSoapServices.servicios = new ContratosWPPPSoapProxy();
			ContratosWPPPSoapServices.servicios.setEndpoint(url);
		}
		return ContratosWPPPSoapServices.servicios;
	}
}