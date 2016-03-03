package mx.com.att.resources;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class ATTServiceLocator {
			
	private static final Logger LOG = Logger.getLogger(ATTServiceLocator.class);
	private static volatile ATTServiceLocator instance;
	private static volatile Context context;
	
	protected ATTServiceLocator() {
		serviceLocator();
	}
	
	public static void serviceLocator(){
		try {
			if (ATTServiceLocator.context == null) {
				LOG.info("Contexto de la aplicacion nulo, se creara contexto...");
				final Properties properties = new Properties();
				LOG.info("creando Contexto...");
				ATTServiceLocator.context = new InitialContext(properties);
				LOG.info("Contexto inicializado...");
			}
		} catch (NamingException ne) {
			LOG.error("Error en el metodo ATTServiceLocator: ",ne);
		} 
	}

	public static ATTServiceLocator getInstance() {
		if (ATTServiceLocator.instance == null) {
			LOG.info("ATTServiceLocator nulo, creando instancia...");
			ATTServiceLocator.instance = new ATTServiceLocator();	
			LOG.info("ATTServiceLocator, instancia creada...");
		}
		return ATTServiceLocator.instance;
	}

	public DataSource getDataSource(final String jndiReference) throws NamingException {
		LOG.info("getDataSource - Obteniendo DataSource con la referencia: [" + jndiReference + "]");
		return (DataSource) context.lookup(jndiReference);
	}
}