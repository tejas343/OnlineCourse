package com.TejasMatal.OnlineCourse.API;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.TejasMatal.OnlineCourse.dto.CourseDto;

import com.TejasMatal.OnlineCourse.service.CouseService;

@RestController
@CrossOrigin
@RequestMapping("CouseApi")
public class CourseApi {
	
	@Autowired
	private CouseService couseService;
	
	@RequestMapping(value ="/UploadImage/", method = RequestMethod.POST)
	public String authenticateStudent(@RequestParam("imageFile") MultipartFile file) throws IOException{
			
			String folder = "C:\\Users\\Director_Office\\Downloads\\onlineCourse_front end\\my-app\\public\\";
			byte[] bytes = file.getBytes();
			String ext = FilenameUtils.getExtension(file.getOriginalFilename());
			String name = couseService.getCount();
			
			Path path = Paths.get(folder+name+"."+ext);
			Files.write(path, bytes);
			
			
			return name+"."+ext;	
	}
	
	@RequestMapping(value ="/addCourse/", method = RequestMethod.POST)
	public ResponseEntity<String> authenticateStudent(@RequestBody CourseDto course){
		try {
			
			String result = couseService.addcourse(course);
			
			return new ResponseEntity<String>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}
	
	@RequestMapping(value ="/getAllCourses/", method = RequestMethod.GET)
	public ResponseEntity<List<CourseDto>> getAllCourses(){
		try {
			
			List<CourseDto> result = couseService.getAllCourse();
			
			return new ResponseEntity<List<CourseDto>>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@RequestMapping(value ="/getAllCourses/{searchCriteria}", method = RequestMethod.GET)
	public ResponseEntity<List<CourseDto>> getCoursesBySearch(@PathVariable String searchCriteria){
		try {
			
			List<CourseDto> result = couseService.courseBySearchCriteria(searchCriteria);
			
			return new ResponseEntity<List<CourseDto>>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
}
