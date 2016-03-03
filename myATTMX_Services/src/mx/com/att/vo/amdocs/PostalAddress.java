package mx.com.att.vo.amdocs;

public class PostalAddress {
	
	private LinkVO[] Link;
	public String addressLine2;
	public String apartmentAndStreet;
	public String city;
	public String country;
	public String id;
	public String poboxNo;
	public String postCode;
	public String state;
	
	public LinkVO[] getLink() {
		return Link;
	}
	public void setLink(final LinkVO[] link) {
		Link = link;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(final String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getApartmentAndStreet() {
		return apartmentAndStreet;
	}
	public void setApartmentAndStreet(final String apartmentAndStreet) {
		this.apartmentAndStreet = apartmentAndStreet;
	}
	public String getCity() {
		return city;
	}
	public void setCity(final String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(final String country) {
		this.country = country;
	}
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getPoboxNo() {
		return poboxNo;
	}
	public void setPoboxNo(final String poboxNo) {
		this.poboxNo = poboxNo;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(final String postCode) {
		this.postCode = postCode;
	}
	public String getState() {
		return state;
	}
	public void setState(final String state) {
		this.state = state;
	}

	
	
}
