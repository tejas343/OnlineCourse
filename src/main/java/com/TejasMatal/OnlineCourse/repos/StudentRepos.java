package com.TejasMatal.OnlineCourse.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.TejasMatal.OnlineCourse.Entity.Studententity;


public interface StudentRepos extends CrudRepository<Studententity, Integer> {
	
	public List<Studententity> findByContactNumber(String contactNumber);
}
