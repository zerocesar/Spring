package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.www.ecommerce.ws.recharge.EcommerceServiceBindingStub;
import mx.com.nextel.www.ecommerce.ws.recharge.RechargeServiceLocator;

import org.apache.log4j.Logger;

public class RechargeSoapServices {

	private static final Logger LOGGER = Logger.getLogger( RechargeSoapServices.class );
	private static volatile EcommerceServiceBindingStub service;
	
	private RechargeSoapServices(){
		
	}
	
	public static EcommerceServiceBindingStub getRechargeService(){

		if(RechargeSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_ECOMMERCE + "EcommerceServices/RechargeService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final RechargeServiceLocator locator = new RechargeServiceLocator();
				locator.setEcommerceServiceEndpointAddress(url);
				RechargeSoapServices.service = (EcommerceServiceBindingStub) locator.getEcommerceService();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return RechargeSoapServices.service;
	}
}