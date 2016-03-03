package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.www.ecommerce.ws.paquetes.ModuloPaquetesServicePortBindingStub;
import mx.com.nextel.www.ecommerce.ws.paquetes.ModuloPaquetesService_ServiceLocator;

import org.apache.log4j.Logger;

public final class ModuloPaquetesSoapServices {
	
	private static final Logger LOGGER = Logger.getLogger(ModuloPaquetesSoapServices.class);
	private static volatile ModuloPaquetesServicePortBindingStub service;
	
	private ModuloPaquetesSoapServices(){
		
	}
	
	/**
	 * Este metodo instancia el proxy  de EcommerceServices interface NavigationLogService
	 * @author Edgar Gutierrez - MindBits Desarrollo (15/OCT/2015)
	 * @return NavigationLogServiceProxy que es proxy a la
	 *  conexion del servicio EcommerceServices
	 */
	public static ModuloPaquetesServicePortBindingStub getNavigationLogSoapServices() {
		if(ModuloPaquetesSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_ECOMMERCE + "EcommerceServices/ModuloPaquetesService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			final ModuloPaquetesService_ServiceLocator locator = new ModuloPaquetesService_ServiceLocator();
			locator.setModuloPaquetesServicePortEndpointAddress(url);
			try {
				ModuloPaquetesSoapServices.service = (ModuloPaquetesServicePortBindingStub) locator.getModuloPaquetesServicePort();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return ModuloPaquetesSoapServices.service;
	}
}