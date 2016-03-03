package mx.com.att.vo.orange;
import java.io.Serializable;

public class ServicesPackVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long servicePackageTypeId;
	private String servicePackageName;
	private String servicePackageDesc;
	private String packageType;
	private String packageRegion;
	private long snCode;
	private long spCode;
	private float cost;
	private String serviceName;
	private String serviceDesc;
	private long comConfigId;
	private AddOnVO addOnVO;
	
	public long getServicePackageTypeId() {
		return servicePackageTypeId;
	}
	public void setServicePackageTypeId(long servicePackageTypeId) {
		this.servicePackageTypeId = servicePackageTypeId;
	}
	public String getServicePackageName() {
		return servicePackageName;
	}
	public void setServicePackageName(String servicePackageName) {
		this.servicePackageName = servicePackageName;
	}
	public String getServicePackageDesc() {
		return servicePackageDesc;
	}
	public void setServicePackageDesc(String servicePackageDesc) {
		this.servicePackageDesc = servicePackageDesc;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getPackageRegion() {
		return packageRegion;
	}
	public void setPackageRegion(String packageRegion) {
		this.packageRegion = packageRegion;
	}
	public long getSnCode() {
		return snCode;
	}
	public void setSnCode(long snCode) {
		this.snCode = snCode;
	}
	public long getSpCode() {
		return spCode;
	}
	public void setSpCode(long spCode) {
		this.spCode = spCode;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDesc() {
		return serviceDesc;
	}
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	public long getComConfigId() {
		return comConfigId;
	}
	public void setComConfigId(long comConfigId) {
		this.comConfigId = comConfigId;
	}
	public AddOnVO getAddOnVO() {
		return addOnVO;
	}
	public void setAddOnVO(AddOnVO addOnVO) {
		this.addOnVO = addOnVO;
	}
}
