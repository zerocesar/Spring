package mx.com.att.resources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import mx.com.att.utils.ConfigParametersATT;

import org.apache.log4j.Logger;

public class ContextListener implements ServletContextListener{
	private static final Logger LOGGER = Logger.getLogger(ContextListener.class);
	public void contextInitialized(final ServletContextEvent ctxEvent) {
		LOGGER.info("<<<<<<<<<< Init ContextListener >>>>>>>>>>");
		LOGGER.info("<<<<<<<<<< Version 1.0.2 >>>>>>>>>>");
		LOGGER.info("<<<<<<<<<< 29-01-2016 >>>>>>>>>>");
		LOGGER.info("<<<<<<<<<< RFC 1601C1116 >>>>>>>>>>");
		final ConfigParametersATT configParameters = new ConfigParametersATT();
		configParameters.configureParameters();
	}

	public void contextDestroyed(final ServletContextEvent ctxEvent) {
		LOGGER.info("<<<<<<<<<< Version 1.0.2 >>>>>>>>>>");
		LOGGER.info("<<<<<<<<<< 29-01-2016 >>>>>>>>>>");
		LOGGER.info("<<<<<<<<<< RFC 1601C1116 >>>>>>>>>>");
		LOGGER.info("<<<<<<<<<< Final ContextListener >>>>>>>>>>");
	}
}