package mx.com.att.utils;

import java.util.Properties;

import mx.com.att.business.call.CallServicesMiIusacell;

import org.apache.log4j.Logger;
import java.net.URL;

public class Certificado {
	private static final Logger LOGGER = Logger.getLogger(CallServicesMiIusacell.class);	

	public static void agregaKS()
	{
		try
		{	
			LOGGER.info("Inicia certificado");
			
			String rutaKeyStore = "";						
			
			
//			URL url2 = Certificado.class.getResource("miiusacellks");																
            URL url   = Certificado.class.getProtectionDomain().getCodeSource().getLocation();
                        
            if(url != null){
            	LOGGER.info("Path " + url.getPath());
            	if(url.getPath().contains("myATTMX_Services/build/classes/"))
            		rutaKeyStore = url.getPath().replace("build/classes/mx/com/att/utils/Certificado.class", "WebContent/WEB-INF/miiusacellks");
            	else if(url.getPath().contains("lib/_wl_cls_gen.jar"))
            		rutaKeyStore = url.getPath().replace("lib/_wl_cls_gen.jar", "miiusacellks");
            		
            }      
            
            LOGGER.info("Path FINAL " + rutaKeyStore);
            
            
            
//			
			
			Properties p = System.getProperties();
			p.remove("javax.net.ssl.trustStore");
			p.remove("javax.net.ssl.trustStorePassword");

			System.setProperty("javax.net.ssl.trustStore", rutaKeyStore);
			System.setProperty("javax.net.ssl.trustStorePassword", "Iusacell");
			
			
			
		}
		catch(Exception e)
		{
			LOGGER.error("");
			LOGGER.error("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			LOGGER.error("::                              ERROR AL CARGAR KEYSTORE ");
			LOGGER.error("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			LOGGER.error("");
		}
	}	
}
