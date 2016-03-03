package mx.com.att.services.ws.iusacell;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="IusacellService",
targetNamespace="http://www.att.com.mx/att/services/ws/customercare/iusacellService")
public interface IusacellService {

	String RETURN = "return";
	String JSON = "customerJson";
	
	@WebMethod(operationName="obtieneWalletsLlamadasMobile")
	@WebResult(name = RETURN)
	String obtieneWalletsLlamadas(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="obtieneWalletsMensajesMobile")
	@WebResult(name = RETURN)
	String obtieneWalletsMensajes(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="obtieneWalletsNavegacionMobile")
	@WebResult(name = RETURN)
	String obtieneWalletsNavegacion(@WebParam(name = JSON) String cadenaJson);
	
	
	@WebMethod(operationName="obtieneNumeroFacturasMobile")
	@WebResult(name = RETURN)
	String obtieneNumeroFacturas(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="actualizafotografiaMobile")
	@WebResult(name = RETURN)
	String actualizafotografia(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="generaPINMobile")
	@WebResult(name = RETURN)
	String generaPIN(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="registraClienteBitMobile")
	@WebResult(name = RETURN)
	String registraClienteBit(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="getCatalogoAbonosMobile")
	@WebResult(name = RETURN)
	String getCatalogoAbonos(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="walletsDetalleMobile")
	@WebResult(name = RETURN)
	String walletsDetalle(@WebParam(name = JSON) String cadenaJson);
	
	@WebMethod(operationName="editarCuentaMobile")
	 @WebResult(name = RETURN)
	 String editarCuenta(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="editarPerfilMobile")
	 @WebResult(name = RETURN)
	 String editarPerfil(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="getServiciosAdicionalesPorDnMobile")
	 @WebResult(name = RETURN)
	 String getServiciosAdicionalesPorDn(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="registroTarjetasMobile")
	 @WebResult(name = RETURN)
	 String registroTarjetas(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="enviarCorreoSMSMobile")
	 @WebResult(name = RETURN)
	 String enviarCorreoSMS(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="enviarCorreoFacturaDetalleMobile")
	 @WebResult(name = RETURN)
	 String enviarCorreoFacturaDetalle(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="detalleSaldoMobile")
	 @WebResult(name = RETURN)
	 String detalleSaldo(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="detalleFacturaMobile")
	 @WebResult(name = RETURN)
	 String detalleFactura(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="operadorMobile")
	 @WebResult(name = RETURN)
	 String operador(@WebParam(name = JSON) String cadenaJson);	
	 
	 @WebMethod(operationName="reservaPINMobile")
	 @WebResult(name = RETURN)
	 String reservaPIN(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="validaPINMobile")
	 @WebResult(name = RETURN)
	 String validaPIN(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="actualizaContraseniaMobile")
	 @WebResult(name = RETURN)
	 String actualizaContrasenia(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="abonoTiempoAireBitMobile")
	 @WebResult(name = RETURN)
	 String abonoTiempoAire(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="bajaNumeroFrencuenteMobile")
	 @WebResult(name = RETURN)
	 String bajaNumeroFrencuente(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="bajaServiciosPassMobile")
	 @WebResult(name = RETURN)
	 String bajaServiciosPass(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="bajaTarjetaMobile")
	 @WebResult(name = RETURN)
	 String bajaTarjeta(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="contrataServiciosMobile")
	 @WebResult(name = RETURN)
	 String contrataServicios(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="obtieneNumerosMobile")
	 @WebResult(name = RETURN)
	 String obtieneNumeros(@WebParam(name = JSON) String cadenaJson);	
	 
	 @WebMethod(operationName="registroNumFrecuentesMobile")
	 @WebResult(name = RETURN)
	 String registroNumFrecuentes(@WebParam(name = JSON) String cadenaJson);	
	 
	 @WebMethod(operationName="obtieneTarjetasMobile")
	 @WebResult(name = RETURN)
	 String obtieneTarjetas(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="pagarFacturaMobile")
	 @WebResult(name = RETURN)
	 String pagarFactura(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="obtieneListaVersionCaeSMobile")
	 @WebResult(name = RETURN)
	 String obtieneListaVersionCaeS(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="obtenerServiciosBundlesMobile")
	 @WebResult(name = RETURN)
	 String obtenerServiciosBundles(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="consultaWalletsMobile")
	 @WebResult(name = RETURN)
	 String consultaWallets(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="consultaOperadorExtendidoMobile")
	 @WebResult(name = RETURN)
	 String consultaOperadorExtendido(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="focalizacionMobile")
	 @WebResult(name = RETURN)
	 String focalizacion(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="getConfiguracionXUsuarioMobile")
	 @WebResult(name = RETURN)
	 String getConfiguracionXUsuarioMovil(@WebParam(name = JSON) String cadenaJson);
	 
	 @WebMethod(operationName="getPermisosXclienteMobile")
	 @WebResult(name = RETURN)
	 String getPermisosXcliente(@WebParam(name = JSON) String cadenaJson);
}