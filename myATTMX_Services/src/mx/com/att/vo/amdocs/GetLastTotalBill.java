package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class GetLastTotalBill implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean lastTotalBill;

	public boolean isLastTotalBill() {
		return lastTotalBill;
	}

	public void setLastTotalBill(boolean lastTotalBill) {
		this.lastTotalBill = lastTotalBill;
	}


}