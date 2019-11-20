package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.Login;
import com.ust.beans.VendorContactBean;

public class VendorContactDao implements IVendorContactDao {

	// Connect with database to perform operations
	JdbcTemplate template;

	// Setter for JDBC Template
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//Verifying user login
	@Override
	public Login userLogin(String username, String password) {
		String sql = "select userId from loginTable where username=? and password=?" ;
		return template.queryForObject(sql, new Object[] {username,password},
		new BeanPropertyRowMapper<Login>(Login.class));
		}
	
	//Retrieving all vendors and their contact details 
	@Override
	public List<VendorContactBean> getVendorsList() {

		return template
				.query("select vId,vendorName,address,location,service,pinCode,contactName,department,email,phone from vendorTable join contactTable using (vId) where vendorTable.isActive='yes' order by vId desc",
						new RowMapper<VendorContactBean>() {

							public VendorContactBean mapRow(ResultSet rs,
									int row) throws SQLException {
								VendorContactBean daoObj = new VendorContactBean();
								daoObj.setvId(rs.getInt(1));
								daoObj.setVendorName(rs.getString(2));
								daoObj.setAddress(rs.getString(3));
								daoObj.setLocation(rs.getString(4));
								daoObj.setService(rs.getString(5));
								daoObj.setPinCode(rs.getInt(6));
								daoObj.setContactName(rs.getString(7));
								daoObj.setDepartment(rs.getString(8));
								daoObj.setEmail(rs.getString(9));
								daoObj.setPhone(rs.getString(10));
								return daoObj;
							}

						});

	}

	
	//Inserting Vendor details
	@Override
	public int insertVendorContact(VendorContactBean vBean) {

		String sql = "insert into vendorTable(vendorName,address,location,service,pinCode,isActive) values('"
				+ vBean.getVendorName()
				+ "','"
				+ vBean.getAddress()
				+ "','"
				+ vBean.getLocation()
				+ "','"
				+ vBean.getService()
				+ "',"
				+ vBean.getPinCode() + ",'" + "yes" + "')";

		if (template.update(sql) != 0)
		{
			
			String sql1 = "select max(vId) from vendorTable";
			int vId = template.queryForObject(sql1, Integer.class);

			String sql2 = "insert into contactTable(contactName,vId,department,email,phone) values(?,?,?,?,?)";
			return template.update(
					sql2,
					new Object[] { vBean.getContactName(), vId,
							vBean.getDepartment(), vBean.getEmail(),
							vBean.getPhone() });

		} 
		else 
		{
			return 0;
		}

	}
	
	
	//Updating vendor details
	@Override
	public int updateVendorContact(VendorContactBean vc) {

		String sql = "update vendorTable set vendorName='" + vc.getVendorName()
				+ "',address='" +vc.getAddress() + "',location='"
				+ vc.getLocation() + "',service='" + vc.getService() + "',pinCode="
				+vc.getPinCode() + ",isActive='yes' where vId= "
				+vc.getvId() + "";
		template.update(sql, new Object[] {});

		String sql1 = "update contactTable set contactName='" + vc.getContactName()
				+ "',department='" + vc.getDepartment()
				+ "',email='" +vc.getEmail() + "',phone='"+vc.getPhone()+"' where vId="
				+ vc.getvId()+ "";
		return template.update(sql1, new Object[] {});
	}
	
	
	//Disabling a vendor
	@Override
	public int disableVendor(VendorContactBean bean) {

		String sql = "update vendorTable set isActive = 'no' where vId=?";
		return template.update(sql, new Object[] { bean.getvId() });
	}
	
	
	
	//Searching by location,contact name and service
	@Override
	public List<VendorContactBean> getContact(String searchString) {
		return template
				.query("select vId,vendorName,address,location,service,pincode,contactName,department,email,phone from vendorTable join contactTable using(vId) where location like '"
						+ searchString
						+ "%' or contactName like '"
						+ searchString
						+ "%' or service like '" + searchString + "%'",
						new RowMapper<VendorContactBean>() {

							public VendorContactBean mapRow(ResultSet rs, int row)
									throws SQLException {
								VendorContactBean bean = new VendorContactBean();
								bean.setvId(rs.getInt(1));
								bean.setVendorName(rs.getString(2));
								bean.setAddress(rs.getString(3));
								bean.setLocation(rs.getString(4));
								bean.setService(rs.getString(5));
								bean.setPinCode(rs.getInt(6));
								bean.setContactName(rs.getString(7));
								bean.setDepartment(rs.getString(8));
								bean.setEmail(rs.getString(9));
								bean.setPhone(rs.getString(10));
								return bean;
							}
						});
	}
	
	
	//Searching a vendor by vendorId
	@Override
	public List<VendorContactBean> getVendorById(int vId) {
		return template
				.query("select vId,vendorName,address,location,service,pinCode,contactName,department,email,phone from vendorTable join contactTable using (vId) where vId="
						+ vId + "", new RowMapper<VendorContactBean>() {
					public VendorContactBean mapRow(ResultSet rs, int row)
							throws SQLException {
						VendorContactBean bean = new VendorContactBean();
						bean.setvId(rs.getInt(1));
						bean.setVendorName(rs.getString(2));
						bean.setAddress(rs.getString(3));
						bean.setLocation(rs.getString(4));
						bean.setService(rs.getString(5));
						bean.setPinCode(rs.getInt(6));
						bean.setContactName(rs.getString(7));
						bean.setDepartment(rs.getString(8));
						bean.setEmail(rs.getString(9));
						bean.setPhone(rs.getString(10));
						return bean;
					}
				});
	}

}
