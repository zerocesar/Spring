package mx.com.att.business;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.att.support.CatalogSoapServices;
import mx.com.att.support.ShareNextelSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.BalanceInquiryVO;
import mx.com.att.vo.orange.BalanceVO;
import mx.com.att.vo.orange.ComparteNextelHijoVO;
import mx.com.att.vo.orange.ComparteNextelPadreVO;
import mx.com.att.vo.orange.ComparteNextelVO;
import mx.com.nextel.www.ws.CatalogosServiceSoapBindingStub;
import mx.com.nextel.www.ws.vo.ConsultaMonederosVO;
import mx.com.nextel.www.ws.vo.MonederoVO;

import org.apache.log4j.Logger;
import org.skink.necws.webservice.ApplicationPortBindingStub;
import org.skink.necws.webservice.ElementInfo;
import org.skink.necws.webservice.HierarchyInfo;
import org.skink.necws.webservice.InfoALL;
import org.skink.necws.webservice.Transfer;

import com.google.gson.Gson;
import com.rits.cloning.Cloner;

public class ShareBusiness {

	private static final Logger LOGGER = Logger.getLogger(ShareBusiness.class);
	Map<String, ComparteNextelPadreVO> mapaPadres = new HashMap<String, ComparteNextelPadreVO>();
	Map<String, ComparteNextelHijoVO> mapaHijos = new HashMap<String, ComparteNextelHijoVO>();
	private static final Cloner CLONER = new Cloner();
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	
	public String getAllBusiness(String cadenaJson) {
		LOGGER.info("Ejecutando el metodo getALLBusiness de la clase ShareBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		ComparteNextelVO comparteNextelVO = new ComparteNextelVO();
		final CustomerVO customerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class);
		final ResponseVO responseVO = new ResponseVO();
		
		//Obtencion de proxy para los servicios de ComparteNextel
		final ApplicationPortBindingStub shareProxy = ShareNextelSoapServices.getComparteNextelService();
		
		try {
			final InfoALL listaCN = shareProxy.getALL("52" + customerVO.getUser());
			
			if (listaCN != null && listaCN.getStatus() != null && listaCN.getStatus().getResponseCode() >= 0){
				
				//Se setea maximo de hijos
				comparteNextelVO.setMaxHijos(ATTConstants.MAX_HIJOS);
				comparteNextelVO.setMaxPadres(ATTConstants.MAX_PADRES);
				
				if (listaCN.getParents() != null && listaCN.getParents().length > 0){
					LOGGER.info("----------- LLENANDO LOS PADRES -----------");
					List <ComparteNextelPadreVO> posiblesPadres = new ArrayList<ComparteNextelPadreVO>();
					
					/* posiblesPadres.add(new ComparteNextelPadreVO
					 * ("5540010213","N","a",null,"",null,true));
					 * buscaMonederos(consultaVO.getSistema(), 
					 * posiblesPadres.get(0).getMsisdn(), 
					 * posiblesPadres.get(0)); */
					
					for (final ElementInfo element : listaCN.getParents()){
						posiblesPadres.add(new ComparteNextelPadreVO(element.getMsisdn(), element.getPending(), element.getStatus(), element.getTmcode(), element.getTmDes(), element.getAddedInCurrentBC(), element.getType(), null, true));
						buscaMonederos(customerVO.getSystemId(), element.getMsisdn().substring(2,12), posiblesPadres.get(posiblesPadres.size()-1));
					}
					comparteNextelVO.setPadres(posiblesPadres);
				}
				
				if (listaCN.getChildren() != null && listaCN.getChildren().length > 0){
					LOGGER.info("----------- LLENANDO LOS HIJOS -----------");
					List <ComparteNextelHijoVO> posiblesHijos = new ArrayList<ComparteNextelHijoVO>();
					
					for (final ElementInfo element : listaCN.getChildren()){
						posiblesHijos.add(new ComparteNextelHijoVO(element.getMsisdn(), element.getPending(), element.getStatus(), element.getTmcode(), element.getTmDes(), element.getAddedInCurrentBC(), element.getType()));
						mapaHijos.put(element.getMsisdn(), CLONER.deepClone(posiblesHijos.get(posiblesHijos.size()-1)));
					}
					comparteNextelVO.setHijos(posiblesHijos);
				}
				
				if (listaCN.getAssociated() != null && listaCN.getAssociated().length > 0){
					LOGGER.info("----------- LLENANDO LOS ASOCIADOS -----------");
					List <ComparteNextelPadreVO> asociados = new ArrayList<ComparteNextelPadreVO>();
					
					for (final HierarchyInfo element : listaCN.getAssociated()){
						if (element.getParent().getMsisdn() != null){
							if(element.getChildren() != null && element.getChildren().length > 0){
								List <ComparteNextelHijoVO> hijosList = new ArrayList<ComparteNextelHijoVO>();
								
								for (final ElementInfo elementHijo : element.getChildren()){
									mapaHijos.get(elementHijo.getMsisdn()).fillBucket();
									hijosList.add(mapaHijos.get(elementHijo.getMsisdn()));
								}
								mapaPadres.get(element.getParent().getMsisdn()).setHijos(hijosList);
								asociados.add(mapaPadres.get(element.getParent().getMsisdn()));
							}
						}	
					}
					comparteNextelVO.setAsociados(asociados);
				}
				
				buscaTransferencias(listaCN.getTransfers(), comparteNextelVO.getAsociados());

				comparteNextelVO.setCode(ATTConstants.CODIGO_EXITO);
				comparteNextelVO.setMessageCode(ATTConstants.DESC_EXITO);
			}else{
				comparteNextelVO.setCode(ATTConstants.CODIGO_ERROR_PARAM_ENTRADA);
				comparteNextelVO.setMessageCode(listaCN.getStatus().getResponseMessage());
			}
		} catch (RemoteException remoteException) {
			LOGGER.error("Ocurrio un error de conexion: " , remoteException);
			comparteNextelVO.setCode(VALIDATOR.validateRemoteException(remoteException));
			comparteNextelVO.setMessageCode(ATTConstants.DESC_SISTEMA_NO_DISPONIBLE);
		} catch (Exception e){
			LOGGER.error("Ocurrio un error: " , e);
			comparteNextelVO.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			comparteNextelVO.setMessageCode(ATTConstants.DESC_SISTEMA_NO_DISPONIBLE);
		}
		
		if (comparteNextelVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
			responseVO.setCode(comparteNextelVO.getCode());
			responseVO.setMessageCode(comparteNextelVO.getMessageCode());
			responseVO.setObjectResponse(comparteNextelVO);
		}else{
			if(comparteNextelVO.getMessageCode()!=null && comparteNextelVO.getMessageCode().contains("no tiene un plan valido")){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(comparteNextelVO.getMessageCode().toString());
				responseVO.setObjectResponse(comparteNextelVO);
			}else{
				responseVO.setCode(comparteNextelVO.getCode());
				responseVO.setMessageCode(comparteNextelVO.getMessageCode());
				responseVO.setObjectResponse(comparteNextelVO);
			}
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public void buscaTransferencias(final Transfer[] transfers, final List<ComparteNextelPadreVO> asociados){
		final DecimalFormat decimalFormat = new DecimalFormat("###,##0");
		
		LOGGER.info("----------- LLENANDO LAS TRANSFERENCIAS PROGRAMADAS -----------");
		if (transfers != null && transfers.length > 0){
			for (final Transfer transfer : transfers){
				for (final ComparteNextelPadreVO padre : asociados){
					if (padre.getMsisdn().equalsIgnoreCase(transfer.getParentMsisdn())){
						for (final ComparteNextelHijoVO hijo : padre.getHijos()){
							if (hijo.getMsisdn().equalsIgnoreCase(transfer.getDestinationMsisdn())){
								for (final BalanceVO bucket : hijo.getBucket()){
									if (bucket.getType().equalsIgnoreCase(transfer.getBucket())){
										if (bucket.getType().equalsIgnoreCase(ATTConstants.ADD_SMS) || bucket.getType().equalsIgnoreCase(ATTConstants.ADD_TELCEL)){
											bucket.setAmount(decimalFormat.format(transfer.getAmount()));
										} else{
											bucket.setAmount(String.valueOf(transfer.getAmount()));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void buscaMonederos(final String sistema, final String dNumber, final ComparteNextelPadreVO listaCNP) throws RemoteException{
		ConsultaMonederosVO consultaMonedero = new ConsultaMonederosVO();
		BalanceInquiryVO monederoActual = null;
		ConsultaMonederosVO monederoIncluido = null;
		//Obtencion de proxy para los servicios de CatalogosService
		final CatalogosServiceSoapBindingStub catalogProxy = CatalogSoapServices.getCatalogSoapServices();
		
		consultaMonedero.setIdSistema(sistema);
		consultaMonedero.setDn(dNumber);
		monederoActual = getCustomerBalanceIncluded(consultaMonedero);
		monederoIncluido = catalogProxy.consultaAbonosMensuales(consultaMonedero);
		
		if (monederoActual != null && monederoActual.getBalancesIncluded() != null){
			for (final BalanceVO balance : monederoActual.getBalancesIncluded()){
				for (final BalanceVO balanceCNP : listaCNP.getMonederoActual()){
					if (balanceCNP.getType().equalsIgnoreCase((balance.getType().equalsIgnoreCase(ATTConstants.ABONO_PESOS)) ? ATTConstants.ABONO_PESOS_3G : balance.getType())){
						balanceCNP.setBalanceVO(balance);
					}
				}
			}
		}
		
		if (monederoIncluido != null && monederoIncluido.getMonederoVO() != null){
			for (final MonederoVO balance : monederoIncluido.getMonederoVO()){
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
				for (final BalanceVO balancePadre : listaCNP.getMonederoIncluido()){
					if (balancePadre.getType().equalsIgnoreCase((balance.getMonedero().equalsIgnoreCase(ATTConstants.ABONO_PESOS)) ? ATTConstants.ABONO_PESOS_3G : balance.getMonedero())){
						balancePadre.setBalanceVO(balance);
					}
				}
			}
		}
		mapaPadres.put(listaCNP.getMsisdn(), CLONER.deepClone(listaCNP));
	}
	
	public BalanceInquiryVO getCustomerBalanceIncluded(final ConsultaMonederosVO consultaMonederosVO){
		LOGGER.info("Ejecutando el metodo getCustomerBalanceIncluded de la clase ShareBusiness");

		BalanceInquiryVO balanceInquiry = new BalanceInquiryVO();
		List<BalanceVO> balancesIncluded = new ArrayList<BalanceVO>();
		MonederoVO[] monederoVOs = null;

		//DEFINIMOS LAS VARIABLES ACUMULATIVAS
		final DecimalFormat decForm = new DecimalFormat("###,##0.00");
		final DecimalFormat numberFormat = new DecimalFormat("###,##0");
		final DecimalFormat kiloByteF = new DecimalFormat("###,##0.00");
			
		//CREAMOS EL LOG DEL SISTEMA
		LOGGER.info("ID Systema : " + consultaMonederosVO.getIdSistema());
		LOGGER.info("DN: "+ consultaMonederosVO.getDn());

		//REALIZAMOS LA LLAMADA AL WS REMOTO
		final CatalogosServiceSoapBindingStub catalogProxy = CatalogSoapServices.getCatalogSoapServices();
		
		try {
			final ConsultaMonederosVO consultaMonederos = catalogProxy.consultaMonederos(consultaMonederosVO);
			//VALIDACION PARA SABER EL CONTENIDO
			if(consultaMonederos != null && consultaMonederos.getMonederoVO() != null && consultaMonederos.getMonederoVO().length >= 1) {
				monederoVOs = consultaMonederos.getMonederoVO();
				LOGGER.info("monederosVOs NO ESTA VACIO, PROCEDE ...");
				for(final MonederoVO monedero: monederoVOs) {

					BalanceVO balanceVO = new BalanceVO();
					final double amount = monedero.getMonto();
					final String tipoUnidad = monedero.getTipoUnidad();

					//SETEAMOS EL OBJETO DE BALANCE CON CADA UNO DE LOS MONEDEROS
					//OBTENIDOS POR EL METODO REMORO consultaMonederos
					balanceVO.setType(monedero.getMonedero());
					balanceVO.setDescripcion(monedero.getDescripcion());
					balanceVO.setExpirationDate(monedero.getFechaExpiracion());
					balanceVO.setUnitType(monedero.getTipoUnidad());
					balanceVO.setMonederoType(monedero.getTipoMonedero());
					balanceVO.setAmount(numberFormat.format(amount));

					//SUMA TOTAL DE PESOS
					if(tipoUnidad.equalsIgnoreCase("PESOS")) {
						balanceVO.setAmount(decForm.format(amount));
					}
					//SUMA TOTAL DE MINUTOS
					else if(tipoUnidad.equalsIgnoreCase("MINUTOS")) {
						balanceVO.setAmount(numberFormat.format(amount));
					}
					//SUMA TOTAL DE LOS SMS
					else if(tipoUnidad.equalsIgnoreCase("SMS")) {
						balanceVO.setAmount(numberFormat.format(amount));
					}
					//SUMA TOTAL DE KB
					else if (tipoUnidad.equalsIgnoreCase(ATTConstants.VALOR_KB)) {
						balanceVO.setAmount(kiloByteF.format(amount/ATTConstants.VALOR_CONVERSION_BYTES) ); 
						balanceVO.setUnitType(ATTConstants.VALOR_MB);
					}
					
					else if (tipoUnidad.equalsIgnoreCase(ATTConstants.VALOR_GB)) {
						balanceVO.setAmount(kiloByteF.format(amount*ATTConstants.VALOR_CONVERSION_BYTES) ); 
						balanceVO.setUnitType(ATTConstants.VALOR_MB);
					} 
					
					else if (tipoUnidad.equalsIgnoreCase(ATTConstants.VALOR_TB)) {
						balanceVO.setAmount(kiloByteF.format(amount*ATTConstants.VALOR_CONVERSION_BYTES*ATTConstants.VALOR_CONVERSION_BYTES) ); 
						balanceVO.setUnitType(ATTConstants.VALOR_MB);
					}
						
					//UNIDADES MENSUALES INCLUIDAS EN EL PLAN TARIFARIO
					if(monedero.getTipoMonedero().equals("1")){
						balancesIncluded.add(balanceVO);
					}
				}
				balanceInquiry.setBalancesIncluded(balancesIncluded);

				
				balanceInquiry.setCode(ATTConstants.CODIGO_EXITO);
			}else{
				LOGGER.error("monederoVOs ESTA VACIO PROCEDE.. ");
				balanceInquiry.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				balanceInquiry.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
			}
		} catch (RemoteException remoteException) {
			LOGGER.error("Error Exception en el metodo getCustomerBalances: ",remoteException);
			balanceInquiry.setCode(VALIDATOR.validateRemoteException(remoteException));
			balanceInquiry.setMessageCode(ATTConstants.DESC_SISTEMA_NO_DISPONIBLE);
		}
		return balanceInquiry;
	}
	
	public boolean isTMCODEShare(String telephoneNumber){
		LOGGER.info("Ejecutando el metodo isTMCODEShare de la clase ShareBusiness");
		final StringBuffer stringBooleanShare = new StringBuffer();
		
		//Obtencion de proxy para los servicios de ComparteNextel
		final ApplicationPortBindingStub shareProxy = ShareNextelSoapServices.getComparteNextelService();
		
		try {
			final InfoALL listaCN = shareProxy.getALL(telephoneNumber);
			
			if (listaCN == null || listaCN.getStatus() == null || listaCN.getStatus().getResponseCode() < ATTConstants.VAL_CERO){
				stringBooleanShare.append(false);
			} else{
				if (listaCN.getParents().length > ATTConstants.VAL_CERO && listaCN.getChildren().length > ATTConstants.VAL_CERO){
					stringBooleanShare.append(true);
				} else{
					stringBooleanShare.append(false);
				}
			}
		} catch (RemoteException remoteException) {
			LOGGER.error("RemoteException en el metodo isTMCODEShare: ", remoteException);
		}
		
		return new Boolean(stringBooleanShare.toString());
	}
}