package mx.com.att.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import mx.com.att.resources.ATTServiceLocator;
import mx.com.att.vo.ContractVO;
import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.DeviceVO;
import mx.com.att.vo.PaymentRespVO;

public class LoginDAOImpl implements LoginDAO {

	private static final Logger LOGGER = Logger.getLogger( LoginDAOImpl.class );
	private Connection connection = null;
	
	public void getConnect(final String dataSource) throws SQLException, NamingException {
		connection = ATTServiceLocator.getInstance().getDataSource(dataSource).getConnection();	
	}
	
	@Override
	public CustomerVO getCustomerInfo(final String telephoneNum) {
		LOGGER.info("Iniciando el metodo getCustomerInfo de la clase LoginDAOImpl");
		ResultSet resultSet = null;
		PreparedStatement prepStat = null;
		CustomerVO customerVO = new CustomerVO();
		
		try{
			getConnect(DAOConstants.WP_BSCS_JDNI);
			LOGGER.info("Obtenemos la conexion " + connection);
			
			final StringBuffer strQuery = new StringBuffer();

			strQuery.append("SELECT dn.DN_NUM telefono, contrato.CO_ID CO_ID, ");
			strQuery.append("		(SELECT CUSTOMER_ID ");
			strQuery.append("		FROM customer_all ");
			strQuery.append("		WHERE PAYMNTRESP = 'X' ");
			strQuery.append("		START WITH CUSTOMER_ID = contrato.CUSTOMER_ID ");
			strQuery.append("		CONNECT BY PRIOR CUSTOMER_ID_high = CUSTOMER_ID AND ROWNUM < 2) AS CUSTOMER_ID, ");
			strQuery.append("		contacto.ccfname nombre, contacto.CCLNAME apellidos, contrato.subm_id, ");
			strQuery.append(" 		contrato.tmcode, contacto.area_id, ");
			strQuery.append("		(SELECT AREA_DESC ");
			strQuery.append("		FROM AREA ");
			strQuery.append("		WHERE area.area_id = contacto.area_id) area, ");
			strQuery.append("		(SELECT PLANES.DES PLANDESC ");
			strQuery.append("		FROM MPUTMTAB PLANES ");
			strQuery.append("		WHERE PLANES.TMCODE = CONTRATO.TMCODE ");
			strQuery.append("		AND PLANES.VSCODE = (SELECT MAX (MP.VSCODE)FROM MPUTMTAB MP WHERE MP.TMCODE = CONTRATO.TMCODE)) DES_TMCODE, ");
			strQuery.append("		DECODE (contacto.area_id,25, 'Baja',26, 'Baja',27, 'Baja',28, 'Baja','Mexico') REGION, ");
			strQuery.append("		(SELECT CASE ATS_PREPAID_IND ");
			strQuery.append("			WHEN 'N' THEN 1 ");
			strQuery.append("			WHEN 'M' THEN (SELECT DECODE (COUNT (1), 0, 2, 1) FROM MPULKTMB WHERE TMCODE = contrato.tmcode AND SNCODE = 1289) ");
			strQuery.append("			WHEN 'P' THEN 3 END ");
			strQuery.append("		FROM RATEPLAN ");
			strQuery.append("		WHERE TMCODE = contrato.tmcode) TIPO, ");
			strQuery.append("		(SELECT custcode ");
			strQuery.append("		FROM customer_all ");
			strQuery.append("		WHERE PAYMNTRESP = 'X' ");
			strQuery.append("		START WITH CUSTOMER_ID = contrato.CUSTOMER_ID ");
			strQuery.append("		CONNECT BY PRIOR CUSTOMER_ID_high = CUSTOMER_ID AND ROWNUM < 2) AS CUSTCODE, ");
			strQuery.append("		(SELECT DN.DN_NUM ");
			strQuery.append("		FROM CONTRACT_ALL CO, CONTR_SERVICES_CAP CO_SERV, DIRECTORY_NUMBER DN ");
			strQuery.append("		WHERE CO.CO_ID = contrato.CO_ID ");
			strQuery.append("		AND co.CUSTOMER_ID = contrato.CUSTOMER_ID ");
			strQuery.append("		AND CO.CO_ID = CO_SERV.CO_ID ");
			strQuery.append("		AND CO_SERV.CS_DEACTIV_DATE IS NULL ");
			strQuery.append("		AND DN.DN_ID = CO_SERV.DN_ID ");
			strQuery.append("		AND CO_SERV.SNCODE IN (1022, 30, 1302) ");
			strQuery.append("		AND ROWNUM < 2) RADIO, ");
			strQuery.append("		(SELECT equipType.DESCRIPTION ");
			strQuery.append("		FROM CONTR_DEVICES contrDev, EQUIPMENT equip, EQUIPMENT_TYPE equipType ");
			strQuery.append("		WHERE contrDev.CO_ID = contrato.CO_ID ");
			strQuery.append("		AND contrDev.cd_deactiv_date IS NULL ");
			strQuery.append("		AND equip.EQUIPMENT_ID = contrDev.EQ_ID ");
			strQuery.append("		AND equipType.EQUIPMENT_TYPE_ID = equip.EQUIPMENT_TYPE_ID) AS EQUIPO, ");
			strQuery.append("		BCD.last_run_date - 1 AS NEXT_BILL_CYCLE, BCD.BCH_RUN_DATE AS BCH_RUN_DATE, iva.DES_IVA, ");
			strQuery.append("		(SELECT PRGCODE ");
			strQuery.append("		FROM CUSTOMER_ALL ");
			strQuery.append("		WHERE CUSTOMER_ID = contrato.CUSTOMER_ID) AS PRGCODE, ");
			strQuery.append("		DECODE (contrato.ch_status,  'a', 2,  's', 3,  'd', 4,  1) AS CO_STATUS, ");
			strQuery.append("		(SELECT cohist.ch_reason ");
			strQuery.append("		FROM contract_history cohist ");
			strQuery.append("		WHERE cohist.CO_ID = contrato.CO_ID ");
			strQuery.append("		AND cohist.ch_seqno = (SELECT MAX (cohist2.ch_seqno) ");
			strQuery.append("								FROM contract_history cohist2 ");
			strQuery.append("								WHERE cohist2.ch_pending IS NULL ");
			strQuery.append("								AND cohist2.CO_ID = cohist.CO_ID)) AS CO_REASON_CODE ");
			strQuery.append("FROM contr_services_cap cs, directory_number dn, contract_all contrato, ");
			strQuery.append("	  ccontact_all contacto, BILLCYCLE_ASSIGNMENT_HISTORY BAH, BILLCYCLE_DEFINITION BCD, ");
			strQuery.append("	  (SELECT a.AREA_ID, a.CUSTOMERCAT_CODE, b.DESCRIPTION DES_IVA ");
			strQuery.append("	  FROM CUSTOMERCATCODE_AREA a, CUSTOMERCATCODE b ");
			strQuery.append("	  WHERE a.CUSTOMERCAT_CODE = b.CUSTOMERCAT_CODE) iva ");
			strQuery.append("WHERE dn.dn_num = ? ");
			strQuery.append("AND contacto.CUSTOMER_ID = contrato.CUSTOMER_ID ");
			strQuery.append("AND cs.seqno = (SELECT MAX (seqno) FROM contr_services_cap WHERE CO_ID = cs.CO_ID AND (sncode IN (1, 1001))) ");
			strQuery.append("AND contacto.ccseq = (SELECT ccseq FROM contract_contact WHERE CUSTOMER_ID = contacto.CUSTOMER_ID AND CO_ID = cs.CO_ID) ");
			strQuery.append("AND contrato.CO_ID = cs.CO_ID ");
			strQuery.append("AND cs.dn_id = dn.dn_id ");
			strQuery.append("AND cs.CS_DEACTIV_DATE IS NULL ");
			strQuery.append("AND contacto.area_id = iva.area_id ");
			strQuery.append("AND (cs.sncode IN (1, 1001)) ");
			strQuery.append("AND BAH.CUSTOMER_ID = contrato.CUSTOMER_ID ");
			strQuery.append("AND BAH.SEQNO = (SELECT MAX (SEQNO) FROM BILLCYCLE_ASSIGNMENT_HISTORY WHERE CUSTOMER_ID = BAH.CUSTOMER_ID AND VALID_FROM <= SYSDATE) ");
			strQuery.append("AND BAH.BILLCYCLE = BCD.BILLCYCLE ");
			strQuery.append("AND BCD.APPROVED_IND = 'X' ");
			
			LOGGER.info("Ejecutando query::::::::: " + strQuery.toString() );
			prepStat = connection.prepareStatement( strQuery.toString() );
			
			prepStat.setString(1, telephoneNum);
			resultSet = prepStat.executeQuery();//EJECUCION DEL QUERY
			
			if ( resultSet.next() ){
				LOGGER.info("Se encontro informacion relacionada al numero: " + telephoneNum);
				customerVO.setArea(resultSet.getString("AREA"));
				customerVO.setAreaId(resultSet.getInt("AREA_ID"));
				customerVO.setLastName(resultSet.getString("APELLIDOS"));
				customerVO.setName(resultSet.getString("NOMBRE"));
				customerVO.setRegion(resultSet.getString("REGION"));
				customerVO.setUser(resultSet.getString("TELEFONO"));
				
				final PaymentRespVO paymentRespVO = new PaymentRespVO();
				paymentRespVO.setCustomerCode(resultSet.getString("CUSTCODE"));
				paymentRespVO.setCustomerId(resultSet.getLong("CUSTOMER_ID"));
				
				final ContractVO contractVO = new ContractVO();
				contractVO.setContractId(resultSet.getLong("CO_ID"));
				contractVO.setContractTypeId(resultSet.getString("TIPO"));
				contractVO.setIvaDesc(resultSet.getString("DES_IVA"));
				
				final Calendar calendar = Calendar.getInstance();
				calendar.setTime(resultSet.getDate("NEXT_BILL_CYCLE"));
				contractVO.setNextBillCycle(calendar);
				final Calendar calendarBchRunDate = Calendar.getInstance();
				calendarBchRunDate.setTime(resultSet.getDate("BCH_RUN_DATE"));
				contractVO.setBchRunDate(calendarBchRunDate);
				contractVO.setSellChannelId(resultSet.getString("PRGCODE"));
				contractVO.setStatusId(resultSet.getString("CO_STATUS"));
				contractVO.setSuspensionId(resultSet.getString("CO_REASON_CODE"));
				contractVO.setTechnologyId(resultSet.getInt("SUBM_ID"));
				contractVO.setTmcode(resultSet.getLong("TMCODE"));
				contractVO.setTmcodeDesc(resultSet.getString("DES_TMCODE"));
				
				final DeviceVO deviceVO = new DeviceVO();
				deviceVO.setEquipmentDesc(resultSet.getString("EQUIPO"));
				deviceVO.setRadioId(resultSet.getString("RADIO"));
				deviceVO.setTelephoneNum(resultSet.getString("TELEFONO"));
				
				contractVO.setDeviceVO(deviceVO);
				customerVO.setContractVO(contractVO);
				customerVO.setPaymentRespVO(paymentRespVO);
				
			} else{
				LOGGER.info("No se encontro informacion relacionada con el numero: " + telephoneNum);
				customerVO = null;
			}
		} catch (SQLException sqlException) {
			LOGGER.error("Ocurrio un error al tratar de ejecutar la consulta sql");
			LOGGER.error("Error SQLException en el metodo getCustomerInfo: ", sqlException);
		} catch (NamingException namingException) {
			LOGGER.error("Ocurrio un error al tratar de obtener el DataSource");
			LOGGER.error("Error NamingException en el metodo getCustomerInfo: ", namingException);
		} finally{
			DAOConstants.closeResultSet(resultSet);
			DAOConstants.closePreparedStatement(prepStat);
			DAOConstants.closeConnection(connection);
		}
		return customerVO;
	}

	@Override
	public int deleteUserLdap(String telephoneNum) {
		LOGGER.info("Iniciando el metodo deleteUserLdap de la clase LoginDAOImpl");
		int resultSet = 0;
		PreparedStatement prepStat = null;
		
		try{
			getConnect(DAOConstants.WP_LDAP_JDNI);
			LOGGER.info("Obtenemos la conexion " + connection);
			
			final StringBuffer strQuery = new StringBuffer();

			strQuery.append("DELETE LDAP_USERS WHERE USERID = ? ");
			
			LOGGER.info("Ejecutando query::::::::: " + strQuery.toString() );
			prepStat = connection.prepareStatement( strQuery.toString() );
			
			prepStat.setString(1, telephoneNum);
			resultSet = prepStat.executeUpdate();//EJECUCION DEL QUERY

		} catch (SQLException sqlException) {
			LOGGER.error("Ocurrio un error al tratar de ejecutar la consulta sql");
			LOGGER.error("Error SQLException en el metodo getCustomerInfo: ", sqlException);
		} catch (NamingException namingException) {
			LOGGER.error("Ocurrio un error al tratar de obtener el DataSource");
			LOGGER.error("Error NamingException en el metodo getCustomerInfo: ", namingException);
		} finally{
			DAOConstants.closePreparedStatement(prepStat);
			DAOConstants.closeConnection(connection);
		}
		return resultSet;
	}

	@Override
	public String getDecriptedPassword(String telephoneNum) {
		LOGGER.info("Iniciando el metodo getDecriptedPassword de la clase LoginDAOImpl");
		ResultSet resultSet = null;
		PreparedStatement prepStat = null;
		String password = null;
		
		try{
			getConnect(DAOConstants.WP_LDAP_JDNI);
			LOGGER.info("Obtenemos la conexion " + connection);
			
			final StringBuffer strQuery = new StringBuffer();

			strQuery.append("SELECT USER_PASSWORD FROM LDAP_USERS WHERE USERID = ? ");
			
			LOGGER.info("Ejecutando query::::::::: " + strQuery.toString() );
			prepStat = connection.prepareStatement( strQuery.toString() );
			
			prepStat.setString(1, telephoneNum);
			resultSet = prepStat.executeQuery();//EJECUCION DEL QUERY
			
			if ( resultSet.next() ){
				LOGGER.info("Se encontro informacion relacionada al numero: " + telephoneNum);
				password = resultSet.getString("USER_PASSWORD");
			} else{
				LOGGER.info("No se encontro informacion relacionada con el numero: " + telephoneNum);
			}
		} catch (SQLException sqlException) {
			LOGGER.error("Ocurrio un error al tratar de ejecutar la consulta sql");
			LOGGER.error("Error SQLException en el metodo getCustomerInfo: ", sqlException);
		} catch (NamingException namingException) {
			LOGGER.error("Ocurrio un error al tratar de obtener el DataSource");
			LOGGER.error("Error NamingException en el metodo getCustomerInfo: ", namingException);
		} finally{
			DAOConstants.closeResultSet(resultSet);
			DAOConstants.closePreparedStatement(prepStat);
			DAOConstants.closeConnection(connection);
		}
		return password;
	}
}