package mx.com.att.vo.orange;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Lista")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="preguntaVO")
	private List<PreguntaVO> preguntaVO;
	@XmlElement(name="custCode")
	private String custCode;
	@XmlElement(name="dn")
	private String dn;
	@XmlElement(name="userPassword")
	private String userPassword;
	/**
	 * @return the preguntaVO
	 */
	public List<PreguntaVO> getPreguntaVO() {
		return preguntaVO;
	}
	/**
	 * @param preguntaVO the preguntaVO to set
	 */
	public void setPreguntaVO(final List<PreguntaVO> preguntaVO) {
		this.preguntaVO = preguntaVO;
	}
	/**
	 * @return the custCode
	 */
	public String getCustCode() {
		return custCode;
	}
	/**
	 * @param custCode the custCode to set
	 */
	public void setCustCode(final String custCode) {
		this.custCode = custCode;
	}
	/**
	 * @return the dn
	 */
	public String getDn() {
		return dn;
	}
	/**
	 * @param dn the dn to set
	 */
	public void setDn(final String dn) {
		this.dn = dn;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
}
