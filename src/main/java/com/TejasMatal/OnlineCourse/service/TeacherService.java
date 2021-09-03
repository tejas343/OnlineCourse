package com.TejasMatal.OnlineCourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TejasMatal.OnlineCourse.Entity.Teacherentity;
import com.TejasMatal.OnlineCourse.repos.TeacherRepos;

@Service(value = "teacherService")
public class TeacherService {

	@Autowired 
	private TeacherRepos teacherRepos;
	
	public String authenticate(String contactNumber) {
		
		List<Teacherentity> teacherList = teacherRepos.findByContactNumber(contactNumber);
		
		if(teacherList.isEmpty()) {
			return "Invalid Contact Number or Password ";
		}
		
		return "user found";
    }
}