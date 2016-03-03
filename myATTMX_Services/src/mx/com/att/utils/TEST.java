package mx.com.att.utils;

import com.google.gson.Gson;

import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.TestVO;
import mx.com.att.vo.amdocs.ChangeProductSatusInputVO;
import mx.com.att.vo.amdocs.ChangeProductStatusOutputVO;
import mx.com.att.vo.amdocs.ProductDisplay;
import mx.com.att.vo.amdocs.RequestAmdocVO;
import mx.com.att.vo.amdocs.UpdateProdConfigRes;
import mx.com.att.vo.amdocs.UpdateProductConfigReq;
import mx.com.att.vo.amdocs.ValidateNewOfferingConfigurationRequest;
import mx.com.att.vo.amdocs.ValidateNewOfferingConfigurationResponse;
import mx.com.att.vo.amdocs.ValidateProductConfigurationRequest;

public class TEST {

	private static final LogInObjectsContents PRINTLOGOBJECT = new LogInObjectsContents();

	public static void main(String[] args) {
		crearJsonResponse(new UpdateProdConfigRes(), true);
		
//		crearJsonRequest(new UpdateProductConfigReq(), true);
	}	

	public static void crearJsonResponse(Object response, boolean setArrays){
		final ResponseVO responseVO = new ResponseVO();
		
		SetObjectsContents setObject = new SetObjectsContents();		
		setObject.fillObject(response, "", setArrays);

		responseVO.setCode("00");
		responseVO.setMessageCode("Finalizo Correctamente");
		responseVO.setObjectResponse(response);

		System.out.println(new Gson().toJson(responseVO));

		PRINTLOGOBJECT.logObject(response, response.getClass().getSimpleName()); 
	}
	
	public static void crearJsonRequest(Object requestObject, boolean setArrays){
		
		SetObjectsContents setObject = new SetObjectsContents();		
		setObject.fillObject(requestObject, "", setArrays);
		
		PRINTLOGOBJECT.logObject(requestObject, "SetObjectsContents"); 
		
		System.out.println(new Gson().toJson(requestObject));
		
	}

}
