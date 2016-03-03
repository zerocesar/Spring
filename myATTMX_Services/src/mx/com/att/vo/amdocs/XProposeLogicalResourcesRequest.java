package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class XProposeLogicalResourcesRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	private LinkVO[] link;
	private String category;
	private String patternOperator;
	private String patternValue;
	private String ufmiMegaFleet;
	private String msisdnType;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(LinkVO[] link) {
		this.link = link;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPatternOperator() {
		return patternOperator;
	}
	public void setPatternOperator(String patternOperator) {
		this.patternOperator = patternOperator;
	}
	public String getPatternValue() {
		return patternValue;
	}
	public void setPatternValue(String patternValue) {
		this.patternValue = patternValue;
	}
	public String getUfmiMegaFleet() {
		return ufmiMegaFleet;
	}
	public void setUfmiMegaFleet(String ufmiMegaFleet) {
		this.ufmiMegaFleet = ufmiMegaFleet;
	}
	public String getMsisdnType() {
		return msisdnType;
	}
	public void setMsisdnType(String msisdnType) {
		this.msisdnType = msisdnType;
	}


	
}