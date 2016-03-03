package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class CharacteristicActionDisplay implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LinkVO[] Link;
	//public CharacteristicActionDisplayType actionDisplayType;
	public String enabled;
	public String function;
	public String functionActionType;
	public String functionParameters;
	public String name;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		this.Link = link;
	}
	/*
	public CharacteristicActionDisplayType getActionDisplayType() {
		return actionDisplayType;
	}
	public void setActionDisplayType(final 
			CharacteristicActionDisplayType actionDisplayType) {
		this.actionDisplayType = actionDisplayType;
	}
	*/
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(final String enabled) { 
		this.enabled = enabled;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(final  String function) {
		this.function = function;
	}
	public String getFunctionActionType() {
		return functionActionType;
	}
	public void setFunctionActionType(final String functionActionType) {
		this.functionActionType = functionActionType;
	}
	public String getFunctionParameters() {
		return functionParameters;
	}
	public void setFunctionParameters(final String functionParameters) {
		this.functionParameters = functionParameters;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}

	
	
}
