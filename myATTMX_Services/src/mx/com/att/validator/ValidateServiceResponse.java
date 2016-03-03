package mx.com.att.validator;

import mx.com.att.utils.ATTConstants;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.SupportVO;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class ValidateServiceResponse {

	private static final Logger LOGGER = Logger.getLogger(ValidateServiceResponse.class);
	
	public String validateSuccess(final int codigo){
		final StringBuffer response = new StringBuffer();
		
		if (codigo == ATTConstants.EXITO_1){
			response.append(ATTConstants.DES_EXITO);
		}else if (codigo == ATTConstants.EXITO_200){
			response.append(ATTConstants.DES_EXITO_200);
		}else if (codigo == ATTConstants.EXITO_202){
			response.append(ATTConstants.DES_EXITO_202);
		}else if (codigo == ATTConstants.EXITO_203){
			response.append(ATTConstants.DES_EXITO_203);
		}else if (codigo == ATTConstants.EXITO_204){
			response.append(ATTConstants.DES_EXITO_204);
		}
		
		return response.toString();
	}
	
	public void validate000Errors(final Object object, final ResponseVO responseVO, final String principal, final String metodo, final int codigo) throws ValidateException{
		
		if (codigo == ATTConstants.COD_ERR_0 || codigo == ATTConstants.COD_ERR_1){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERROR_REG);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERROR_REG + ATTConstants.DES_ERROR_LOG + principal);
		}
	}
	
	public void validate400Errors(final Object object, final ResponseVO responseVO, final String principal, final String metodo, final int codigo) throws ValidateException{
		
		if (codigo == ATTConstants.COD_ERR_400){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_400);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_400 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_401){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_401);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_401 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_402){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_402);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_402 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_403){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_403);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_403 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_404){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_404);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_404 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_405){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_405);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_405 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_406){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_406);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_406 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_500){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_500);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_500 + ATTConstants.DES_ERROR_LOG + principal);
		}
	}
	
	public void validate500Errors(final Object object, final ResponseVO responseVO, final String principal, final String metodo, final int codigo) throws ValidateException{
		
		if (codigo == ATTConstants.COD_ERR_500){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_500);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_500 + ATTConstants.DES_ERROR_LOG + principal);
		}
	}
	
	public void validate600Errors(final Object object, final ResponseVO responseVO, final String principal, final String metodo, final int codigo) throws ValidateException{
		
		if (codigo == ATTConstants.COD_ERR_601){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_601);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_601 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_602){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_602);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_602 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_603){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_603);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_603 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_604){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_604);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_604 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_605){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_605);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_605 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_606){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_606);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_606 + ATTConstants.DES_ERROR_LOG + principal);
		} else if (codigo == ATTConstants.COD_ERR_607){
			responseVO.setCode(ATTConstants.COD_ERROR);
    		responseVO.setMessageCode(ATTConstants.DESC_ERR_607);
    		responseVO.setObjectResponse(null);
    		throw new ValidateException(ATTConstants.DESC_ERR_607 + ATTConstants.DES_ERROR_LOG + principal);
		}
	}

	public int validateResponseNull(final Object object, final ResponseVO responseVO, final String principal, final String metodo) throws ValidateException{
		LOGGER.info("Validando respuesta obtenida de los servicios...");
		
		if (object == null){
			responseVO.setCode(ATTConstants.COD_ERROR);
			responseVO.setMessageCode(ATTConstants.DES_SIS_NO_DISP);
			responseVO.setObjectResponse(null);
			throw new ValidateException("El servicio OnlinePaymentService." + metodo + " no regreso datos.");
		}
		
		final String responseJSON = new Gson().toJson(object);
		final SupportVO supportVO = new Gson().fromJson(responseJSON, SupportVO.class);
		LOGGER.info("El DN: " + principal + " respondio con codigo: " + supportVO.getCode() + ", respuesta del Servicio: " + responseJSON);
		
		return supportVO.getCode();
	}
}