package mx.com.att.vo.amdocs;

public class RequestCallDetailsVO
{
    private int customerId;
    private int subscriberId;
    private int pageSize;
    private int pageNumber;
    private String externalStructureInfo;
    
    
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getExternalStructureInfo() {
        return externalStructureInfo;
    }
    public void setExternalStructureInfo(String externalStructureInfo) {
        this.externalStructureInfo = externalStructureInfo;
    }
    public int getSubscriberId() {
        return subscriberId;
    }
    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
