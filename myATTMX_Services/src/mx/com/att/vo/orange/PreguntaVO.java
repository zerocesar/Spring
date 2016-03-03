package mx.com.att.vo.orange;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "preguntaId", "textoPregunta", "esCorrecta",
		"custcode", "tipo" ,"respuestaUs",
	    "customerId"		
})
@XmlRootElement(name = "PreguntaVO")
public class PreguntaVO implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(required = true, type = Long.class, nillable = true)
	private Long preguntaId;
	@XmlElement(required = true, type = String.class, nillable = true)
	private String textoPregunta;
	@XmlElement(required = true, type = Boolean.class, nillable = true)
	private Boolean esCorrecta;
	@XmlElement(required = true, type = String.class, nillable = true)
	private String custcode;
	@XmlElement(required = true, type = String.class, nillable = true)
	private String tipo;
	@XmlElement(required = true, type = String.class, nillable = true)
	private String respuestaUs;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long customerId;

	
	
    public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(final Long customerId) {
		this.customerId = customerId;
	}
	
	public String getRespuestaUs() {
		return respuestaUs;
	}
	public void setRespuestaUs(final String respuestaUs) {
		this.respuestaUs = respuestaUs;
	}
	public Long getPreguntaId() {
		return preguntaId;
	}
	public void setPreguntaId(final Long preguntaId) {
		this.preguntaId = preguntaId;
	}
	public String getTextoPregunta() {
		return textoPregunta;
	}
	public void setTextoPregunta(final String textoPregunta) {
		this.textoPregunta = textoPregunta;
	}
	public Boolean getEsCorrecta() {
		return esCorrecta;
	}
	public void setEsCorrecta(final Boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}
	public String getCustcode() {
		return custcode;
	}
	public void setCustcode(final String custcode) {
		this.custcode = custcode;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}