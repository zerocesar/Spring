package mx.com.att.services.ws.customercare;

import javax.jws.WebService;

import mx.com.att.business.PaperlessBusiness;
import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

@WebService(portName="PaperlessServicePort",
serviceName="PaperlessService",
targetNamespace="http://www.att.com.mx/att/services/ws/customercare/paperlessService",
endpointInterface="mx.com.att.services.ws.customercare.PaperlessService")
public class PaperlessServiceImp implements PaperlessService {

	private static final Logger LOGGER = Logger.getLogger(PaperlessServiceImp.class);

	@Override
	public String addPaperlessMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo addPaperlessMobile de la clase PaperlessServiceImp");
		
		final PaperlessBusiness paperlessBusiness = new PaperlessBusiness();
		
		return paperlessBusiness.addPaperless(cadenaJson);
	}

	@Override
	public ResponseVO addPaperless(PaymentRespVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo addPaperless de la clase PaperlessServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = addPaperlessMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getPaperlessInfoMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPaperlessInfoMobile de la clase PaperlessServiceImp");
		
		final PaperlessBusiness paperlessBusiness = new PaperlessBusiness();
		
		return paperlessBusiness.getPaperlessInfo(cadenaJson);
	}

	@Override
	public ResponseVO getPaperlessInfo(PaymentRespVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getPaperlessInfo de la clase PaperlessServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getPaperlessInfoMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String getIsPaperlessMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getIsPaperlessMobile de la clase PaperlessServiceImp");
		
		final PaperlessBusiness paperlessBusiness = new PaperlessBusiness();
		
		return paperlessBusiness.getIsPaperless(cadenaJson);
	}

	@Override
	public ResponseVO getIsPaperless(PaymentRespVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getIsPaperless de la clase PaperlessServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getIsPaperlessMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

	@Override
	public String removePaperlessMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo removePaperlessMobile de la clase PaperlessServiceImp");
		
		final PaperlessBusiness paperlessBusiness = new PaperlessBusiness();
		
		return paperlessBusiness.removePaperless(cadenaJson);
	}

	@Override
	public ResponseVO removePaperless(PaymentRespVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo removePaperless de la clase PaperlessServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = removePaperlessMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}