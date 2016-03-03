package mx.com.att.services.ws.commercialoffer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.HistoricoVO;
import mx.com.nextel.www.ws.vo.ConsultaCompraServiciosVO;

@WebService(name = "WebPortalServices", 
targetNamespace = "http://www.att.com.mx/att/services/ws/commercialoffer/webPortalServices")
public interface WebPortalServices {

	String RETURN = "return";
	String HISTORICOVOJSON = "historicoVOJson";
	String HISTORICOVO = "historicoVO";
	String CONSULTACOMPRAJSON = "consultaCompraServiciosVOJson";
	String CONSULTACOMPRA = "consultaCompraServiciosVO";
	
	@WebMethod(operationName="getActiveServicesALUMobile")
	@WebResult(name = RETURN)
	String getActiveServicesALUMobile(@WebParam(name = CONSULTACOMPRAJSON) String cadenaJson);

	@WebMethod(operationName="getActiveServicesALU")
	@WebResult(name = RETURN)
	ResponseVO getActiveServicesALU(@WebParam(name = CONSULTACOMPRA) ConsultaCompraServiciosVO requestVO);
	
	@WebMethod(operationName="getTransactionHistoryWPMobile")
	@WebResult(name = RETURN)
	String getTransactionHistoryWPMobile(@WebParam(name = HISTORICOVOJSON) String cadenaJson);

	@WebMethod(operationName="getTransactionHistoryWP")
	@WebResult(name = RETURN)
	ResponseVO getTransactionHistoryWP(@WebParam(name = HISTORICOVO) HistoricoVO requestVO);
	
	@WebMethod(operationName="getTransactionHistoryUnifiedMobile")
	@WebResult(name = RETURN)
	String getTransactionHistoryUnifiedMobile(@WebParam(name = HISTORICOVOJSON) String cadenaJson);

	@WebMethod(operationName="getTransactionHistoryUnified")
	@WebResult(name = RETURN)
	ResponseVO getTransactionHistoryUnified(@WebParam(name = HISTORICOVO) HistoricoVO requestVO);
}