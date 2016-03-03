package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;

import org.apache.log4j.Logger;
import org.skink.necws.webservice.ApplicationPortBindingStub;
import org.skink.necws.webservice.ApplicationServiceLocator;

public final class ShareNextelSoapServices {

	private static final Logger LOGGER = Logger.getLogger( ShareNextelSoapServices.class );
	private static volatile ApplicationPortBindingStub service;
	
	private ShareNextelSoapServices(){
		
	}
	
	public static ApplicationPortBindingStub getComparteNextelService(){
		if(ShareNextelSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_RATE_SHARING + "NECWS/application?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final ApplicationServiceLocator locator = new ApplicationServiceLocator();				
				locator.setApplicationPortEndpointAddress(url);
				ShareNextelSoapServices.service = (ApplicationPortBindingStub) locator.getApplicationPort();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return ShareNextelSoapServices.service;
	}
}