package mx.com.att.vo.red;

public class TarjetaVO {
	private int marcaTarjeta; 
	private String numeroTarjeta; 
	private  String mesVencimiento; 
	private String anioVencimiento; 
	private String nombre; 
	private String aPaterno; 
	private String aMaterno; 
	private String cp; 
	private String ultimosDigitos; 
	private String dn; 
	
	public int getMarcaTarjeta() {
		return marcaTarjeta;
	}
	public void setMarcaTarjeta(int marcaTarjeta) {
		this.marcaTarjeta = marcaTarjeta;
	}
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
	public String getaPaterno() {
		return aPaterno;
	}
	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}
	public String getaMaterno() {
		return aMaterno;
	}
	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
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
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
}
