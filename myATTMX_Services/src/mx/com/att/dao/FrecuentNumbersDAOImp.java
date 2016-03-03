package mx.com.att.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import mx.com.att.resources.ATTServiceLocator;

import org.apache.log4j.Logger;

public class FrecuentNumbersDAOImp implements FrecuentNumbersDAO {

	private static final Logger LOGGER = Logger.getLogger(FrecuentNumbersDAOImp.class);
	private Connection connection = null;
	
	public void getConnect(String dataSource) throws SQLException, NamingException {
		connection = ATTServiceLocator.getInstance().getDataSource(dataSource).getConnection();	
	}
	
	@Override
	public int getMaximoNumerosFrecuentes(String tmcode, String dNumber) {
		LOGGER.info("Iniciando metodo getMaximoNumerosFrecuentes en la clase FrecuentNumbersDAOImp");
		ResultSet resultSet = null;
		StringBuffer strQuery = null;
		PreparedStatement prepStat = null;
		int maxNumsFrecs = 0;
		
		try {
			//TODO: Checar el datasource para esta consulta
			getConnect(DAOConstants.WP_VISIO_JDNI);
			LOGGER.info("Recuperamos la conexion: " + connection);
			
			strQuery = new StringBuffer();
			
			strQuery.append("SELECT max_ff ");
			strQuery.append("FROM MKT_PLAN ");
			strQuery.append("WHERE TMCODE = ? ");

			prepStat = connection.prepareStatement( strQuery.toString() );
			LOGGER.info("Ejecutando query::::::::: " + strQuery.toString() );
			prepStat.setLong(1,Long.parseLong(tmcode));
			resultSet = prepStat.executeQuery();//EJECUCION DEL QUERY

			if ( resultSet.next() ){
				maxNumsFrecs = resultSet.getInt("max_ff");
			}
			LOGGER.info("Maximo Numeros Frecuentes: " + maxNumsFrecs + " para el numero telefonico: " + dNumber);
			
		} catch (SQLException e) {
			LOGGER.error("Ocurrio un error al tratar de ejecutar la consulta sql");
			LOGGER.error("Error SQLException en el metodo getMaximoNumerosFrecuentes: ",e);
		} catch (NamingException e) {
			LOGGER.error("Ocurrio un error al tratar de obtener el DataSource");
			LOGGER.error("Error NamingException en el metodo getMaximoNumerosFrecuentes: ",e);
		}
		finally{
			DAOConstants.closeResultSet(resultSet);
			DAOConstants.closePreparedStatement(prepStat);
			DAOConstants.closeConnection(connection);
		}
		return maxNumsFrecs;
	}

}