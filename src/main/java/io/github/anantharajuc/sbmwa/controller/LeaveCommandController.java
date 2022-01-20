package io.github.anantharajuc.sbmwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.LeaveEntity;
import io.github.anantharajuc.sbmwa.service.LeaveServiceImpl;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/smjh/leave")
@Log4j2
@CrossOrigin
public class LeaveCommandController {
	@Autowired
	private LeaveServiceImpl leaveServiceImpl;
	
	@PostMapping("/insert")
	public LeaveEntity saveLeave(@RequestBody LeaveEntity leaveEntity)
	{
		log.info("-----> saveLeave controller");
		return leaveServiceImpl.saveLeave(leaveEntity);
	}
	
	
	@PostMapping("/delete/{id}")
	public void deleteLeave(@PathVariable("id") Long id)
	{
		leaveServiceImpl.deleteleave(id);
	}
	
	@PostMapping("/update/{id}")
	public LeaveEntity updateLeave(@PathVariable("id") Long id,@RequestBody LeaveEntity leaveEntityUpdated)
	{		
		return leaveServiceImpl.updateLeave(id, leaveEntityUpdated);
	}
	
}
