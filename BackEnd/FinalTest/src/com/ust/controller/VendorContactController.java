package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.beans.Login;
import com.ust.beans.VendorContactBean;
import com.ust.dao.IVendorContactDao;

@RestController
public class VendorContactController {

	@Autowired
	IVendorContactDao vcdao;

	//Login verification
	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	public Login selectRoleName(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return vcdao.userLogin(username, password);
	}

	// Listing all vendor details
	@RequestMapping(value = "/api/vendorDetails", method = RequestMethod.GET)
	public List<VendorContactBean> getAllVendors() {
		List list = vcdao.getVendorsList();
		return list;
	}

	// Insertion and updation of vendor
	@RequestMapping(value = "/api/insertVendor", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void doctorInsert(@RequestBody VendorContactBean vbean) {
		if (vbean.getvId() != 0) {
			vcdao.updateVendorContact(vbean);
		} else {
			vcdao.insertVendorContact(vbean);

		}
	}

	// Searching vendor by vId
	@RequestMapping(value = "/api/getVendorById/{vId}", method = RequestMethod.GET, produces = "application/json")
	public VendorContactBean getVendors(
			@ModelAttribute("vcBean") VendorContactBean vcBean,
			@PathVariable("vId") int vId) {
		List vendors = vcdao.getVendorById(vId);
		vcBean = (VendorContactBean) vendors.get(0);
		return vcBean;
	}

	// Searching a vendor
	@RequestMapping(value = "/api/searchVendor/{searchString}", method = RequestMethod.GET)
	public List<VendorContactBean> getVendorContact(
			@PathVariable("searchString") String searchString) {
		List list = vcdao.getContact(searchString);
		return list;
	}

	// Disabling vendor
	@RequestMapping(value = "/api/disableVendor", method = RequestMethod.PUT)
	void staffDisable(@RequestBody VendorContactBean aBean) {
		vcdao.disableVendor(aBean);

	}

}
