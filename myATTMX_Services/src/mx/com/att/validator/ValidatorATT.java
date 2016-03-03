package mx.com.att.validator;

import java.rmi.RemoteException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.security.SecurityUtils;

public class ValidatorATT {
	
	public void validateDN10(final String cadena) throws ValidateException{
		if (cadena == null || cadena.trim().equalsIgnoreCase("") || cadena.length() != 10){
			throw new ValidateException("El numero telefonico esta vacio, nulo o no tiene 10 digitos.");
		}
	}
	
	public void validateEmptyString(final String cadena, final String campo) throws ValidateException{
		if (cadena == null || cadena.trim().equalsIgnoreCase("")){
			throw new ValidateException("El campo " + campo + " esta vacio o nulo.");
		}
	}
	
	public boolean validateGetCode(final String cadena, final String codigo) {
		final String string;
		if (cadena == null || cadena.trim().equalsIgnoreCase("")){
			string = "false";
		} else if(cadena.equalsIgnoreCase(codigo)){
			string = "true";
		} else{
			string = "false";
		}
		
		return new Boolean(string);
	}
	
	public void validateEmptyLong(final long cadena, final String campo) throws ValidateException{
		if (cadena <= ATTConstants.VAL_CERO){
			throw new ValidateException("El campo " + campo + " esta vacio o nulo.");
		}
	}
	
	public void validateDN12(final String cadena) throws ValidateException{
		if (cadena == null || cadena.trim().equalsIgnoreCase("") || cadena.length() != 12){
			throw new ValidateException("El numero telefonico esta vacio, nulo o no tiene 12 digitos.");
		}
	}
	
	public String validateRemoteException(final RemoteException remoteException) {
		
		return (remoteException == null) ? ATTConstants.DESC_ERROR_SERVICIO : remoteException.toString();
	}
	
	public String validateRequestString(final String requestString){
		return (ATTConstants.IS_ACTIVE_ENCRYPTION) ? SecurityUtils.getDecrypt(requestString, ATTConstants.ATT) : requestString;
	}
	
	public String validateResponseString(final String responseString){
		return (ATTConstants.IS_ACTIVE_ENCRYPTION) ? SecurityUtils.getCrypt(responseString, ATTConstants.ATT) : responseString;
	}
}