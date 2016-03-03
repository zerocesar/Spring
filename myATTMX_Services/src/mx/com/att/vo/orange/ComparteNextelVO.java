package mx.com.att.vo.orange;

import java.util.List;

public class ComparteNextelVO {
	
	private List<ComparteNextelPadreVO> padres;
	private List<ComparteNextelHijoVO> hijos;
	private List<ComparteNextelPadreVO> asociados;
	private Integer maxPadres;
	private Integer maxHijos;
	private String code;
	private String messageCode;
	
	public List<ComparteNextelPadreVO> getPadres() {
		return padres;
	}
	public void setPadres(final List<ComparteNextelPadreVO> padres) {
		this.padres = padres;
	}
	public List<ComparteNextelHijoVO> getHijos() {
		return hijos;
	}
	public void setHijos(final List<ComparteNextelHijoVO> hijos) {
		this.hijos = hijos;
	}
	public List<ComparteNextelPadreVO> getAsociados() {
		return asociados;
	}
	public void setAsociados(final List<ComparteNextelPadreVO> asociados) {
		this.asociados = asociados;
	}
	public Integer getMaxPadres() {
		return maxPadres;
	}
	public void setMaxPadres(final Integer maxPadres) {
		this.maxPadres = maxPadres;
	}
	public Integer getMaxHijos() {
		return maxHijos;
	}
	public void setMaxHijos(final Integer maxHijos) {
		this.maxHijos = maxHijos;
	}
	public String getCode() {
		return code;
	}
	public void setCode(final String code) {
		this.code = code;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(final String messageCode) {
		this.messageCode = messageCode;
	}
}