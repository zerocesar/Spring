package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ChangeProductStatusOutputVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public LinkVO[] link;
	public ResponseStatusVO responseStatus;
	public String productOrderId;
	
	
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(final LinkVO[] link) {
		this.link = link;
	}
	
	public ResponseStatusVO getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(final ResponseStatusVO responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(final String productOrderId) {
		this.productOrderId = productOrderId;
	}
	
	
	
	
}