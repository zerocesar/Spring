package mx.com.att.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import mx.com.att.resources.ATTServiceLocator;
import mx.com.att.vo.BankReferenceVO;

public class PaymentDAOImp implements PaymentDAO {
	
	private static final Logger LOGGER = Logger.getLogger(FrecuentNumbersDAOImp.class);
	private Connection connection = null;
	
	public void getConnect(String dataSource) throws SQLException, NamingException {
		connection = ATTServiceLocator.getInstance().getDataSource(dataSource).getConnection();	
	}
	
	@Override
	public BankReferenceVO[] getBankReference(BankReferenceVO bankReferenceVO) {
		LOGGER.info("Iniciando metodo getBankReference en la clase PaymentDAOImp");
		List<BankReferenceVO> listBankReferenceVO = new ArrayList<BankReferenceVO>();
		ResultSet resultSet = null;
		StringBuffer strQuery = null;
		PreparedStatement prepStat = null;
		
		try {
			//TODO: Checar el datasource para esta consulta
			getConnect(DAOConstants.WP_FACBGH_JDNI);
			LOGGER.info("Recuperamos la conexion: " + connection);
			
			strQuery = new StringBuffer();
			
			strQuery.append("SELECT TAB2.TIMM_CUSTOMER_ID, ");
			strQuery.append("TAB2.FECHA_INGRESO, ");
			strQuery.append("BNK.DESCRIPCION_BANCO AS BANCO, ");
			strQuery.append("BNK.CONTRATO, ");
			strQuery.append("DECODE (UPPER (BNK.DESCRIPCION_BANCO), ");
			strQuery.append("   'BANAMEX', TAB2.BASE_97, ");
			strQuery.append("   TAB2.BASE_10) ");
			strQuery.append(" AS REFERENCIA, ");
			strQuery.append(" BNK.ORDEN ");
			strQuery.append(" FROM FACBGH.CAT_BANCOS BNK, ");
			strQuery.append("   (SELECT TIMM_CUSTOMER_ID, ");
			strQuery.append("           FECHA_INGRESO, ");
			strQuery.append("           BASE_97, ");
			strQuery.append("           BASE_10 ");
			strQuery.append("    FROM FACBGH.REFERENCIAS_BANCARIAS ");
			strQuery.append("    WHERE TIMM_CUSTOMER_ID = ? ");
			strQuery.append("    AND ROWNUM < 2) TAB2 ");
			strQuery.append("ORDER BY BNK.ORDEN ASC ");

			prepStat = connection.prepareStatement( strQuery.toString() );
			LOGGER.info("Ejecutando query::::::::: " + strQuery.toString() );
			prepStat.setLong(1,bankReferenceVO.getTimCustomerId());
			resultSet = prepStat.executeQuery();//EJECUCION DEL QUERY

			while ( resultSet.next() ){
				final BankReferenceVO itemBankReferenceVO = new BankReferenceVO();
				itemBankReferenceVO.setBanco(resultSet.getString("BANCO"));
				itemBankReferenceVO.setContrato(resultSet.getString("CONTRATO"));
				itemBankReferenceVO.setFechaIngreso(resultSet.getString("FECHA_INGRESO"));
				itemBankReferenceVO.setOrden(resultSet.getInt("ORDEN"));
				itemBankReferenceVO.setReferencia(resultSet.getString("REFERENCIA"));
				itemBankReferenceVO.setTimCustomerId(resultSet.getLong("TIMM_CUSTOMER_ID"));
				listBankReferenceVO.add(itemBankReferenceVO);
			}
			LOGGER.info("Referencias Bancarias: " + listBankReferenceVO.size() + " para el responsable de pago: " + bankReferenceVO.getTimCustomerId());
			
		} catch (SQLException e) {
			LOGGER.error("Ocurrio un error al tratar de ejecutar la consulta sql");
			LOGGER.error("Error SQLException en el metodo getBankReference: ",e);
		} catch (NamingException e) {
			LOGGER.error("Ocurrio un error al tratar de obtener el DataSource");
			LOGGER.error("Error NamingException en el metodo getBankReference: ",e);
		}
		finally{
			DAOConstants.closeResultSet(resultSet);
			DAOConstants.closePreparedStatement(prepStat);
			DAOConstants.closeConnection(connection);
		}
		
		return listBankReferenceVO.toArray(new BankReferenceVO[listBankReferenceVO.size()]);
	}

}
