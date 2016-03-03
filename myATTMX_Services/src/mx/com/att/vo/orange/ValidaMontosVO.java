package mx.com.att.vo.orange;

import java.io.Serializable;

public class ValidaMontosVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mdn;
	private String id_estatus;
	private String fecha_inicio;
	private String fecha_fin;
	private String monto;
	

	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getId_estatus() {
		return id_estatus;
	}
	public void setId_estatus(String id_estatus) {
		this.id_estatus = id_estatus;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	
}
