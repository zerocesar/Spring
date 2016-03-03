package mx.com.att.vo.red;

import java.util.List;

public class WalletsDetalleVO {
	
	private List<ConsumoFechaTablaVO> detalleConsumo;
	private String isPostPagoHibrido;
	public List<ConsumoFechaTablaVO> getDetalleConsumo() {
		return detalleConsumo;
	}
	public void setDetalleConsumo(List<ConsumoFechaTablaVO> detalleConsumo) {
		this.detalleConsumo = detalleConsumo;
	}
	public String getIsPostPagoHibrido() {
		return isPostPagoHibrido;
	}
	public void setIsPostPagoHibrido(String isPostPagoHibrido) {
		this.isPostPagoHibrido = isPostPagoHibrido;
	}
}
