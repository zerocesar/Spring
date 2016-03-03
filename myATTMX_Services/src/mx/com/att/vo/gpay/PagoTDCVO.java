package mx.com.att.vo.gpay;

import java.io.Serializable;

public class PagoTDCVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String credencial;

	private String credencialApp;

	private String principal;

	private String principalApp;

	private String checksum;
	
	private Boolean status;

	private PagoVO[] data;
    
    private String referencia;

	private String codigo;

    private String descripcion;

    private String idTarjeta;
    
    private Float monto;
    
    private String nip;
    
    private Integer idServicio;

    public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(final Integer idServicio) {
		this.idServicio = idServicio;
	}

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
	
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(final String referencia) {
		this.referencia = referencia;
	}

	public PagoVO[] getData() {
		PagoVO[] data;
		if( this.data == null){
			data = new PagoVO[0];
		} else{
			data = (PagoVO[])this.data.clone();
		}
		return data;
	}

	public void setData(final PagoVO[] data) {
		this.data = (PagoVO[])data.clone();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(final String idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	
	public Float getMonto() {
		return monto;
	}

	public void setMonto(final Float monto) {
		this.monto = monto;
	}
}