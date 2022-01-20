package io.github.anantharajuc.sbmwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.LeaveEntity;
import io.github.anantharajuc.sbmwa.repository.LeaveEntityRepository;

@RestController
@RequestMapping("/smjh/leave")
@CrossOrigin
public class LeaveQueryController 
{
	@Autowired
	private LeaveEntityRepository leaveEntityRepository;
	
	@GetMapping()	
	public List<LeaveEntity> findAllStudents()
	{
		return leaveEntityRepository.findAll();
	}
	
	@GetMapping("/{id}")	
	public LeaveEntity findStudentById(@PathVariable Long id)
	{
		return leaveEntityRepository.getById(id);
	}

}
