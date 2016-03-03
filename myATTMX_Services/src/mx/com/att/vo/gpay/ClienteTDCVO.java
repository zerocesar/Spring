package mx.com.att.vo.gpay;

import java.io.Serializable;

public class ClienteTDCVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String credencial;

	private String credencialApp;

	private String principal;

	private String principalApp;

	private String checksum;
	
	private Boolean status;

	private ClienteVO[] data;
			
	private String apMaterno;

	private String apPaterno;

	private String correo;

	private String nombres;

	private String telefono;
	
	private String ncredencial;
			
	private String causa;
	
	private String cuenta;

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(final String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCredencial() {
		return credencial;
	}
	
	public void setCredencial(final String credencial) {
		this.credencial = credencial;
	}

	public String getCredencialApp() {
		return credencialApp;
	}

	public void setCredencialApp(final String credencialApp) {
		this.credencialApp = credencialApp;
	}

	public String getNcredencial() {
		return ncredencial;
	}

	public void setNcredencial(final String ncredencial) {
		this.ncredencial = ncredencial;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(final String principal) {
		this.principal = principal;
	}

	public String getPrincipalApp() {
		return principalApp;
	}

	public void setPrincipalApp(final String principalApp) {
		this.principalApp = principalApp;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(final String checksum) {
		this.checksum = checksum;
	}

	public ClienteVO[] getData() {
		ClienteVO[] data;
		if( this.data == null){
			data = new ClienteVO[0];
		} else{
			data = (ClienteVO[])this.data.clone();
		}
		return data;
	}

	public void setData(final ClienteVO[] data) {
		this.data = (ClienteVO[])data.clone();
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

	public String getCausa() {
		return causa;
	}

	public void setCausa(final String causa) {
		this.causa = causa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(final Boolean status) {
		this.status = status;
	}
}