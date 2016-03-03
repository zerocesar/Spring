package mx.com.att.services.ws.tools;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.business.MailBusiness;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.MailVO;

@WebService(name="MailServicePort",
serviceName="MailService",
targetNamespace="http://www.att.com.mx/att/services/ws/tools/mailService",
endpointInterface="mx.com.att.services.ws.tools.MailService")
public class MailServiceImp implements MailService {

	private static final Logger LOGGER = Logger.getLogger(MailServiceImp.class);
	
	@Override
	public String sendEmailMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo sendEmailMobile de la clase MailServiceImp");
		
		final MailBusiness mailBusiness = new MailBusiness();
		
		return mailBusiness.sendEmail(cadenaJson);
	}

	@Override
	public ResponseVO sendEmail(MailVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo sendEmail de la clase MailServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = sendEmailMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}

}