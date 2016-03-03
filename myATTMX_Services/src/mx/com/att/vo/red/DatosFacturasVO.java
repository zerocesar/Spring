package mx.com.att.vo.red;

import java.util.List;

public class DatosFacturasVO {
	
	private List<DatosUltimasFacturasVO> facturas;
	private String saldoPendienteDePago;
	public List<DatosUltimasFacturasVO> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<DatosUltimasFacturasVO> facturas) {
		this.facturas = facturas;
	}
	public void setSaldoPendienteDePago(String saldoPendienteDePago) {
		this.saldoPendienteDePago = saldoPendienteDePago;
	}
	public String getSaldoPendienteDePago() {
		return saldoPendienteDePago;
	}
}
