package mx.com.att.business;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import mx.com.att.support.ModuloPaquetesSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.GetDetalleVO;
import mx.com.att.vo.orange.ServicesPackVO;
import mx.com.nextel.www.ecommerce.ws.paquetes.ModuloPaquetesServicePortBindingStub;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class PackagesBusiness {
	private static final Logger LOGGER = Logger.getLogger(PackagesBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT(); 
	
	public String activateFixpack(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo activateFixpack de la clase PackagesBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			//Se registra la informacion para la activacion de los Fixpack.
			final ModuloPaquetesServicePortBindingStub ecommerceModuloPaquetesProxy = ModuloPaquetesSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceModuloPaquetesProxy.activateFixpackMovil(jsonDecrypted);
			final ResponseVO responseModuloVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseModuloVO == null || responseModuloVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PACKAGES_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseModuloVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseModuloVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(responseModuloVO.getCode());
				responseVO.setMessageCode(responseModuloVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getOrderDetail(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getOrderDetail de la clase PackagesBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			//Se registra la informacion para la activacion de los Fixpack.
			final ModuloPaquetesServicePortBindingStub ecommerceModuloPaquetesProxy = ModuloPaquetesSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceModuloPaquetesProxy.getDetalleOrdenMovil(jsonDecrypted);
			final ResponseVO responseModuloVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseModuloVO == null || responseModuloVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PACKAGES_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseModuloVO.getCode(), ATTConstants.CODIGO_EXITO)){
				JsonElement objectResponseJson = new JsonParser().parse( responseString ).getAsJsonObject().get("objectResponse");
				JsonArray respuestaArray = objectResponseJson.getAsJsonArray();
				
				List<GetDetalleVO> listaDetalleVO = new ArrayList<GetDetalleVO>();
				for(JsonElement object: respuestaArray){
					GetDetalleVO getDetalleVO = new Gson().fromJson(object, GetDetalleVO.class);
					listaDetalleVO.add(getDetalleVO);
				}
				
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(listaDetalleVO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(responseModuloVO.getCode());
				responseVO.setMessageCode(responseModuloVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getPacksDetail(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getPacksDetail de la clase PackagesBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			//Se registra la informacion para la activacion de los Fixpack.
			final ModuloPaquetesServicePortBindingStub ecommerceModuloPaquetesProxy = ModuloPaquetesSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceModuloPaquetesProxy.getPacksDetalleMovil(jsonDecrypted);
			final ResponseVO responseModuloVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseModuloVO == null || responseModuloVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PACKAGES_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseModuloVO.getCode(), ATTConstants.CODIGO_EXITO)){
				JsonElement objectResponseJson = new JsonParser().parse( responseString ).getAsJsonObject().get("objectResponse");
				JsonArray respuestaArray = objectResponseJson.getAsJsonArray();
				
				List<ServicesPackVO> listaServicesPackVO = new ArrayList<ServicesPackVO>();
				for(JsonElement object: respuestaArray){
					ServicesPackVO servicesPackVO = new Gson().fromJson(object, ServicesPackVO.class);
					listaServicesPackVO.add(servicesPackVO);
				}
				
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(listaServicesPackVO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(responseModuloVO.getCode());
				responseVO.setMessageCode(responseModuloVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getPrePlanPackages(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getPrePlanPackages de la clase PackagesBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			//Se registra la informacion para la activacion de los Fixpack.
			final ModuloPaquetesServicePortBindingStub ecommerceModuloPaquetesProxy = ModuloPaquetesSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceModuloPaquetesProxy.getPaquetesPrePlanMovil(jsonDecrypted);
			final ResponseVO responseModuloVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseModuloVO == null || responseModuloVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PACKAGES_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseModuloVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseModuloVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(responseModuloVO.getCode());
				responseVO.setMessageCode(responseModuloVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getTransactionStatus(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getTransactionStatus de la clase PackagesBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			//Se registra la informacion para la activacion de los Fixpack.
			final ModuloPaquetesServicePortBindingStub ecommerceModuloPaquetesProxy = ModuloPaquetesSoapServices.getNavigationLogSoapServices();
			final String responseString = ecommerceModuloPaquetesProxy.getTransactionStatusMovil(jsonDecrypted);
			final ResponseVO responseModuloVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseModuloVO == null || responseModuloVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_PACKAGES_LOG);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseModuloVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseModuloVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				responseVO.setCode(responseModuloVO.getCode());
				responseVO.setMessageCode(responseModuloVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
}