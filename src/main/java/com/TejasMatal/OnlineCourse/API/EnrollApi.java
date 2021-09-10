package com.TejasMatal.OnlineCourse.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.TejasMatal.OnlineCourse.dto.CourseDto;
import com.TejasMatal.OnlineCourse.dto.EnrollDto;
import com.TejasMatal.OnlineCourse.service.EnrollService;

@RestController
@CrossOrigin
@RequestMapping("EnrollApi")
public class EnrollApi {
	
	@Autowired
	private EnrollService enrollService;
	
	@RequestMapping(value ="/enroll/", method = RequestMethod.POST)
	public ResponseEntity<String> enrollCourse(@RequestBody EnrollDto enrollDto){
		try {
			
			String result = enrollService.enrollCourse(enrollDto);
			
			return new ResponseEntity<String>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}

}
