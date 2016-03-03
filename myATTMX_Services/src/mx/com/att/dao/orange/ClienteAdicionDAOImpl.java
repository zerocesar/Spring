package mx.com.att.dao.orange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import mx.com.att.dao.DAOConstants;
import mx.com.att.resources.ATTServiceLocator;
import mx.com.att.validator.ValidateException;
import mx.com.att.vo.orange.CommercialConfigurationVO;
import mx.com.att.vo.orange.OrdenesWPVO;
import mx.com.att.vo.orange.ParamCatalogoVO;
import mx.com.att.vo.orange.ServiceWPVO;

import org.apache.log4j.Logger;

public class ClienteAdicionDAOImpl implements ClienteAdicionDAO{

	private static final Logger LOG = Logger.getLogger( ClienteAdicionDAOImpl.class );
	Connection connection;


	public void getConnect(String dataSource) throws SQLException, NamingException {
		connection = ATTServiceLocator.getInstance().getDataSource(dataSource).getConnection();
	}


	/**
	 * Este metodo consulta en la base de datos de Web Portal los 
	 * parametros de la tabla FVM_PARAMETERS
	 * @author Karina Quintana - MindBits Desarrollo (14/OCT/2013)
	 * @param String param_id
	 * @return ParamCatalogoVO un objeto con el param_value
	 *    correspondiente al valor del param_id consultado.
	 * @throws SQLException 
	 */
	@Override
	public ParamCatalogoVO getParameter(String param_id){
		ResultSet rs3 = null;
		StringBuffer strQuery3 = null;
		PreparedStatement ps3 = null;
		ParamCatalogoVO aux = null;
		LOG.info("entramos en el dao de getParameter");
		try {
			getConnect(DAOConstants.WEB_PORTAL_JDNI);
			LOG.info("entramos en conexion"+connection);
			strQuery3 = new StringBuffer();
			strQuery3.append("SELECT PARAM_ID, PARAM_VALUE  ");
			strQuery3.append("FROM FVM_PARAMETERS  ");
			strQuery3.append("WHERE PARAM_ID = ? ");

			ps3 = connection.prepareStatement( strQuery3.toString() );
			LOG.info("prepared "+ ps3);
			ps3.setString(1,param_id);
			rs3 = ps3.executeQuery();//EJECUCION DEL QUERY

			if ( rs3.next() ){
				aux = new ParamCatalogoVO();
				aux.setParam_id(rs3.getString("PARAM_ID"));
				aux.setParam_value(rs3.getString("PARAM_VALUE"));
				LOG.info("estamos aqui "+aux);
			}
		} catch (SQLException e) {
			LOG.error("Error SQLException en el metodo getOrdenesWP: ",e);
		} catch (NamingException e) {
			LOG.error("Error NamingException en el metodo getOrdenesWP: ",e);
		} finally {
			try { if ( rs3 != null ) {rs3.close();} } catch ( SQLException e ) {LOG.error("Error SQLException en el metodo getParameter: ",e);}
			try { if ( ps3 != null ) {ps3.close();} } catch ( SQLException e ) {LOG.error("Error SQLException en el metodo getParameter: ",e);}
			DAOConstants.closeConnection(connection);
		}
		return aux;
	}
	
	/**
	 * Este metodo consulta en la base de datos de Web Portal
	 *  los parametros de la tabla WP_PARAMETERS
	 * @author Oscar Cruz - MindBits Desarrollo (14/OCT/2013)
	 * @param String param_id
	 * @return ParamCatalogoVO un objeto con el parametro 
	 * un param_value del valor correspondiente al param_id consultado.
	 * 
	 */
	@Override
	public ParamCatalogoVO getParameterWp(String param_id) {
		ResultSet rs3 = null;
		StringBuffer strQuery3 = null;
		PreparedStatement ps3 = null;
		ParamCatalogoVO aux = null;
		LOG.info("entramos en el dao de getParameter");
		try {
			getConnect(DAOConstants.WEB_PORTAL_JDNI);

			LOG.info("entramos en conexion"+connection);
			strQuery3 = new StringBuffer();
			strQuery3.append("SELECT PARAM_ID, PARAM_VALUE  ");
			strQuery3.append("FROM WP_PARAMETERS  ");
			strQuery3.append("WHERE PARAM_ID = ? ");

			ps3 = connection.prepareStatement( strQuery3.toString() );
			LOG.info("prepared "+ ps3);
			ps3.setString(1,param_id);
			rs3 = ps3.executeQuery();

			if ( rs3.next() ){
				aux = new ParamCatalogoVO();
				aux.setParam_id(rs3.getString("PARAM_ID"));
				aux.setParam_value(rs3.getString("PARAM_VALUE"));
				LOG.info("estamos aqui "+aux);
			}
		} catch ( Exception e ) {
			LOG.error("Error en el metodo getParameterWp: ",e);
			//throw new SOEntException("No se puede obtener el profile" + e.getMessage());
		} finally {
			try { if ( rs3 != null ) {rs3.close();} } catch ( SQLException e ) {LOG.error("Error SQLException en el metodo getParameterWp: ",e);}
			try { if ( ps3 != null ) {ps3.close();} } catch ( SQLException e ) {LOG.error("Error SQLException en el metodo getParameterWp: ",e);}
			DAOConstants.closeConnection(connection);
		}
		return aux;
	}
	
	/**
	 * Este metodo obtiene un estatus de orden, nombre y 
	 * descripciÃ³n de la orden, 
	 * a partir del parÃ¡metro ORDER_ID, realiza una consulta
	 *  con web Portal tomando 
	 * como condicion el order_id, sobre las tablas de 
	 * @author Daniel Ceron - MindBits Desarrollo (14/OCT/2013)
	 * @param  String idPromocion
	 * @throws SOEntException
	 * @return OrdenesWPVO con los datos correspondientes a las
	 *  orden como son estatus de la orden,
	 * 			nombre de la orden, descripcion.
	 * @throws SQLException 
	 *
	 */
	@Override
	public OrdenesWPVO getOrdenesWP(String orderID) {
		ResultSet resultSet = null;
		PreparedStatement prepaSta =null;
		OrdenesWPVO ordenesObtn = new OrdenesWPVO();		
		try {
			
			getConnect(DAOConstants.WEB_PORTAL_JDNI);
			if (orderID == null ){				
				
				throw new ValidateException("El id de la orden no puede estar vacio.");
			}
			else{
				LOG.info(" Buscando ordenes en web portal... ");
				StringBuffer strQuery = new StringBuffer();												
				strQuery.append("SELECT WOSC.ORDER_STATUS_ID, WOSC.NAME, WOSC.DESCRIPTION ");
				strQuery.append(" FROM  WP_ORDER_STATUS_CATALOG WOSC, WP_SERV_ORD_LOG WSOL, WP_SERVICE_ORDERS WSO");
				strQuery.append(" WHERE WSO.ORDER_ID = ?");
				strQuery.append(" AND WSOL.ORDER_ID = WSO.ORDER_ID");
				strQuery.append(" AND WSOL.ORDER_STATUS_ID = WOSC.ORDER_STATUS_ID");
				strQuery.append(" AND SERV_ORD_ID =(SELECT MAX(SERV_ORD_ID) FROM WP_SERV_ORD_LOG WHERE ORDER_ID = ?)");
				
				prepaSta = connection.prepareStatement(strQuery.toString());
				prepaSta.setString(1, orderID);
				prepaSta.setString(2, orderID);
				resultSet = prepaSta.executeQuery();
				
				while(resultSet.next()){
					ordenesObtn = new OrdenesWPVO();
					ordenesObtn.setOrderStatus(resultSet.getString("ORDER_STATUS_ID"));
					ordenesObtn.setNombre(resultSet.getString("NAME"));
					ordenesObtn.setDescripcion(resultSet.getString("DESCRIPTION"));
				}			
			}
		} catch (SQLException e) {
			 LOG.error("Error SQLException en el metodo getOrdenesWP: ",e);
		} catch (NamingException e) {
			LOG.error("Error NamingException en el metodo getOrdenesWP: ",e);
		} catch (ValidateException e) {
			LOG.error("Error ValidateException en el metodo getOrdenesWP: ",e);
		} finally {
			try { if ( resultSet != null ) {resultSet.close();} } catch ( SQLException e ) {LOG.error("Error SQLException en el metodo getOrdenesWP: ",e);}
			try { if ( prepaSta != null ) {prepaSta.close();} } catch ( SQLException e ) {LOG.error("Error SQLException en el metodo getOrdenesWP: ",e);}
			DAOConstants.closeConnection(connection);
		}
		return ordenesObtn;
	}
	
	/**
	 *Este metodo realiza la consulta a la base de datos de CCI
	 *  tomado como condicion el custcode,
	 * regresando el numero de incidentes con los que el cliente
	 *  cuenta con base a las tablas 
	 * siguientes CCI_INCIDENTES, CCI_CATEGORIAS, CCI_SUBCATEGORIAS
	 * @author Jesus Perez - MindBits Desarrollo (14/OCT/2013) 
	 * @param String custcode representa la cuenta del cliente.
	 * @return int incidents numero de incidentes que la cuenta
	 *  tiene asociada
	 * @throws SQLException 
	 * 
	 */
	@Override
	public int getIncidentes(String custCode) {
		ResultSet resultSet = null;
		PreparedStatement prepaSta =null;
		
		int incidents=0;
		try {
			getConnect(DAOConstants.WPCCI_JDNI);	
			if (custCode ==null){
				throw new ValidateException("El cusCode no  puede estar vacio");
			}else{
				LOG.info(" Buscando ordenes en web portal... ");
				StringBuffer strQuery = new StringBuffer();					
				strQuery.append("SELECT COUNT(*) CUENTA ");
				strQuery.append(" FROM CCI_INCIDENTES I, CCI_CATEGORIAS C, CCI_SUBCATEGORIAS S");
				strQuery.append(" WHERE CUSTCODE = ?");
				strQuery.append(" AND I.CATEGORIA_ID = C.CATEGORIA_ID");
				strQuery.append(" AND I.SUBCATEGORIA_ID = S.SUBCATEGORIA_ID");
				strQuery.append(" AND D_CATEGORIA = 'MOVIMIENTOS A LA CUENTA'");
				strQuery.append(" AND ESTATUS_ID IN (1, 2)");
				strQuery.append(" AND D_SUBCATEGORIA = 'INFORMACION CONFIDENCIAL'");
				LOG.info("    prepareStatement() ...");
				
				prepaSta = connection.prepareStatement(strQuery.toString());
				prepaSta.setString(1, custCode);
				LOG.info("inicio ---Ejecutando Query");
				
				resultSet = prepaSta.executeQuery();
				LOG.info("fin ---Ejecutando Query");
				incidents=0;
				
				while(resultSet.next()){
					incidents=resultSet.getInt(1);
				}
			}
			
		}catch (SQLException e) {
			LOG.error("Error SQLException en el metodo getIncidentes: ",e);
		} catch (ValidateException e) {
			LOG.error("Error ValidateException en el metodo getIncidentes: ",e);
		} catch (NamingException e) {
			LOG.error("Error NamingException en el metodo getIncidentes: ",e);
		} finally {
			try { if ( resultSet != null ) {resultSet.close();} } catch ( SQLException e ) {LOG.error("Error SQLException en el metodo getIncidentes: ",e);}
			try { if ( prepaSta != null ) {prepaSta.close();} } catch ( SQLException e ) {LOG.error("Error SQLException en el metodo getIncidentes: ",e);}
			DAOConstants.closeConnection(connection);
		}
		return incidents;
	}

	/**
	 * Este metodo hace la consulta a la base da datos de web 
	 * Portal a fin de enlistar los servicios, 
	 * con base al tipo de contrato, el canal y el tipo de 
	 * tecnologia (2G,3G)
	 * @author Karina Quintana - Mindbits Desarrollo (14/OCT/2013)
	 * @param CommercialConfigurationVO con los siguientes parametros
	 *  channelID, tipoDeContrato, idTipo de tecnologia, 
	 * idTipo de Servicio.
	 * @return List&lt;ServiceOrderWPVO&gt; con los siguientes 
	 * parametros no nulos.
	 * service, serviceType, serv_name, SERV_DESCRIPTION, 
	 * SERV_SNCODE, SERV_SPCODE, SERV_TYPE_NAME, 
	 * SERV_TYPE_SECRET_HASH, SERV_TYPE_DESCRIPTION, 
	 * SERV_TYPE_ACCESS_CODE, SERV_TYPE_MERCHANT_ID
	 * @throws SQLException 
	  */
	@Override
	public List<ServiceWPVO> getServiciosList(CommercialConfigurationVO conf) {
		ResultSet resultSet= null;
		PreparedStatement pstmt= null;
		List<ServiceWPVO> listaServicios= new ArrayList<ServiceWPVO>();
		LOG.info("Estamos en el dao de getServiciosList");
		try{
			
			getConnect(DAOConstants.WEB_PORTAL_JDNI);
			StringBuffer query=new StringBuffer();
			
			query.append("SELECT DISTINCT WCC.SERVICE_ID AS SERVICE, WSC.SERVICE_TYPE_ID AS SERVICE_TYPE,"
				         +" WSC.NAME AS SERV_NAME, WSC.DESCRIPTION AS SERV_DESCRIPTION, "
				         +" WSC.SN_CODE AS SERV_SNCODE, WSC.SP_CODE AS SERV_SPCODE, "
				         +" WST.NAME AS SERV_TYPE_NAME, WST.DESCRIPTION AS SERV_TYPE_DESCRIPTION, "
				         +" WST.SECRET_HASH AS SERV_TYPE_SECRET_HASH, WST.ACCESS_CODE AS SERV_TYPE_ACCESS_CODE, "
				         +" WST.MERCHANT_ID AS SERV_TYPE_MERCHANT_ID, WSBF.FAMILY_ID, WSBF.WEIGHT, "
				         +" CASE WHEN (SELECT COUNT(WSBF.FAMILY_ID) "
				         +" FROM WP_SERVICES_BY_FAMILY WSBF, "
				         +" WP_FAMILY_CATALOG WFC, "
				         +" WP_SERVICE_CATALOG WSC2 "
				         +" WHERE WFC.FAMILY_ID = WSBF.FAMILY_ID "
				         +" AND WSBF.SERVICE_ID = WSC2.SERVICE_ID "
				         +" AND WSC2.SN_CODE = (SELECT SN_CODE FROM WP_SERVICE_CATALOG WSC3 WHERE WSC3.SERVICE_ID = WSC.SERVICE_ID)) > 0 "
				         +" THEN 1 "
				         +" ELSE 0 "
				         +" END AS ISINFAMILY "
				         +" FROM WP_COMMERCIAL_CONFIGURATION WCC, "
				         +" WP_SERVICE_CATALOG WSC, "
				         +" WP_SERVICE_TYPE WST, "
				         +" WP_PAYMENT_OPTIONS WPO, " 
				         +" WP_CONTRACT_TYPES WCT, "
				         +" WP_SELL_CHANNELS WSCH, "
				         +" WP_TECHNOLOGY_TYPE WTT, "
				         +" WP_SERVICES_BY_FAMILY WSBF "
				         +" WHERE WCC.SERVICE_ID = WSC.SERVICE_ID "
				         +" AND WSC.SERVICE_TYPE_ID = WST.SERVICE_TYPE_ID "
				         +" AND WCC.PAYMENT_ID = WPO.PAYMENT_ID "
				         +" AND WCC.CONTRACT_TYPE_ID = WCT.CONTRACT_TYPE_ID "
				         +" AND WCC.CHANNEL_ID = WSCH.CHANNEL_ID "
				         +" AND WTT.TECHNOLOGY_TYPE_ID (+)= WST.TECHNOLOGY_TYPE_ID "
				         +" AND WCC.STATUS = 'AC' "
				         +" AND WSBF.SERVICE_ID (+)= WSC.SERVICE_ID "
				         +" AND WCC.CHANNEL_ID =  ? "
				         +" AND WCC.CONTRACT_TYPE_ID = ? "
				         +" AND NVL(WTT.TECHNOLOGY_TYPE_ID, ? "
				         +" ) = ? ");

			if (conf.getServiceTypeId()>0L){
				query.append("AND WST.SERVICE_TYPE_ID = ? ");
			}
			
			query.append("ORDER BY WSBF.WEIGHT ASC");

				pstmt=connection.prepareStatement(query.toString());	
			LOG.info("Estamos en el dao de getServiciosList tenemos conexion");
			LOG.info("Query"+query);
			pstmt.setLong(1, conf.getChannelId());
			pstmt.setLong(2, conf.getContractTypeId());
			pstmt.setLong(3, conf.getTechnologyTypeId());
			pstmt.setLong(4, conf.getTechnologyTypeId());
			
			if (conf.getServiceTypeId()>0L){
				pstmt.setLong(5, conf.getServiceTypeId());
			}
			
			LOG.info("Query33333"+" "+conf.getChannelId() +" " +conf.getContractTypeId() +" "+ conf.getTechnologyTypeId());
			resultSet= pstmt.executeQuery();
				
			LOG.info("inicio... recorre");
			if(resultSet == null){	
				throw new ValidateException("No se encontraron servicios en la base de datos.");
			}
			else{
				while(resultSet.next()){
					ServiceWPVO  ccC= new ServiceWPVO();
					ccC.setServiceId(resultSet.getLong("SERVICE"));
					ccC.setServiceTypeId(resultSet.getLong("SERVICE_TYPE"));
					ccC.setServName(resultSet.getString("SERV_NAME"));
					ccC.setServDescription(resultSet.getString("SERV_DESCRIPTION"));
					ccC.setServSncode(resultSet.getString("SERV_SNCODE"));
					ccC.setServSpcode(resultSet.getString("SERV_SPCODE"));
					ccC.setServTypeName(resultSet.getString("SERV_TYPE_NAME"));
					ccC.setServTypeDescription(resultSet.getString("SERV_TYPE_DESCRIPTION"));
					ccC.setServTypeSecretHash(resultSet.getString("SERV_TYPE_SECRET_HASH"));
					ccC.setServTypeAccessCode(resultSet.getString("SERV_TYPE_ACCESS_CODE"));
					ccC.setServTypeMerchantId(resultSet.getString("SERV_TYPE_MERCHANT_ID"));
					listaServicios.add(ccC);
				}
			}
			
		} catch (SQLException e) {
			LOG.error("Error SQLException en el metodo getServiciosList: ",e);
		} catch (NamingException e) {
			LOG.error("Error NamingException en el metodo getServiciosList: ",e);
		} catch (ValidateException e) {
			LOG.error("Error ValidateException en el metodo getServiciosList: ",e);
		} finally {
			DAOConstants.closePreparedStatement(pstmt);
			DAOConstants.closeResultSet(resultSet);
			DAOConstants.closeConnection(connection);
		}
		return listaServicios;
	}


	@Override
	public List<CommercialConfigurationVO> getServicesByChannel(
			CommercialConfigurationVO commercialConfig) {
		
		LOG.info("Iniciando la ejecución del método getServicesByChannel de la clase ClienteAdicionDAOImpl...");
		ResultSet resultSet = null;
		PreparedStatement preparedStatement= null;
		
		List<CommercialConfigurationVO> services = new ArrayList<CommercialConfigurationVO>();
		CommercialConfigurationVO service;
		
		try{
			getConnect(DAOConstants.WEB_PORTAL_JDNI);
			LOG.info("Conexión obtenida: " + connection );
			StringBuffer strQuery=new StringBuffer();
			
			strQuery.append("SELECT WCC.COMMERCIAL_CONFIG_ID, WCC.CHANNEL_ID, WCC.SERVICE_ID, WSC.SERVICE_TYPE_ID,  ");
			strQuery.append("       WCC.CONTRACT_TYPE_ID, WCC.PAYMENT_ID, WTT.TECHNOLOGY_TYPE_ID, ");
			strQuery.append("       WCC.STATUS, TO_CHAR(WCC.REG_DATE,'DD/MM/YYYY HH:MI:SS PM') AS REG_DATE, WCC.REG_USER, ");
			strQuery.append("       TO_CHAR(WCC.MOD_DATE,'DD/MM/YYYY HH:MI:SS PM') AS MOD_DATE, WCC.MOD_USER, ");
			strQuery.append("       WSC.NAME AS SERV_NAME, WSC.DESCRIPTION AS SERV_DESCRIPTION, ");
			strQuery.append("       WPO.NAME AS PAYM_NAME, WPO.DESCRIPTION AS PAYM_DESCRIPTION, ");
			strQuery.append("       WST.NAME AS SERV_TYPE_NAME, WST.DESCRIPTION AS SERV_TYPE_DESCRIPTION, ");
			strQuery.append("       WCT.NAME AS CONT_NAME, WCT.DESCRIPTION AS CONT_DESCRIPTION, ");
			strQuery.append("       WSCH.NAME AS CHAN_NAME, WSCH.DESCRIPTION AS CHAN_DESCRIPTION, ");
			strQuery.append("       WST.PREFIX ");
			strQuery.append("FROM WP_COMMERCIAL_CONFIGURATION WCC, ");
			strQuery.append("     WP_SERVICE_CATALOG WSC, ");
			strQuery.append("     WP_SERVICE_TYPE WST, ");
			strQuery.append("     WP_PAYMENT_OPTIONS WPO, ");
			strQuery.append("     WP_CONTRACT_TYPES WCT, ");
			strQuery.append("     WP_SELL_CHANNELS WSCH, ");
			strQuery.append("     WP_TECHNOLOGY_TYPE WTT ");
			strQuery.append("WHERE WCC.SERVICE_ID = WSC.SERVICE_ID ");
			strQuery.append("      AND WSC.SERVICE_TYPE_ID = WST.SERVICE_TYPE_ID ");
			strQuery.append("      AND WCC.PAYMENT_ID = WPO.PAYMENT_ID ");
			strQuery.append("      AND WCC.CONTRACT_TYPE_ID = WCT.CONTRACT_TYPE_ID ");
			strQuery.append("      AND WCC.CHANNEL_ID = WSCH.CHANNEL_ID ");
			strQuery.append("      AND WTT.TECHNOLOGY_TYPE_ID (+)= WST.TECHNOLOGY_TYPE_ID ");
			strQuery.append("      AND WCC.STATUS = 'AC' ");
			strQuery.append("AND WSC.SERVICE_TYPE_ID NOT IN (3, 4, 5, 6, 11, 12) ");
			strQuery.append("AND WCC.CHANNEL_ID = ? "); // Parámetro 1
			strQuery.append("ORDER BY CHANNEL_ID ASC, CONTRACT_TYPE_ID ASC, TECHNOLOGY_TYPE_ID ASC, SERVICE_TYPE_ID ASC, SERVICE_ID ASC, PAYMENT_ID ASC ");
			
			preparedStatement = connection.prepareStatement( strQuery.toString() );
			
//			LOG.info("Query: \n" + strQuery.toString());
			
			preparedStatement.setInt(1, (int)commercialConfig.getChannelId() );
			
			resultSet = preparedStatement.executeQuery();
			
			
				while( resultSet.next() ){
					
					service = new CommercialConfigurationVO();
					
					service.setCommercialConfigId(  resultSet.getLong("COMMERCIAL_CONFIG_ID") );
					service.setChannelId(           resultSet.getLong("CHANNEL_ID") );
					service.setServiceId(           resultSet.getLong("SERVICE_ID") );
					service.setServiceTypeId(       resultSet.getLong("SERVICE_TYPE_ID") );
					service.setContractTypeId(      resultSet.getLong("CONTRACT_TYPE_ID") );
					service.setPaymentId(           resultSet.getLong("PAYMENT_ID") );
					service.setTechnologyTypeId(    resultSet.getLong("TECHNOLOGY_TYPE_ID") );
					service.setStatus(              resultSet.getString("STATUS") );
					service.setRegDate(             resultSet.getString("REG_DATE") );
					service.setRegUser(             resultSet.getString("REG_USER") );
					service.setModDate(             resultSet.getString("MOD_DATE") );
					service.setModUser(             resultSet.getString("MOD_USER") );
					service.setServName(            resultSet.getString("SERV_NAME") );
					service.setServDescription(     resultSet.getString("SERV_DESCRIPTION") );
					service.setPaymName(            resultSet.getString("PAYM_NAME") );
					service.setPaymDescription(     resultSet.getString("PAYM_DESCRIPTION") );
					service.setServTypeName(        resultSet.getString("SERV_TYPE_NAME") );
					service.setServTypeDescription( resultSet.getString("SERV_TYPE_DESCRIPTION") );
					service.setContName(            resultSet.getString("CONT_NAME") );
					service.setContDescription(     resultSet.getString("CONT_DESCRIPTION") );
					service.setChanName(            resultSet.getString("CHAN_NAME") );
					service.setChanDescription(     resultSet.getString("CHAN_DESCRIPTION") );
					service.setPrefix(              resultSet.getString("PREFIX") );
					
					services.add(service);
				}
			
			
			LOG.info("servicios encontrados: " + services.size());
			
		}  catch (SQLException e) {
			LOG.error("Ocurrio un error al tratar de ejecutar la consulta sql");
			LOG.error("Error SQLException en el método getServicesByChannel: ",e);
		} catch (Exception e) {
			LOG.error("Ocurrio un error al tratar de ejecutar la consulta");
			LOG.error("Error Exception en el método getServicesByChannel: ",e);
		}finally{
			try { 
				if ( resultSet != null ){
					resultSet.close(); 
				} 
			} catch ( SQLException e ){
				LOG.error("Ocurrió un error al tratar de cerrar el objeto ResultSet");
				LOG.error("Error SQLException en el método getServicesByChannel: ",e);
			}
			try { 
				if ( preparedStatement != null ){
					preparedStatement.close(); 
				} 
			} catch ( SQLException e ){
				
				LOG.error("Ocurrió un error al tratar de cerrar el objeto PreparedStatement");
				LOG.error("Error SQLException en el método getServicesByChannel: ",e);			
			}
			DAOConstants.closeConnection(connection);
		}
		
		return services;
	}
}