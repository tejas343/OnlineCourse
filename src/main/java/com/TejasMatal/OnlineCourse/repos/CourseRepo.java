package com.TejasMatal.OnlineCourse.repos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TejasMatal.OnlineCourse.Entity.CourseEntity;


@Repository(value = "couseRepo")
public interface CourseRepo extends CrudRepository<CourseEntity, Integer>{
	@Query("SELECT c from CourseEntity c where c.dateTime > :date")
	Iterable<CourseEntity> findAllValid(@Param("date") LocalDateTime date);
	
	@Query("SELECT c from CourseEntity c where c.courseName LIKE %:searchCriteria% or c.description LIKE %:searchCriteria%")
	Iterable<CourseEntity> findBySearchCriteria(@Param("searchCriteria") String searchCriteria);
}
