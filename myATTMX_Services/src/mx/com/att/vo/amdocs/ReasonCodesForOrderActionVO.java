package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ReasonCodesForOrderActionVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LinkVO Link[];		
	public OrderActionReasonListVO  orderActionReasonList[];
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public OrderActionReasonListVO[] getOrderActionReasonList() {
		return orderActionReasonList;
	}
	public void setOrderActionReasonList(final
			OrderActionReasonListVO[] orderActionReasonList) {
		this.orderActionReasonList = orderActionReasonList;
	}
	
	
	
}