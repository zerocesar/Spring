package mx.com.att.services.ws.tools;

import javax.jws.WebService;

import mx.com.att.business.CommercialConfigBusiness;
import mx.com.att.business.ToolsBusiness;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.ClassificationDnVO;
import mx.com.att.vo.orange.ClassificationVO;
import mx.com.att.vo.orange.ParamCatalogoVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

@WebService(name="ToolsServicePort",
serviceName="ToolsService",
targetNamespace="http://www.att.com.mx/att/services/ws/tools/toolsService",
endpointInterface="mx.com.att.services.ws.tools.ToolsService")
public class ToolsServiceImp implements ToolsService {
	
	private static final Logger LOGGER = Logger.getLogger(ToolsServiceImp.class);
	
	@Override
	public String getParametersWPMobile(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getParametersWPMobile de la clase ToolsServiceImp");
		
		final ToolsBusiness toolsBusiness = new ToolsBusiness();
		return toolsBusiness.getParametersWP(cadenaJson);
	}
	
	@Override
	public ResponseVO getParametersWP(ParamCatalogoVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo getParametersWPMobile de la clase ToolsServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getParametersWPMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getParametersFVMMobile(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getParametersFVMMobile de la clase ToolsServiceImp");
		
		final ToolsBusiness toolsBusiness = new ToolsBusiness();
		return toolsBusiness.getParametersFVM(cadenaJson);
	}
	
	@Override
	public ResponseVO getParametersFVM(ParamCatalogoVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo getParametersFVM de la clase ToolsServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getParametersFVMMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getClassificationMobile(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getClassificationMobile de la clase ToolsServiceImp");
		
		final CommercialConfigBusiness commercialConfigBusiness = new CommercialConfigBusiness();
		return commercialConfigBusiness.getClassificationJson(cadenaJson);
	}
	
	@Override
	public ResponseVO getClassification(ClassificationVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo getClassification de la clase ToolsServiceImp");
		final String request = new Gson().toJson(requestVO);
		final String response = getClassificationMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getClassificationDnMobile(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getClassificationDnMobile de la clase ToolsServiceImp");
		
		final CommercialConfigBusiness commercialConfigBusiness = new CommercialConfigBusiness();
		return commercialConfigBusiness.getClassificationDnJson(cadenaJson);
	}
	
	@Override
	public ResponseVO getClassificationDn(ClassificationDnVO requestVO){
		LOGGER.info("Comienza la ejecucion del metodo getClassificationDn de la clase ToolsServiceImp");
		final String request = new Gson().toJson(requestVO);
		final String response = getClassificationDnMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}