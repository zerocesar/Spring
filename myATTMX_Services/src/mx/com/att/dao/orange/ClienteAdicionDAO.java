package mx.com.att.dao.orange;

import java.sql.SQLException;
import java.util.List;

import mx.com.att.vo.orange.CommercialConfigurationVO;
import mx.com.att.vo.orange.OrdenesWPVO;
import mx.com.att.vo.orange.ParamCatalogoVO;
import mx.com.att.vo.orange.ServiceWPVO;

public interface ClienteAdicionDAO {
	
	ParamCatalogoVO getParameter(String param_id);
	
	ParamCatalogoVO getParameterWp(String param_id);
	
	List<ServiceWPVO> getServiciosList(CommercialConfigurationVO conf);
	
	OrdenesWPVO getOrdenesWP(String orderID) throws SQLException;
	
	int getIncidentes(String custCode) throws SQLException;
	
	List<CommercialConfigurationVO> getServicesByChannel(CommercialConfigurationVO commercialConfig);
}