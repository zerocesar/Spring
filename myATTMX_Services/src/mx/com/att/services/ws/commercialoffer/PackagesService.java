package mx.com.att.services.ws.commercialoffer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.EstadoCuentaVO;

@WebService(name="PackagesService",
targetNamespace="http://www.att.com.mx/att/services/ws/commercialoffer/packagesService")
public interface PackagesService {
	
	String RETURN = "return";
	String ESTADOCUENTAVO = "estadoCuentaVO";
	String DATOSCUENTAVO = "datosCuentaVO";
	String JSON = "billingBalanceJson";
	
	@WebMethod(operationName="activateFixpackMobile")
	@WebResult(name = RETURN)
	String activateFixpackMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="activateFixpack")
	@WebResult(name = RETURN)
	ResponseVO activateFixpack(@WebParam(name = ESTADOCUENTAVO) EstadoCuentaVO requestVO);
	
	@WebMethod(operationName="getOrderDetailMobile")
	@WebResult(name = RETURN)
	String getOrderDetailMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getOrderDetail")
	@WebResult(name = RETURN)
	ResponseVO getOrderDetail(@WebParam(name = ESTADOCUENTAVO) EstadoCuentaVO requestVO);
	
	@WebMethod(operationName="getPacksDetailMobile")
	@WebResult(name = RETURN)
	String getPacksDetailMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getPacksDetail")
	@WebResult(name = RETURN)
	ResponseVO getPacksDetail(@WebParam(name = ESTADOCUENTAVO) EstadoCuentaVO requestVO);
	
	@WebMethod(operationName="getPrePlanPackagesMobile")
	@WebResult(name = RETURN)
	String getPrePlanPackagesMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getPrePlanPackages")
	@WebResult(name = RETURN)
	ResponseVO getPrePlanPackages(@WebParam(name = ESTADOCUENTAVO) EstadoCuentaVO requestVO);
	
	@WebMethod(operationName="getTransactionStatusMobile")
	@WebResult(name = RETURN)
	String getTransactionStatusMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getTransactionStatus")
	@WebResult(name = RETURN)
	ResponseVO getTransactionStatus(@WebParam(name = ESTADOCUENTAVO) EstadoCuentaVO requestVO);
	
}
