package com.TejasMatal.OnlineCourse.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TejasMatal.OnlineCourse.Entity.CourseEntity;
import com.TejasMatal.OnlineCourse.Entity.Enrollment;
import com.TejasMatal.OnlineCourse.Entity.Studententity;

@Repository(value = "enrollmentRepo")
public interface EnrollmentRepo extends CrudRepository<Enrollment, Integer> {

	

	List<Enrollment> findByCouseIdAndStudentId(CourseEntity course, Studententity student);

	List<Enrollment> findByStudentId(Studententity student);

}
