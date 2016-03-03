package mx.com.att.business;

import java.util.Map;

import mx.com.att.dao.ParametrosDAOImpl;

import org.apache.log4j.Logger;

public class ParametrosBusiness {
	
	private static final Logger LOGGER = Logger.getLogger(ParametrosBusiness.class);

	public Map<String,String> getConfigurationParameterWP(){
		LOGGER.info("Entrando a ParametrosBusiness.getConfigurationParameterWP");
		final ParametrosDAOImpl pdaoimpl = new ParametrosDAOImpl();
		
		return pdaoimpl.getParameterWP();
	}
	
	public Map<String,String> getConfigurationParameterFVM(){
		LOGGER.info("Entrando a ParametrosBusiness.getConfigurationParameter");
		final ParametrosDAOImpl pdaoimpl = new ParametrosDAOImpl(); 
	  
	  return pdaoimpl.getParameterFVM();
	}
}