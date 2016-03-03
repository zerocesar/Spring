package mx.com.att.vo.red;

import java.util.List;

public class CatalogoMovilCaeVO {
	
	private int version;
	private List<CatalogoCaeGeneralVO> detalleCatalogoCaeGeneral;	
	
	public int getVersion() {
		return version;
	}
	public void setVersion(final int version) {
		this.version = version;
	}
	public List<CatalogoCaeGeneralVO> getDetalleCatalogoCaeGeneral() {
		return detalleCatalogoCaeGeneral;
	}
	public void setDetalleCatalogoCaeGeneral(
			final List<CatalogoCaeGeneralVO> detalleCatalogoCaeGeneral) {
		this.detalleCatalogoCaeGeneral = detalleCatalogoCaeGeneral;
	}

}
