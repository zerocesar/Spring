package mx.com.att.business;

import java.rmi.RemoteException;

import mx.com.att.business.call.CallServicesMiIusacell;
import mx.com.att.dao.LoginDAO;
import mx.com.att.dao.LoginDAOImpl;
import mx.com.att.support.ContratosWPPPSoapServices;
import mx.com.att.support.LdapSoapServices;
import mx.com.att.utils.ATTConstants;
import mx.com.att.utils.CryptoHelper;
import mx.com.att.utils.MD5;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.LoginRecordVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.amdocs.ContactPerson;
import mx.com.att.vo.orange.BalanceInquiryVO;
import mx.com.att.vo.orange.PaymentBillVO;
import mx.com.att.vo.orange.ServiceWPVO;
import mx.com.att.vo.red.LoginVO;
import mx.com.nextel.www.wppp.ws.contratos.ContratosWPPPSoapProxy;
import mx.com.nextel.www.wppp.ws.vo.DeviceVO;
import mx.com.nextel.www.ws.vo.ConsultaMonederosVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import aut.soa.nextel.mx.com.ws.LdapServiceBindingStub;

public class LoginBusiness {

	private static final Logger LOGGER = Logger.getLogger(LoginBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();	
	
	public String validateLogin(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateLogin de la clase LoginBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final CustomerVO customerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class);
		
		try {
			VALIDATOR.validateDN10(customerVO.getUser());
			VALIDATOR.validateEmptyString(customerVO.getLogin(), "Password");
			VALIDATOR.validateEmptyString(customerVO.getToken(), "Token");

			final int carrier = getCarrier(customerVO.getUser(), customerVO.getToken());			

			/* 5-Unefon; 7-Iusacell 190-Nextel*/
			if (carrier == ATTConstants.CARRIER_NEXTEL){ //NARANJA
				VALIDATOR.validateEmptyString(customerVO.getMyATTVersion(), "MyATTVersion");
				VALIDATOR.validateEmptyString(customerVO.getSystemId(), "SystemId");
				
				//Se busca la informacion del usuario en BSCS
				LOGGER.info("Se busca la informacion del contrato en BSCS para el DN: " + customerVO.getUser());
				final LoginDAO loginDAO = new LoginDAOImpl();
				final CustomerVO foundCustomer = loginDAO.getCustomerInfo("52" + customerVO.getUser());

				if (foundCustomer == null){
					responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_NO_ENCONT);
					responseVO.setMessageCode(ATTConstants.DESC_ERROR_NUM_NO_ENCONT);
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				} else{
					//Se asigna el carrierId
					foundCustomer.setCarrierId(190);
					foundCustomer.setSystemId(customerVO.getSystemId());
					
					//Se valida que el usuario este registrado en LDAP
					//Se crea cadena JSON para el metodo isUserLdapMovil
					final String requestIsLdap = "{\"uid\":\"" + customerVO.getUser() + "\"}";
					
					LOGGER.info("Validando si el usuario esta registrado en la BD LDAP para el DN: " + customerVO.getUser());
					LOGGER.info("requestLdap JSON: " + requestIsLdap);
					final LdapServiceBindingStub ldapProxy = LdapSoapServices.consultaProxy();
					final String responseString = ldapProxy.isUserLdapMovil(requestIsLdap);
					final ResponseVO responseLdap = new Gson().fromJson(responseString, ResponseVO.class);
					
					VALIDATOR.validateEmptyString(responseLdap.getCode(), "Codigo LDAP");
					if (responseLdap.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
						//Se obtiene informacion del registro en la BD LDAP
						//Se valida la version de MyATT
						if (customerVO.getMyATTVersion().equalsIgnoreCase(ATTConstants.VERSION_MY_ATT)){
							//Se crea JSON para metodo autenticaLdapMovil del servicio LDAP
							final String requestLdap = "{\"uid\":\"" + customerVO.getUser()
									+ "\",\"userPassword\":\"" + customerVO.getLogin()
									+ "\",\"miNextelVersion\":\"" + ATTConstants.VERSION_MY_NEXTEL + "\"}";
							LOGGER.info("requestLdap JSON: " + requestLdap);
							final String response = ldapProxy.autenticaLdapMovil(requestLdap);
							
							final LoginRecordVO loginRecordVO = new Gson().fromJson(response, LoginRecordVO.class);
							
							if (VALIDATOR.validateGetCode(loginRecordVO.getError(), ATTConstants.CODIGO_EXITO) || VALIDATOR.validateGetCode(loginRecordVO.getRespuesta(), ATTConstants.LDAP44)){
								foundCustomer.setLoginRecordVO(loginRecordVO);
								
								//Se obtiene la informacion de monederos
								if (foundCustomer.getContractVO().getContractTypeId().equalsIgnoreCase(ATTConstants.PREPAGO)){
									//Si es PREPAGO
									final ShareBusiness shareBusiness = new ShareBusiness();
									final ConsultaMonederosVO consultaMonederos = new ConsultaMonederosVO();
									consultaMonederos.setDn((foundCustomer.getUser().length() == 12) ? foundCustomer.getUser().substring(2) : foundCustomer.getUser());
									consultaMonederos.setIdSistema(foundCustomer.getSystemId());
									
									final BalanceInquiryVO balanceInquiryVO = shareBusiness.getCustomerBalanceIncluded(consultaMonederos);
									
									if (balanceInquiryVO == null || balanceInquiryVO.getBalancesIncluded() == null || balanceInquiryVO.getBalancesIncluded().isEmpty()){
										LOGGER.info("No se encontraron monederos.");
									} else{
										final BalanceInquiryVO balanceInquiry = new BalanceInquiryVO(); 
										balanceInquiry.setCurrentBalances(balanceInquiryVO.getBalancesIncluded());
										foundCustomer.setBalanceInquiryVO(balanceInquiry);
									}
								} else{
									//Si es POSTPAGO o HIBRIDO
									final PocketsBusiness pocketsBusiness = new PocketsBusiness();
									final String responsePockets = pocketsBusiness.consultaTopesMonederos(new Gson().toJson(foundCustomer));
									final ResponseVO responsePocketsVO = new Gson().fromJson(responsePockets, ResponseVO.class);
									
									if (responsePocketsVO == null || responsePocketsVO.getCode() == null || responsePocketsVO.getObjectResponse() == null){
										LOGGER.info("No se encontraron monederos.");
									} else if(responsePocketsVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
										foundCustomer.setBalanceInquiryVO(new Gson().fromJson(new Gson().toJson(responsePocketsVO.getObjectResponse()), BalanceInquiryVO.class));
									}
								}
								
								//Se obtiene la lista de servicios
								final CommercialConfigBusiness commercialConfigBusiness = new CommercialConfigBusiness();
								final String responseCommConfig = commercialConfigBusiness.getServiceList(new Gson().toJson(foundCustomer));
								final ResponseVO responseCommConfigVO = new Gson().fromJson(responseCommConfig, ResponseVO.class);
								
								if (responseCommConfigVO == null || responseCommConfigVO.getCode() == null || responseCommConfigVO.getObjectResponse() == null){
									LOGGER.info("No se encontro la lista de servicios.");
								} else if(responseCommConfigVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
									foundCustomer.setServiceWPVO(new Gson().fromJson(new Gson().toJson(responseCommConfigVO.getObjectResponse()), ServiceWPVO[].class));
								}
								
								//Se obtiene el saldo de la cuenta
								final CustomersBusiness customersBusiness = new CustomersBusiness();
								final String responseCustomerBusiness = customersBusiness.saldoFacturasCuenta(new Gson().toJson(foundCustomer));
								final ResponseVO responseCustomerBusinessVO = new Gson().fromJson(responseCustomerBusiness, ResponseVO.class);
								
								if (responseCustomerBusinessVO == null || responseCustomerBusinessVO.getCode() == null || responseCustomerBusinessVO.getObjectResponse() == null){
									LOGGER.info("No se encontro informacion del saldo de la cuenta.");
								} else if (responseCustomerBusinessVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
									foundCustomer.setPaymentBillVO(new Gson().fromJson(new Gson().toJson(responseCustomerBusinessVO.getObjectResponse()), PaymentBillVO.class));
								}
								
								//Se obtiene el maximo de numeros frecuentes
								final FrecuentNumbersBusiness frecuentNumbersBusiness = new FrecuentNumbersBusiness();
								final String responseFrecuentNumbers = frecuentNumbersBusiness.getMaximumFrecuentsNumbersBsn(new Gson().toJson(foundCustomer));
								final ResponseVO responseFrecuentNumbersVO = new Gson().fromJson(responseFrecuentNumbers, ResponseVO.class);
								
								if (responseFrecuentNumbersVO == null || responseFrecuentNumbersVO.getCode() == null || responseFrecuentNumbersVO.getObjectResponse() == null){
									LOGGER.info("No se encontro el maximo de numeros frecuentes.");
									foundCustomer.getContractVO().setMaxFrecuentNumbers(0);
								} else if(responseFrecuentNumbersVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
									foundCustomer.getContractVO().setMaxFrecuentNumbers(Integer.parseInt((String) responseFrecuentNumbersVO.getObjectResponse()));
								}
								
								//Se valida que el DN sea de la oferta Comparte
								final ShareBusiness shareBusiness = new ShareBusiness();
								foundCustomer.getContractVO().setIsTMCODEShare(shareBusiness.isTMCODEShare(foundCustomer.getUser()));
								
								//Se obtiene numero de contratos hermanos
								final ContratosWPPPSoapProxy webService = ContratosWPPPSoapServices.getContratosWPPPSoapServices();
								final DeviceVO deviceVO = new DeviceVO();
								deviceVO.setDn(foundCustomer.getUser());
								foundCustomer.setAssociateContracts(webService.cuentaContratosHermanosDn(deviceVO));
								
								responseVO.setCode(ATTConstants.CODIGO_EXITO);
								responseVO.setMessageCode(ATTConstants.DESC_EXITO);
								responseVO.setObjectResponse(foundCustomer);
								LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
							} else if(VALIDATOR.validateGetCode(loginRecordVO.getError(), ATTConstants.CODIGO_PASS_INC) || VALIDATOR.validateGetCode(loginRecordVO.getError(), ATTConstants.CODIGO_PASS_INC2)){
								responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
								responseVO.setMessageCode((loginRecordVO.getError() == null) ? ATTConstants.DESC_ERROR_SIN_INFORMACION : loginRecordVO.getError());
								LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
							} else if(loginRecordVO.getError().contains(ATTConstants.CODIGO_PASS_TEMP)){
								responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_TEMP);
								responseVO.setMessageCode((loginRecordVO.getError() == null) ? ATTConstants.DESC_ERROR_SIN_INFORMACION : loginRecordVO.getError());
								LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
							} else{
								responseVO.setCode(ATTConstants.CODIGO_ERROR_LDAP);
								responseVO.setMessageCode((loginRecordVO.getError() == null) ? ATTConstants.DESC_ERROR_SIN_INFORMACION : loginRecordVO.getError());
								LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
							}
						} else{
							responseVO.setCode(ATTConstants.CODIGO_ERROR_VER_INCOR);
							responseVO.setMessageCode(ATTConstants.DESC_ERROR_VER_INCOR);
							LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
						}
					} else if(VALIDATOR.validateGetCode(responseLdap.getCode(), ATTConstants.LDAP50)){
						responseVO.setCode(ATTConstants.CODIGO_ERROR_NO_REGISTRO);
						responseVO.setMessageCode(ATTConstants.DESC_ERROR_NO_REGISTRO);
						LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
					} else{
						responseVO.setCode(responseLdap.getCode());
						responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
						LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
					}
				}
				
			} else if (carrier == ATTConstants.CARRIER_IUSACEL){ //ROJO
				//Se busca la informacion del usuario en BSCS
				LOGGER.info("Se busca la informacion para el DN: " + customerVO.getUser());
				CallServicesMiIusacell datosFocalizacion = new CallServicesMiIusacell();
				LoginVO loginobject = new LoginVO();

				try {
					
					VALIDATOR.validateEmptyString(customerVO.getUnidadNegocio(),"unidadNegocio");
					VALIDATOR.validateEmptyString(customerVO.getLogin(),"Login");
					
					loginobject.setConsultaOperador(datosFocalizacion.consultaOperadorExtendido("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/",customerVO.getUser() , customerVO.getToken()));
					loginobject.setLogin(datosFocalizacion.login("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser()+"10", MD5.getMD5(customerVO.getLogin()), customerVO.getUnidadNegocio(), customerVO.getToken())); 

					LOGGER.info("Response Login" + loginobject.getLogin());
					
					if(loginobject.getLogin().equals(ATTConstants.CODIGO_EXITO_LOGIN)){
	  					loginobject.setDatosFocalizacionVo(datosFocalizacion.focalizacion("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(), customerVO.getToken()));
						loginobject.setConfiguracionXUsuario(datosFocalizacion.getConfiguracionXUsuarioMovil("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(), customerVO.getToken()));
						loginobject.setListPermisosCliente(datosFocalizacion.getPermisosXcliente("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(),  customerVO.getToken()));
						final CustomerVO customer = new CustomerVO();
						customer.setCarrierId(ATTConstants.CARRIER_IUSACEL);
						customer.setLoginVO(loginobject);
						
						responseVO.setCode(ATTConstants.CODIGO_EXITO);
						responseVO.setMessageCode(ATTConstants.DESC_EXITO);
						responseVO.setObjectResponse(customer);
						
						//LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
						
					}else{
						responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
						responseVO.setMessageCode(ATTConstants.DESC_ERROR_NUM_INV);
						responseVO.setObjectResponse(loginobject.getLogin());
						LOGGER.info("Numero invalido " + loginobject.getLogin());
					}
					
				} catch (Exception e) {
					responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
					responseVO.setMessageCode(ATTConstants.DESC_ERROR_NUM_INV);
					LOGGER.info("Problemas al consultar la informacion del usuario");
				}
				
			}else if(carrier==280){
				ContactPerson person= new ContactPerson();
				person.setName("Emiliano");
				person.setFirstName("Zapata");
				person.setLastName("Sanchez");
				person.setPersonID("0003");
				person.setPhone("5519515478");
				
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(person);			
				
				
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_NUM_INV);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
			
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} 
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	private int getCarrier(final String telephoneNumber, final String token) {

		//Invocacion al servicio de IUSA que indica que carrier es el DN
		int idOperador = ATTConstants.VAL_CERO;
		
		try {
			final OperadorBusiness operador = new OperadorBusiness();
			final String sResponse = operador.consultaOperador(telephoneNumber, token);
			
			if(sResponse != null && !sResponse.equals("")) {
				idOperador =  Integer.parseInt(sResponse);
			}
		} catch (Exception exception) {
			LOGGER.error("Ocurrio una Excepcion al llamar los servicios de Iusacel: " + exception.getMessage());
		}
		
		return idOperador;
	}

	public String addUser(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo addUser de la clase LoginBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final LoginRecordVO loginRecordVO = new Gson().fromJson(jsonDecrypted, LoginRecordVO.class);
		
		try {
			VALIDATOR.validateEmptyString(loginRecordVO.getBusinessCategory(), "BusinessCategory");
			VALIDATOR.validateEmptyString(loginRecordVO.getCommonName(), "CommonName");
			VALIDATOR.validateEmptyString(loginRecordVO.getDescription(), "Description");
			VALIDATOR.validateEmptyString(loginRecordVO.getEmployeeType(), "EmployeeType");
			VALIDATOR.validateEmptyString(loginRecordVO.getGivenName(), "GivenName");
			VALIDATOR.validateEmptyString(loginRecordVO.getInitials(), "Initials");
			VALIDATOR.validateEmptyString(loginRecordVO.getLastName(), "LastName");
			VALIDATOR.validateEmptyString(loginRecordVO.getMail(), "Mail");
			VALIDATOR.validateEmptyString(loginRecordVO.getUid(), "Uid");
			VALIDATOR.validateEmptyString(loginRecordVO.getUserPassword(), "UserPassword");
			
			/*if(loginRecordVO.getDescription().equalsIgnoreCase("@")){*/
				final LdapServiceBindingStub ldapProxy = LdapSoapServices.consultaProxy();
				final String responseLdap = ldapProxy.addUserLdapMovil(jsonDecrypted);
				final LoginRecordVO responseLoginRecordVO = new Gson().fromJson(responseLdap, LoginRecordVO.class);
				
				if (responseLoginRecordVO == null){
					responseVO.setCode(ATTConstants.CODIGO_ERROR_LDAP);
					responseVO.setMessageCode(ATTConstants.DESC_SISTEMA_NO_DISPONIBLE);
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				} else if (VALIDATOR.validateGetCode(responseLoginRecordVO.getError(), ATTConstants.CODIGO_EXITO) || VALIDATOR.validateGetCode(responseLoginRecordVO.getRespuesta(), ATTConstants.CODIGO_EXITO) || VALIDATOR.validateGetCode(responseLoginRecordVO.getRespuesta(), ATTConstants.LDAP02)){
					responseVO.setCode(ATTConstants.CODIGO_EXITO);
					responseVO.setMessageCode(ATTConstants.DESC_EXITO);
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				} else{
					responseVO.setCode(ATTConstants.CODIGO_ERROR_LDAP);
					responseVO.setMessageCode(responseLoginRecordVO.getError());
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				}
			/*}else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_LDAP);
				responseVO.setMessageCode(ATTConstants.DESC_INCORRECT_OPERATION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}*/
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String changeUser(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo changePasswordUser de la clase LoginBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final LoginRecordVO loginRecordVO = new Gson().fromJson(jsonDecrypted, LoginRecordVO.class);
		
		try {
			VALIDATOR.validateEmptyString(loginRecordVO.getBusinessCategory(), "BusinessCategory");
			VALIDATOR.validateEmptyString(loginRecordVO.getCommonName(), "CommonName");
			VALIDATOR.validateEmptyString(loginRecordVO.getDescription(), "Description");
			VALIDATOR.validateEmptyString(loginRecordVO.getEmployeeType(), "EmployeeType");
			VALIDATOR.validateEmptyString(loginRecordVO.getGivenName(), "GivenName");
			VALIDATOR.validateEmptyString(loginRecordVO.getInitials(), "Initials");
			VALIDATOR.validateEmptyString(loginRecordVO.getLastName(), "LastName");
			VALIDATOR.validateEmptyString(loginRecordVO.getMail(), "Mail");
			VALIDATOR.validateEmptyString(loginRecordVO.getUid(), "Uid");
			VALIDATOR.validateEmptyString(loginRecordVO.getUserPassword(), "UserPassword");
			
			if (loginRecordVO.getDescription().equalsIgnoreCase("@")){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_LDAP);
				responseVO.setMessageCode(ATTConstants.DESC_INCORRECT_OPERATION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else{
				final LdapServiceBindingStub ldapProxy = LdapSoapServices.consultaProxy();
				String currentPassword = loginRecordVO.getUserPassword();
				if(loginRecordVO.getOldPassword()!=null){
					currentPassword = loginRecordVO.getOldPassword();
				}
				final LoginDAO loginDAO = new LoginDAOImpl();
				final String userPassLdap = loginDAO.getDecriptedPassword(loginRecordVO.getUid()); 
				if (userPassLdap == null){
					responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
					responseVO.setMessageCode(ATTConstants.DESC_PASSWORD_INCORRECT);
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				}else if (currentPassword.equals(CryptoHelper.decrypt(userPassLdap))){
						final String responseLdap = ldapProxy.addUserLdapMovil(jsonDecrypted);
						final LoginRecordVO responseLoginRecordVO = new Gson().fromJson(responseLdap, LoginRecordVO.class);
						
						if (responseLoginRecordVO == null){
							responseVO.setCode(ATTConstants.CODIGO_ERROR_LDAP);
							responseVO.setMessageCode(ATTConstants.DESC_SISTEMA_NO_DISPONIBLE);
							LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
						} else if (VALIDATOR.validateGetCode(responseLoginRecordVO.getError(), ATTConstants.CODIGO_EXITO) || VALIDATOR.validateGetCode(responseLoginRecordVO.getRespuesta(), ATTConstants.CODIGO_EXITO) || VALIDATOR.validateGetCode(responseLoginRecordVO.getRespuesta(), ATTConstants.LDAP02)){
							responseVO.setCode(ATTConstants.CODIGO_EXITO);
							responseVO.setMessageCode(ATTConstants.DESC_EXITO);
							LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
						} else{
							responseVO.setCode(ATTConstants.CODIGO_ERROR_LDAP);
							responseVO.setMessageCode(responseLoginRecordVO.getError());
							LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
						}
				}else{
					responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
					responseVO.setMessageCode(ATTConstants.DESC_PASSWORD_INCORRECT);
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				}
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String generatePasswordLdap(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo generatePasswordLdap de la clase LoginBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final LoginRecordVO loginRecordVO = new Gson().fromJson(jsonDecrypted, LoginRecordVO.class);
		
		try {
			VALIDATOR.validateEmptyString(loginRecordVO.getUid(), "Uid");
			
			final LdapServiceBindingStub ldapProxy = LdapSoapServices.consultaProxy();
			final String responseLdap = ldapProxy.generaPasswordLdapMovil(jsonDecrypted);
			
			final ResponseVO responseLoginRecordVO = new Gson().fromJson(responseLdap, ResponseVO.class);
			
			if (responseLoginRecordVO == null || responseLoginRecordVO.getCode() == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_LDAP);
				responseVO.setMessageCode(ATTConstants.DESC_SISTEMA_NO_DISPONIBLE);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if (responseLoginRecordVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_LDAP);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String serachInfoUserLdap(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo serachInfoUserLdap de la clase LoginBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final LoginRecordVO loginRecordVO = new Gson().fromJson(jsonDecrypted, LoginRecordVO.class);
		
		try {
			VALIDATOR.validateEmptyString(loginRecordVO.getUid(), "Uid");
			
			final LdapServiceBindingStub ldapProxy = LdapSoapServices.consultaProxy();
			final String responseLdap = ldapProxy.searchInfoUserLdapMovil(jsonDecrypted);
			
			final LoginRecordVO responseLoginRecordVO = new Gson().fromJson(responseLdap, LoginRecordVO.class);
			
			if (VALIDATOR.validateGetCode(responseLoginRecordVO.getError(), ATTConstants.CODIGO_EXITO) || VALIDATOR.validateGetCode(responseLoginRecordVO.getError(), ATTConstants.LDAP44)){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(responseLoginRecordVO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NO_REGISTRO);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_NO_REGISTRO);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String getCarrier(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo serachInfoUserLdap de la clase LoginBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final CustomerVO customerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class);
		
		try {
			VALIDATOR.validateEmptyString(customerVO.getUser(), "Usuario");
			
			final int idCarrier = getCarrier(customerVO.getUser(), null);
			
			if (idCarrier == ATTConstants.CARRIER_NEXTEL){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_CARRIER_NEXTEL);
				responseVO.setObjectResponse(idCarrier);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else if(idCarrier == ATTConstants.CARRIER_IUSACEL){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_CARRIER_IUSACEL);
				responseVO.setObjectResponse(idCarrier);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}else if(idCarrier == ATTConstants.CARRIER_AMDOCS){
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_CARRIER_AMDOCS);
				responseVO.setObjectResponse(idCarrier);				
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_NUM_INV);
				responseVO.setObjectResponse(idCarrier);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String getCustomerFromDN(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getCustomerFromDN de la clase LoginBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		final CustomerVO customerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class);
		
		try {
			VALIDATOR.validateEmptyString(customerVO.getUser(), "Usuario");
			
			final LoginDAO loginDAO = new LoginDAOImpl();
			final CustomerVO foundCustomer = loginDAO.getCustomerInfo("52" + customerVO.getUser());

			if (foundCustomer == null){
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_NO_ENCONT);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_NUM_NO_ENCONT);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			} else{
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(foundCustomer);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String validateLoginSplit(final String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateLogin de la clase LoginBusiness");
		final String jsonDecrypted = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonDecrypted);
		
		final ResponseVO responseVO = new ResponseVO();
		
		final CustomerVO customerVO = new Gson().fromJson(jsonDecrypted, CustomerVO.class);
		
		try {
			VALIDATOR.validateDN10(customerVO.getUser());
			VALIDATOR.validateEmptyString(customerVO.getLogin(), "Password");
			VALIDATOR.validateEmptyString(customerVO.getToken(), "Token");

			final int carrier = getCarrier(customerVO.getUser(), customerVO.getToken());			

			/* 5-Unefon; 7-Iusacell 190-Nextel*/
			if (carrier == ATTConstants.CARRIER_NEXTEL){ //NARANJA
				VALIDATOR.validateEmptyString(customerVO.getMyATTVersion(), "MyATTVersion");
				VALIDATOR.validateEmptyString(customerVO.getSystemId(), "SystemId");
				
				//Se busca la informacion del usuario en BSCS
				LOGGER.info("Se busca la informacion del contrato en BSCS para el DN: " + customerVO.getUser());
				final LoginDAO loginDAO = new LoginDAOImpl();
				final CustomerVO foundCustomer = loginDAO.getCustomerInfo("52" + customerVO.getUser());

				if (foundCustomer == null){
					responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_NO_ENCONT);
					responseVO.setMessageCode(ATTConstants.DESC_ERROR_NUM_NO_ENCONT);
					LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
				} else{
					//Se asigna el carrierId
					foundCustomer.setCarrierId(190);
					foundCustomer.setSystemId(customerVO.getSystemId());
					
					//Se valida que el usuario este registrado en LDAP
					//Se crea cadena JSON para el metodo isUserLdapMovil
					final String requestIsLdap = "{\"uid\":\"" + customerVO.getUser() + "\"}";
					
					LOGGER.info("Validando si el usuario esta registrado en la BD LDAP para el DN: " + customerVO.getUser());
					LOGGER.info("requestLdap JSON: " + requestIsLdap);
					final LdapServiceBindingStub ldapProxy = LdapSoapServices.consultaProxy();
					final String responseString = ldapProxy.isUserLdapMovil(requestIsLdap);
					final ResponseVO responseLdap = new Gson().fromJson(responseString, ResponseVO.class);
					
					VALIDATOR.validateEmptyString(responseLdap.getCode(), "Codigo LDAP");
					if (responseLdap.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
						//Se obtiene informacion del registro en la BD LDAP
						//Se valida la version de MyATT
						if (customerVO.getMyATTVersion().equalsIgnoreCase(ATTConstants.VERSION_MY_ATT)){
							//Se crea JSON para metodo autenticaLdapMovil del servicio LDAP
							final String requestLdap = "{\"uid\":\"" + customerVO.getUser()
									+ "\",\"userPassword\":\"" + customerVO.getLogin()
									+ "\",\"miNextelVersion\":\"" + ATTConstants.VERSION_MY_NEXTEL + "\"}";
							LOGGER.info("requestLdap JSON: " + requestLdap);
							final String response = ldapProxy.autenticaLdapMovil(requestLdap);
							
							final LoginRecordVO loginRecordVO = new Gson().fromJson(response, LoginRecordVO.class);
							
							if (VALIDATOR.validateGetCode(loginRecordVO.getError(), ATTConstants.CODIGO_EXITO) || VALIDATOR.validateGetCode(loginRecordVO.getRespuesta(), ATTConstants.LDAP44)){
								foundCustomer.setLoginRecordVO(loginRecordVO);
								
								//Se obtiene la informacion de monederos
								if (foundCustomer.getContractVO().getContractTypeId().equalsIgnoreCase(ATTConstants.PREPAGO)){
									//Si es PREPAGO
									final ShareBusiness shareBusiness = new ShareBusiness();
									final ConsultaMonederosVO consultaMonederos = new ConsultaMonederosVO();
									consultaMonederos.setDn((foundCustomer.getUser().length() == 12) ? foundCustomer.getUser().substring(2) : foundCustomer.getUser());
									consultaMonederos.setIdSistema(foundCustomer.getSystemId());
									
									final BalanceInquiryVO balanceInquiryVO = shareBusiness.getCustomerBalanceIncluded(consultaMonederos);
									
									if (balanceInquiryVO == null || balanceInquiryVO.getBalancesIncluded() == null || balanceInquiryVO.getBalancesIncluded().isEmpty()){
										LOGGER.info("No se encontraron monederos.");
									} else{
										final BalanceInquiryVO balanceInquiry = new BalanceInquiryVO(); 
										balanceInquiry.setCurrentBalances(balanceInquiryVO.getBalancesIncluded());
										foundCustomer.setBalanceInquiryVO(balanceInquiry);
									}
								} else{
									//Si es POSTPAGO o HIBRIDO
									final PocketsBusiness pocketsBusiness = new PocketsBusiness();
									final String responsePockets = pocketsBusiness.consultaTopesMonederos(new Gson().toJson(foundCustomer));
									final ResponseVO responsePocketsVO = new Gson().fromJson(responsePockets, ResponseVO.class);
									
									if (responsePocketsVO == null || responsePocketsVO.getCode() == null || responsePocketsVO.getObjectResponse() == null){
										LOGGER.info("No se encontraron monederos.");
									} else if(responsePocketsVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
										foundCustomer.setBalanceInquiryVO(new Gson().fromJson(new Gson().toJson(responsePocketsVO.getObjectResponse()), BalanceInquiryVO.class));
									}
								}
								
								//Se obtiene la lista de servicios
								final CommercialConfigBusiness commercialConfigBusiness = new CommercialConfigBusiness();
								final String responseCommConfig = commercialConfigBusiness.getServiceList(new Gson().toJson(foundCustomer));
								final ResponseVO responseCommConfigVO = new Gson().fromJson(responseCommConfig, ResponseVO.class);
								
								if (responseCommConfigVO == null || responseCommConfigVO.getCode() == null || responseCommConfigVO.getObjectResponse() == null){
									LOGGER.info("No se encontro la lista de servicios.");
								} else if(responseCommConfigVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
									foundCustomer.setServiceWPVO(new Gson().fromJson(new Gson().toJson(responseCommConfigVO.getObjectResponse()), ServiceWPVO[].class));
								}
								
								//Se obtiene el saldo de la cuenta
								final CustomersBusiness customersBusiness = new CustomersBusiness();
								final String responseCustomerBusiness = customersBusiness.saldoFacturasCuenta(new Gson().toJson(foundCustomer));
								final ResponseVO responseCustomerBusinessVO = new Gson().fromJson(responseCustomerBusiness, ResponseVO.class);
								
								if (responseCustomerBusinessVO == null || responseCustomerBusinessVO.getCode() == null || responseCustomerBusinessVO.getObjectResponse() == null){
									LOGGER.info("No se encontro informacion del saldo de la cuenta.");
								} else if (responseCustomerBusinessVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
									foundCustomer.setPaymentBillVO(new Gson().fromJson(new Gson().toJson(responseCustomerBusinessVO.getObjectResponse()), PaymentBillVO.class));
								}
								
								//Se obtiene el maximo de numeros frecuentes
								final FrecuentNumbersBusiness frecuentNumbersBusiness = new FrecuentNumbersBusiness();
								final String responseFrecuentNumbers = frecuentNumbersBusiness.getMaximumFrecuentsNumbersBsn(new Gson().toJson(foundCustomer));
								final ResponseVO responseFrecuentNumbersVO = new Gson().fromJson(responseFrecuentNumbers, ResponseVO.class);
								
								if (responseFrecuentNumbersVO == null || responseFrecuentNumbersVO.getCode() == null || responseFrecuentNumbersVO.getObjectResponse() == null){
									LOGGER.info("No se encontro el maximo de numeros frecuentes.");
									foundCustomer.getContractVO().setMaxFrecuentNumbers(0);
								} else if(responseFrecuentNumbersVO.getCode().equalsIgnoreCase(ATTConstants.CODIGO_EXITO)){
									foundCustomer.getContractVO().setMaxFrecuentNumbers(Integer.parseInt((String) responseFrecuentNumbersVO.getObjectResponse()));
								}
								
								//Se valida que el DN sea de la oferta Comparte
								final ShareBusiness shareBusiness = new ShareBusiness();
								foundCustomer.getContractVO().setIsTMCODEShare(shareBusiness.isTMCODEShare(foundCustomer.getUser()));
								
								//Se obtiene numero de contratos hermanos
								final ContratosWPPPSoapProxy webService = ContratosWPPPSoapServices.getContratosWPPPSoapServices();
								final DeviceVO deviceVO = new DeviceVO();
								deviceVO.setDn(foundCustomer.getUser());
								foundCustomer.setAssociateContracts(webService.cuentaContratosHermanosDn(deviceVO));
								
								responseVO.setCode(ATTConstants.CODIGO_EXITO);
								responseVO.setMessageCode(ATTConstants.DESC_EXITO);
								responseVO.setObjectResponse(foundCustomer);
								LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
							} else if(VALIDATOR.validateGetCode(loginRecordVO.getError(), ATTConstants.CODIGO_PASS_INC) || VALIDATOR.validateGetCode(loginRecordVO.getError(), ATTConstants.CODIGO_PASS_INC2)){
								responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_INC);
								responseVO.setMessageCode((loginRecordVO.getError() == null) ? ATTConstants.DESC_ERROR_SIN_INFORMACION : loginRecordVO.getError());
								LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
							} else if(loginRecordVO.getError().contains(ATTConstants.CODIGO_PASS_TEMP)){
								responseVO.setCode(ATTConstants.CODIGO_ERROR_PASS_TEMP);
								responseVO.setMessageCode((loginRecordVO.getError() == null) ? ATTConstants.DESC_ERROR_SIN_INFORMACION : loginRecordVO.getError());
								LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
							} else{
								responseVO.setCode(ATTConstants.CODIGO_ERROR_LDAP);
								responseVO.setMessageCode((loginRecordVO.getError() == null) ? ATTConstants.DESC_ERROR_SIN_INFORMACION : loginRecordVO.getError());
								LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
							}
						} else{
							responseVO.setCode(ATTConstants.CODIGO_ERROR_VER_INCOR);
							responseVO.setMessageCode(ATTConstants.DESC_ERROR_VER_INCOR);
							LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
						}
					} else if(VALIDATOR.validateGetCode(responseLdap.getCode(), ATTConstants.LDAP50)){
						responseVO.setCode(ATTConstants.CODIGO_ERROR_NO_REGISTRO);
						responseVO.setMessageCode(ATTConstants.DESC_ERROR_NO_REGISTRO);
						LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
					} else{
						responseVO.setCode(responseLdap.getCode());
						responseVO.setMessageCode(ATTConstants.DESC_ERROR_SIN_INFORMACION);
						LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
					}
				}
				
			} else if (carrier == ATTConstants.CARRIER_IUSACEL){ //ROJO
				//Se busca la informacion del usuario en BSCS
				LOGGER.info("Se busca la informacion para el DN: " + customerVO.getUser());
				CallServicesMiIusacell datosFocalizacion = new CallServicesMiIusacell();
				LoginVO loginobject = new LoginVO();

				try {
					
					VALIDATOR.validateEmptyString(customerVO.getUnidadNegocio(),"unidadNegocio");
					VALIDATOR.validateEmptyString(customerVO.getLogin(),"Login");
										
					loginobject.setLogin(datosFocalizacion.login("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser()+"10", MD5.getMD5(customerVO.getLogin()), customerVO.getUnidadNegocio(), customerVO.getToken())); 

					LOGGER.info("Response Login" + loginobject.getLogin());
					
					if(loginobject.getLogin().equals(ATTConstants.CODIGO_EXITO_LOGIN)){
						
						final CustomerVO customer = new CustomerVO();
						customer.setCarrierId(ATTConstants.CARRIER_IUSACEL);
						customer.setLoginVO(loginobject);
						
						responseVO.setCode(ATTConstants.CODIGO_EXITO);
						responseVO.setMessageCode(ATTConstants.DESC_EXITO);
						responseVO.setObjectResponse(customer);
						
						//LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
						
					}else{
						responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
						responseVO.setMessageCode(ATTConstants.DESC_ERROR_NUM_INV);
						responseVO.setObjectResponse(loginobject.getLogin());
						LOGGER.info("Numero invalido " + loginobject.getLogin());
					}
					
				} catch (Exception e) {
					responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
					responseVO.setMessageCode(ATTConstants.DESC_ERROR_NUM_INV);
					LOGGER.info("Problemas al consultar la informacion del usuario");
				}
				
			} else{
				responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
				responseVO.setMessageCode(ATTConstants.DESC_ERROR_NUM_INV);
				LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			}
			
			
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} catch (RemoteException remoteException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_REMOTE_EXCEPTION);
			responseVO.setMessageCode(VALIDATOR.validateRemoteException(remoteException));
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		} 
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}		
}