package io.github.anantharajuc.sbmwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.HomeWorkEntity;
import io.github.anantharajuc.sbmwa.model.StaffsEntity;
import io.github.anantharajuc.sbmwa.repository.HomeWorkEntityRepository;

@RestController
@CrossOrigin
@RequestMapping("/smjh/homework")
public class HomeWorkQueryController 
{
	@Autowired
	private  HomeWorkEntityRepository  homeWorkEntityRepository;
	
	@GetMapping()	
	public List<HomeWorkEntity> findHomework()
	{
		return homeWorkEntityRepository.findAll();
	}
	
	@GetMapping("/{id}")	
	public HomeWorkEntity findHomeworkById(@PathVariable Long id)
	{
		
		return homeWorkEntityRepository.findById(id).get(); 
		
	}
	
	
	@GetMapping("/getUniqHomeworkData/{classe}/{section}")
	public List<HomeWorkEntity> getUniqHomeworkData(@PathVariable("classe") String classe,@PathVariable("section") String section) {	
		return homeWorkEntityRepository.getHomeworkData(classe,section);
	}
	

}
