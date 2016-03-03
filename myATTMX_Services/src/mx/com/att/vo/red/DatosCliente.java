package mx.com.att.vo.red;

public class DatosCliente {
	
    private String ApellidoMaterno; //Apellido del cliente
	
	private String ApellidoPaterno; //Apellido del cliente
	
	private String email;           //email del cliente
	
	private String edad;
	
	private String dispositivo;
	
	private String foto;          //imagen personal del cliente
	
	private String FechaNacimiento;
	
	private String paisId;
	
	private String PreguntaSecreta;
	
	private String respuestaSecreta;
	
	private String sexo;
	
	private String sistemaOrigen;
	
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSistemaOrigen() {
		return sistemaOrigen;
	}

	public void setSistemaOrigen(String sistemaOrigen) {
		this.sistemaOrigen = sistemaOrigen;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getUnidadNegocio() {
		return UnidadNegocio;
	}

	public void setUnidadNegocio(String unidadNegocio) {
		UnidadNegocio = unidadNegocio;
	}

	private String tipoCliente;
	
	private String UnidadNegocio;
	
	

	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getPaisId() {
		return paisId;
	}

	public void setPaisId(String paisId) {
		this.paisId = paisId;
	}

	public String getPreguntaSecreta() {
		return PreguntaSecreta;
	}

	public void setPreguntaSecreta(String preguntaSecreta) {
		PreguntaSecreta = preguntaSecreta;
	}

	public String getRespuestaSecreta() {
		return respuestaSecreta;
	}

	public void setRespuestaSecreta(String respuestaSecreta) {
		this.respuestaSecreta = respuestaSecreta;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	
	
}
