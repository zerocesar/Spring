package mx.com.att.services.ws.billinginfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.DatosCuentaVO;
import mx.com.att.vo.orange.EstadoCuentaVO;

@WebService(name="BillingBalanceService",
targetNamespace="http://www.att.com.mx/att/services/ws/billinginfo/billingBalanceService")
public interface BillingBalanceService {

	String RETURN = "return";
	String ESTADOCUENTAVO = "estadoCuentaVO";
	String DATOSCUENTAVO = "datosCuentaVO";
	String JSON = "billingBalanceJson";
	
	@WebMethod(operationName="getAcountChargeMobile")
	@WebResult(name = RETURN)
	String getAcountChargeMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getAcountCharge")
	@WebResult(name = RETURN)
	ResponseVO getAcountCharge(@WebParam(name = ESTADOCUENTAVO) EstadoCuentaVO requestVO);
	
	@WebMethod(operationName="getEquipmentChargeMobile")
	@WebResult(name = RETURN)
	String getEquipmentChargeMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getEquipmentCharge")
	@WebResult(name = RETURN)
	ResponseVO getEquipmentCharge(@WebParam(name = ESTADOCUENTAVO) EstadoCuentaVO requestVO);
	
	@WebMethod(operationName="getEquipmentChargeDetailMobile")
	@WebResult(name = RETURN)
	String getEquipmentChargeDetailMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getEquipmentChargeDetail")
	@WebResult(name = RETURN)
	ResponseVO getEquipmentChargeDetail(@WebParam(name = ESTADOCUENTAVO) EstadoCuentaVO requestVO);
	
	@WebMethod(operationName="getBillAccountMobile")
	@WebResult(name = RETURN)
	String getBillAccountMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getBillAccount")
	@WebResult(name = RETURN)
	ResponseVO getBillAccount(@WebParam(name = DATOSCUENTAVO) DatosCuentaVO requestVO);
	
	@WebMethod(operationName="getItemsMobile")
	@WebResult(name = RETURN)
	String getItemsMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getItems")
	@WebResult(name = RETURN)
	ResponseVO getItems(@WebParam(name = ESTADOCUENTAVO) EstadoCuentaVO requestVO);
}
