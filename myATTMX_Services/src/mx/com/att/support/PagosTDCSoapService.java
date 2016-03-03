package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.pggpay.ops.service.impl.PagosServiceLocator;
import mx.com.nextel.pggpay.ops.service.impl.PagosServiceSoapBindingStub;

public final class PagosTDCSoapService {
	
	private static final Logger LOGGER = Logger.getLogger( PagosTDCSoapService.class );
	private static volatile PagosServiceSoapBindingStub servicio;
	
	private PagosTDCSoapService(){
		
	}
	
	public static PagosServiceSoapBindingStub consultaProxy(){
		if(PagosTDCSoapService.servicio == null) {
			final String url = ATTConstants.URL_WS_GPAY + "OnlinePaymentService/PagosService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final PagosServiceLocator locator = new PagosServiceLocator();
				locator.setPagosServiceImplPortEndpointAddress(url);
				PagosTDCSoapService.servicio = (PagosServiceSoapBindingStub)locator.getPagosServiceImplPort();
			} catch (ServiceException e) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", e);
			}
		}
		
		return PagosTDCSoapService.servicio;
	}
}