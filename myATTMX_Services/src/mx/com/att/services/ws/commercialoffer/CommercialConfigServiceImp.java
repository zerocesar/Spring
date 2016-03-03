package mx.com.att.services.ws.commercialoffer;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.CommercialConfigBusiness;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.CommercialConfigurationVO;

@WebService(portName="commercialConfigServicePort", 
serviceName="CommercialConfigService", 
targetNamespace="http://www.att.com.mx/att/services/ws/commercialoffer/commercialConfigService", 
endpointInterface="mx.com.att.services.ws.commercialoffer.CommercialConfigService")
public class CommercialConfigServiceImp implements CommercialConfigService {

	private static final Logger LOGGER = Logger.getLogger(CommercialConfigServiceImp.class);
	
	@Override
	public String getServiceListMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getServiceListMobile de la clase CommercialConfigServiceImp");
		
		final CommercialConfigBusiness commercialConfigBusiness = new CommercialConfigBusiness();
		
		return commercialConfigBusiness.getServiceList(cadenaJson);
	}

	@Override
	public ResponseVO getServiceList(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getServiceList de la clase CommercialConfigServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getServiceListMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getPaymentTypeListMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPaymentTypeListMobile de la clase CommercialConfigServiceImp");
		
		final CommercialConfigBusiness commercialConfigBusiness = new CommercialConfigBusiness();
		
		return commercialConfigBusiness.getPaymentTypeList(cadenaJson);
	}

	@Override
	public ResponseVO getPaymentTypeList(CommercialConfigurationVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getPaymentTypeList de la clase CommercialConfigServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getPaymentTypeListMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getCommercialConfigurationMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getCommercialConfigurationMobile de la clase CommercialConfigServiceImp");
		
		final CommercialConfigBusiness commercialConfigBusiness = new CommercialConfigBusiness();
		
		return commercialConfigBusiness.getCommercialConfiguration(cadenaJson);
	}

	@Override
	public ResponseVO getCommercialConfiguration(CommercialConfigurationVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getCommercialConfiguration de la clase CommercialConfigServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getCommercialConfigurationMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getServicesByChannelMovil(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getServicesByChannelMovil de la clase CommercialConfigServiceImp");
		
		final CommercialConfigBusiness commercialConfigBusiness = new CommercialConfigBusiness();
		
		return commercialConfigBusiness.getServicesByChannel(cadenaJson);
	}

	@Override
	public ResponseVO getServicesByChannel(CommercialConfigurationVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getServicesByChannel de la clase CommercialConfigServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getServicesByChannelMovil(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}