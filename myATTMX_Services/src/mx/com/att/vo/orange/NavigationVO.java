package mx.com.att.vo.orange;

import java.io.Serializable;

public class NavigationVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long loginId;
	private long navigationId;
	private String success;
    private String additionalInfo;
    private long orderId;
    
    public NavigationVO(){
    	
    }

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(final long loginId) {
		this.loginId = loginId;
	}

	public long getNavigationId() {
		return navigationId;
	}

	public void setNavigationId(final long navigationId) {
		this.navigationId = navigationId;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(final String success) {
		this.success = success;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(final String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(final long orderId) {
		this.orderId = orderId;
	}
    
    

}
