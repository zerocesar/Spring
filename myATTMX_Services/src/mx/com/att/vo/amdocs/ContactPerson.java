package mx.com.att.vo.amdocs;

import java.io.Serializable;

public class ContactPerson implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public LinkVO[] link;
	public String firstName;
	public String lastName;
	public String name;
	public String personID;
	public String phone;
	//public Work work;
	public PostalAddress postalAddress;
	public EAddress electronicAddresses;
	
	public LinkVO[] getLink() {
		return link;
	}
	public void setLink(final LinkVO[] link) {
		this.link = link;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(final String personID) {
		this.personID = personID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(final String phone) {
		this.phone = phone;
	}
	/*
	public Work getWork() {
		return work;
	}
	public void setWork(final Work work) {
		this.work = work;
	}*/
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(final PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}
	public EAddress getElectronicAddresses() {
		return electronicAddresses;
	}
	public void setElectronicAddresses(final EAddress electronicAddresses) {
		this.electronicAddresses = electronicAddresses;
	}

	
	
}