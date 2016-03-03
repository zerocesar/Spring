package mx.com.att.vo.gpay;

import java.io.Serializable;

public class ClienteVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String token;
	
	private String apMaterno;

    private String apPaterno;

    private String correo;

    private String nombres;

    private String telefono;
    
    private String cuenta;
	
	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(final String cuenta) {
		this.cuenta = cuenta;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(final String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(final String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(final String correo) {
		this.correo = correo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(final String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	public String getToken() {
		return token;
	}

	public void setToken(final String token) {
		this.token = token;
	}
}