package com.ust.beans;

//Vendor class
public class VendorBean {
	
	//Instance Variables
	private int vId;
	private String vendorName;
	private String address; 
	private String location;
	private String service; 
	private int pinCode;
	private String isActive;
	
	//Default constructor
	public VendorBean() 
	{
		super();
	}

	//Parameterized constructor with vendorId
	public VendorBean(int vId, String vendorName, String address,
			String location, String service, int pinCode, String isActive) 
	{
		super();
		this.vId = vId;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pinCode = pinCode;
		this.isActive = isActive;
	}

	//Parameterized constructor without vendorId
	public VendorBean(String vendorName, String address, String location,
			String service, int pinCode, String isActive) 
	{
		super();
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pinCode = pinCode;
		this.isActive = isActive;
	}

	
	//All Getter and Setter methods
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

	
	
	//toString method
	@Override
	public String toString() {
		return "VendorBean [vId=" + vId + ", vendorName=" + vendorName
				+ ", address=" + address + ", location=" + location
				+ ", service=" + service + ", pinCode=" + pinCode
				+ ", isActive=" + isActive + "]";
	}

}
