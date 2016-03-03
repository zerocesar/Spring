package mx.com.att.vo.amdocs;

public class TVPackage {
	
	private LinkVO[] link;
	private String catalogItemDescription;
	private String catalogItemID;
	private String catalogItemImages;
	private String catalogItemName;
	private String id;
	private String status;
	private OnetimeCharge onetimeCharge;
	private CatalogItemCharacteristic[] summary;
	private ConfigurationParameter[] parameters;
	private CatalogItemCharacteristicGroup[] detailsGroups;
	private RecurringCharge[] recurringCharge;
	private Attachment[] attachments;
	private CatalogItemCharacteristic[] overview;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getCatalogItemDescription() {
		return catalogItemDescription;
	}
	public void setCatalogItemDescription(String catalogItemDescription) {
		this.catalogItemDescription = catalogItemDescription;
	}
	public String getCatalogItemID() {
		return catalogItemID;
	}
	public void setCatalogItemID(String catalogItemID) {
		this.catalogItemID = catalogItemID;
	}
	public String getCatalogItemImages() {
		return catalogItemImages;
	}
	public void setCatalogItemImages(String catalogItemImages) {
		this.catalogItemImages = catalogItemImages;
	}
	public String getCatalogItemName() {
		return catalogItemName;
	}
	public void setCatalogItemName(String catalogItemName) {
		this.catalogItemName = catalogItemName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OnetimeCharge getOnetimeCharge() {
		return onetimeCharge;
	}
	public void setOnetimeCharge(OnetimeCharge onetimeCharge) {
		this.onetimeCharge = onetimeCharge;
	}
	public CatalogItemCharacteristic[] getSummary() {
		return summary;
	}
	public void setSummary(CatalogItemCharacteristic[] summary) {
		this.summary = summary;
	}
	public ConfigurationParameter[] getParameters() {
		return parameters;
	}
	public void setParameters(ConfigurationParameter[] parameters) {
		this.parameters = parameters;
	}
	public CatalogItemCharacteristicGroup[] getDetailsGroups() {
		return detailsGroups;
	}
	public void setDetailsGroups(CatalogItemCharacteristicGroup[] detailsGroups) {
		this.detailsGroups = detailsGroups;
	}
	public RecurringCharge[] getRecurringCharge() {
		return recurringCharge;
	}
	public void setRecurringCharge(RecurringCharge[] recurringCharge) {
		this.recurringCharge = recurringCharge;
	}
	public Attachment[] getAttachments() {
		return attachments;
	}
	public void setAttachments(Attachment[] attachments) {
		this.attachments = attachments;
	}
	public CatalogItemCharacteristic[] getOverview() {
		return overview;
	}
	public void setOverview(CatalogItemCharacteristic[] overview) {
		this.overview = overview;
	}
	
	
	
}
