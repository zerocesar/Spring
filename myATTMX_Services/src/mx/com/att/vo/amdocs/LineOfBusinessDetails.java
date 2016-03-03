package mx.com.att.vo.amdocs;

public class LineOfBusinessDetails {
	private LinkVO[]	link;
	private String	bigPicture;
	private String	code;
	private String	displayIdentifier;
	private boolean	displaySPOName;
	private String	name;
	private String	plansCategoryStructureID;
	private String	smallPicture;
	private String	smallPicture2;
	private boolean	serviceAbility;
	private boolean	mandatoryConfigurationCheck;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getBigPicture() {
		return bigPicture;
	}
	public final void setBigPicture(final String bigPicture) {
		this.bigPicture = bigPicture;
	}
	public final String getCode() {
		return code;
	}
	public final void setCode(final String code) {
		this.code = code;
	}
	public final String getDisplayIdentifier() {
		return displayIdentifier;
	}
	public final void setDisplayIdentifier(final String displayIdentifier) {
		this.displayIdentifier = displayIdentifier;
	}
	public boolean isDisplaySPOName() {
		return displaySPOName;
	}
	public void setDisplaySPOName(final boolean displaySPOName) {
		this.displaySPOName = displaySPOName;
	}
	public final String getName() {
		return name;
	}
	public final void setName(final String name) {
		this.name = name;
	}
	public final String getPlansCategoryStructureID() {
		return plansCategoryStructureID;
	}
	public final void setPlansCategoryStructureID(final String plansCategoryStructureID) {
		this.plansCategoryStructureID = plansCategoryStructureID;
	}
	public final String getSmallPicture() {
		return smallPicture;
	}
	public final void setSmallPicture(final String smallPicture) {
		this.smallPicture = smallPicture;
	}
	public final String getSmallPicture2() {
		return smallPicture2;
	}
	public final void setSmallPicture2(final String smallPicture2) {
		this.smallPicture2 = smallPicture2;
	}
	public boolean isServiceAbility() {
		return serviceAbility;
	}
	public void setServiceAbility(final boolean serviceAbility) {
		this.serviceAbility = serviceAbility;
	}
	public boolean isMandatoryConfigurationCheck() {
		return mandatoryConfigurationCheck;
	}
	public void setMandatoryConfigurationCheck(final boolean mandatoryConfigurationCheck) {
		this.mandatoryConfigurationCheck = mandatoryConfigurationCheck;
	}

}
