package io.github.anantharajuc.sbmwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.StudentEntity;
import io.github.anantharajuc.sbmwa.repository.StudentEntityRepository;

@RestController
@RequestMapping("/smjh/student")
public class StudentQueryController 
{
	@Autowired
	private StudentEntityRepository studentEntityRepository;
	
	@GetMapping()	
	public List<StudentEntity> findAllStudents()
	{
		return studentEntityRepository.findAll();
	}
	
	@GetMapping("/{id}")	
	public StudentEntity findStudentById(@PathVariable Long id)
	{
		return studentEntityRepository.getById(id);
	}

}
