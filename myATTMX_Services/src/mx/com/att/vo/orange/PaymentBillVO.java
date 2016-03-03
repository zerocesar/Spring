package mx.com.att.vo.orange;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentBillVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name="account")
	private String account;
	@XmlElement(name="numberBill")
	private String numberBill;
	@XmlElement(name="dateBill")
	private String dateBill;
	@XmlElement(name="amount")
	private String amount;
	@XmlElement(name="action")
	private String action;
	@XmlElement(name="dateExpiracion")
	private String dateExpiracion;
	@XmlElement(name="balance")
	private String balance;
	@XmlElement(name="saldoVencido")
	private String saldoVencido;
	@XmlElement(name="saldoVencer")
	private String saldoVencer;
	@XmlElement(name="saldoTotal")
	private String saldoTotal;
	@XmlElement(name="fechaVencido")
	private String fechaVencido;
	@XmlElement(name="fechaVencer")
	private String fechaVencer;

	private double saldoVencerTotal;
	private double saldoVencidoTotal;
	private double saldoAcumTotal;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(final String account) {
		this.account = account;
	}
	public String getNumberBill() {
		return numberBill;
	}
	public void setNumberBill(final String numberBill) {
		this.numberBill = numberBill;
	}
	public String getDateBill() {
		return dateBill;
	}
	public void setDateBill(final String dateBill) {
		this.dateBill = dateBill;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(final String amount) {
		this.amount = amount;
	}
	public String getAction() {
		return action;
	}
	public void setAction(final String action) {
		this.action = action;
	}
	public String getDateExpiracion() {
		return dateExpiracion;
	}
	public void setDateExpiracion(final String dateExpiracion) {
		this.dateExpiracion = dateExpiracion;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(final String balance) {
		this.balance = balance;
	}
	public String getSaldoVencido() {
		return saldoVencido;
	}
	public void setSaldoVencido(final String saldoVencido) {
		this.saldoVencido = saldoVencido;
	}
	public String getSaldoVencer() {
		return saldoVencer;
	}
	public void setSaldoVencer(final String saldoVencer) {
		this.saldoVencer = saldoVencer;
	}
	public String getSaldoTotal() {
		return saldoTotal;
	}
	public void setSaldoTotal(final String saldoTotal) {
		this.saldoTotal = saldoTotal;
	}
	public String getFechaVencido() {
		return fechaVencido;
	}
	public void setFechaVencido(final String fechaVencido) {
		this.fechaVencido = fechaVencido;
	}
	public String getFechaVencer() {
		return fechaVencer;
	}
	public void setFechaVencer(final String fechaVencer) {
		this.fechaVencer = fechaVencer;
	}
	public double getSaldoVencerTotal() {
		return saldoVencerTotal;
	}
	public void setSaldoVencerTotal(double saldoVencerTotal) {
		this.saldoVencerTotal = saldoVencerTotal;
	}
	public double getSaldoVencidoTotal() {
		return saldoVencidoTotal;
	}
	public void setSaldoVencidoTotal(double saldoVencidoTotal) {
		this.saldoVencidoTotal = saldoVencidoTotal;
	}
	public double getSaldoAcumTotal() {
		return saldoAcumTotal;
	}
	public void setSaldoAcumTotal(double saldoAcumTotal) {
		this.saldoAcumTotal = saldoAcumTotal;
	}
	
}
