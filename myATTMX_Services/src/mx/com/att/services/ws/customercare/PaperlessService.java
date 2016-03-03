package mx.com.att.services.ws.customercare;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.PaymentRespVO;
import mx.com.att.vo.ResponseVO;

@WebService(name="PaperlessService",
targetNamespace="http://www.att.com.mx/att/services/ws/customercare/paperlessService")
public interface PaperlessService {

	String RETURN = "return";
	String PAYMENTRESPVO = "paymentRespVO";
	String JSON = "paymentRespVOJson";
	
	@WebMethod(operationName="addPaperlessMobile")
	@WebResult(name = RETURN)
	String addPaperlessMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="addPaperless")
	@WebResult(name = RETURN)
	ResponseVO addPaperless(@WebParam(name = PAYMENTRESPVO) PaymentRespVO requestVO);
	
	@WebMethod(operationName="getPaperlessInfoMobile")
	@WebResult(name = RETURN)
	String getPaperlessInfoMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getPaperlessInfo")
	@WebResult(name = RETURN)
	ResponseVO getPaperlessInfo(@WebParam(name = PAYMENTRESPVO) PaymentRespVO requestVO);
	
	@WebMethod(operationName="getIsPaperlessMobile")
	@WebResult(name = RETURN)
	String getIsPaperlessMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getIsPaperless")
	@WebResult(name = RETURN)
	ResponseVO getIsPaperless(@WebParam(name = PAYMENTRESPVO) PaymentRespVO requestVO);
	
	@WebMethod(operationName="removePaperlessMobile")
	@WebResult(name = RETURN)
	String removePaperlessMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="removePaperless")
	@WebResult(name = RETURN)
	ResponseVO removePaperless(@WebParam(name = PAYMENTRESPVO) PaymentRespVO requestVO);
}