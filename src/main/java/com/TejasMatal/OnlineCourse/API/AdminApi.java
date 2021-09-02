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
import com.TejasMatal.OnlineCourse.service.Adminservice;

@CrossOrigin
@RestController
@RequestMapping("AdminApli")
public class AdminApi {
	
	@Autowired
	private Adminservice adminservice;

	@RequestMapping(value = "/getAdmin/", method = RequestMethod.GET)
	public ResponseEntity<AdminDto> getBooking(){
		try {
			AdminDto adminDto = adminservice.getadmin();
			
			return new ResponseEntity<AdminDto>(adminDto, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "");
		}
	}
}
