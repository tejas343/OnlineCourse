package com.TejasMatal.OnlineCourse.Entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENROLLMENT")
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COURSE_ID")
	private CourseEntity couseId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT_ID")
	private Studententity studentId;
	
	private LocalDateTime enrollAt= LocalDateTime.now();

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public CourseEntity getCouseId() {
		return couseId;
	}

	public void setCouseId(CourseEntity couseId) {
		this.couseId = couseId;
	}

	public Studententity getStudentId() {
		return studentId;
	}

	public void setStudentId(Studententity studentId) {
		this.studentId = studentId;
	}

	public LocalDateTime getEnrollAt() {
		return enrollAt;
	}

	public void setEnrollAt(LocalDateTime enrollAt) {
		this.enrollAt = enrollAt;
	}
	
	
	

}
