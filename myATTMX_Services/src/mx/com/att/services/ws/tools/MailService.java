package mx.com.att.services.ws.tools;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.MailVO;

@WebService(name="MailService",
targetNamespace="http://www.att.com.mx/att/services/ws/tools/mailService")
public interface MailService {

	String RETURN = "return";
	
	@WebMethod(operationName="sendEmailMobile")
	@WebResult(name = RETURN)
	String sendEmailMobile(@WebParam(name = "mailVOJson") String cadenaJson);

	@WebMethod(operationName="sendEmail")
	@WebResult(name = RETURN)
	ResponseVO sendEmail(@WebParam(name = "mailVO") MailVO requestVO);
}