package com.dynamic.model;

import java.util.Date;

public class StaffPersonalDetails {

	private int staff_id;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dob;
	private String address1;
	private String address2;
	private String email;
	private String mobile;
	private String phone;
	private String staffType;
	private String deptCode;
	private int postBox;
	private String status;
	public StaffPersonalDetails(int staff_id, String firstName, String middleName, String lastName, Date dob, String address1,
			String address2, String email, String mobile, String phone, String staffType, String deptCode, int postBox,
			String status) {
		super();
		this.staff_id = staff_id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.address1 = address1;
		this.address2 = address2;
		this.email = email;
		this.mobile = mobile;
		this.phone = phone;
		this.staffType = staffType;
		this.deptCode = deptCode;
		this.postBox = postBox;
		this.status = status;
	}
	public StaffPersonalDetails(String firstName, String middleName, String lastName, Date dob, String address1,
			String address2, String email, String mobile, String phone, String staffType, String deptCode, int postBox,
			String status) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.address1 = address1;
		this.address2 = address2;
		this.email = email;
		this.mobile = mobile;
		this.phone = phone;
		this.staffType = staffType;
		this.deptCode = deptCode;
		this.postBox = postBox;
		this.status = status;
	}
	public StaffPersonalDetails() {
		super();
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public int getPostBox() {
		return postBox;
	}
	public void setPostBox(int postBox) {
		this.postBox = postBox;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
