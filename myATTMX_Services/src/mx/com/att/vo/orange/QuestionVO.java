package mx.com.att.vo.orange;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Question")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionVO implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name="numberOfQuestions")
	private long numberOfQuestions;
	@XmlElement(name="excludeQuestionIds")
	private String[] excludeQuestionIds;
	@XmlElement(name="custCode")
	private String custCode;
	/**
	 * @return the numberOfQuestions
	 */
	public long getNumberOfQuestions() {
		return numberOfQuestions;
	}
	/**
	 * @param numberOfQuestions the numberOfQuestions to set
	 */
	public void setNumberOfQuestions(final long numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	/**
	 * @return the excludeQuestionIds
	 */
	public String[] getExcludeQuestionIds() {
		if( this.excludeQuestionIds instanceof String[] ){
			return (String []) this.excludeQuestionIds.clone();
		} else{
			return new String[0];
		}
	}
	/**
	 * @param excludeQuestionIds the excludeQuestionIds to set
	 */
	public void setExcludeQuestionIds(final String[] excludeQuestionIds) {
		if( excludeQuestionIds instanceof String[] ){
			this.excludeQuestionIds = (String[]) excludeQuestionIds.clone();
		} else{
			this.excludeQuestionIds = new String[0];
		}
	}
	/**
	 * @return the custCode
	 */
	public String getCustCode() {
		return custCode;
	}
	/**
	 * @param custCode the custCode to set
	 */
	public void setCustCode(final String custCode) {
		this.custCode = custCode;
	}
   
}