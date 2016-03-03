package mx.com.att.vo.red;

public class DatosFocalizacionUsuario {

	private String compania;
	private DatosLogin datosUsuario;
	private ObtenerDescripcionPlanesVO1 datosPlan;
	private DatosFocalizacion datosFocalizacion;
	private DatosFocalizacionFocaVO datosFocalizacionUsuario;
	public DatosLogin getDatosUsuario() {
		return datosUsuario;
	}
	public void setDatosUsuario(DatosLogin datosUsuario) {
		this.datosUsuario = datosUsuario;
	}
	public ObtenerDescripcionPlanesVO1 getDatosPlan() {
		return datosPlan;
	}
	public void setDatosPlan(ObtenerDescripcionPlanesVO1 datosPlan) {
		this.datosPlan = datosPlan;
	}
	
	
	
	
	public void setDatosFocalizacion(DatosFocalizacion datosFocalizacion) {
		this.datosFocalizacion = datosFocalizacion;
	}
	public DatosFocalizacion getDatosFocalizacion() {
		return datosFocalizacion;
	}
	public void setDatosFocalizacionUsuario(DatosFocalizacionFocaVO datosFocalizacionUsuario) {
		this.datosFocalizacionUsuario = datosFocalizacionUsuario;
	}
	public DatosFocalizacionFocaVO getDatosFocalizacionUsuario() {
		return datosFocalizacionUsuario;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
}
