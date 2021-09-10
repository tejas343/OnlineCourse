package com.TejasMatal.OnlineCourse.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class EnrollDto {
	
	private int enrollmentId;
	
	@NotNull(message = "Student details required")
	private Studentdto studentDto;
	
	@NotNull(message = "Course details required")
	private CourseDto courseDto;
	
	private LocalDateTime enrollAt = LocalDateTime.now();
	
	public int getEnrollmentId() {
		return enrollmentId;
	}
	
	public LocalDateTime getEnrollAt() {
		return enrollAt;
	}

	public void setEnrollAt(LocalDateTime enrollAt) {
		this.enrollAt = enrollAt;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	
	public Studentdto getStudentDto() {
		return studentDto;
	}
	public void setStudentDto(Studentdto studentDto) {
		this.studentDto = studentDto;
	}
	public CourseDto getCourseDto() {
		return courseDto;
	}
	public void setCourseDto(CourseDto courseDto) {
		this.courseDto = courseDto;
	}
	
	

}
