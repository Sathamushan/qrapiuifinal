package  io.github.anantharajuc.sbmwa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.StaffsEntity;
import io.github.anantharajuc.sbmwa.service.StaffsServiceImpl;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@CrossOrigin
@RequestMapping("/smjh/staff")
public class StaffCommandController {
	@Autowired
	private StaffsServiceImpl staffServiceImpl;
	
		
	@PostMapping("/insert")
	public StaffsEntity insertStaffDetails(@RequestBody StaffsEntity staffsEntity)
	{
		log.info("-----> insertStaff controller");
		log.info("-----> staffsEntity "+ staffsEntity.getName());
		return staffServiceImpl.saveStaffDetails(staffsEntity);
	}
	
	
	@PostMapping("/update/{id}")
	public StaffsEntity updateStudentDetails(@PathVariable("id") Long id,@RequestBody StaffsEntity staffsEntity)
	{	
		log.info("-----> updateStudentDetails controller");
		return staffServiceImpl.updatestaffData(id,staffsEntity);
	}
	
	
	
	@PostMapping("/delete/{id}")
	public void deleteStaff(@PathVariable("id") Long id)
	{
		log.info("-----> deleteStaff controller");
		staffServiceImpl.deleteStaff(id);
	}
	
	
	
	
	
	
	
	
	
	
}
