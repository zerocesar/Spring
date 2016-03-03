package mx.com.att.vo.amdocs;

public class GetLastInvoiceInfo {
	
	private DocListInfo[] DocListInfo;	
	private CycleControlInfo[] cycleControlInfo;
	
	public DocListInfo[] getDocListInfo() {
		return DocListInfo;
	}
	public void setDocListInfo(final DocListInfo[] docListInfo) {
		DocListInfo = docListInfo;
	}
	public CycleControlInfo[] getCycleControlInfo() {
		return cycleControlInfo;
	}
	public void setCycleControlInfo(final CycleControlInfo[] cycleControlInfo) {
		this.cycleControlInfo = cycleControlInfo;
	}	
}
