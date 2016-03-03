package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.www.ws.CatalogosServiceLocator;
import mx.com.nextel.www.ws.CatalogosServiceSoapBindingStub;

import org.apache.log4j.Logger;

public final class CatalogSoapServices {
	
	private static final Logger LOGGER = Logger.getLogger(CatalogSoapServices.class);
	private static volatile CatalogosServiceSoapBindingStub service;
	
	private CatalogSoapServices(){
		
	}
	
	/**
	 * Este metodo instancia el proxy  de MARServiciosPrepago
	 * @author Francisco Oliva - MindBits Desarrollo (17/OCT/2013)
	 * @return CatalogosServiceSoapProxy que es proxy a la
	 *  conexion del servicio MARServiciosPrepago
	 */
	public static CatalogosServiceSoapBindingStub getCatalogSoapServices() {
		if(CatalogSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_MAP + "MARServiciosPrepago/CatalogosService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final CatalogosServiceLocator locator = new CatalogosServiceLocator(); 
				locator.setCatalogosServiceSoapEndpointAddress(url);
				CatalogSoapServices.service = (CatalogosServiceSoapBindingStub) locator.getCatalogosServiceSoap();
				
				CatalogSoapServices.service.setTimeout(ATTConstants.TIME_OUT);
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return CatalogSoapServices.service;
	}
}