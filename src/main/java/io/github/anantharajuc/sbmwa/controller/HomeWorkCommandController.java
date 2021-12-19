package io.github.anantharajuc.sbmwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.HomeWorkEntity;
import io.github.anantharajuc.sbmwa.service.HomeWorkServiceImpl;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/smjh/homework")
@Log4j2
@CrossOrigin
public class HomeWorkCommandController {

	
	@Autowired
	private  HomeWorkServiceImpl homeWorkServiceImpl;
	
	@PostMapping("/insert")
	public HomeWorkEntity saveHomeWorkData(@RequestBody HomeWorkEntity homeWorkEntity)
	{
		log.info("-----> saveHomeWorkData controller");
		log.info("-----> homeWorkEntity "+ homeWorkEntity.getAssignmentname());
		return homeWorkServiceImpl.saveHomework(homeWorkEntity);
	}
	
	
	@PostMapping("/update/{id}")
	public HomeWorkEntity updateHomeWorkData(@PathVariable("id") Long id,@RequestBody HomeWorkEntity homeWorkEntity)
	{		
		return homeWorkServiceImpl.updateHomework(id,homeWorkEntity);
	}
	
	@PostMapping("/delete/{id}")
	public void deleteFeedback(@PathVariable("id") Long id)
	{
		homeWorkServiceImpl.deleteHomeWork(id);
	}
}
