package mx.com.att.services.ws.customercare;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.FrecuentNumbersBusiness;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.DatosNumerosFrecuentesVO;

@WebService(portName="FrecuentNumbersServicePort",
serviceName="FrecuentNumbersService",
targetNamespace="http://www.att.com.mx/att/services/ws/customercare/frecuentNumbersService",
endpointInterface="mx.com.att.services.ws.customercare.FrecuentNumbersService")
public class FrecuentNumbersServiceImp implements FrecuentNumbersService {
	
	private static final Logger LOGGER = Logger.getLogger(FrecuentNumbersServiceImp.class);

	@Override
	public String getMaximumFrecuentNumbersMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getMaximumFrecuentNumbersMobile de la clase FrecuentNumbersServiceImp");
		
		final FrecuentNumbersBusiness frecuentNumbersBusiness = new FrecuentNumbersBusiness();
		
		return frecuentNumbersBusiness.getMaximumFrecuentsNumbersBsn(cadenaJson);
	}

	@Override
	public ResponseVO getMaximumFrecuentNumbers(DatosNumerosFrecuentesVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getMaximumFrecuentNumbers de la clase FrecuentNumbersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getMaximumFrecuentNumbersMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getFrecuentNumbersMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getFrecuentNumbersMobile de la clase FrecuentNumbersServiceImp");
		
		final FrecuentNumbersBusiness frecuentNumbersBusiness = new FrecuentNumbersBusiness();
		
		return frecuentNumbersBusiness.getFrecuentNumbers(cadenaJson);
	}

	@Override
	public ResponseVO getFrecuentNumbers(DatosNumerosFrecuentesVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getFrecuentNumbers de la clase FrecuentNumbersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getFrecuentNumbersMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getMethodOfPaymentMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getMethodOfPaymentMobile de la clase FrecuentNumbersServiceImp");
		
		final FrecuentNumbersBusiness frecuentNumbersBusiness = new FrecuentNumbersBusiness();
		
		return frecuentNumbersBusiness.getMethodOfPayment(cadenaJson);
	}

	@Override
	public ResponseVO getMethodOfPayment(DatosNumerosFrecuentesVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getMethodOfPayment de la clase FrecuentNumbersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getMethodOfPaymentMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getPriceChangeFNMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPriceChangeFNMobile de la clase FrecuentNumbersServiceImp");
		
		final FrecuentNumbersBusiness frecuentNumbersBusiness = new FrecuentNumbersBusiness();
		
		return frecuentNumbersBusiness.getPriceChangeFN(cadenaJson);
	}

	@Override
	public ResponseVO getPriceChangeFN(DatosNumerosFrecuentesVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getPriceChangeFN de la clase FrecuentNumbersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getPriceChangeFNMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String validateContractMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateContractMobile de la clase FrecuentNumbersServiceImp");
		
		final FrecuentNumbersBusiness frecuentNumbersBusiness = new FrecuentNumbersBusiness();
		
		return frecuentNumbersBusiness.validateContract(cadenaJson);
	}

	@Override
	public ResponseVO validateContract(DatosNumerosFrecuentesVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo validateContract de la clase FrecuentNumbersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = validateContractMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String validateDnMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateDnMobile de la clase FrecuentNumbersServiceImp");
		
		final FrecuentNumbersBusiness frecuentNumbersBusiness = new FrecuentNumbersBusiness();
		
		return frecuentNumbersBusiness.validateDn(cadenaJson);
	}

	@Override
	public ResponseVO validateDn(DatosNumerosFrecuentesVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo validateDn de la clase FrecuentNumbersServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = validateDnMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}