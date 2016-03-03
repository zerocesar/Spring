package mx.com.att.vo.amdocs;

public class BundleSearchResult {
	private LinkVO[]	link;
	
	private String displayName;
	private String lobImage;
	private String offeringName;
	private String planName;
	private String offeringID;
	private String minNumOfSubscribers;
	private String maxNumOfSubscribers;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getLobImage() {
		return lobImage;
	}
	public void setLobImage(String lobImage) {
		this.lobImage = lobImage;
	}
	public String getOfferingName() {
		return offeringName;
	}
	public void setOfferingName(String offeringName) {
		this.offeringName = offeringName;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getOfferingID() {
		return offeringID;
	}
	public void setOfferingID(String offeringID) {
		this.offeringID = offeringID;
	}
	public String getMinNumOfSubscribers() {
		return minNumOfSubscribers;
	}
	public void setMinNumOfSubscribers(String minNumOfSubscribers) {
		this.minNumOfSubscribers = minNumOfSubscribers;
	}
	public String getMaxNumOfSubscribers() {
		return maxNumOfSubscribers;
	}
	public void setMaxNumOfSubscribers(String maxNumOfSubscribers) {
		this.maxNumOfSubscribers = maxNumOfSubscribers;
	}
	
	

}
