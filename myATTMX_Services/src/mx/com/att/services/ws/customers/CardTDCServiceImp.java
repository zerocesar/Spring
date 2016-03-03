package mx.com.att.services.ws.customers;

import javax.jws.WebService;

import mx.com.att.business.gpay.CardTDCBusiness;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.TarjetaTDCVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

@WebService(portName="CardTDCServicePort", 
serviceName="CardTDCService", 
targetNamespace="http://www.att.com.mx/att/services/ws/customers/cardTDCService", 
endpointInterface="mx.com.att.services.ws.customers.CardTDCService")
public class CardTDCServiceImp implements CardTDCService {

	private static final Logger LOGGER = Logger.getLogger(CardTDCServiceImp.class);
	
	@Override
	public String registerTDCMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo registerTDCMobile de la clase CardTDCServiceImp");
		
		final CardTDCBusiness cardTDCBusiness = new CardTDCBusiness();
		
		return cardTDCBusiness.addCustomerTDC(cadenaJson);
	}
	
	@Override
	public ResponseVO registerTDC(final TarjetaTDCVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo registerTDC de la clase CardTDCServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = registerTDCMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String defaultTDCMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo defaultTDCMobile de la clase CardTDCServiceImp");
		
		final CardTDCBusiness cardTDCBusiness = new CardTDCBusiness();
		
		return cardTDCBusiness.defaultCustomerTDC(cadenaJson);
	}
	
	@Override
	public ResponseVO defaultTDC(final TarjetaTDCVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo defaultTDC de la clase CardTDCServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = defaultTDCMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getCustomerTDCMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getCustomerTDCMobile de la clase CardTDCServiceImp");
		
		final CardTDCBusiness cardTDCBusiness = new CardTDCBusiness();
		
		return cardTDCBusiness.getCustomerTDC(cadenaJson);
	}
	
	@Override
	public ResponseVO getCustomerTDC(final TarjetaTDCVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getCustomerTDC de la clase CardTDCServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getCustomerTDCMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String deactivateTDCMobile(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo deactivateTDCMobile de la clase CardTDCServiceImp");
		
		final CardTDCBusiness cardTDCBusiness = new CardTDCBusiness();
		
		return cardTDCBusiness.deleteCustomerTDC(cadenaJson);
	}
	
	@Override
	public ResponseVO deactivateTDC(final TarjetaTDCVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo deactivateTDC de la clase CardTDCServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = deactivateTDCMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}