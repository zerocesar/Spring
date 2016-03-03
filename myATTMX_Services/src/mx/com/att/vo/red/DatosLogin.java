package mx.com.att.vo.red;

public class DatosLogin {
	private String 	foto;
	private String 	nombre;
	private String 	apPaterno;
	private String 	apMaterno;
	private String	edad;
	private String	sexo;	
	private String 	correo;	
	private String 	preguntaSecretea;
	private String 	respPreguntaSecreta;
	private String	tipoClienteId;
	private String	fechaNacimiento;
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(final String correo) {
		this.correo = correo;
	}	
	public String getPreguntaSecretea() {
		return preguntaSecretea;
	}
	public void setPreguntaSecretea(final String preguntaSecretea) {
		this.preguntaSecretea = preguntaSecretea;
	}
	public String getRespPreguntaSecreta() {
		return respPreguntaSecreta;
	}
	public void setRespPreguntaSecreta(final String respPreguntaSecreta) {
		this.respPreguntaSecreta = respPreguntaSecreta;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(final String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(final String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(final String foto) {
		this.foto = foto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(final String sexo) {
		this.sexo = sexo;
	}
	
	public void setFechaNacimiento(final String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(final String edad) {
		this.edad = edad;
	}
	public String getTipoClienteId() {
		return tipoClienteId;
	}
	public void setTipoClienteId(final String tipoClienteId) {
		this.tipoClienteId = tipoClienteId;
	}	
}
