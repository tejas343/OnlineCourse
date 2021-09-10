package com.TejasMatal.OnlineCourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TejasMatal.OnlineCourse.Entity.CourseEntity;
import com.TejasMatal.OnlineCourse.Entity.Enrollment;
import com.TejasMatal.OnlineCourse.Entity.Studententity;
import com.TejasMatal.OnlineCourse.dto.CourseDto;
import com.TejasMatal.OnlineCourse.dto.EnrollDto;
import com.TejasMatal.OnlineCourse.repos.CourseRepo;
import com.TejasMatal.OnlineCourse.repos.EnrollmentRepo;
import com.TejasMatal.OnlineCourse.repos.StudentRepos;

@Service(value = "enrollService")
public class EnrollService {
	
	@Autowired
	private StudentRepos studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private EnrollmentRepo enrollmentRepo;
	
	public String enrollCourse(EnrollDto enrollDto) throws Exception{
		
		Optional<CourseEntity> optionalCourse = courseRepo.findById(enrollDto.getCourseDto().getCourseId());
		CourseEntity course = optionalCourse.orElseThrow(() -> new Exception("Course Not found!"));
		
		Optional<Studententity> optionalStudent = studentRepo.findById(enrollDto.getStudentDto().getStudentId());
		Studententity student = optionalStudent.orElseThrow(() -> new Exception("Student not found"));
		
		List<Enrollment> optionalEnroll = enrollmentRepo.findByCouseIdAndStudentId(course,student);
		
		if(!optionalEnroll.isEmpty()) throw new Exception("Already enrolled for course, you can see this in enrolled course.");
		
		Enrollment enroll = new Enrollment();
		enroll.setCouseId(course);
		enroll.setStudentId(student);
		
		enrollmentRepo.save(enroll);
		
		return "Successfully Enrolled";
	}

}
