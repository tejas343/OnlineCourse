package com.TejasMatal.OnlineCourse.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.TejasMatal.OnlineCourse.Entity.Teacherentity;

public interface TeacherRepos extends CrudRepository<Teacherentity, Integer> {

	public List<Teacherentity> findByContactNumber(String contactNumber);


}
