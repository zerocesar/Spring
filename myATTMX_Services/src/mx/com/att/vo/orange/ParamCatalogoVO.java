package mx.com.att.vo.orange;

public class ParamCatalogoVO {
	
	protected String param_id;
	protected String param_value;
	protected String descripcion;
	protected String reg_user;
	protected String reg_date;
	protected String parameter_type;
	public String getParam_id() {
		return param_id;
	}
	public void setParam_id(final String param_id) {
		this.param_id = param_id;
	}
	public String getParam_value() {
		return param_value;
	}
	public void setParam_value(final String param_value) {
		this.param_value = param_value;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	public String getReg_user() {
		return reg_user;
	}
	public void setReg_user(final String reg_user) {
		this.reg_user = reg_user;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(final String reg_date) {
		this.reg_date = reg_date;
	}
	public String getParameter_type() {
		return parameter_type;
	}
	public void setParameter_type(final String parameter_type) {
		this.parameter_type = parameter_type;
	}
}
