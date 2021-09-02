package com.TejasMatal.OnlineCourse.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TejasMatal.OnlineCourse.Entity.Admin;

@Repository(value = "adminrepos") 
public interface Adminrepos extends CrudRepository<Admin, Integer>{
	
	public Admin findByFirstName(String name);

}
