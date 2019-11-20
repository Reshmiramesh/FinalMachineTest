package com.ust.dao;

import java.util.List;

import com.ust.beans.Login;
import com.ust.beans.VendorContactBean;

public interface IVendorContactDao {

	//Verifying user login
	public abstract Login userLogin(String username, String password);

	//Retrieving all vendors and their contact details 
	public abstract List<VendorContactBean> getVendorsList();

	//Inserting Vendor details
	public abstract int insertVendorContact(VendorContactBean vBean);

	//Updating vendor details
	public abstract int updateVendorContact(VendorContactBean vc);

	//Disabling a vendor
	public abstract int disableVendor(VendorContactBean bean);

	//Searching by location,contact name and service
	public abstract List<VendorContactBean> getContact(String searchString);

	//Searching a vendor by vendorId
	public abstract List<VendorContactBean> getVendorById(int vId);

}