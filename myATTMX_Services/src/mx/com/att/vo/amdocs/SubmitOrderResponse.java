package mx.com.att.vo.amdocs;

public class SubmitOrderResponse {
	
	private LinkVO[] link;
	private FailedOrder[] FailedOrder;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public FailedOrder[] getFailedOrder() {
		return FailedOrder;
	}
	public void setFailedOrder(FailedOrder[] failedOrder) {
		FailedOrder = failedOrder;
	}

	
	
}
