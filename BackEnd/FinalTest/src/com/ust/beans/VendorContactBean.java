package com.ust.beans;

//VendorContactBean class
public class VendorContactBean 
{

	//VendorBean Instance Variables
	private int vId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private int pinCode;
	private String isActive;

	//ContactBean Instance Variables
	private int contactId;
	private String contactName;
	private String department;
	private String email;
	private String phone;
	
	//Default Constructor
	public VendorContactBean() 
	{
		super();
	}
	
	
	//Parameterized constructor with vendorId
	public VendorContactBean(int vId, String vendorName, String address,
			String location, String service, int pinCode, String isActive,
			int contactId, String contactName, String department, String email,
			String phone) {
		super();
		this.vId = vId;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pinCode = pinCode;
		this.isActive = isActive;
		this.contactId = contactId;
		this.contactName = contactName;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}


	//Parameterized constructor without vendorId
	public VendorContactBean(String vendorName, String address,
			String location, String service, int pinCode, String isActive,
			int contactId, String contactName, String department, String email,
			String phone) {
		super();
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pinCode = pinCode;
		this.isActive = isActive;
		this.contactId = contactId;
		this.contactName = contactName;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}


	//All Getter and Setter Methods
	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	//toString method
	@Override
	public String toString() {
		return "VendorContactBean [vId=" + vId + ", vendorName=" + vendorName
				+ ", address=" + address + ", location=" + location
				+ ", service=" + service + ", pinCode=" + pinCode
				+ ", isActive=" + isActive + ", contactId=" + contactId
				+ ", contactName=" + contactName + ", department=" + department
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
}
