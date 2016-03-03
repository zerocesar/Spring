package mx.com.att.vo.amdocs;

public class ExternalWidget {
	private LinkVO[]	link;
	private String	logicalName;
	private String	physicalName;
	private ExternalWidgetParameters[]	inputParameters;
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getLogicalName() {
		return logicalName;
	}
	public final void setLogicalName(final String logicalName) {
		this.logicalName = logicalName;
	}
	public final String getPhysicalName() {
		return physicalName;
	}
	public final void setPhysicalName(final String physicalName) {
		this.physicalName = physicalName;
	}
	public ExternalWidgetParameters[] getInputParameters() {
		return inputParameters;
	}
	public void setInputParameters(final ExternalWidgetParameters[] inputParameters) {
		this.inputParameters = inputParameters;
	}

}
