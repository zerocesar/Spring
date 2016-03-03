package mx.com.att.vo.amdocs;

public class ProductDiscountsDisplay {			 

		private LinkVO[] Link;		
		public String productID;
		public String productLineOfBusiness;
		public String productName;
		public String productOfferingInstanceID;
		public String productOfferingName;
		public String productServiceID;
		public String simpleProductOfferingName;
		public TotalOneTimeCalculatedPrice totalOneTimeCalculatedPrice;
		public AssignedBillingOfferDisplay[] crossProductDiscounts;
		public TotalRecurringCalculatedPrice totalRecurringCalculatedPrice;
		public String  installationAddressID;
		public ContactPerson person;
		
		public LinkVO[] getLink() {
			return Link;
		}
		public void setLink(final LinkVO[] link) {
			Link = link;
		}
		public String getProductID() {
			return productID;
		}
		public void setProductID(final String productID) {
			this.productID = productID;
		}
		public String getProductLineOfBusiness() {
			return productLineOfBusiness;
		}
		public void setProductLineOfBusiness(final String productLineOfBusiness) {
			this.productLineOfBusiness = productLineOfBusiness;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(final String productName) {
			this.productName = productName;
		}
		public String getProductOfferingInstanceID() {
			return productOfferingInstanceID;
		}
		public void setProductOfferingInstanceID(final String productOfferingInstanceID) {
			this.productOfferingInstanceID = productOfferingInstanceID;
		}
		public String getProductOfferingName() {
			return productOfferingName;
		}
		public void setProductOfferingName(final String productOfferingName) {
			this.productOfferingName = productOfferingName;
		}
		public String getProductServiceID() {
			return productServiceID;
		}
		public void setProductServiceID(final String productServiceID) {
			this.productServiceID = productServiceID;
		}
		public String getSimpleProductOfferingName() {
			return simpleProductOfferingName;
		}
		public void setSimpleProductOfferingName(final String simpleProductOfferingName) {
			this.simpleProductOfferingName = simpleProductOfferingName;
		}
		public TotalOneTimeCalculatedPrice getTotalOneTimeCalculatedPrice() {
			return totalOneTimeCalculatedPrice;
		}
		public void setTotalOneTimeCalculatedPrice(final 
				TotalOneTimeCalculatedPrice totalOneTimeCalculatedPrice) {
			this.totalOneTimeCalculatedPrice = totalOneTimeCalculatedPrice;
		}
		public AssignedBillingOfferDisplay[] getCrossProductDiscounts() {
			return crossProductDiscounts;
		}
		public void setCrossProductDiscounts(final 
				AssignedBillingOfferDisplay[] crossProductDiscounts) {
			this.crossProductDiscounts = crossProductDiscounts;
		}
		public TotalRecurringCalculatedPrice getTotalRecurringCalculatedPrice() {
			return totalRecurringCalculatedPrice;
		}
		public void setTotalRecurringCalculatedPrice(final 
				TotalRecurringCalculatedPrice totalRecurringCalculatedPrice) {
			this.totalRecurringCalculatedPrice = totalRecurringCalculatedPrice;
		}
		public String getInstallationAddressID() {
			return installationAddressID;
		}
		public void setInstallationAddressID(final String installationAddressID) {
			this.installationAddressID = installationAddressID;
		}
		public ContactPerson getPerson() {
			return person;
		}
		public void setPerson(final ContactPerson person) {
			this.person = person;
		}
		
		
		
}
