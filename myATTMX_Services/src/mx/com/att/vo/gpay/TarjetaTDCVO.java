package mx.com.att.vo.gpay;

import java.io.Serializable;

public class TarjetaTDCVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String credencial;

	private String credencialApp;

	private String principal;

	private String principalApp;

	private String checksum;
	
	private Boolean status;
	
	private TarjetaVO[] data;
	
	private String causa;

    private String idTarjeta;
	
	private String codigo;

    private String numero;

    private String tarjetaHabiente;

    private String tipo;

    private String vigencia;
    
    private String nip;

    public String getNip() {
		return nip;
	}

	public void setNip(final String nip) {
		this.nip = nip;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(final Boolean status) {
		this.status = status;
	}

	public TarjetaVO[] getData() {
		TarjetaVO[] data;
		if( this.data == null){
			data = new TarjetaVO[0];
		} else{
			data = (TarjetaVO[])this.data.clone();
		}
		return data;
	}

	public void setData(final TarjetaVO[] data) {
		this.data = (TarjetaVO[])data.clone();
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(final String causa) {
		this.causa = causa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	public String getTarjetaHabiente() {
		return tarjetaHabiente;
	}

	public void setTarjetaHabiente(final String tarjetaHabiente) {
		this.tarjetaHabiente = tarjetaHabiente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(final String vigencia) {
		this.vigencia = vigencia;
	}

	public String getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(final String idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
}