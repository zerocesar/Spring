package mx.com.att.business.call;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;

import mx.com.att.utils.ATTConstants;
import mx.com.att.vo.red.AbonoTiempoAireVO;
import mx.com.att.vo.red.CatalogoAbonos;
import mx.com.att.vo.red.CatalogoCaeGeneralVO;
import mx.com.att.vo.red.CatalogoMovilCaeVO;
import mx.com.att.vo.red.ConfiguracionXUsuarioMovilVO;
import mx.com.att.vo.red.ConsultaOperadorExtendidoVO;
import mx.com.att.vo.red.ConsultaWalletGeneralVO;
import mx.com.att.vo.red.ConsultaWalletListVO;
import mx.com.att.vo.red.ConsumoDetalleTablaVO;
import mx.com.att.vo.red.ConsumoFechaTablaVO;
import mx.com.att.vo.red.ContratarServiciosVO;
import mx.com.att.vo.red.DatosFacturasVO;
import mx.com.att.vo.red.DatosFocalizacion;
import mx.com.att.vo.red.DatosFocalizacionFocaVO;
import mx.com.att.vo.red.DatosFocalizacionUsuario;
import mx.com.att.vo.red.DatosLogin;
import mx.com.att.vo.red.DatosUltimasFacturasVO;
import mx.com.att.vo.red.DetalleFacturaVO;
import mx.com.att.vo.red.DetalleSaldoVO;
import mx.com.att.vo.red.DetalleTotalesLlamadas;
import mx.com.att.vo.red.Llamadas;
import mx.com.att.vo.red.MensajeMailVO;
import mx.com.att.vo.red.Mensajes;
import mx.com.att.vo.red.MinutosComunidad;
import mx.com.att.vo.red.MinutosTodoDestino;
import mx.com.att.vo.red.Navegacion;
import mx.com.att.vo.red.NumerosFrecuentesVO;
import mx.com.att.vo.red.ObtenerDescripcionPlanesVO1;
import mx.com.att.vo.red.PagoFacturaResponseVO;
import mx.com.att.vo.red.PermisosClienteVO;
import mx.com.att.vo.red.ServiciosAdicionalesVO;
import mx.com.att.vo.red.ServiciosBundlesAdicionales;
import mx.com.att.vo.red.TarjetasFrecuentesVO;
import mx.com.att.vo.red.WalletsDetalleVO;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ParseMiIusacellAtt {
	private static final Logger LOGGER = Logger.getLogger(ParseMiIusacellAtt.class);

	public static String idOperdador(String resultadoXML){

		String idOperador = null;
		try {
			validaExcepcion(resultadoXML);
			
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			Document doc;
			NodeList childrens;

			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			childrens = doc.getElementsByTagName("idOperador");
			if(childrens != null && childrens.getLength() > 0){
				idOperador = childrens.item(0).getTextContent();
			}
			LOGGER.info("idOperador:  {"+idOperador+"}");
			if (idOperador == null || (!idOperador.equals(String.valueOf(ATTConstants.CARRIER_IUSACEL)) && !idOperador.equals(String.valueOf(ATTConstants.CARRIER_NEXTEL)))){
				idOperador = String.valueOf(ATTConstants.VAL_CERO);
			} 
		} catch (ServiceException e) {			
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return idOperador;
	}


	public static ConfiguracionXUsuarioMovilVO parsegetConfiguracionXUsuarioMovil (String resultadoXML) throws Exception{

		ConfiguracionXUsuarioMovilVO configuracionVo = new ConfiguracionXUsuarioMovilVO();

		validaExcepcion(resultadoXML);


		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("descripcion");
			if(children != null && children.getLength() > 0)	    	
				configuracionVo.setDescripcion(children.item(0).getTextContent());
			else
				configuracionVo.setDescripcion("");


			children = doc.getElementsByTagName("dn");
			if(children != null && children.getLength() > 0)	    	
				configuracionVo.setDn(children.item(0).getTextContent());
			else
				configuracionVo.setDn("");


			children = doc.getElementsByTagName("fechaAlta");
			if(children != null && children.getLength() > 0)	    	
				configuracionVo.setFechaAlta(children.item(0).getTextContent());
			else
				configuracionVo.setFechaAlta("");


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}			


		return configuracionVo;
	}


	public static ConsultaOperadorExtendidoVO parseConsultaOperadorExtendido(String resultadoXML) throws Exception{

		ConsultaOperadorExtendidoVO consultaOperador = new ConsultaOperadorExtendidoVO();

		validaExcepcion(resultadoXML);

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("idOperador");
			if(children != null && children.getLength() > 0)	    	
				consultaOperador.setIdOperador(children.item(0).getTextContent());
			else
				consultaOperador.setIdOperador("");


			children = doc.getElementsByTagName("statusLinea");
			if(children != null && children.getLength() > 0)	    	
				consultaOperador.setStatusLinea(children.item(0).getTextContent());
			else
				consultaOperador.setStatusLinea("");	    		    		    	


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}			


		return consultaOperador;
	}


	public static Navegacion parseWalletsTotalNavegacion(String resultadoXML) throws Exception{

		Navegacion navegacion = new Navegacion();	

		validaExcepcion(resultadoXML);

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("datosExtra");
			if(children != null && children.getLength() > 0)	    	
				navegacion.setDatosExtra(children.item(0).getTextContent());
			else
				navegacion.setDatosExtra("");


			children = doc.getElementsByTagName("datosIncluidos");
			if(children != null && children.getLength() > 0)	    	
				navegacion.setDatosIncluidos(children.item(0).getTextContent());
			else
				navegacion.setDatosIncluidos("");	

			children = doc.getElementsByTagName("navegacionDeRegalo");
			if(children != null && children.getLength() > 0)	    	
				navegacion.setNavegacionDeRegalo(children.item(0).getTextContent());
			else
				navegacion.setNavegacionDeRegalo("");

			children = doc.getElementsByTagName("totalCostoDatos");
			if(children != null && children.getLength() > 0)	    	
				navegacion.setTotalCostoDatos(children.item(0).getTextContent());
			else
				navegacion.setTotalCostoDatos("");

			children = doc.getElementsByTagName("totalDatos");
			if(children != null && children.getLength() > 0)	    	
				navegacion.setTotalDatos(children.item(0).getTextContent());
			else
				navegacion.setTotalDatos("");



		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}					

		return navegacion;
	}

	public static DetalleTotalesLlamadas parsewalletsTotalLlamadas(String resultadoXML) throws Exception{

		DetalleTotalesLlamadas totalesLlamadasVo = new DetalleTotalesLlamadas();
		Llamadas llamadasVo = new Llamadas();
		MinutosComunidad minutosComunidadVo = new MinutosComunidad();
		MinutosTodoDestino minTodoDestino = new MinutosTodoDestino();				

		validaExcepcion(resultadoXML);

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);

			//++++ Llamadas
			children = doc.getElementsByTagName("llamadasIncluidas");
			if(children != null && children.getLength() > 0)	    	
				llamadasVo.setLlamadasIncluidas(children.item(0).getTextContent());
			else
				llamadasVo.setLlamadasIncluidas("");


			children = doc.getElementsByTagName("minutosComunidadConsumidos");
			if(children != null && children.getLength() > 0)	    	
				llamadasVo.setMinutosComunidadConsumidos(children.item(0).getTextContent());
			else
				llamadasVo.setMinutosComunidadConsumidos("");

			children = doc.getElementsByTagName("minutosDeRegalo");
			if(children != null && children.getLength() > 0)	    	
				llamadasVo.setMinutosDeRegalo(children.item(0).getTextContent());
			else
				llamadasVo.setMinutosDeRegalo("");	

			children = doc.getElementsByTagName("minutosExtras");
			if(children != null && children.getLength() > 0)	    	
				llamadasVo.setMinutosExtras(children.item(0).getTextContent());
			else
				llamadasVo.setMinutosExtras("");	

			children = doc.getElementsByTagName("totalCostoLlamadas");
			if(children != null && children.getLength() > 0)	    	
				llamadasVo.setTotalCostoLlamadas(children.item(0).getTextContent());
			else
				llamadasVo.setTotalCostoLlamadas("");	

			children = doc.getElementsByTagName("totalLlamadas");
			if(children != null && children.getLength() > 0)	    	
				llamadasVo.setTotalLlamadas(children.item(0).getTextContent());
			else
				llamadasVo.setTotalLlamadas("");	

			//++ Minutos Comunidad

			children = doc.getElementsByTagName("minutosComunidadConsumidos");
			if(children != null && children.getLength() > 0)	    	
				minutosComunidadVo.setMinutosComunidadConsumidos(children.item(0).getTextContent());
			else
				minutosComunidadVo.setMinutosComunidadConsumidos("");	

			children = doc.getElementsByTagName("minutosComunidadExtra");
			if(children != null && children.getLength() > 0)	    	
				minutosComunidadVo.setMinutosComunidadExtra(children.item(0).getTextContent());
			else
				minutosComunidadVo.setMinutosComunidadExtra("");	

			children = doc.getElementsByTagName("minutosComunidadIncluido");
			if(children != null && children.getLength() > 0)	    	
				minutosComunidadVo.setMinutosComunidadIncluido(children.item(0).getTextContent());
			else
				minutosComunidadVo.setMinutosComunidadIncluido("");	

			children = doc.getElementsByTagName("minutosComunidadRegalo");
			if(children != null && children.getLength() > 0)	    	
				minutosComunidadVo.setMinutosComunidadRegalo(children.item(0).getTextContent());
			else
				minutosComunidadVo.setMinutosComunidadRegalo("");	

			children = doc.getElementsByTagName("minutosTDconsumido");
			if(children != null && children.getLength() > 0)	    	
				minTodoDestino.setMinutosTDconsumido(children.item(0).getTextContent());
			else
				minTodoDestino.setMinutosTDconsumido("");	

			children = doc.getElementsByTagName("minutosTDextra");
			if(children != null && children.getLength() > 0)	    	
				minTodoDestino.setMinutosTDextra(children.item(0).getTextContent());
			else
				minTodoDestino.setMinutosTDextra("");	

			children = doc.getElementsByTagName("minutosTDincluido");
			if(children != null && children.getLength() > 0)	    	
				minTodoDestino.setMinutosTDincluido(children.item(0).getTextContent());
			else
				minTodoDestino.setMinutosTDincluido("");	

			children = doc.getElementsByTagName("minutosTDregalo");
			if(children != null && children.getLength() > 0)	    	
				minTodoDestino.setMinutosTDregalo(children.item(0).getTextContent());
			else
				minTodoDestino.setMinutosTDregalo("");		    		    

			totalesLlamadasVo.setLlamadas(llamadasVo);
			totalesLlamadasVo.setMinutosComunidad(minutosComunidadVo);
			totalesLlamadasVo.setMinutosTodoDestino(minTodoDestino);


			children = doc.getElementsByTagName("tiempoAireAbonado");
			if(children != null && children.getLength() > 0)	    	
				totalesLlamadasVo.setTiempoAireAbonado(children.item(0).getTextContent());
			else
				totalesLlamadasVo.setTiempoAireAbonado("");	

			children = doc.getElementsByTagName("tiempoAireDeRegalo");
			if(children != null && children.getLength() > 0)	    	
				totalesLlamadasVo.setTiempoAireDeRegalo(children.item(0).getTextContent());
			else
				totalesLlamadasVo.setTiempoAireDeRegalo("");	

			children = doc.getElementsByTagName("tiempoAireTotal");
			if(children != null && children.getLength() > 0)	    	
				totalesLlamadasVo.setTiempoAireTotal(children.item(0).getTextContent());
			else
				totalesLlamadasVo.setTiempoAireTotal("");	

		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}																	

		return totalesLlamadasVo;

	}

	public static Mensajes parsewalletsTotalMensajes(String resultadoXML) throws Exception{

		Mensajes mensajesVo = new Mensajes();

		validaExcepcion(resultadoXML);

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("mensajesDeTextoDeRegalo");
			if(children != null && children.getLength() > 0)	    	
				mensajesVo.setMensajesDeTextoDeRegalo(children.item(0).getTextContent());
			else
				mensajesVo.setMensajesDeTextoDeRegalo("");


			children = doc.getElementsByTagName("mensajesExtras");
			if(children != null && children.getLength() > 0)	    	
				mensajesVo.setMensajesExtras(children.item(0).getTextContent());
			else
				mensajesVo.setMensajesExtras("");	  

			children = doc.getElementsByTagName("mensajesIncluidos");
			if(children != null && children.getLength() > 0)	    	
				mensajesVo.setMensajesIncluidos(children.item(0).getTextContent());
			else
				mensajesVo.setMensajesIncluidos("");

			children = doc.getElementsByTagName("totalCostoMensajes");
			if(children != null && children.getLength() > 0)	    	
				mensajesVo.setTotalCostoMensajes(children.item(0).getTextContent());
			else
				mensajesVo.setTotalCostoMensajes("");

			children = doc.getElementsByTagName("totalMensajes");
			if(children != null && children.getLength() > 0)	    	
				mensajesVo.setTotalMensajes(children.item(0).getTextContent());
			else
				mensajesVo.setTotalMensajes("");	


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}						

		return mensajesVo;
	}

	public static String actualizaFotografiaXUsu (String resultadoXML) throws Exception{
		String respuesta="";				

		validaExcepcion(resultadoXML);

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns1:out");
			if(children != null && children.getLength() > 0)	    	
				respuesta = children.item(0).getTextContent();	
			else
				respuesta = "";


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}							

		return respuesta;
	}

	public static String parseLogin(String resultadoXML) throws Exception{
		String sResponse= "";				

		validaExcepcion(resultadoXML);

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns1:out");
			if(children != null && children.getLength() > 0)	    	
				sResponse = children.item(0).getTextContent();	
			else
				sResponse = "";


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}							

		return sResponse;
	}


	public static DatosFocalizacionUsuario parseFocalizacion(String resultadoXML) throws Exception{

		DatosFocalizacionUsuario  datosFocalizacionVo = new DatosFocalizacionUsuario();
		DatosFocalizacion datosFocalizacion = new DatosFocalizacion();
		DatosFocalizacionFocaVO datosFocalizacionUsuario = new DatosFocalizacionFocaVO();
		ObtenerDescripcionPlanesVO1 datosPlan = new ObtenerDescripcionPlanesVO1();
		DatosLogin datosUsuario = new DatosLogin();						

		validaExcepcion(resultadoXML);

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("compania");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionVo.setCompania(children.item(0).getTextContent());	
			else
				datosFocalizacionVo.setCompania("");

			children = doc.getElementsByTagName("fechaCorte");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacion.setFechaCorte(children.item(0).getTextContent());	
			else
				datosFocalizacion.setFechaCorte("");

			children = doc.getElementsByTagName("idOperador");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacion.setIdOperador(children.item(0).getTextContent());	
			else
				datosFocalizacion.setIdOperador("");

			children = doc.getElementsByTagName("idPrepago");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacion.setIdPrepago(children.item(0).getTextContent());	
			else
				datosFocalizacion.setIdPrepago("");

			children = doc.getElementsByTagName("isPostpagoOrHibrido");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacion.setIsPostpagoOrHibrido(children.item(0).getTextContent());	
			else
				datosFocalizacion.setIsPostpagoOrHibrido("");

			children = doc.getElementsByTagName("servicio");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacion.setServicio(children.item(0).getTextContent());	
			else
				datosFocalizacion.setServicio("");

			children = doc.getElementsByTagName("subservicio");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacion.setSubservicio(children.item(0).getTextContent());	
			else
				datosFocalizacion.setSubservicio("");

			children = doc.getElementsByTagName("tecnologia");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacion.setTecnologia(children.item(0).getTextContent());	
			else
				datosFocalizacion.setTecnologia("");

			children = doc.getElementsByTagName("apMATERNOFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setApMATERNOFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setApMATERNOFoca("");

			children = doc.getElementsByTagName("apPATERNOFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setApPATERNOFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setApPATERNOFoca("");

			children = doc.getElementsByTagName("coidFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setCoidFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setCoidFoca("");

			children = doc.getElementsByTagName("correoFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setCorreoFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setCorreoFoca("");

			children = doc.getElementsByTagName("cuentaFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setCuentaFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setCuentaFoca("");

			children = doc.getElementsByTagName("descripcionPlanFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setDescripcionPlanFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setDescripcionPlanFoca("");

			children = doc.getElementsByTagName("fechaNacimientoFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setFechaNacimientoFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setFechaNacimientoFoca("");

			children = doc.getElementsByTagName("idOperadorFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setIdOperadorFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setIdOperadorFoca("");

			children = doc.getElementsByTagName("isPostpagoOrHibridoFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setIsPostpagoOrHibridoFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setIsPostpagoOrHibridoFoca("");

			children = doc.getElementsByTagName("nombreFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setNombreFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setNombreFoca("");

			children = doc.getElementsByTagName("tmcodeFoca");
			if(children != null && children.getLength() > 0)	    	
				datosFocalizacionUsuario.setTmcodeFoca(children.item(0).getTextContent());	
			else
				datosFocalizacionUsuario.setTmcodeFoca("");

			//***Datos Plan

			children = doc.getElementsByTagName("idPlan");
			if(children != null && children.getLength() > 0)	    	
				datosPlan.setIdPlan(children.item(0).getTextContent());	
			else
				datosPlan.setIdPlan("");

			children = doc.getElementsByTagName("megaadc");
			if(children != null && children.getLength() > 0)	    	
				datosPlan.setMegaadc(children.item(0).getTextContent());	
			else
				datosPlan.setMegaadc("");

			children = doc.getElementsByTagName("megas");
			if(children != null && children.getLength() > 0)	    	
				datosPlan.setMegas(children.item(0).getTextContent());	
			else
				datosPlan.setMegas("");

			children = doc.getElementsByTagName("mensajeadc");
			if(children != null && children.getLength() > 0)	    	
				datosPlan.setMensajeadc(children.item(0).getTextContent());	
			else
				datosPlan.setMensajeadc("");

			children = doc.getElementsByTagName("mensajes");
			if(children != null && children.getLength() > 0)	    	
				datosPlan.setMensajes(children.item(0).getTextContent());	
			else
				datosPlan.setMensajes("");

			children = doc.getElementsByTagName("minutoadc");
			if(children != null && children.getLength() > 0)	    	
				datosPlan.setMinutoadc(children.item(0).getTextContent());	
			else
				datosPlan.setMinutoadc("");

			children = doc.getElementsByTagName("minutos");
			if(children != null && children.getLength() > 0)	    	
				datosPlan.setMinutos(children.item(0).getTextContent());	
			else
				datosPlan.setMinutos("");

			children = doc.getElementsByTagName("minutoscomunidad");
			if(children != null && children.getLength() > 0)	    	
				datosPlan.setMinutoscomunidad(children.item(0).getTextContent());	
			else
				datosPlan.setMinutoscomunidad("");

			children = doc.getElementsByTagName("nombreCortoPlan");
			if(children != null && children.getLength() > 0)	    	
				datosPlan.setNombreCortoPlan(children.item(0).getTextContent());	
			else
				datosPlan.setNombreCortoPlan("");

			children = doc.getElementsByTagName("tiempoAire");
			if(children != null && children.getLength() > 0)	    	
				datosPlan.setTiempoAire(children.item(0).getTextContent());	
			else
				datosPlan.setTiempoAire("");

			//datosUsuario

			children = doc.getElementsByTagName("apMaterno");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setApMaterno(children.item(0).getTextContent());	
			else
				datosUsuario.setApMaterno("");

			children = doc.getElementsByTagName("apPaterno");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setApPaterno(children.item(0).getTextContent());	
			else
				datosUsuario.setApPaterno("");

			children = doc.getElementsByTagName("correo");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setCorreo(children.item(0).getTextContent());	
			else
				datosUsuario.setCorreo("");

			children = doc.getElementsByTagName("edad");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setEdad(children.item(0).getTextContent());	
			else
				datosUsuario.setEdad("");

			children = doc.getElementsByTagName("fechaNacimiento");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setFechaNacimiento(children.item(0).getTextContent());	
			else
				datosUsuario.setFechaNacimiento("");

			children = doc.getElementsByTagName("foto");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setFoto(children.item(0).getTextContent());	
			else
				datosUsuario.setFoto("");

			children = doc.getElementsByTagName("nombre");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setNombre(children.item(0).getTextContent());	
			else
				datosUsuario.setNombre("");

			children = doc.getElementsByTagName("preguntaSecretea");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setPreguntaSecretea(children.item(0).getTextContent());	
			else
				datosUsuario.setPreguntaSecretea("");

			children = doc.getElementsByTagName("respPreguntaSecreta");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setRespPreguntaSecreta(children.item(0).getTextContent());	
			else
				datosUsuario.setRespPreguntaSecreta("");

			children = doc.getElementsByTagName("sexo");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setSexo(children.item(0).getTextContent());	
			else
				datosUsuario.setSexo("");

			children = doc.getElementsByTagName("tipoClienteId");
			if(children != null && children.getLength() > 0)	    	
				datosUsuario.setTipoClienteId(children.item(0).getTextContent());	
			else
				datosUsuario.setTipoClienteId("");


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}				


		datosFocalizacionVo.setDatosFocalizacion(datosFocalizacion);
		datosFocalizacionVo.setDatosFocalizacionUsuario(datosFocalizacionUsuario);
		datosFocalizacionVo.setDatosPlan(datosPlan);
		datosFocalizacionVo.setDatosUsuario(datosUsuario);

		return datosFocalizacionVo;
	}

	
	public static List<PermisosClienteVO> parsegetPermisosXcliente (String resultadoXML) throws Exception{
		List<PermisosClienteVO> listPermisosCliente = new ArrayList<PermisosClienteVO>();
		PermisosClienteVO  permisoCliente = new PermisosClienteVO();

		validaExcepcion(resultadoXML);		
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;
		NodeList child;		
		
		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			
			children = doc.getElementsByTagName("ns2:PermisosClienteVO");
			if(children != null && children.getLength() > 0)
			{
				for(int cont = 0; cont < children.getLength(); cont ++)
				{
					permisoCliente = new PermisosClienteVO();	 
					child = children.item(cont).getChildNodes();				
					permisoCliente.setServicioID(child.item(0).getTextContent());	  					
					permisoCliente.setValor(child.item(1).getTextContent());							
					listPermisosCliente.add(permisoCliente);
				}				
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return listPermisosCliente;
	}
	
	public static DatosFacturasVO parsegetFacturas(String resultadoXML) throws Exception{
		DatosFacturasVO datosFacturaVo = new DatosFacturasVO();
		DatosUltimasFacturasVO facturas = new DatosUltimasFacturasVO();
		List<DatosUltimasFacturasVO> listFacturas = new ArrayList<DatosUltimasFacturasVO>();		

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;
		NodeList child;		
		
		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("saldoPendienteDePago");
			if(children != null && children.getLength() > 0)			
				datosFacturaVo.setSaldoPendienteDePago(children.item(0).getTextContent());				
			else
				datosFacturaVo.setSaldoPendienteDePago("");
			
			children = doc.getElementsByTagName("DatosUltimasFacturasVO");
			if(children != null && children.getLength() > 0)
			{
				for(int cont = 0; cont < children.getLength(); cont ++)
				{
					facturas = new DatosUltimasFacturasVO();
					child = children.item(cont).getChildNodes();				
					facturas.setFechaCorte(child.item(0).getTextContent());	  					
					facturas.setFechaVencimiento(child.item(1).getTextContent());
					facturas.setLink(child.item(2).getTextContent());
					facturas.setSaldoVencido(child.item(3).getTextContent());
					facturas.setTotalPagar(child.item(4).getTextContent());						
					listFacturas.add(facturas);
				}
				if(listFacturas.size()>0)
					datosFacturaVo.setFacturas(listFacturas);
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return datosFacturaVo;
	}


	public static String generaPIN(String resultadoXML) throws Exception{
		String respuesta="";

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList childrens;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			childrens = doc.getElementsByTagName("ns1:out");
			if(childrens != null && childrens.getLength() > 0)
			{
				respuesta = childrens.item(0).getTextContent();
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return respuesta;
	}

	public static void validaExcepcionPlus(String resultadoXML) throws ServiceException{

		Pattern pattern =null;
		Matcher matcher =null;

		pattern = Pattern.compile("<faultstring>(.+?)</faultstring>");
		matcher = pattern.matcher(resultadoXML);	


		if(matcher.find()){
			throw new ServiceException(matcher.group(1));
		}

	} 


	public static void validaExcepcion(String resultadoXML) throws ServiceException{

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			Document doc=builder.parse(is);
			NodeList links=doc.getElementsByTagName("faultstring");
			String resultado = "";
			if (links.getLength()>0){

				resultado = links.item(0).getTextContent();
				if (!resultado.isEmpty()) {
					throw new ServiceException(resultado);
				}
			}else resultado ="";
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}



	} 



	public static String registroClienteBit(String resultadoXML) throws Exception{
		String sRespuesta="";

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList childrens;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			childrens = doc.getElementsByTagName("ns1:out");
			if(childrens != null && childrens.getLength() > 0)
			{
				sRespuesta = childrens.item(0).getTextContent();
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return sRespuesta;
	}


	public static List<CatalogoAbonos> parsegetCatalogoAbono (String resultadoXML) throws Exception{
		List<CatalogoAbonos> listCatalogo = new ArrayList<CatalogoAbonos>();
		CatalogoAbonos  catalogoAbonos = null;

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;
		NodeList child;		
		
		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);			
			children = doc.getElementsByTagName("ns2:CatalogoAbonos");
			if(children != null && children.getLength() > 0)
			{
				for(int cont = 0; cont < children.getLength(); cont ++)
				{
					catalogoAbonos = new CatalogoAbonos();
					child = children.item(cont).getChildNodes();				
					catalogoAbonos.setCantidad(child.item(0).getTextContent());	  					
					catalogoAbonos.setDescripcion(child.item(1).getTextContent());								
					listCatalogo.add(catalogoAbonos);
				}				
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return listCatalogo;
	}

	public static List<ServiciosAdicionalesVO> parsegetServiciosAdicionalesPorDn (String resultadoXML) throws Exception{
		List<ServiciosAdicionalesVO> listResponse = new ArrayList<ServiciosAdicionalesVO>();
		ServiciosAdicionalesVO  response = null;

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;
		NodeList child;		
		
		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);			
			children = doc.getElementsByTagName("ns2:ServiciosAdicionalesVO");
			if(children != null && children.getLength() > 0)
			{
				for(int cont = 0; cont < children.getLength(); cont ++)
				{
					int i =0;
					response = new ServiciosAdicionalesVO();
					child = children.item(cont).getChildNodes();				
					response.setCosto(child.item(i++).getTextContent());	  					
					response.setDescripcion(child.item(i++).getTextContent());
					response.setIdServicio(child.item(i++).getTextContent());	
					response.setImagenB64(child.item(i++).getTextContent());	
					response.setMensajeServicios(child.item(i++).getTextContent());	
					response.setServicio(child.item(i++).getTextContent());					
					int status = 0;
					try{status = Integer.parseInt(child.item(i++).getTextContent());}
					catch(NumberFormatException e){}
					response.setStatus(status);	
					response.setVersion(child.item(i++).getTextContent());
					listResponse.add(response);
				}				
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return listResponse;
	}

	public static MensajeMailVO parseEnviaCorreoSMS(String resultadoXML) throws Exception{
		MensajeMailVO datosMailVO = new MensajeMailVO();

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;		
		
		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);			
			children = doc.getElementsByTagName("mailError");
			if(children != null && children.getLength() > 0)
				datosMailVO.setMailError(children.item(0).getTextContent());
			else
				datosMailVO.setMailError("");
			
			children = doc.getElementsByTagName("mailSended");
			if(children != null && children.getLength() > 0)
				datosMailVO.setMailSended(children.item(0).getTextContent());
			else
				datosMailVO.setMailSended("");
			
			children = doc.getElementsByTagName("messageErrors");
			if(children != null && children.getLength() > 0)
				datosMailVO.setMessageErrors(children.item(0).getTextContent());
			else
				datosMailVO.setMessageErrors("");
			
			children = doc.getElementsByTagName("smsError");
			if(children != null && children.getLength() > 0)
				datosMailVO.setSmsError(children.item(0).getTextContent());
			else
				datosMailVO.setSmsError("");
			
			children = doc.getElementsByTagName("smsSended");
			if(children != null && children.getLength() > 0)
				datosMailVO.setSmsSended(children.item(0).getTextContent());
			else
				datosMailVO.setSmsSended("");
									
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return datosMailVO;
	}

	public static DetalleSaldoVO parseDetalleSaldo(String resultadoXML) throws Exception{
		DetalleSaldoVO detalleFactura= new DetalleSaldoVO();
		
		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;		
		
		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);			
			children = doc.getElementsByTagName("o1saldoAnterior");
			if(children != null && children.getLength() > 0)
				detalleFactura.setO1saldoAnterior(children.item(0).getTextContent());
			else
				detalleFactura.setO1saldoAnterior("");		
			
			children = doc.getElementsByTagName("o2suPagoGracias");
			if(children != null && children.getLength() > 0)
				detalleFactura.setO2suPagoGracias(children.item(0).getTextContent());
			else
				detalleFactura.setO2suPagoGracias("");
			
			children = doc.getElementsByTagName("o3ajustesCuenta");
			if(children != null && children.getLength() > 0)
				detalleFactura.setO3ajustesCuenta(children.item(0).getTextContent());
			else
				detalleFactura.setO3ajustesCuenta("");
			
			children = doc.getElementsByTagName("o4totalFacturaActual");
			if(children != null && children.getLength() > 0)
				detalleFactura.setO4totalFacturaActual(children.item(0).getTextContent());
			else
				detalleFactura.setO4totalFacturaActual("");
			
			children = doc.getElementsByTagName("o5ajusteRedondeo");
			if(children != null && children.getLength() > 0)
				detalleFactura.setO5ajusteRedondeo(children.item(0).getTextContent());
			else
				detalleFactura.setO5ajusteRedondeo("");
			
			children = doc.getElementsByTagName("o6totalPagar");
			if(children != null && children.getLength() > 0)
				detalleFactura.setO6totalPagar(children.item(0).getTextContent());
			else
				detalleFactura.setO6totalPagar("");
			
			children = doc.getElementsByTagName("o7pagadoSupuesto");
			if(children != null && children.getLength() > 0)
				detalleFactura.setO7pagadoSupuesto(children.item(0).getTextContent());
			else
				detalleFactura.setO7pagadoSupuesto("");
			
			children = doc.getElementsByTagName("o8pendientePago");
			if(children != null && children.getLength() > 0)
				detalleFactura.setO8pendientePago(children.item(0).getTextContent());
			else
				detalleFactura.setO8pendientePago("");
									
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}		

		return detalleFactura;	
	}

	public static MensajeMailVO enviarCorreoFacturaDetalle(String responseXML) throws ServiceException
	{
		MensajeMailVO vo = new MensajeMailVO();

		validaExcepcion(responseXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(responseXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("mailError");
			if(children != null && children.getLength() > 0)								
				vo.setMailError(children.item(0).getTextContent());
			else
				vo.setMailError("");
			
			children = doc.getElementsByTagName("mailSended");
			if(children != null && children.getLength() > 0)								
				vo.setMailSended(children.item(0).getTextContent());
			else
				vo.setMailSended("");
			
			children = doc.getElementsByTagName("messageErrors");
			if(children != null && children.getLength() > 0)								
				vo.setMessageErrors(children.item(0).getTextContent());
			else
				vo.setMessageErrors("");
			
			children = doc.getElementsByTagName("smsError");
			if(children != null && children.getLength() > 0)								
				vo.setSmsError(children.item(0).getTextContent());
			else
				vo.setSmsError("");
			
			children = doc.getElementsByTagName("smsSended");
			if(children != null && children.getLength() > 0)								
				vo.setSmsSended(children.item(0).getTextContent());
			else
				vo.setSmsSended("");					
					
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return vo;
	}

	public static DetalleFacturaVO parseDetalleFactura(String resultadoXML) throws Exception{
		DetalleFacturaVO detalleFactura= new DetalleFacturaVO();
		
		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ajuste");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setAjuste(children.item(0).getTextContent());
			else
				detalleFactura.setAjuste("");
			
			children = doc.getElementsByTagName("consumosPeriodo");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setConsumosPeriodo(children.item(0).getTextContent());
			else
				detalleFactura.setConsumosPeriodo("");
			
			children = doc.getElementsByTagName("cuenta");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setCuenta(children.item(0).getTextContent());
			else
				detalleFactura.setCuenta("");
			
			children = doc.getElementsByTagName("factura");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setFactura(children.item(0).getTextContent());
			else
				detalleFactura.setFactura("");
			
			children = doc.getElementsByTagName("fechaLimite");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setFechaLimite(children.item(0).getTextContent());
			else
				detalleFactura.setFechaLimite("");
			
			children = doc.getElementsByTagName("iva");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setIva(children.item(0).getTextContent());
			else
				detalleFactura.setIva("");
			
			children = doc.getElementsByTagName("otrosCargos");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setOtrosCargos(children.item(0).getTextContent());
			else
				detalleFactura.setOtrosCargos("");
			
			children = doc.getElementsByTagName("periodo");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setPeriodo(children.item(0).getTextContent());
			else
				detalleFactura.setPeriodo("");
			
			children = doc.getElementsByTagName("porcentajeIVA");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setPorcentajeIVA(children.item(0).getTextContent());
			else
				detalleFactura.setPorcentajeIVA("");
			
			children = doc.getElementsByTagName("rentas");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setRentas(children.item(0).getTextContent());
			else
				detalleFactura.setRentas("");
			
			children = doc.getElementsByTagName("serviciosAdicionales");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setServiciosAdicionales(children.item(0).getTextContent());
			else
				detalleFactura.setServiciosAdicionales("");
			
			children = doc.getElementsByTagName("subtotal");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setSubtotal(children.item(0).getTextContent());
			else
				detalleFactura.setSubtotal("");
			
			children = doc.getElementsByTagName("total");
			if(children != null && children.getLength() > 0)								
				detalleFactura.setTotal(children.item(0).getTextContent());
			else
				detalleFactura.setTotal("");
									
					
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}		

		return detalleFactura;	
	}

	public static String editarCuentaParse(String resultadoXML) throws Exception{

		String sRespuesta="";

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns1:out");
			if(children != null && children.getLength() > 0)			
			{			
				sRespuesta =children.item(0).getTextContent();
			}			


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return sRespuesta;

	}

	public static String editarPerfilParse(String resultadoXML) throws Exception{

		String sRespuesta="";

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns1:out");
			if(children != null && children.getLength() > 0)			
			{			
				sRespuesta =children.item(0).getTextContent();
			}			


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return sRespuesta;

	}

	public static String parseRegistroTarjetas(String resultadoXML) throws Exception{

		String sRespuesta="";

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("return");
			if(children != null && children.getLength() > 0)			
			{			
				sRespuesta =children.item(0).getTextContent();
			}			


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return sRespuesta;

	}

	public static WalletsDetalleVO parseWalletsDetalle(String resultadoXML) throws Exception{

		WalletsDetalleVO detalleWallets = new WalletsDetalleVO();	
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		Element element;
		NodeList children;
		NodeList childrenDetalle;
		NodeList childrenFecha;
		NodeList child;	
		NodeList childDetalle;

		validaExcepcion(resultadoXML);	
		
		List<ConsumoFechaTablaVO> detalleConsumo = new ArrayList<ConsumoFechaTablaVO>();		
		ConsumoFechaTablaVO detalleCons = null;		
		List<ConsumoDetalleTablaVO> detalleTabla = null;
		ConsumoDetalleTablaVO detalle = null;			
		
		try{
			
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("isPostPagoHibrido");
			if(children != null && children.getLength() > 0)							
				detalleWallets.setIsPostPagoHibrido(children.item(0).getTextContent());
			else
				detalleWallets.setIsPostPagoHibrido("");
			
			
			NodeList nodeList = doc.getElementsByTagName("detalleConsumo").item(0).getChildNodes();
		     for (int i = 0; i < nodeList.getLength(); i++){
		    	 detalleCons = new ConsumoFechaTablaVO();
		    	 switch (nodeList.item(i).getNodeType()) {
		    	     case Node.ELEMENT_NODE:

		    	       detalleTabla = new ArrayList<ConsumoDetalleTablaVO>();	 
				       element = (Element) nodeList.item(i);
                       child = element.getChildNodes();
                       childrenFecha = child.item(1).getChildNodes();				
                       System.out.println(childrenFecha.item(0).getTextContent());
                       detalleCons.setFecha(childrenFecha.item(0).getTextContent());
                       childrenDetalle = child.item(0).getChildNodes();	
                       if(childrenDetalle != null && childrenDetalle.getLength() > 0)
               		    {
               			   for(int cont = 0; cont < childrenDetalle.getLength(); cont ++)
               			   {
               				  int j = 0;
               				  childDetalle = childrenDetalle.item(cont).getChildNodes();	
               				  
               				  detalle = new ConsumoDetalleTablaVO();
          				  detalle.setCompania(childDetalle.item(j++).getTextContent());
          				  detalle.setCosto(childDetalle.item(j++).getTextContent());
                                          detalle.setDestino(childDetalle.item(j++).getTextContent());
                                          detalle.setFecha(childDetalle.item(j++).getTextContent());
                                          detalle.setHora(childDetalle.item(j++).getTextContent());
                                          detalle.setIdColumna(Integer.parseInt(childDetalle.item(j++).getTextContent()));
                                          detalle.setMbConsumidos(childDetalle.item(j++).getTextContent());
                                          detalle.setNumero(childDetalle.item(j++).getTextContent());
                                          detalle.setTiempo(childDetalle.item(j++).getTextContent());
                                          detalleTabla.add(detalle);
               			   }
               		    }
                       detalleCons.setDetalle(detalleTabla);
                        
                       break;
   
		       }
		      detalleConsumo.add(detalleCons);
		     }
			
		     detalleWallets.setDetalleConsumo(detalleConsumo);
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return detalleWallets;
	}

	public static String parseReservaPIN(String resultadoXML) throws Exception{

		String sRespuesta="";

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns1:out");
			if(children != null && children.getLength() > 0)			
			{			
				sRespuesta =children.item(0).getTextContent();
			}			


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return sRespuesta;

	}

	public static boolean parseValidaPIN(String responseXML) throws ServiceException
	{
		boolean vo = false;

		validaExcepcion(responseXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(responseXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns1:out");
			if(children != null && children.getLength() > 0)			
			{			
				vo = Boolean.valueOf(children.item(0).getTextContent());
			}			


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return vo;
	}

	public static boolean parseActualiza(String responseXML) throws ServiceException
	{
		boolean vo = false;

		validaExcepcion(responseXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(responseXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns1:out");
			if(children != null && children.getLength() > 0)			
			{			
				vo = Boolean.valueOf(children.item(0).getTextContent());
			}			


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return vo;
	}

	public static AbonoTiempoAireVO parseAbonoTiempoAire(String resultadoXML) throws Exception{

		AbonoTiempoAireVO tiempoAireVO = new AbonoTiempoAireVO();

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("codigoRespuestaAbonoTA");
			if(children != null && children.getLength() > 0)							
				tiempoAireVO.setCodigoRespuestaAbonoTA(children.item(0).getTextContent());
			else
				tiempoAireVO.setCodigoRespuestaAbonoTA("");
			
			children = doc.getElementsByTagName("idRegistroCaja");
			if(children != null && children.getLength() > 0)							
				tiempoAireVO.setIdRegistroCaja(children.item(0).getTextContent());
			else
				tiempoAireVO.setIdRegistroCaja("");
			
			children = doc.getElementsByTagName("numTransaccionCaja");
			if(children != null && children.getLength() > 0)							
				tiempoAireVO.setNumTransaccionCaja(children.item(0).getTextContent());
			else
				tiempoAireVO.setNumTransaccionCaja("");
			
			children = doc.getElementsByTagName("numeroAutorizacionAbonoTA");
			if(children != null && children.getLength() > 0)							
				tiempoAireVO.setNumeroAutorizacionAbonoTA(children.item(0).getTextContent());
			else
				tiempoAireVO.setNumeroAutorizacionAbonoTA("");
			
			children = doc.getElementsByTagName("numeroAutorizacionCaja");
			if(children != null && children.getLength() > 0)							
				tiempoAireVO.setNumeroAutorizacionCaja(children.item(0).getTextContent());
			else
				tiempoAireVO.setNumeroAutorizacionCaja("");						
			
					
			
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return tiempoAireVO;

	}

	public static int bajaNumeroFrencuente(String responseXML) throws ServiceException
	{
		int vo = -1;

		validaExcepcion(responseXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(responseXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns1:out");
			if(children != null && children.getLength() > 0)			
				{
				try{
					vo = Integer.parseInt(children.item(0).getTextContent());
				}catch(NumberFormatException e){}
				}			
					
			
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return vo;
	}

	public static ContratarServiciosVO bajaServiciosPass(String responseXML) throws ServiceException
	{
		ContratarServiciosVO vo = new ContratarServiciosVO();

		validaExcepcion(responseXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(responseXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("messageCode");
			if(children != null && children.getLength() > 0)			
				vo.setMessageCode(children.item(0).getTextContent());
			else 
				vo.setMessageCode("");	
			
			children = doc.getElementsByTagName("operationCode");
			if(children != null && children.getLength() > 0)			
				vo.setOperationCode(children.item(0).getTextContent());
			else 
				vo.setOperationCode("");	
			
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return vo;
	}

	public static String parseBajaTarjeta(String resultadoXML) throws ServiceException
	{
		String sRespuesta="";

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns1:out");
			if(children != null && children.getLength() > 0)			
				sRespuesta = children.item(0).getTextContent();
			else 
				sRespuesta = "";						
			
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return sRespuesta;
	}

	public static ContratarServiciosVO parseContratarServicios(String resultadoXML) throws ServiceException
	{
		ContratarServiciosVO sRespuesta= new ContratarServiciosVO();

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("messageCode");
			if(children != null && children.getLength() > 0)			
				sRespuesta.setMessageCode(children.item(0).getTextContent());
			else 
				sRespuesta.setMessageCode("");
			
			children = doc.getElementsByTagName("operationCode");
			if(children != null && children.getLength() > 0)			
				sRespuesta.setOperationCode(children.item(0).getTextContent());
			else
				sRespuesta.setOperationCode("");
			
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return sRespuesta;
	}

	public static List<NumerosFrecuentesVO> parseObtieneNumeros(String resultadoXML) throws Exception{				

		validaExcepcion(resultadoXML);

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;
		NodeList child;
		Node element;

		List<NumerosFrecuentesVO> response = new ArrayList<NumerosFrecuentesVO>();
		NumerosFrecuentesVO numeroFrec;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns2:NumerosFrecuentesVO");
			if(children != null && children.getLength() > 0)
			{
				for(int cont = 0; cont < children.getLength(); cont ++)
				{
					numeroFrec = new NumerosFrecuentesVO();	 
					child = children.item(cont).getChildNodes();
					element = child.item(0);//Nombre
					numeroFrec.setNombre(element.getTextContent());	  
					element = child.item(1);//Telefono
					numeroFrec.setTelefono(element.getTextContent());
					response.add(numeroFrec);
				}
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return response;
	}

	public static String parseRegistroNumFrecuentes(String resultadoXML) throws Exception{

		String response = "";

		validaExcepcion(resultadoXML);

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList childrens;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			childrens = doc.getElementsByTagName("ns1:out");
			if(childrens != null && childrens.getLength() > 0)
			{
				response = childrens.item(0).getTextContent();
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return response;
	}

	public static List<TarjetasFrecuentesVO> obtieneTarjeta(String resultadoXML) throws ServiceException
	{

		validaExcepcion(resultadoXML);
		List<TarjetasFrecuentesVO> response = new ArrayList<TarjetasFrecuentesVO>();
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;
		NodeList child;
		Node element;
		TarjetasFrecuentesVO tarjetasFrec;
		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("ns2:TarjetasFrecuentesVO");
			if(children != null && children.getLength() > 0)
			{
				for(int cont = 0; cont < children.getLength(); cont ++)
				{
					tarjetasFrec = new TarjetasFrecuentesVO();  
					child = children.item(cont).getChildNodes();
					element = child.item(0);
					tarjetasFrec.setAnioVencimiento(element.getTextContent()); 
					element = child.item(1);
					tarjetasFrec.setApMaterno(element.getTextContent());
					element = child.item(2);
					tarjetasFrec.setApPaterno(element.getTextContent());
					element = child.item(3);
					tarjetasFrec.setCp(element.getTextContent());
					element = child.item(4);
					tarjetasFrec.setMarcaTarjetaId(Integer.parseInt(element.getTextContent().toString()));
					element = child.item(5);
					tarjetasFrec.setMesVencimiento(element.getTextContent());
					element = child.item(6);
					tarjetasFrec.setNombre(element.getTextContent());
					element = child.item(7);
					tarjetasFrec.setNumeroTarjeta(element.getTextContent());
					element = child.item(8);
					tarjetasFrec.setUltimosDigitos(element.getTextContent());
					response.add(tarjetasFrec);

				}

			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return response;
	}

	public static PagoFacturaResponseVO parsePagoFactura(String resultadoXML) throws Exception{

		PagoFacturaResponseVO response = new PagoFacturaResponseVO();

		validaExcepcion(resultadoXML);

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("folioPago");
			if(children != null && children.getLength() > 0)
			{
				response.setFolioPago(children.item(0).getTextContent());
			}
			children = doc.getElementsByTagName("numAutBmx");
			if(children != null && children.getLength() > 0)
			{
				response.setNumAutBmx(children.item(0).getTextContent());
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return response;
	}
	
	public static CatalogoMovilCaeVO parseObtieneListaVersionCaes(String resultadoXML) throws Exception{
		CatalogoMovilCaeVO respuesta = new CatalogoMovilCaeVO();

		validaExcepcion(resultadoXML);
		
		List<CatalogoCaeGeneralVO> response = new ArrayList<CatalogoCaeGeneralVO>();
		CatalogoCaeGeneralVO registro;
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;
		NodeList child;		
		
		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("version");
			if(children != null && children.getLength() > 0)
			{
				int version = 0;
				try{
					version = Integer.parseInt(children.item(0).getTextContent());
				}catch(NumberFormatException e){}
				respuesta.setVersion(version);
			}
			children = doc.getElementsByTagName("CatalogoCaeGeneralVO");
			if(children != null && children.getLength() > 0)
			{
				for(int cont = 0; cont < children.getLength(); cont ++)
				{
					registro = new CatalogoCaeGeneralVO();	 
					child = children.item(cont).getChildNodes();				
					registro.setClave(child.item(0).getTextContent());	  					
					registro.setCodigoPostal(child.item(1).getTextContent());
					registro.setDescripcion(child.item(2).getTextContent());
					registro.setDireccion(child.item(3).getTextContent());
					registro.setHorario(child.item(4).getTextContent());
					registro.setIdCae(Integer.parseInt(child.item(5).getTextContent()));
					registro.setLatitud(Double.parseDouble(child.item(6).getTextContent()));
					registro.setLongitud(Double.parseDouble(child.item(7).getTextContent()));
					registro.setPovHeading(Double.parseDouble(child.item(8).getTextContent()));
					registro.setPovLatitud(Double.parseDouble(child.item(9).getTextContent()));
					registro.setPovLongitud(Double.parseDouble(child.item(10).getTextContent()));
					registro.setPovPitch(Double.parseDouble(child.item(11).getTextContent()));
					registro.setPovZoom(Double.parseDouble(child.item(12).getTextContent()));
					registro.setTelefono(child.item(13).getTextContent());					
					response.add(registro);
				}
				respuesta.setDetalleCatalogoCaeGeneral(response);
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return respuesta;
	}	
	
	public static List<ServiciosBundlesAdicionales> parseObtenerServiciosBundles (String resultadoXML) throws Exception{
		List<ServiciosBundlesAdicionales> listServicios = new ArrayList<ServiciosBundlesAdicionales>();
		ServiciosBundlesAdicionales  servicio;;

		validaExcepcion(resultadoXML);		
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;
		NodeList child;		
		
		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			
			children = doc.getElementsByTagName("ns2:ServiciosBundlesAdicionales");
			if(children != null && children.getLength() > 0)
			{
				for(int cont = 0; cont < children.getLength(); cont ++)
				{
					servicio = new ServiciosBundlesAdicionales();
					int i = 0;
					child = children.item(cont).getChildNodes();				
					servicio.setCosto(child.item(i++).getTextContent());	  					
					servicio.setCostoBundle(Integer.parseInt(child.item(i++).getTextContent()));	
					servicio.setDescripcion(child.item(i++).getTextContent());
					servicio.setIdServicio(child.item(i++).getTextContent());
					servicio.setImagenB64(child.item(i++).getTextContent());
					servicio.setMensajeServicios(child.item(i++).getTextContent());
					servicio.setMensajes(Integer.parseInt(child.item(i++).getTextContent()));
					servicio.setMinutos(Integer.parseInt(child.item(i++).getTextContent()));
					servicio.setNavegacion(Integer.parseInt(child.item(i++).getTextContent()));
					servicio.setServicio(child.item(i++).getTextContent());
					servicio.setStatus(Integer.parseInt(child.item(i++).getTextContent()));
					servicio.setTipo(Integer.parseInt(child.item(i++).getTextContent()));
					servicio.setVersion(child.item(i++).getTextContent());
					servicio.setVigencia(Integer.parseInt(child.item(i++).getTextContent()));
					listServicios.add(servicio);
				}				
			}
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return listServicios;
	}
	
	public static List<ConsultaWalletGeneralVO> parseConsultaWallets (String resultadoXML) throws Exception{
		List<ConsultaWalletGeneralVO> listWallets = new ArrayList<ConsultaWalletGeneralVO>();
		ConsultaWalletGeneralVO  wallets = new ConsultaWalletGeneralVO();

		List<ConsultaWalletListVO>    consultaWalletsDinero = new ArrayList<ConsultaWalletListVO>();
		List<ConsultaWalletListVO>       consultaWalletsVoz = new ArrayList<ConsultaWalletListVO>();
		List<ConsultaWalletListVO>       consultaWalletsSms = new ArrayList<ConsultaWalletListVO>();
		List<ConsultaWalletListVO>     consultaWalletsDatos = new ArrayList<ConsultaWalletListVO>();
		List<ConsultaWalletListVO> consultaWalletsIlimitado = new ArrayList<ConsultaWalletListVO>();
		String[] nombreWallets = {"consultaWalletsDatos","consultaWalletsDinero","consultaWalletsIlimitado","consultaWalletsSms","consultaWalletsVoz"};
		ConsultaWalletListVO registro;

		validaExcepcion(resultadoXML);		

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList children;
		NodeList child;		
		Element element;
		NodeList childVO;	

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			children = doc.getElementsByTagName("planDescripcion");
			if(children != null && children.getLength() > 0)
			{
				wallets.setPlanDescripcion(children.item(0).getTextContent());
			}

			children = doc.getElementsByTagName("serviceClass");
			if(children != null && children.getLength() > 0)
			{
				wallets.setServiceClass(children.item(0).getTextContent());
			}

			children = doc.getElementsByTagName("totalRedesIlimitadas");
			if(children != null && children.getLength() > 0)
			{
				wallets.setTotalRedesIlimitadas(children.item(0).getTextContent());
			}

			children = doc.getElementsByTagName("totalWalletsDatos");
			if(children != null && children.getLength() > 0)
			{
				wallets.setTotalWalletsDatos(children.item(0).getTextContent());
			}

			children = doc.getElementsByTagName("totalWalletsDinero");
			if(children != null && children.getLength() > 0)
			{
				wallets.setTotalWalletsDinero(children.item(0).getTextContent());
			}

			children = doc.getElementsByTagName("totalWalletsSms");
			if(children != null && children.getLength() > 0)
			{
				wallets.setTotalWalletsSms(children.item(0).getTextContent());
			}

			children = doc.getElementsByTagName("totalWalletsVoz");
			if(children != null && children.getLength() > 0)
			{
				wallets.setTotalWalletsVoz(children.item(0).getTextContent());
			}

			for(int detalleW = 0; detalleW < nombreWallets.length; detalleW++)
			{
				String walletConsulta = nombreWallets[detalleW];
				children = doc.getElementsByTagName(walletConsulta);
				if(children != null && children.getLength() > 0)
				{
					element = (Element) children.item(0);
					child = element.getElementsByTagName("ConsultaWalletListVO");
					if(child != null && child.getLength() > 0)
					{
						for(int cont = 0; cont < child.getLength(); cont ++)
						{
							registro = new ConsultaWalletListVO();
							int i = 0;
							childVO = child.item(cont).getChildNodes();				
							registro.setCantidad(childVO.item(i++).getTextContent());
							registro.setEscenario(childVO.item(i++).getTextContent());
							registro.setFechaFin(childVO.item(i++).getTextContent());
							registro.setIdValor(childVO.item(i++).getTextContent());
							registro.setIdWallet(childVO.item(i++).getTextContent());
							registro.setPrioridad(childVO.item(i++).getTextContent());
							registro.setTipoWallet(childVO.item(i++).getTextContent());
							registro.setWallet(childVO.item(i++).getTextContent());

							if(walletConsulta.equals("consultaWalletsDatos"))
								consultaWalletsDatos.add(registro);
							else if(walletConsulta.equals("consultaWalletsDinero"))
								consultaWalletsDinero.add(registro);
							else if(walletConsulta.equals("consultaWalletsIlimitado"))
								consultaWalletsIlimitado.add(registro);
							else if(walletConsulta.equals("consultaWalletsSms"))
								consultaWalletsSms.add(registro);
							else if(walletConsulta.equals("consultaWalletsVoz"))
								consultaWalletsVoz.add(registro);							
						}			
					}
				}
			}			
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		wallets.setConsultaWalletsDatos(consultaWalletsDatos);
		wallets.setConsultaWalletsDinero(consultaWalletsDinero);
		wallets.setConsultaWalletsIlimitado(consultaWalletsIlimitado);
		wallets.setConsultaWalletsSms(consultaWalletsSms);
		wallets.setConsultaWalletsVoz(consultaWalletsVoz);
		listWallets.add(wallets);

		return listWallets;
	}
	
	public static String getIdOperador(String resultadoXML) throws Exception{
		String idOperador="";

		validaExcepcion(resultadoXML);
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;
		NodeList childrens;

		try{
			builder = factory.newDocumentBuilder();
			InputSource is=new InputSource(new StringReader(resultadoXML));
			doc=builder.parse(is);
			childrens = doc.getElementsByTagName("ns1:out");
			if(childrens != null && childrens.getLength() > 0)
			{
				idOperador = childrens.item(0).getTextContent();
			}
			LOGGER.info("idOperador:  {"+idOperador+"}");
			if (idOperador == null || (!idOperador.equals(String.valueOf(ATTConstants.CARRIER_IUSACEL)) && !idOperador.equals(String.valueOf(ATTConstants.CARRIER_NEXTEL)))){
				idOperador = String.valueOf(ATTConstants.VAL_CERO);
			} 
		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}

		return idOperador;
	}
}
