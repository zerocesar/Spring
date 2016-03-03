package mx.com.att.vo.orange;

import java.io.Serializable;

public class FormatoMensajeVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id_asunto;
	private String desc_asunto;
	private Object mensaje;
	
	public Long getId_asunto() {
		return id_asunto;
	}
	public void setId_asunto(Long id_asunto) {
		this.id_asunto = id_asunto;
	}
	public String getDesc_asunto() {
		return desc_asunto;
	}
	public void setDesc_asunto(String desc_asunto) {
		this.desc_asunto = desc_asunto;
	}
	public Object getMensaje() {
		return mensaje;
	}
	public void setMensaje(Object mensaje) {
		this.mensaje = mensaje;
	}
}
