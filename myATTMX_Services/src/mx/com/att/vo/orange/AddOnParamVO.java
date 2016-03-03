package mx.com.att.vo.orange;

import java.io.Serializable;

public class AddOnParamVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String tipo;
	private String valor;
	
	public int getId() {
		return id;
	}
	public void setId(final int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(final String valor) {
		this.valor = valor;
	}

}
