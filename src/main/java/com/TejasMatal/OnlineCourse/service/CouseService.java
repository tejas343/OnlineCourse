package com.TejasMatal.OnlineCourse.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TejasMatal.OnlineCourse.Entity.CourseEntity;
import com.TejasMatal.OnlineCourse.Entity.Teacherentity;
import com.TejasMatal.OnlineCourse.dto.CourseDto;
import com.TejasMatal.OnlineCourse.dto.Studentdto;
import com.TejasMatal.OnlineCourse.dto.Teacherdto;
import com.TejasMatal.OnlineCourse.repos.CourseRepo;
import com.TejasMatal.OnlineCourse.repos.TeacherRepos;

@Service(value = "courseService")
@Transactional
public class CouseService {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private TeacherRepos teacherRepo;
	
	public String getCount() {
		
		return String.valueOf(courseRepo.count()+1);
	}
	
	public String addcourse(CourseDto courseDto) throws Exception {
		
		int teacherId = courseDto.getTeacherDto().getTeacherId();
		
		Optional<Teacherentity> optional = teacherRepo.findById(teacherId);
		
		Teacherentity teacher = optional.orElseThrow(() -> new Exception("Teacher Not found"));
		
		CourseEntity course = new CourseEntity();
		
		course.setCourseName(courseDto.getCourseName());
		course.setCreatedAt(courseDto.getCreatedAt());
		course.setDateTime(courseDto.getDateTime());
		course.setDescription(courseDto.getDescription());
		course.setEducatorName(courseDto.getEducatorName());
		course.setImageUrl(courseDto.getImageUrl());
		course.setTeacher(teacher);
		
		
		
		courseRepo.save(course);
		
		return "Course created successfully with courseId: "+course.getCourseId();
		
	}
	
	public List<CourseDto> getAllCourse() throws Exception{
		LocalDateTime date = LocalDateTime.now();
		System.out.println(date);
		List<CourseEntity> courseEntityList = (List<CourseEntity>) courseRepo.findAllValid(date);
		List<CourseDto> CourseList = new ArrayList<>();
		if(courseEntityList.isEmpty()) {
			throw new Exception("Course not available at this time");
		}
		else {
			
			for(CourseEntity couseEntity: courseEntityList) {
				
				CourseDto course = new CourseDto();
				
				course.setCourseId(couseEntity.getCourseId());
				course.setCourseName(couseEntity.getCourseName());
				course.setDateTime(couseEntity.getDateTime());
				course.setDescription(couseEntity.getDescription());
				course.setEducatorName(couseEntity.getEducatorName());
				course.setImageUrl(couseEntity.getImageUrl());
				
				Teacherentity teacher = couseEntity.getTeacher();
				Teacherdto teacherDto = new Teacherdto();
				
				teacherDto.setTeacherName(teacher.getTeacherName());
				
				course.setTeacherDto(teacherDto);
				course.setCreatedAt(couseEntity.getCreatedAt());
				
				
				CourseList.add(course);
				
			}
		}
		
		return CourseList;
	}
	
	public List<CourseDto> courseBySearchCriteria(String searchCriteria) throws Exception{
		
		List<CourseEntity> courseEntityList = (List<CourseEntity>) courseRepo.findBySearchCriteria(searchCriteria);
		List<CourseDto> CourseList = new ArrayList<>();
		if(courseEntityList.isEmpty()) {
			throw new Exception("Course not found, search other key word");
		}
		else {
			
			for(CourseEntity couseEntity: courseEntityList) {
				
				CourseDto course = new CourseDto();
				
				course.setCourseId(couseEntity.getCourseId());
				course.setCourseName(couseEntity.getCourseName());
				course.setDateTime(couseEntity.getDateTime());
				course.setDescription(couseEntity.getDescription());
				course.setEducatorName(couseEntity.getEducatorName());
				course.setImageUrl(couseEntity.getImageUrl());
				
				Teacherentity teacher = couseEntity.getTeacher();
				Teacherdto teacherDto = new Teacherdto();
				
				teacherDto.setTeacherName(teacher.getTeacherName());
				
				course.setTeacherDto(teacherDto);
				course.setCreatedAt(couseEntity.getCreatedAt());
				
				
				CourseList.add(course);
				
			}
		}
		
		return CourseList;
	}
	
}
