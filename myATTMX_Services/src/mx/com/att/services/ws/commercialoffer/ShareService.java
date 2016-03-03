package mx.com.att.services.ws.commercialoffer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;

@WebService(name = "ShareService", 
targetNamespace = "http://www.att.com.mx/att/services/ws/commercialoffer/shareService")
public interface ShareService {

	String RETURN = "return";
	String CUSTOMERVO = "customerVO";
	String JSON = "customerJson";
	
	@WebMethod(operationName="getAllMobile")
	@WebResult(name = RETURN)
	String getAllMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getAll")
	@WebResult(name = RETURN)
	ResponseVO getAll(@WebParam(name = CUSTOMERVO) CustomerVO requestVO);
}