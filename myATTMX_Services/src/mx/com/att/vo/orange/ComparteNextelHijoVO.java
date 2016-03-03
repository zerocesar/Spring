package mx.com.att.vo.orange;

import java.util.ArrayList;
import java.util.List;

import mx.com.att.utils.ATTConstants;

public class ComparteNextelHijoVO {
	
	private String msisdn;
	private String pending;
	private String status;
	private String tmcode;
	private String plan;
	private List<BalanceVO> bucket;
	private String addedInCurrentBC;
	private String type;
	
	public ComparteNextelHijoVO(){
		
	}
	
	public ComparteNextelHijoVO(final String msisdn, final String pending, final String status, final Long tmcode, final String plan, final String addedInCurrentBC, final String type){
		this.msisdn = msisdn;
		this.pending = pending;
		this.status = status;
		this.tmcode = (tmcode != null) ? String.valueOf(tmcode) : "";
		this.plan = plan;
		this.addedInCurrentBC = addedInCurrentBC;
		this.type = type;
	}
	
	public void fillBucket(){
		List<BalanceVO> bucketList = new ArrayList<BalanceVO>();
		
		for (int i = 0; i<=ATTConstants.BUCKET_TYPE.length-1; i++){
			bucketList.add(new BalanceVO(ATTConstants.BUCKET_TYPE[i], "0"));
		}
		this.bucket = bucketList;
	}
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(final String msisdn) {
		this.msisdn = msisdn;
	}
	public String getPending() {
		return pending;
	}
	public void setPending(final String pending) {
		this.pending = pending;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(final String status) {
		this.status = status;
	}
	public List<BalanceVO> getBucket() {
		return bucket;
	}
	public void setBucket(final List<BalanceVO> bucket) {
		this.bucket = bucket;
	}
	
	public String getTmcode() {
		return tmcode;
	}

	public void setTmcode(final String tmcode) {
		this.tmcode = tmcode;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(final String plan) {
		this.plan = plan;
	}

	public String getAddedInCurrentBC() {
		return addedInCurrentBC;
	}

	public void setAddedInCurrentBC(final String addedInCurrentBC) {
		this.addedInCurrentBC = addedInCurrentBC;
	}
	
	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}
}