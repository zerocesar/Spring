package mx.com.att.vo.amdocs;

public class ProductHasAddOnsOutput {
	
	private LinkVO[] Link;
	//private Boolean anyServiceHasAddOns;
	private Boolean productHasServiceGroupAddOns;
	private ServiceHasAddOns[] anyServiceHasAddOns;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(LinkVO[] link) {
		Link = link;
	}
	/*
	public Boolean getAnyServiceHasAddOns() {
		return anyServiceHasAddOns;
	}
	public void setAnyServiceHasAddOns(Boolean anyServiceHasAddOns) {
		this.anyServiceHasAddOns = anyServiceHasAddOns;
	}
	*/
	public Boolean getProductHasServiceGroupAddOns() {
		return productHasServiceGroupAddOns;
	}
	public void setProductHasServiceGroupAddOns(Boolean productHasServiceGroupAddOns) {
		this.productHasServiceGroupAddOns = productHasServiceGroupAddOns;
	}
	public ServiceHasAddOns[] getAnyServiceHasAddOns() {
		return anyServiceHasAddOns;
	}
	public void setAnyServiceHasAddOns(ServiceHasAddOns[] anyServiceHasAddOns) {
		this.anyServiceHasAddOns = anyServiceHasAddOns;
	}

	
	
}
