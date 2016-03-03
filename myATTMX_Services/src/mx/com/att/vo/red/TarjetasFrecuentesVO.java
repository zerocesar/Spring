package mx.com.att.vo.red;

public class TarjetasFrecuentesVO {

	private String numeroTarjeta;
	private String mesVencimiento;
	private String anioVencimiento;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String cp;
	private String ultimosDigitos;
	private int marcaTarjetaId;
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getMesVencimiento() {
		return mesVencimiento;
	}
	public void setMesVencimiento(String mesVencimiento) {
		this.mesVencimiento = mesVencimiento;
	}
	public String getAnioVencimiento() {
		return anioVencimiento;
	}
	public void setAnioVencimiento(String anioVencimiento) {
		this.anioVencimiento = anioVencimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getUltimosDigitos() {
		return ultimosDigitos;
	}
	public void setUltimosDigitos(String ultimosDigitos) {
		this.ultimosDigitos = ultimosDigitos;
	}
	public void setMarcaTarjetaId(int marcaTarjetaId) {
		this.marcaTarjetaId = marcaTarjetaId;
	}
	public int getMarcaTarjetaId() {
		return marcaTarjetaId;
	}
}
