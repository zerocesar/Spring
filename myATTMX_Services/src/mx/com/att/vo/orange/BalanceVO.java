package mx.com.att.vo.orange;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

import mx.com.nextel.www.ws.vo.MonederoVO;

public class BalanceVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String type;
	protected String descripcion;
	protected String amount;
	protected Date expirationDate;
	protected Double maxAmountAllowed;
	protected String unitType;
	protected String monederoType;
	
	public BalanceVO(){
		
	}
	
	public BalanceVO(final String type, final String amount){
		this.type = type;
		this.amount = amount;
	}
	
	public BalanceVO(final String type, final String amount, final boolean isFill){
		this.type = type;
		this.amount = amount;
		if (isFill){
			this.descripcion = "";
			this.expirationDate = null;
			this.unitType = "";
		}
	}
	
	public void setBalanceVO(final BalanceVO balance){
		this.descripcion = balance.getDescripcion();
		this.amount = balance.getAmount();
		this.expirationDate = balance.getExpirationDate();
		this.unitType = balance.getUnitType();
	}
	
	public void setBalanceVO(final MonederoVO balance){
		final DecimalFormat decimalFormat = new DecimalFormat("###,##0");
		this.descripcion = balance.getDescripcion();
		this.expirationDate = balance.getFechaExpiracion();
		this.unitType = balance.getTipoUnidad();
		if (balance.getMonedero().equalsIgnoreCase("ADD_SMS") || balance.getMonedero().equalsIgnoreCase("ADD_TELCEL")){
			this.amount = decimalFormat.format(balance.getMonto());
		} else{
			this.amount = String.valueOf(balance.getMonto());
		}
	}
	
	public String getType() {
		return type;
	}
	public void setType(final String type) {
		this.type = type;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(final String amount) {
		this.amount = amount;
	}
	public Date getExpirationDate() {
		return this.expirationDate;
	}
	public void setExpirationDate(final Date expirationDate) {
		this.expirationDate = new Date(expirationDate.getTime());
	}
	public Double getMaxAmountAllowed() {
		return maxAmountAllowed;
	}
	public void setMaxAmountAllowed(final Double maxAmountAllowed) {
		this.maxAmountAllowed = maxAmountAllowed;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(final String unitType) {
		this.unitType = unitType;
	}
	public String getMonederoType() {
		return monederoType;
	}
	public void setMonederoType(final String monederoType) {
		this.monederoType = monederoType;
	}

}
