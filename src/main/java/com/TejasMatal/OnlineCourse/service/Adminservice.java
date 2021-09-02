package com.TejasMatal.OnlineCourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TejasMatal.OnlineCourse.Entity.Admin;
import com.TejasMatal.OnlineCourse.dto.AdminDto;
import com.TejasMatal.OnlineCourse.repos.Adminrepos;

@Service(value = "adminservice")
public class Adminservice {
	@Autowired
	private Adminrepos adminrepos;
	
	public AdminDto getadmin() {
		Admin admin= adminrepos.findByFirstName("rahul");
		
		AdminDto admindto = new AdminDto();
		
		admindto.setPersonid(admin.getPersonId());
		admindto.setFirstName(admin.getFirstName());
		admindto.setLastName(admin.getLastName());
		admindto.setContact(admin.getContactNo());
		
		return admindto;
	}

}
