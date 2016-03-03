package mx.com.att.business;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import mx.com.att.business.orange.BsnContract;
import mx.com.att.dao.LoginDAO;
import mx.com.att.dao.LoginDAOImpl;
import mx.com.att.dao.ParametrosDAO;
import mx.com.att.dao.ParametrosDAOImpl;
import mx.com.att.dao.orange.ClienteAdicionDAO;
import mx.com.att.dao.orange.ClienteAdicionDAOImpl;
import mx.com.att.dao.orange.PaymentTypeWPVO;
import mx.com.att.support.ClientesAdicionSoapServices;
import mx.com.att.support.ContratosWPPPSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.ContractVO;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.ClassificationDnVO;
import mx.com.att.vo.orange.ClassificationVO;
import mx.com.att.vo.orange.CommercialConfigurationVO;
import mx.com.att.vo.orange.ServiceWPVO;
import mx.com.att.vo.orange.ValidaMontosVO;
import mx.com.nextel.www.ecommerce.ws.adicion.ClientesAdicionPortBindingStub;
import mx.com.nextel.www.wppp.exceptions.WPPPntException;
import mx.com.nextel.www.wppp.ws.contratos.ContratosWPPPSoapProxy;
import mx.com.nextel.www.wppp.ws.vo.DeviceVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class CommercialConfigBusiness {

	private static final Logger LOGGER = Logger.getLogger(CommercialConfigBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();

	/**
	 * Este metodo obtiene una lista de servicios de acuerdo al canal,
	 *  tipo de contrato, tecnologia y serviceType,
	 * @author Karina Quintana - Mindbits Desarrollo (14/OCT/2013)
	 * @param CommercialConfigurationVO con los siguientes atributos
	 *  no nulos y diferentes de cero:
	 * 		CHANNELID	[Identificador del canal].
	 * 		CONTRACTTYPEID	[Identificador del tipo de contrato].
	 * 		TECHNOLOGYTYPEID	[Identificador del tipo de tecnologia].
	 * @return ServiceWPVO[] con los siguientes atributos diferentes
	 *  de nulos y diferentes de cero: 
 	 * 		IDCODEMESSAGE 	[Identificador del mensaje].
 	 * 		SERVDESCRIPTION		[Descripcion del servicio].		
 	 * 		SERVNAME		[Nombre del servicio].			
 	 * 		SERVTYPEDESCRIPTION		[Descripcion correspondiente
 	 * 		 al tipos de servicio].
 	 * 		SERVTYPENAME	[Nombre del tipo de servicio].
 	 * 		SERVICEID	[Identificador del servicio].
 	 * 		SERVICETYPEID	[Identificador de tipo de servicio].
	 * @throws EcommerceWSException 
 	 */
	public String getServiceList(String cadenaJson) {
		LOGGER.info("Ejecutando el metodo getServiceList de la clase CommercialConfigBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final CustomerVO customerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class);
		
		//Excepciones por rojo/verde si aplica para el DN
		try {
			VALIDATOR.validateDN10((customerVO.getUser().length()==12) ? customerVO.getUser().substring(2) : customerVO.getUser());
			ClassificationDnVO classif = new ClassificationDnVO();
			classif.setMdn(customerVO.getUser());
				
			classif = (ClassificationDnVO) getClassificationDn( classif ).getObjectResponse();

			CommercialConfigurationVO comConfVO = new CommercialConfigurationVO();
			
			if (customerVO.getSystemId().equalsIgnoreCase(ATTConstants.ETIQUETA_MVL)){
				comConfVO.setChannelId(ATTConstants.ID_MVL);
			} else if(customerVO.getSystemId().equalsIgnoreCase(ATTConstants.ETIQUETA_IOS)){
				comConfVO.setChannelId(ATTConstants.ID_IOS);
			} else if(customerVO.getSystemId().equalsIgnoreCase(ATTConstants.ETIQUETA_WPN)){
				comConfVO.setChannelId(ATTConstants.ID_WPN);
			}
			
			ContractVO contratoVO = new Gson().fromJson(new Gson().toJson(customerVO.getContractVO()), ContractVO.class);
			comConfVO.setContractTypeId(Long.parseLong(contratoVO.getContractTypeId()));
			comConfVO.setTechnologyTypeId(contratoVO.getTechnologyId());
			
			List<ServiceWPVO> listServiceWPVO = getServiciosList(comConfVO);//ENVIAMOS EL OBJETO AL BUSSINESS
			
			LOGGER.info("estamos en get service List4" + listServiceWPVO);
			ServiceWPVO[] serviceWPVO = null;
			if (listServiceWPVO != null && listServiceWPVO.size() > ATTConstants.VAL_CERO) {//VALIDAMOS SI LA LISTA ESTA ES DIFERENTE DE NULA Y MAYOR A 0
				serviceWPVO = new ServiceWPVO[listServiceWPVO.size()];
				LOGGER.info("Estamos en get service List");

				List<ServiceWPVO> listService = new ArrayList<ServiceWPVO> ();	
				
				for (int i = 0; i < listServiceWPVO.size(); i++) {
					boolean agregar = true;

					//Excepciones por rojo/verde
					if(classif!=null && classif.getClassification()!=null && classif.getClassification().getMetaCatalogType().equalsIgnoreCase(ATTConstants.META_CATALOG_TYPE_LIBERTAD))
						for(ClassificationVO c : ATTConstants.EXCLUSIONES_TMCODE_ARR)
							if(listServiceWPVO.get(i).getServiceId()==Long.parseLong(c.getMetaCatalogValue()))
							{
								LOGGER.info("Se omitio el serviceId: " + listServiceWPVO.get(i).getServiceId());
								agregar = false;
							}
					
					if(agregar){
						listService.add(listServiceWPVO.get(i));
					}
				}
				
				serviceWPVO = new ServiceWPVO[listService.size()];
				serviceWPVO = listService.toArray(serviceWPVO);

				LOGGER.info("El metodo getServiceList del webservice Clientes Adicion regresa [" + listServiceWPVO.size() + "]");
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(serviceWPVO);

			} else {
				LOGGER.info("No hay datos en la lista de get ServiceLis" + listServiceWPVO);
				responseVO.setCode(ATTConstants.CODIGO_ERROR_SIN_INFORMACION);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				responseVO.setObjectResponse(serviceWPVO);
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	/**
	 * Este metodo regresa toda la lista de los servicios
	 * @author Karina Quintana - MindBits Desarrollo (14/OCT/2013)
	 * @param CommercialConfigurationVO que contiene el id del canal,
	 *  el tipo de contrato y el tipo de tecnologia.
	 * @return List&lt;ServiceWPVO&gt;  que devolvera la lista de Servicios.
	 * @throws EcommerceWSException, SQLException 
	 */

	public  List<ServiceWPVO> getServiciosList(CommercialConfigurationVO conf) {
		List<ServiceWPVO> listServiceWPVO;
		try{
			LOGGER.info("getServiciosList &&&&&&&&&");
			VALIDATOR.validateEmptyLong(conf.getChannelId(), "ChannelId");//VALIDACION DE CANAL SEA MAYOR A 0
			VALIDATOR.validateEmptyLong(conf.getContractTypeId(), "ContractTypeId");//VALIDACION DE TIPO DE CONTRATO SEA MAYOR A 0
			VALIDATOR.validateEmptyLong(conf.getTechnologyTypeId(), "TecnologyType");//VALIDACION DEL ID DEL TIPO DE TECNOLOGIA SEA MAYOR A 0
			LOGGER.info("getServiciosList"+ conf.getTechnologyTypeId());
			ClienteAdicionDAO dao= new ClienteAdicionDAOImpl();//SE LLAMA AL DAO
			LOGGER.info("Estamos en get servicios Bussines1");
			listServiceWPVO=dao.getServiciosList(conf);
			LOGGER.info("Estamos en get servicios Bussines3");
			
		} catch (ValidateException e) {
			LOGGER.error("Ocurrio un error en el metodo getServiciosList: " + e.getMessage());
			listServiceWPVO = null;
		}
		return listServiceWPVO;
	}
	
	public ResponseVO getClassificationDn(ClassificationDnVO dn)
	{
		LOGGER.info("Ejecutando el metodo getClassificationDn de la clase CommercialConfigBusiness");
		
		BsnContract bsnContract = new BsnContract();
		ResponseVO response = new ResponseVO();
		
		if(dn.getMdn().trim().length()!=10)
		{
			response.setObjectResponse(null);
			response.setMessageCode("Se requiere un dn a 10 dígitos");
			response.setCode(ATTConstants.CODIGO_SISTEMA_NO_DISPONIBLE);
			return response;
		}
		
		mx.com.nextel.www.wppp.ws.vo.ContractVO contractVO;
		contractVO = bsnContract.getContractDetails("52" +dn.getMdn());
		
		//Invocación al Servicio que consulta que el DN sea válido
		if (contractVO == null){
			LOGGER.info("No hay informacion para el dn: " + dn.getMdn());
		}else{
			dn.setTmcode(contractVO.getTmCode().toString());
			
			ClassificationVO classif = new ClassificationVO();
			classif.setMetaCatalogValue(dn.getTmcode());
			classif.setMetaCatalogType(ATTConstants.META_CATALOG_TYPE_LIBERTAD);
			ResponseVO repTmp = getClassification(classif);
			
			if( repTmp.getObjectResponse()!=null && ((ClassificationVO[])repTmp.getObjectResponse()).length >0  )
				dn.setClassification(((ClassificationVO[])repTmp.getObjectResponse())[0]);
			
			response.setCode(ATTConstants.CODIGO_EXITO);
			response.setMessageCode(ATTConstants.DESC_EXITO);
			response.setObjectResponse(dn);
		}
		
		return response;
	}
	
	public ResponseVO getClassification(ClassificationVO classif)
	{
		LOGGER.info("Ejecutando el metodo getClassification de la clase CommercialConfigBusiness");
		
		ResponseVO response = new ResponseVO();

		ParametrosDAO param = new ParametrosDAOImpl();
		
		ClassificationVO[] arrClassification = param.getClassification(classif);
		
		response.setCode(ATTConstants.CODIGO_EXITO);
		response.setMessageCode(ATTConstants.DESC_EXITO);
		response.setObjectResponse(arrClassification);
		
		return response;
	}

	public String getPaymentTypeList(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPaymentTypeList de la clase CommercialConfigBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final ClientesAdicionPortBindingStub clienteAdicionProxy = ClientesAdicionSoapServices.getClientesAdicionService();
			final String responseRecharge = clienteAdicionProxy.getPaymentTypeListMovil(jsonDecrypted);
			
			VALIDATOR.validateEmptyString(responseRecharge, "respuestaPaymentTypeWPVO[]");
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			//Se agrega filtrado de Cargo a Factura.
			
			responseVO.setObjectResponse(new Gson().fromJson(responseRecharge, PaymentTypeWPVO[].class));
			PaymentTypeWPVO[] arrPaymentTypeWPVO = (PaymentTypeWPVO[]) responseVO.getObjectResponse();
			responseVO.setObjectResponse(filterPaymentTypeBillingCharge(arrPaymentTypeWPVO,jsonDecrypted));
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_COMMCONFIG);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getCommercialConfiguration(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getCommercialConfiguration de la clase CommercialConfigBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final ClientesAdicionPortBindingStub clienteAdicionProxy = ClientesAdicionSoapServices.getClientesAdicionService();
			final String responseRecharge = clienteAdicionProxy.getCommercialConfigurationMovil(jsonDecrypted);
			
			VALIDATOR.validateEmptyString(responseRecharge, "respuestaCommercialConfigurationVO[]");
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(new Gson().fromJson(responseRecharge, CommercialConfigurationVO[].class));
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_COMMCONFIG);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getServicesByChannel(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getServicesByChannel de la clase CommercialConfigBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			
			final ClientesAdicionPortBindingStub clienteAdicionProxy = ClientesAdicionSoapServices.getClientesAdicionService();
			final String responseRecharge = clienteAdicionProxy.getServicesByChannelMovil(jsonDecrypted);
			
			VALIDATOR.validateEmptyString(responseRecharge, "respuestaList<CommercialConfigurationVO>");
			
			final JsonArray respuestaArray = new JsonParser().parse( responseRecharge ).getAsJsonArray();
			
			List<CommercialConfigurationVO> listaCommConfVO = new ArrayList<CommercialConfigurationVO>();
			for(JsonElement object: respuestaArray){
				CommercialConfigurationVO commerConfVO = new Gson().fromJson(object, CommercialConfigurationVO.class);
				
				if(commerConfVO.getCommercialConfigId()<=0)
					continue;
				
				listaCommConfVO.add(commerConfVO);
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(listaCommConfVO);
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_COMMCONFIG);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} 
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getClassificationDnJson(String cadenaJson) {
		LOGGER.info("Ejecutando el metodo getClassificationDnJson de la clase CommercialConfigBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ClassificationDnVO classificationDnVO = new Gson().fromJson(jsonDecrypted, ClassificationDnVO.class);
		final BsnContract bsnContract = new BsnContract();
		final ResponseVO responseVO = new ResponseVO();
		
		try {
			VALIDATOR.validateDN10(classificationDnVO.getMdn());
			
			final mx.com.nextel.www.wppp.ws.vo.ContractVO contractVO = bsnContract.getContractDetails("52" +classificationDnVO.getMdn());
			
			//Invocación al Servicio que consulta que el DN sea válido
			if (contractVO == null){
				LOGGER.info("No hay informacion para el dn: " + classificationDnVO.getMdn());
			}else{
				classificationDnVO.setTmcode(contractVO.getTmCode().toString());
				
				ClassificationVO classif = new ClassificationVO();
				classif.setMetaCatalogValue(classificationDnVO.getTmcode());
				classif.setMetaCatalogType(ATTConstants.META_CATALOG_TYPE_LIBERTAD);
				ResponseVO repTmp = getClassification(classif);
				
				if( repTmp.getObjectResponse()!=null && ((ClassificationVO[])repTmp.getObjectResponse()).length >0  )
					classificationDnVO.setClassification(((ClassificationVO[])repTmp.getObjectResponse())[0]);
				
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(classificationDnVO);
			}
		} catch (ValidateException e) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_COMMCONFIG);
			responseVO.setMessageCode("Se requiere un dn a 10 dígitos");
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getClassificationJson(String cadenaJson) {
		LOGGER.info("Ejecutando el metodo getClassificationJson de la clase CommercialConfigBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ClassificationVO classificationVO = new Gson().fromJson(jsonDecrypted, ClassificationVO.class);
		final ResponseVO responseVO = new ResponseVO();

		final ParametrosDAO param = new ParametrosDAOImpl();
		
		final ClassificationVO[] arrClassification = param.getClassification(classificationVO);
		
		responseVO.setCode(ATTConstants.CODIGO_EXITO);
		responseVO.setMessageCode(ATTConstants.DESC_EXITO);
		responseVO.setObjectResponse(arrClassification);
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	private PaymentTypeWPVO[] filterPaymentTypeBillingCharge(PaymentTypeWPVO[] paymentTypeWPVO, String cadenaJson){
		PaymentTypeWPVO[] filterPaymentTypeWPVO = null;
		final List<PaymentTypeWPVO> listPaymentTypeWPVO = new ArrayList<PaymentTypeWPVO>();
		try{
			LOGGER.error("filterPaymentTypeBillingCharge *-"+cadenaJson+"-*");
			final CommercialConfigurationVO commercialConfigurationVO = new Gson().fromJson(cadenaJson, CommercialConfigurationVO.class);

			if (paymentTypeWPVO == null || (paymentTypeWPVO.length == 0)){
				return filterPaymentTypeWPVO;
			}
			final int lengthPaymentTypeWPVO = paymentTypeWPVO.length;
			boolean webPortalAmountValid = false;
			boolean billValid = false;
			boolean contractsValid = false;
			
			for (int i =0; i < lengthPaymentTypeWPVO; i++){
				if(paymentTypeWPVO[i].getPaymentId() == 2){
					webPortalAmountValid = billValid = false;
					//Forma de Pago Cargo a Factura
					LOGGER.info("FORMA DE PAGO CARGO A FACTURA");
					/*getWebPortalAmountsMobile*/
					/*Este metodo recupera el monto de transacciones en WebPortal
					 * con pago cargo a factura.*/
					final TopUpBusiness topUpBusiness = new TopUpBusiness();
					final ValidaMontosVO validaMontosVO= fillValidaMontos(commercialConfigurationVO.getDn());
					if (validaMontosVO == null){
						continue;
					}
					final String cadenaJsonAmountResquest = topUpBusiness.getWebPortalAmounts(new Gson().toJson(validaMontosVO));
					LOGGER.info("Request getWebPortalAmounts JSON: -"+cadenaJsonAmountResquest+"-");
					final ResponseVO responseAmount = new Gson().fromJson(cadenaJsonAmountResquest, ResponseVO.class);
					if(responseAmount.getCode().equals(ATTConstants.CODIGO_EXITO)){
						if(responseAmount.getObjectResponse() == null || !(responseAmount.getObjectResponse() instanceof String) ){
							webPortalAmountValid = true;
						}else{
							final String strAmount = (String) responseAmount.getObjectResponse();
							final double amoutWP = Double.parseDouble(strAmount);
							if(amoutWP < Double.parseDouble(ATTConstants.MAX_CHARGE_BILL)){
								webPortalAmountValid = true;
							}
							
						}
					}
					
					if(webPortalAmountValid){
						/*validateBillByDNMobile*/
						/*Este metodo valida si el cliente cuenta con al menos una factura pagada*/
						/*Si el cliente no cuenta con al menos una factura pagada la opcion de Cargo a Factura no debe estar disponible*/
						commercialConfigurationVO.setDn("52"+commercialConfigurationVO.getDn());
						final String cadenaJsonBillResquest = topUpBusiness.validateBillByDN(new Gson().toJson(commercialConfigurationVO));
						LOGGER.info("Request validateBillByDN JSON: -"+cadenaJsonBillResquest+"-");
						final ResponseVO responseBillVO = new Gson().fromJson(cadenaJsonBillResquest, ResponseVO.class);
						if(responseBillVO.getCode().equals(ATTConstants.CODIGO_EXITO)){
							billValid = true;
						}
						
						//Se obtiene numero de contratos hermanos
						final ContratosWPPPSoapProxy webService = ContratosWPPPSoapServices.getContratosWPPPSoapServices();
						final DeviceVO deviceVO = new DeviceVO();
						deviceVO.setDn(commercialConfigurationVO.getDn());
						
						final Integer numContracts = webService.cuentaContratosHermanosDn(deviceVO);
						LOGGER.info("numContracts:"+numContracts);
						if (numContracts <= ATTConstants.NUM_MAX_CONTR){
							contractsValid = true;
						}
					}
					if (webPortalAmountValid && billValid && contractsValid){
						LOGGER.info("listPaymentTypeWPVO.add("+i+")");
						listPaymentTypeWPVO.add(paymentTypeWPVO[i]);
					}
				}else{
					LOGGER.info("listPaymentTypeWPVO.add("+i+")");
					listPaymentTypeWPVO.add(paymentTypeWPVO[i]);
				}
			}
			filterPaymentTypeWPVO = new PaymentTypeWPVO[listPaymentTypeWPVO.size()];
			for(int i=0; i < filterPaymentTypeWPVO.length; i++){
				filterPaymentTypeWPVO[i] = listPaymentTypeWPVO.get(i);
			}
		}catch(NullPointerException e){
			LOGGER.error("Ocurrio un error en el metodo filterPaymentTypeBillingCharge de la clase CommercialConfigBusiness: ",e);
		} catch (WPPPntException e) {
			LOGGER.error("Ocurrio un error en el metodo filterPaymentTypeBillingCharge de la clase CommercialConfigBusiness: ",e);
		} catch (RemoteException e) {
			LOGGER.error("Ocurrio un error en el metodo filterPaymentTypeBillingCharge de la clase CommercialConfigBusiness: ",e);
		}
		
		return filterPaymentTypeWPVO;
	}
	private ValidaMontosVO fillValidaMontos (String telefono){
		LOGGER.error("fillValidaMontos *-"+telefono+"-*");
		final ValidaMontosVO validaMontosVO = new ValidaMontosVO();
			
		validaMontosVO.setId_estatus(""+ATTConstants.ESTATUS_TRANS_WP_EXITO);
		validaMontosVO.setMdn(telefono);
		final LoginDAO loginDAO = new LoginDAOImpl();
		final CustomerVO foundCustomer = loginDAO.getCustomerInfo("52" + telefono);
		
		if (foundCustomer == null){
			return null;
		}
		
		final Calendar today = Calendar.getInstance();
		final Date now = today.getTime();
		final StringBuffer cycleInit = new StringBuffer();
		final StringBuffer cycleEnd = new StringBuffer();
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		if(foundCustomer.getContractVO().getBchRunDate().get(Calendar.DAY_OF_MONTH) <= today.get(Calendar.DAY_OF_MONTH)){

			today.set(Calendar.DAY_OF_MONTH, foundCustomer.getContractVO().getBchRunDate().get(Calendar.DAY_OF_MONTH));
			today.add(Calendar.MONTH, 1);
			today.add(Calendar.DATE, -1);
			cycleEnd.append(dateFormat.format(today.getTime()));			

			today.setTime(now);
			today.set(Calendar.DAY_OF_MONTH, foundCustomer.getContractVO().getBchRunDate().get(Calendar.DAY_OF_MONTH));
			cycleInit.append(dateFormat.format(today.getTime()));

		} else {

			today.set(Calendar.DAY_OF_MONTH, foundCustomer.getContractVO().getBchRunDate().get(Calendar.DAY_OF_MONTH));
			today.add(Calendar.DATE, -1);
			cycleEnd.append(dateFormat.format(today.getTime()));

			today.setTime(now);
			today.set(Calendar.DAY_OF_MONTH, foundCustomer.getContractVO().getBchRunDate().get(Calendar.DAY_OF_MONTH));
			today.add(Calendar.MONTH, -1);
			cycleInit.append(dateFormat.format(today.getTime()));

		}
		validaMontosVO.setFecha_inicio(cycleInit.toString());
		validaMontosVO.setFecha_fin(cycleEnd.toString());

		return validaMontosVO;
	}
}