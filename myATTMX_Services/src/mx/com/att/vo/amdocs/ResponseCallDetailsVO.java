package mx.com.att.vo.amdocs;

public class ResponseCallDetailsVO
{
    private AttributeList[] attributeList;
    private PaginationInfo paginationInfo;
    
    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }
    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }
    public AttributeList[] getAttributeList() {
        return attributeList;
    }
    public void setAttributeList(AttributeList[] attributeList) {
        this.attributeList = attributeList;
    }
}
