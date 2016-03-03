package mx.com.att.vo.orange;

import java.io.Serializable;

public class AttachFileVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private byte[] arregloArchivo; 
	private String nombreArchivo;
	
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public byte[] getArregloArchivo() {
		return arregloArchivo;
	}
	public void setArregloArchivo(byte[] arregloArchivo) {
		this.arregloArchivo = arregloArchivo;
	}
}
