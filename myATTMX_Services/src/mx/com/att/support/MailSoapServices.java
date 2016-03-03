package mx.com.att.support;

import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.www.mail.ws.mail.MailServicePortBindingStub;
import mx.com.nextel.www.mail.ws.mail.MailServiceServicesLocator;

import org.apache.log4j.Logger;

public final class MailSoapServices {

	private static final Logger LOGGER = Logger.getLogger( MailSoapServices.class );
	private static volatile MailServicePortBindingStub service;
	
	private MailSoapServices(){
		
	}
	
	public static MailServicePortBindingStub getMailService(){

		if(MailSoapServices.service == null) {
			final String url = ATTConstants.URL_WS_MAIL + "MailService/MailServiceServices?wsdl";
			LOGGER.info("ENDPOINT -- " + url);
			try {
				final MailServiceServicesLocator locator = new MailServiceServicesLocator();
				locator.setMailServicePortEndpointAddress(url);
				MailSoapServices.service = (MailServicePortBindingStub) locator.getMailServicePort();
			} catch (ServiceException serviceException) {
				LOGGER.error("Ocurrio un error al tratar de hacer la conexion con los servicios - ", serviceException);
			}
		}
		
		return MailSoapServices.service;
	}
}