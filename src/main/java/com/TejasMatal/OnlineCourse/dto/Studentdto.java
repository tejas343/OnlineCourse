package com.TejasMatal.OnlineCourse.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Studentdto {
	private int studentId;
	
	@NotNull(message = "Student name is required")
	@Pattern(regexp = "([A-Za-z])+(\\s[A-Za-z]+)*", message = "Invalid student name Format.")
	private String studentName;
	
	
	@NotNull(message = "Contact Number Required")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "Invalid Contact Number Format.")
	private String contactNumber;
	
	@NotNull(message = "Email required.")
	@Pattern(regexp = "[A-z0-9._]+@[A-z]{2,}\\.[A-z][A-z.]+", message = "Invalid email format.")
	private String emailId;
	
	@NotNull(message = "password required")
	@Pattern(regexp = ".*[A-Z]+.*", message = "Uppercase character required.")
	@Pattern(regexp = ".*[0-9]+.*", message = "Numeric character required.")
	@Pattern(regexp = ".*[a-z]+.*", message = "Lowwercase character required.")
	@Pattern(regexp = ".*[!@#$%^&*]+.*", message = "Special character required.")
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
