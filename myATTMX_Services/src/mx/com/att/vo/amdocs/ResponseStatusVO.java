package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ResponseStatusVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public LinkVO[] Link;
	public boolean Status;
	public String RejectCode;
	public String RejectDescription;
	
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(LinkVO[] link) {
		Link = link;
	}
	public boolean getStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public String getRejectCode() {
		return RejectCode;
	}
	public void setRejectCode(String rejectCode) {
		RejectCode = rejectCode;
	}
	public String getRejectDescription() {
		return RejectDescription;
	}
	public void setRejectDescription(String rejectDescription) {
		RejectDescription = rejectDescription;
	}

}