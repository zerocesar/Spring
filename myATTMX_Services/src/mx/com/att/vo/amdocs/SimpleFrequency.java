package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class SimpleFrequency implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LinkVO Link[];		
	public int  frequencyFactor;
//	public TimeUnits frequencyUnit;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public int getFrequencyFactor() {
		return frequencyFactor;
	}
	public void setFrequencyFactor(final int frequencyFactor) {
		this.frequencyFactor = frequencyFactor;
	}
	/*
	public TimeUnits getFrequencyUnit() {
		return frequencyUnit;
	}
	public void setFrequencyUnit(final TimeUnits frequencyUnit) {
		this.frequencyUnit = frequencyUnit;
	}
	*/
	
	
}