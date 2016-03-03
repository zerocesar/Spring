package mx.com.att.vo.orange;

import java.io.Serializable;

public class MailVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String[] direccionDestino;
	private String direccionOrigen;
	private String[] direccionesCC;
	private FormatoMensajeVO formMsj;
	private AttachFileVO[] archivosAdjuntos;
	
	public String getDireccionOrigen() {
		return direccionOrigen;
	}
	public void setDireccionOrigen(String direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}
	public String[] getDireccionesCC() {
		return direccionesCC;
	}
	public void setDireccionesCC(String[] direccionesCC) {
		this.direccionesCC = direccionesCC;
	}
	public FormatoMensajeVO getFormMsj() {
		return formMsj;
	}
	public void setFormMsj(FormatoMensajeVO formMsj) {
		this.formMsj = formMsj;
	}
	public String[] getDireccionDestino() {
		return direccionDestino;
	}
	public void setDireccionDestino(String[] direccionDestino) {
		this.direccionDestino = direccionDestino;
	}
	public AttachFileVO[] getArchivosAdjuntos() {
		return archivosAdjuntos;
	}
	public void setArchivosAdjuntos(AttachFileVO[] archivosAdjuntos) {
		this.archivosAdjuntos = archivosAdjuntos;
	}

}
