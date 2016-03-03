package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class VerifyInvoiceZipCode implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean isValid;

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	

}