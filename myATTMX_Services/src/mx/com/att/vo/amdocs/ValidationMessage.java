package mx.com.att.vo.amdocs;

public class ValidationMessage {
	
	private LinkVO[] link;
	public String serviceID;
	//public MessageSeverity severity;
	public String text;
	
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(final String serviceID) {
		this.serviceID = serviceID;
	}
	/*
	public MessageSeverity getSeverity() {
		return severity;
	}
	public void setSeverity(final MessageSeverity severity) {
		this.severity = severity;
	}
	*/
	public String getText() {
		return text;
	}
	public void setText(final String text) {
		this.text = text;
	}
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(LinkVO[] link) {
		this.link = link;
	}

	

}
