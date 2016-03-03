package mx.com.att.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import com.ibm.wsdl.util.IOUtils;

public class SOAPManager {
	
	public String sURLWebService		= "";
	public int CONNECTIONTIMEOUT 		= 60000;
	public String sSoapAction		    = "";

	private RequestConfig requestConfig = null;
	private HttpClient client 			= null;
	private Document document;
	private static final Logger LOGGER = Logger.getLogger(SOAPManager.class);
	
	
	public boolean createSOAPManager(String sURL) throws Exception
	{
		boolean bresp = false;
		try
		{
			/** CON PROXY **/
//			HttpHost host = new HttpHost("10.189.48.205", 80);
//     		requestConfig 	= RequestConfig.custom().setConnectTimeout(CONNECTIONTIMEOUT).setProxy(host).build();		
     		/** SIN PROXY **/
     		requestConfig 	= RequestConfig.custom().setConnectTimeout(CONNECTIONTIMEOUT).build();
			client 			= HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
			sURLWebService  = sURL; 
			bresp 			= true;
			LOGGER.info("   + Iniciando SOAPManager  + ");
		}
		catch(Exception e)
		{
			LOGGER.info("No se pudo inicializar la clase SOAPManager");
			LOGGER.info("Message : " + e.getMessage());
			bresp 			= false;
			requestConfig 	= null;
			client 			= null;
			sURLWebService  = null; 

			throw new Exception(e.getMessage()); 
		}
		finally
		{
		}
		return bresp;
	}
	
	@SuppressWarnings("deprecation")
	public String sendRequestWithXML(String sXMLRequest) throws Exception, IOException
	{
		String sResponse	= "";
		InputStream isResponse	= null;
		HttpPost httppost = null;
		Reader reader = null;
		HttpResponse response = null;

		try
		{			
			if (sURLWebService != null || !sURLWebService.equals("") || sURLWebService.length() > 0)
			{
				httppost		= new HttpPost(sURLWebService);

				StringEntity se 		= new StringEntity(sXMLRequest,HTTP.UTF_8);
				
				if(sSoapAction != null && !sSoapAction.equals("") && sSoapAction.length() > 0)
					httppost.setHeader("SOAPAction",sSoapAction);

				se.setContentType("text/xml");  
				httppost.setHeader("Content-Type","application/soap+xml;charset=UTF-8");
				httppost.setEntity(se);
				LOGGER.info("   + Enviando operacion     + ");

				//*************************************
				//Enviamos la peticion al servicio web
				response = client.execute(httppost);
				//*************************************
				
				//Obtenemos la respuesta del servicio web			
				isResponse = response.getEntity().getContent();
				InputStream in = isResponse;
				reader = new InputStreamReader(in);
				sResponse = IOUtils.getStringFromReader(reader);
			}
		}
		catch (Exception e)
		{
			LOGGER.info("Message : " + e.getMessage());
			throw new Exception (e.getMessage());
		}finally{
			if(isResponse != null)
				isResponse.close();
			if(reader != null)
				reader.close();
			if(httppost != null)
				httppost.releaseConnection();
			if(response != null && response.getEntity() != null){
				EntityUtils.consume(response.getEntity());
			}
		}
		return sResponse;
	}
	
	public Document getDocument() 
	{
		return document;
	}

	public void setDocument(Document document) 
	{
		this.document = document;
	}
}