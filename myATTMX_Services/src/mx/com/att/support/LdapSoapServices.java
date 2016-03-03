package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;

import org.apache.log4j.Logger;

import aut.soa.nextel.mx.com.ws.LdapServiceBindingStub;
import aut.soa.nextel.mx.com.ws.LdapService_ServiceLocator;

public final class LdapSoapServices {
	
	private static final Logger LOGGER = Logger.getLogger( LdapSoapServices.class );
	private static volatile LdapServiceBindingStub service;
	
	private LdapSoapServices(){
		
	}
	
	public static LdapServiceBindingStub consultaProxy(){
		if(LdapSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_ECOMMERCE + "LdapWS/LdapService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final LdapService_ServiceLocator locator = new LdapService_ServiceLocator();				
				locator.setLdapServiceEndpointAddress(url);
				LdapSoapServices.service = (LdapServiceBindingStub) locator.getLdapService();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return LdapSoapServices.service;
	}
}