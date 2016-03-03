package mx.com.att.business.call;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;

import mx.com.att.support.SOAPManager;
import mx.com.att.utils.ATTConstants;
import mx.com.att.utils.Certificado;
import mx.com.att.utils.Formatter;
import mx.com.att.vo.red.AbonoTiempoAireVO;
import mx.com.att.vo.red.AltaServicioEtakVO;
import mx.com.att.vo.red.AltaServicioLegacyVO;
import mx.com.att.vo.red.AltaServicioPrepagoLegacyVO;
import mx.com.att.vo.red.CardVO;
import mx.com.att.vo.red.CatalogoAbonos;
import mx.com.att.vo.red.CatalogoMovilCaeVO;
import mx.com.att.vo.red.ClienteRegistroVO;
import mx.com.att.vo.red.ConfiguracionXUsuarioMovilVO;
import mx.com.att.vo.red.ConsultaOperadorExtendidoVO;
import mx.com.att.vo.red.ConsultaWalletGeneralVO;
import mx.com.att.vo.red.ContratarServiciosVO;
import mx.com.att.vo.red.DatosFacturasVO;
import mx.com.att.vo.red.DatosFocalizacionUsuario;
import mx.com.att.vo.red.DetalleFacturaVO;
import mx.com.att.vo.red.DetalleSaldoVO;
import mx.com.att.vo.red.DetalleTotalesLlamadas;
import mx.com.att.vo.red.FacturaVirtualDetalleVO;
import mx.com.att.vo.red.LoginRegisterBean;
import mx.com.att.vo.red.MensajeMailVO;
import mx.com.att.vo.red.Mensajes;
import mx.com.att.vo.red.Navegacion;
import mx.com.att.vo.red.NumerosFrecuentesVO;
import mx.com.att.vo.red.PagoFacturaResponseVO;
import mx.com.att.vo.red.PermisosClienteVO;
import mx.com.att.vo.red.ServiciosAdicionalesVO;
import mx.com.att.vo.red.ServiciosBundlesAdicionales;
import mx.com.att.vo.red.TarjetaVO;
import mx.com.att.vo.red.TarjetasFrecuentesVO;
import mx.com.att.vo.red.WalletsDetalleVO;

import org.apache.log4j.Logger;

//import javax.xml.rpc.Exception;


public class CallServicesMiIusacell {
	
//	String urlMiIusacell = "https://www.services.iusacell.com.mx/miIusacell/services/miIusacellService";
//	String urlMiIusacell = "http://14.128.95.138:9000/miIusacell/services/miIusacellService";
//	String urlMiIusacell = "http://10.203.24.211:9000/miIusacell/services/miIusacellService";
	String urlMiIusacell = ATTConstants.URL_WS_IUSACEL + "miIusacell/services/miIusacellService";
	
	
	private static final Logger LOGGER = Logger.getLogger(CallServicesMiIusacell.class);


	public ConfiguracionXUsuarioMovilVO getConfiguracionXUsuarioMovil (String user, String pass, String dn, String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		String url = urlMiIusacell;
		ConfiguracionXUsuarioMovilVO configuracionVo = new ConfiguracionXUsuarioMovilVO();
		  
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : getConfiguracionXUsuarioMovil");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);
		LOGGER.info("     Dn                     : " + dn);
		LOGGER.info("     token                  : " + token);
        
		try {
			
			Certificado.agregaKS();
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
						"<soapenv:Header/>"+
						"<soapenv:Body>"+
						"   <mii:getConfiguracionXUsuarioMovil>"+
						"      <mii:in0>"+user+"</mii:in0>"+
						"      <mii:in1>"+pass+"</mii:in1>"+
						"      <mii:in2>"+dn+"</mii:in2>"+
						"      <mii:in3>"+token+"</mii:in3>"+
						"   </mii:getConfiguracionXUsuarioMovil>"+
						"</soapenv:Body>"+
						"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           : " +  sResponse);
   		    
   		    configuracionVo =  ParseMiIusacellAtt.parsegetConfiguracionXUsuarioMovil(sResponse);
    		   
   		    
		}catch(Exception e)
		{
			//throw new Exception(e.getMessage());
			configuracionVo = new ConfiguracionXUsuarioMovilVO();
			LOGGER.error(e.getStackTrace());
		}
		return configuracionVo;
	}
		
	public List<PermisosClienteVO> getPermisosXcliente (String user, String pass, String dn, String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		String url = urlMiIusacell;
		List<PermisosClienteVO> listPermisosCliente = new ArrayList<PermisosClienteVO>();
		
		
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : getPermisosXcliente");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);
		LOGGER.info("     Dn                     : " + dn);
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
						"<soapenv:Header/>"+
						"<soapenv:Body>"+
						"   <mii:getPermisosXcliente>"+
						"      <mii:in0>"+user+"</mii:in0>"+
						"      <mii:in1>"+pass+"</mii:in1>"+
						"      <mii:in2>"+dn+"</mii:in2>"+
						"      <mii:in3>"+token+"</mii:in3>"+
						"   </mii:getPermisosXcliente>"+
						"</soapenv:Body>"+
						"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           : " +  sResponse);
   		    
   		 listPermisosCliente = ParseMiIusacellAtt.parsegetPermisosXcliente(sResponse);
   		    
		}catch(Exception e)
		{
			//throw new Exception(e.getMessage());
			listPermisosCliente = new ArrayList<PermisosClienteVO>();
			LOGGER.error(e.getStackTrace());
		}
		return listPermisosCliente;
	}
	
	public Navegacion walletsTotalNavegacion (String user, String pass, String dn, String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		String url = urlMiIusacell;
		Navegacion navegacionvo = new Navegacion();
		
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : walletsTotalNavegacion");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);
		LOGGER.info("     Dn                     : " + dn);
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">\")"+
	           "<soapenv:Header/>"                                  +
	             "<soapenv:Body>"                                     +
	                "<mii:walletsTotalNavegacion>"                   +
	                    "<mii:in0>" + user  + "</mii:in0>"           +
	                    "<mii:in1>" + pass  + "</mii:in1>"           +
	                    "<mii:in2>" + dn    + "</mii:in2>"           +
	                    "<mii:in3>" + token + "</mii:in3>"           +
	                "</mii:walletsTotalNavegacion>"                  +
	             "</soapenv:Body>"                                   +
	           "</soapenv:Envelope>" ;
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           : " +  sResponse);
   		    
   		    navegacionvo = ParseMiIusacellAtt.parseWalletsTotalNavegacion(sResponse);
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar walletsTotalNavegacion: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
		return navegacionvo;
	}
	
	public ConsultaOperadorExtendidoVO consultaOperadorExtendido (String user, String pass, String dn, String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		String url = urlMiIusacell;
		ConsultaOperadorExtendidoVO consultaOperador = null;
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : consultaOperadorExtendido");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);
		LOGGER.info("     Dn                     : " + dn);
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
						"<soapenv:Header/>"+
						"<soapenv:Body>"+
						"   <mii:consultaOperadorExtendido>"+
						"      <mii:in0>"+user+"</mii:in0>"+
						"      <mii:in1>"+pass+"</mii:in1>"+
						"      <mii:in2>"+dn+"</mii:in2>"+
						"      <mii:in3>"+token+"</mii:in3>"+
						"   </mii:consultaOperadorExtendido>"+
						"</soapenv:Body>"+
						"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			consultaOperador = ParseMiIusacellAtt.parseConsultaOperadorExtendido(sResponse);
			
			
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           : " +  sResponse);
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar consultaOperadorExtendido: ",e);
			throw new Exception(e.getMessage());
		}
		return consultaOperador;
	}
	
	public DatosFocalizacionUsuario  focalizacion (String user, String pass, String dn, String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		String url = urlMiIusacell;
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : focalizacion");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);
		LOGGER.info("     Dn                     : " + dn);
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		DatosFocalizacionUsuario  datosFocalizacionVo = new DatosFocalizacionUsuario();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
						"<soapenv:Header/>"+
						"<soapenv:Body>"+
						"   <mii:focalizacion>"+
						"      <mii:in0>"+user+"</mii:in0>"+
						"      <mii:in1>"+pass+"</mii:in1>"+
						"      <mii:in2>"+dn+"</mii:in2>"+
						"      <mii:in3>"+token+"</mii:in3>"+
						"   </mii:focalizacion>"+
						"</soapenv:Body>"+
						"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           : " +  sResponse);
   		    
   		 datosFocalizacionVo = ParseMiIusacellAtt.parseFocalizacion(sResponse);
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar focalizacion: ",e);
			throw new Exception(e.getMessage());
		}
		return datosFocalizacionVo;
	}
	

	public String generaPin (String user, String pass, String dn, String pin, String idServicio, String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		String sRespuesta="";
		String url = urlMiIusacell;
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : generaPin");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);
		LOGGER.info("     Dn                     : " + dn);
		LOGGER.info("     pin                    : " + pin);
		LOGGER.info("     idServicio             : " + idServicio);
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
						"<soapenv:Header/>"+
						"<soapenv:Body>"+
						"   <mii:generaPin>"+
						" <mii:in0>"+user+"</mii:in0>"+
				        " <mii:in1>"+pass+"</mii:in1>"+
				        " <mii:in2>"+dn+"</mii:in2>"+
				        " <mii:in3>"+pin+"</mii:in3>"+
				        " <mii:in4>"+idServicio+"</mii:in4>"+
				        " <mii:in5>"+token+"</mii:in5>"+
						" </mii:generaPin>"+
						"</soapenv:Body>"+
						"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           :  " +  sResponse);
   		    
   		    sRespuesta = ParseMiIusacellAtt.generaPIN(sResponse);
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar generaPin: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
		return sRespuesta;
	}
	
	

	public String registroClienteBit (String user, String pass,ClienteRegistroVO cliente, String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		String respuesta="";
		String url = urlMiIusacell;
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : registroClienteBit");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);
		LOGGER.info("     Dn                     : " + cliente.getDn());
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\" xmlns:vo=\"http://vo.miiusacell.services.iusacell.com.mx\">"+
						"<soapenv:Header/>"+
						"<soapenv:Body>"+
						"   <mii:registroClienteBit>"+
						"      <mii:in0>"+user+"</mii:in0>"+
						"      <mii:in1>"+pass+"</mii:in1>"+
						"      <mii:in2>"+
						"         <vo:aMaterno>"+cliente.getaMaterno()+"</vo:aMaterno>"+
						"         <vo:aPaterno>"+cliente.getaPaterno()+"</vo:aPaterno>"+
						"         <vo:contrasena>"+cliente.getContrasena()+"</vo:contrasena>"+
						"         <vo:correo>"+cliente.getCorreo()+"</vo:correo>"+
						"         <vo:dn>"+cliente.getDn()+"</vo:dn>"+
						"         <vo:dispositivo>"+cliente.getDispositivo()+"</vo:dispositivo>"+
						"         <vo:edad>"+cliente.getEdad()+"</vo:edad>"+
						"         <vo:fotografia>"+cliente.getFotografia()+"</vo:fotografia>"+
						"         <vo:nacimiento>"+cliente.getNacimiento()+"</vo:nacimiento>"+
						"         <vo:nombre>"+cliente.getNombre()+"</vo:nombre>"+
						"         <vo:paisID>"+cliente.getPaisID()+"</vo:paisID>"+
						"         <vo:preguntaSecreta>"+cliente.getPreguntaSecreta()+"</vo:preguntaSecreta>"+
						"         <vo:respPreguntaSecreta>"+cliente.getRespPreguntaSecreta()+"</vo:respPreguntaSecreta>"+
						"         <vo:sexo>"+cliente.getSexo()+"</vo:sexo>"+
						"         <vo:sistemaOrigen>"+cliente.getSistemaOrigen()+"</vo:sistemaOrigen>"+
						"         <vo:tipoCliente>"+cliente.getTipoCliente()+"</vo:tipoCliente>"+
						"         <vo:unidadNegocioID>"+cliente.getUnidadNegocioID()+"</vo:unidadNegocioID>"+
						"      </mii:in2>"+
					"      <mii:in3>"+cliente.getDn().substring(2)  +"</mii:in3>"+
						"      <mii:in4>"+token+"</mii:in4>"+
						"   </mii:registroClienteBit>"+
						"</soapenv:Body>"+
						"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              +  ");
   		    LOGGER.debug("     XMLRespuesta           : " +  sResponse);
   		    
             respuesta = ParseMiIusacellAtt.registroClienteBit(sResponse);   		    
   		    
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar registroClienteBit: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
		return respuesta;
	}
	
	public DatosFacturasVO  getFacturas (String user, String pass, String dn, String noFacturas, String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		String url = urlMiIusacell;
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : getFacturas");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);
		LOGGER.info("     noFacturas             : " + noFacturas);
		LOGGER.info("     token                  : " + token);
		
		DatosFacturasVO facturas = new DatosFacturasVO();
		
		Certificado.agregaKS();
        
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
						"<soapenv:Header/>"+
						"<soapenv:Body>"+
						"   <mii:getFacturas>"+
						"      <mii:in0>"+user+"</mii:in0>"+
						"      <mii:in1>"+pass+"</mii:in1>"+
						"      <mii:in2>"+dn+"</mii:in2>"+
						"      <mii:in3>"+noFacturas+"</mii:in3>"+
						"      <mii:in4>"+token+"</mii:in4>"+
						"   </mii:getFacturas>"+
						"</soapenv:Body>"+
						"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         :   "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           :  " +  sResponse);
   		    
   		    facturas = ParseMiIusacellAtt.parsegetFacturas(sResponse);
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar getFacturas: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
		return facturas;
	}
	
	public String actualizaFotografiaXUsu(String user, String pass,String dn, String fotografia, String usuarioID,String token) throws Exception
		{	
			String url = urlMiIusacell;
			LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
			LOGGER.info("     EndPoint               : " + url);
			LOGGER.info("     Operacion              : actualizaFotografiaXUsu");
			LOGGER.info("     requesting             : " + new Date().toString());
			LOGGER.info("   + Parametros             + ");
			LOGGER.info("     dn		              : " + dn);
			LOGGER.info("     fotografia             : " + fotografia);
			LOGGER.info("     usuarioID              : " + usuarioID);
			LOGGER.info("     token                  : " + Formatter.pintaLogCadenasLargas(token));
			
			String sXMLRequest = "";
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			String sResponse = "";
			
			try
			{
				
				Certificado.agregaKS();
				
				 sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">\n"+
					  "<soapenv:Header/>\n"+
						   "<soapenv:Body>\n"+
						      "<mii:actualizaFotografiaXUsu>\n"+
						      	 "<mii:in0>"+user+"</mii:in0>\n"+
						         "<mii:in1>"+pass+"</mii:in1>\n"+
						         "<mii:in2>"+dn+"</mii:in2>\n"+
						         "<mii:in3>"+fotografia+"</mii:in3>\n"+
						         "<mii:in4>"+usuarioID+"</mii:in4>\n"+
						         "<mii:in5>"+token+"</mii:in5>\n"+
						      "</mii:actualizaFotografiaXUsu>\n"+
						   "</soapenv:Body>\n"+
					    "</soapenv:Envelope>";
				
				LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
			
				//********************************
				//Enviamos la peticion al servidor
				//********************************
				sResponse = soapManager.sendRequestWithXML(sXMLRequest);
				 
				LOGGER.info("   + Respuesta              + ");
				LOGGER.debug("     SOAPResponseXML        : " + sResponse);
				
				sResponse = ParseMiIusacellAtt.actualizaFotografiaXUsu(sResponse);
				
			}
			catch(Exception e)
			{
				LOGGER.error("Eror al invocar actualizaFotografiaXUsu: ",e);
				throw new ServiceException(e.getLocalizedMessage());
			}
			return sResponse;
		}
	
	public WalletsDetalleVO walletsDetalle(String user, String pass, String dn, String tipoEvento, String token) throws Exception
		{
			String url = urlMiIusacell;
			LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
			LOGGER.info("     EndPoint               : " + url);
			LOGGER.info("     Operacion              : walletsDetalle");
			LOGGER.info("     requesting             : " + new Date().toString());
			LOGGER.info("   + Parametros             + ");
			LOGGER.info("     dn		              : " + dn);
			LOGGER.info("     tipoEvento             : " + tipoEvento);
			LOGGER.info("     token                  : " + Formatter.pintaLogCadenasLargas(token));
			
			String sXMLRequest = "";
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			String sResponse = "";
			WalletsDetalleVO detalleResponse = null;
			
			try
			{
				
				Certificado.agregaKS();
				
				 sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
							   "<soapenv:Header/>\n"+
							   "<soapenv:Body>\n"+
							      "<mii:walletsDetalle>\n"+
							      	 "<mii:in0>"+user+"</mii:in0>\n"+
							         "<mii:in1>"+pass+"</mii:in1>\n"+
							         "<mii:in2>"+dn+"</mii:in2>\n"+
							         "<mii:in3>"+tipoEvento+"</mii:in3>\n"+
							         "<mii:in4>"+token+"</mii:in4>\n"+
							      "</mii:walletsDetalle>\n"+
							   "</soapenv:Body>\n"+
							"</soapenv:Envelope>";
				
				LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
			
				//********************************
				//Enviamos la peticion al servidor
				//********************************
				sResponse = soapManager.sendRequestWithXML(sXMLRequest);
				 
				LOGGER.info("   + Respuesta              + ");
				LOGGER.debug("     SOAPResponseXML        : " + sResponse);
				
				detalleResponse = ParseMiIusacellAtt.parseWalletsDetalle(sResponse);
			}
			catch(Exception e)
			{
				LOGGER.error("Eror al invocar walletsDetalle: ",e);
				sResponse = "";
				throw new Exception("Al consultar la url: " + url + " :: " + e.getMessage());
			}
			return detalleResponse;
			
		}
		
	public MensajeMailVO enviarCorreoSMS(String user, String pass, String dn, String tipoEvento, String mail, String nombre, String idServicio, String token) throws Exception
	  {
		  LOGGER.info("  >> LLAMADA WEB SERVICE"                                         );
	      LOGGER.info("     endpoint                     : " + urlMiIusacell             );
	      LOGGER.info("     operacion                    : enviarCorreoSMS" );
	      LOGGER.info("   + Parametros                   +"                              );
	      LOGGER.info("     ws.usuario                   : -PROTEGIDO-"                  );
	      LOGGER.info("     ws.combinacion               : -PROTEGIDO-"                  );
	      LOGGER.info("     datos.version                : " + ""                        );
	      LOGGER.info("     datos.dn                     : " + dn                        );
	      LOGGER.info("     datos.tipoEvento             : " + tipoEvento                );
	      LOGGER.info("     datos.mail                   : " + mail                      );
	      LOGGER.info("     datos.nombre                 : " + nombre                    );
	      LOGGER.info("     datos.idServicio             : " + idServicio                );
	      LOGGER.info("     ws.token                     : " + token                     );
	      
	    	String sXMLRequest = "";
			String sResponse = "";
			Certificado.agregaKS();
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(urlMiIusacell);
			MensajeMailVO respuesta=new MensajeMailVO();
			
			try {
				
				sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">\")"+
						           "<soapenv:Header/>"                        +
						           "<soapenv:Body>"                           +
						              "<mii:enviarCorreoSMS>"+
								         "<mii:in0>"+user+"</mii:in0>"+
								         "<mii:in1>"+pass+"</mii:in1>"+
								         "<mii:in2>"+dn+"</mii:in2>"+
								         "<mii:in3>"+tipoEvento+"</mii:in3>"+
								         "<mii:in4>"+mail+"</mii:in4>"+
								         "<mii:in5>"+nombre+"</mii:in5>"+
									  "<mii:in6>"+idServicio+"</mii:in6>"+
									  "<mii:in7>"+token+"</mii:in7>"+
								      "</mii:enviarCorreoSMS>"   +
						           "</soapenv:Body>"                          +
						        "</soapenv:Envelope>"                         ;
					
				 LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
					
				 sResponse = soapManager.sendRequestWithXML(sXMLRequest);
					
				 LOGGER.info("   + Respuesta              +");
				 LOGGER.debug("     SOAPResponseXML        : " + sResponse);
				
				 respuesta=ParseMiIusacellAtt.parseEnviaCorreoSMS(sResponse);
							
			} catch (Exception e) {
				LOGGER.error("Eror al invocar enviarCorreoSMS: ",e);
				throw new ServiceException (e.getLocalizedMessage());
			}
	      
			return respuesta;
	      
	  }
		
	public String login(String user, String pass, String usuario, String valida2c, String unidadDeNegocio, String token) throws Exception
		{
			String url = urlMiIusacell;
			LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
			LOGGER.info("     EndPoint               : " + url);
			LOGGER.info("     Operacion              : login");
			LOGGER.info("     requesting             : " + new Date().toString());
			LOGGER.info("   + Parametros             + ");
			LOGGER.info("     usuario	              : " + usuario);
			LOGGER.info("     valida2c		          : XXXXXXX");
			LOGGER.info("     unidadDeNegocio             : " + unidadDeNegocio);
			LOGGER.info("     token                  : " + Formatter.pintaLogCadenasLargas(token));
			
			String sXMLRequest = "";
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			String sResponse = "";
			
			try
			{
				 Certificado.agregaKS();
				
				 sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
							   "<soapenv:Header/>\n"+
							   "<soapenv:Body>\n"+
							      "<mii:login>\n"+
							      	 "<mii:in0>"+user+"</mii:in0>\n"+
							         "<mii:in1>"+pass+"</mii:in1>\n"+
							         "<mii:in2>"+usuario+"</mii:in2>\n"+
							         "<mii:in3>"+valida2c+"</mii:in3>\n"+
							         "<mii:in4>"+unidadDeNegocio+"</mii:in4>\n"+
							         "<mii:in5>"+token+"</mii:in5>\n"+
							      "</mii:login>\n"+
							   "</soapenv:Body>\n"+
							"</soapenv:Envelope>";
				
				LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
			
				//********************************
				//Enviamos la peticion al servidor
				//********************************
				sResponse = soapManager.sendRequestWithXML(sXMLRequest);
				 
				LOGGER.info("   + Respuesta              + ");
				LOGGER.debug("     SOAPResponseXML        : " + sResponse);
				
				sResponse = ParseMiIusacellAtt.parseLogin(sResponse);
				
			}
			catch(Exception e)
			{
				LOGGER.error("Eror al invocar login: ",e);
				sResponse = "";
				throw new Exception("Al consultar la url :" + url + " :: " + e.getMessage());
			}
			return sResponse;
			
		}
		
	public String reservaPIN(String user, String pass, String dn, String token) throws Exception{

		LOGGER.info("  >> LLAMADA WEB SERVICE"                                         );
		LOGGER.info("     endpoint                     : " + urlMiIusacell             );
		LOGGER.info("     operacion                    :     reservaPIN"               );
		LOGGER.info("   + Parametros                   +"                              );
		LOGGER.info("     ws.usuario                   : -PROTEGIDO-"                  );
		LOGGER.info("     ws.pass                      : -PROTEGIDO-"                  );
		LOGGER.info("     datos.dn                     : " + dn                        );
		LOGGER.info("     ws.token                     : " + token                     );

		String sXMLRequest = "";
		String sResponse = "";
		Certificado.agregaKS();
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(urlMiIusacell);
		String resultado="";

		try {
			sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
					"<soapenv:Header/>"+
					"<soapenv:Body>"+
					"<mii:reservaPIN>"+
					"<mii:in0>"+user+"</mii:in0>"+
					"<mii:in1>"+pass+"</mii:in1>"+
					"<mii:in2>"+dn+"</mii:in2>"+
					"<mii:in3>"+token+"</mii:in3>"+
					"</mii:reservaPIN>"+
					"</soapenv:Body>"+
					"</soapenv:Envelope>";

			LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);

			sResponse = soapManager.sendRequestWithXML(sXMLRequest);

			LOGGER.info("   + Respuesta              +");
			LOGGER.debug("     SOAPResponseXML        : " + sResponse);

			resultado = ParseMiIusacellAtt.parseReservaPIN(sResponse);


		} catch (Exception e) {
			LOGGER.error("Eror al invocar reservaPIN: ",e);
			throw new ServiceException (e.getLocalizedMessage());
		}

		return resultado;
	}

	public boolean validaPIN(String user, String pass, String dn, String pin, String token) throws Exception{

		LOGGER.info("  >> LLAMADA WEB SERVICE"                                         );
		LOGGER.info("     endpoint                     : " + urlMiIusacell             );
		LOGGER.info("     operacion                    : validaPIN"                    );
		LOGGER.info("   + Parametros                   +"                              );
		LOGGER.info("     ws.usuario                   : -PROTEGIDO-"                  );
		LOGGER.info("     ws.combinacion               : -PROTEGIDO-"                  );
		LOGGER.info("     datos.version                : " + ""                        );
		LOGGER.info("     datos.dn                     : " + dn                        );
		LOGGER.info("     datos.pin                    : " + pin                       );
		LOGGER.info("     ws.token                     : " + token                     );

		String sXMLRequest = "";
		String sResponse = "";
		boolean respuesta=false;
		Certificado.agregaKS();
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(urlMiIusacell);

		try {
			sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
					"<soapenv:Header/>"+
					"<soapenv:Body>"+
					"<mii:validaPIN>"+
					"<mii:in0>"+user+"</mii:in0>"+
					"<mii:in1>"+pass+"</mii:in1>"+
					"<mii:in2>"+dn+"</mii:in2>"+
					"<mii:in3>"+pin+"</mii:in3>"+
					"<mii:in4>"+token+"</mii:in4>"+
					"</mii:validaPIN>"+
					"</soapenv:Body>"+
					"</soapenv:Envelope>";

			LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);

			sResponse = soapManager.sendRequestWithXML(sXMLRequest);

			LOGGER.info("   + Respuesta              +");
			LOGGER.debug("     SOAPResponseXML        : " + sResponse);

			respuesta = ParseMiIusacellAtt.parseValidaPIN(sResponse);

		} catch (Exception e) {
			LOGGER.error("Eror al invocar validaPIN: ",e);
			throw new ServiceException (e.getLocalizedMessage());
		}

		return respuesta;
	}

	public boolean actualizaContrasenia (String user, String pass, String dn, String pin, String token) throws Exception
	{
		String url = urlMiIusacell;
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : actualizaContrasenia");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     dn                 : " + dn);
		LOGGER.info("     pin                 : XXXXXX");
		LOGGER.info("     token                  : " + Formatter.pintaLogCadenasLargas(token));

		String sXMLRequest = "";
		boolean respuesta=false;
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(url);
		String sResponse = "";

		try
		{
			Certificado.agregaKS();

			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
					"<soapenv:Header/>\n"+
					"<soapenv:Body>\n"+
					"<mii:actualizaContrasenia>\n"+
					"<mii:in0>"+user+"</mii:in0>\n"+
					"<mii:in1>"+pass+"</mii:in1>\n"+
					"<mii:in2>"+dn+"</mii:in2>\n"+
					"<mii:in3>"+pin+"</mii:in3>\n"+
					"<mii:in4>"+token+"</mii:in4>\n"+
					"</mii:actualizaContrasenia>\n"+
					"</soapenv:Body>\n"+
					"</soapenv:Envelope>";

			LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);

			//********************************
			//Enviamos la peticion al servidor
			//********************************
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);

			LOGGER.info("   + Respuesta              + ");
			LOGGER.debug("     SOAPResponseXML        : " + sResponse);

			respuesta = ParseMiIusacellAtt.parseActualiza(sResponse);
		}
		catch(Exception e)
		{
			LOGGER.error("Eror al invocar actualizaContrasenia: ",e);
			sResponse = "";
			throw new Exception("Al consultar la url: " + url + " :: " + e.getMessage());
		}
		return respuesta;

	}

	public List<TarjetasFrecuentesVO> obtieneTarjetas(String user, String pass, String dn, String token) throws Exception
	{
		String url = urlMiIusacell;
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : obtieneTarjetas");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     dn                 : " + dn);
		LOGGER.info("     token                  : " + Formatter.pintaLogCadenasLargas(token));

		String sXMLRequest = "";
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(url);
		String sResponse = "";
		List<TarjetasFrecuentesVO> response = null;
		try
		{

			Certificado.agregaKS();

			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
					"<soapenv:Header/>\n"+
					"<soapenv:Body>\n"+
					"<mii:obtieneTarjetas>\n"+
					"<mii:in0>"+user+"</mii:in0>\n"+
					"<mii:in1>"+pass+"</mii:in1>\n"+
					"<mii:in2>"+dn+"</mii:in2>\n"+
					"<mii:in3>"+token+"</mii:in3>\n"+
					"</mii:obtieneTarjetas>\n"+
					"</soapenv:Body>\n"+
					"</soapenv:Envelope>";

			LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);

			//********************************
			//Enviamos la peticion al servidor
			//********************************
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);

			response = ParseMiIusacellAtt.obtieneTarjeta(sResponse);
			LOGGER.info("   + Respuesta              + ");
			LOGGER.debug("     SOAPResponseXML        : " + response);
		}
		catch(Exception e)
		{
			LOGGER.error("Eror al invocar obtieneTarjetas: ",e);
			sResponse = "";
			throw new Exception("Al consultar la url: " + url + " :: " + e.getMessage());
		}
		return response;

	}

	public DetalleSaldoVO detalleSaldo (String user, String pass, String dn, String facturaUrl, String token) throws Exception{

		  LOGGER.info("  >> LLAMADA WEB SERVICE"                                         );
	      LOGGER.info("     endpoint                     : " + urlMiIusacell             );
	      LOGGER.info("     operacion                    :     detalleSaldo"             );
	      LOGGER.info("   + Parametros                   +"                              );
	      LOGGER.info("     ws.usuario                   : -PROTEGIDO-"                  );
	      LOGGER.info("     ws.pass                      : -PROTEGIDO-"                  );
	      LOGGER.info("     datos.dn                     : " + dn                        );
	      LOGGER.info("     datos.facturaUrl             : " + facturaUrl                );
	      LOGGER.info("     ws.token                     : " + token                     );
	      
			
			
	        String sXMLRequest = "";
			String sResponse = "";
			Certificado.agregaKS();
			DetalleSaldoVO  detalleSaldo = new DetalleSaldoVO();
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(urlMiIusacell);
			
			
			try {
				
				sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
							"<soapenv:Header/>"+
							"<soapenv:Body>"+
							"   <mii:detalleSaldo>"+
							"      <mii:in0>"+user+"</mii:in0>"+
							"      <mii:in1>"+pass+"</mii:in1>"+
							"      <mii:in2>"+dn+"</mii:in2>"+
							"      <mii:in3>"+facturaUrl+"</mii:in3>"+
							"      <mii:in4>"+token+"</mii:in4>"+
							"   </mii:detalleSaldo>"+
							"</soapenv:Body>"+
							"</soapenv:Envelope>";
					
				LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
					
				sResponse = soapManager.sendRequestWithXML(sXMLRequest);
				 
				LOGGER.info("   + Respuesta              +");
     		    LOGGER.debug("     SOAPResponseXML        : " + sResponse);
				 
				 detalleSaldo=ParseMiIusacellAtt.parseDetalleSaldo(sResponse);
				
				 
							
			} catch (Exception e) {
				LOGGER.error("Eror al invocar detalleSaldo: ",e);
				throw new ServiceException(e.getLocalizedMessage());
			}      
			return detalleSaldo;		
		}
		
		public MensajeMailVO enviarCorreoFacturaDetalle(String user, String pass, String tipoEvento, String idServicio, String urlFactura,FacturaVirtualDetalleVO facturaVirtualDetalle, String token) throws Exception
		{
			String url = urlMiIusacell;
			LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
			LOGGER.info("     EndPoint               : " + url);
			LOGGER.info("     Operacion              : reservaPIN");
			LOGGER.info("     requesting             : " + new Date().toString());
			LOGGER.info("   + Parametros             + ");
			LOGGER.info("     tipoEvento	          : " + tipoEvento);
			LOGGER.info("     idServicio          	  : "+ idServicio);
			LOGGER.info("     urlFactura          	  : XXXXXXXXXX");
			LOGGER.info("     token                  : " + Formatter.pintaLogCadenasLargas(token));
			
			String sXMLRequest = "";
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			String sResponse = "";
			MensajeMailVO vo = new MensajeMailVO();
			
			try
			{
				Certificado.agregaKS();
				
				sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\" xmlns:vo=\"http://vo.miiusacell.services.iusacell.com.mx\">"+
			            "<soapenv:Header/>"+
						"<soapenv:Body>"+
								   "<mii:enviarCorreoFacturaDetalle>\n"+
							         "<mii:in0>"+user+"</mii:in0>\n"+
							         "<mii:in1>"+pass+"</mii:in1>\n"+
							         "<mii:in2>"+tipoEvento+"</mii:in2>\n"+
							         "<mii:in3>"+idServicio+"</mii:in3>\n"+
							         "<mii:in4>"+urlFactura+"</mii:in4>\n"+
							         "<mii:in5>\n"+
							         	"<vo:ajustes>"+facturaVirtualDetalle.getAjustes()+"</vo:ajustes>\n"+
							            "<vo:codigoAutorizacion>"+facturaVirtualDetalle.getCodigoAutorizacion()+"</vo:codigoAutorizacion>\n"+
							            "<vo:consumosPeriodo>"+facturaVirtualDetalle.getConsumosPeriodo()+"</vo:consumosPeriodo>\n"+
							            "<vo:dn>"+facturaVirtualDetalle.getDn()+"</vo:dn>\n"+
							            "<vo:fechaConsulta>"+facturaVirtualDetalle.getFechaConsulta()+"</vo:fechaConsulta>\n"+
							            "<vo:fechaCorte>"+facturaVirtualDetalle.getFechaCorte()+"</vo:fechaCorte>\n"+
							            "<vo:fechaPago>"+facturaVirtualDetalle.getFechaPago()+"</vo:fechaPago>\n"+
							            "<vo:iva>"+facturaVirtualDetalle.getIva()+"</vo:iva>\n"+
							            "<vo:mail>"+facturaVirtualDetalle.getMail()+"</vo:mail>\n"+
							            "<vo:mesFactura>"+facturaVirtualDetalle.getMesFactura()+"</vo:mesFactura>\n"+
							            "<vo:noCuenta>"+facturaVirtualDetalle.getNoCuenta()+"</vo:noCuenta>\n"+
							            "<vo:noFactura>"+facturaVirtualDetalle.getNoFactura()+"</vo:noFactura>\n"+
							            "<vo:nombre>"+facturaVirtualDetalle.getNombre()+"</vo:nombre>\n"+
							            "<vo:otrosCargos>"+facturaVirtualDetalle.getOtrosCargos()+"</vo:otrosCargos>\n"+
							            "<vo:pago>"+facturaVirtualDetalle.getPago()+"</vo:pago>\n"+
							            "<vo:pagoAntesDe>"+facturaVirtualDetalle.getPagoAntesDe()+"</vo:pagoAntesDe>\n"+
							            "<vo:periodoXFecha>"+facturaVirtualDetalle.getPeriodoXFecha()+"</vo:periodoXFecha>\n"+
							            "<vo:periodoXMes>"+facturaVirtualDetalle.getPeriodoXMes()+"</vo:periodoXMes>\n"+
							            "<vo:porcentajeIVA>"+facturaVirtualDetalle.getPorcentajeIVA()+"</vo:porcentajeIVA>\n"+
							            "<vo:rentas>"+facturaVirtualDetalle.getRentas()+"</vo:rentas>\n"+
							            "<vo:saldoCorte>"+facturaVirtualDetalle.getSaldoCorte()+"</vo:saldoCorte>\n"+
							            "<vo:saldoPendiente>"+facturaVirtualDetalle.getSaldoPendiente()+"</vo:saldoPendiente>\n"+
							            "<vo:serviciosAdicionales>"+facturaVirtualDetalle.getServiciosAdicionales()+"</vo:serviciosAdicionales>\n"+
							            "<vo:subtotal>"+facturaVirtualDetalle.getSubtotal()+"</vo:subtotal>\n"+
							            "<vo:totalPagar>"+facturaVirtualDetalle.getTotalPagar()+"</vo:totalPagar>\n"+
							         "</mii:in5>\n"+
							         "<mii:in6>"+token+"</mii:in6>\n"+
							      "</mii:enviarCorreoFacturaDetalle>\n"+
							   "</soapenv:Body>\n"+
							"</soapenv:Envelope>";
				
				LOGGER.info("     SOAPRequestXML         : " + sXMLRequest);
			
				//********************************
				//Enviamos la peticion al servidor
				//********************************
				sResponse = soapManager.sendRequestWithXML(sXMLRequest);
				 
				LOGGER.info("   + Respuesta              + ");
				LOGGER.info("     SOAPResponseXML        : " + sResponse);
				
				vo = ParseMiIusacellAtt.enviarCorreoFacturaDetalle(sResponse);
			}
			catch(Exception e)
			{
				LOGGER.error("Eror al invocar enviarCorreoFacturaDetalle: ",e);
				sResponse = "";
				throw new Exception("Al consultar la url: " + url + " :: " + e.getMessage());
			}
			return vo;
			
		}
		

	public String registroNumFrecuentes(String user, String pass,String dn, String nombre, String telefono, String usuarioId, String token) throws Exception{
		       
		
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + urlMiIusacell);
		LOGGER.info("     Operacion              : registroNumFrecuentes");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     dn                     : " + dn);
		
		String sXMLRequest = "";
		String sResponse = "";
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(urlMiIusacell);
		
		Certificado.agregaKS();
		
		
		try {
			
			sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
			   "<soapenv:Header/>"+
			   "<soapenv:Body>"+
			      "<mii:registroNumFrecuentes>"+
			         "<mii:in0>"+user+"</mii:in0>"+
			         "<mii:in1>"+pass+"</mii:in1>"+
			         "<mii:in2>"+dn+"</mii:in2>"+
			         "<mii:in3>"+nombre+"</mii:in3>"+
			         "<mii:in4>"+telefono+"</mii:in4>"+
			         "<mii:in5>"+usuarioId+"</mii:in5>"+
			         "<mii:in6>"+token+"</mii:in6>"+
			      "</mii:registroNumFrecuentes>"+
			   "</soapenv:Body>"+
			"</soapenv:Envelope>";
			
            LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
			
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              +");
			LOGGER.debug("     SOAPResponseXML        : " + sResponse);
			
			sResponse = ParseMiIusacellAtt.parseRegistroNumFrecuentes(sResponse);		
			
		} catch (Exception e) {
			LOGGER.error("Eror al invocar registroNumFrecuentes: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
		
		
		
		return sResponse;
		
	}
	
	public String callDatosFocalizacion(String user, String pass, String dn, String token) throws Exception {
		
		String url =urlMiIusacell;
		
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : callDatosFocalizacion");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     dn                     : " + dn);
		
		Certificado.agregaKS();
//		certificado.cargarCertificadoDirecto();
		
		String sXMLRequest = "";
		String sResponse = "";
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(url);
		
		
		
		try {
			sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
			   "<soapenv:Header/>"+
			   "<soapenv:Body>"+
			      "<mii:datosFocalizacion>"+
			         "<mii:in0>"+user+"</mii:in0>"+
			         "<mii:in1>"+pass+"</mii:in1>"+
			         "<mii:in2>"+dn+"</mii:in2>"+
			         "<mii:in3>"+token+"</mii:in3>"+
			      "</mii:datosFocalizacion>"+
			   "</soapenv:Body>"+
			"</soapenv:Envelope>";
			
			LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
			
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              +");
			LOGGER.debug("     SOAPResponseXML        : " + sResponse);
			
		} catch (IOException e) {
			LOGGER.error("Eror al invocar datosFocalizacion: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
		
		return sResponse;
	}
		
	public DetalleTotalesLlamadas walletsTotalLlamadas(String user, String pass, String dn, String token) throws Exception
	 {
		    LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
			LOGGER.info("     EndPoint               : " + urlMiIusacell);
			LOGGER.info("     Operacion              : walletsTotalLlamadas");
			LOGGER.info("     requesting             : " + new Date().toString());
			LOGGER.info("   + Parametros             + ");
			LOGGER.info("     dn                     : " + dn);
			
			String sXMLRequest = "";
			String sResponse = "";
			Certificado.agregaKS();
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(urlMiIusacell);
			DetalleTotalesLlamadas totalesLlamadasVo = new DetalleTotalesLlamadas();
			
		 
		    try {
		    	
		   	   sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
		                     "<soapenv:Header/>"+                                
		                           "<soapenv:Body>"+                                 
		                               "<mii:walletsTotalLlamadas>"+                 
		                                  "<mii:in0>"+ user  +"</mii:in0>"+         
		                                  "<mii:in1>"+ pass  +"</mii:in1>"+       
		                                  "<mii:in2>"+ dn    +"</mii:in2>"+         
		                                  "<mii:in3>"+ token +"</mii:in3>"+         
		                               "</mii:walletsTotalLlamadas>"+                
		                           "</soapenv:Body>"+                                
		                        "</soapenv:Envelope>";   
		   	   
               LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
			
			   sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			   LOGGER.info("   + Respuesta              +");
			   LOGGER.debug("     SOAPResponseXML        : " + sResponse);
			   
			   totalesLlamadasVo = ParseMiIusacellAtt.parsewalletsTotalLlamadas(sResponse);
		   	   
		    } catch (Exception e) {
		    	LOGGER.error("Eror al invocar walletsTotalLlamadas: ",e);
				throw new ServiceException(e.getLocalizedMessage());
			}
			
		    return totalesLlamadasVo;
		 
	 }
	 
	public Mensajes walletsTotalMensajes(String user, String pass, String dn, String token) throws Exception
	 {

		    LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
			LOGGER.info("     EndPoint               : " + urlMiIusacell);
			LOGGER.info("     Operacion              : walletsTotalMensajes");
			LOGGER.info("     requesting             : " + new Date().toString());
			LOGGER.info("   + Parametros             + ");
			LOGGER.info("     dn                     : " + dn);
			
			String sXMLRequest = "";
			String sResponse = "";
			Certificado.agregaKS();
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(urlMiIusacell);
			Mensajes mensajesVo = new Mensajes();
			
			try {
				
			sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
				            "<soapenv:Header/>"+                               
				            "<soapenv:Body>"+                                   
				                "<mii:walletsTotalMensajes>"+                   
				                    "<mii:in0>" + user  + "</mii:in0>"+         
				                    "<mii:in1>" + pass  + "</mii:in1>"+         
				                    "<mii:in2>" + dn    + "</mii:in2>"+         
				                    "<mii:in3>" + token + "</mii:in3>"+         
				                "</mii:walletsTotalMensajes>"+                  
				            "</soapenv:Body>"+                                  
				        "</soapenv:Envelope>";
			
			   
			   LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
			
			   sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			   LOGGER.info("   + Respuesta              +");
			   LOGGER.debug("     SOAPResponseXML        : " + sResponse);
			   
			   mensajesVo = ParseMiIusacellAtt.parsewalletsTotalMensajes(sResponse);
			
			} catch (Exception e) {
				LOGGER.error("Eror al invocar walletsTotalMensajes: ",e);
				throw new ServiceException(e.getLocalizedMessage());
			}
			
			return mensajesVo;
	 }
	 
	 public String editarCuenta(String user, String pass,String dn, LoginRegisterBean datos, String token) throws Exception
	 {
	  LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
	  LOGGER.info("     EndPoint               : " + urlMiIusacell);
	  LOGGER.info("     Operacion              : getFacturas");
	  LOGGER.info("     requesting             : " + new Date().toString());
	  LOGGER.info("   + Parametros             + ");
	  LOGGER.info("     dn                     : " + dn);
	  
	  
	  String sXMLRequest = "";
	  String sResponse = "";
	  String retorno = "";
	  Certificado.agregaKS();
	  SOAPManager soapManager = new SOAPManager();
	  soapManager.createSOAPManager(urlMiIusacell);
	  
	  try {
	   
	       sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">\")"+
	                 "<soapenv:Header/>"                                    +
	                 "<soapenv:Body>"                                       +
	                     "<mii:editarCuenta>"                               +
	                         "<mii:in0>" + user              + "</mii:in0>" +
	                         "<mii:in1>" + pass              + "</mii:in1>" +
	                         "<mii:in2>" + dn                + "</mii:in2>" +
	                         "<mii:in3>" + datos.getKeyBis() + "</mii:in3>" +
	                         "<mii:in4>" + datos.getKey()    + "</mii:in4>" +
	                         "<mii:in5>" + "NA"              + "</mii:in5>" +
	                         "<mii:in6>" + "NA"              + "</mii:in6>" +
	                         "<mii:in7>" + dn.substring(2)   + "</mii:in7>" +
	                         "<mii:in8>" + token             + "</mii:in8>" +
	                     "</mii:editarCuenta>"                              +
	                 "</soapenv:Body>"                                      +
	             "</soapenv:Envelope>"                                      ;               
	       
	       
	       LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
		    
		    sResponse = soapManager.sendRequestWithXML(sXMLRequest);
		    
		    LOGGER.info("   + Respuesta              +");
		    LOGGER.debug("     SOAPResponseXML        : " + sResponse);
		    
			retorno = ParseMiIusacellAtt.editarCuentaParse(sResponse);
		   
	  } catch (Exception e) {
		  LOGGER.error("Eror al invocar editarCuenta: ",e);
		  throw new ServiceException(e.getLocalizedMessage());
	  }
	  
		return retorno;
	  
	  
	 }
	
	 public String editarPerfil(String user, String pass,ClienteRegistroVO datos, String token) throws Exception
	    {
	  
	      LOGGER.info("  >> LLAMADA WEB SERVICE"                                         );
	         LOGGER.info("     endpoint                     : " + urlMiIusacell             );
	         LOGGER.info("     operacion                    : editarPerfil"                 );
	         LOGGER.info("   + Parametros                   +"                              );
	         LOGGER.info("     ws.usuario                   : -PROTEGIDO-"                  );
	         LOGGER.info("     ws.password                  : -PROTEGIDO-"                  );
	         LOGGER.info("     usuario.dn                   : " + datos.getDn()             );  
	         LOGGER.info("     usuario.nombre               : " + datos.getNombre()         );
	         LOGGER.info("     usuario.paterno              : " + datos.getaPaterno()       );
	         LOGGER.info("     usuario.materno              : " + datos.getaMaterno()       );
	         LOGGER.info("     usuario.correo               : " + datos.getCorreo()         );
	         LOGGER.info("     usuario.contrasena           : " + datos.getContrasena()     );        
	         LOGGER.info("     usuario.nacimiento           : " + datos.getNacimiento()     );
	         LOGGER.info("     usuario.fotografia           : " + Formatter.pintaLogCadenasLargas(datos.getFotografia()));
	         LOGGER.info("     usuario.id                   : " + datos.getDn().substring(2));
	         LOGGER.info("     ws.token                     : " + token                     );
	         
	         String sXMLRequest = "";
	   String sResponse = "";
		String retorno = "";
	   Certificado.agregaKS();
	   SOAPManager soapManager = new SOAPManager();
	   soapManager.createSOAPManager(urlMiIusacell);
	         
	         try {
	    
	           sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">\")"+
	                  "<soapenv:Header/>"                                               +
	                  "<soapenv:Body>"                                                  +
	                      "<mii:editarPerfil>"                                          +
	                          "<mii:in0>"  + user                       + "</mii:in0>"  +
	                          "<mii:in1>"  + pass                       + "</mii:in1>"  +
	                          "<mii:in2>"  + datos.getDn()              + "</mii:in2>"  +
	                          "<mii:in3>"  + datos.getNombre()          + "</mii:in3>"  +
	                          "<mii:in4>"  + datos.getaPaterno()        + "</mii:in4>"  +
	                          "<mii:in5>"  + datos.getaMaterno()        + "</mii:in5>"  +
	                          "<mii:in6>"  + datos.getCorreo()          + "</mii:in6>"  +
	                          "<mii:in7>"  + datos.getContrasena()      + "</mii:in7>"  +
	                          "<mii:in8>"  + datos.getNacimiento()      + "</mii:in8>"  +
	                          "<mii:in9>"  + datos.getFotografia()      + "</mii:in9>"  +
	                          "<mii:in10>" + datos.getDn().substring(2) + "</mii:in10>" +
	                          "<mii:in11>" + token                      + "</mii:in11>" +
	                      "</mii:editarPerfil>"                                    +
	                  "</soapenv:Body>"                                            +
	              "</soapenv:Envelope>"                                            ;
	              
	           LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
	     
	     sResponse = soapManager.sendRequestWithXML(sXMLRequest);
	     
	     LOGGER.info("   + Respuesta              +");
	     LOGGER.debug("     SOAPResponseXML        : " + sResponse);
	           
			retorno = ParseMiIusacellAtt.editarPerfilParse(sResponse);
	   } catch (Exception e) {
		   LOGGER.error("Eror al invocar editarPerfil: ",e);
	    	throw new Exception(e.getLocalizedMessage());
	   }
	         
		return retorno;
	    
	    }
	
	public List<ServiciosAdicionalesVO> getServiciosAdicionalesPorDn(String user, String pass,String dn, String token) throws Exception
    {
		LOGGER.info("  >> LLAMADA WEB SERVICE"                                         );
        LOGGER.info("     endpoint                     : " + urlMiIusacell             );
        LOGGER.info("     operacion                    : getServiciosAdicionalesPorDn" );
        LOGGER.info("   + Parametros                   +"                              );
        LOGGER.info("     ws.usuario                   : -PROTEGIDO-"                  );
        LOGGER.info("     ws.combinacion               : -PROTEGIDO-"                  );
        LOGGER.info("     datos.version                : " + ""                        );
        LOGGER.info("     datos.dn                     : " + dn                        );
        LOGGER.info("     ws.token                     : " + token                     );
        
        String sXMLRequest = "";
		String sResponse = "";
		Certificado.agregaKS();
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(urlMiIusacell);
		List<ServiciosAdicionalesVO> retorno = new ArrayList<ServiciosAdicionalesVO>();
		
		try {
			
			sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">\")"+
					           "<soapenv:Header/>"                        +
					           "<soapenv:Body>"                           +
					              "<mii:getServiciosAdicionalesPorDn>"    +
					                 "<mii:in0>" + user    + "</mii:in0>" +
					                 "<mii:in1>" + pass    + "</mii:in1>" +
					                 "<mii:in2>" + "0"     + "</mii:in2>" +
					                 "<mii:in3>" + dn      + "</mii:in3>" +
					                 "<mii:in4>" + token   + "</mii:in4>" +
					              "</mii:getServiciosAdicionalesPorDn>"   +
					           "</soapenv:Body>"                          +
					        "</soapenv:Envelope>"                         ;
				
			 LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
				
			 sResponse = soapManager.sendRequestWithXML(sXMLRequest);
				
			 LOGGER.info("   + Respuesta              +");
			 LOGGER.debug("     SOAPResponseXML        : " + sResponse);
			 
			 retorno = ParseMiIusacellAtt.parsegetServiciosAdicionalesPorDn(sResponse);
					           
						
		} catch (Exception e) {
			LOGGER.error("Eror al invocar getServiciosAdicionalesPorDn: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
        
		return retorno;
        
    }
	
	public List<CatalogoAbonos> getCatalogoAbonos (String user, String pass, String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		String url = urlMiIusacell;
		List<CatalogoAbonos> listCatalogo = new ArrayList<CatalogoAbonos>();
		
		
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : getCatalogoAbonos");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);		
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
					"   <soapenv:Header/>"+
					"   <soapenv:Body>"+
					"      <mii:getCatalogoAbonos>"+
					"         <mii:in0>"+ user +"</mii:in0>"+
					"         <mii:in1>"+ pass +"</mii:in1>"+
					"         <mii:in2>"+ token + "</mii:in2>"+
					"      </mii:getCatalogoAbonos>"+
					"   </soapenv:Body>"+
					"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           : " +  sResponse);
   		    
   		 listCatalogo = ParseMiIusacellAtt.parsegetCatalogoAbono(sResponse);
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar getCatalogoAbonos: ",e);
			throw new Exception(e.getMessage());
		}
		return listCatalogo;
	}	

	public String registroTarjetas(String user, String pass, TarjetaVO tarjeta, String usuarioId, String token) throws Exception
	{
		String url = urlMiIusacell;
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint                 : " + url);
		LOGGER.info("     Operacion                : registroTarjetas");
		LOGGER.info("     requesting               : " + new Date().toString());
		LOGGER.info("   + Parametros               + ");
		LOGGER.info("     tarjeta.aPaterno	       : " + tarjeta.getaPaterno());
		LOGGER.info("     tarjeta.aMaterno	 	   : " + tarjeta.getaMaterno());
		LOGGER.info("     tarjeta.Nombre	       : " + tarjeta.getNombre());
		LOGGER.info("     tarjeta.AnioVencimiento  : " + tarjeta.getAnioVencimiento());		
		LOGGER.info("     tarjeta.Cp	           : " + tarjeta.getCp());
		LOGGER.info("     tarjeta.Dn	           : " + tarjeta.getDn());
		LOGGER.info("     tarjeta.MarcaTarjeta	   : " + tarjeta.getMarcaTarjeta());
		LOGGER.info("     tarjeta.MesVencimiento   : " + tarjeta.getMesVencimiento());		
		LOGGER.info("     tarjeta.NumeroTarjeta	   : " + tarjeta.getNumeroTarjeta());
		LOGGER.info("     tarjeta.UltimosDigitos   : " + tarjeta.getUltimosDigitos());	
		LOGGER.info("     usuarioId	               : " + usuarioId);
		LOGGER.info("     token                    : " + Formatter.pintaLogCadenasLargas(token));

		String sXMLRequest = "";
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(url);
		String sResponse = "";
		String respuesta = "";

		try
		{

			Certificado.agregaKS();

			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\" xmlns:vo=\"http://vo.miiusacell.services.iusacell.com.mx\">" +
					"<soapenv:Header/>" +
					"<soapenv:Body>" +
					"<mii:registroTarjetas>" +
					"<mii:in0>"+user+"</mii:in0>" +
					"<mii:in1>"+pass+"</mii:in1>" +
					"<mii:in2>" +
					"<vo:aMaterno>"+tarjeta.getaMaterno()+"</vo:aMaterno>" +
					"<vo:aPaterno>"+tarjeta.getaPaterno()+"</vo:aPaterno>" +
					"<vo:anioVencimiento>"+tarjeta.getAnioVencimiento()+"</vo:anioVencimiento>" +
					"<vo:cp>"+tarjeta.getCp()+"</vo:cp>" +
					"<vo:dn>"+tarjeta.getDn()+"</vo:dn>" +
					"<vo:marcaTarjeta>"+tarjeta.getMarcaTarjeta()+"</vo:marcaTarjeta>" +
					"<vo:mesVencimiento>"+tarjeta.getMesVencimiento()+"</vo:mesVencimiento>" +
					"<vo:nombre>"+tarjeta.getNombre()+"</vo:nombre>" +
					"<vo:numeroTarjeta>"+tarjeta.getNumeroTarjeta()+"</vo:numeroTarjeta>" +
					"<vo:ultimosDigitos>"+tarjeta.getUltimosDigitos()+"</vo:ultimosDigitos>" +
					"</mii:in2>" +
					"<mii:in3>"+usuarioId+"</mii:in3>" +
					"<mii:in4>"+token+"</mii:in4>" +
					"</mii:registroTarjetas>" +
					"</soapenv:Body>" +
					"</soapenv:Envelope>";

			LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);

			//********************************
			//Enviamos la peticion al servidor
			//********************************
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);

			LOGGER.info("   + Respuesta              + ");
			LOGGER.debug("     SOAPResponseXML        : " + sResponse);

			respuesta = ParseMiIusacellAtt.parseRegistroTarjetas(sResponse);
		}
		catch(Exception e)
		{
			LOGGER.error("Eror al invocar registroTarjetas: ",e);
			sResponse = "";
			throw new Exception("Al consultar la url: " + url + " :: " + e.getMessage());
		}
		return respuesta;

	}

	public DetalleFacturaVO detalleFactura (String user, String pass, String dn, String facturaUrl, String token) throws Exception{

     	  LOGGER.info("  >> LLAMADA WEB SERVICE"                                         );
	      LOGGER.info("     endpoint                     : " + urlMiIusacell             );
	      LOGGER.info("     operacion                    : detalleFactura"               );
	      LOGGER.info("   + Parametros                   +"                              );
	      LOGGER.info("     ws.user                      : -PROTEGIDO-"                  );
	      LOGGER.info("     ws.pass                      : -PROTEGIDO-"                  );
	      LOGGER.info("     datos.dn                     : " + ""                        );
	      LOGGER.info("     datos.facturaUrl             : " + dn                        );
	      LOGGER.info("     ws.token                     : " + token                     );
	      

			
			 String sXMLRequest = "";
			 String sResponse = "";
			 Certificado.agregaKS();
			 DetalleFacturaVO detalleFactura =  null;
			 SOAPManager soapManager = new SOAPManager();
			 soapManager.createSOAPManager(urlMiIusacell);
			
			try {
				
				sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
							"<soapenv:Header/>"+
							"<soapenv:Body>"+
							"   <mii:detalleFactura>"+
							"      <mii:in0>"+user+"</mii:in0>"+
							"      <mii:in1>"+pass+"</mii:in1>"+
							"      <mii:in2>"+dn+"</mii:in2>"+
							"      <mii:in3>"+facturaUrl+"</mii:in3>"+
							"      <mii:in4>"+token+"</mii:in4>"+
							"   </mii:detalleFactura>"+
							"</soapenv:Body>"+
							"</soapenv:Envelope>";
					
				 LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
					
				 sResponse = soapManager.sendRequestWithXML(sXMLRequest);
				 
				 LOGGER.info("   + Respuesta              +");
				 LOGGER.debug("     SOAPResponseXML        : " + sResponse);
				 
				 detalleFactura=ParseMiIusacellAtt.parseDetalleFactura(sResponse);
				 
					
			} catch (Exception e) {
				LOGGER.error("Eror al invocar detalleFactura: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}

		return detalleFactura;

	}

	public AbonoTiempoAireVO abonoTiempoAireBit(String user,String pass, String dn, String dnParaAbono, String anioExpira, String cdgSeguridad, String concepto, String importe, String mesExpira, String numTarjeta, String tipoTarjeta, String ip, String secuencia, String login, String tipoPlataforma, String compania, String sistemaOrigen, String dispositivo,String token) throws Exception{

		LOGGER.info("  >> LLAMADA WEB SERVICE"                                         );
		LOGGER.info("     endpoint                     : " + urlMiIusacell             );
		LOGGER.info("     operacion                    :     abonoTiempoAireBit"       );
		LOGGER.info("   + Parametros                   +"                              );
		LOGGER.info("     ws.usuario                   : -PROTEGIDO-"                  );
		LOGGER.info("     ws.pass                      : -PROTEGIDO-"                  );
		LOGGER.info("     datos.dn                     : " + dn                        );
		LOGGER.info("     datos.dnParaAbono            : " + dnParaAbono               );
		LOGGER.info("     datos.anioExpira             : " + anioExpira                );
		LOGGER.info("     datos.cdgSeguridad           : " + cdgSeguridad              );
		LOGGER.info("     datos.concepto               : " + concepto                  );
		LOGGER.info("     datos.importe                : " + importe                   );
		LOGGER.info("     datos.mesExpira              : " + mesExpira                 );
		LOGGER.info("     datos.numTarjeta             : " + numTarjeta                );
		LOGGER.info("     datos.tipoTarjeta            : " + tipoTarjeta               );
		LOGGER.info("     datos.ip                     : " + ip                        );
		LOGGER.info("     datos.secuencia              : " + secuencia                 );
		LOGGER.info("     datos.login                  : " + login                     );
		LOGGER.info("     datos.tipoPlataforma         : " + tipoPlataforma            );
		LOGGER.info("     datos.compania               : " + compania                  );
		LOGGER.info("     datos.sistemaOrigen          : " + sistemaOrigen             );
		LOGGER.info("     datos.dispositivo            : " + dispositivo               );
		LOGGER.info("     ws.token                     : " + token                     );

		String sXMLRequest = "";
		String sResponse = "";
		Certificado.agregaKS();
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(urlMiIusacell);
		AbonoTiempoAireVO abonoTiempoAire = null;

		try {
			sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
					"<soapenv:Header/>"+
					"<soapenv:Body>"+
					"<mii:abonoTiempoAireBit>"+
					"<mii:in0>"+user+"</mii:in0>"+
					"<mii:in1>"+pass+"</mii:in1>"+
					"<mii:in2>"+dn+"</mii:in2>"+
					"<mii:in3>"+dnParaAbono+"</mii:in3>"+
					"<mii:in4>"+anioExpira+"</mii:in4>"+
					"<mii:in5>"+cdgSeguridad+"</mii:in5>"+
					"<mii:in6>"+concepto+"</mii:in6>"+
					"<mii:in7>"+importe+"</mii:in7>"+
					"<mii:in8>"+mesExpira+"</mii:in8>"+
					"<mii:in9>"+numTarjeta+"</mii:in9>"+
					"<mii:in10>"+tipoTarjeta+"</mii:in10>"+
					"<mii:in11>"+ip+"</mii:in11>"+
					"<mii:in12>"+secuencia+"</mii:in12>"+
					"<mii:in13>"+login+"</mii:in13>"+
					"<mii:in14>"+tipoPlataforma+"</mii:in14>"+
					"<mii:in15>"+compania+"</mii:in15>"+
					"<mii:in16>"+sistemaOrigen+"</mii:in16>"+
					"<mii:in17>"+dispositivo+"</mii:in17>"+
					"<mii:in18>"+token+"</mii:in18>"+
					"</mii:abonoTiempoAireBit>"+
					"</soapenv:Body>"+
					"</soapenv:Envelope>";

			LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);

			sResponse = soapManager.sendRequestWithXML(sXMLRequest);

			LOGGER.info("   + Respuesta              +");
			LOGGER.debug("     SOAPResponseXML        : " + sResponse);

			abonoTiempoAire = ParseMiIusacellAtt.parseAbonoTiempoAire(sResponse);



		}catch (Exception e) {
			LOGGER.error("Eror al invocar abonoTiempoAireBit: ",e);
			throw new ServiceException (e.getLocalizedMessage());
		}


		return abonoTiempoAire;

	}	

	public int bajaNumeroFrencuente(String user, String pass, String dn, String telefonoBaja, String usuarioid, String token) throws Exception
	{
		StringBuilder requestXML = new StringBuilder();
		String sResponse = "";		
		int vo = -1;

		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e"             );
		LOGGER.info("     EndPoint               : " + urlMiIusacell         );
		LOGGER.info("     Operacion              : bajaNumeroFrencuente"     );
		LOGGER.info("     requesting             : " + new Date().toString() );
		LOGGER.info("   + Parametros             + "                         );
		LOGGER.info("     user                   : " + user                  );
		LOGGER.info("     pass                   : " + pass                  );
		LOGGER.info("     dn                     : " + dn                    );
		LOGGER.info("     telefono.baja          : " + telefonoBaja          );
		LOGGER.info("     usuario.id             : " + usuarioid             );
		LOGGER.info("     token                  : " + token                 );

		try
		{

			requestXML.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">");
			requestXML.append(    "<soapenv:Header/>"                               );
			requestXML.append(    "<soapenv:Body>"                                  );
			requestXML.append(        "<mii:bajaNumeroFrencuente>"                  );
			requestXML.append(            "<mii:in0>" + user         + "</mii:in0>" );
			requestXML.append(            "<mii:in1>" + pass         + "</mii:in1>" );
			requestXML.append(            "<mii:in2>" + dn           + "</mii:in2>" );
			requestXML.append(            "<mii:in3>" + telefonoBaja + "</mii:in3>" );
			requestXML.append(            "<mii:in4>" + usuarioid    + "</mii:in4>" );
			requestXML.append(            "<mii:in5>" + token        + "</mii:in5>" );
			requestXML.append(        "</mii:bajaNumeroFrencuente>"                 );
			requestXML.append(    "</soapenv:Body>"                                 );
			requestXML.append("</soapenv:Envelope>"                                 );

			LOGGER.debug("     SOAPRequestXML         : " + requestXML.toString());

			Certificado.agregaKS();
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(urlMiIusacell);

			sResponse = soapManager.sendRequestWithXML(requestXML.toString());

			LOGGER.info("   + Respuesta              + ");
			LOGGER.debug("     XMLRespuesta           : " + sResponse);

			vo = ParseMiIusacellAtt.bajaNumeroFrencuente(sResponse);
		}
		catch (Exception e)
		{
			LOGGER.error("Eror al invocar bajaNumeroFrencuente: ",e);
			throw new Exception(e.getMessage());
		}
		return vo;
	}

	public ContratarServiciosVO bajaServiciosPass(String user, String pass, String mdn, String idServicio, AltaServicioLegacyVO datosAlta, String valida2c, String token) throws Exception
	{
		StringBuilder requestXML = new StringBuilder();
		String sResponse = "";        
		ContratarServiciosVO vo = null;

		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e"             );
		LOGGER.info("     EndPoint               : " + urlMiIusacell         );
		LOGGER.info("     Operacion              : bajaServiciosPass"        );
		LOGGER.info("     requesting             : " + new Date().toString() );
		LOGGER.info("   + Parametros             + "                         );
		LOGGER.info("     user                   : " + user                  );
		LOGGER.info("     pass                   : " + pass                  );
		LOGGER.info("     mdn                    : " + mdn                   );
		LOGGER.info("     idservicio             : " + idServicio            );
		LOGGER.info("     continente.favortio    : " + datosAlta.getContinenteFavortio()    );
		LOGGER.info("     dn.usa                 : " + datosAlta.getDnUsa()                 );
		LOGGER.info("     servicios              : " + datosAlta.getServicios()             );
		LOGGER.info("     in5                    : " + valida2c                   );
		LOGGER.info("     token                  : " + token                 );

		try
		{            

			requestXML.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\" xmlns:vo=\"http://vo.miiusacell.services.iusacell.com.mx\">");
			requestXML.append(    "<soapenv:Header/>"                                                                     );
			requestXML.append(    "<soapenv:Body>"                                                                        );
			requestXML.append(        "<mii:bajaServiciosPass>"                                                           );
			requestXML.append(            "<mii:in0>" + user  + "</mii:in0>"                                              );
			requestXML.append(            "<mii:in1>" + pass  + "</mii:in1>"                                              );
			requestXML.append(            "<mii:in2>" + mdn   + "</mii:in2>"                                              );
			requestXML.append(            "<mii:in3>" + idServicio   + "</mii:in3>"                                       );
			requestXML.append(            "<mii:in4>"                                                                     );
			requestXML.append(                "<vo:continenteFavortio>" + datosAlta.getContinenteFavortio() + "</vo:continenteFavortio>" );
			requestXML.append(                "<vo:dnUsa>"              + datosAlta.getDnUsa()              + "</vo:dnUsa>"              );
			requestXML.append(                "<vo:servicios>"          + datosAlta.getServicios()          + "</vo:servicios>"          );
			requestXML.append(            "</mii:in4>"                                                                    );
			requestXML.append(            "<mii:in5>" + valida2c   + "</mii:in5>"                                              );
			requestXML.append(            "<mii:in6>" + token + "</mii:in6>"                                              );
			requestXML.append(        "</mii:bajaServiciosPass>"                                                          );
			requestXML.append(    "</soapenv:Body>"                                                                       );
			requestXML.append("</soapenv:Envelope>"                                                                       );

			LOGGER.debug("     SOAPRequestXML         : " + requestXML.toString());
			Certificado.agregaKS();
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(urlMiIusacell);
			sResponse = soapManager.sendRequestWithXML(requestXML.toString());

			LOGGER.info("   + Respuesta              + ");
			LOGGER.debug("     XMLRespuesta           : " + sResponse);

			vo = ParseMiIusacellAtt.bajaServiciosPass(sResponse);
		}
		catch (Exception e)
		{
			LOGGER.error("Eror al invocar bajaServiciosPass: ",e);
			throw new Exception(e.getMessage());
		}
		return vo;
	}

	public String bajaTarjeta(String user, String pass, String dn, String marcaTarjetaId, String numtarjeta, String usuarioID, String token)  throws ServiceException{

		LOGGER.info("  >> LLAMADA WEB SERVICE"                                         );
		LOGGER.info("     endpoint                     : " + urlMiIusacell             );
		LOGGER.info("     operacion                    : bajaTarjeta"                  );
		LOGGER.info("   + Parametros                   +"                              );
		LOGGER.info("     ws.usuario                   : -PROTEGIDO-"                  );
		LOGGER.info("     ws.pass                      : -PROTEGIDO-"                  );
		LOGGER.info("     datos.version                : " + ""                        );
		LOGGER.info("     datos.dn                     : " + dn                        );
		LOGGER.info("     datos.marcaTarjetaId         : " + marcaTarjetaId            );
		LOGGER.info("     datos.numtarjeta             : " + numtarjeta                );
		LOGGER.info("     datos.usuarioID              : " + usuarioID                 );
		LOGGER.info("     ws.token                     : " + token                     );

		String sXMLRequest = "";
		String sResponse = "";		
		String resultado="";

		try {
			sXMLRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"+
					"<soapenv:Header/>"+
					"<soapenv:Body>"+
					"<mii:bajaTarjeta>"+
					"<mii:in0>"+user+"</mii:in0>"+
					"<mii:in1>"+pass+"</mii:in1>"+
					"<mii:in2>"+dn+"</mii:in2>"+
					"<mii:in3>"+marcaTarjetaId+"</mii:in3>"+
					"<mii:in4>"+numtarjeta+"</mii:in4>"+
					"<mii:in5>"+usuarioID+"</mii:in5>"+
					"<mii:in6>"+token+"</mii:in6>"+
					"</mii:bajaTarjeta>"+
					"</soapenv:Body>"+
					"</soapenv:Envelope>";

			LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
			
			Certificado.agregaKS();		
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(urlMiIusacell);

			sResponse = soapManager.sendRequestWithXML(sXMLRequest);

			LOGGER.info("   + Respuesta              +");
			LOGGER.debug("     SOAPResponseXML        : " + sResponse);

			resultado = ParseMiIusacellAtt.parseBajaTarjeta(sResponse);


		} catch (Exception e) {
			LOGGER.error("Eror al invocar bajaTarjeta: ",e);
			throw new ServiceException(e.getMessage());
		}

		return resultado;

	}

	public ContratarServiciosVO contrataServicios(String user, String pass, String dn, AltaServicioEtakVO datosAltaEtak, AltaServicioLegacyVO datosAlta, AltaServicioPrepagoLegacyVO datosAltaPrepago, String compania, String sistemaOrigen,String dispositivo,String login, String token) throws ServiceException{ 

        LOGGER.info("  >> LLAMADA WEB SERVICE"                                         ); 
        LOGGER.info("     endpoint                     : " + urlMiIusacell             ); 
        LOGGER.info("     operacion                    : contrataServicios" ); 
        LOGGER.info("   + Parametros                   +"                              ); 
        LOGGER.info("     ws.usuario                   : -PROTEGIDO-"                  ); 
        LOGGER.info("     ws.pass                      : -PROTEGIDO-"                  ); 
        LOGGER.info("     datos.dn                     : " + dn                        ); 
        LOGGER.info("     AltaServicioEtakVO           : " + datosAltaEtak             ); 

        if(datosAltaEtak != null){ 
                LOGGER.info("     IdHistorico            : " + datosAltaEtak.getIdHistorico()); 
                LOGGER.info("     Vigencia               : " + datosAltaEtak.getVigencia()); 
        } 
        LOGGER.info("     DatosAltaLEGACY        : " ); 
        if(datosAlta != null){ 
                LOGGER.info("     Servicios              : " + datosAlta.getServicios()); 
        }else{ 
                datosAlta = new AltaServicioLegacyVO(); 
        } 
        if(datosAltaPrepago != null){ 
                LOGGER.info("     ServicioOrigen         : " + datosAltaPrepago.getServicioOrigen()); 
                LOGGER.info("     VigenciasCantidad      : " + datosAltaPrepago.getVigenciasCantidad()); 
                LOGGER.info("     VigenciasUnidad        : " + datosAltaPrepago.getVigenciasUnidad()); 
                LOGGER.info("     ServiciosId            : " + datosAltaPrepago.getServiciosId()); 
        } 

        LOGGER.info("     compania                     : " + compania                  ); 
        LOGGER.info("     sistemaOrigen                : " + sistemaOrigen             ); 
        LOGGER.info("     dispositivo                  : " + dispositivo               ); 
        LOGGER.info("     login                        : " + login                     ); 
        LOGGER.info("     ws.token                     : " + token                     ); 




        String sXMLRequest = ""; 
        String sResponse = "";                 
        ContratarServiciosVO  contratarServicios = null;                 

        try { 

                sXMLRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\" xmlns:vo=\"http://vo.miiusacell.services.iusacell.com.mx\">"+ 
                                "<soapenv:Header/>"+ 
                                "<soapenv:Body>"+ 
                                "<mii:contrataServicios>"+ 
                                "<mii:in0>"+user+"</mii:in0>"+ 
                                "<mii:in1>"+pass+"</mii:in1>"+ 
                                "<mii:in2>"+dn+"</mii:in2>"+ 
                                "<mii:in3>"+ 
                                "<vo:idHistorico>"+datosAltaEtak.getIdHistorico()+"</vo:idHistorico>"+ 
                                "<vo:vigencia>"+datosAltaEtak.getVigencia()+"</vo:vigencia>"+ 
                                "</mii:in3>"+ 
                                "<mii:in4>"+ 
                                "<vo:servicios>"+datosAlta.getServicios()+"</vo:servicios>"+ 
                                "</mii:in4>"+ 
                                "<mii:in5>"+ 
                                "<vo:servicioOrigen>"+datosAltaPrepago.getServicioOrigen()+"</vo:servicioOrigen>"+ 
                                "<vo:vigenciasCantidad>"+datosAltaPrepago.getVigenciasCantidad()+"</vo:vigenciasCantidad>"+ 
                                "<vo:vigenciasUnidad>"+datosAltaPrepago.getVigenciasUnidad()+"</vo:vigenciasUnidad>"+ 
                                "<vo:serviciosId>"+datosAltaPrepago.getServiciosId()+"</vo:serviciosId>"+ 
                                "</mii:in5>"+ 
                                "<mii:in6>"+compania+"</mii:in6>"+ 
                                "<mii:in7>"+sistemaOrigen+"</mii:in7>"+ 
                                "<mii:in8>"+dispositivo+"</mii:in8>"+ 
                                "<mii:in9>"+login+"</mii:in9>"+ 
                                "<mii:in10>"+token+"</mii:in10>"+ 
                                "</mii:contrataServicios>"+ 
                                "</soapenv:Body>"+ 
                                "</soapenv:Envelope>"; 

                LOGGER.info("     SOAPRequestXML         : " + sXMLRequest); 
                Certificado.agregaKS(); 
                SOAPManager soapManager = new SOAPManager(); 
                soapManager.createSOAPManager(urlMiIusacell); 

                sResponse = soapManager.sendRequestWithXML(sXMLRequest); 

                LOGGER.info("   + Respuesta              +"); 
                LOGGER.info("     SOAPResponseXML        : " + sResponse); 

                contratarServicios=ParseMiIusacellAtt.parseContratarServicios(sResponse); 

        } catch (Exception e) { 
			LOGGER.error("Eror al invocar contrataServicios: ",e);
                throw new ServiceException(e.getLocalizedMessage()); 
        } 

        return contratarServicios;                         
	}

	
	public List<NumerosFrecuentesVO> obtieneNumeros(String user, String pass,String dn, String token) throws Exception
    {
		LOGGER.info("  >> LLAMADA WEB SERVICE"                                         );
        LOGGER.info("     endpoint                     : " + urlMiIusacell             );
        LOGGER.info("     operacion                    : obtieneNumeros" );
        LOGGER.info("   + Parametros                   +"                              );
        LOGGER.info("     user                         : -PROTEGIDO-"                  );
        LOGGER.info("     pass                         : -PROTEGIDO-"                  );       
        LOGGER.info("     dn                           : " + dn                        );
        LOGGER.info("     token                        : " + token                     );
        
        String sXMLRequest = "";
		String sResponse = "";
		Certificado.agregaKS();
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(urlMiIusacell);
		List<NumerosFrecuentesVO> retorno;
		
		try {
			
			sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">" +
						   "<soapenv:Header/>" +
						   "<soapenv:Body>" +
						   "<mii:obtieneNumeros>" +
						   "   <mii:in0>" + user +"</mii:in0>" +
						   "    <mii:in1>" + pass +"</mii:in1>" +
						   "     <mii:in2>" + dn +"</mii:in2>" +
						   "      <mii:in3>" + token +"</mii:in3>" +
						   "    </mii:obtieneNumeros>" +
						   "  </soapenv:Body>" +
						   "</soapenv:Envelope>";
				
			 LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
				
			 sResponse = soapManager.sendRequestWithXML(sXMLRequest);
				
			 LOGGER.info("   + Respuesta              +");
			 LOGGER.debug("     SOAPResponseXML        : " + sResponse);
			 
			 retorno = ParseMiIusacellAtt.parseObtieneNumeros(sResponse);
					           
						
		} catch (Exception e) {
			LOGGER.error("Eror al invocar obtieneNumeros: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
        
		return retorno;
        
    }
	
	public PagoFacturaResponseVO pagarFactura(String user, String pass, String dn, CardVO tarjeta, String tipoPlataforma, String compania, String sistemaOrigen, String dispositivo, String valida2c, String token) throws Exception{
		       
		
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint                     : " + urlMiIusacell);
		LOGGER.info("     Operacion                    : pagarFactura");
		LOGGER.info("     requesting                   : " + new Date().toString());
		LOGGER.info("   + Parametros                   + ");
		LOGGER.info("     dn                           : " + dn);
		LOGGER.info("     tarjeta.Amount               : " + tarjeta.getAmount());
		LOGGER.info("     tarjeta.CardExpiryYear       : " + tarjeta.getCardExpiryYear());
		LOGGER.info("     tarjeta.CardNumber           : " + tarjeta.getCardNumber());
		LOGGER.info("     tarjeta.CardSecurityCode     : " + tarjeta.getCardSecurityCode());
		LOGGER.info("     tipoPlataforma               : " + tipoPlataforma);
		LOGGER.info("     compania                     : " + compania);
		LOGGER.info("     sistemaOrigen                : " + sistemaOrigen);
		LOGGER.info("     dispositivo                  : " + dispositivo);
		LOGGER.info("     valida2c                     : " + valida2c);
		LOGGER.info("     token                        : " + token                     );
		
		String sXMLRequest = "";
		String sResponse = "";
		SOAPManager soapManager = new SOAPManager();
		soapManager.createSOAPManager(urlMiIusacell);
		PagoFacturaResponseVO respuesta;
		
		Certificado.agregaKS();
		
		
		try {
			
			sXMLRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\" xmlns:vo=\"http://vo.miiusacell.services.iusacell.com.mx\">" +
					"<soapenv:Header/> " +
					"<soapenv:Body>" +
					"<mii:pagarFactura>" +
					"<mii:in0>"+user+"</mii:in0>" +
					"<mii:in1>"+pass+"</mii:in1>" +
					"<mii:in2>"+dn+"</mii:in2>" +
					"<mii:in3>" +
					"<vo:amount>"+tarjeta.getAmount()+"</vo:amount>" +
					"<vo:cardExpiryMonth>"+tarjeta.getCardExpiryMonth()+"</vo:cardExpiryMonth>" +
					"<vo:cardExpiryYear>"+tarjeta.getCardExpiryYear()+"</vo:cardExpiryYear>" +
					"<vo:cardNumber>"+tarjeta.getCardNumber()+"</vo:cardNumber>" +
					"<vo:cardSecurityCode>"+tarjeta.getCardSecurityCode()+"</vo:cardSecurityCode>" +
					"</mii:in3>" +
					"<mii:in4>"+tipoPlataforma+"</mii:in4>" +
					"<mii:in5>"+compania+"</mii:in5>" +
					"<mii:in6>"+sistemaOrigen+"</mii:in6>" +
					"<mii:in7>"+dispositivo+"</mii:in7>" +
					"<mii:in8>"+valida2c+"</mii:in8>" +
					"<mii:in9>"+token+"</mii:in9>" +
					"</mii:pagarFactura>" +
					"</soapenv:Body>" +
					"</soapenv:Envelope>";
			
            LOGGER.debug("     SOAPRequestXML         : " + sXMLRequest);
			
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              +");
			LOGGER.debug("     SOAPResponseXML        : " + sResponse);
			
			respuesta = ParseMiIusacellAtt.parsePagoFactura(sResponse);		
			
		} catch (Exception e) {
			LOGGER.error("Eror al invocar pagarFactura: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}			
		
		return respuesta;
		
	}
	
	public CatalogoMovilCaeVO obtieneListaVersionCaeS (String user, String pass, int canal,int idAplicacion,int version, String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		CatalogoMovilCaeVO sRespuesta;		
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + urlMiIusacell);
		LOGGER.info("     Operacion              : obtieneListaVersionCaeS");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);
		LOGGER.info("     canal                  : " + canal);
		LOGGER.info("     idAplicacion           : " + idAplicacion);
		LOGGER.info("     version                : " + version);
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">" +
						   "<soapenv:Header/>" +
						   "<soapenv:Body>" +
						      "<mii:obtieneListaVersionCaeS>" +
						         "<mii:in0>"+user+"</mii:in0>" +
						         "<mii:in1>"+pass+"</mii:in1>" +
						         "<mii:in2>"+canal+"</mii:in2>" +
						         "<mii:in3>"+idAplicacion+"</mii:in3>" +
						         "<mii:in4>"+version+"</mii:in4>" +
						         "<mii:in5>"+token+"</mii:in5>" +
						      "</mii:obtieneListaVersionCaeS>" +
						   "</soapenv:Body>" +
						"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(urlMiIusacell);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           :  " +  sResponse);
   		    
   		    sRespuesta = ParseMiIusacellAtt.parseObtieneListaVersionCaes(sResponse);
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar obtieneListaVersionCaeS: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
		return sRespuesta;
	}
	
	public List<ServiciosBundlesAdicionales> obtenerServiciosBundles(String user, String pass, int version, String dn, String token) throws Exception
	{
		String sXMLRequest = "";
		String sResponse="";
		String url = urlMiIusacell;
		List<ServiciosBundlesAdicionales> listServicios = new ArrayList<ServiciosBundlesAdicionales>();
		
		
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : obtenerServiciosBundles");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);		
		LOGGER.info("     version                : " + version);
		LOGGER.info("     Dn                     : " + dn);
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">" +
					   "<soapenv:Header/>" +
					   "<soapenv:Body>" +
					      "<mii:obtenerServiciosBundles>" +
					         "<mii:in0>"+ user +"</mii:in0>" +
					         "<mii:in1>"+ pass +"</mii:in1>" +
					         "<mii:in2>"+ version +"</mii:in2>" +
					         "<mii:in3>"+ dn +" </mii:in3>" +
					         "<mii:in4>"+ token +"</mii:in4>" +
					      "</mii:obtenerServiciosBundles>" +
					   "</soapenv:Body>" +
					"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           : " +  sResponse);
   		    
   		 listServicios = ParseMiIusacellAtt.parseObtenerServiciosBundles(sResponse);
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar obtenerServiciosBundles: ",e);
			throw new Exception(e.getMessage());			
		}
		return listServicios;
	}
	
	public List<ConsultaWalletGeneralVO> consultaWallets(String user, String pass, String dn,String compania, String token) throws Exception
	{
		String sXMLRequest = "";
		String sResponse="";
		String url = urlMiIusacell;
		List<ConsultaWalletGeneralVO> listServicios = null;
		
		
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + url);
		LOGGER.info("     Operacion              : obtenerServiciosBundles");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);	
		LOGGER.info("     Dn                     : " + dn);
		LOGGER.info("     compania               : " + compania);		
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">" +
						   "<soapenv:Header/>" +
						   "<soapenv:Body>" +
						      "<mii:consultaWallets>" +
						         "<mii:in0>"+user+"</mii:in0>" +
						         "<mii:in1>"+pass+"</mii:in1>" +
						         "<mii:in2>"+dn+"</mii:in2>" +
						         "<mii:in3>"+compania+"</mii:in3>" +
						         "<mii:in4>"+token+"</mii:in4>" +
						      "</mii:consultaWallets>" +
						   "</soapenv:Body>" +
						"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(url);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           : " +  sResponse);
   		    
   		 listServicios = ParseMiIusacellAtt.parseConsultaWallets(sResponse);
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar consultaWallets: ",e);
			throw new Exception(e.getMessage());			
		}
		return listServicios;
	}

	public String getIdOperador (final String user, final String pass, final String dn, final String token) throws Exception 
	{
		String sXMLRequest = "";
		String sResponse="";
		String sRespuesta="";		
		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + urlMiIusacell);
		LOGGER.info("     Operacion              : getIdOperador");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");
		LOGGER.info("     user                   : " + user);
		LOGGER.info("     pass                   : " + pass);
		LOGGER.info("     Dn                     : " + dn);		
		LOGGER.info("     token                  : " + token);
        
		Certificado.agregaKS();
		
		try {
			
			sXMLRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mii=\"http://miiusacell.services.iusacell.com.mx\">"
					   +"<soapenv:Header/>"
					   +"<soapenv:Body>"
					   +"   <mii:getIdOperador>"
					   +"      <mii:in0>"+user+"</mii:in0>"
					   +"      <mii:in1>"+pass+"</mii:in1>"
					   +"      <mii:in2>"+dn+"</mii:in2>"
					   +"      <mii:in3>"+token+"</mii:in3>"
					   +"   </mii:getIdOperador>"
					   +"</soapenv:Body>"
					   +"</soapenv:Envelope>";
			
			
            LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);
			
			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(urlMiIusacell);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest);
			
			LOGGER.info("   + Respuesta              + ");
   		    LOGGER.debug("     XMLRespuesta           :  " +  sResponse);
   		    
   		    sRespuesta = ParseMiIusacellAtt.getIdOperador(sResponse);
   		    
		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar getIdOperador: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
		return sRespuesta;
	}
}