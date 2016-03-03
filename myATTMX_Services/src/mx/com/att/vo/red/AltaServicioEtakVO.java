package mx.com.att.vo.red;

public class AltaServicioEtakVO {

	private String costo;
	private String id;
	private String idHistorico;
	private String vigencia;
	private String monto;
	public String getCosto() {
		return costo;
	}
	public void setCosto(final String costo) {
		this.costo = costo;
	}
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(final String monto) {
		this.monto = monto;
	}
	public void setIdHistorico(final String idHistorico) {
		this.idHistorico = idHistorico;
	}
	public String getIdHistorico() {
		return idHistorico;
	}
	public void setVigencia(final String vigencia) {
		this.vigencia = vigencia;
	}
	public String getVigencia() {
		return vigencia;
	}
}
