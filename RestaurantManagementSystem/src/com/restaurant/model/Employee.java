package com.restaurant.model;

import java.util.Date;

public class Employee {

	private String username;
	private String password;
	private String jobtype;
	private String fullname;
	private String dob;
	private String education;
	private Integer experience;
	private String phoneNo;
	private String address;
	private String skills;
	private String applicantId;
	
	public Employee() {
	}
	public Employee(String username, String password, String jobtype, String fullname, String dob, String education,
			Integer experience, String phoneNo, String address, String skills, String applicantId) {
		super();
		this.username = username;
		this.password = password;
		this.jobtype = jobtype;
		this.fullname = fullname;
		this.dob = dob;
		this.education = education;
		this.experience = experience;
		this.phoneNo = phoneNo;
		this.address = address;
		this.skills = skills;
		this.applicantId = applicantId;
	}
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(Employee emp) {
		boolean isEqual = this.getUsername().trim().toLowerCase()
				.equals(emp.getUsername().trim().toLowerCase())
				&&
				this.getPassword().trim().toLowerCase()
				.equals(emp.getPassword().trim().toLowerCase())
				&&
				this.getJobtype().trim().toLowerCase()
				.equals(emp.getJobtype().trim().toLowerCase());
		System.out.println("Employee comparision with equals()"+ isEqual);
		return isEqual;
	}
}
