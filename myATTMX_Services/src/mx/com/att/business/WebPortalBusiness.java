package mx.com.att.business;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import mx.com.att.support.ClientesOESoapServices;
import mx.com.att.support.WebPortalSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.DetalleHistoricoRCSVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.ServiceOrderVO;
import mx.com.att.vo.orange.ServicioActivoVO;
import mx.com.nextel.ecommerce.ws.exception.EcommerceWSException;
import mx.com.nextel.www.ecommerce.ws.cliente.ClientesOESoapBindingStub;
import ws.ecommerce.nextel.com.mx.HistoricoVO;
import ws.ecommerce.nextel.com.mx.Servicio;
import ws.ecommerce.nextel.com.mx.WPServicesPortBindingStub;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class WebPortalBusiness {

	private static final Logger LOGGER = Logger.getLogger(WebPortalBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	
	public String getActiveServicesALU(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getActiveServicesALU de la clase WebPortalBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final WPServicesPortBindingStub webPortalProxy = WebPortalSoapServices.getWebPortalService();
			final String response = webPortalProxy.serviciosActivosMovil(jsonDecrypted);
			
			VALIDATOR.validateEmptyString(response, "Servicios Activos");
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(new Gson().fromJson(response, ServicioActivoVO.class));
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_WEB_PORTAL);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getContractsServicesBSCS(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getContractsServicesBSCS de la clase WebPortalBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final CustomerVO customerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class);
		
		try {
			VALIDATOR.validateEmptyString(customerVO.getUser(), "User/DN");
			
			final WPServicesPortBindingStub webPortalProxy = WebPortalSoapServices.getWebPortalService();
			final Servicio[] responseServicioVO = webPortalProxy.consultaServiciosContratos(customerVO.getUser());
			
			if (responseServicioVO == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_WEB_PORTAL);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseServicioVO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_WEB_PORTAL);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getTransactionHistoryWP(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getTransactionHistoryWP de la clase WebPortalBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final WPServicesPortBindingStub webPortalProxy = WebPortalSoapServices.getWebPortalService();
			final String responseHistorico = webPortalProxy.getHistoricoTransaccionesWPMovil(jsonDecrypted);
			final ResponseVO responseHistoricoVO = new Gson().fromJson(responseHistorico, ResponseVO.class);
			
			if (responseHistoricoVO == null || responseHistoricoVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_WEB_PORTAL);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseHistoricoVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(new Gson().fromJson(new Gson().toJson(responseHistoricoVO.getObjectResponse()), HistoricoVO.class));
				LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_WEB_PORTAL);
				responseVO.setMessageCode(responseHistoricoVO.getMessageCode());
				LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getTransactionHistoryUnified(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getTransactionHistoryUnified de la clase WebPortalBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final WPServicesPortBindingStub webPortalProxy = WebPortalSoapServices.getWebPortalService();
			final String responseHistorico = webPortalProxy.getHistoricoTransaccionesWPMovil(jsonDecrypted);
			final ResponseVO responseHistoricoVO = new Gson().fromJson(responseHistorico, ResponseVO.class);
			
			if (responseHistoricoVO == null || responseHistoricoVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_WEB_PORTAL);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (VALIDATOR.validateGetCode(responseHistoricoVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				final DetalleHistoricoRCSVO[] listDetalleHistoricoRCSVO = getListDetalleHistoricoRCS(responseHistoricoVO.getObjectResponse());
				responseVO.setObjectResponse(listDetalleHistoricoRCSVO);
				LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_WEB_PORTAL);
				responseVO.setMessageCode(responseHistoricoVO.getMessageCode());
				LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (EcommerceWSException ecommerceWSException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(ecommerceWSException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	private DetalleHistoricoRCSVO[] getListDetalleHistoricoRCS (Object objectResponse){
		DetalleHistoricoRCSVO[] listDetalleHistoricoRCS = new DetalleHistoricoRCSVO[1];
		final HistoricoVO historicoResponseVO = new Gson().fromJson(new Gson().toJson(objectResponse), HistoricoVO.class);
		
		if(historicoResponseVO == null){
			LOGGER.info("listDetalleHistoricoRCS "+ listDetalleHistoricoRCS.length+" elemento(s).");
		} else{
			final ClientesOESoapBindingStub clientesAdicionProxy = ClientesOESoapServices.getClientesOEService();
			final ws.ecommerce.nextel.com.mx.DetalleRecargaVO[] arrDetalleRecargaVO = historicoResponseVO.getHistorialRecargas();
			final ws.ecommerce.nextel.com.mx.DetalleCompraServicioVO[] arrDetalleCompraServicioVO = historicoResponseVO.getHistorialServicios();
			final ws.ecommerce.nextel.com.mx.ServiceOrderVO[] arrServiceOrderVO = historicoResponseVO.getHistoricoTransacciones();
			listDetalleHistoricoRCS = new DetalleHistoricoRCSVO[arrDetalleRecargaVO.length+arrDetalleCompraServicioVO.length+arrServiceOrderVO.length];
			final int sizeDetalleRecargaVO = arrDetalleRecargaVO.length;
			int j=0;
			
			for (int i=0; i<sizeDetalleRecargaVO; i++){
				final DetalleHistoricoRCSVO detalleHistoricoRCSVO = new DetalleHistoricoRCSVO();
				
				try {
					final String responseString = clientesAdicionProxy.getServiceOrderMovil("{\"serviceRef\":\""+arrDetalleRecargaVO[i].getIdLlavecliente()+"\"}");
					final ResponseVO serviceOrderResponseVO = new Gson().fromJson(responseString, ResponseVO.class);
					
					if (serviceOrderResponseVO == null){
						LOGGER.info("No se encontro informacion de la transaccion.");
						detalleHistoricoRCSVO.setMonto(arrDetalleRecargaVO[i].getMonto());
					} else if (VALIDATOR.validateGetCode(serviceOrderResponseVO.getCode(), ATTConstants.COD_EXITO)){
						JsonElement objectResponseJson = new JsonParser().parse( responseString ).getAsJsonObject().get("objectResponse");
						JsonArray respuestaArray = objectResponseJson.getAsJsonArray();
						
						for(JsonElement object: respuestaArray){
							ServiceOrderVO serviceOrderVO = new Gson().fromJson(object, ServiceOrderVO.class);
							detalleHistoricoRCSVO.setMonto(Double.toString(serviceOrderVO.getAmount()));
							break;
						}
					} else{
						LOGGER.info("No se encontro informacion de la transaccion.");
						detalleHistoricoRCSVO.setMonto(arrDetalleRecargaVO[i].getMonto());
					}
					
					detalleHistoricoRCSVO.setFecha(arrDetalleRecargaVO[i].getFechaTransaccion());
					detalleHistoricoRCSVO.setOrderId(arrDetalleRecargaVO[i].getFolio());
					detalleHistoricoRCSVO.setTransaccion("Recargas");
					listDetalleHistoricoRCS[j++]=detalleHistoricoRCSVO;
				} catch (Exception e) {
					detalleHistoricoRCSVO.setFecha(arrDetalleRecargaVO[i].getFechaTransaccion());
					detalleHistoricoRCSVO.setMonto(arrDetalleRecargaVO[i].getMonto());
					detalleHistoricoRCSVO.setOrderId(arrDetalleRecargaVO[i].getFolio());
					detalleHistoricoRCSVO.setTransaccion("Recargas");
					listDetalleHistoricoRCS[j++]=detalleHistoricoRCSVO;
				}
			}
			
			final int sizeDetalleCompraServicioVO = arrDetalleCompraServicioVO.length;
			for (int i=0; i<sizeDetalleCompraServicioVO; i++){
				final DetalleHistoricoRCSVO detalleHistoricoRCSVO = new DetalleHistoricoRCSVO();
				
				try {
					final String responseString = clientesAdicionProxy.getServiceOrderMovil("{\"serviceRef\":\""+arrDetalleCompraServicioVO[i].getIdLlaveCliente()+"\"}");
					final ResponseVO serviceOrderResponseVO = new Gson().fromJson(responseString, ResponseVO.class);
					
					if (serviceOrderResponseVO == null){
						LOGGER.info("No se encontro informacion de la transaccion.");
						detalleHistoricoRCSVO.setMonto(arrDetalleCompraServicioVO[i].getMonto());
					} else if (VALIDATOR.validateGetCode(serviceOrderResponseVO.getCode(), ATTConstants.COD_EXITO)){
						JsonElement objectResponseJson = new JsonParser().parse( responseString ).getAsJsonObject().get("objectResponse");
						JsonArray respuestaArray = objectResponseJson.getAsJsonArray();
						
						for(JsonElement object: respuestaArray){
							ServiceOrderVO serviceOrderVO = new Gson().fromJson(object, ServiceOrderVO.class);
							detalleHistoricoRCSVO.setMonto(Double.toString(serviceOrderVO.getAmount()));
							break;
						}
					} else{
						LOGGER.info("No se encontro informacion de la transaccion.");
						detalleHistoricoRCSVO.setMonto(arrDetalleCompraServicioVO[i].getMonto());
					}
					
					detalleHistoricoRCSVO.setFecha(arrDetalleCompraServicioVO[i].getFechaTransaccion());
					detalleHistoricoRCSVO.setOrderId(arrDetalleCompraServicioVO[i].getFolio());
					detalleHistoricoRCSVO.setTransaccion("Paquetes");
					listDetalleHistoricoRCS[j++]=detalleHistoricoRCSVO;
				} catch (Exception e) {
					detalleHistoricoRCSVO.setFecha(arrDetalleCompraServicioVO[i].getFechaTransaccion());
					detalleHistoricoRCSVO.setMonto(arrDetalleCompraServicioVO[i].getMonto());
					detalleHistoricoRCSVO.setOrderId(arrDetalleCompraServicioVO[i].getFolio());
					detalleHistoricoRCSVO.setTransaccion("Paquetes");
					listDetalleHistoricoRCS[j++]=detalleHistoricoRCSVO;
				}
			}
			
			final int sizeServiceOrderVO = arrServiceOrderVO.length;
			for (int i=0; i<sizeServiceOrderVO; i++){
				DetalleHistoricoRCSVO detalleHistoricoRCSVO = new DetalleHistoricoRCSVO();
				final int year = Integer.parseInt(arrServiceOrderVO[i].getFechaProcesado().substring(0, 4));
				final int month =  Integer.parseInt(arrServiceOrderVO[i].getFechaProcesado().substring(5, 7));
				final int day =  Integer.parseInt(arrServiceOrderVO[i].getFechaProcesado().substring(8, 10));
				final int hour =  Integer.parseInt(arrServiceOrderVO[i].getFechaProcesado().substring(11, 13));
				final int min =  Integer.parseInt(arrServiceOrderVO[i].getFechaProcesado().substring(14, 16));
				final int sec =  Integer.parseInt(arrServiceOrderVO[i].getFechaProcesado().substring(17, 19));
				detalleHistoricoRCSVO.setFecha(new GregorianCalendar(year, month, day, hour, min, sec));
				detalleHistoricoRCSVO.setMonto(""+arrServiceOrderVO[i].getAmount());
				detalleHistoricoRCSVO.setOrderId(arrServiceOrderVO[i].getOrderId());
				detalleHistoricoRCSVO.setTransaccion(arrServiceOrderVO[i].getServiceRef());
				listDetalleHistoricoRCS[j++]=detalleHistoricoRCSVO;
			}
			Arrays.sort(listDetalleHistoricoRCS, DetalleHistoricoRCSVO.DetalleHistoricoRCSVOComparator);
		}
		
		return listDetalleHistoricoRCS;
	}
}