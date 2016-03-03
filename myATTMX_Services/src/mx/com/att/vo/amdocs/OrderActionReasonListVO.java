package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class OrderActionReasonListVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LinkVO Link[];	
	public ReasonListVO reasonList[];
	public String orderItemType;
	
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public ReasonListVO[] getReasonList() {
		return reasonList;
	}
	public void setReasonList(final ReasonListVO[] reasonList) {
		this.reasonList = reasonList;
	}
	
	public String getOrderItemType() {
		return orderItemType;
	}
	public void setOrderItemType(final String orderItemType) {
		this.orderItemType = orderItemType;
	}
	
	
	
	
	
}