package mx.com.att.vo;

import java.io.Serializable;

public class ParameterVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String paramId; //param_id Id del parametro
	
	private String paramValue; //param_value Valor del parametro

	public String getParamId() {
		return paramId;
	}

	public void setParamId(final String paramId) {
		this.paramId = paramId;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(final String paramValue) {
		this.paramValue = paramValue;
	}
}