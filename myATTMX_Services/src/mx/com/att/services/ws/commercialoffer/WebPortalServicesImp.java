package mx.com.att.services.ws.commercialoffer;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.WebPortalBusiness;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.HistoricoVO;
import mx.com.nextel.www.ws.vo.ConsultaCompraServiciosVO;

@WebService(portName="WebPortalServicesPort", 
serviceName="WebPortalServices", 
targetNamespace="http://www.att.com.mx/att/services/ws/commercialoffer/webPortalServices", 
endpointInterface="mx.com.att.services.ws.commercialoffer.WebPortalServices")
public class WebPortalServicesImp implements WebPortalServices {

	private static final Logger LOGGER = Logger.getLogger(WebPortalServicesImp.class);
	
	@Override
	public String getActiveServicesALUMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getActiveServicesALUMobile de la clase WebPortalServicesImp");
		
		final WebPortalBusiness webPortalBusiness = new WebPortalBusiness();
		
		return webPortalBusiness.getActiveServicesALU(cadenaJson);
	}

	@Override
	public ResponseVO getActiveServicesALU(ConsultaCompraServiciosVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getActiveServicesALU de la clase WebPortalServicesImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getActiveServicesALUMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getTransactionHistoryWPMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getTransactionHistoryWPMobile de la clase WebPortalServicesImp");
		
		final WebPortalBusiness webPortalBusiness = new WebPortalBusiness();
		
		return webPortalBusiness.getTransactionHistoryWP(cadenaJson);
	}

	@Override
	public ResponseVO getTransactionHistoryWP(HistoricoVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getTransactionHistoryWP de la clase WebPortalServicesImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getTransactionHistoryWPMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getTransactionHistoryUnifiedMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getTransactionHistoryUnifiedMobile de la clase WebPortalServicesImp");
		
		final WebPortalBusiness webPortalBusiness = new WebPortalBusiness();
		
		return webPortalBusiness.getTransactionHistoryUnified(cadenaJson);
	}

	@Override
	public ResponseVO getTransactionHistoryUnified(HistoricoVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getTransactionHistoryUnified de la clase WebPortalServicesImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getTransactionHistoryUnifiedMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}