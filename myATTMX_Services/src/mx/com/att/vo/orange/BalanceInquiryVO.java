package mx.com.att.vo.orange;

import java.io.Serializable;
import java.util.List;

public class BalanceInquiryVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String id;
	protected String systemId;
	protected String dn;
	protected String code;
	protected String messageCode;
	protected List<BalanceVO> balancesIncluded;
	protected List<BalanceVO> balancesBought;
	protected List<BalanceVO> balancesGift;
	protected List<BalanceVO> balancesPromotion;
	protected List<BalanceVO> balancesBenefits;
	protected List<BalanceVO> currentBalances;
	protected List<BalanceVO> monthlyBalances;
	protected String totalPesos;
	protected String totalMinutes;
	protected String totalSMS;
	protected String totalKB;
	
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(final String systemId) {
		this.systemId = systemId;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(final String dn) {
		this.dn = dn;
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
	public List<BalanceVO> getBalancesIncluded() {
		return balancesIncluded;
	}
	public void setBalancesIncluded(final List<BalanceVO> balancesIncluded) {
		this.balancesIncluded = balancesIncluded;
	}
	public List<BalanceVO> getBalancesBought() {
		return balancesBought;
	}
	public void setBalancesBought(final List<BalanceVO> balancesBought) {
		this.balancesBought = balancesBought;
	}
	public List<BalanceVO> getBalancesGift() {
		return balancesGift;
	}
	public void setBalancesGift(final List<BalanceVO> balancesGift) {
		this.balancesGift = balancesGift;
	}
	public List<BalanceVO> getBalancesPromotion() {
		return balancesPromotion;
	}
	public void setBalancesPromotion(final List<BalanceVO> balancesPromotion) {
		this.balancesPromotion = balancesPromotion;
	}
	public List<BalanceVO> getBalancesBenefits() {
		return balancesBenefits;
	}
	public void setBalancesBenefits(final List<BalanceVO> balancesBenefits) {
		this.balancesBenefits = balancesBenefits;
	}
	public String getTotalPesos() {
		return totalPesos;
	}
	public void setTotalPesos(final String totalPesos) {
		this.totalPesos = totalPesos;
	}
	public String getTotalMinutes() {
		return totalMinutes;
	}
	public void setTotalMinutes(final String totalMinutes) {
		this.totalMinutes = totalMinutes;
	}
	public String getTotalSMS() {
		return totalSMS;
	}
	public void setTotalSMS(final String totalSMS) {
		this.totalSMS = totalSMS;
	}
	public String getTotalKB() {
		return totalKB;
	}
	public void setTotalKB(final String totalKB) {
		this.totalKB = totalKB;
	}

	public List<BalanceVO> getCurrentBalances() {
		return currentBalances;
	}
	public void setCurrentBalances(final List<BalanceVO> currentBalances) {
		this.currentBalances = currentBalances;
	}
	public List<BalanceVO> getMonthlyBalances() {
		return monthlyBalances;
	}
	public void setMonthlyBalances(final List<BalanceVO> monthlyBalances) {
		this.monthlyBalances = monthlyBalances;
	}
}