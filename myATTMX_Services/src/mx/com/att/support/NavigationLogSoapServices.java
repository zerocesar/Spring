package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.www.ecommerce.ws.navigationLog.EcommerceServiceBindingStub;
import mx.com.nextel.www.ecommerce.ws.navigationLog.NavigationLogService_ServiceLocator;

import org.apache.log4j.Logger;

public final class NavigationLogSoapServices {
	
	private static final Logger LOGGER = Logger.getLogger(NavigationLogSoapServices.class);
	private static volatile EcommerceServiceBindingStub service;
	
	private NavigationLogSoapServices(){
		
	}
	
	/**
	 * Este metodo instancia el proxy  de EcommerceServices interface NavigationLogService
	 * @author Edgar Gutierrez - MindBits Desarrollo (07/OCT/2015)
	 * @return NavigationLogServiceProxy que es proxy a la
	 *  conexion del servicio EcommerceServices
	 */
	public static EcommerceServiceBindingStub getNavigationLogSoapServices() {
		if(NavigationLogSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_ECOMMERCE + "EcommerceServices/NavigationLogService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			final NavigationLogService_ServiceLocator locator = new NavigationLogService_ServiceLocator();
			locator.setEcommerceServiceEndpointAddress(url);
			try {
				NavigationLogSoapServices.service = (EcommerceServiceBindingStub) locator.getEcommerceService();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return NavigationLogSoapServices.service;
	}
}