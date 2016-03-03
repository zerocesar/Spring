package mx.com.att.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import mx.com.att.resources.ATTServiceLocator;
import mx.com.att.vo.orange.ClassificationVO;

import org.apache.log4j.Logger;

public class ParametrosDAOImpl implements ParametrosDAO {
	private static final Logger LOGGER = Logger.getLogger(ParametrosDAOImpl.class);
	private static Connection connection;
	
	public void getConnect(final String dataSource) throws SQLException, NamingException {
		connection = ATTServiceLocator.getInstance().getDataSource(dataSource).getConnection();	
	}

	@Override
	public Map<String, String> getParameterWP() {

		LOGGER.info("validando parametros de webportal");
		
		ResultSet resultSet = null;
		PreparedStatement prepStat = null;
		Map <String, String> hashMap = new HashMap<String, String>();
		final String query = "SELECT * FROM wp_parameters";
		try {
			getConnect(DAOConstants.WEB_PORTAL_JDNI);

			prepStat = connection.prepareStatement(query);
			resultSet = prepStat.executeQuery();
			
			while(resultSet.next()){
				hashMap.put(resultSet.getString("PARAM_ID"), resultSet.getString("PARAM_VALUE"));
			}
		} catch (SQLException sqlException) {
			LOGGER.error("Ocurrio un error al tratar de ejecutar la consulta sql");
			LOGGER.error("Error SQLException en el metodo getCustomerInfo: ", sqlException);
		} catch (NamingException namingException) {
			LOGGER.error("Ocurrio un error al tratar de obtener el DataSource");
			LOGGER.error("Error NamingException en el metodo getCustomerInfo: ", namingException);
		} finally {
			DAOConstants.closeResultSet(resultSet);
			DAOConstants.closePreparedStatement(prepStat);
			DAOConstants.closeConnection(connection);
		}

		return hashMap;
	}
	
	/***
	 * Este metodo obtiene todos los parametros de la tabla de fvm_parameters sobre
	 * la base de datos de Web Portal.
	 * @author Oscar Cruz - MindBits Desarrollo (14/OCT/2013)
	 * @param String, String.
	 * @return HashMap&lt;String, String&gt;
	 */
	@Override
	public Map<String, String> getParameterFVM() {

		LOGGER.info("validando parametros");
		
		ResultSet resultSet = null;
		PreparedStatement prepStat = null;
		String query = "SELECT * FROM fvm_parameters";
		Map <String, String> hashMap = new HashMap<String, String>();
		try {
			getConnect(DAOConstants.WEB_PORTAL_JDNI);

			prepStat = connection.prepareStatement(query);
			resultSet = prepStat.executeQuery();
			
			while(resultSet.next()){
				hashMap.put(resultSet.getString("PARAM_ID"), resultSet.getString("PARAM_VALUE"));
			}
		} catch (Exception e) {
			LOGGER.error("Error Exception en el metodo getParameter: ",e);
			LOGGER.error("Ocurrio un error al tratar de consultar los parametros");
		} finally {
			DAOConstants.closeResultSet(resultSet);
			DAOConstants.closePreparedStatement(prepStat);
			DAOConstants.closeConnection(connection);
		}

		return hashMap;
	}
	
	@Override
	public ClassificationVO[] getClassification(ClassificationVO classificationVO) {
		List<ClassificationVO> lstClassification = new java.util.ArrayList<ClassificationVO>();
		ResultSet resultSet = null;
		PreparedStatement preparedS = null;
		final StringBuilder query = new StringBuilder();
		query.append("SELECT META_CATALOG_ID,META_CATALOG_VALUE,META_CATALOG_TYPE,META_CATALOG_DESC");
		query.append(" FROM WP_META_CATALOG ");
		query.append(" WHERE 1=1");
		
		if(classificationVO.getMetaCatalogId()>0)
			query.append(" AND META_CATALOG_ID=? ");
		if(classificationVO.getMetaCatalogValue()!=null && classificationVO.getMetaCatalogValue().trim().length() > 0)
			query.append(" AND META_CATALOG_VALUE=? ");
		if(classificationVO.getMetaCatalogType()!=null && classificationVO.getMetaCatalogType().trim().length() > 0)
			query.append(" AND META_CATALOG_TYPE=? ");
		if(classificationVO.getMetaCatalogDesc()!=null && classificationVO.getMetaCatalogDesc().trim().length() > 0)
			query.append(" AND META_CATALOG_DESC=? ");
		
		try {
			int currParam = 1;
			getConnect(DAOConstants.WEB_PORTAL_JDNI);

			preparedS = connection.prepareStatement(query.toString());
			
			if(classificationVO.getMetaCatalogId()>0)
				preparedS.setInt(currParam++,classificationVO.getMetaCatalogId());
			if(classificationVO.getMetaCatalogValue()!=null && classificationVO.getMetaCatalogValue().trim().length() > 0)
				preparedS.setString(currParam++,classificationVO.getMetaCatalogValue());
			if(classificationVO.getMetaCatalogType()!=null && classificationVO.getMetaCatalogType().trim().length() > 0)
				preparedS.setString(currParam++,classificationVO.getMetaCatalogType());
			if(classificationVO.getMetaCatalogDesc()!=null && classificationVO.getMetaCatalogDesc().trim().length() > 0)
				preparedS.setString(currParam++,classificationVO.getMetaCatalogDesc());

			
			resultSet = preparedS.executeQuery();
			
			while(resultSet.next()){
				
				final ClassificationVO cl = new ClassificationVO();
				cl.setMetaCatalogId(resultSet.getInt("META_CATALOG_ID"));
				cl.setMetaCatalogValue(resultSet.getString("META_CATALOG_VALUE"));
				cl.setMetaCatalogType(resultSet.getString("META_CATALOG_TYPE"));
				cl.setMetaCatalogDesc(resultSet.getString("META_CATALOG_DESC"));
				 
				lstClassification.add(cl);
			}
		} catch (Exception e) {
			LOGGER.error("Error Exception en el metodo getClassification: ",e);
		} finally {
			try { if ( resultSet != null ) {resultSet.close();} } catch ( SQLException e ) {LOGGER.error("Error SQLException en el metodo getClassification: ",e);}
			try { if ( preparedS != null ) {preparedS.close();} } catch ( SQLException e ) {LOGGER.error("Error SQLException en el metodo getClassification: ",e);}
			DAOConstants.closeConnection(connection);
			
		}		
		
		return lstClassification.toArray(new ClassificationVO[lstClassification.size()]);
	}
}