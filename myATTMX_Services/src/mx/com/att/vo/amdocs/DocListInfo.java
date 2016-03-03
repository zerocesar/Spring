package mx.com.att.vo.amdocs;

import java.util.Date;

public class DocListInfo {
	private long docId;
	private String docType;
	private char docStatus;
	private Date billDate;
	private Date periodCoverageStartDate;
	private Date periodCoverageEndDate;
	private String productionType;
	private long accountNo;
	private long customerNo;
	private long baNo;
	private String documentFormat;
	private String printingCategory;
	private byte docProduceInd;
	private String amountCurrency;
	private Date dueDate;
	private double totalAmount;
	private double invoiceAmount;
	private double invoiceTaxAmountQ;
	private double invoiceNetAmount;
	private String legalInvoiceNo;
	private short billFrequency;
	private byte rebillActivity;
	private String docDemandType;
	
	public long getDocId() {
		return docId;
	}
	public void setDocId(final long docId) {
		this.docId = docId;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(final String docType) {
		this.docType = docType;
	}
	public char getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(final char docStatus) {
		this.docStatus = docStatus;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(final Date billDate) {
		this.billDate = billDate;
	}
	public Date getPeriodCoverageStartDate() {
		return periodCoverageStartDate;
	}
	public void setPeriodCoverageStartDate(final Date periodCoverageStartDate) {
		this.periodCoverageStartDate = periodCoverageStartDate;
	}
	public Date getPeriodCoverageEndDate() {
		return periodCoverageEndDate;
	}
	public void setPeriodCoverageEndDate(final Date periodCoverageEndDate) {
		this.periodCoverageEndDate = periodCoverageEndDate;
	}
	public String getProductionType() {
		return productionType;
	}
	public void setProductionType(final String productionType) {
		this.productionType = productionType;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(final long accountNo) {
		this.accountNo = accountNo;
	}
	public long getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(final long customerNo) {
		this.customerNo = customerNo;
	}
	public long getBaNo() {
		return baNo;
	}
	public void setBaNo(final long baNo) {
		this.baNo = baNo;
	}
	public String getDocumentFormat() {
		return documentFormat;
	}
	public void setDocumentFormat(final String documentFormat) {
		this.documentFormat = documentFormat;
	}
	public String getPrintingCategory() {
		return printingCategory;
	}
	public void setPrintingCategory(final String printingCategory) {
		this.printingCategory = printingCategory;
	}
	public byte getDocProduceInd() {
		return docProduceInd;
	}
	public void setDocProduceInd(final byte docProduceInd) {
		this.docProduceInd = docProduceInd;
	}
	public String getAmountCurrency() {
		return amountCurrency;
	}
	public void setAmountCurrency(final String amountCurrency) {
		this.amountCurrency = amountCurrency;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(final Date dueDate) {
		this.dueDate = dueDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(final double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(final double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public double getInvoiceTaxAmountQ() {
		return invoiceTaxAmountQ;
	}
	public void setInvoiceTaxAmountQ(final double invoiceTaxAmountQ) {
		this.invoiceTaxAmountQ = invoiceTaxAmountQ;
	}
	public double getInvoiceNetAmount() {
		return invoiceNetAmount;
	}
	public void setInvoiceNetAmount(final double invoiceNetAmount) {
		this.invoiceNetAmount = invoiceNetAmount;
	}
	public String getLegalInvoiceNo() {
		return legalInvoiceNo;
	}
	public void setLegalInvoiceNo(final String legalInvoiceNo) {
		this.legalInvoiceNo = legalInvoiceNo;
	}
	public short getBillFrequency() {
		return billFrequency;
	}
	public void setBillFrequency(final short billFrequency) {
		this.billFrequency = billFrequency;
	}
	public byte getRebillActivity() {
		return rebillActivity;
	}
	public void setRebillActivity(final byte rebillActivity) {
		this.rebillActivity = rebillActivity;
	}
	public String getDocDemandType() {
		return docDemandType;
	}
	public void setDocDemandType(final String docDemandType) {
		this.docDemandType = docDemandType;
	}
}
