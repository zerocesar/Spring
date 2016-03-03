package mx.com.att.vo.red;


import java.util.List;

public class LoginVO {
	
	private DatosFocalizacionUsuario  datosFocalizacionVo;
	private ConsultaOperadorExtendidoVO consultaOperador;				
	private ConfiguracionXUsuarioMovilVO configuracionXUsuario;
	private List<PermisosClienteVO> listPermisosCliente;
	private Navegacion navegacionvo;
	private DetalleTotalesLlamadas totalesLlamadasVo;
	private DatosFacturasVO DatosFacturas;
	
	private Mensajes mensajesVo;
	private String login;
	
	public DatosFocalizacionUsuario getDatosFocalizacionVo() {
		return datosFocalizacionVo;
	}
	public void setDatosFocalizacionVo(DatosFocalizacionUsuario datosFocalizacionVo) {
		this.datosFocalizacionVo = datosFocalizacionVo;
	}
	public ConsultaOperadorExtendidoVO getConsultaOperador() {
		return consultaOperador;
	}
	public void setConsultaOperador(ConsultaOperadorExtendidoVO consultaOperador) {
		this.consultaOperador = consultaOperador;
	}
	public ConfiguracionXUsuarioMovilVO getConfiguracionXUsuario() {
		return configuracionXUsuario;
	}
	public void setConfiguracionXUsuario(
			ConfiguracionXUsuarioMovilVO configuracionXUsuario) {
		this.configuracionXUsuario = configuracionXUsuario;
	}
	public List<PermisosClienteVO> getListPermisosCliente() {
		return listPermisosCliente;
	}
	public void setListPermisosCliente(List<PermisosClienteVO> listPermisosCliente) {
		this.listPermisosCliente = listPermisosCliente;
	}
	public Navegacion getNavegacionvo() {
		return navegacionvo;
	}
	public void setNavegacionvo(Navegacion navegacionvo) {
		this.navegacionvo = navegacionvo;
	}
	public DetalleTotalesLlamadas getTotalesLlamadasVo() {
		return totalesLlamadasVo;
	}
	public void setTotalesLlamadasVo(DetalleTotalesLlamadas totalesLlamadasVo) {
		this.totalesLlamadasVo = totalesLlamadasVo;
	}
	public Mensajes getMensajesVo() {
		return mensajesVo;
	}
	public void setMensajesVo(Mensajes mensajesVo) {
		this.mensajesVo = mensajesVo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public DatosFacturasVO getDatosFacturas() {
		return DatosFacturas;
	}
	public void setDatosFacturas(DatosFacturasVO datosFacturas) {
		DatosFacturas = datosFacturas;
	}

}
