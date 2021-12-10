package io.github.anantharajuc.sbmwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.MarksEntity;
import io.github.anantharajuc.sbmwa.repository.MarksEntityRepository;

@RestController
@CrossOrigin
@RequestMapping("/smjh/mark")
public class MarkQueryController 
{
	@Autowired
	private MarksEntityRepository marksEntityRepository;
	
	@GetMapping()	
	public List<MarksEntity> findAllMarks()
	{
		return marksEntityRepository.findAll();
	}
	
	@GetMapping("/{id}")	
	public MarksEntity findMarksById(@PathVariable Long id)
	{
		return marksEntityRepository.findById(id).get(); 
		//return marksEntityRepository.getById(id);
	}

}
