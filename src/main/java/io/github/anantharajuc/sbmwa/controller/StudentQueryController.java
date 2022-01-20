package io.github.anantharajuc.sbmwa.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.github.anantharajuc.sbmwa.model.StudentCountEntity;
import io.github.anantharajuc.sbmwa.model.StudentEntity;
import io.github.anantharajuc.sbmwa.repository.StudentEntityRepository;
import io.github.anantharajuc.sbmwa.service.StudentServiceImpl;
import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin
@Log4j2
@RequestMapping("/smjh/student")
public class StudentQueryController 
{
	@Autowired
	private StudentEntityRepository studentEntityRepository;
	
	@GetMapping()	
	public List<StudentEntity> findAllStudents() {
		return studentEntityRepository.findAll();
	}
	
	
	@GetMapping("/{id}")	
	public StudentEntity findStudentById(@PathVariable Long id)	{
		return studentEntityRepository.findById(id).get(); 
	}
	

}
