package com.TejasMatal.OnlineCourse.API;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.TejasMatal.OnlineCourse.dto.Studentdto;
import com.TejasMatal.OnlineCourse.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping("StudentApi")
public class StudentApi {
	
	@Autowired
	private StudentService studentService;
	 
	@RequestMapping(value ="/authenticate_student/", method = RequestMethod.POST)
	public ResponseEntity<String> authenticateStudent(@RequestBody Studentdto student){
		try {
			
			String result = studentService.authenticate(student.getContactNumber(), student.getPassword());
			
			return new ResponseEntity<String>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}
	
	@RequestMapping(value = "registerStudent", method = RequestMethod.POST)
	public ResponseEntity<String> registerStudent(@Valid @RequestBody Studentdto student){
		
		try {
			
			String result = studentService.registerStudent(student);
			
			return new ResponseEntity<String>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}
	

}
