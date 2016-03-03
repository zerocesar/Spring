package mx.com.att.services.ws.commercialoffer;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.ShareBusiness;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;

@WebService(portName="ShareServicePort", 
serviceName="ShareService", 
targetNamespace="http://www.att.com.mx/att/services/ws/commercialoffer/shareService", 
endpointInterface="mx.com.att.services.ws.commercialoffer.ShareService")
public class ShareServiceImp implements ShareService {

	private static final Logger LOGGER = Logger.getLogger(ShareServiceImp.class);
	
	@Override
	public String getAllMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getAllMobil de la clase ShareServiceImp");
		
		final ShareBusiness shareBusiness = new ShareBusiness();
		
		return shareBusiness.getAllBusiness(cadenaJson);
	}

	@Override
	public ResponseVO getAll(CustomerVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getAll de la clase ShareServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getAllMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}