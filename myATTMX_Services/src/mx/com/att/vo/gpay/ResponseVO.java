package mx.com.att.vo.gpay;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ClienteTDCVO.class, PagoTDCVO.class, TarjetaTDCVO.class})
public class ResponseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name="code")
	private String code;
	@XmlElement(name="messageCode")
	private String messageCode;
	@XmlElement(name="objectResponse")
	private Object objectResponse;

	public String getCode() {
		return code;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public Object getObjectResponse() {
		return objectResponse;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public void setMessageCode(final String messageCode) {
		this.messageCode = messageCode;
	}

	public void setObjectResponse(final Object objectResponse) {
		this.objectResponse = objectResponse;
	}
}