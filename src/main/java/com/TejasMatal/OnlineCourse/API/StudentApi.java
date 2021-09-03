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

import com.TejasMatal.OnlineCourse.dto.AdminDto;
import com.TejasMatal.OnlineCourse.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping("StudentApi")
public class StudentApi {
	
	@Autowired
	private StudentService studentService;
	 
	@RequestMapping(value ="/getstudent/{ContactNumber}", method = RequestMethod.GET)
	public ResponseEntity<String> getBooking(@PathVariable String ContactNumber){
		try {
			
			String result = studentService.authenticate(ContactNumber);
			
			return new ResponseEntity<String>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "");
		}
	}

}
