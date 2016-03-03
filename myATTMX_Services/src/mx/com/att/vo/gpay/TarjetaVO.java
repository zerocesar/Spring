package mx.com.att.vo.gpay;

import java.io.Serializable;

public class TarjetaVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Boolean defaul;

	private String id; //NOPMD

	private String numero;

    private String tipo;
    
    public String getId() {
		return id;
	}

	public void setId(final String id) { //NOPMD
		this.id = id;
	}

	public Boolean getDefaul() {
		return defaul;
	}

	public void setDefaul(final Boolean defaul) {
		this.defaul = defaul;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}
}