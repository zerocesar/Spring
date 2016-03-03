package mx.com.att.vo.red;

public class ServiciosAdicionalesVO {
	private String descripcion;
	private String costo;
	private String idServicio;
	private String imagenB64;
	private String servicio;
	private String version;
	private int status;
	private String mensajeServicios;
	
	
	public String getMensajeServicios() {
		return mensajeServicios;
	}
	public void setMensajeServicios(String mensajeServicios) {
		this.mensajeServicios = mensajeServicios;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getServicio() {
		return servicio;
	}
	public String getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}
	public String getImagenB64() {
		return imagenB64;
	}
	public void setImagenB64(String imagenB64) {
		this.imagenB64 = imagenB64;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	
	
}
