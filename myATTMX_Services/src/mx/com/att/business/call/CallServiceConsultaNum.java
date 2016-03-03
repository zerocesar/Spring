package mx.com.att.business.call;

import java.util.Date;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import mx.com.att.support.SOAPManager;
import mx.com.att.utils.ATTConstants;
import mx.com.att.vo.red.OperadorVO;

public class CallServiceConsultaNum {	
	private	String urlConsultaNum = ATTConstants.URL_WS_CONSULTASNUM + "ConsultasNum/ConsultasNum";

	private static final Logger LOGGER = Logger.getLogger(CallServiceConsultaNum.class);

	public OperadorVO getInfoOwner (String dn) throws Exception 
	{
		StringBuffer sXMLRequest = new StringBuffer();
		String sResponse="";		
		OperadorVO operador = null;

		LOGGER.info(" >>> L l a m a d a   W e b   S e r v i c e");
		LOGGER.info("     EndPoint               : " + urlConsultaNum);
		LOGGER.info("     Operacion              : getInfoOwner");
		LOGGER.info("     requesting             : " + new Date().toString());
		LOGGER.info("   + Parametros             + ");		
		LOGGER.info("     Dn                     : " + dn);		


		try {

			sXMLRequest.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:con=\"http://consultasnum.iusacell.com/\">" );
			sXMLRequest.append(   "<soapenv:Header/>");
			sXMLRequest.append(   "<soapenv:Body>");
			sXMLRequest.append(      "<con:getInfoOwner>");
			sXMLRequest.append(         "<mdn>"+dn+"</mdn>");            
			sXMLRequest.append(      "</con:getInfoOwner>");
			sXMLRequest.append(   "</soapenv:Body>");
			sXMLRequest.append("</soapenv:Envelope>");


			LOGGER.debug("     SOAPRequestXML         : "  +  sXMLRequest);

			SOAPManager soapManager = new SOAPManager();
			soapManager.createSOAPManager(urlConsultaNum);
			sResponse = soapManager.sendRequestWithXML(sXMLRequest.toString());

			LOGGER.info("   + Respuesta              + ");
			LOGGER.debug("     XMLRespuesta           : " +  sResponse);

			operador = ParseConsultasNum.parseGetInfoOwner(sResponse);

		}catch(Exception e)
		{
			LOGGER.error("Eror al invocar getInfoOwner: ",e);
			throw new ServiceException(e.getLocalizedMessage());
		}
		return operador;
	}
}
