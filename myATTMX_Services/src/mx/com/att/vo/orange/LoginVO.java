package mx.com.att.vo.orange;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Login")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String custCode;
	
	private long loginId;
	private long coId;
	private long channelId;
	private long customerId;
	private long tmCode;
	private long contractTypeId;
	private long technologyTypeId;
	private String userMdn;
    private String userEmail;
    private String ratePlan;
    private String device;
    private String area;
    private String region;
	

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(final String custCode) {
		this.custCode = custCode;
	}

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(final long loginId) {
		this.loginId = loginId;
	}

	public long getCoId() {
		return coId;
	}

	public void setCoId(final long coId) {
		this.coId = coId;
	}

	public long getChannelId() {
		return channelId;
	}

	public void setChannelId(final long channelId) {
		this.channelId = channelId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(final long customerId) {
		this.customerId = customerId;
	}

	public long getTmCode() {
		return tmCode;
	}

	public void setTmCode(final long tmCode) {
		this.tmCode = tmCode;
	}

	public long getContractTypeId() {
		return contractTypeId;
	}

	public void setContractTypeId(final long contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	public long getTechnologyTypeId() {
		return technologyTypeId;
	}

	public void setTechnologyTypeId(final long technologyTypeId) {
		this.technologyTypeId = technologyTypeId;
	}

	public String getUserMdn() {
		return userMdn;
	}

	public void setUserMdn(final String userMdn) {
		this.userMdn = userMdn;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(final String userEmail) {
		this.userEmail = userEmail;
	}

	public String getRatePlan() {
		return ratePlan;
	}

	public void setRatePlan(final String ratePlan) {
		this.ratePlan = ratePlan;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(final String device) {
		this.device = device;
	}

	public String getArea() {
		return area;
	}

	public void setArea(final String area) {
		this.area = area;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(final String region) {
		this.region = region;
	}
	
	
	
}
