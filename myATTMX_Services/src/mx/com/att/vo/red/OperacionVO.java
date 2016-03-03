package mx.com.att.vo.red;

public class OperacionVO {

	private String user;
	private String token;
	private String telefono;	
	private String login;
	private String servicioId;
	private TarjetaVO datosTarjeta;
	private AltaServicioLegacyVO datosAltaServicio;
	private AltaServicioEtakVO datosAltaServicioEtak;
	private AltaServicioPrepagoLegacyVO datosAltaServicioPrepago;
	private AbonoVO datosAbono;
	private String dispositivo;
	private String compania; 
	private String sistemaOrigen;
	private String nombre; 	
	private CardVO card;
	private String tipoPlataforma;
	private int canal;
	private int idAplicacion;
	private int version;
	
	public String getUser() {
		return user;
	}
	public void setUser(final String user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(final String token) {
		this.token = token;
	}
	public TarjetaVO getDatosTarjeta() {
		return datosTarjeta;
	}
	public void setDatosTarjeta(final TarjetaVO datosTarjeta) {
		this.datosTarjeta = datosTarjeta;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public AltaServicioLegacyVO getDatosAltaServicio() {
		return datosAltaServicio;
	}
	public void setDatosAltaServicio(AltaServicioLegacyVO datosAltaServicio) {
		this.datosAltaServicio = datosAltaServicio;
	}
	public String getServicioId() {
		return servicioId;
	}
	public void setServicioId(String servicioId) {
		this.servicioId = servicioId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public AbonoVO getDatosAbono() {
		return datosAbono;
	}
	public void setDatosAbono(AbonoVO datosAbono) {
		this.datosAbono = datosAbono;
	}
	public String getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}
	public AltaServicioEtakVO getDatosAltaServicioEtak() {
		return datosAltaServicioEtak;
	}
	public void setDatosAltaServicioEtak(AltaServicioEtakVO datosAltaServicioEtak) {
		this.datosAltaServicioEtak = datosAltaServicioEtak;
	}
	public AltaServicioPrepagoLegacyVO getDatosAltaServicioPrepago() {
		return datosAltaServicioPrepago;
	}
	public void setDatosAltaServicioPrepago(
			AltaServicioPrepagoLegacyVO datosAltaServicioPrepago) {
		this.datosAltaServicioPrepago = datosAltaServicioPrepago;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public String getSistemaOrigen() {
		return sistemaOrigen;
	}
	public void setSistemaOrigen(String sistemaOrigen) {
		this.sistemaOrigen = sistemaOrigen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public CardVO getCard() {
		return card;
	}
	public void setCard(CardVO card) {
		this.card = card;
	}
	public String getTipoPlataforma() {
		return tipoPlataforma;
	}
	public void setTipoPlataforma(String tipoPlataforma) {
		this.tipoPlataforma = tipoPlataforma;
	}
	public int getCanal() {
		return canal;
	}
	public void setCanal(int canal) {
		this.canal = canal;
	}
	public int getIdAplicacion() {
		return idAplicacion;
	}
	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

}
