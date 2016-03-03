package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;

import org.apache.log4j.Logger;

import ws.ecommerce.nextel.com.mx.WPServicesPortBindingStub;
import ws.ecommerce.nextel.com.mx.WPServicesServiceLocator;

public class WebPortalSoapServices {

	private static final Logger LOGGER = Logger.getLogger( WebPortalSoapServices.class );
	private static volatile WPServicesPortBindingStub service;
	
	private WebPortalSoapServices(){
		
	}
	
	public static WPServicesPortBindingStub getWebPortalService(){

		if(WebPortalSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_ECOMMERCE + "EcommerceServices/WPServicesService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final WPServicesServiceLocator locator = new WPServicesServiceLocator();
				locator.setWPServicesPortEndpointAddress(url);
				WebPortalSoapServices.service = (WPServicesPortBindingStub) locator.getWPServicesPort();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return WebPortalSoapServices.service;
	}
}