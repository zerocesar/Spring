package mx.com.att.vo.amdocs;

public class RequestProductsVOBis
{
    private String id;
    private String sc;
    private String lo;
    private boolean allParams;
    private String Productid;
    private ContactPerson request;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLo() {
        return lo;
    }
    public void setLo(String lo) {
        this.lo = lo;
    }
    public String getSc() {
        return sc;
    }
    public void setSc(String sc) {
        this.sc = sc;
    }
    public boolean isAllParams() {
        return allParams;
    }
    public void setAllParams(boolean allParams) {
        this.allParams = allParams;
    }
    public String getProductid() {
        return Productid;
    }
    public void setProductid(String productid) {
        Productid = productid;
    }
    public ContactPerson getRequest() {
        return request;
    }
    public void setRequest(ContactPerson request) {
        this.request = request;
    }
}