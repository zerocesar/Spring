package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;

import org.apache.log4j.Logger;

import ws.ecommerce.nextel.com.mx.masterpin.MasterPINServicePortBindingStub;
import ws.ecommerce.nextel.com.mx.masterpin.MasterPINService_ServiceLocator;

public final class MasterPINSoapServices {

	private static final Logger LOGGER = Logger.getLogger( MasterPINSoapServices.class );
	private static volatile MasterPINServicePortBindingStub service;
	
	private MasterPINSoapServices(){
		
	}
	
	public static MasterPINServicePortBindingStub getMasterPINService(){

		if(MasterPINSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_ECOMMERCE + "EcommerceServices/MasterPINService?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final MasterPINService_ServiceLocator locator = new MasterPINService_ServiceLocator();
				locator.setMasterPINServicePortEndpointAddress(url);
				MasterPINSoapServices.service = (MasterPINServicePortBindingStub) locator.getMasterPINServicePort();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return MasterPINSoapServices.service;
	}
}