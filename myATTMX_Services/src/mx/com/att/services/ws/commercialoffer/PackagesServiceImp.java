package mx.com.att.services.ws.commercialoffer;

import javax.jws.WebService;

import mx.com.att.business.PackagesBusiness;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.orange.EstadoCuentaVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

@WebService(portName="PackagesServicePort",
serviceName="PackagesService",
targetNamespace="http://www.att.com.mx/att/services/ws/commercialoffer/packagesService",
endpointInterface="mx.com.att.services.ws.commercialoffer.PackagesService")
public class PackagesServiceImp implements PackagesService {
	
	private static final Logger LOGGER = Logger.getLogger(PackagesServiceImp.class);
	
	@Override
	public String activateFixpackMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo activateFixpackMobile de la clase PackagesServiceImp");
		
		final PackagesBusiness packagesBusiness = new PackagesBusiness();
		
		return packagesBusiness.activateFixpack(cadenaJson);
	}

	@Override
	public ResponseVO activateFixpack(EstadoCuentaVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo activateFixpack de la clase PackagesServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = activateFixpackMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getOrderDetailMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getOrderDetailMobile de la clase PackagesServiceImp");
		
		final PackagesBusiness packagesBusiness = new PackagesBusiness();
		
		return packagesBusiness.getOrderDetail(cadenaJson);
	}

	@Override
	public ResponseVO getOrderDetail(EstadoCuentaVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getOrderDetail de la clase PackagesServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getOrderDetailMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getPacksDetailMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPacksDetailMobile de la clase PackagesServiceImp");
		
		final PackagesBusiness packagesBusiness = new PackagesBusiness();
		
		return packagesBusiness.getPacksDetail(cadenaJson);
	}

	@Override
	public ResponseVO getPacksDetail(EstadoCuentaVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getPacksDetail de la clase PackagesServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getPacksDetailMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getPrePlanPackagesMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPrePlanPackagesMobile de la clase PackagesServiceImp");
		
		final PackagesBusiness packagesBusiness = new PackagesBusiness();
		
		return packagesBusiness.getPrePlanPackages(cadenaJson);
	}

	@Override
	public ResponseVO getPrePlanPackages(EstadoCuentaVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getPrePlanPackages de la clase PackagesServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getPrePlanPackagesMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
	
	@Override
	public String getTransactionStatusMobile(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getTransactionStatusMobile de la clase PackagesServiceImp");
		
		final PackagesBusiness packagesBusiness = new PackagesBusiness();
		
		return packagesBusiness.getTransactionStatus(cadenaJson);
	}

	@Override
	public ResponseVO getTransactionStatus(EstadoCuentaVO requestVO) {
		LOGGER.info("Comienza la ejecucion del metodo getTransactionStatus de la clase PackagesServiceImp");
		
		final String request = new Gson().toJson(requestVO);
		final String response = getTransactionStatusMobile(request);
		
		return new Gson().fromJson(response, ResponseVO.class);
	}
}