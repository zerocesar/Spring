package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.www.ecommerce.ws.numerosFrecuentes.NumerosFrecuentesPortBindingStub;
import mx.com.nextel.www.ecommerce.ws.numerosFrecuentes.NumerosFrecuentesService_ServiceLocator;

import org.apache.log4j.Logger;

public final class NumerosFrecuentesSoapServices {

	private static final Logger LOGGER = Logger.getLogger( NumerosFrecuentesSoapServices.class );
	private static volatile NumerosFrecuentesPortBindingStub service;
	
	private NumerosFrecuentesSoapServices(){
		
	}
	
	public static NumerosFrecuentesPortBindingStub getNumerosFrecuentesService(){

		if(NumerosFrecuentesSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_ECOMMERCE + "EcommerceServices/NumerosFrecuentesService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final NumerosFrecuentesService_ServiceLocator locator = new NumerosFrecuentesService_ServiceLocator();
				locator.setNumerosFrecuentesPortEndpointAddress(url);
				NumerosFrecuentesSoapServices.service = (NumerosFrecuentesPortBindingStub) locator.getNumerosFrecuentesPort();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return NumerosFrecuentesSoapServices.service;
	}
}