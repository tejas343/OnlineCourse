package com.TejasMatal.OnlineCourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TejasMatal.OnlineCourse.Entity.Studententity;
import com.TejasMatal.OnlineCourse.dto.Studentdto;
import com.TejasMatal.OnlineCourse.repos.StudentRepos;

@Service(value = "studentService")
public class StudentService {
	
	@Autowired
	private StudentRepos studentrepos;
	
	public String authenticate(String contactNumber, String password) throws Exception {
		
		List<Studententity> studentList = studentrepos.findByContactNumber(contactNumber);
		System.out.println(studentList);
		if(studentList.isEmpty()) {
			throw new Exception("Invalid contact number or password");
		}
		
		String passwordFromDb = studentList.get(0).getPassword();
		
		if(!passwordFromDb.equals(password)) {
			throw new Exception("Invalid contact number or password");
		}
		return "Success";
	}
	
	public String registerStudent(Studentdto studentDto) throws Exception{
		
		//Retrieve student on the basis of contact number.
		List<Studententity> studentList = studentrepos.findByContactNumber(studentDto.getContactNumber());
		
		//check whether contact number is present in database or not.
		if(!studentList.isEmpty()) {
			throw new Exception("Contact number is already used. Please use other contact number or log in");
		}
		
		Studententity student = new Studententity();
		
		student.setContactNumber(studentDto.getContactNumber());
		student.setEmailId(studentDto.getEmailId());
		student.setPassword(studentDto.getPassword());
		student.setStudentName(studentDto.getStudentName());
		
		studentrepos.save(student);
		
		return "student registered successfully with Sutdent Id : " +student.getStudentId();
	}

}
