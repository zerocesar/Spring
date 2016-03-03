package mx.com.att.services.ws.commercialoffer;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.TopUpBusiness;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.RechargeVO;
import mx.com.att.vo.orange.ValidaMontosVO;

@WebService(portName="TopUpServicesPort", 
serviceName="TopUpServices", 
targetNamespace="http://www.att.com.mx/att/services/ws/commercialoffer/topUpServices", 
endpointInterface="mx.com.att.services.ws.commercialoffer.TopUpServices")
public class TopUpServicesImp implements TopUpServices {

	private static final Logger LOGGER = Logger.getLogger(TopUpServicesImp.class);
	
	@Override
	public String getWebPortalAmountsMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getWebPortalAmountsMobile de la clase TopUpServicesImp");
		
		final TopUpBusiness topUpBusiness = new TopUpBusiness();
		
		return topUpBusiness.getWebPortalAmounts(cadenaJson);
	}

	@Override
	public ResponseVO getWebPortalAmounts(ValidaMontosVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getWebPortalAmounts de la clase TopUpServicesImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getWebPortalAmountsMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getRechargeAmountsMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getRechargeAmountsMobile de la clase TopUpServicesImp");
		
		final TopUpBusiness topUpBusiness = new TopUpBusiness();
		
		return topUpBusiness.getRechargeAmounts(cadenaJson);
	}

	@Override
	public ResponseVO getRechargeAmounts(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getRechargeAmounts de la clase TopUpServicesImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getRechargeAmountsMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getServiceCreditMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getServiceCreditMobile de la clase TopUpServicesImp");
		
		final TopUpBusiness topUpBusiness = new TopUpBusiness();
		
		return topUpBusiness.getServiceCredit(cadenaJson);
	}

	@Override
	public ResponseVO getServiceCredit(ValidaMontosVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getServiceCredit de la clase TopUpServicesImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getServiceCreditMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String validateDNTopUpMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateDNMobile de la clase TopUpServicesImp");
		
		final TopUpBusiness topUpBusiness = new TopUpBusiness();
		
		return topUpBusiness.validateDN(cadenaJson);
	}

	@Override
	public ResponseVO validateDNTopUp(RechargeVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo validateDN de la clase TopUpServicesImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = validateDNTopUpMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String validateDNTransferMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateDNTransferMobile de la clase TopUpServicesImp");
		
		final TopUpBusiness topUpBusiness = new TopUpBusiness();
		
		return topUpBusiness.validateDNTransfer(cadenaJson);
	}

	@Override
	public ResponseVO validateDNTransfer(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo validateDNTransfer de la clase TopUpServicesImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = validateDNTransferMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String validateBillByDNMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateBillByDNMobile de la clase TopUpServicesImp");
		
		final TopUpBusiness topUpBusiness = new TopUpBusiness();
		
		return topUpBusiness.validateBillByDN(cadenaJson);
	}

	@Override
	public ResponseVO validateBillByDN(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo validateBillByDN de la clase TopUpServicesImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = validateBillByDNMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}