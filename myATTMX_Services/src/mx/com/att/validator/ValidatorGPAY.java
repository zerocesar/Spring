package mx.com.att.validator;

import mx.com.att.utils.ATTConstants;
import mx.com.att.vo.ResponseVO;
import mx.com.att.vo.gpay.BankTransResWPVO;
import mx.com.att.vo.orange.ServiceOrderWPVO;
import mx.com.nextel.pggpay.ops.service.impl.PagoLineaResponse;
import mx.com.nextel.portal.constants.OrderStatus;

public class ValidatorGPAY {
	
	public void validateVO(final Object object, final String nombreObj) throws ValidateException{
		if (object == null){
			throw new ValidateException(ATTConstants.EL_OBJETO + nombreObj + ATTConstants.VACIO_O_NULO);
		}
	}
	
	public Boolean isNotEmpty(final String cadena){
		final Boolean isNotEmpty;
		if (cadena == null || cadena.trim().equalsIgnoreCase("")){
			isNotEmpty = false;
		} else{
			isNotEmpty = true;
		}
		
		return isNotEmpty;
	}
	
	public void validateAttrString(final Object object, final String atributo) throws ValidateException{
		if (object instanceof String){
			if (((String)object).trim().equalsIgnoreCase(ATTConstants.VACIO)){
				throw new ValidateException(ATTConstants.EL_ATRIBUTO + atributo + ATTConstants.VACIO_O_NULO);
			}
		}else{
			throw new ValidateException(ATTConstants.EL_ATRIBUTO + atributo + ATTConstants.VACIO_O_NULO);
		}
	}
	
	public void validateAttrInteger(final Object object, final String atributo) throws ValidateException{
		final Integer compare = 1;
		if (object instanceof Integer){
			if (((Integer)object) < compare){
				throw new ValidateException(ATTConstants.EL_ATRIBUTO + atributo + ATTConstants.MENOR_A_UNO);
			}
		}else{
			throw new ValidateException(ATTConstants.EL_ATRIBUTO + atributo + ATTConstants.MENOR_A_UNO);
		}
	}
	
	public void validateAttrFloat(final Object object, final String atributo) throws ValidateException{
		final Float compare = 0f;
		if (object instanceof Float){
			if (((Float)object) < compare){
				throw new ValidateException(ATTConstants.EL_ATRIBUTO + atributo + ATTConstants.MENOR_A_CERO);
			}
		}else{
			throw new ValidateException(ATTConstants.EL_ATRIBUTO + atributo + ATTConstants.MENOR_A_CERO);
		}
	}
	
	public String validateCredencialApp(final String principalApp) throws ValidateException{
		String password = null;
		
		if (principalApp.equalsIgnoreCase("MVL")){
			password = ATTConstants.MVL;
		} else if (principalApp.equalsIgnoreCase("IOS")){
			password = ATTConstants.IOS;
		} else if (principalApp.equalsIgnoreCase("WPN")){
			password = ATTConstants.WPN;
		} else {
			throw new ValidateException("El atributo principalApp es un sistema no valido: " + principalApp);
		}
		
		return password;
	}
	
	public String validateServiceResponse(final Object object, final ResponseVO responseVO, final String principal, final String metodo) throws ValidateException{
		final ValidateServiceResponse validateSR = new ValidateServiceResponse(); 
		final int codigo = validateSR.validateResponseNull(object, responseVO, principal, metodo);
		
		validateSR.validate000Errors(object, responseVO, principal, metodo, codigo);
		validateSR.validate400Errors(object, responseVO, principal, metodo, codigo);
		validateSR.validate500Errors(object, responseVO, principal, metodo, codigo);
		validateSR.validate600Errors(object, responseVO, principal, metodo, codigo);
		
		return validateSR.validateSuccess(codigo);
	}
	
	public String validateServiceResponse(final PagoLineaResponse object, final ResponseVO responseVO, final String principal, final String referencia, final String metodo, final BankTransResWPVO bankTransResWPVO, final ServiceOrderWPVO serviceOrderWPVO) throws ValidateException{
		final ValidateServiceResponse validateSR = new ValidateServiceResponse(); 
		final int codigo = validateSR.validateResponseNull(object, responseVO, principal, metodo);
		
		bankTransResWPVO.setOrderId(Long.parseLong(referencia.substring(3, 12)));
		serviceOrderWPVO.setOrderId(Long.parseLong(referencia.substring(3, 12)));
		bankTransResWPVO.setTxnResponseCode(Integer.toString(object.getCode()));
		if (object.getData() == null || object.getData().length <= 0 || object.getData(0).getRef() == null || object.getData(0).getRef().trim().equals("")){
			bankTransResWPVO.setAuthorizeId("");
			serviceOrderWPVO.setOrderStatusId(OrderStatus.REJECTED_BY_BANK);
		} else{
			bankTransResWPVO.setAuthorizeId(object.getData(0).getRef());
			serviceOrderWPVO.setOrderStatusId(OrderStatus.APROVED_BY_BANK);
		}
		bankTransResWPVO.setMessage(object.getMessage());
		
		validateSR.validate000Errors(object, responseVO, principal, metodo, codigo);
		validateSR.validate400Errors(object, responseVO, principal, metodo, codigo);
		validateSR.validate500Errors(object, responseVO, principal, metodo, codigo);
		validateSR.validate600Errors(object, responseVO, principal, metodo, codigo);
		
		return validateSR.validateSuccess(codigo);
	}
}