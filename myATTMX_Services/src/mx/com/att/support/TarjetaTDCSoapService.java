package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.pggpay.ops.service.impl.TarjetaServiceLocator;
import mx.com.nextel.pggpay.ops.service.impl.TarjetaServiceSoapBindingStub;

public final class TarjetaTDCSoapService {
	
	private static final Logger LOGGER = Logger.getLogger( TarjetaTDCSoapService.class );
	private static volatile TarjetaServiceSoapBindingStub servicio;
	
	private TarjetaTDCSoapService(){
		
	}
	
	public static TarjetaServiceSoapBindingStub consultaProxy(){
		if(TarjetaTDCSoapService.servicio == null) {
			final String url = ATTConstants.URL_WS_GPAY + "OnlinePaymentService/TarjetaService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final TarjetaServiceLocator locator = new TarjetaServiceLocator();
				locator.setTarjetaServiceImplPortEndpointAddress(url);
				TarjetaTDCSoapService.servicio = (TarjetaServiceSoapBindingStub)locator.getTarjetaServiceImplPort();
			} catch (ServiceException e) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", e);
			}
		}
		
		return TarjetaTDCSoapService.servicio;
	}
}