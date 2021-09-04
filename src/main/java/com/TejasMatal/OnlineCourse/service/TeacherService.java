package com.TejasMatal.OnlineCourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TejasMatal.OnlineCourse.Entity.Studententity;
import com.TejasMatal.OnlineCourse.Entity.Teacherentity;
import com.TejasMatal.OnlineCourse.dto.Studentdto;
import com.TejasMatal.OnlineCourse.dto.Teacherdto;
import com.TejasMatal.OnlineCourse.repos.TeacherRepos;

@Service(value = "teacherService")
public class TeacherService {

	@Autowired 
	private TeacherRepos teacherRepos;
	
	public String authenticate(String contactNumber , String password)throws Exception {
		
		List<Teacherentity> teacherList = teacherRepos.findByContactNumber(contactNumber);
		System.out.println(teacherList);
		System.out.println(password);
		if(teacherList.isEmpty()) {
			throw new Exception("Invalid contact number or password");
		}
           String passwordFromDb = teacherList.get(0).getPassword();
		System.out.println(passwordFromDb);
		if(!passwordFromDb.equals(password)) {
			throw new Exception("Invalid contact number or password");
		}
		
		return "sucess";
    }
   public String registerTeacher(Teacherdto teacherDto) throws Exception{
		
		//Retrieve student on the basis of contact number.
		List<Teacherentity> teacherList = teacherRepos.findByContactNumber(teacherDto.getContactNo());
		
		//check whether contact number is present in database or not.
		if(!teacherList.isEmpty()) {
			throw new Exception("Contact number is already used. Please use other contact number or log in");
		}
		
		Teacherentity teacher = new Teacherentity();
		
		teacher.setContactNumber(teacherDto.getContactNo());
		teacher.setEmailId(teacherDto.getEmailId());
		teacher.setPassword(teacherDto.getPassword());
		teacher.setTeacherName(teacherDto.getTeacherName());
		
		teacherRepos.save(teacher);
		
		return "teacher registered successfully with Sutdent Id : " +teacher.getTeacherId();
	}
}