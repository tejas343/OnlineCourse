package com.TejasMatal.OnlineCourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TejasMatal.OnlineCourse.Entity.Studententity;
import com.TejasMatal.OnlineCourse.repos.StudentRepos;

@Service(value = "studentService")
public class StudentService {
	
	@Autowired
	private StudentRepos studentrepos;
	
	public String authenticate(String contactNumber) {
		
		List<Studententity> studentList = studentrepos.findByContactNumber(contactNumber);
		
		if(studentList.isEmpty()) {
			return "Invalid Contact Number or Password ";
		}
		
		return "user found";
	}

}
