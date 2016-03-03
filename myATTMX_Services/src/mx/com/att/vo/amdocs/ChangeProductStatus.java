package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ChangeProductStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String lo;
	public String sc;
	public String externalProductOrderID;
	public String changeStatusCode;
	public ChangeProductSatusInputVO changeProductSatusInput; 
	
	
	public ChangeProductSatusInputVO getChangeProductSatusInput() {
		return changeProductSatusInput;
	}
	public void setChangeProductSatusInput(final 
			ChangeProductSatusInputVO changeProductSatusInput) {
		this.changeProductSatusInput = changeProductSatusInput;
	}
	
	
	public String getLo() {
		return lo;
	}
	public void setLo(final String lo) {
		this.lo = lo;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(final String sc) {
		this.sc = sc;
	}
	public String getExternalProductOrderID() {
		return externalProductOrderID;
	}
	public void setExternalProductOrderID(final String externalProductOrderID) {
		this.externalProductOrderID = externalProductOrderID;
	}
	public String getChangeStatusCode() {
		return changeStatusCode;
	}
	public void setChangeStatusCode(final String changeStatusCode) {
		this.changeStatusCode = changeStatusCode;
	}

	
	
	
	
}