package mx.com.att.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class CryptoHelper {
	
    private static final String SALT = "As4Rh0KbCstRewNaAs4Rh0Kb";
    private static final Logger LOGGER = Logger.getLogger(CryptoHelper.class);
    private static final String ALGORITHM = "DESede";
	/**
	 * Defaults Constructor
	 *
	 */
	private CryptoHelper(){
		
	}

    public static String decrypt(final String text) {
    	String result = null;
    	if (!StringUtils.isEmpty(text)) {
    		try {
            	final SecretKeySpec passwordKey = new SecretKeySpec(SALT.getBytes("UTF-8"), ALGORITHM);
            	final Cipher cipher = Cipher.getInstance(ALGORITHM);
            	final BigInteger Bciph1 = new BigInteger(text);
                cipher.init(Cipher.DECRYPT_MODE, passwordKey);
                result = new String(cipher.doFinal(Bciph1.toByteArray()));
            } catch (NoSuchAlgorithmException e) {
    			LOGGER.error("Error en metodo decrypt: ",e);
    		} catch (NoSuchPaddingException e) {
    			LOGGER.error("Error en metodo decrypt: ",e);
    		} catch (InvalidKeyException e) {
    			LOGGER.error("Error en metodo decrypt: ",e);
    		} catch (IllegalBlockSizeException e) {
    			LOGGER.error("Error en metodo decrypt: ",e);
    		} catch (BadPaddingException e) {
    			LOGGER.error("Error en metodo encrypt: ",e);
    		} catch (UnsupportedEncodingException e) {
    			LOGGER.error("Error en metodo decrypt: ",e);
			}
        }

		return result;
    }

    public static String encrypt(final String text) {
    	String result = null;
    	
    	if (text != null) {
    		try {
    			final SecretKeySpec passwordKey = new SecretKeySpec(SALT.getBytes("UTF-8"), ALGORITHM);
    			final Cipher cipher = Cipher.getInstance(ALGORITHM);
    			cipher.init(Cipher.ENCRYPT_MODE, passwordKey);
    			final byte[] data = text.getBytes();
    			final BigInteger Bciph = new BigInteger(cipher.doFinal(data));
    			result = Bciph.toString();
    		}
            catch (NoSuchAlgorithmException e) {
    			LOGGER.error("Error en metodo encrypt: ",e);
    		} catch (NoSuchPaddingException e) {
    			LOGGER.error("Error en metodo encrypt: ",e);
    		} catch (InvalidKeyException e) {
    			LOGGER.error("Error en metodo encrypt: ",e);
    		} catch (IllegalBlockSizeException e) {
    			LOGGER.error("Error en metodo encrypt: ",e);
    		} catch (BadPaddingException e) {
    			LOGGER.error("Error en metodo encrypt: ",e);
    		} catch (UnsupportedEncodingException e) {
    			LOGGER.error("Error en metodo encrypt: ",e);
			}
        }

        return result;
    }
    
}