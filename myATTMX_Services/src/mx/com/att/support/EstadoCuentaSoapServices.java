package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;

import org.apache.log4j.Logger;

import ws.cuenta.nextel.com.mx.n0.EstadoCuentaPortBindingStub;
import ws.cuenta.nextel.com.mx.n0.EstadoCuentaService_ServiceLocator;

public final class EstadoCuentaSoapServices {

	private static final Logger LOGGER = Logger.getLogger( EstadoCuentaSoapServices.class );
	private static volatile EstadoCuentaPortBindingStub service;
	
	private EstadoCuentaSoapServices(){
		
	}
	
	public static EstadoCuentaPortBindingStub getEstadoCuentaService(){

		if(EstadoCuentaSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_ESTADOCUENTA + "EstadoCuentaServices/EstadoCuentaService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final EstadoCuentaService_ServiceLocator locator = new EstadoCuentaService_ServiceLocator();
				locator.setEstadoCuentaPortEndpointAddress(url);
				EstadoCuentaSoapServices.service = (EstadoCuentaPortBindingStub) locator.getEstadoCuentaPort();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return EstadoCuentaSoapServices.service;
	}
}