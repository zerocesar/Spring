package mx.com.att.services.ws.billinginfo;

import javax.jws.WebService;

import mx.com.att.business.BillingBalanceBusiness;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.DatosCuentaVO;
import mx.com.att.vo.orange.EstadoCuentaVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

@WebService(portName="BillingBalanceServicePort",
serviceName="BillingBalanceService",
targetNamespace="http://www.att.com.mx/att/services/ws/billinginfo/billingBalanceService",
endpointInterface="mx.com.att.services.ws.billinginfo.BillingBalanceService")
public class BillingBalanceServiceImp implements BillingBalanceService {
	
	private static final Logger LOGGER = Logger.getLogger(BillingBalanceServiceImp.class);
	
	@Override
	public String getAcountChargeMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getAcountChargeMobile de la clase BillingBalanceServiceImp");
		
		final BillingBalanceBusiness billingBalanceBusiness = new BillingBalanceBusiness();
		
		return billingBalanceBusiness.getAcountCharge(cadenaJson);
	}

	@Override
	public ResponseVO getAcountCharge(EstadoCuentaVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getAcountCharge de la clase BillingBalanceServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getAcountChargeMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getEquipmentChargeMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getEquipmentChargeMobile de la clase BillingBalanceServiceImp");
		
		final BillingBalanceBusiness billingBalanceBusiness = new BillingBalanceBusiness();
		
		return billingBalanceBusiness.getEquipmentCharge(cadenaJson);
	}

	@Override
	public ResponseVO getEquipmentCharge(EstadoCuentaVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getEquipmentCharge de la clase BillingBalanceServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getEquipmentChargeMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getEquipmentChargeDetailMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getEquipmentChargeDetailMobile de la clase BillingBalanceServiceImp");
		
		final BillingBalanceBusiness billingBalanceBusiness = new BillingBalanceBusiness();
		
		return billingBalanceBusiness.getEquipmentChargeDetail(cadenaJson);
	}

	@Override
	public ResponseVO getEquipmentChargeDetail(EstadoCuentaVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getEquipmentChargeDetail de la clase BillingBalanceServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getEquipmentChargeDetailMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getBillAccountMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getBillAccountMobile de la clase BillingBalanceServiceImp");
		
		final BillingBalanceBusiness billingBalanceBusiness = new BillingBalanceBusiness();
		
		return billingBalanceBusiness.getBillAccount(cadenaJson);
	}

	@Override
	public ResponseVO getBillAccount(DatosCuentaVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getBillAccount de la clase BillingBalanceServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getBillAccountMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getItemsMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getItemsMobile de la clase BillingBalanceServiceImp");
		
		final BillingBalanceBusiness billingBalanceBusiness = new BillingBalanceBusiness();
		
		return billingBalanceBusiness.getItems(cadenaJson);
	}

	@Override
	public ResponseVO getItems(EstadoCuentaVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getItems de la clase BillingBalanceServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getItemsMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}