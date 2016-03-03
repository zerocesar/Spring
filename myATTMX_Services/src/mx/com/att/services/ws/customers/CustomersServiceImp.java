package mx.com.att.services.ws.customers;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.CustomersBusiness;
import mx.com.att.business.PocketsBusiness;
import mx.com.att.services.ws.commercialoffer.ShareServiceImp;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.OrdenesWPVO;
import mx.com.att.vo.orange.ServiceOrderWPVO;

@WebService(portName="CustomersServicePort", 
serviceName="CustomersService", 
targetNamespace="http://www.att.com.mx/att/services/ws/customers/customersService", 
endpointInterface="mx.com.att.services.ws.customers.CustomersService")
public class CustomersServiceImp implements CustomersService{

	private static final Logger LOGGER = Logger.getLogger(ShareServiceImp.class);
	
	@Override
	public String getBlockedDnMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getBlockedDnMobile de la clase CustomersServiceImp");
		
		final CustomersBusiness customerBusiness = new CustomersBusiness();
		
		return customerBusiness.getBlockedDn(cadenaJson);
	}

	@Override
	public ResponseVO getBlockedDn(PaymentRespVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getBlockedDn de la clase CustomersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getBlockedDnMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getAccountContractsBrothersDnMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getAccountContractsBrothersDnMobile de la clase CustomersServiceImp");
		
		final CustomersBusiness customerBusiness = new CustomersBusiness();
		
		return customerBusiness.getAccountContractsBrothersDn(cadenaJson);
	}

	@Override
	public ResponseVO getAccountContractsBrothersDn(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getAccountContractsBrothersDn de la clase CustomersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getAccountContractsBrothersDnMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getServiceBalanceMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getServiceBalanceMobile de la clase CustomersServiceImp");
		
		final CustomersBusiness customerBusiness = new CustomersBusiness();
		
		return customerBusiness.getServiceBalance(cadenaJson);
	}

	@Override
	public ResponseVO getServiceBalance(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getServiceBalance de la clase CustomersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getServiceBalanceMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getTicketInfoMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getTicketInfoMobile de la clase CustomersServiceImp");
		
		final CustomersBusiness customerBusiness = new CustomersBusiness();
		
		return customerBusiness.getTicketInfo(cadenaJson);
	}

	@Override
	public ResponseVO getTicketInfo(OrdenesWPVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getTicketInfo de la clase CustomersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getTicketInfoMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getPocketsMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPocketsMobile de la clase CustomersServiceImp");
		
		final PocketsBusiness pocketsBusiness = new PocketsBusiness();
		
		return pocketsBusiness.getPockets(cadenaJson);
	}

	@Override
	public ResponseVO getPockets(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getPockets de la clase CustomersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getPocketsMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getPocketsLimitMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPocketsLimitMobil de la clase CustomersServiceImp");
		
		final PocketsBusiness pocketsBusiness = new PocketsBusiness();
		
		return pocketsBusiness.consultaTopesMonederos(cadenaJson);
	}

	@Override
	public ResponseVO getPocketsLimit(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getPocketsLimit de la clase CustomersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getPocketsLimitMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getAccountBalanceMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getAccountBalanceMobil de la clase CustomersServiceImp");
		
		final CustomersBusiness customersBusiness = new CustomersBusiness();
		
		return customersBusiness.saldoFacturasCuenta(cadenaJson);
	}

	@Override
	public ResponseVO getAccountBalance(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getAccountBalance de la clase CustomersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getAccountBalanceMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getServiceOrderMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getServiceOrderMobile de la clase CustomersServiceImp");
		
		final CustomersBusiness customersBusiness = new CustomersBusiness();
		
		return customersBusiness.getServiceOrder(cadenaJson);
	}

	@Override
	public ResponseVO getServiceOrder(OrdenesWPVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getServiceOrder de la clase CustomersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getServiceOrderMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String setServiceOrderRegisterMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo setServiceOrderRegisterMobile de la clase CustomersServiceImp");
		
		final CustomersBusiness customersBusiness = new CustomersBusiness();
		
		return customersBusiness.setServiceOrderRegister(cadenaJson);
	}

	@Override
	public ResponseVO setServiceOrderRegister(ServiceOrderWPVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo setServiceOrderRegister de la clase CustomersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = setServiceOrderRegisterMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String updateServiceOrderStatusMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo updateServiceOrderStatusMobile de la clase CustomersServiceImp");
		
		final CustomersBusiness customersBusiness = new CustomersBusiness();
		
		return customersBusiness.updateServiceOrderStatus(cadenaJson);
	}

	@Override
	public ResponseVO updateServiceOrderStatus(ServiceOrderWPVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo updateServiceOrderStatus de la clase CustomersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = updateServiceOrderStatusMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}