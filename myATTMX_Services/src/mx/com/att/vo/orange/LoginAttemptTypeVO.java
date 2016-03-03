package mx.com.att.vo.orange;

import java.io.Serializable;
import java.util.Calendar;

public class LoginAttemptTypeVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long navigationId;
	private String gpsLocation;
	private long retries;
	private Calendar dateFirstAttempt;
	private String success;
	private String additionalInfo;
	
	public long getNavigationId() {
		return navigationId;
	}
	
	public void setNavigationId(final long navigationId) {
		this.navigationId = navigationId;
	}
	
	public String getGpsLocation() {
		return gpsLocation;
	}
	
	public void setGpsLocation(final String gpsLocation) {
		this.gpsLocation = gpsLocation;
	}
	
	public long getRetries() {
		return retries;
	}
	
	public void setRetries(final long retries) {
		this.retries = retries;
	}
	
	public Calendar getDateFirstAttempt() {
		return dateFirstAttempt;
	}
	
	public void setDateFirstAttempt(final Calendar dateFirstAttempt) {
		this.dateFirstAttempt = dateFirstAttempt;
	}
	
	public String getSuccess() {
		return success;
	}

	public void setSuccess(final String success) {
		this.success = success;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(final String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}