package mx.com.att.vo.amdocs;

public class GetUnbilledUsage {
	
//	private AttributeList attributeList;
	private String attributeName;
	private String attributeValue;
//	private PaginationInfo paginationInfo;
	private int pageSize;
	private int pageNumber;
	private byte hasMore;
	private long numberOfRows;
	
//	public AttributeList getAttributeList() {
//		return attributeList;
//	}
//	public void setAttributeList(AttributeList attributeList) {
//		this.attributeList = attributeList;
//	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
//	public PaginationInfo getPaginationInfo() {
//		return paginationInfo;
//	}
//	public void setPaginationInfo(PaginationInfo paginationInfo) {
//		this.paginationInfo = paginationInfo;
//	}
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
