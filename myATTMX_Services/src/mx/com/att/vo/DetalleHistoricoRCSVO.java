package mx.com.att.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;

public class DetalleHistoricoRCSVO implements Serializable, Comparable<DetalleHistoricoRCSVO>{

	private static final long serialVersionUID = 1L;
	
	private Calendar fecha;  //fechaTransaccion;
	private String transaccion;  //descTransaccion;
	private String monto;
	private String orderId;  //folio;
	
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public String getTransaccion() {
		return transaccion;
	}
	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public int compareTo(DetalleHistoricoRCSVO detalleHistoricoRCSVO) {
		
		//DESCENDENTE
		//LOGGER.info("FORMA 1 ["+detalleHistoricoRCSVO.fecha.compareTo(this.fecha)+"]");
		//ACENDENTE
		//LOGGER.info("FORMA 2 ["+this.fecha.compareTo(detalleHistoricoRCSVO.fecha)+"]");
		
		return detalleHistoricoRCSVO.fecha.compareTo(this.fecha);
	}
	
	public static Comparator<DetalleHistoricoRCSVO> DetalleHistoricoRCSVOComparator 
    = new Comparator<DetalleHistoricoRCSVO>() {

		public int compare(DetalleHistoricoRCSVO detalleHistoricoRCS1, DetalleHistoricoRCSVO detalleHistoricoRCS2) {
			return detalleHistoricoRCS1.compareTo(detalleHistoricoRCS2);
			}

	};
}
