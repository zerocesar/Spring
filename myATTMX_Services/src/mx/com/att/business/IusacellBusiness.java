package mx.com.att.business;


import java.util.List;

import mx.com.att.business.call.CallServicesMiIusacell;
import mx.com.att.utils.ATTConstants;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.red.AbonoTiempoAireVO;
import mx.com.att.vo.red.CatalogoAbonos;
import mx.com.att.vo.red.CatalogoMovilCaeVO;
import mx.com.att.vo.red.ClienteRegistroVO;
import mx.com.att.vo.red.ConsultaWalletGeneralVO;
import mx.com.att.vo.red.ContratarServiciosVO;
import mx.com.att.vo.red.DetalleFacturaVO;
import mx.com.att.vo.red.DetalleSaldoVO;
import mx.com.att.vo.red.LoginRegisterBean;
import mx.com.att.vo.red.LoginVO;
import mx.com.att.vo.red.MensajeMailVO;
import mx.com.att.vo.red.NumerosFrecuentesVO;
import mx.com.att.vo.red.OperacionVO;
import mx.com.att.vo.red.PagoFacturaResponseVO;
import mx.com.att.vo.red.ServiciosAdicionalesVO;
import mx.com.att.vo.red.ServiciosBundlesAdicionales;
import mx.com.att.vo.red.TarjetasFrecuentesVO;
import mx.com.att.vo.red.WalletsDetalleVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class IusacellBusiness {

	private static final Logger LOGGER = Logger.getLogger(IusacellBusiness.class);
	private static final ValidatorATT VALIDATOR = new ValidatorATT();
	
	
	public String obtieneInformacionLlamadas(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		
		LOGGER.info("Comienza la ejecucion del metodo obtieneInformacionLlamadas de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell datosFocalizacion = new CallServicesMiIusacell();
		
		LoginVO loginobject = new LoginVO();
		
		try {
			
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			
			try {
				loginobject.setTotalesLlamadasVo(datosFocalizacion.walletsTotalLlamadas("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(), customerVO.getToken()));
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(loginobject);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	
	public String obtieneInformacionMensajes(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		
		LOGGER.info("Comienza la ejecucion del metodo obtieneInformacionMensajes de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell datosFocalizacion = new CallServicesMiIusacell();
		
		LoginVO loginobject = new LoginVO();
		
		try {
			
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			
			try {
				loginobject.setMensajesVo(datosFocalizacion.walletsTotalMensajes("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(), customerVO.getToken()));
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(loginobject);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	
	public String obtieneInformacionNavegacion(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		
		LOGGER.info("Comienza la ejecucion del metodo obtieneInformacionNavegacion de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell datosFocalizacion = new CallServicesMiIusacell();
		
		LoginVO loginobject = new LoginVO();
		
		try {
			
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			
			try {
				 
				 loginobject.setNavegacionvo(datosFocalizacion.walletsTotalNavegacion("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(), customerVO.getToken()));
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(loginobject);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String obtieneNumeroFacturas(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		
		LOGGER.info("Comienza la ejecucion del metodo obtieneNumeroFacturas de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell datosFocalizacion = new CallServicesMiIusacell();
		
		LoginVO loginobject = new LoginVO();
		
		try {
			
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			VALIDATOR.validateEmptyString(customerVO.getNumFacturas(),"numeroFacturas");
			
			
			try {
				loginobject.setDatosFacturas(datosFocalizacion.getFacturas("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(),customerVO.getNumFacturas(), customerVO.getToken()));

			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(loginobject);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	
	public String actualizafotografia(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		
		LOGGER.info("Comienza la ejecucion del metodo actualizafotografia de la clase IusacellBusiness");
				
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell datosFocalizacion = new CallServicesMiIusacell();
		
		String regresa="";
		
		try {
			
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			if(customerVO.getDatosCliente() == null) 
				throw new ValidateException("El campo datosCliente esta vacio o nulo.");
			VALIDATOR.validateEmptyString(customerVO.getDatosCliente().getFoto(),"foto");
			VALIDATOR.validateEmptyString(customerVO.getIdUsuario(),"idUsuario");
			
			try {
				regresa = datosFocalizacion.actualizaFotografiaXUsu("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/",  customerVO.getUser(), customerVO.getDatosCliente().getFoto(), customerVO.getIdUsuario(), customerVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
				responseVO.setCode(ATTConstants.CODIGO_EXITO);
				responseVO.setMessageCode(ATTConstants.DESC_EXITO);
				responseVO.setObjectResponse(regresa);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
	
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String generaPIN(final String cadenaJson){
		
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo generaPIN de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell datosFocalizacion = new CallServicesMiIusacell();
		String regresa="";		
		
		try{
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			try {
				regresa = datosFocalizacion.generaPin("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(), customerVO.getIdPin(), customerVO.getIdServicios(), customerVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(regresa);
		
		    LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String  registraClienteBit(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo registraClienteBit de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		String respuesta ="";				
		
		try {
			
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");			
			VALIDATOR.validateEmptyString(customerVO.getLogin(),"password");
			if(customerVO.getDatosCliente() == null)
				throw new ValidateException("El campo datosCliente esta vacio o nulo.");
			VALIDATOR.validateEmptyString(customerVO.getDatosCliente().getEdad(),"edad");
			VALIDATOR.validateEmptyString(customerVO.getDatosCliente().getPaisId(),"paisId");
			VALIDATOR.validateEmptyString(customerVO.getDatosCliente().getUnidadNegocio(),"unidadNegocioID");
			VALIDATOR.validateEmptyString(customerVO.getDatosCliente().getSistemaOrigen(),"sistemaOrigen");
			VALIDATOR.validateEmptyString(customerVO.getDatosCliente().getDispositivo(),"dispositivo");
			
		    ClienteRegistroVO cliente = new ClienteRegistroVO();
		 
		    cliente.setaMaterno(customerVO.getDatosCliente().getApellidoMaterno());
			cliente.setaPaterno(customerVO.getDatosCliente().getApellidoPaterno());
			cliente.setContrasena(customerVO.getLogin());
			cliente.setCorreo(customerVO.getDatosCliente().getEmail());
			cliente.setDispositivo(customerVO.getDatosCliente().getDispositivo());
		    cliente.setDn(customerVO.getUser());
			cliente.setEdad(Integer.parseInt(customerVO.getDatosCliente().getEdad()));
			cliente.setFotografia(customerVO.getDatosCliente().getFoto());
			cliente.setNacimiento(customerVO.getDatosCliente().getFechaNacimiento());
			cliente.setNombre(customerVO.getDatosCliente().getNombre());
			cliente.setPaisID(Integer.parseInt(customerVO.getDatosCliente().getPaisId()));
			cliente.setPreguntaSecreta(customerVO.getDatosCliente().getPreguntaSecreta());
			cliente.setRespPreguntaSecreta(customerVO.getDatosCliente().getRespuestaSecreta());
			cliente.setSexo(customerVO.getDatosCliente().getSexo());
			cliente.setSistemaOrigen(Integer.parseInt(customerVO.getDatosCliente().getSistemaOrigen()));
			cliente.setTipoCliente(Integer.parseInt(customerVO.getDatosCliente().getTipoCliente()));
			cliente.setUnidadNegocioID(Integer.parseInt(customerVO.getDatosCliente().getUnidadNegocio()));

			try {
				respuesta = servicioMiIusacell.registroClienteBit("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", cliente, customerVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
            
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);
		
		    LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		
			
		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  getCatalogoAbonos(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo getCatalogoAbonos de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		List<CatalogoAbonos> respuesta = null;	

		try {						
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");

			respuesta = servicioMiIusacell.getCatalogoAbonos("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getToken());						           

			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (Exception validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String walletsDetalle(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();

		LOGGER.info("Comienza la ejecucion del metodo walletsDetalle de la clase IusacellBusiness");

		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();

		WalletsDetalleVO detalle = null;

		try {

			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			VALIDATOR.validateEmptyString(customerVO.getTipoEvento(),"tipoEvento");

			detalle = servicioMiIusacell.walletsDetalle("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
					customerVO.getUser(), customerVO.getTipoEvento(), 
					customerVO.getToken());


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(detalle);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));						

		}catch (Exception validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}


		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}	

	public String  editarCuenta(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo editarCuenta de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		String respuesta ="";		

		try {
			
			VALIDATOR.validateEmptyString(customerVO.getLogin(),"password");
			VALIDATOR.validateEmptyString(customerVO.getPasswordAnt(),"passwordAnt");
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			
			LoginRegisterBean datos = new LoginRegisterBean();
			datos.setKeyBis(customerVO.getLogin());
			datos.setKey(customerVO.getPasswordAnt());

			ClienteRegistroVO cliente = new ClienteRegistroVO();

			cliente.setDn(customerVO.getUser());

			try {
				respuesta = servicioMiIusacell.editarCuenta("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", cliente.getDn(), datos, customerVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  editarPerfil(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo editarPerfil de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		String respuesta ="";		

		try {
			
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			if(customerVO.getDatosCliente() == null)
				throw new ValidateException("El campo datosCliente esta vacio o nulo.");
			
			ClienteRegistroVO cliente = new ClienteRegistroVO();

			cliente.setDn(customerVO.getUser());
			cliente.setNombre(customerVO.getDatosCliente().getNombre());
			cliente.setaPaterno(customerVO.getDatosCliente().getApellidoPaterno());
			cliente.setaMaterno(customerVO.getDatosCliente().getApellidoMaterno());
			cliente.setCorreo(customerVO.getDatosCliente().getEmail());
			cliente.setContrasena(customerVO.getLogin());
			cliente.setNacimiento(customerVO.getDatosCliente().getFechaNacimiento());
			cliente.setFotografia(customerVO.getDatosCliente().getFoto());



			try {
				respuesta = servicioMiIusacell.editarPerfil("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", cliente, customerVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  getServiciosAdicionalesPorDn(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo getServiciosAdicionalesPorDn de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		List<ServiciosAdicionalesVO> respuesta =null;		

		try {	
			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");

			respuesta = servicioMiIusacell.getServiciosAdicionalesPorDn("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(), customerVO.getToken());

			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (Exception validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  registroTarjetas(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo registroTarjetas de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		String respuesta ="";		

		try {			   			   

			if(operacionVO.getDatosTarjeta() == null)
				throw new ValidateException("El campo datosTarjeta esta vacio o nulo.");
			VALIDATOR.validateEmptyString(operacionVO.getDatosTarjeta().getDn(),"dn");
			VALIDATOR.validateEmptyString(operacionVO.getDatosTarjeta().getNumeroTarjeta(),"tarjeta");

			String idUser = operacionVO.getDatosTarjeta().getDn().substring(2);
			try {
				respuesta = servicioMiIusacell.registroTarjetas("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						operacionVO.getDatosTarjeta(), idUser, operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  enviarCorreoSMS(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo enviarCorreoSMS de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		MensajeMailVO respuesta = null;		

		try {			   			   

			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			VALIDATOR.validateEmptyString(customerVO.getTipoEvento(),"tipoEvento");
			VALIDATOR.validateEmptyString(customerVO.getIdServicios(),"idServicio");
			if(customerVO.getDatosCliente() == null)
				throw new ValidateException("El campo datosCliente esta vacio o nulo.");
			VALIDATOR.validateEmptyString(customerVO.getDatosCliente().getEmail(),"email");
			VALIDATOR.validateEmptyString(customerVO.getDatosCliente().getNombre(),"nombre");

			try {
				respuesta = servicioMiIusacell.enviarCorreoSMS("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						customerVO.getUser(), customerVO.getTipoEvento(), customerVO.getDatosCliente().getEmail(),
						customerVO.getDatosCliente().getNombre(), customerVO.getIdServicios(), 
						customerVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  enviarCorreoFacturaDetalle(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo enviarCorreoFacturaDetalle de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		MensajeMailVO respuesta = null;		

		try {		

			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");
			VALIDATOR.validateEmptyString(customerVO.getTipoEvento(),"tipoEvento");
			VALIDATOR.validateEmptyString(customerVO.getIdServicios(),"idServicio");
			VALIDATOR.validateEmptyString(customerVO.getUrlFactura(),"urlFactura");
			if(customerVO.getFacturaVirtualDetalle() == null)
				throw new ValidateException("El campo facturaVirtualDetalle esta vacio o nulo.");
			VALIDATOR.validateEmptyString(customerVO.getFacturaVirtualDetalle().getMail(),"email");

			try {
				respuesta = servicioMiIusacell.enviarCorreoFacturaDetalle("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						customerVO.getTipoEvento(), customerVO.getIdServicios(), customerVO.getUrlFactura(), 
						customerVO.getFacturaVirtualDetalle(), customerVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}

			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  detalleSaldo(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo detalleSaldo de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		DetalleSaldoVO respuesta = null;		

		try {		

			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");				
			VALIDATOR.validateEmptyString(customerVO.getUrlFactura(),"urlFactura");				 

			try {
				respuesta = servicioMiIusacell.detalleSaldo("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						customerVO.getUser(), customerVO.getUrlFactura(), 
						customerVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}

			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  detalleFactura(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo detalleFactura de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		DetalleFacturaVO respuesta = null;		

		try {		

			VALIDATOR.validateEmptyString(customerVO.getUser(),"user");				
			VALIDATOR.validateEmptyString(customerVO.getUrlFactura(),"urlFactura");				 

			try {
				respuesta = servicioMiIusacell.detalleFactura("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						customerVO.getUser(), customerVO.getUrlFactura(), 
						customerVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}

			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  operador(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo operador de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		final OperadorBusiness operador = new OperadorBusiness();
		String respuesta ="";
		
		try{
			try {
				VALIDATOR.validateEmptyString(customerVO.getUser(),"user");		
				
				respuesta = operador.consultaOperador(customerVO.getUser(), customerVO.getToken());

			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  reservaPIN(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo reservaPIN de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		String respuesta ="";
		
		try{
			try {

				VALIDATOR.validateEmptyString(customerVO.getUser(),"user");	
				
				respuesta = servicioMiIusacell.reservaPIN("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(), customerVO.getToken());

			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}


	public String  validaPIN(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo validaPIN de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		boolean valor = false;
		
		try{
			try {

				VALIDATOR.validateEmptyString(customerVO.getUser(),"user");	
				
				valor = servicioMiIusacell.validaPIN("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(), customerVO.getIdPin(), customerVO.getToken());

			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(valor);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}


	public String  actualizaContrasenia(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo actualizaContrasenia de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final CustomerVO customerVO = new Gson().fromJson(jsonRequest, CustomerVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		boolean valor = false;
		
		try{
			try {

				VALIDATOR.validateEmptyString(customerVO.getUser(),"user");	
				
				valor = servicioMiIusacell.actualizaContrasenia("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", customerVO.getUser(), customerVO.getIdPin(), customerVO.getToken());

			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(valor);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String  abonoTiempoAire(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo abonoTiempoAire de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		AbonoTiempoAireVO respuesta = null;		

		try {			   			   

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			if(operacionVO.getDatosAbono() == null)
				throw new ValidateException("El campo datosAbono esta vacio o nulo.");
			VALIDATOR.validateEmptyString(operacionVO.getDatosAbono().getDnParaAbono(),"dnParaAbono");
			VALIDATOR.validateEmptyString(operacionVO.getLogin(),"password");
			
			try {
				respuesta = servicioMiIusacell.abonoTiempoAireBit("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						operacionVO.getUser(), operacionVO.getDatosAbono().getDnParaAbono(), operacionVO.getDatosAbono().getAnioExpira(), 
						operacionVO.getDatosAbono().getCdgSeguridad(), operacionVO.getDatosAbono().getConcepto(),
						operacionVO.getDatosAbono().getImporte(), operacionVO.getDatosAbono().getMesExpira(), operacionVO.getDatosAbono().getNumTarjeta(), 
						operacionVO.getDatosAbono().getTipoTarjeta(), operacionVO.getDatosAbono().getIp(), operacionVO.getDatosAbono().getSecuencia(), 
						operacionVO.getLogin(), operacionVO.getDatosAbono().getTipoPlataforma(), operacionVO.getCompania(), 
						operacionVO.getSistemaOrigen(), operacionVO.getDispositivo(), 
						operacionVO.getToken());
				
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String  bajaNumeroFrencuente(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo bajaNumeroFrencuente de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		int respuesta = -1;		

		try {			   			   

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			VALIDATOR.validateEmptyString(operacionVO.getTelefono(),"telefono");

			String idUser = operacionVO.getUser().substring(2);
			try {
				respuesta = servicioMiIusacell.bajaNumeroFrencuente("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						operacionVO.getUser(), operacionVO.getTelefono(), idUser, operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String  bajaServiciosPass(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo bajaServiciosPass de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		ContratarServiciosVO respuesta = null;		

		try {			   			   

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			if(operacionVO.getDatosAltaServicio() == null)
				throw new ValidateException("El campo datosAltaServicio esta vacio o nulo.");
			VALIDATOR.validateEmptyString(operacionVO.getDatosAltaServicio().getServicios(),"servicios");
			VALIDATOR.validateEmptyString(operacionVO.getLogin(),"password");
			
			try {
				respuesta = servicioMiIusacell.bajaServiciosPass("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						operacionVO.getUser(), operacionVO.getServicioId(), operacionVO.getDatosAltaServicio(), 
						operacionVO.getLogin(), operacionVO.getToken());
								
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String  bajaTarjeta(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo bajaTarjeta de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		String respuesta = "";		

		try {			   			   

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");	
			if(operacionVO.getDatosTarjeta() == null)
				throw new ValidateException("El campo datosTarjeta esta vacio o nulo.");
			VALIDATOR.validateEmptyString(operacionVO.getDatosTarjeta().getNumeroTarjeta(), "tarjeta");			

			String idUser = operacionVO.getUser().substring(2);
			try {
				respuesta = servicioMiIusacell.bajaTarjeta("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						operacionVO.getUser(), operacionVO.getDatosTarjeta().getMarcaTarjeta()+"", 
						operacionVO.getDatosTarjeta().getNumeroTarjeta(), idUser, operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String  contrataServicios(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo contrataServicios de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		ContratarServiciosVO respuesta = null;		

		try {			   			   

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");			
			VALIDATOR.validateEmptyString(operacionVO.getLogin(), "password");		
			if(operacionVO.getDatosAltaServicio() == null)
				throw new ValidateException("El campo datosAltaServicio esta vacio o nulo.");
			VALIDATOR.validateEmptyString(operacionVO.getDatosAltaServicio().getServicios(), "servicio");
			
			try {
				respuesta = servicioMiIusacell.contrataServicios("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						operacionVO.getUser(), operacionVO.getDatosAltaServicioEtak(), operacionVO.getDatosAltaServicio(), 
						operacionVO.getDatosAltaServicioPrepago(), operacionVO.getCompania(), operacionVO.getSistemaOrigen(), 
						operacionVO.getDispositivo(), operacionVO.getLogin(), operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String  obtieneNumeros(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo obtieneNumeros de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
				
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		List<NumerosFrecuentesVO> respuesta =null;		

		try {	
			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");

			respuesta = servicioMiIusacell.obtieneNumeros("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", operacionVO.getUser(), operacionVO.getToken());

			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (Exception validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String  registroNumFrecuentes(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo registroNumFrecuentes de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
			
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		String respuesta ="";		

		try {			   			   

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			VALIDATOR.validateEmptyString(operacionVO.getNombre(),"nombre");
			VALIDATOR.validateEmptyString(operacionVO.getTelefono(),"telefono");
			

			String idUser = operacionVO.getUser().substring(2);
			try {
				respuesta = servicioMiIusacell.registroNumFrecuentes("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						operacionVO.getUser(), operacionVO.getNombre(), operacionVO.getTelefono(), idUser, operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);

			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}

	public String  obtieneTarjetas(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();
		LOGGER.info("Comienza la ejecucion del metodo obtieneTarjetas de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
		List<TarjetasFrecuentesVO> response = null;
		String cadena = "";		

		try {            

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");  

			try {
				response = servicioMiIusacell.obtieneTarjetas("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", operacionVO.getUser(), operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}


			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(response);

			Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			cadena = gson.toJson(responseVO);


		} catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}

		return  cadena;
	}
	
	public String pagarFactura(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();		
		LOGGER.info("Comienza la ejecucion del metodo pagarFactura de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell iusacellService = new CallServicesMiIusacell();				
		PagoFacturaResponseVO respuesta;
		
		try {
			
			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			VALIDATOR.validateEmptyString(operacionVO.getCompania(),"compania");
			VALIDATOR.validateEmptyString(operacionVO.getSistemaOrigen(),"sistemaOrigen");
			VALIDATOR.validateEmptyString(operacionVO.getDispositivo(),"dispositivo");
			VALIDATOR.validateEmptyString(operacionVO.getTipoPlataforma(),"tipoPlataforma");
			VALIDATOR.validateEmptyString(operacionVO.getLogin(),"password");
			if(operacionVO.getCard() == null)
				throw new ValidateException("El campo card esta vacio o nulo.");
			VALIDATOR.validateEmptyString(operacionVO.getCard().getCardNumber(),"cardNumber");
			VALIDATOR.validateEmptyString(operacionVO.getCard().getCardSecurityCode(),"cardSecurityCode");
			VALIDATOR.validateEmptyString(operacionVO.getCard().getAmount(),"amount");
			VALIDATOR.validateEmptyString(operacionVO.getCard().getCardExpiryMonth(),"cardExpiryMonth");
			VALIDATOR.validateEmptyString(operacionVO.getCard().getCardExpiryYear(),"cardExpiryYear");			
			
			
			try {
				respuesta = iusacellService.pagarFactura("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						operacionVO.getUser(), operacionVO.getCard(), operacionVO.getTipoPlataforma(), operacionVO.getCompania(), 
						operacionVO.getSistemaOrigen(), operacionVO.getDispositivo(), operacionVO.getLogin(), operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(respuesta);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String obtieneListaVersionCaeS(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();		
		LOGGER.info("Comienza la ejecucion del metodo obtieneListaVersionCaeS de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);		
		CallServicesMiIusacell iusacellService = new CallServicesMiIusacell();
		
		CatalogoMovilCaeVO response;;
		
		try {										
			
			try {
				response = iusacellService.obtieneListaVersionCaeS("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", operacionVO.getCanal(), 
						operacionVO.getIdAplicacion(), operacionVO.getVersion(), operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(response);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String obtenerServiciosBundles(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();		
		LOGGER.info("Comienza la ejecucion del metodo obtenerServiciosBundles de la clase IusacellBusiness");
				
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell iusacellService = new CallServicesMiIusacell();
		
		List<ServiciosBundlesAdicionales> response;;
		
		try {	

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			VALIDATOR.validateEmptyString(String.valueOf(operacionVO.getVersion()),"version");
			
			try {
				response = iusacellService.obtenerServiciosBundles("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						operacionVO.getVersion(), operacionVO.getUser(), operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(response);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
	
	public String consultaWallets(final String cadenaJson){
		final ResponseVO responseVO = new ResponseVO();		
		LOGGER.info("Comienza la ejecucion del metodo consultaWallets de la clase IusacellBusiness");
		
		final String jsonRequest = VALIDATOR.validateRequestString(cadenaJson);
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
		
		final OperacionVO operacionVO = new Gson().fromJson(jsonRequest, OperacionVO.class);
		CallServicesMiIusacell iusacellService = new CallServicesMiIusacell();
		
		List<ConsultaWalletGeneralVO> response;;
		
		try {	

			VALIDATOR.validateEmptyString(operacionVO.getUser(),"user");
			VALIDATOR.validateEmptyString(operacionVO.getCompania(),"compania");
			
			try {
				response = iusacellService.consultaWallets("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", 
						operacionVO.getUser(), operacionVO.getCompania(), operacionVO.getToken());
			} catch (Exception e) {
				throw new ValidateException(e.getLocalizedMessage());
			}
			
			responseVO.setCode(ATTConstants.CODIGO_EXITO);
			responseVO.setMessageCode(ATTConstants.DESC_EXITO);
			responseVO.setObjectResponse(response);
			
			LOGGER.info("Cadena JSON de salida: " + new Gson().toJson(responseVO));
			
			
			
		}catch (ValidateException validateException) {
			responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
			responseVO.setMessageCode(validateException.getMessage());
			LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
		}
		
		
		return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
	}
}