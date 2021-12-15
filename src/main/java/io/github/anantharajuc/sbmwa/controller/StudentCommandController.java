package  io.github.anantharajuc.sbmwa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.StudentEntity;
import io.github.anantharajuc.sbmwa.service.StudentServiceImpl;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@CrossOrigin
@RequestMapping("/smjh/student")
public class StudentCommandController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
		
	@PostMapping("/insert")
	public StudentEntity insertStudentDetails(@RequestBody StudentEntity studentEntity)
	{
		log.info("-----> insertStudent controller");
		log.info("-----> studentEntity "+ studentEntity.getStudentnameinenglish());
		return studentServiceImpl.insertStudentDetails(studentEntity);
	}
	
	
	@PostMapping("/update/{id}")
	public StudentEntity updateStudentDetails(@PathVariable("id") Long id,@RequestBody StudentEntity studentEntity)
	{	
		log.info("-----> updateAttandanceDetails controller");
		return studentServiceImpl.updateStudentDetails(id,studentEntity);
	}
	
	
	
	@PostMapping("/delete/{id}")
	public void deleteAttandance(@PathVariable("id") Long id)
	{
		log.info("-----> deleteAttandance controller");
		studentServiceImpl.deleteStudentDetail(id);
	}
}
