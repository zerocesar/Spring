package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ReasonListVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LinkVO Link[];	
	public ReasonVO reason;
	public String reasonTextRequired;
	
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		this.Link = link;
	}
	public ReasonVO getReason() {
		return reason;
	}
	public void setReason(final ReasonVO reason) {
		this.reason = reason;
	}
	public String getReasonTextRequired() {
		return reasonTextRequired;
	}
	public void setReasonTextRequired (final String reasonTextRequired) {
		this.reasonTextRequired = reasonTextRequired;
	}
	
	
	
}