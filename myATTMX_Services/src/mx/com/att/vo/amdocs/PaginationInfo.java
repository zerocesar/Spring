package mx.com.att.vo.amdocs;

public class PaginationInfo
{
    private int pageSize;
    private int pageNumber;
    private byte hasMore;
    private long numberOfRows;
    
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
    public byte getHasMore() {
        return hasMore;
    }
    public void setHasMore(byte hasMore) {
        this.hasMore = hasMore;
    }
    public long getNumberOfRows() {
        return numberOfRows;
    }
    public void setNumberOfRows(long numberOfRows) {
        this.numberOfRows = numberOfRows;
    }
}
