package mx.com.att.services.ws.tools;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.ClassificationDnVO;
import mx.com.att.vo.orange.ClassificationVO;
import mx.com.att.vo.orange.ParamCatalogoVO;

@WebService(name="ToolsService",
targetNamespace="http://www.att.com.mx/att/services/ws/tools/toolsService")
public interface ToolsService {
	
	String RETURN = "return";
	String CLASSIFICATIONVO = "classificationVO";
	String CLASSIFICATIONDNVO = "classificationDnVO";
	String PARAMCATALOGOVO = "paramCatalogoVO";
	String STRINGPARAM = "stringParam";
	String PARAMCATALOGVO = "paramCatalogoVO";
	String JSON = "cadenaJson";
	
	@WebMethod(operationName="getParametersWPMobile")
	@WebResult(name = RETURN)
	String getParametersWPMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getParametersWP")
	@WebResult(name = RETURN)
	ResponseVO getParametersWP(@WebParam(name = PARAMCATALOGVO) ParamCatalogoVO requestVO);
	
	@WebMethod(operationName="getParametersFVMMobile")
	@WebResult(name = RETURN)
	String getParametersFVMMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getParametersFVM")
	@WebResult(name = RETURN)
	ResponseVO getParametersFVM(@WebParam(name = PARAMCATALOGVO) ParamCatalogoVO requestVO);
	
	@WebMethod(operationName="getClassificationMobile")
	@WebResult(name = RETURN)
	String getClassificationMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getClassification")
	@WebResult(name = RETURN)
	ResponseVO getClassification(@WebParam(name = CLASSIFICATIONVO) ClassificationVO classificationVO);
	
	@WebMethod(operationName="getClassificationDnMobile")
	@WebResult(name = RETURN)
	String getClassificationDnMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getClassificationDn")
	@WebResult(name = RETURN)
	ResponseVO getClassificationDn(@WebParam(name = CLASSIFICATIONDNVO) ClassificationDnVO classificationDnrequestVO);
}
