package com.TejasMatal.OnlineCourse.dto;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

public class CourseDto {
	
	private int courseId;
	
	@NotNull(message = "Course name required")
	private String courseName;
	
	@NotNull(message = "Please upload Image")
	private String imageUrl;
	
	private LocalDateTime createdAt= LocalDateTime.now();
	
	@NotNull(message = "Description Required")
	private String description;
	
	@NotNull(message = "Course date Required")
	@Future(message = "Course date can not from the past.")
	private LocalDateTime dateTime;
	
	@NotNull(message = "Educator Name required")
    private String educatorName;
    
	@NotNull(message = "Teacher Details required")
    private Teacherdto teacherDto;
    
	private Set<EnrollDto> enrollmentlist;
	
	
	public Set<EnrollDto> getEnrollmentlist() {
		return enrollmentlist;
	}

	public void setEnrollmentlist(Set<EnrollDto> enrollmentlist) {
		this.enrollmentlist = enrollmentlist;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getEducatorName() {
		return educatorName;
	}

	public void setEducatorName(String educatorName) {
		this.educatorName = educatorName;
	}

	public Teacherdto getTeacherDto() {
		return teacherDto;
	}

	public void setTeacherDto(Teacherdto teacherDto) {
		this.teacherDto = teacherDto;
	}
    
    
}
