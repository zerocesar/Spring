package mx.com.att.vo.orange;

import java.io.Serializable;
import java.util.List;

import mx.com.nextel.www.ws.vo.DetalleCompraServicioVO;


public class HistoricoVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String user_mdn;
	private String fecha_ini;
	private String fecha_fin;
    private int channel_id;
    private String idSistema;
    private List<DetalleRecargaVO> historialRecargas;
    private List<DetalleCompraServicioVO> historialServicios;
    private List<ServiceOrderVO> historicoTransacciones;
    
	public String getUser_mdn() {
		return user_mdn;
	}
	public void setUser_mdn(final String user_mdn) {
		this.user_mdn = user_mdn;
	}
	public String getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(final String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(final String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	public int getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(final int channel_id) {
		this.channel_id = channel_id;
	}
	public String getIdSistema() {
		return idSistema;
	}
	public void setIdSistema(final String idSistema) {
		this.idSistema = idSistema;
	}
	public List<DetalleRecargaVO> getHistorialRecargas() {
		return historialRecargas;
	}
	public void setHistorialRecargas(final List<DetalleRecargaVO> historialRecargas) {
		this.historialRecargas = historialRecargas;
	}
	public List<DetalleCompraServicioVO> getHistorialServicios() {
		return historialServicios;
	}
	public void setHistorialServicios(
			final List<DetalleCompraServicioVO> historialServicios) {
		this.historialServicios = historialServicios;
	}
	public List<ServiceOrderVO> getHistoricoTransacciones() {
		return historicoTransacciones;
	}
	public void setHistoricoTransacciones(final List<ServiceOrderVO> historicoTransacciones) {
		this.historicoTransacciones = historicoTransacciones;
	}
}
