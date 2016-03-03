package mx.com.att.business;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import mx.com.att.support.CatalogSoapServices;
import mx.com.att.support.ClientesOESoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.BalanceInquiryVO;
import mx.com.att.vo.orange.BalanceVO;
import mx.com.nextel.www.ecommerce.ws.cliente.ClientesOESoapBindingStub;
import mx.com.nextel.www.wppp.exceptions.WPPPntException;
import mx.com.nextel.www.ws.CatalogosServiceSoapBindingStub;
import mx.com.nextel.www.ws.vo.ConsultaMonederosVO;
import mx.com.nextel.www.ws.vo.MonederoVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class PocketsBusiness {

	private static final Logger LOGGER = Logger.getLogger(PocketsBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT(); 
	
	public String getPockets(final String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getPockets de la clase PocketsBusiness");
		final ResponseVO responseVO = new ResponseVO();
		
		final CustomerVO customerVO = new Gson().fromJson(cadenaJson, CustomerVO.class);
		try{
			VALIDATOR.validateDN10(customerVO.getUser());
			VALIDATOR.validateEmptyString(customerVO.getSystemId(), "Id del Sistema");
			
			final mx.com.nextel.www.ecommerce.ws.cliente.ConsultaMonederosVO consultaMonederosVO = new mx.com.nextel.www.ecommerce.ws.cliente.ConsultaMonederosVO();
			consultaMonederosVO.setDn(customerVO.getUser());
			consultaMonederosVO.setIdSistema(customerVO.getSystemId());
			//Obtiene la informacion de los monederos para el dn mediante consultaMonederos de MAR.
			final ClientesOESoapBindingStub clientesOEProxy = ClientesOESoapServices.getClientesOEService();
			final String responseString = clientesOEProxy.consultaMonederosMovil(new Gson().toJson(consultaMonederosVO));
			final ResponseVO responseRemoteVO = new Gson().fromJson(responseString, ResponseVO.class);
			
			if (responseRemoteVO == null || responseRemoteVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_MPIN);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(VALIDATOR.validateGetCode(responseRemoteVO.getCode(), ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseRemoteVO.getObjectResponse());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(responseRemoteVO.getCode());
				responseVO.setMessageCode(responseRemoteVO.getMessageCode());
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (WPPPntException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_GET_SALDO_CUENTA);
			responseVO.setMessageCode(e.getMessage1());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return new Gson().toJson(responseVO);
	}
	
	public String consultaTopesMonederos(String cadenaJson) {
		LOGGER.info("Ejecutando el metodo consultaTopesMonederos de la clase PocketsBusiness");
		final CustomerVO customerVO = new Gson().fromJson(cadenaJson, CustomerVO.class);
		final ConsultaMonederosVO consultaMonedero = new ConsultaMonederosVO();
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			VALIDATOR.validateEmptyString(customerVO.getUser(), "user (dn)");
			VALIDATOR.validateEmptyString(customerVO.getSystemId(), "systemId");
		
			consultaMonedero.setDn((customerVO.getUser().length() == 12) ? customerVO.getUser().substring(2) : customerVO.getUser());
			consultaMonedero.setIdSistema(customerVO.getSystemId());
			
			final DecimalFormat numberFormat = new DecimalFormat("###,##0");
			final DecimalFormat megaByteF = new DecimalFormat("###,##0.00");
			
			final CatalogosServiceSoapBindingStub catalogProxy = CatalogSoapServices.getCatalogSoapServices();
			
			final BalanceInquiryVO balanceInquiry = new BalanceInquiryVO();
			
			
			final ShareBusiness bsnComparteNextel = new ShareBusiness();
			final BalanceInquiryVO balanceInquiryVO = bsnComparteNextel.getCustomerBalanceIncluded(consultaMonedero);
		
		
			if (balanceInquiryVO == null || balanceInquiryVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_ERROR_SIN_INFORMACION)){
				LOGGER.error("Se presento un error al consultar los monederos actuales para el DN: " + consultaMonedero.getDn());
				responseVO.setCode(ATTConstants.CODIGO_ERROR_MONEDEROS);
				responseVO.setMessageCode(ATTConstants.DESC_CODIGO_ERROR_MONEDEROS);
				responseVO.setObjectResponse(null);
				
			} else if (balanceInquiryVO.getBalancesIncluded() == null){
				LOGGER.error("Se presento un error al consultar los monederos actuales para el DN: " + consultaMonedero.getDn());
				responseVO.setCode(ATTConstants.CODIGO_ERROR_MONEDEROS);
				responseVO.setMessageCode(ATTConstants.DESC_CODIGO_ERROR_MONEDEROS);
				responseVO.setObjectResponse(null);
			} else {
				LOGGER.info("Se encontraron los monederos actuales para el DN: " + consultaMonedero.getDn());
				balanceInquiry.setCurrentBalances(balanceInquiryVO.getBalancesIncluded());
				
				final List<BalanceVO> balanceMensual = new ArrayList<BalanceVO>();
				final ConsultaMonederosVO monederoMensual = catalogProxy.consultaAbonosMensuales(consultaMonedero);
				
				if (monederoMensual == null || monederoMensual.getMonederoVO() == null){
					LOGGER.error("Se presento un error al consultar los monederos mensuales para el DN: " + consultaMonedero.getDn());
					responseVO.setCode(ATTConstants.CODIGO_ERROR_MONEDEROS);
					responseVO.setMessageCode(ATTConstants.DESC_CODIGO_ERROR_MONEDEROS);
					responseVO.setObjectResponse(null);
				} else {
					for (MonederoVO balance : monederoMensual.getMonederoVO()){
						final BalanceVO balanceVO = new BalanceVO();
						if(balance.getTipoUnidad().equalsIgnoreCase(ATTConstants.VALOR_KB)){
							balance.setMonto(balance.getMonto()/ATTConstants.VALOR_CONVERSION_BYTES); 
							balance.setTipoUnidad(ATTConstants.VALOR_MB);
						} else if (balance.getTipoUnidad().equalsIgnoreCase(ATTConstants.VALOR_GB)){
							balance.setMonto(balance.getMonto()*ATTConstants.VALOR_CONVERSION_BYTES);
							balance.setTipoUnidad(ATTConstants.VALOR_MB);
						} else if (balance.getTipoUnidad().equalsIgnoreCase(ATTConstants.VALOR_TB)){
							balance.setMonto(balance.getMonto()*ATTConstants.VALOR_CONVERSION_BYTES*ATTConstants.VALOR_CONVERSION_BYTES);
							balance.setTipoUnidad(ATTConstants.VALOR_MB);
						}
						
						balanceVO.setType(balance.getMonedero());
						balanceVO.setDescripcion(balance.getDescripcion());
						if (balance.getMonedero().equalsIgnoreCase(ATTConstants.ABONO_PESOS) || balance.getMonedero().equalsIgnoreCase(ATTConstants.ADD_TELCEL) || balance.getMonedero().equalsIgnoreCase(ATTConstants.ADD_SMS)){
							balanceVO.setAmount(numberFormat.format(balance.getMonto()));
						} else if(balance.getMonedero().equalsIgnoreCase(ATTConstants.ADD_WAP_TETH)){
							balanceVO.setAmount(megaByteF.format(balance.getMonto()));
						} else{
							balanceVO.setAmount(balance.getMonto().toString());
						}
						balanceVO.setUnitType(balance.getTipoUnidad());
						
						balanceMensual.add(balanceVO);
					}
					balanceInquiry.setMonthlyBalances(balanceMensual);
					
					LOGGER.info("Se encontraron los monederos mensuales para el DN: " + consultaMonedero.getDn());
					responseVO.setCode(ATTConstants.CODIGO_EXITO);
					responseVO.setMessageCode(ATTConstants.DESC_EXITO);
					responseVO.setObjectResponse(balanceInquiry);
				}
			}
		} catch (RemoteException remoteException) {
			LOGGER.error("Ocurrio un error con los servicios MARServiciosPrepago/CatalogosService?wsdl ", remoteException);
			responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			responseVO.setObjectResponse(null);
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return new Gson().toJson(responseVO);
	}
}