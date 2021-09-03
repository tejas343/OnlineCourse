package com.TejasMatal.OnlineCourse.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.TejasMatal.OnlineCourse.service.TeacherService;

@CrossOrigin
@RestController
@RequestMapping("TeacherApi")
public class TeacherApi {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value ="/getteacher/{ContactNumber}", method = RequestMethod.GET)
	public ResponseEntity<String> getBooking(@PathVariable String ContactNumber){
		try {
			
			String result = teacherService.authenticate(ContactNumber);
			
			return new ResponseEntity<String>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "");
		}

    }
}