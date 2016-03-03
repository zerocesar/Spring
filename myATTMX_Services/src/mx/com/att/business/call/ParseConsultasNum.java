package mx.com.att.business.call;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;

import mx.com.att.vo.red.OperadorVO;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ParseConsultasNum {

	private static final Logger LOGGER = Logger.getLogger(ParseConsultasNum.class);
	
	public static OperadorVO parseGetInfoOwner(String resultadoXML) throws Exception{

		OperadorVO operador = new OperadorVO();	

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

			children = doc.getElementsByTagName("operador");
			if(children != null && children.getLength() > 0)	
			{
				child = children.item(0).getChildNodes();	
				for(int cont = 0; cont < child.getLength(); cont ++)
				{
					if (child.item(cont).getNodeName() != null &&  child.item(cont).getNodeName().equals("idOperadorComp"))
						operador.setIdOperadorComp(child.item(cont).getTextContent());
					else if (child.item(cont).getNodeName() != null &&  child.item(cont).getNodeName().equals("ida"))
						operador.setIdA(child.item(cont).getTextContent()); 
					else if (child.item(cont).getNodeName() != null &&  child.item(cont).getNodeName().equals("ido"))
						operador.setIdO(child.item(cont).getTextContent());
				}
			}			


		} catch (ParserConfigurationException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (SAXException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		} catch (IOException e) {
			LOGGER.error("Exception al realizar parser: " + e.getLocalizedMessage());
		}					

		return operador;
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
}
