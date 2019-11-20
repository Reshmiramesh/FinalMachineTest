package com.ust.beans;

//Contact class
public class ContactBean {
	
	//Instance Variables
	private int contactId;
	private String contactName;
	private int vId;
	private String department;
	private String email;
	private String phone;
	
	
	//Default constructor
	public ContactBean()
	{
		super();
		
	}

	//Parameterized constructor with contactId
	public ContactBean(int contactId, String contactName, int vId,
			String department, String email, String phone) 
	{
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.vId = vId;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}

	//Parameterized constructor without contactId
	public ContactBean(String contactName, int vId, String department,
			String email, String phone) 
	{
		super();
		this.contactName = contactName;
		this.vId = vId;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}

	
	//All Getter and Setter  methods
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

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
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
		return "ContactBean [contactId=" + contactId + ", contactName="
				+ contactName + ", vId=" + vId + ", department=" + department
				+ ", email=" + email + ", phone=" + phone + "]";
	}

}
