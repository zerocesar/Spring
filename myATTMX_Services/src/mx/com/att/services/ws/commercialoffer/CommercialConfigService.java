package mx.com.att.services.ws.commercialoffer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.CommercialConfigurationVO;

@WebService(name = "CommercialConfigService", 
targetNamespace = "http://www.att.com.mx/att/services/ws/commercialoffer/commercialConfigService")
public interface CommercialConfigService {

	String RETURN = "return";
	String CUSTOMERVO = "customerVO";
	String JSON = "customerJson";
	String COMCONFVO = "commercialConfigurationVOJSON";
	String COMCONFVOJSON = "commercialConfigurationVO";
	
	@WebMethod(operationName="getServiceListMobile")
	@WebResult(name = RETURN)
	String getServiceListMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getServiceList")
	@WebResult(name = RETURN)
	ResponseVO getServiceList(@WebParam(name = CUSTOMERVO) CustomerVO requestVO);
	
	@WebMethod(operationName="getPaymentTypeListMobile")
	@WebResult(name = RETURN)
	String getPaymentTypeListMobile(@WebParam(name = COMCONFVOJSON) String cadenaJson);	
	
	@WebMethod(operationName="getPaymentTypeList")
	@WebResult(name = RETURN)
	ResponseVO getPaymentTypeList(@WebParam(name= COMCONFVO) CommercialConfigurationVO requestVO);
	
	@WebMethod(operationName="getCommercialConfigurationMobile")
	@WebResult(name = RETURN)
	String getCommercialConfigurationMobile(@WebParam(name= COMCONFVOJSON) String cadenaJson);
	  
	@WebMethod(operationName="getCommercialConfiguration")
	@WebResult(name = RETURN)
	ResponseVO getCommercialConfiguration(@WebParam(name= COMCONFVO) CommercialConfigurationVO requestVO);

	@WebMethod(operationName = "getServicesByChannelMovil")
	@WebResult(name = RETURN)
	String getServicesByChannelMovil (@WebParam(name= COMCONFVOJSON) String cadenaJson);
	
	@WebMethod(operationName = "getServicesByChannel")
	@WebResult(name = RETURN)
	ResponseVO getServicesByChannel (@WebParam(name= COMCONFVO) CommercialConfigurationVO requestVO);
}