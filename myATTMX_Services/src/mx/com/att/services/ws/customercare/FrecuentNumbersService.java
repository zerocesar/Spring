package mx.com.att.services.ws.customercare;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.DatosNumerosFrecuentesVO;

@WebService(name="FrecuentNumbersService",
targetNamespace="http://www.att.com.mx/att/services/ws/customercare/frecuentNumbersService")
public interface FrecuentNumbersService {

	String RETURN = "return";
	String FRECNUMBERSVO = "datosNumerosFrecuentesVO";
	String JSON = "datosNumerosFrecuentesJson";
	
	@WebMethod(operationName="getMaximumFrecuentNumbersMobile")
	@WebResult(name = RETURN)
	String getMaximumFrecuentNumbersMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getMaximumFrecuentNumbers")
	@WebResult(name = RETURN)
	ResponseVO getMaximumFrecuentNumbers(@WebParam(name = FRECNUMBERSVO) DatosNumerosFrecuentesVO requestVO);
	
	@WebMethod(operationName="getFrecuentNumbersMobile")
	@WebResult(name = RETURN)
	String getFrecuentNumbersMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getFrecuentNumbers")
	@WebResult(name = RETURN)
	ResponseVO getFrecuentNumbers(@WebParam(name = FRECNUMBERSVO) DatosNumerosFrecuentesVO requestVO);
	
	@WebMethod(operationName="getMethodOfPaymentMobile")
	@WebResult(name = RETURN)
	String getMethodOfPaymentMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getMethodOfPayment")
	@WebResult(name = RETURN)
	ResponseVO getMethodOfPayment(@WebParam(name = FRECNUMBERSVO) DatosNumerosFrecuentesVO requestVO);
	
	@WebMethod(operationName="getPriceChangeFNMobile")
	@WebResult(name = RETURN)
	String getPriceChangeFNMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getPriceChangeFN")
	@WebResult(name = RETURN)
	ResponseVO getPriceChangeFN(@WebParam(name = FRECNUMBERSVO) DatosNumerosFrecuentesVO requestVO);
	
	@WebMethod(operationName="validateContractMobile")
	@WebResult(name = RETURN)
	String validateContractMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="validateContract")
	@WebResult(name = RETURN)
	ResponseVO validateContract(@WebParam(name = FRECNUMBERSVO) DatosNumerosFrecuentesVO requestVO);
	
	@WebMethod(operationName="validateDnMobile")
	@WebResult(name = RETURN)
	String validateDnMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="validateDn")
	@WebResult(name = RETURN)
	ResponseVO validateDn(@WebParam(name = FRECNUMBERSVO) DatosNumerosFrecuentesVO requestVO);
}