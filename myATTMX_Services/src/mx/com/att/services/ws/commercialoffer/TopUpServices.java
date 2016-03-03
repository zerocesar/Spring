package mx.com.att.services.ws.commercialoffer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mx.com.att.vo.CustomerVO;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.RechargeVO;
import mx.com.att.vo.orange.ValidaMontosVO;

@WebService(name = "TopUpServices", 
targetNamespace = "http://www.att.com.mx/att/services/ws/commercialoffer/topUpServices")
public interface TopUpServices {

	String RETURN = "return";
	String CUSTOMERVO = "customerVO";
	String JSON = "customerJson";
	String VALIDAMONTOSVO = "validaMontosVO";
	String MONTOSJSON = "validaMontosVOJson";
	String RECHARGEJSON = "rechargeVOJson";
	String RECHARGEVO = "rechargeVO";
	
	@WebMethod(operationName="getWebPortalAmountsMobile")
	@WebResult(name = RETURN)
	String getWebPortalAmountsMobile(@WebParam(name = MONTOSJSON) String cadenaJson);

	@WebMethod(operationName="getWebPortalAmounts")
	@WebResult(name = RETURN)
	ResponseVO getWebPortalAmounts(@WebParam(name = VALIDAMONTOSVO) ValidaMontosVO requestVO);
	
	@WebMethod(operationName="getRechargeAmountsMobile")
	@WebResult(name = RETURN)
	String getRechargeAmountsMobile(@WebParam(name = JSON) String cadenaJson);

	@WebMethod(operationName="getRechargeAmounts")
	@WebResult(name = RETURN)
	ResponseVO getRechargeAmounts(@WebParam(name = CUSTOMERVO) CustomerVO requestVO);
	
	@WebMethod(operationName="getServiceCreditMobile")
	@WebResult(name = RETURN)
	String getServiceCreditMobile(@WebParam(name = MONTOSJSON) String cadenaJson);

	@WebMethod(operationName="getServiceCredit")
	@WebResult(name = RETURN)
	ResponseVO getServiceCredit(@WebParam(name = VALIDAMONTOSVO) ValidaMontosVO requestVO);
	
	@WebMethod(operationName="validateDNTopUpMobile")
	@WebResult(name = RETURN)
	String validateDNTopUpMobile(@WebParam(name = RECHARGEJSON) String cadenaJson);

	@WebMethod(operationName="validateDNTopUp")
	@WebResult(name = RETURN)
	ResponseVO validateDNTopUp(@WebParam(name = RECHARGEVO) RechargeVO requestVO);
	
	@WebMethod(operationName="validateDNTransferMobile")
	@WebResult(name = RETURN)
	String validateDNTransferMobile(@WebParam(name = RECHARGEJSON) String cadenaJson);

	@WebMethod(operationName="validateDNTransfer")
	@WebResult(name = RETURN)
	ResponseVO validateDNTransfer(@WebParam(name = RECHARGEVO) CustomerVO requestVO);
	
	@WebMethod(operationName="validateBillByDNMobile")
	@WebResult(name = RETURN)
	String validateBillByDNMobile(@WebParam(name = RECHARGEJSON) String cadenaJson);

	@WebMethod(operationName="validateBillByDN")
	@WebResult(name = RETURN)
	ResponseVO validateBillByDN(@WebParam(name = RECHARGEVO) CustomerVO requestVO);
}