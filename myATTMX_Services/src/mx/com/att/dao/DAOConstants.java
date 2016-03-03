package mx.com.att.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DAOConstants {
	
	private static final Logger LOGGER = Logger.getLogger( DAOConstants.class );
	
	/*JDNI a WEB PORTAL*/
	public static final String WEB_PORTAL_JDNI= "Nextel.ecommerce.ws.jdbc.portalweb";
	
	/*JDNI a WEB WPCCI*/
	public static final String WPCCI_JDNI =  "Nextel.ecommerce.ws.jdbc.cci";
	
	/*JDNI a WEB BSCS */
	public static final String WP_BSCS_JDNI =  "Nextel.ecommerce.ws.jdbc.bscs";
	
	/*JDNI a WEB VISIO*/
	public static final String WP_VISIO_JDNI = "Nextel.ecommerce.ws.jdbc.visio";
	
	/*JDNI a WEB NXTL*/
	public static final String WP_NXTL_JDNI = "Nextel.ecommerce.ws.jdbc.nxtl";
	
	/*JDNI a WEB FACBGH*/
	public static final String WP_FACBGH_JDNI = "Nextel.ecommerce.ws.jdbc.facb";
	
	/*JDNI a WEB LDAP*/
	public static final String WP_LDAP_JDNI = "Nextel.ecommerce.ws.jdbc.ldapDb";
	
	public static void closeConnection(final Connection connection) {
		try { 
			if ( connection == null ){ 
				LOGGER.info("Conexion nula.");
			} else{
				connection.close();
			}
		} catch ( SQLException sqlException ) {
			LOGGER.error("Error en el metodo closeConnection: ", sqlException);
		}	
	}
	
	public static void closeResultSet(final ResultSet resultSet) {
		try { 
			if ( resultSet == null ){ 
				LOGGER.info("ResultSet nulo.");
			} else{
				resultSet.close();
			}
		} catch ( SQLException sqlException ) {
			LOGGER.error("Error en el metodo closeResultSet: ", sqlException);
		}	
	}
	
	public static void closePreparedStatement(final PreparedStatement prepStat) {
		try { 
			if ( prepStat == null ){ 
				LOGGER.info("PreparedStatement nulo.");
			} else{
				prepStat.close();
			}
		} catch ( SQLException sqlException ) {
			LOGGER.error("Error en el metodo closePreparedStatement: ", sqlException);
		}	
	}
}