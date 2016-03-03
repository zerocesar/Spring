package mx.com.att.business;

import java.rmi.RemoteException;

import mx.com.att.support.EstadoCuentaSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.DatosCuentaVO;
import mx.com.att.vo.orange.EstadoCuentaVO;
import mx.com.nextel.www.wppp.exceptions.WPPPntException;

import org.apache.log4j.Logger;

import ws.cuenta.nextel.com.mx.n0.EstadoCuentaPortBindingStub;

import com.google.gson.Gson;

public class BillingBalanceBusiness {
	private static final Logger LOGGER = Logger.getLogger(BillingBalanceBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT(); 
	
	
	public String getAcountCharge(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getAcountCharge de la clase BillingBalanceBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final EstadoCuentaVO estadoCuentaVO = new Gson().fromJson(jsonDecrypted, EstadoCuentaVO.class);
		try{
			VALIDATOR.validateEmptyString(estadoCuentaVO.getBillingAccountId(), "Id del Estado de Cuenta");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getIdCiclo(), "Id del Ciclo");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getTimmCustomerId(), "Id del Cliente");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getSubFijoTabla(), "Subfijo Tabla");
			
			//Obtiene la informacion del numero de dns bloqueados mediante el id del responsable de pago.
			final EstadoCuentaPortBindingStub estadoCuentaProxy = EstadoCuentaSoapServices.getEstadoCuentaService();
			final String responseString = estadoCuentaProxy.getCargoCuentaMovil(jsonDecrypted);
			final ResponseVO responseEstadoCuenta = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseEstadoCuenta == null || responseEstadoCuenta.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_BILLING_BALANCE);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseEstadoCuenta.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseEstadoCuenta.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseEstadoCuenta.getCode());
				responseVO.setMessageCode(responseEstadoCuenta.getMessageCode());
				responseVO.setObjectResponse(responseEstadoCuenta.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_BILLING_BALANCE);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getEquipmentCharge(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getEquipmentCharge de la clase BillingBalanceBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final EstadoCuentaVO estadoCuentaVO = new Gson().fromJson(jsonDecrypted, EstadoCuentaVO.class);
		try{
			VALIDATOR.validateEmptyString(estadoCuentaVO.getBillingAccountId(), "Id del Estado de Cuenta");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getIdCiclo(), "Id del Ciclo");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getTimmCustomerId(), "Id del Cliente");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getSubFijoTabla(), "Subfijo Tabla");
			
			//Obtiene la informacion del numero de dns bloqueados mediante el id del responsable de pago.
			final EstadoCuentaPortBindingStub estadoCuentaProxy = EstadoCuentaSoapServices.getEstadoCuentaService();
			final String responseString = estadoCuentaProxy.getCargoEquipoMovil(jsonDecrypted);
			final ResponseVO responseEstadoCuenta = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseEstadoCuenta == null || responseEstadoCuenta.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_BILLING_BALANCE);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseEstadoCuenta.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseEstadoCuenta.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseEstadoCuenta.getCode());
				responseVO.setMessageCode(responseEstadoCuenta.getMessageCode());
				responseVO.setObjectResponse(responseEstadoCuenta.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_BILLING_BALANCE);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getEquipmentChargeDetail(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getEquipmentChargeDetail de la clase BillingBalanceBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final EstadoCuentaVO estadoCuentaVO = new Gson().fromJson(jsonDecrypted, EstadoCuentaVO.class);
		try{
			VALIDATOR.validateEmptyString(estadoCuentaVO.getBillingAccountId(), "Id del Estado de Cuenta");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getIdCiclo(), "Id del Ciclo");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getTimmCustomerId(), "Id del Cliente");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getIdContrato(), "Id del Contrato");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getTmcode(), "Id del Plan Tarifario");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getSubFijoTabla(), "Subfijo Tabla");
			
			//Obtiene la informacion del numero de dns bloqueados mediante el id del responsable de pago.
			final EstadoCuentaPortBindingStub estadoCuentaProxy = EstadoCuentaSoapServices.getEstadoCuentaService();
			final String responseString = estadoCuentaProxy.getDetalleCargoEquipoMovil(jsonDecrypted);
			final ResponseVO responseEstadoCuenta = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseEstadoCuenta == null || responseEstadoCuenta.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_BILLING_BALANCE);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseEstadoCuenta.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseEstadoCuenta.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseEstadoCuenta.getCode());
				responseVO.setMessageCode(responseEstadoCuenta.getMessageCode());
				responseVO.setObjectResponse(responseEstadoCuenta.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_BILLING_BALANCE);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getBillAccount(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getBillAccount de la clase BillingBalanceBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try{
			final DatosCuentaVO datosCuentaVO = new Gson().fromJson(jsonDecrypted, DatosCuentaVO.class);
			
			VALIDATOR.validateEmptyString(datosCuentaVO.getCustomerId(), "Customer Id");
			
			//Obtiene la informacion del numero de dns bloqueados mediante el id del responsable de pago.
			final EstadoCuentaPortBindingStub estadoCuentaProxy = EstadoCuentaSoapServices.getEstadoCuentaService();
			final String responseString = estadoCuentaProxy.getEstadoCuentaMovil(jsonDecrypted);
			final ResponseVO responseEstadoCuenta = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseEstadoCuenta == null || responseEstadoCuenta.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_BILLING_BALANCE);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseEstadoCuenta.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseEstadoCuenta.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseEstadoCuenta.getCode());
				responseVO.setMessageCode(responseEstadoCuenta.getMessageCode());
				responseVO.setObjectResponse(responseEstadoCuenta.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_BILLING_BALANCE);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getItems(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getItems de la clase BillingBalanceBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try{
			final EstadoCuentaVO estadoCuentaVO = new Gson().fromJson(jsonDecrypted, EstadoCuentaVO.class);
			
			VALIDATOR.validateEmptyString(estadoCuentaVO.getCustomerId(), "Customer Id");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getIdContrato(), "Contrato");
			VALIDATOR.validateEmptyString(estadoCuentaVO.getSubFijoTabla(), "Sufijo de Tabla");
			
			final ws.cuenta.nextel.com.mx.n0.InvoiceInVO invoiceInVO = new ws.cuenta.nextel.com.mx.n0.InvoiceInVO();
			invoiceInVO.setCoId(Long.parseLong(estadoCuentaVO.getIdContrato()));
			invoiceInVO.setCustomerId(Long.parseLong(estadoCuentaVO.getCustomerId()));
			invoiceInVO.setMmYY(estadoCuentaVO.getSubFijoTabla());
			
			//Obtiene la informacion del numero de dns bloqueados mediante el id del responsable de pago.
			final EstadoCuentaPortBindingStub estadoCuentaProxy = EstadoCuentaSoapServices.getEstadoCuentaService();
			final String responseString = estadoCuentaProxy.getItemsMovil(new Gson().toJson(invoiceInVO));
			final ResponseVO responseEstadoCuenta = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseEstadoCuenta == null || responseEstadoCuenta.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_BILLING_BALANCE);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseEstadoCuenta.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseEstadoCuenta.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseEstadoCuenta.getCode());
				responseVO.setMessageCode(responseEstadoCuenta.getMessageCode());
				responseVO.setObjectResponse(responseEstadoCuenta.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_BILLING_BALANCE);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
}