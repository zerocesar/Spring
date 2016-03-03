package mx.com.att.services.ws.amdoc;

import javax.jws.WebService;
import org.apache.log4j.Logger;

import mx.com.att.business.BillingBalanceAmdocsBusiness;
import mx.com.att.business.LoginServiceAmdocs;
import mx.com.att.business.ProductsBussiness;
import mx.com.att.business.PocketsAccountBusiness;

@WebService(portName="AmdocServicePort", 
serviceName="AmdocService", 
targetNamespace="http://www.att.com.mx/att/services/ws/amdoc/amdocService", 
endpointInterface="mx.com.att.services.ws.amdoc.AmdocService")

public class AmdocServiceImp implements AmdocService {

	private static final Logger LOGGER = Logger.getLogger(AmdocServiceImp.class);

	@Override
	public String getCustomerFromDnMobileAMDOCS(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getCustomerFromDnMobileAMDOCS de la clase AmdocServiceImp");

		final LoginServiceAmdocs loginBusiness = new LoginServiceAmdocs();

		return loginBusiness.getCustomerFromDnMobileAMDOCS(cadenaJson);
	}

	@Override
	public String validateLoginMobileAMDOCS(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo validateLoginMobileAMDOCS de la clase AmdocServiceImp");

		final LoginServiceAmdocs loginBusiness = new LoginServiceAmdocs();

		return loginBusiness.validateLoginMobileAMDOCS(cadenaJson);
	}

@Override
    public String getUnbilledCallDetailsAMDOCS(String cadenaJson)
    {
        LOGGER.info("Comienza la ejecucion del metodo getUnbilledCallDetailsAMDOCS de la clase LoginServiceImp");
        
        final ProductsBussiness productsBussiness = new ProductsBussiness();
        
        return productsBussiness.getUnbilledCallDetailsAMDOCS(cadenaJson);
    }
    
    @Override
    public String getProductsAMDOCS(String cadenaJson)
    {
        LOGGER.info("Comienza la ejecucion del metodo getProductsAMDOCS de la clase LoginServiceImp");
        
        final ProductsBussiness productsBussiness = new ProductsBussiness();
        
        return productsBussiness.getProductsAMDOCS(cadenaJson);
    }
    
    @Override
    public String getProductsDetailsAMDOCS(String cadenaJson)
    {
        LOGGER.info("Comienza la ejecucion del metodo getProductsDetailsAMDOCS de la clase LoginServiceImp");
        
        final ProductsBussiness productsBussiness = new ProductsBussiness();
        
        return productsBussiness.getProductsDetailsAMDOCS(cadenaJson);
    }
	
	public String getPocketsLimitMobileAMDOCS(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getPocketsLimitMobileAMDOCS de la clase PocketsAccountBusiness");
		
		final PocketsAccountBusiness pocketsAccountsBussines = new PocketsAccountBusiness();
		
		return pocketsAccountsBussines.getPocketsLimitMobileAMDOCS(cadenaJson);
	}

	@Override
	public String getAccountBalanceMobileAMDOCS(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getAccountBalanceMobileAMDOCS de la clase PocketsAccountBusiness");
		
		final PocketsAccountBusiness pocketsAccountsBussines = new PocketsAccountBusiness();
		
		return pocketsAccountsBussines.getAccountBalanceMobileAMDOCS(cadenaJson);
	}

	@Override
	public String getAccountContractsBrothersDNMobileAMDOCS(String cadenaJson) {
		LOGGER.info("Comienza la ejecucion del metodo getAccountContractsBrothersDNMobileAMDOCS de la clase PocketsAccountBusiness");
		
		final PocketsAccountBusiness pocketsAccountsBussines = new PocketsAccountBusiness();
		
		return pocketsAccountsBussines.getAccountContractsBrothersDNMobileAMDOCS(cadenaJson);
	}
	
	@Override
	public String getAvailableActionsAMDOCS(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getAvailableActionsAMDOCS de la clase AmdocServiceImp");

		final BillingBalanceAmdocsBusiness loginBusiness = new BillingBalanceAmdocsBusiness();

		return loginBusiness.getAvailableActions(cadenaJson);
	}
	
	@Override
	public String getAvailableProductsAMDOCS(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getAvailableProductsAMDOCS de la clase AmdocServiceImp");

		final BillingBalanceAmdocsBusiness loginBusiness = new BillingBalanceAmdocsBusiness();

		return loginBusiness.getAvailableProducts(cadenaJson);
	}
	
	@Override
	public String setConfigurationAMDOCS(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo setConfigurationAMDOCS de la clase AmdocServiceImp");

		final BillingBalanceAmdocsBusiness loginBusiness = new BillingBalanceAmdocsBusiness();

		return loginBusiness.setConfiguration(cadenaJson);
	}
	
	@Override
	public String getLastInvoiceAMDOCS(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getLastInvoiceAMDOCS de la clase AmdocServiceImp");

		final BillingBalanceAmdocsBusiness loginBusiness = new BillingBalanceAmdocsBusiness();

		return loginBusiness.getLastInvoice(cadenaJson);
	}
	
	@Override
	public String getLastTotalBillAMDOCS(String cadenaJson){
		LOGGER.info("Comienza la ejecucion del metodo getLastTotalBillAMDOCS de la clase AmdocServiceImp");

		final BillingBalanceAmdocsBusiness loginBusiness = new BillingBalanceAmdocsBusiness();

		return loginBusiness.getLastTotalBill(cadenaJson);
	}
}