package mx.com.att.vo.red;

public class Navegacion {
	private String totalDatos;
	private String totalCostoDatos;
	private String datosIncluidos;
	private String datosExtra;
	private String navegacionDeRegalo;
	public String getTotalDatos() {
		return totalDatos;
	}
	public void setTotalDatos(String totalDatos) {
		this.totalDatos = totalDatos;
	}
	public String getTotalCostoDatos() {
		return totalCostoDatos;
	}
	public void setTotalCostoDatos(String totalCostoDatos) {
		this.totalCostoDatos = totalCostoDatos;
	}
	public void setNavegacionDeRegalo(String navegacionDeRegalo) {
		this.navegacionDeRegalo = navegacionDeRegalo;
	}
	public String getNavegacionDeRegalo() {
		return navegacionDeRegalo;
	}
	public void setDatosExtra(String datosExtra) {
		this.datosExtra = datosExtra;
	}
	public String getDatosExtra() {
		return datosExtra;
	}
	public void setDatosIncluidos(String datosIncluidos) {
		this.datosIncluidos = datosIncluidos;
	}
	public String getDatosIncluidos() {
		return datosIncluidos;
	}
}
