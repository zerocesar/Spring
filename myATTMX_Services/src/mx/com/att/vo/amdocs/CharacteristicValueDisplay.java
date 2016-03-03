package mx.com.att.vo.amdocs;

public class CharacteristicValueDisplay {
	private LinkVO[]	link;
//	private CharacteristicBusinessType	businessType;
	private String	productSpecCharacteristicID;
	private String	value;
	private CharacteristicDisplay	displayInformation;
	private ResourceSpec	resourceSpec;
	private CharacteristicDisplay	originalCatalogDisplayInformation;
	private CharacteristicActionDisplay	actionDisplay;
	private ProductSpecCharacteristic	productSpecCharacteristic;
	private ExternalWidget	externalWidget;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final String getProductSpecCharacteristicID() {
		return productSpecCharacteristicID;
	}
	public final void setProductSpecCharacteristicID(final 
			String productSpecCharacteristicID) {
		this.productSpecCharacteristicID = productSpecCharacteristicID;
	}
	public final String getValue() {
		return value;
	}
	public final void setValue(final String value) {
		this.value = value;
	}
	public final CharacteristicDisplay getDisplayInformation() {
		return displayInformation;
	}
	public final void setDisplayInformation(final CharacteristicDisplay displayInformation) {
		this.displayInformation = displayInformation;
	}
	public final ResourceSpec getResourceSpec() {
		return resourceSpec;
	}
	public final void setResourceSpec(final ResourceSpec resourceSpec) {
		this.resourceSpec = resourceSpec;
	}
	public final CharacteristicDisplay getOriginalCatalogDisplayInformation() {
		return originalCatalogDisplayInformation;
	}
	public final void setOriginalCatalogDisplayInformation(final 
			CharacteristicDisplay originalCatalogDisplayInformation) {
		this.originalCatalogDisplayInformation = originalCatalogDisplayInformation;
	}
	public final CharacteristicActionDisplay getActionDisplay() {
		return actionDisplay;
	}
	public final void setActionDisplay(final CharacteristicActionDisplay actionDisplay) {
		this.actionDisplay = actionDisplay;
	}
	public final ProductSpecCharacteristic getProductSpecCharacteristic() {
		return productSpecCharacteristic;
	}
	public final void setProductSpecCharacteristic(final 
			ProductSpecCharacteristic productSpecCharacteristic) {
		this.productSpecCharacteristic = productSpecCharacteristic;
	}
	public final ExternalWidget getExternalWidget() {
		return externalWidget;
	}
	public final void setExternalWidget(final ExternalWidget externalWidget) {
		this.externalWidget = externalWidget;
	}

}
