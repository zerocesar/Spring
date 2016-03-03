package mx.com.att.business;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import mx.com.att.utils.ATTConstants;
import mx.com.att.utils.LogInObjectsContents;
import mx.com.att.utils.SetObjectsAmdocs;
import mx.com.att.validator.ValidateException;
import mx.com.att.validator.ValidatorATT;
 import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.amdocs.Product;
import mx.com.att.vo.amdocs.Products;
import mx.com.att.vo.amdocs.RequestCallDetailsVO;
import mx.com.att.vo.amdocs.RequestProductsVO;
import mx.com.att.vo.amdocs.RequestProductsVOBis;
import mx.com.att.vo.amdocs.ResponseCallDetailsVO;

public class ProductsBussiness
{
    private static final Logger LOGGER = Logger.getLogger(LoginBusiness.class);
    private static final ValidatorATT VALIDATOR = new ValidatorATT();
    private static final LogInObjectsContents PRINTLOGOBJECT = new LogInObjectsContents();

    public String getUnbilledCallDetailsAMDOCS(final String cadenaJSON)
    {
        final String jsonRequest = VALIDATOR.validateRequestString(cadenaJSON);
        LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
        
        final ResponseVO responseVO = new ResponseVO();
        RequestCallDetailsVO requestVO = new Gson().fromJson(jsonRequest, RequestCallDetailsVO.class);
        
        try
        {
            VALIDATOR.validateEmptyLong(requestVO.getCustomerId()  ,"CustomerId"  );
            VALIDATOR.validateEmptyLong(requestVO.getSubscriberId(),"SubscriberId");
            VALIDATOR.validateEmptyLong(requestVO.getPageSize()    ,"PageSize"    );
            VALIDATOR.validateEmptyLong(requestVO.getPageNumber()  ,"PageNumber"  );
            VALIDATOR.validateEmptyString(requestVO.getExternalStructureInfo()  ,"externalStructureInfo"  );
            
            ResponseCallDetailsVO responseTMP = SetObjectsAmdocs.getUnbilledCallDetailsAMDOCS();
            
            PRINTLOGOBJECT.logObject(responseTMP, "RESPONSE"); 

            responseVO.setCode(ATTConstants.CODIGO_EXITO);
            responseVO.setMessageCode(ATTConstants.DESC_EXITO);
            responseVO.setObjectResponse(responseTMP);
        }
        catch (ValidateException validateException)
        {
            responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
            responseVO.setMessageCode(validateException.getMessage());
            LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
        }    
        catch (Exception exception)
        {
            responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
            responseVO.setMessageCode(exception.getMessage());
            LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
        }    
        
        return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
    }
    
    public String getProductsAMDOCS(final String cadenaJSON)
    {
        final String jsonRequest = VALIDATOR.validateRequestString(cadenaJSON);
        LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
        
        final ResponseVO responseVO = new ResponseVO();
        RequestProductsVO requestVO = new Gson().fromJson(jsonRequest, RequestProductsVO.class);
        
        try
        {
            VALIDATOR.validateEmptyString(requestVO.getId()  ,"id" );
            
            Products Link = SetObjectsAmdocs.getProducts();
            
            PRINTLOGOBJECT.logObject(Link, "RESPONSE"); 
            
            responseVO.setCode(ATTConstants.CODIGO_EXITO);
            responseVO.setMessageCode(ATTConstants.DESC_EXITO);
            responseVO.setObjectResponse(Link);
        }
        catch (ValidateException validateException)
        {
            responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
            responseVO.setMessageCode(validateException.getMessage());
            LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
        }    
        catch (Exception exception)
        {
            responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
            responseVO.setMessageCode(exception.getMessage());
            LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
        }
        
        return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
    }
    
    public String getProductsDetailsAMDOCS(final String cadenaJSON)
    {
        final String jsonRequest = VALIDATOR.validateRequestString(cadenaJSON);
        LOGGER.info(ATTConstants.CAD_JSON_ENT +  jsonRequest);
        
        final ResponseVO responseVO = new ResponseVO();
        
        try
        {
            RequestProductsVOBis requestVO = new Gson().fromJson(jsonRequest, RequestProductsVOBis.class);
            Product responseTMP = SetObjectsAmdocs.getProduct();
            
            PRINTLOGOBJECT.logObject(responseTMP, "RESPONSE"); 
            
            responseVO.setCode(ATTConstants.CODIGO_EXITO);
            responseVO.setMessageCode(ATTConstants.DESC_EXITO);
            responseVO.setObjectResponse(responseTMP);
        }
        catch (Exception exception)
        {
            responseVO.setCode(ATTConstants.CODIGO_ERROR_NUM_INV);
            responseVO.setMessageCode(exception.getMessage());
            LOGGER.error("Cadena JSON de salida: " + new Gson().toJson(responseVO));
        }
        
        return VALIDATOR.validateResponseString(new Gson().toJson(responseVO));
    }
}
