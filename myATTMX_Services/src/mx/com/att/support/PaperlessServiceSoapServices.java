package mx.com.att.support;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.paperless.PaperlessServicePortTypeProxy;

import org.apache.log4j.Logger;

public final class PaperlessServiceSoapServices {
	
	private static final Logger LOGGER = Logger.getLogger(PaperlessServiceSoapServices.class);
	private static volatile PaperlessServicePortTypeProxy service;
	
	private PaperlessServiceSoapServices(){
		
	}
	
	/**
	 * Este metodo instancia el proxy  de PaperlessWS
	 * @author Francisco Oliva - MindBits Desarrollo (17/OCT/2013)
	 * @return PaperlessServicePortTypeProxy que es proxy a la
	 *  conexion del servicio PaperlessWS
	 */
	public static PaperlessServicePortTypeProxy getPaperlessServices(){
		if(PaperlessServiceSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_PAPERLESS + "PaperlessWS/services/PaperlessService";
			LOGGER.info("ENDPOINT -- " + url);
			PaperlessServiceSoapServices.service = new PaperlessServicePortTypeProxy();
			PaperlessServiceSoapServices.service.setEndpoint(url);
		}
		
		return PaperlessServiceSoapServices.service;
	}
}