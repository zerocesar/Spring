package mx.com.att.vo.amdocs;

public class ActivityChargeDisplay {
	private LinkVO[]	link;
	private String	activityChargeID;
	private ActivityCharge	activityCharge;
	private OneTimeCalculatedPrice	oneTimeCalculatedPrice;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getActivityChargeID() {
		return activityChargeID;
	}
	public final void setActivityChargeID(final String activityChargeID) {
		this.activityChargeID = activityChargeID;
	}
	public final ActivityCharge getActivityCharge() {
		return activityCharge;
	}
	public final void setActivityCharge(final ActivityCharge activityCharge) {
		this.activityCharge = activityCharge;
	}
	public final OneTimeCalculatedPrice getOneTimeCalculatedPrice() {
		return oneTimeCalculatedPrice;
	}
	public final void setOneTimeCalculatedPrice(final 
			OneTimeCalculatedPrice oneTimeCalculatedPrice) {
		this.oneTimeCalculatedPrice = oneTimeCalculatedPrice;
	}

}
