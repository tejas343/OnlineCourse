package com.TejasMatal.OnlineCourse.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Teacherdto {

	private int teacherId;
	
	@NotNull(message = "Teacher name is required")
	@Pattern(regexp = "([A-Za-z])+(\\s[A-Za-z]+)*", message = "Invalid Teacher name Format.")
	private String teacherName;
	
	@NotNull(message = "Contact Number Required")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "Invalid Contact Number Format.")
	private String contactNo;
	
	@NotNull(message = "password required")
	@Pattern(regexp = ".*[A-Z]+.*", message = "Uppercase character required.")
	@Pattern(regexp = ".*[0-9]+.*", message = "Numeric character required.")
	@Pattern(regexp = ".*[a-z]+.*", message = "Lowwercase character required.")
	@Pattern(regexp = ".*[!@#$%^&*]+.*", message = "Special character required.")
	private String password;
	
	
	@NotNull(message = "Email required.")
	@Pattern(regexp = "[A-z0-9._]+@[A-z]{2,}\\.[A-z][A-z.]+", message = "Invalid email format.")
	private String emailId;
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
