package mx.com.att.vo.amdocs;

public class FailedOrder {
	private LinkVO[] link;
	private String ErrorCode;
	private String OrderID;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	
}
