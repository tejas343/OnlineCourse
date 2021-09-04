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
import com.TejasMatal.OnlineCourse.dto.Teacherdto;
import com.TejasMatal.OnlineCourse.service.TeacherService;

@CrossOrigin
@RestController
@RequestMapping("TeacherApi")
public class TeacherApi {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value ="/authenticate_teacher/", method = RequestMethod.POST)
	public ResponseEntity<String> getBooking(@RequestBody Teacherdto teacher ){
		try {
			
			String result = teacherService.authenticate(teacher.getContactNo(),teacher.getPassword());
			
			return new ResponseEntity<String>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}
		@RequestMapping(value = "registerTeacher", method = RequestMethod.POST)
		public ResponseEntity<String> registerTeacher(@Valid @RequestBody Teacherdto teacher){
			
			try {
				
				 String result = teacherService.registerTeacher(teacher);
				
				return new ResponseEntity<String>(result, HttpStatus.OK);
				
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
			}
		}

    }
