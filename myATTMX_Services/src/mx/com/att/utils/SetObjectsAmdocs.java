package mx.com.att.utils;

import mx.com.att.vo.GetBasicCustomerInfo;
import mx.com.att.vo.amdocs.GetLastInvoiceInfo;
import mx.com.att.vo.amdocs.ProductsAvailableActions;
import mx.com.att.vo.amdocs.UpdateProdConfigRes;
import mx.com.att.vo.amdocs.ValidateNewOfferingConfigurationResponse;
import mx.com.att.vo.amdocs.Product;
import mx.com.att.vo.amdocs.Products;
import mx.com.att.vo.amdocs.ResponseCallDetailsVO;
import mx.com.att.vo.amdocs.GetAllowance;
import mx.com.att.vo.amdocs.GetBalance;
import mx.com.att.vo.amdocs.GetNumberOfHandsets;

public class SetObjectsAmdocs {
    
    public static ResponseCallDetailsVO getUnbilledCallDetailsAMDOCS ()
    {
        ResponseCallDetailsVO response = new ResponseCallDetailsVO();
        
        SetObjectsContents setObject = new SetObjectsContents();		
        setObject.fillObject(response, "ResponseCallDetailsVO", true);
        
        return response;
    }

	public static GetBasicCustomerInfo getBasicCustomerInfo ()
	{
		GetBasicCustomerInfo response = new GetBasicCustomerInfo();

		SetObjectsContents setObject = new SetObjectsContents();		
		setObject.fillObject(response, "GetBasicCustomerInfo", false);

		return response;
	}
	
	public static ProductsAvailableActions getAvailableActions()
	{
		ProductsAvailableActions response = new ProductsAvailableActions();
		
		SetObjectsContents setObject = new SetObjectsContents();	
		setObject.fillObject(response,"ProductsAvailableActions", true);
		
		return response;
	}
	
	public static ValidateNewOfferingConfigurationResponse getAvailableProducts()
	{
		ValidateNewOfferingConfigurationResponse response = new ValidateNewOfferingConfigurationResponse();
		
		SetObjectsContents setObject = new SetObjectsContents();	
		setObject.fillObject(response,"ValidateNewOfferingConfigurationResponse", true);
		
		return response;
	}
		
	public static UpdateProdConfigRes setConfiguration()
	{
		UpdateProdConfigRes response = new UpdateProdConfigRes();
		
		SetObjectsContents setObject = new SetObjectsContents();	
		setObject.fillObject(response,"UpdateProdConfigRes", true);
		
		return response;
	}
		
	public static GetLastInvoiceInfo getLastInvoice()
	{
		GetLastInvoiceInfo response = new GetLastInvoiceInfo();
		
		SetObjectsContents setObject = new SetObjectsContents();	
		setObject.fillObject(response,"GetLastInvoiceInfo", true);
		
		return response;
	}
	
		public static Products getProducts()
    {
	    Products response = new Products();

        SetObjectsContents setObject = new SetObjectsContents();        
        setObject.fillObject(response, "Products", true);

        return response;
    }
	
	public static Product getProduct()
	{
	    Product response = new Product();
	    
	    SetObjectsContents setObject = new SetObjectsContents();        
	    setObject.fillObject(response, "Product", true);
	    
	    return response;
	}
	
	public static GetAllowance getAllowenceInfo ()
	{
		GetAllowance response = new GetAllowance();

		SetObjectsContents setObject = new SetObjectsContents();		
		setObject.fillObject(response, "GetAllowance", true);

		return response;
	}
	
	public static GetBalance getBalanceInfo ()
	{
		GetBalance response = new GetBalance();

		SetObjectsContents setObject = new SetObjectsContents();		
		setObject.fillObject(response, "GetBalance", false);

		return response;
	}
	public static GetNumberOfHandsets getNumberOfHandsetsInfo ()
	{
		GetNumberOfHandsets response = new GetNumberOfHandsets();

		SetObjectsContents setObject = new SetObjectsContents();		
		setObject.fillObject(response, "GetNumberOfHandsets", false);

		return response;
	}
}
