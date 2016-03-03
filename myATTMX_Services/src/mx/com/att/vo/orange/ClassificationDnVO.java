package mx.com.att.vo.orange;

import java.io.Serializable;

public class ClassificationDnVO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5246585406864542078L;
	
	private String mdn;
	private String tmcode;
	private ClassificationVO classification;
	
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getTmcode() {
		return tmcode;
	}
	public void setTmcode(String tmcode) {
		this.tmcode = tmcode;
	}
	public ClassificationVO getClassification() {
		return classification;
	}
	public void setClassification(ClassificationVO classification) {
		this.classification = classification;
	}

}
