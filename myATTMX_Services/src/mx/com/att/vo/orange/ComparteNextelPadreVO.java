package mx.com.att.vo.orange;

import java.util.ArrayList;
import java.util.List;

import mx.com.att.utils.ATTConstants;

public class ComparteNextelPadreVO {
	
	private String msisdn;
	private String pending;
	private String status;
	private String tmcode;
	private String plan;
	private List<ComparteNextelHijoVO> hijos;
	private List<BalanceVO> monederoActual;
	private List<BalanceVO> monederoIncluido;
	private String addedInCurrentBC;
	private String type;
	
	public ComparteNextelPadreVO(){
		
	}
	
	public ComparteNextelPadreVO(final String msisdn, final String pending, final String status, final Long tmcode, final String plan, final String addedInCurrentBC, final String type, final List<ComparteNextelHijoVO> hijos, final boolean isFill){
		List<BalanceVO> monederoActual = new ArrayList<BalanceVO>();
		List<BalanceVO> monederoIncluido = new ArrayList<BalanceVO>();
		
		this.msisdn = msisdn;
		this.pending = pending;
		this.status = status;
		this.tmcode = (tmcode != null) ? String.valueOf(tmcode) : "";
		this.plan = plan;
		this.hijos = hijos;
		this.addedInCurrentBC = addedInCurrentBC;
		this.type = type;
		if (isFill){
			for (int i = 0; i<=ATTConstants.BUCKET_TYPE.length-1; i++){
				monederoActual.add(new BalanceVO(ATTConstants.BUCKET_TYPE[i], "0", true));
				monederoIncluido.add(new BalanceVO(ATTConstants.BUCKET_TYPE[i], "0", true));
			}
			this.monederoActual = monederoActual;
			this.monederoIncluido = monederoIncluido;
		}
	}
	
	public ComparteNextelPadreVO(final String msisdn) {
		this.msisdn = msisdn;
	}

	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(final String msisdn) {
		this.msisdn = msisdn;
	}
	public String getPending() {
		return pending;
	}
	public void setPending(final String pending) {
		this.pending = pending;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(final String status) {
		this.status = status;
	}
	public String getTmcode() {
		return tmcode;
	}
	public void setTmcode(final String tmcode) {
		this.tmcode = tmcode;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(final String plan) {
		this.plan = plan;
	}
	public List<ComparteNextelHijoVO> getHijos() {
		return hijos;
	}
	public void setHijos(final List<ComparteNextelHijoVO> hijos) {
		this.hijos = hijos;
	}
	public List<BalanceVO> getMonederoActual() {
		return monederoActual;
	}
	public void setMonederoActual(final List<BalanceVO> monederoActual) {
		this.monederoActual = monederoActual;
	}
	public List<BalanceVO> getMonederoIncluido() {
		return monederoIncluido;
	}
	public void setMonederoIncluido(final List<BalanceVO> monederoIncluido) {
		this.monederoIncluido = monederoIncluido;
	}

	public String getAddedInCurrentBC() {
		return addedInCurrentBC;
	}

	public void setAddedInCurrentBC(final String addedInCurrentBC) {
		this.addedInCurrentBC = addedInCurrentBC;
	}
	
	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}
}