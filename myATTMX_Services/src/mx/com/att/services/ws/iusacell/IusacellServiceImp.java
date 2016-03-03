package mx.com.att.services.ws.iusacell;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import mx.com.att.business.IusacellBusiness;
import mx.com.att.business.IusacellLoginBusiness;
import mx.com.att.utils.ATTConstants;

@WebService(portName="IusacellServicePort", 
serviceName="IusacellService", 
targetNamespace="http://www.att.com.mx/att/services/ws/security/iusacellService", 
endpointInterface="mx.com.att.services.ws.iusacell.IusacellService")
public class IusacellServiceImp implements IusacellService {

	private static final Logger LOGGER = Logger.getLogger(IusacellServiceImp.class);

	@Override
	public String obtieneWalletsLlamadas(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo obtieneInformacionLlamadas de la clase IusacellServiceImp");
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  cadenaJson);
		
		final IusacellBusiness iusacellBusiness = new IusacellBusiness();
		
		return iusacellBusiness.obtieneInformacionLlamadas(cadenaJson);
	}
	
	@Override
	public String obtieneWalletsMensajes(String cadenaJson){
		
		LOGGER.info("Comienza la ejecucion del metodo optieneWalletsMensajes de la clase IusacellServiceImp");
		LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
		
		final IusacellBusiness iusacellBusiness = new IusacellBusiness();
		
		return iusacellBusiness.obtieneInformacionMensajes(cadenaJson);
	}
    
	@Override
	public String obtieneWalletsNavegacion(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo optieneWalletsNavegacion de la clase IusacellServiceImp");
		LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
		
		final IusacellBusiness iusacellBusiness = new IusacellBusiness();
		
		return iusacellBusiness.obtieneInformacionNavegacion(cadenaJson);
		
	}
	
	@Override
	public String obtieneNumeroFacturas(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo obtieneNumeroFacturas de la clase IusacellServiceImp");
		LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
		
		final IusacellBusiness iusacellbusines = new IusacellBusiness();
		
		return iusacellbusines.obtieneNumeroFacturas(cadenaJson);
	}
	
	@Override
	public String actualizafotografia(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo actualizafotografia de la clase IusacellServiceImp");
		LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
		
		final IusacellBusiness iusacellBusiness = new IusacellBusiness();
		
		return iusacellBusiness.actualizafotografia(cadenaJson);
		
	}
	
	@Override
	 public String reservaPIN(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo editarCuenta de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.reservaPIN(cadenaJson);
	 }
	 
	 @Override
	 public String validaPIN(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo editarCuenta de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.validaPIN(cadenaJson);
	 }
	 
	 @Override
	 public String actualizaContrasenia(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo editarCuenta de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.actualizaContrasenia(cadenaJson);
	 }

	@Override
	public String generaPIN(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo generaPIN de la clase IusacellServiceImp");
		LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
		
		final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	
		return iusacellBusiness.generaPIN(cadenaJson);
	}
	
	
	@Override
	public String registraClienteBit(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo registraClienteBIT de la clase IusacellServiceImp");
		LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
		
		final IusacellBusiness iusacellBusiness = new IusacellBusiness();
		
		return iusacellBusiness.registraClienteBit(cadenaJson);
	}
	
	@Override
	public String getCatalogoAbonos(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getCatalogoAbonos de la clase IusacellServiceImp");
		LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
		
		final IusacellBusiness iusacellBusiness = new IusacellBusiness();
		
		return iusacellBusiness.getCatalogoAbonos(cadenaJson);
	}
	
	@Override
	public String walletsDetalle(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo walletsDetalle de la clase IusacellServiceImp");
		LOGGER.info(ATTConstants.CAD_JSON_ENT +  cadenaJson);
		
		final IusacellBusiness iusacellBusiness = new IusacellBusiness();
		
		return iusacellBusiness.walletsDetalle(cadenaJson);
	}
	
	@Override
	 public String editarCuenta(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo editarCuenta de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.editarCuenta(cadenaJson);
	 }
	 
	 @Override
	 public String editarPerfil(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo editarCuenta de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.editarPerfil(cadenaJson);
	 }
	 
	 @Override
	 public String getServiciosAdicionalesPorDn(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo getServiciosAdicionalesPorDn de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.getServiciosAdicionalesPorDn(cadenaJson);
	 }
	 
	 @Override
	 public String registroTarjetas(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo registroTarjetas de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.registroTarjetas(cadenaJson);
	 }
	 
	 @Override
	 public String enviarCorreoSMS(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo enviarCorreoSMS de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.enviarCorreoSMS(cadenaJson);
	 }
	 
	 @Override
	 public String enviarCorreoFacturaDetalle(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo enviarCorreoFacturaDetalle de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.enviarCorreoFacturaDetalle(cadenaJson);
	 }
	 
	 @Override
	 public String detalleSaldo(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo detalleSaldo de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.detalleSaldo(cadenaJson);
	 }
	 
	 @Override
	 public String detalleFactura(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo detalleFactura de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.detalleFactura(cadenaJson);
	 }
	 
	 @Override
	 public String operador(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo editarCuenta de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.operador(cadenaJson);
	 }
	 
	 @Override
	 public String abonoTiempoAire(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo abonoTiempoAire de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.abonoTiempoAire(cadenaJson);
	 }
	 
	 @Override
	 public String bajaNumeroFrencuente(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo bajaNumeroFrencuente de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.bajaNumeroFrencuente(cadenaJson);
	 }
	 
	 @Override
	 public String bajaServiciosPass(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo bajaServiciosPass de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.bajaServiciosPass(cadenaJson);
	 }
	 
	 @Override
	 public String bajaTarjeta(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo bajaTarjeta de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.bajaTarjeta(cadenaJson);
	 }
	 
	 @Override
	 public String contrataServicios(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo contrataServicios de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.contrataServicios(cadenaJson);
	 }
	 
	 @Override
	 public String obtieneNumeros(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo obtieneNumeros de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.obtieneNumeros(cadenaJson);
	 }
	 
	 @Override
	 public String registroNumFrecuentes(String cadenaJson){
	  LOGGER.info("Comienza la ejecucion del metodo registroNumFrecuentes de la clase IusacellServiceImp");
	  LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	  
	  final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	  
	  return iusacellBusiness.registroNumFrecuentes(cadenaJson);
	 }
	 
	 @Override
	  public String obtieneTarjetas(String cadenaJson){
	   LOGGER.info("Comienza la ejecucion del metodo obtieneTarjetas de la clase IusacellServiceImp");
	   LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	   
	   final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	   
	   return iusacellBusiness.obtieneTarjetas(cadenaJson);
	  }
	 
	 @Override
	  public String pagarFactura(String cadenaJson){
	   LOGGER.info("Comienza la ejecucion del metodo pagarFactura de la clase IusacellServiceImp");
	   LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	   
	   final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	   
	   return iusacellBusiness.pagarFactura(cadenaJson);
	  }
	 
	 @Override
	  public String obtieneListaVersionCaeS(String cadenaJson){
	   LOGGER.info("Comienza la ejecucion del metodo pagarFactura de la clase IusacellServiceImp");
	   LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	   
	   final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	   
	   return iusacellBusiness.obtieneListaVersionCaeS(cadenaJson);
	  }
	 
	 @Override
	  public String obtenerServiciosBundles(String cadenaJson){
	   LOGGER.info("Comienza la ejecucion del metodo obtenerServiciosBundles de la clase IusacellServiceImp");
	   LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	   
	   final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	   
	   return iusacellBusiness.obtenerServiciosBundles(cadenaJson);
	  }
	 
	 @Override
	  public String consultaWallets(String cadenaJson){
	   LOGGER.info("Comienza la ejecucion del metodo consultaWallets de la clase IusacellServiceImp");
	   LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	   
	   final IusacellBusiness iusacellBusiness = new IusacellBusiness();
	   
	   return iusacellBusiness.consultaWallets(cadenaJson);
	  }
	
	 @Override
	  public String consultaOperadorExtendido(String cadenaJson){
	   LOGGER.info("Comienza la ejecucion del metodo consultaOperadorExtendido de la clase IusacellServiceImp");
	   LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	   
	   final IusacellLoginBusiness iusacellBusiness = new IusacellLoginBusiness();
	   
	   return iusacellBusiness.consultaOperadorExtendido(cadenaJson);
	  }
	 
	 
	 @Override
	  public String focalizacion(String cadenaJson){
	   LOGGER.info("Comienza la ejecucion del metodo focalizacion de la clase IusacellServiceImp");
	   LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	   
	   final IusacellLoginBusiness iusacellBusiness = new IusacellLoginBusiness();
	   
	   return iusacellBusiness.focalizacion(cadenaJson);
	  }
	 
	 @Override
	  public String getConfiguracionXUsuarioMovil(String cadenaJson){
	   LOGGER.info("Comienza la ejecucion del metodo getConfiguracionXUsuarioMovil de la clase IusacellServiceImp");
	   LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	   
	   final IusacellLoginBusiness iusacellBusiness = new IusacellLoginBusiness();
	   
	   return iusacellBusiness.getConfiguracionXUsuarioMovil(cadenaJson);
	  }
	 
	 @Override
	  public String getPermisosXcliente(String cadenaJson){
	   LOGGER.info("Comienza la ejecucion del metodo getPermisosXcliente de la clase IusacellServiceImp");
	   LOGGER.info(ATTConstants.CAD_JSON_ENT + cadenaJson);
	   
	   final IusacellLoginBusiness iusacellBusiness = new IusacellLoginBusiness();
	   
	   return iusacellBusiness.getPermisosXcliente(cadenaJson);
	  }
}