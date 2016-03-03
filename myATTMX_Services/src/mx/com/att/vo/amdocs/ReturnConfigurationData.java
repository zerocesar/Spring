package mx.com.att.vo.amdocs;

public class ReturnConfigurationData {
	private LinkVO[] link;
	private Boolean catalogDataInd;
	private Boolean crossProductsDiscountsDataInd;
	private Boolean previousQuotedRecurringPricesInd;	
	private Boolean productConfigurationInd;
	private Boolean quotedPricesInd;
	private Boolean quotedProrationInd;
	private Boolean quotedTaxInd;
	private Boolean summaryInd;
	private Boolean topLevelProductData;
	
	public final LinkVO[] getLink() {
		return link;
	}
	public final void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public final Boolean getCatalogDataInd() {
		return catalogDataInd;
	}
	public final void setCatalogDataInd(final Boolean catalogDataInd) {
		this.catalogDataInd = catalogDataInd;
	}
	public final Boolean getCrossProductsDiscountsDataInd() {
		return crossProductsDiscountsDataInd;
	}
	public final void setCrossProductsDiscountsDataInd(final 
			Boolean crossProductsDiscountsDataInd) {
		this.crossProductsDiscountsDataInd = crossProductsDiscountsDataInd;
	}
	public final Boolean getPreviousQuotedRecurringPricesInd() {
		return previousQuotedRecurringPricesInd;
	}
	public final void setPreviousQuotedRecurringPricesInd(final 
			Boolean previousQuotedRecurringPricesInd) {
		this.previousQuotedRecurringPricesInd = previousQuotedRecurringPricesInd;
	}
	public final Boolean getProductConfigurationInd() {
		return productConfigurationInd;
	}
	public final void setProductConfigurationInd(final Boolean productConfigurationInd) {
		this.productConfigurationInd = productConfigurationInd;
	}
	public final Boolean getQuotedPricesInd() {
		return quotedPricesInd;
	}
	public final void setQuotedPricesInd(final Boolean quotedPricesInd) {
		this.quotedPricesInd = quotedPricesInd;
	}
	public final Boolean getQuotedProrationInd() {
		return quotedProrationInd;
	}
	public final void setQuotedProrationInd(final Boolean quotedProrationInd) {
		this.quotedProrationInd = quotedProrationInd;
	}
	public final Boolean getQuotedTaxInd() {
		return quotedTaxInd;
	}
	public final void setQuotedTaxInd(final Boolean quotedTaxInd) {
		this.quotedTaxInd = quotedTaxInd;
	}
	public final Boolean getSummaryInd() {
		return summaryInd;
	}
	public final void setSummaryInd(final Boolean summaryInd) {
		this.summaryInd = summaryInd;
	}
	public final Boolean getTopLevelProductData() {
		return topLevelProductData;
	}
	public final void setTopLevelProductData(final Boolean topLevelProductData) {
		this.topLevelProductData = topLevelProductData;
	}
	
}
